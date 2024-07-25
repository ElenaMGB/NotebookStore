**Магазин ноутбуков**

**Задача** 
из курса GeekBrains "Java: знакомство и как пользоваться базовым API (семинары)":

**Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.**

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


**Решение**

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
_private String brand_ - бренд ноутбука. </br>
_private int ram_ - объем оперативной памяти (в ГБ).</br>
_private int hdd_ - объем жесткого диска (в ГБ).</br>
_private String os_ - операционная система.</br>
_private String color_ - цвет.

Конструктор</br>
_public Notebook(String brand, int ram, int hdd, String os, String color)_</br>
создает экземпляр ноутбука с указанными параметрами.

Методы</br>
_public String getBrand()_: возвращает бренд ноутбука.</br>
_public int getRam()_: возвращает объем оперативной памяти.</br>
_public int getHdd()_: возвращает объем жесткого диска.</br>
_public String getOs()_: возвращает операционную систему.</br>
_public String getColor()_: возвращает цвет.</br>


_@Override public String toString():_</br> 
возвращает строковое представление ноутбука.

**Класс NotebookStore</br>**

Класс **NotebookStore** управляет множеством ноутбуков и их фильтрацией.

Поля</br>
_private Set<Notebook> notebooks_: множество ноутбуков.

Методы</br>
_public void addNotebook(Notebook notebook)_: добавляет ноутбук в магазин.</br>

_public Set<Notebook> filterNotebooks(Map<String, Object> criteria)_: фильтрует ноутбуки по указанным критериям.</br>
