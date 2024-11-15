public class Main {
    private static Emploee[] emploees = new Emploee[10];

    public static void main(String[] args) {

        EmploeeBook emploeeBook = new EmploeeBook();

        emploees[0] = new Emploee(
                "Глухова",
                "Ксения",
                "Валерьевна",
                1,
                310
        );
        emploees[1] = new Emploee(
                "Кохановский",
                "Дмитрий",
                "Алексеевич",
                1,
                300
        );
        emploees[2] = new Emploee(
                "Мухин",
                "Илья",
                "Сергеевич",
                2,
                200
        );
        emploees[3] = new Emploee(
                "Петров",
                "Константин",
                "Викторович",
                2,
                100
        );
        emploees[4] = new Emploee(
                "Иванов",
                "Иван",
                "Иванович",
                3,
                200
        );
        emploees[5] = new Emploee(
                "Сидоров",
                "Петр",
                "Константинович",
                3,
                150
        );
        emploees[6] = new Emploee(
                "Краюшина",
                "Елена",
                "Александровна",
                3,
                100
        );
        emploees[7] = new Emploee(
                "Горбунов",
                "Илья",
                "Витальевич",
                4,
                260
        );
        emploees[8] = new Emploee(
                "Арапов",
                "Владимир",
                "Николаевич",
                5,
                120
        );
        emploees[9] = new Emploee(
                "Федорова",
                "Ольга",
                "Евгеньевна",
                5,
                150
        );


        System.out.printf("\nСумма затрат на ЗП в месяц: %s", calculateSumSalariesPerMonth());

        System.out.printf("\nСредняя зарплата: %.2f", calculateAverageSalary());

        System.out.printf("\nСотрудник с минимальной ЗП: %s", findEmploeeWithMinSalary());

        System.out.printf("\nСотрудник с максимальной ЗП: %s", findEmploeeWithMaxSalary());

        printFullNameEmploee();
        printAllEmploee();
        indexSalary(10);
        printAllEmploee();

        int selectedDepartment = 5;

        System.out.printf("\nСотрудник с максимальной ЗП в %s-м отделе: %s",
                selectedDepartment, findEmploeeWithMaxSalaryInDepartment(selectedDepartment));
        System.out.printf("\nСотрудник с минимальной ЗП в %s-м отделе: %s",
                selectedDepartment, findEmploeeWithMinSalaryInDepartment(selectedDepartment));

        System.out.printf("\nСумма затрат на ЗП в %s-м отделе: %s",
                selectedDepartment, calculateSumSalariesPerMonthOfDepartment(selectedDepartment));

        System.out.printf("\nВ %s-м отделе работающих сотрудников: %s",
                selectedDepartment, countDepartment(selectedDepartment));
        System.out.printf("\nСредняя зарплата в %s-м отделе: %.2f",
                selectedDepartment, calculateAverageSalaryOfDepartment(selectedDepartment));

        indexSalaryEmploeeOfDepartment(20, selectedDepartment);

        printAllEmploeesOfDepartment(selectedDepartment);

        findAndPrintEmploeesWithSalaryLessThan(25000);

        findAndPrintEmploeesWithSalaryMoreThan(50000);

    }

    public static void checkDepartmentNumber(int departmentNumber) {
        if (departmentNumber < 1 || departmentNumber > 5) {
            throw new IllegalArgumentException("Такого департамента не существует");
        }
    }

    public static void printAllEmploee() {
        System.out.println("\n\nСписок всех данных сотрудников:");
        for (int i = 0; i < emploeesSize(); i++) {
            System.out.printf("%s. %s\n", i + 1, emploees[i]);
        }
    }

    public static void printFullNameEmploee() {
        System.out.println("\n\nСписок сотрудников:");
        for (int i = 0; i < emploeesSize(); i++) {
            System.out.printf("%s. %s\n", i + 1, emploees[i].getEmploeeFullName());
        }
    }

    public static double calculateSumSalariesPerMonth() {
        double sum = 0;
        for (int i = 0; i < emploeesSize(); i++) {
            sum += emploees[i].getSalary();
        }
        return sum;
    }

    public static double calculateAverageSalary() {
        return calculateSumSalariesPerMonth() / (double) emploeesSize();
    }

    public static Emploee findEmploeeWithMinSalary() {
        Emploee minSalaryEmploee = emploees[0];
        for (int i = 0; i < emploeesSize(); i++) {
            if (minSalaryEmploee.getSalary() > emploees[i].getSalary()) {
                minSalaryEmploee = emploees[i];
            }
        }
        return minSalaryEmploee;
    }

    public static Emploee findEmploeeWithMaxSalary() {
        Emploee maxSalaryEmploee = emploees[0];
        for (int i = 0; i < emploeesSize(); i++) {
            if (maxSalaryEmploee.getSalary() < emploees[i].getSalary()) {
                maxSalaryEmploee = emploees[i];
            }
        }
        return maxSalaryEmploee;
    }

    public static int emploeesSize() {
        int amount = 0;
        for (int i = 0; i < emploees.length; i++) {
            if (emploees[i] != null) {
                amount++;
            }
        }
        return amount;
    }

    public static void indexSalary(double percent) {
        percent /= 100;
        for (int i = 0; i < emploeesSize(); i++) {
            emploees[i].setSalary((emploees[i].getSalary() * percent) + emploees[i].getSalary());
        }
    }

    public static Emploee findEmploeeWithMaxSalaryInDepartment(int departmentNumber) {
        checkDepartmentNumber(departmentNumber);
        Emploee maxSalaryEmploee = null;
        boolean isFirstEmploeeInDepartment;
        boolean isMaxSalaryEmploeeINDepartment;

        for (int i = 0; i < emploeesSize(); i++) {
            isFirstEmploeeInDepartment = departmentNumber == emploees[i].getDepartment() && maxSalaryEmploee == null;
            isMaxSalaryEmploeeINDepartment = maxSalaryEmploee != null &&
                    departmentNumber == emploees[i].getDepartment() &&
                    maxSalaryEmploee.getSalary() < emploees[i].getSalary();
            if (isFirstEmploeeInDepartment || isMaxSalaryEmploeeINDepartment) {
                maxSalaryEmploee = emploees[i];
            }
        }
        return maxSalaryEmploee;
    }

    public static Emploee findEmploeeWithMinSalaryInDepartment(int departmentNumber) {
        checkDepartmentNumber(departmentNumber);
        Emploee minSalaryEmploee = null;
        boolean isFirstEmploeeInDepartment;
        boolean isMaxSalaryEmploeeINDepartment;

        for (int i = 0; i < emploeesSize(); i++) {
            isFirstEmploeeInDepartment = departmentNumber == emploees[i].getDepartment() && minSalaryEmploee == null;
            isMaxSalaryEmploeeINDepartment = minSalaryEmploee != null &&
                    departmentNumber == emploees[i].getDepartment() &&
                    minSalaryEmploee.getSalary() > emploees[i].getSalary();
            if (isFirstEmploeeInDepartment || isMaxSalaryEmploeeINDepartment) {
                minSalaryEmploee = emploees[i];
            }
        }
        return minSalaryEmploee;
    }

    public static double calculateSumSalariesPerMonthOfDepartment(int departmentNumber) {
        checkDepartmentNumber(departmentNumber);
        double sumSalaryOfDepartment = 0;
        for (int i = 0; i < emploeesSize(); i++) {
            if (departmentNumber == emploees[i].getDepartment()) {
                sumSalaryOfDepartment += emploees[i].getSalary();
            }
        }
        return sumSalaryOfDepartment;
    }

    public static int countDepartment(int departmentNumber) {
        checkDepartmentNumber(departmentNumber);
        int quantityEmploeeINDepartment = 0;
        for (int i = 0; i < emploeesSize(); i++) {
            if (departmentNumber == emploees[i].getDepartment()) {
                quantityEmploeeINDepartment++;
            }
        }
        return quantityEmploeeINDepartment;
    }

    public static double calculateAverageSalaryOfDepartment(int departmentNumber) {
        checkDepartmentNumber(departmentNumber);
        return calculateSumSalariesPerMonthOfDepartment(departmentNumber) / countDepartment(departmentNumber);
    }

    public static void indexSalaryEmploeeOfDepartment(double percent, int departmentNumber) {
        checkDepartmentNumber(departmentNumber);
        percent /= 100;

        for (int i = 0; i < emploeesSize(); i++) {
            if (departmentNumber == emploees[i].getDepartment()) {
                emploees[i].setSalary((emploees[i].getSalary() * percent) + emploees[i].getSalary());
            }
        }
    }

    public static void printAllEmploeesOfDepartment(int departmentNumber) {
        checkDepartmentNumber(departmentNumber);
        System.out.printf("\n\nСписок всех сотрудников в %s-м отделе:", departmentNumber);
        for (int i = 0; i < emploeesSize(); i++) {
            if (departmentNumber == emploees[i].getDepartment()) {
                System.out.printf("\n%s", emploees[i].getEmploeeWithoutDepartment());
            }
        }
    }

    public static void findAndPrintEmploeesWithSalaryLessThan(double baseSalary) {
        System.out.printf("\n\nСписок сотрудников с ЗП меньше чем %s", baseSalary);
        for (int i = 0; i < emploeesSize(); i++) {
            if (emploees[i].getSalary() < baseSalary) {
                System.out.printf("\n%s", emploees[i].getEmploeeWithoutDepartment());
            }
        }
    }

    public static void findAndPrintEmploeesWithSalaryMoreThan(double baseSalary) {
        System.out.printf("\n\nСписок сотрудников с ЗП больше или равной %s", baseSalary);
        for (int i = 0; i < emploeesSize(); i++) {
            if (emploees[i].getSalary() >= baseSalary) {
                System.out.printf("\n%s", emploees[i].getEmploeeWithoutDepartment());
            }
        }
    }
}