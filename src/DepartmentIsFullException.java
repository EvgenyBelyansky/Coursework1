public class DepartmentIsFullException extends RuntimeException{
    public DepartmentIsFullException() {
        super("В департаменте не осталось свободных мест!");
    }
}
