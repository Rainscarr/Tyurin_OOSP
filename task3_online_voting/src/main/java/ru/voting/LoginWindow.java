package ru.voting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LoginWindow extends JFrame {
    private Map<String, String> users = new HashMap<>(); // Хранение пользователей (логин - пароль)
    private Map<String, String> roles = new HashMap<>(); // Хранение ролей пользователей (логин - роль)

    private JTextField loginField;
    private JPasswordField passwordField;

    public LoginWindow() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // Центрирование окна
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        panel.add(loginLabel);
        panel.add(loginField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel, BorderLayout.CENTER);

        // Предварительное заполнение пользователей (заглушка)
        users.put("admin", "admin");
        roles.put("admin", "Administrator");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String password = new String(passwordField.getPassword());

                if (login.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both login and password");
                    return;
                }

                if (users.containsKey(login)) {
                    if (users.get(login).equals(password)) {
                        String role = roles.get(login); // Определить роль пользователя

                        if (role != null) {
                            openWindowForRole(role); // Открыть соответствующее окно в зависимости от роли
                        } else {
                            JOptionPane.showMessageDialog(null, "Role not found");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid password");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User not found. Would you like to register?");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationWindow(LoginWindow.this); // Передаем текущее окно для обновления данных о пользователе
            }
        });

        setVisible(true);

    }

    public void addUser(String login, String password, String role) {
        users.put(login, password);
        roles.put(login, role);
    }

    private void openWindowForRole(String role) {
        switch (role) {
            case "Administrator":
                new AdminActionsWindow();
                break;
            case "CIK":
                new CIKActionsWindow(); // Открыть окно для кандидата
                break;

            case "Candidate":
                new CandidateWindow(); // Открыть окно для кандидата
                break;
            case "User":
                new UserWindow(); // Открыть окно для кандидата
                break;
            default:
                JOptionPane.showMessageDialog(null, "Role not found");
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow();
            }
        });
    }
}
