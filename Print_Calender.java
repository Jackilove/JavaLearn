import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.Scanner;

public class Print_Calender {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        int year=cin.nextInt();
        int month=cin.nextInt();
        judgeYearAndMonth s=new judgeYearAndMonth();
        judgeYearAndMonth.year =year;
        judgeYearAndMonth.month =month;
        s.printCalender();
    }
}

class judgeYearAndMonth {
    static int year;
    static int month;
    static int flag;
    static int[] array;

    public int judgeYear() {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            flag = 1;
            return 1;
        } else {
            flag = 0;
            return 0;
        }
    }

    public void judgeMonth() {
        judgeYear();
        if (flag == 1) {
            array = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        } else {
            array = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }
    }

    public void printCalender() {
        judgeMonth();
        String[] daysOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < array[month-1]; i++) {
            int j = 0;
            LocalDate date = LocalDate.of(year, month, i+1);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            String temp = dayOfWeek.name();
            while (!temp.contains(daysOfWeek[j])) {
                j++;
            }
            if(i==0)
            {
                if (j != 6) {
                    for (int l = 0; l < 4 * j + 3; l++) {
                        System.out.print(" ");
                    }
                    System.out.print(i + 1);
                }
                if (j == 6) {
                    for (int l = 0; l < 4 * j + 3; l++) {
                        System.out.print(" ");
                    }
                    System.out.println(i + 1);
                }
            }
            if (i < 9&&i!=0) {
                if (j != 6)
                {
                    for (int l = 0; l < 3; l++) {
                        System.out.print(" ");
                    }
                    System.out.print(i + 1);
                }
                if (j == 6)
                {
                    for (int l = 0; l < 3; l++) {
                        System.out.print(" ");
                    }
                    System.out.println(i + 1);
                }
            }
            if(i>=9){
                if (j != 6)
                {
                    for (int l = 0; l < 2; l++) {
                        System.out.print(" ");
                    }
                    System.out.print(i + 1);
                }
                if (j == 6)
                {
                    for (int l = 0; l < 2; l++) {
                        System.out.print(" ");
                    }
                    System.out.println(i + 1);
                }
            }
        }
    }
}