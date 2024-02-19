package ru.voting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationWindow extends JFrame {
    private JTextField loginField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    public RegistrationWindow(LoginWindow parent) {
        setTitle("Registration");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Закрывать окно регистрации, не закрывая главное окно входа
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 5, 5));

        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JLabel roleLabel = new JLabel("Role:");
        String[] roles = {"Administrator", "CIK", "Candidate", "User"}; // Возможные роли
        roleComboBox = new JComboBox<>(roles);
        JButton registerButton = new JButton("Register");

        add(loginLabel);
        add(loginField);
        add(passwordLabel);
        add(passwordField);
        add(roleLabel);
        add(roleComboBox);
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newLogin = loginField.getText();
                String newPassword = new String(passwordField.getPassword());
                String selectedRole = (String) roleComboBox.getSelectedItem();

                if (newLogin.isEmpty() || newPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both login and password");
                    return;
                }

                parent.addUser(newLogin, newPassword, selectedRole); // Добавляем нового пользователя с указанной ролью
                JOptionPane.showMessageDialog(null, "Registration successful! Role: " + selectedRole);
                dispose(); // Закрываем окно регистрации
            }
        });

        setVisible(true);
    }
}