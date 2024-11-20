# Отчет по лабораторной работе №2

**№ группы:** ПМ-2401

**Выполнила:** Важова Дарья Юрьевна

**Вариант:** 4

**1.Постановка задачи:**

* Условие задачи
>Напишите программу на Java, которая выполняет следующие действия
с квадратным двумерным массивом целых чисел:
>1. Считывает с консоли размер массива N, затем элементы массива
размером N × N.
>2. Сортирует элементы главной диагонали по возрастанию, не затрагивая остальные элементы, затем сортирует элементы побочной
диагонали по убыванию. Далее заменяет элемент на пересечении
диагоналей на их среднее арифметическое.
>3. Находит сумму элементов на главной и побочной диагоналях, а
также разницу между этими суммами.
>4. Выводит все диагонали массива (ниже главной, главную, выше
главной).
>5. Определяет и выводит индексы строки и столбца, при вычеркивании которых сумма всех элементов новой матрицы будет максимальной. Дополнительно выводит саму новую матрицу.


* Моё понимание
1. Создать двумерный массив размером N×N. Т.к. впоследствии придётся искать пересечение диагоналей, N - нечётное.
2. Отсортировать элементы главной оси по возрастанию от левого верхнего угла к правому нижнему. Отсортировать побочную диагональ по убыванию от правого верхнего угла к левому нижнему углу. Найти среднее арифметическое всех элементов обеих диагоналей и заменить центральный элемент (на пересечении диагоналей) на найденое и округленное до ближайшего целого числа среднее арифметическое.
3. Найти сумму элементов обеих осей и разницу между ними.
4. Вывести все диагонали переллельные главной побочной оси.
5. Найти строку и сболбец в минимальными суммами. Вывести их индексы и матрицу без них. Если есть несколько столбцов или строк с одинаковыми суммами, то убираю первые найденные подходящие строку и столбец.


**2.Входные и выходные данные**

* Входные данные
  * **Тип данных:** Целые (По условию задачи)
  * **Колличество:** N^2 + 1 (размер массива,элементы массива
размером N × N.)
  * **Диапозон:** min = - 10^9, max = 10^9 (На вход могут подаваться любые целые числа)

* Выходные данные
  * **Тип данных:** Целые (По условию задачи)
  * **Колличество:** N^2+2N + 1 (все диагонали параллельные главной(2N-1), индексы строки и столбца, при вычеркивании которых сумма всех элементов новой матрицы будет максимальной(2), новая матрица (N^2).
  * **Диапозон:** min = -10^9, max = 10^9
    
**3.Выбор структуры данных**

* Для хранения введённых значений создадим целочисленные переменные и массивы.
  * n - размер массива
  * a - массив 
  * glav - массив для хранения и сортировки элементов главной диагонали
  * pob -  массив для хранения и сортировки элементов побочной диагонали
  * sum1 и sum2 - массивы, в которых хранятся суммы элементов строк и столбцов соответственно
  *  sumgl и sumpob - суммы элементов главной и побочной осей соответственно
  * flag - целочисленная переменная, выполняющая роль "флага"
  * temp - переменная для замены значений 2 переменных
  * sr - среднее арифметическое диагоналей
  * 

**4.Алгоритм**

Описание:
