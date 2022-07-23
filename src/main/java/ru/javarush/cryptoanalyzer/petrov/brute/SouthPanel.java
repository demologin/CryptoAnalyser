package ru.javarush.cryptoanalyzer.petrov.brute;

import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
    public JTextField jTextField;
    public JLabel key;

    public SouthPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel jLabel = new JLabel("Слово, которое ищем: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.33f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.WEST;
        gbc.anchor = GridBagConstraints.EAST;
        add(jLabel, gbc);

        jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(100, 40));
        jTextField.setFont(new Font("italic", 3, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.66f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.WEST;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(jTextField, gbc);

        JButton findBtn = new JButton("Искать совпадения");
        findBtn.addActionListener(BruteFrame.actionListener);
        findBtn.setActionCommand("FIND");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.33f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(findBtn, gbc);

        key = new JLabel("Ключ:");
        key.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.33f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(key, gbc);
    }
}
