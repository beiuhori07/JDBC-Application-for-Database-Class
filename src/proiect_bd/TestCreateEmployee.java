package proiect_bd;

public class TestCreateEmployee {
    public static void main(String[] args) {
        CreateEmployeeView view = new CreateEmployeeView();
        Model model = new Model();
        CreateEmployeeController controller = new CreateEmployeeController(model, view);
    }
}
