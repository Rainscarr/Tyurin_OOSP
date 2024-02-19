package ru.voting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalInfoEntryWindow extends JFrame {
    private JTextField fullNameField;
    private JTextField dobField;
    private JTextField snilsField;
    private JTextField passportField;
    private JTextField loginField;
    private JPasswordField passwordField;

    public PersonalInfoEntryWindow(String role) {
        setTitle("Personal Info Entry");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 5, 5));

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameField = new JTextField();
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobField = new JTextField();
        JLabel snilsLabel = new JLabel("SNILS:");
        snilsField = new JTextField();
        JLabel passportLabel = new JLabel("Passport (series + number):");
        passportField = new JTextField();
        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");

        add(fullNameLabel);
        add(fullNameField);
        add(dobLabel);
        add(dobField);
        add(snilsLabel);
        add(snilsField);
        add(passportLabel);
        add(passportField);
        add(loginLabel);
        add(loginField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameField.getText();
                String dob = dobField.getText();
                String snils = snilsField.getText();
                String passport = passportField.getText();
                String login = loginField.getText();
                String password = new String(passwordField.getPassword());

                if (fullName.isEmpty() || dob.isEmpty() || snils.isEmpty() || passport.isEmpty() || login.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                    return;
                }

                // Добавить регистрацию пользователя с указанной ролью
                LoginWindow.getInstance().addUser(login, password, role);

                JOptionPane.showMessageDialog(null, "Registration successful! Role: " + role);
                dispose(); // Закрыть окно ввода данных
            }
        });

        setVisible(true);
    }
}
