package notebookstore;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        NotebookStore store = new NotebookStore();
        store.populateStore();
        Map<String, Object> criteria = store.getCriteriaFromUser();
        store.displayFilteredNotebooks(criteria);
    }
}