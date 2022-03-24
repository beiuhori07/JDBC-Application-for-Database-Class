package proiect_bd;


import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class CreateUserView extends JFrame {
    private JTextField nume = new JTextField();
    private JTextField prenume = new JTextField();
    private JTextField adresa = new JTextField();
    private JTextField nr = new JTextField();
    private JTextField email = new JTextField();
    private JTextField banca = new JTextField();
    private JTextField an = new JTextField();
    private JTextField luna = new JTextField();
    private JTextField zi = new JTextField();
    private JTextField username = new JTextField();
    private JTextField password = new JPasswordField();
    private JTextField cnp = new JTextField();
    JButton btnCreate = new JButton("Creeaza utilizator");
    JButton btnBack = new JButton("Mergi inapoi");
    JLabel labelIncompleteField = new JLabel("Completeaza toate datele!", JLabel.CENTER);
    JLabel labelDateWrong = new JLabel("Data incorecta!", JLabel.CENTER);
    JLabel labelUsernameWrong = new JLabel("Nume utilzator deja folosit!", JLabel.CENTER);
    JLabel label = new JLabel("Creeaza un utilizator", JLabel.CENTER);

    int yOffset = 70;
    int xCoord = 50;
    int yCoord = 40;
    int width = 100;
    int height = 25;

    CreateUserView() {	
        JLabel cnpLabel = new JLabel("CNP", JLabel.CENTER);
        JLabel numeLabel = new JLabel("Nume", JLabel.CENTER);
        JLabel prenumeLabel = new JLabel("Prenume", JLabel.CENTER);
        JLabel adresaLabel = new JLabel("Adresa", JLabel.CENTER);
        JLabel nrLabel = new JLabel("Numar", JLabel.CENTER);
        JLabel emailLabel = new JLabel("Email", JLabel.CENTER);
        JLabel bancaLabel = new JLabel("Banca", JLabel.CENTER);
        JLabel anLabel = new JLabel("An", JLabel.CENTER);
        JLabel lunaLabel = new JLabel("Luna", JLabel.CENTER);
        JLabel ziLabel = new JLabel("Zi", JLabel.CENTER);
        JLabel usernameLabel = new JLabel("Nume Utilizator", JLabel.CENTER);
        JLabel passwordLabel = new JLabel("Parola", JLabel.CENTER);

        label.setBounds(115, 15, 200, 25);
        label.setFont(new Font("Dialog", Font.BOLD, 20));
        cnpLabel.setBounds(xCoord, yOffset, width, height);
        numeLabel.setBounds(xCoord, yCoord + yOffset, width, height);
        prenumeLabel.setBounds(xCoord, yCoord * 2 + yOffset, width, height);
        adresaLabel.setBounds(xCoord, yCoord * 3 + yOffset, width, height);
        nrLabel.setBounds(xCoord, yCoord * 4 + yOffset, width, height);
        emailLabel.setBounds(xCoord, yCoord * 5 + yOffset, width, height);
        bancaLabel.setBounds(xCoord, yCoord * 6 + yOffset, width, height);
        anLabel.setBounds(xCoord, yCoord * 7 + yOffset, width, height);
        lunaLabel.setBounds(xCoord, yCoord * 8 + yOffset, width, height);
        ziLabel.setBounds(xCoord, yCoord * 9 + yOffset, width, height);
        usernameLabel.setBounds(xCoord, yCoord * 10 + yOffset, width, height);
        passwordLabel.setBounds(xCoord, yCoord * 11 + yOffset, width, height);
        
        cnp.setBounds(xCoord + 100, yOffset, width + 100, height);
        nume.setBounds(xCoord + 100, yCoord + yOffset, width + 100, height);
        prenume.setBounds(xCoord + 100, yCoord * 2 + yOffset, width + 100, height);
        adresa.setBounds(xCoord + 100, yCoord * 3 + yOffset, width + 100, height);
        nr.setBounds(xCoord + 100, yCoord * 4 + yOffset, width + 100, height);
        email.setBounds(xCoord + 100, yCoord * 5 + yOffset, width + 100, height);
        banca.setBounds(xCoord + 100, yCoord * 6 + yOffset, width + 100, height);
        an.setBounds(xCoord + 100, yCoord * 7 + yOffset, width + 100, height);
        luna.setBounds(xCoord + 100, yCoord * 8 + yOffset, width + 100, height);
        zi.setBounds(xCoord + 100, yCoord * 9 + yOffset, width + 100, height);
        username.setBounds(xCoord + 100, yCoord * 10 + yOffset, width + 100, height);
        password.setBounds(xCoord + 100, yCoord * 11 + yOffset, width + 100, height);

        labelIncompleteField.setBounds(xCoord + 60, yCoord * 11 + 27 + yOffset, width + 100, height);
        labelDateWrong.setBounds(xCoord + 60, yCoord * 11 + 27 + yOffset, width + 100, height);
        labelUsernameWrong.setBounds(xCoord + 60, yCoord * 11 + 27 + yOffset, width + 100, height);
        btnCreate.setBounds(xCoord + 20, yCoord * 12 + yOffset + 15, width + 40, height);
        btnBack.setBounds(xCoord + 180, yCoord * 12 + yOffset + 15, width + 20, height);

        labelIncompleteField.setForeground(Color.red);
        labelDateWrong.setForeground(Color.red);
        labelUsernameWrong.setForeground(Color.red);
        labelIncompleteField.setVisible(false);
        labelDateWrong.setVisible(false);
        labelUsernameWrong.setVisible(false);

        this.add(cnpLabel);
        this.add(labelDateWrong);
        this.add(labelUsernameWrong);
        this.add(labelIncompleteField);
        this.add(label);
        this.add(numeLabel);
        this.add(prenumeLabel);
        this.add(adresaLabel);
        this.add(nrLabel);
        this.add(emailLabel);
        this.add(bancaLabel);
        this.add(anLabel);
        this.add(lunaLabel);
        this.add(ziLabel);
        this.add(usernameLabel);
        this.add(passwordLabel);

        this.add(cnp);
        this.add(nume);
        this.add(prenume);
        this.add(adresa);
        this.add(nr);
        this.add(email);
        this.add(banca);
        this.add(an);
        this.add(luna);
        this.add(zi);
        this.add(username);
        this.add(password);
            
        this.add(btnCreate);
        this.add(btnBack);

        this.setLocation(520, 50);
		this.setSize(450, 660);
		this.setLayout(null);
		this.setResizable(false);
		
		this.setTitle("mare titlu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public Boolean isDateFormatGood() {
        if(isDateANumber()) {
            int an = Integer.parseInt(getAn());
            int luna = Integer.parseInt(getLuna());
            int zi = Integer.parseInt(getZi());

            if(an >= 1900 && an <= 2022 && luna >= 1 && luna <= 12 && zi >= 1 && zi <= 31)
                return true;
            else
                return false;
        }
        return false;
    }
    public String getDate() {
        String an = getAn();
        String luna = getLuna();
        String zi = getZi();
        if(luna.length() == 1) {
            luna = "0" + luna;
        }
        if(zi.length() == 1) {
            zi = "0" + zi;
        }
        return an + "-" + luna + "-" + zi;
    }
    public Boolean isDateANumber() {
        return
            isNumeric(an.getText()) &&
            isNumeric(luna.getText()) &&
            isNumeric(zi.getText());
    }
    public static boolean isNumeric(String string) {
        int intValue;    
        if(string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    public void setVisIncompleteLabel(Boolean bool) {
        labelIncompleteField.setVisible(bool);
    }
    public void setVisDateWrongLabel(Boolean bool) {
        labelDateWrong.setVisible(bool);
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
            getPassword().equals("");
    }

    public void addCreateUserListener(ActionListener cal) {
        btnCreate.addActionListener(cal);
    }
    public void addBackListener(ActionListener cal) {
        btnBack.addActionListener(cal);
    }

    public String getCNP() {
        return cnp.getText();
    }
    public String getNume() {
        return nume.getText();
    }
    public String getPrenume() {
        return prenume.getText();
    }
    public String getAdresa() {
        return adresa.getText();
    }
    public String getNr() {
        return nr.getText();
    }
    public String getEmail() {
        return email.getText();
    }
    public String getBanca() {
        return banca.getText();
    }
    public String getAn() {
        return an.getText();
    }
    public String getLuna() {
        return luna.getText();
    }
    public String getZi() {
        return zi.getText();
    }
    public String getUsername() {
        return username.getText();
    }
    public String getPassword() {
        return password.getText();
    }
    public static void main(String[] args) {
        CreateUserView view = new CreateUserView();
    }
}
