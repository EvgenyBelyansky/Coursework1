public class EmploeeBook {

    private final Department[] departments = new Department[5];

    public int departmentSize() {
        int amount = 0;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                amount++;
            }
        }
        return amount;
    }

    public void addDepartment(Department department) {
        if (departmentSize() >= departments.length) {
            throw new DepartmentIsFullException();
        }
        departments[departmentSize()] = department;
    }

    public void printAllEmploee() {
        System.out.println("\n\nСписок всех данных сотрудников:");
        for (int i = 0; i < departmentSize(); i++) {
            System.out.println("%s. %s\n");
            departments[i].printAllEmploeesOfDepartment();
        }
    }

    public void printFullNameEmploee() {
        System.out.println("\n\nСписок сотрудников:");
        for (int i = 0; i < departmentSize(); i++) {
            System.out.printf("%s. %s\n", i + 1, departments[i].g);
        }
    }

    public double calculateSumSalariesPerMonth() {
        double sum = 0;
        for (int i = 0; i < departmentSize(); i++) {
            sum += departments[i].calculateSumSalariesPerMonthOfDepartment();
        }
        return sum;
    }

    public double calculateAverageSalary() {
        return calculateSumSalariesPerMonth() / (double) emploeesSize();
    }

    public Emploee findEmploeeWithMinSalary() {
        Emploee minSalaryEmploee = emploees[0];
        for (int i = 0; i < emploeesSize(); i++) {
            if (minSalaryEmploee.getSalary() > emploees[i].getSalary()) {
                minSalaryEmploee = emploees[i];
            }
        }
        return minSalaryEmploee;
    }

    public Emploee findEmploeeWithMaxSalary() {
        Emploee maxSalaryEmploee = emploees[0];
        for (int i = 0; i < 5; i++) {
            if (maxSalaryEmploee.getSalary() < emploees[i].getSalary()) {
                maxSalaryEmploee = emploees[i];
            }
        }
        return maxSalaryEmploee;
    }


    public void indexSalary(double percent) {
        percent /= 100;
        for (int i = 0; i < emploeesSize(); i++) {
            emploees[i].setSalary((emploees[i].getSalary() * percent) + emploees[i].getSalary());
        }
    }
}
