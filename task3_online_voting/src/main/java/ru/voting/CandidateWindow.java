package ru.voting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CandidateWindow extends JFrame {

    public CandidateWindow() {
        setTitle("Candidate Actions");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 5, 5));

        JButton fillDataButton = new JButton("Fill Candidate Data");
        JButton viewResultsButton = new JButton("View Previous Results");
        JButton viewVotingsButton = new JButton("View Participated Votings");

        add(fillDataButton);
        add(viewResultsButton);
        add(viewVotingsButton);

        fillDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика заполнения данных кандидата
                JOptionPane.showMessageDialog(null, "Fill Candidate Data");
            }
        });

        viewResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика просмотра результатов предыдущих голосований
                JOptionPane.showMessageDialog(null, "View Previous Results");
            }
        });

        viewVotingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика просмотра списка голосований, в которых принимал участие кандидат
                JOptionPane.showMessageDialog(null, "View Participated Votings");
            }
        });

        setVisible(true);
    }
}
