public class Department {


    private final Emploee[] emploees;
    private final int departmentNumber;
    private int emploeesSizeInDepartment;

    public Department(int departmentSize, int departmentNumber) {
        emploees = new Emploee[departmentSize];
        this.departmentNumber = departmentNumber;
    }


    public void addEmploee(Emploee emploee) {

        if (emploeesSizeInDepartment >= emploees.length) {
            throw new DepartmentISFullException();
        }
        emploees[emploeesSizeInDepartment++] = emploee;
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < emploeesSizeInDepartment; i++) {
            if (emploees[i].getId() == id) {
                System.arraycopy(emploees, i + 1, emploees, i, emploeesSizeInDepartment - i - 1);
                emploees[emploeesSizeInDepartment-- - 1] = null;
                return;
            }
        }
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public Emploee findEmploeeWithMaxSalaryInDepartment() {
        Emploee maxSalaryEmploee = emploees[0];

        for (int i = 0; i < emploeesSizeInDepartment; i++) {
            if (maxSalaryEmploee.getSalary() < emploees[i].getSalary()) {
                maxSalaryEmploee = emploees[i];
            }
        }
        return maxSalaryEmploee;
    }

    public Emploee findEmploeeWithMinSalaryInDepartment() {
        Emploee minSalaryEmploee = emploees[0];

        for (int i = 0; i < emploeesSizeInDepartment; i++) {
            if (minSalaryEmploee.getSalary() > emploees[i].getSalary()) {
                minSalaryEmploee = emploees[i];
            }
        }
        return minSalaryEmploee;
    }

    public double calculateSumSalariesPerMonthOfDepartment() {
        double sumSalaryOfDepartment = 0;
        for (int i = 0; i < emploeesSizeInDepartment; i++) {
            sumSalaryOfDepartment += emploees[i].getSalary();
        }
        return sumSalaryOfDepartment;
    }

    public int getEmploeesSizeInDepartment() {
        return emploeesSizeInDepartment;
    }

    public double calculateAverageSalaryOfDepartment() {
        return calculateSumSalariesPerMonthOfDepartment() / emploeesSizeInDepartment;
    }

    public void indexSalaryEmploeeOfDepartment(final double percent) {
        for (int i = 0; i < emploeesSizeInDepartment; i++) {
            emploees[i].setSalary((emploees[i].getSalary() * percent / 100) + emploees[i].getSalary());
        }
    }

    public void printAllEmploeesOfDepartment() {
        System.out.printf("\nСписок всех сотрудников в %s-м отделе:", departmentNumber);
        for (int i = 0; i < emploeesSizeInDepartment; i++) {
            System.out.printf("\n%s", emploees[i].getEmploeeWithoutDepartment());
        }

    }

    public void printAllFullNamesEmploeesOfDepartment() {
        System.out.printf("Список сотрудников %s отдела:%n", this.getDepartmentNumber());
        for (int i = 0; i < emploeesSizeInDepartment; i++) {
            System.out.println(emploees[i].getEmploeeFullName());
        }
    }

    public void findAndPrintEmploeesWithSalaryLessThanInDepartment(double baseSalary) {
        for (int i = 0; i < emploeesSizeInDepartment; i++) {
            if (emploees[i].getSalary() < baseSalary) {
                System.out.printf("\n%s", emploees[i].getEmploeeWithoutDepartment());
            }
        }
    }

    public Emploee findEmploeeInDepartmentByID(final int emploeeId) {
        Emploee emploeeInDepartmentById = emploees[0];
        for (int i = 0; i < emploeesSizeInDepartment; i++) {
            if (emploeeId == emploees[i].getId()) {
                emploeeInDepartmentById = emploees[i];
            }
        }
        return emploeeInDepartmentById;
    }
}