import java.util.Scanner;

public class Main {
    static Emploee[] emploees = new Emploee[10];

    public static void main(String[] args) {

        emploees[0] = new Emploee("Глухова", "Ксения", "Валерьевна", 1, 55000);
        emploees[1] = new Emploee("Кохановский", "Дмитрий", "Алексеевич", 2, 15000);
        emploees[2] = new Emploee("Мухин", "Илья", "Сергеевич", 4, 10000);
        emploees[3] = new Emploee("Петров", "Константин", "Викторович", 3, 15000);
        emploees[4] = new Emploee("Иванов", "Иван", "Иванович", 5, 15000);
        emploees[5] = new Emploee("Сидоров", "Петр", "Константинович", 2, 11000);
        emploees[6] = new Emploee("Краюшина", "Елена", "Александровна", 3, 12000);
        emploees[7] = new Emploee("Горбунов", "Илья", "Витальевич", 1, 65000);
        emploees[8] = new Emploee("Арапов", "Владимир", "Николаевич", 5, 12000);
        emploees[9] = new Emploee("Федорова", "Ольга", "Евгеньевна", 2, 15000);

        Emploee.printAllEmploee(emploees);

        System.out.printf("\nСумма затрат на ЗП в месяц: %s", Emploee.calculateSumSalariesPerMonth(emploees));

        System.out.printf("\nСредняя зарплата: %.2f", Emploee.calculateAverageSalary(emploees));

        System.out.printf("\nСотрудник с минимальной ЗП: %s", emploees[Emploee.findEmploeeWithMinSalary(emploees) - 1]);

        System.out.printf("\nСотрудник с максимальной ЗП: %s", emploees[Emploee.findEmploeeWithMaxSalary(emploees) - 1]);

    }
}