public class Main {

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




}