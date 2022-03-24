package proiect_bd;

public class EmClientData extends ClientDataPanel{
    EmClientData(String user) {
        super(user);
        rigidarea1.remove(modifybtn);
        rigidarea1.repaint();
        rigidarea1.revalidate();

        nume.setEditable(false);
        prenume.setEditable(false);
        cnp.setEditable(false);
        username.setEditable(false);
        id.setEditable(false);
        adress.setEditable(false);
        nr.setEditable(false);
        email.setEditable(false);
        bank.setEditable(false);
        date.setEditable(false);

        idField.setBounds(400, 500, 150, 30);
    }
}
