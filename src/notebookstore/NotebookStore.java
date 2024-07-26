package notebookstore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NotebookStore {
    private Set<Notebook> notebooks = new HashSet<>();

    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    public Set<Notebook> filterNotebooks(Map<String, Object> criteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>(notebooks);
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            filteredNotebooks.removeIf(notebook -> {
                switch (key) {
                    case "ram":
                        return notebook.getRam() < (int) value;
                    case "hdd":
                        return notebook.getHdd() < (int) value;
                    case "os":
                        return !notebook.getOs().equalsIgnoreCase((String) value);
                    case "color":
                        return !notebook.getColor().equalsIgnoreCase((String) value);
                    case "brand":
                        return !notebook.getBrand().equalsIgnoreCase((String) value);
                    default:
                        return true;
                }
            });
        }
        return filteredNotebooks;
    }

    public void populateStore() {
        addNotebook(new Notebook("Dell", 16, 512, "Windows", "Black"));
        addNotebook(new Notebook("HP", 8, 256, "Windows", "Silver"));
        addNotebook(new Notebook("Apple", 8, 256, "MacOS", "Gray"));
        addNotebook(new Notebook("Asus", 16, 1024, "Windows", "Black"));
        addNotebook(new Notebook("Lenovo", 4, 128, "Linux", "Black"));
    }

    public Map<String, Object> getCriteriaFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> criteria = new HashMap<>();

        boolean continueFiltering = true;
        while (continueFiltering) {
            int choice = getUserChoice(scanner);
            getCriteriaInput(scanner, criteria, choice);
            continueFiltering = askForMoreCriteria(scanner);
        }
        return criteria;
    }

    private int getUserChoice(Scanner scanner) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Бренд");
        System.out.print("Ваш выбор: ");
        return scanner.nextInt();
    }

    private void getCriteriaInput(Scanner scanner, Map<String, Object> criteria, int choice) {
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1:
                System.out.print("Введите минимальное значение ОЗУ (в ГБ): ");
                criteria.put("ram", scanner.nextInt());
                break;
            case 2:
                System.out.print("Введите минимальное значение объема ЖД (в ГБ): ");
                criteria.put("hdd", scanner.nextInt());
                break;
            case 3:
                System.out.print("Введите операционную систему: ");
                criteria.put("os", scanner.nextLine());
                break;
            case 4:
                System.out.print("Введите цвет: ");
                criteria.put("color", scanner.nextLine());
                break;
            case 5:
                System.out.print("Введите бренд: ");
                criteria.put("brand", scanner.nextLine());
                break;
            default:
                System.out.println("Неверный выбор.");
                break;
        }
    }

    private boolean askForMoreCriteria(Scanner scanner) {
        System.out.print("Хотите добавить еще критерий? (yes/no): ");
        String moreCriteria = scanner.nextLine();
        return moreCriteria.equalsIgnoreCase("yes");
    }

    public void displayFilteredNotebooks(Map<String, Object> criteria) {
        System.out.println("Критерии фильтрации:");
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Set<Notebook> filteredNotebooks = filterNotebooks(criteria);
        System.out.println("Отфильтрованные ноутбуки:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }
}