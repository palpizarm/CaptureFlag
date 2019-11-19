package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Variables declaration - do not modify 
    private JPanel panel;   
    private JTextField email;
    private JTextField pasword;
    private JLabel labelEmail;
    private JLabel labelLogin;
    private JLabel labelPasword;
    private JButton loginButton; 
    private JButton registerButton;
    // End of variables declaration 
    

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
                                 
    private void initComponents() {
    	this.setTitle("Login");
        panel = new JPanel();
        email = new JTextField();
        pasword = new JTextField();
        labelLogin = new JLabel();
        labelPasword = new JLabel();
        labelEmail = new JLabel();
        loginButton = new JButton();
        registerButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new Color(102, 102, 102));       

        labelLogin.setFont(new Font("Times New Roman", 0, 36)); 
        labelLogin.setForeground(new Color(0, 0, 102));
        labelLogin.setText("Login");

        labelPasword.setFont(new Font("Times New Roman", 0, 24)); 
        labelPasword.setForeground(new Color(0, 0, 102));
        labelPasword.setText("Pasword:");

        labelEmail.setFont(new Font("Times New Roman", 0, 24)); 
        labelEmail.setForeground(new Color(0, 0, 102));
        labelEmail.setText("Mail:");

        loginButton.setBackground(new Color(0, 0, 102));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setFont(new Font("Times New Roman", 0, 24)); 
        loginButton.setText("Log in: ");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setBackground(new Color(0, 0, 102));
        registerButton.setForeground(new Color(255, 255, 255));
        registerButton.setFont(new Font("Times New Roman", 0, 24)); 
        registerButton.setText("sign in: ");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(email, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(labelEmail, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelPasword, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addGap(111, 111, 111)
                                    .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(loginButton)
                                        .addComponent(pasword, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registerButton))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(labelLogin, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(labelLogin, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEmail, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPasword, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(pasword, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(0, 128, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(loginButton)
                            .addComponent(registerButton))
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                      

    
    private void loginButtonActionPerformed(ActionEvent evt) {       
	
    	// Patr�n para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        // El email a validar
        String mail = email.getText();
 
        Matcher mather = pattern.matcher(mail);
 
        if (mather.find() == true) {
            System.out.println("El email ingresado es v�lido.");
        } else {
            System.out.println("El email ingresado es inv�lido.");
        }
        // Pasword    	
    	String pasw = pasword.getText(); 
    	
    }                                           

    private void registerButtonActionPerformed(ActionEvent evt) {                                               
    	// Patr�n para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        // El email a validar
        String mail = email.getText();
 
        Matcher mather = pattern.matcher(mail);
 
        if (mather.find() == true) {
            System.out.println("El email ingresado es v�lido.");
        } else {
            System.out.println("El email ingresado es inv�lido.");
        }
        // Pasword    	
    	String pasw = pasword.getText(); 
    }                                              

}
