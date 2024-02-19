package ru.voting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserWindow extends JFrame {
    public UserWindow() {
        setTitle("User Actions");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 5, 5));

        JButton registerButton = new JButton("Register");
        JButton voteButton = new JButton("Vote");
        JButton viewCandidatesButton = new JButton("View Candidates");
        JButton viewVotingsButton = new JButton("View Votings");

        add(registerButton);
        add(voteButton);
        add(viewCandidatesButton);
        add(viewVotingsButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика регистрации
                JOptionPane.showMessageDialog(null, "Registering...");
            }
        });

        voteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика голосования
                JOptionPane.showMessageDialog(null, "Voting...");
            }
        });

        viewCandidatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика просмотра кандидатов
                JOptionPane.showMessageDialog(null, "Viewing Candidates...");
            }
        });

        viewVotingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика просмотра голосований
                JOptionPane.showMessageDialog(null, "Viewing Votings...");
            }
        });

        setVisible(true);
    }
}
