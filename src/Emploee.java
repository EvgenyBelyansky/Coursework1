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
        if (departament >= 1 && departament <= 5) {
            this.departament = departament;
        } else {
            throw new IllegalArgumentException("Такого департамента не существует");
        }

    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть меньше или равна нулю");
        }

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
        return String.format("%s %s %s; Отдел: %s; Зарплата: %s; Id: %s.",
                lastName, firstName, middleName, departament, salary, id);
    }

    public String getEmploeeFullName() {
        return String.format("%s %s %s", lastName, firstName, middleName);
    }
}
