import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        EmploeeBook companyN1 = new EmploeeBook();
        Department departmentN1;
        Department departmentN2;
        Department departmentN3;
        Department departmentN4;
        Department departmentN5;

        companyN1.addDepartment(departmentN1 = new Department(2, 1));
        companyN1.addEmploee(
                new Emploee(
                        "Сидоров",
                        "Петр",
                        "Константинович",
                        1,
                        100
                ),
                departmentN1.getDepartmentNumber()
        );

        companyN1.addEmploee(
                new Emploee(
                        "Краюшина",
                        "Елена",
                        "Александровна",
                        departmentN1.getDepartmentNumber(),
                        220
                ),
                departmentN1.getDepartmentNumber()
        );

        companyN1.addDepartment(departmentN2 = new Department(5, 2));
        companyN1.addEmploee(
                new Emploee(
                        "Мухин",
                        "Илья",
                        "Сергеевич",
                        departmentN2.getDepartmentNumber(),
                        200
                ),
                departmentN2.getDepartmentNumber()
        );
        companyN1.addEmploee(
                new Emploee(
                        "Петров",
                        "Константин",
                        "Викторович",
                        departmentN2.getDepartmentNumber(),
                        200
                ),
                departmentN2.getDepartmentNumber()
        );
        companyN1.addEmploee(
                new Emploee(
                        "Иванов",
                        "Иван",
                        "Иванович",
                        departmentN2.getDepartmentNumber(),
                        200
                ),
                departmentN2.getDepartmentNumber()
        );

        companyN1.addDepartment(departmentN3 = new Department(5, 3));
        companyN1.addEmploee(
                new Emploee(
                        "Краюшина",
                        "Елена",
                        "Александровна",
                        departmentN3.getDepartmentNumber(),
                        210
                ),
                departmentN3.getDepartmentNumber()
        );
        companyN1.addEmploee(
                new Emploee(
                        "Горбунов",
                        "Илья",
                        "Витальевич",
                        departmentN3.getDepartmentNumber(),
                        260
                ),
                departmentN3.getDepartmentNumber()
        );

        companyN1.addDepartment(departmentN4 = new Department(3, 4));
        companyN1.addEmploee(
                new Emploee(
                        "Арапов",
                        "Владимир",
                        "Николаевич",
                        departmentN4.getDepartmentNumber(),
                        220
                ),
                departmentN4.getDepartmentNumber()
        );
        companyN1.addEmploee(
                new Emploee(
                        "Федорова",
                        "Ольга",
                        "Евгеньевна",
                        departmentN4.getDepartmentNumber(),
                        260
                ),
                departmentN4.getDepartmentNumber()
        );

        companyN1.addDepartment(departmentN5 = new Department(10, 5));
        companyN1.addEmploee(
                new Emploee(
                        "Федоров",
                        "Кирилл",
                        "Евгеньевич",
                        departmentN5.getDepartmentNumber(),
                        100
                ),
                departmentN5.getDepartmentNumber()
        );

        companyN1.printAllEmploee();
        companyN1.printFullNameEmploeeInCompany();
        System.out.println(companyN1.calculateSumSalariesPerMonthInCompany());
        System.out.println(companyN1.calculateAverageSalaryInCompany());
        System.out.println(Arrays.toString(companyN1.findAllEmploeeWithMinSalaryInCompany()));
        System.out.println(companyN1.findEmploeeInCompanyById(3));
        companyN1.indexSalaryAllEmploees(20);
        companyN1.printAllEmploee();

        System.out.println("\n" + companyN1.findMaxSalaryInCompany());
        System.out.println(Arrays.toString(companyN1.findAllEmploeeWithMaxSalaryInCompany()));

        System.out.println("\nСписок сотрудников с зарплатой меньше 250:");
        companyN1.findAndPrintEmploeesWithSalaryLessThanInCompany(250);

    }
}