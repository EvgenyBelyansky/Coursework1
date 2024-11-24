public class OrganizationIsFullException extends RuntimeException {
    public OrganizationIsFullException() {
        super("Нет места для нового департамента!");
    }
}
