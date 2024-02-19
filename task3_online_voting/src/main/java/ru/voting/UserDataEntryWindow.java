package ru.voting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDataEntryWindow extends JFrame {
    private JTextField loginField;
    private JPasswordField passwordField;

    public UserDataEntryWindow(String role) {
        setTitle("User Data Entry");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");

        add(loginLabel);
        add(loginField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String password = new String(passwordField.getPassword());

                if (login.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both login and password");
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
