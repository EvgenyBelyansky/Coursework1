import java.util.Comparator;

public class EmploeeSalaryComparator implements Comparator <Emploee> {


    @Override
    public int compare(Emploee o1, Emploee o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}
