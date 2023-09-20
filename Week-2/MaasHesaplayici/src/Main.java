import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        int salary, workHours, hireYear;

        System.out.print("İşçinin ismini giriniz: ");
        name = input.nextLine();

        System.out.print("İşçinin maaşını giriniz: ");
        salary = input.nextInt();

        System.out.print("İşçinin çalışma saatini giriniz: ");
        workHours = input.nextInt();

        System.out.print("İşçinin işe giriş tarihini giriniz: ");
        hireYear = input.nextInt();

        Employee e1 = new Employee(name, salary, workHours, hireYear);
        e1.toString();

    }
}