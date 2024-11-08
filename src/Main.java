public class Main {
    private static Emploee [] emploees = new Emploee[10];

    public static void main(String[] args) {

        EmploeeBook emploeeBook = new EmploeeBook();

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



        System.out.printf("\nСумма затрат на ЗП в месяц: %s", calculateSumSalariesPerMonth());

        System.out.printf("\nСредняя зарплата: %.2f", calculateAverageSalary());

        System.out.printf("\nСотрудник с минимальной ЗП: %s", findEmploeeWithMinSalary());

        System.out.printf("\nСотрудник с максимальной ЗП: %s", findEmploeeWithMaxSalary());

        printFullNameEmploee();
        printAllEmploee();

    }
    public static void printAllEmploee() {
        System.out.println("\n\nСписок всех данных сотрудников:");
        for (int i = 0; i < emploees.length; i++) {
            System.out.printf("%s. %s\n", i+1, emploees[i]);
        }
    }

    public static void printFullNameEmploee() {
        System.out.println("\n\nСписок сотрудников:");
        for (int i = 0; i < emploees.length; i++) {
            System.out.printf("%s. %s\n", i+1, emploees[i].getEmploeeFullName());
        }
    }

    public static double calculateSumSalariesPerMonth() {
        double sum = 0;
        for (int i = 0; i < emploees.length; i++) {
            sum += emploees[i].getSalary();
        }
        return sum;
    }

    public static double calculateAverageSalary() {
        return calculateSumSalariesPerMonth() / (double) emploesSize();
    }

    public static Emploee findEmploeeWithMinSalary() {
        Emploee minSalaryEmploee = emploees[0];
        for (int i = 0; i < emploees.length; i++) {
            if (minSalaryEmploee.getSalary() > emploees[i].getSalary()) {
                minSalaryEmploee = emploees[i];
            }
        }
        return minSalaryEmploee;
    }

    public static Emploee findEmploeeWithMaxSalary() {
        Emploee maxSalaryEmploee = emploees[0];
        for (int i = 0; i < emploees.length; i++) {
            if (maxSalaryEmploee.getSalary() < emploees[i].getSalary()) {
                maxSalaryEmploee = emploees[i];
            }
        }
        return maxSalaryEmploee;
    }

    public static int emploesSize() {
        int amount = 0;
        for (int i = 0; i < emploees.length; i++) {
            if (emploees[i] != null) {
                amount++;
            }
        }
        return amount;
    }
}