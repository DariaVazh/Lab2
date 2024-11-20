import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {

        int n = in.nextInt();

        int[][] a = new int[n][n];
        int [] glav = new int[n];
        int [] pob = new int[n];
        int sumgl = 0;
        int sumpob = 0;
        int flag;
        int flag2 = 0;
        int temp;
        int sr;
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
        
        //Получение массива из элементов главной диагонали и суммы элементов шлавной диагонали
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
        sr = (sumgl + sumpob)/(2*a.length);
        a[a.length/2][a.length/2] = sr;

        //Получение суммы элементов главной оси
        for (int x = 0; x< a.length; x ++){
            for (int y = 0; y<a.length; y++){
                if (x == y)
                    sumgl2+=a[x][y];
            }
        }
        //Получение суммы элементов побочной оси
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
