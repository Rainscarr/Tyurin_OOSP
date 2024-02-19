package ru.voting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CIKActionsWindow extends JFrame {
    public CIKActionsWindow() {
        setTitle("CIK Actions");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 5, 5));

        JButton createVotingButton = new JButton("Create Voting");
        JButton addCandidatesButton = new JButton("Add Candidates");
        JButton printResultsButton = new JButton("Print Results (PDF)");
        JButton selectGroupingButton = new JButton("Select Grouping");
        JButton sortResultsButton = new JButton("Sort Results");

        add(createVotingButton);
        add(addCandidatesButton);
        add(printResultsButton);
        add(selectGroupingButton);
        add(sortResultsButton);

        createVotingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика создания голосования
                JOptionPane.showMessageDialog(null, "Create Voting");
            }
        });

        addCandidatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика добавления кандидатов
                JOptionPane.showMessageDialog(null, "Add Candidates");
            }
        });

        printResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика печати результатов в PDF
                JOptionPane.showMessageDialog(null, "Print Results (PDF)");
            }
        });

        selectGroupingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика выбора группировки результатов
                JOptionPane.showMessageDialog(null, "Select Grouping");
            }
        });

        sortResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика сортировки результатов
                JOptionPane.showMessageDialog(null, "Sort Results");
            }
        });

        setVisible(true);
    }
}
