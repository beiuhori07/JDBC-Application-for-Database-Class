package proiect_bd;

public class TestMainMenu {
    public static void main(String[] args) {
        Model model = new Model();
        MainMenuClientView view = new MainMenuClientView("beiuhori07");
        MainMenuController controller = new MainMenuController(model, view);
    }
}
