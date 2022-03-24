package proiect_bd;

public class TestAdminMenu {
    public static void main(String[] args) {
        Model model = new Model();
        AdminMainMenuView view = new AdminMainMenuView("admin");
        AdminMainMenuController controller = new AdminMainMenuController(model, view);
    }
}
