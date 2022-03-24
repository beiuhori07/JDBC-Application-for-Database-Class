package proiect_bd;

public class TestFirstPage {
    public static void main(String[] args) {
		Model model = new Model();
		FirstPageView view = new FirstPageView();
		FirstPageController controller = new FirstPageController(model, view);
	}
}
