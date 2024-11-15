import java.util.Objects;

public class Department {

    private final Emploee[] emploees;
    private final int departmentNumber;

    public Department(int departmentSize, int departmentNumber) {
        emploees = new Emploee[departmentSize];
        this.departmentNumber = departmentNumber;

    }

    public void addEmploee(Emploee emploee) {
        if (emploeesSize() >= emploees.length) {
            throw new DepartmentIsFullException();
        }
        emploees[emploeesSize()] = emploee;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public int emploeesSize() {
        int amount = 0;
        for (int i = 0; i < emploees.length; i++) {
            if (emploees[i] != null) {
                amount++;
            }
        }
        return amount;
    }

    public Emploee findEmploeeWithMaxSalaryInDepartment() {
        Emploee maxSalaryEmploee = emploees[0];

        for (int i = 0; i < emploeesSize(); i++) {
            if (maxSalaryEmploee.getSalary() < emploees[i].getSalary()) {
                maxSalaryEmploee = emploees[i];
            }
        }
        return maxSalaryEmploee;
    }

    public Emploee findEmploeeWithMinSalaryInDepartment() {
        Emploee minSalaryEmploee = emploees[0];

        for (int i = 0; i < emploeesSize(); i++) {
            if (minSalaryEmploee.getSalary() > emploees[i].getSalary()) {
                minSalaryEmploee = emploees[i];
            }
        }
        return minSalaryEmploee;
    }

    public double calculateSumSalariesPerMonthOfDepartment() {
        double sumSalaryOfDepartment = 0;
        for (int i = 0; i < emploeesSize(); i++) {
            sumSalaryOfDepartment += emploees[i].getSalary();
        }
        return sumSalaryOfDepartment;
    }

    public int countDepartment() {
        int quantityEmploeeINDepartment = 0;
        for (int i = 0; i < emploeesSize(); i++) {
            quantityEmploeeINDepartment++;
        }
        return quantityEmploeeINDepartment;
    }

    public double calculateAverageSalaryOfDepartment() {
        return calculateSumSalariesPerMonthOfDepartment() / countDepartment();
    }

    public void indexSalaryEmploeeOfDepartment(final double percent) {
        for (int i = 0; i < emploeesSize(); i++) {
            emploees[i].setSalary((emploees[i].getSalary() * percent / 100) + emploees[i].getSalary());
        }
    }

    public void printAllEmploeesOfDepartment() {
        System.out.printf("\n\nСписок всех сотрудников в %s-м отделе:", departmentNumber);
        for (int i = 0; i < emploeesSize(); i++) {
            System.out.printf("\n%s", emploees[i].getEmploeeWithoutDepartment());
        }
    }

    public void findAndPrintEmploeesWithSalaryLessThan(double baseSalary) {
        System.out.printf("\n\nСписок сотрудников с ЗП меньше чем %s", baseSalary);
        for (int i = 0; i < emploeesSize(); i++) {
            if (emploees[i].getSalary() < baseSalary) {
                System.out.printf("\n%s", emploees[i].getEmploeeWithoutDepartment());
            }
        }
    }

    public void findAndPrintEmploeesWithSalaryMoreThan(double baseSalary) {
        System.out.printf("\n\nСписок сотрудников с ЗП больше или равной %s", baseSalary);
        for (int i = 0; i < emploeesSize(); i++) {
            if (emploees[i].getSalary() >= baseSalary) {
                System.out.printf("\n%s", emploees[i].getEmploeeWithoutDepartment());
            }
        }
    }


}