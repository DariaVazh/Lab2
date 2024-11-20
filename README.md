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
2. Отсортировать элементы главной диагонали по возрастанию от левого верхнего угла к правому нижнему. Отсортировать побочную диагональ по убыванию от правого верхнего угла к левому нижнему углу. Найти среднее арифметическое всех элементов обеих диагоналей и заменить центральный элемент (на пересечении диагоналей) на найденое и округленное до ближайшего целого числа среднее арифметическое.
3. Найти сумму элементов обеих диагоналей и разницу между ними.
4. Вывести все диагонали переллельные главной диагонали.
5. Найти строку и сболбец в минимальными суммами. Вывести их индексы и матрицу без них. Если есть несколько столбцов или строк с одинаковыми суммами, то убираю первые найденные подходящие строку и столбец.


**2.Входные и выходные данные**

* Входные данные
  * **Тип данных:** Целые (По условию задачи)
  * **Колличество:** N^2 + 1 (элементы массива
размером N × N + размер массива)
  * **Диапозон:** min = - 10^9, max = 10^9 (На вход могут подаваться любые целые числа)

* Выходные данные
  * **Тип данных:** Целые (По условию задачи)
  * **Колличество:** N^2+2N + 1 (все диагонали параллельные главной(2N-1), индексы строки и столбца, при вычеркивании которых сумма всех элементов новой матрицы будет максимальной(2), новая матрица (N^2).
  * **Диапозон:** min = -10^9, max = 10^9

**2.5 Математическая модель**

Среднее арифметическое = (сумма всех элементов)/колличество элементов

**3.Выбор структуры данных**

* Для хранения введённых значений создадим целочисленные переменные, вещественные переменные и массивы. Массивы используются для хранения и многократной отбработки однотипных данных. Вещественные переменные используются для правильного матиматического округления среднего арифметического элементов диагоналей.
  * n - размер массива (целочисленная переменная по условию задачи)
  * a - массив (необходимо многократно пройти по элементам)
  * glav - массив для хранения и сортировки элементов главной диагонали (необходимо многократно пройти по элементам)
  * pob -  массив для хранения и сортировки элементов побочной диагонали (необходимо многократно пройти по элементам)
  * sumgl и sumpob - суммы элементов главной и побочной осей соответственно (вещественные переменные)
  * flag - целочисленная переменная, выполняющая роль "флага" (целочисленная переменная) 
  * temp - переменная для замены значений 2 переменных (целочисленная переменная, тк по условию работа проходит с массивом целых чисел)
  * sr - среднее арифметическое диагоналей (вещественная переменная)
  * sumgl2 и sumpob2 - суммы главной и побочной оси соответственно после изменения элемента на пересечении диагоналей (целочисленные переменные, тк по условию работа проходит с массивом целых чисел)
  * mins и mins2 - переменные для нахождения строки и столба с минимальной суммой элементов соответственно (целочисленные переменные, тк по условию работа проходит с массивом целых чисел)
  * n1 и n2  - индексы строки и столбца с минимальной суммой элементов соответственно (целочисленные переменные, тк индекс может быть только натуральным или равным нулю)

**4.Алгоритм**

Описание: на вход подается натуральное число. Далее вводится N^2 целых чисел, которыми заполняется массив. 

Заполняется массив glav элементами главной диагонали. Вычисляется сумма элементов главной диагонали. Элементы массива glav сортируются по возрастанию. Происходит замена элементов главной диагонали основного массива на отсортированные элементы массива glav.

Заполняется массив pob элементами главной диагонали. Вычисляется сумма элементов побочной диагонали. Элементы массива pob сортируются по убыванию. Происходит замена элементов побочной диагонали основного массива на отсортированные элементы массива pob.

Происходит вычисление среднего арифметического элементов обеих диагоналей, полученный результат округляется по правилами математики до целого числа. Происходит замена элемента на пересечении диагоналей на среднее арифметическое диагоналей

Происходит вычисление сумм главной и побочной диагоналей после измены элемента. Происходит вычисление разности между ними.

Происходит вывод диагоналей параллельных главной диагонали "снизу вверх".

Происходит поиск строки с минимальной суммой элементов и её индекса. Происходит поиск столбца с минимальной суммой элементов и его индекса. Индексы выводятся на экран. Матрица выводится без найденных строки и столбца.

**5.Программа**

 ```java
  public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {

        int n = in.nextInt();

        int[][] a = new int[n][n];
        int [] glav = new int[n];
        int [] pob = new int[n];
        double sumgl = 0;
        double sumpob = 0;
        int flag;
        int flag2 = 0;
        int temp;
        double sr;
        int sumgl2 = 0;
        int sumpob2 = 0;
        int mins = 1000000000;
        int mins2 = 1000000000;
        int n1 = 0;
        int n2 = 0;

        //Заполнение основного массива
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j< a.length; j++){
                a[i][j] = in.nextInt();
            }
        }
        
        //Получение массива из элементов главной диагонали и суммы элементов главной диагонали
        for (int x = 0; x< a.length; x ++){
            for (int y = 0; y<a.length; y++){
                if (x == y) { //индексы строки и столбца элементов главной оси равны
                    glav[x] = a[x][y];
                    sumgl+=a[x][y];
                }
            }
        }


        //Сортировка массива с элементами главной диагонали по возрастанию
        flag = glav.length;
        while (flag!=0){
            for (int i = 0; i<glav.length - 1; i++) {
                if (glav[i] <= glav[i + 1]) //Проверка на правильность расположения двух последовательных элементов
                    flag2++;
                else {
                    temp = glav[i+1];
                    glav[i+1] = glav[i];
                    glav[i] = temp;
                }
                if (flag2 == glav.length - 1)//проверка на то, что все элементы последовательности стоят верно
                    flag = 0;
            }
        }

        //Перестановка элементов главной диагонали
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == j) //индексы строки и столбца элементов главной оси равны
                    a[i][j] = glav[i];
            }
        }

        //Получение элементов побочной оси и подсчет их суммы
        for (int i = 0; i<a.length;i++){
            for (int j = a.length-1; j!=-1; j--){
                if (i + j == a.length - 1) { //сумма индексов строки и столбца элементов побочной оси равна размеру массива - 1
                    pob[j]= a[i][j];
                    sumpob +=a[i][j];
                }
            }
        }

        //Сортировка массива элементов побочной диагонали
        flag = 1;
        flag2 = 0;

        while (flag!=0){
            for (int i = 0; i<pob.length - 1; i++) {
                if (pob[i] >= pob[i + 1])//Проверка на правильность расположения двух последовательных элементов
                    flag2++;
                else {
                    temp = pob[i+1];
                    pob[i+1] = pob[i];
                    pob[i] = temp;
                }
                if (flag2 == pob.length - 1)//проверка на то, что все элементы последовательности стоят верно
                    flag = 0;
            }
        }

        //Перестановка элементов побочной оси в массиве
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i + j == a.length - 1) //сумма индексов строки и столбца элементов побочной оси равна размеру массива - 1
                    a[i][j] = pob[i];
            }
        }

        //Поиск среднего арифметического на пересечении диагоналей
        sr = Math.round((sumgl + sumpob)/(2*a.length));
        //Замена элемента на пересечении диагоналей на среднее арифметическое диагоналей
        a[a.length/2][a.length/2] = (int)sr;

        //Получение суммы элементов главной диагонали
        for (int x = 0; x< a.length; x ++){
            for (int y = 0; y<a.length; y++){
                if (x == y)
                    sumgl2+=a[x][y];
            }
        }
        //Получение суммы элементов побочной диагонали
        for (int i = 0; i<a.length;i++){
            for (int j = a.length-1; j!=-1; j--){
                if (i + j == a.length - 1)
                    sumpob2 +=a[i][j];
            }
        }

        //Получение разницы между суммами диагоналей
        int differ = Math.abs(sumpob2-sumgl2);

        //Поиск и вывод на экран диагоналей массива
        out.println("Диагонали:");
        //Диагонали ниже главной и главная
        for (int u = a.length - 1; u>=0; u--) {
            for (int i = 0; i <a.length ; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (i == j + u) {
                        out.print(a[i][j] + " ");
                    }
                }
            }
            out.println();
        }

        //Диагонали выше главной
        for (int u = 1; u<a.length; u++) {
            for (int i = 0; i <a.length ; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (i == j + u) {
                        out.print(a[j][i] + " ");
                    }
                }
            }
            out.println();
        }

        //Поиск строки с минимальной суммой и её индекса
        for (int i = 0; i < a.length ; i++) {
            int sum = 0;
            for (int j = 0; j< a.length; j++){
                sum += a[i][j];
            }
            if (sum<mins) {
                mins = sum;
                n1 = i;
            }
        }

        //Поиск столбца с минимальной суммой и его индекса
        for (int i = 0; i < a.length ; i++) {
            int sum = 0;
            for (int j = 0; j<a.length; j++){
                sum += a[j][i];
            }
            if (sum<mins2) {
                mins2 = sum;
                n2 = i;
            }
        }

        //Вывод индексов строки с минимальной суммой и столбца с минимальной суммой
        out.println();

        out.print("Индекс строки:");
        out.println(n1);

        out.print("Индекс столбца:");
        out.println(n2);

        out.println();

        out.println("Новая матрица:");

        //Вывод новой матрицы
        for (int i = 0 ; i < a.length; i++) {
            flag = 0;
            for (int j = 0; j < a.length; j++) {
                if (i!=n1 && j!=n2) {
                    System.out.print(a[i][j] + " ");
                    flag++;
                }
            }
            if(flag==a.length - 1)
                System.out.println();
        }
    }
}
 ```

**6.Анализ правильности решения**
1. Тест на проверку корректности работы с натуральными числами
   * Input
      ```
     5
     1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
      ```
   * Output
      ```
      Диагонали:
      5 
      16 22 
      11 9 23 
      6 12 18 24 
      1 7 13 19 25 
      2 8 14 20 
      3 17 15 
      4 10 
      21 
      
      Индекс строки:0
      Индекс столбца:0
      
      Новая матрица:
      7 8 17 10 
      12 13 14 15 
      9 18 19 20 
      22 23 24 25 
      ```
2. Тест на проверку корректности работы с целыми числами
   * Input
      ```
       5
       16 -27 72 46 71 78 -12 61 89 -52 -14 -24 -40 45 -96 99 -4 26 0 -4 51 -44 -22 -84 54
      ```
   * Output
      ```
        Диагонали:
        -4 
        99 -44 
        -14 0 -22 
        78 -24 26 -84 
        -40 -12 23 16 54 
        -27 61 45 -4 
        72 71 -96 
        46 -52 
        89 
        
        Индекс строки:4
        Индекс столбца:1
        
        Новая матрица:
        -40 72 46 89 
        78 61 71 -52 
        -14 23 45 -96 
        99 26 16 -4 
      ``` 
3. Проверка на корректность работы при наличии строк и столбцов с одинаковой суммой элементов
   * Input
      ```
     5
     1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
      ```
   * Output
      ```
      Диагонали:
      1 
      1 1 
      1 1 1 
      1 1 1 1 
      1 1 1 1 1 
      1 1 1 1 
      1 1 1 
      1 1 
      1 
      
      Индекс строки:0
      Индекс столбца:0
      
      Новая матрица:
      1 1 1 1 
      1 1 1 1 
      1 1 1 1 
      1 1 1 1 
      ``` 
