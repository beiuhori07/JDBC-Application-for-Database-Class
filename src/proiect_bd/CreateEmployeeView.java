package proiect_bd;

import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreateEmployeeView extends CreateUserView {
    private JTextField salariu = new JTextField();
    private JTextField departament = new JTextField();
    private JTextField norma = new JTextField();

    CreateEmployeeView() {
        super();
        label.setText("Creeaza un angajat");
        JLabel salariuLabel = new JLabel("Salariu", JLabel.CENTER);
        JLabel departamentLabel = new JLabel("Departament", JLabel.CENTER);
        JLabel normaLabel = new JLabel("Norma", JLabel.CENTER);

        salariuLabel.setBounds(xCoord, yCoord * 12 + yOffset, width, height);
        departamentLabel.setBounds(xCoord, yCoord * 13 + yOffset, width, height);
        normaLabel.setBounds(xCoord, yCoord * 14 + yOffset, width, height);
        
        salariu.setBounds(xCoord + 100, yCoord * 12 + yOffset, width + 100, height);
        departament.setBounds(xCoord + 100, yCoord * 13 + yOffset, width + 100, height);
        norma.setBounds(xCoord + 100, yCoord * 14 + yOffset, width + 100, height);

        btnCreate.setText("Creeaza angajat");
        labelIncompleteField.setBounds(xCoord + 60, yCoord * 14 + 27 + yOffset, width + 100, height);
        labelDateWrong.setBounds(xCoord + 60, yCoord * 14 + 27 + yOffset, width + 100, height);
        labelUsernameWrong.setBounds(xCoord + 60, yCoord * 14 + 27 + yOffset, width + 100, height);
        btnCreate.setBounds(xCoord + 20, yCoord * 15 + yOffset + 15, width + 40, height);
        btnBack.setBounds(xCoord + 180, yCoord * 15 + yOffset + 15, width + 20, height);

        this.add(salariu);
        this.add(salariuLabel);
        this.add(norma);
        this.add(normaLabel);
        this.add(departament);
        this.add(departamentLabel);


        this.setLocation(520, 20);
        this.setSize(450, 780);
        this.setVisible(true);
    }
    public int getIntSalariu() {
        if(isNumeric(getSalariu())) {
            int value = Integer.parseInt(getSalariu());
            return value;
        }
        else
            return 0;
    }
    public Boolean areTextFieldsIncomplete() {
        return 
            getNume().equals("") ||
            getPrenume().equals("") ||
            getAdresa().equals("") ||
            getNr().equals("") ||
            getEmail().equals("") ||
            getBanca().equals("") ||
            getAn().equals("") ||
            getZi().equals("") ||
            getLuna().equals("") ||
            getUsername().equals("") ||
            getPassword().equals("") ||
            getSalariu().equals("") ||
            getDepartament().equals("") ||
            getNorma().equals("");
    }
    public String getSalariu() {
        return salariu.getText();
    }
    public String getDepartament() {
        return departament.getText();
    }
    public String getNorma() {
        return norma.getText();
    }

    
    public void addCreateEmployeeListener(ActionListener cal) {
        btnCreate.addActionListener(cal);
    }
    public static void main(String[] args) {
        CreateEmployeeView view = new CreateEmployeeView();
    }
}
