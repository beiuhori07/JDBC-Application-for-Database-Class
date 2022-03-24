package proiect_bd;

public class TestEmployeeMenu {
    public static void main(String[] args) {
        Model model = new Model();
        EmployeeMenuView view = new EmployeeMenuView("hori");
        EmployeeMenuController controller = new EmployeeMenuController(model, view);
    }
}
    