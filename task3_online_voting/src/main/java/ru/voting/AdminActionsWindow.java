package ru.voting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminActionsWindow extends JFrame {
    public AdminActionsWindow() {
        setTitle("Administrator Actions");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 5, 5));

        JButton viewUsersButton = new JButton("View Users");
        JButton deleteUsersButton = new JButton("Delete Users");
        JButton viewCIKButton = new JButton("View CIK");
        JButton deleteCIKButton = new JButton("Delete CIK");
        JButton createCIKButton = new JButton("Create CIK");
        JButton viewCandidatesButton = new JButton("View Candidates");
        JButton deleteCandidatesButton = new JButton("Delete Candidates");

        add(viewUsersButton);
        add(deleteUsersButton);
        add(viewCIKButton);
        add(deleteCIKButton);
        add(createCIKButton);
        add(viewCandidatesButton);
        add(deleteCandidatesButton);

        viewUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика просмотра пользователей
                JOptionPane.showMessageDialog(null, "View Users");
            }
        });

        deleteUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика удаления пользователей
                JOptionPane.showMessageDialog(null, "Delete Users");
            }
        });

        viewCIKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика просмотра ЦИК
                JOptionPane.showMessageDialog(null, "View CIK");
            }
        });

        deleteCIKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика удаления ЦИК
                JOptionPane.showMessageDialog(null, "Delete CIK");
            }
        });

        createCIKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика создания ЦИК
                JOptionPane.showMessageDialog(null, "Create CIK");
            }
        });

        viewCandidatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика просмотра кандидатов
                JOptionPane.showMessageDialog(null, "View Candidates");
            }
        });

        deleteCandidatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика удаления кандидатов
                JOptionPane.showMessageDialog(null, "Delete Candidates");
            }
        });

        setVisible(true);
    }
}
