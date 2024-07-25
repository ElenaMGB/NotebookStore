**Магазин ноутбуков**

**Задача** 

по курсу GeekBrains _"Java: знакомство и как пользоваться базовым API (семинары)"_:

Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.

* Создать множество ноутбуков.
* Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
* Критерии фильтрации можно хранить в Map.

_Например:_

Введите цифру, соответствующую необходимому критерию:
1. ОЗУ 
2. Объем ЖД
3. Операционная система
4. Цвет

Далее нужно запросить минимальные значения для указанных критериев. Сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.


**Описание решения**

Эта программа моделирует магазин ноутбуков. В ней реализованы следующие функции:

- Создание и хранение множества ноутбуков.
- Запрос критериев фильтрации у пользователя.
- Фильтрация ноутбуков по указанным критериям.
- Вывод отфильтрованных ноутбуков на экран.

****Структура проекта****

Проект состоит из двух классов: Notebook, NotebookStore.

**Класс Notebook**

Класс **Notebook** представляет ноутбук.

Поля</br>
private String brand - бренд ноутбука. </br>
private int ram - объем оперативной памяти (в ГБ).</br>
private int hdd - объем жесткого диска (в ГБ).</br>
private String os - операционная система.</br>
private String color - цвет.

Конструктор</br>
public Notebook(String brand, int ram, int hdd, String os, String color)</br>
оздает экземпляр ноутбука с указанными параметрами.

Методы</br>
public String getBrand(): возвращает бренд ноутбука.</br>
public int getRam(): возвращает объем оперативной памяти.</br>
public int getHdd(): возвращает объем жесткого диска.</br>
public String getOs(): возвращает операционную систему.</br>
public String getColor(): возвращает цвет.</br>


@Override public String toString():</br> 
возвращает строковое представление ноутбука.

**Класс NotebookStore</br>**

Класс **NotebookStore** управляет множеством ноутбуков и их фильтрацией.

Поля</br>
private Set<Notebook> notebooks: множество ноутбуков.

Методы</br>
public void addNotebook(Notebook notebook): добавляет ноутбук в магазин.</br>

public Set<Notebook> filterNotebooks(Map<String, Object> criteria): фильтрует ноутбуки по указанным критериям.</br>

Метод filterNotebooks фильтрует ноутбуки по указанным критериям.