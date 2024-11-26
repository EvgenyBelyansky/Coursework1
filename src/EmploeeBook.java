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
            throw new CompanyFullException();
        }
        departments[departmentSize()] = department;
    }


    public void printAllEmploee() {
        System.out.println("\n\nСписок всех данных сотрудников:");
        for (int i = 0; i < departmentSize(); i++) {
            departments[i].printAllEmploeesOfDepartment();
        }
    }

    public void addEmploee(Emploee emploee, int departmentNumber) {
        for (int i = 0; i < departmentSize(); i++) {
            if (departmentNumber == departments[i].getDepartmentNumber()) {
                departments[i].addEmploee(emploee);
                break;
            }
        }
    }

    public void printFullNameEmploeeInCompany() {
        System.out.println("\n\nСписок сотрудников компании:");
        for (int i = 0; i < departmentSize(); i++) {
            departments[i].printAllFullNamesEmploeesOfDepartment();
        }
    }

    public double calculateSumSalariesPerMonthInCompany() {
        double sum = 0;
        for (int i = 0; i < departmentSize(); i++) {
            sum += departments[i].calculateSumSalariesPerMonthOfDepartment();
        }
        return sum;
    }

    public int calculateQuantityEmploeeINCompany() {
        int quantityEmploeeINCompany = 0;
        for (int i = 0; i < departmentSize(); i++) {
            quantityEmploeeINCompany += departments[i].getEmploeesSizeInDepartment();
        }
        return quantityEmploeeINCompany;
    }

    public double calculateAverageSalaryInCompany() {
        return calculateSumSalariesPerMonthInCompany() / calculateQuantityEmploeeINCompany();
    }


    public double findMinSalaryInCompany() {
        double tempSalary;
        double minSalaryInCompany = departments[0].findEmploeeWithMinSalaryInDepartment().getSalary();
        for (int i = 0; i < departmentSize(); i++) {
            tempSalary = departments[i].findEmploeeWithMinSalaryInDepartment().getSalary();
            if (minSalaryInCompany > tempSalary) {
                minSalaryInCompany = tempSalary;
            }
        }
        return minSalaryInCompany;
    }

    public int countMinSalaryInCompany() {
        int count = 0;
        for (int i = 0; i < departmentSize(); i++) {
            if (departments[i].findEmploeeWithMinSalaryInDepartment().getSalary() == findMinSalaryInCompany()) {
                count++;
            }
        }
        return count;
    }

    public Emploee[] findAllEmploeeWithMinSalaryInCompany() {
        Emploee[] minSalaryEmploeesInCompany = new Emploee[countMinSalaryInCompany()];
        int j = 0;
        for (int i = 0; i < departmentSize(); i++) {
            if (departments[i].findEmploeeWithMinSalaryInDepartment().getSalary() == findMinSalaryInCompany()) {
                minSalaryEmploeesInCompany[j] = departments[i].findEmploeeWithMinSalaryInDepartment();
                j++;
            }
        }
        return minSalaryEmploeesInCompany;
    }

    public Emploee[] findAllEmploeeWithMinSalaryInCompanyV2() {
        Emploee[] minSalaryEmploeesInCompany = new Emploee[departmentSize()];
        for (int i = 0; i < departmentSize(); i++) {

        }
        return null;
    }

//    Имеет ли смысл делать такой же набор методов для максимальной ЗП или нужно сделать по другому?

    public void indexSalaryAllEmploees(final double percent) {
        for (int i = 0; i < departmentSize(); i++) {
            departments[i].indexSalaryEmploeeOfDepartment(percent);
        }
    }

    public Emploee findEmploeeInCompanyById(final int idEmploee) {
        Emploee emploeebyId = departments[0].findEmploeeInDepartmentByID(idEmploee);
        for (int i = 0; i < departmentSize(); i++) {
            if (idEmploee == departments[i].findEmploeeInDepartmentByID(idEmploee).getId()) {
                emploeebyId = departments[i].findEmploeeInDepartmentByID(idEmploee);
            }

        }
        return emploeebyId;
    }
}