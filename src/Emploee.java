import java.util.Objects;
public class Emploee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int departament;
    private double salary;
    private int id;
    public static int count = 1;

    public Emploee(String lastName, String firstName, String middleName, int departament, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.departament = departament;
        this.salary = salary;
        this.id = count;
        count++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartament() {
        return departament;
    }

    public double getSalary() {
        return salary;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setDepartament(int departament) {
        if (departament < 1 && departament > 5) {
            this.departament = departament;
        }
        throw new IllegalArgumentException("Такого департамента не существует");
    }

    public void setSalary(int salary) {
        if (salary > 0) {
            this.salary = salary;
        }
        throw new IllegalArgumentException("Зарплата не может быть меньше или равна нулю");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Emploee emploee = (Emploee) o;
        return departament == emploee.departament && salary == emploee.salary && id == emploee.id &&
                Objects.equals(firstName, emploee.firstName) &&
                Objects.equals(middleName, emploee.middleName) &&
                Objects.equals(lastName, emploee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, departament, salary, id);
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s %s; Отдел: %s; Зарплата: %s; Id: %s.",
                lastName, firstName, middleName, departament, salary, id);
    }

    public static void printAllEmploee(Emploee[] emploees) {
        for (int i = 0; i < emploees.length; i++) {
            System.out.println(emploees[i]);
        }
    }

    public static double calculateSumSalariesPerMonth(Emploee[] emploees) {
        double sum = 0;
        for (int i = 0; i < emploees.length; ) {
            sum += emploees[i].salary;
            i++;
        }
        return sum;
    }

    public static double calculateAverageSalary(Emploee[] emploees) {
        double averageSalary = calculateSumSalariesPerMonth(emploees) / count;
        return averageSalary;
    }

    public static int findEmploeeWithMinSalary(Emploee[] emploees) {
        double minSalary = emploees[0].salary;
        int idEmploeeWithMinSalary = 0;
        for (int i = 0; i < emploees.length; i++) {
            if (minSalary > emploees[i].salary) {
                minSalary = emploees[i].salary;
                idEmploeeWithMinSalary = emploees[i].id;
            }
        }
        return idEmploeeWithMinSalary;
    }

    public static int findEmploeeWithMaxSalary(Emploee[] emploees) {
        double maxSalary = emploees[0].salary;
        int idEmploeeWithMaxSalary = 0;
        for (int i = 0; i < emploees.length; i++) {
            if (maxSalary < emploees[i].salary) {
                maxSalary = emploees[i].salary;
                idEmploeeWithMaxSalary = emploees[i].id;
            }
        }
        return idEmploeeWithMaxSalary;
    }
}
