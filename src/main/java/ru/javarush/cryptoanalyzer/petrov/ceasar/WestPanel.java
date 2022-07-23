package ru.javarush.cryptoanalyzer.petrov.ceasar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WestPanel extends JPanel {
    JLabel jLabel;
    JTextField jTextField;
    public WestPanel(){
        //TODO Code style. Long code. Needs to be split into several methods
        ActionListener actionListener = CeasarFrame.actionListener;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        jLabel = new JLabel("Ключ: 0");
        jLabel.setFont(new Font("verdana", Font.ITALIC, 16));
        jLabel.setIgnoreRepaint(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1.0f;
        gbc.weighty = 0.0f;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(jLabel, gbc);

        JButton plus = new JButton("=>");
        plus.addActionListener(actionListener);
        plus.setActionCommand("SHIFT_PLUS");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1.0f;
        gbc.weighty = 0.0f;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,10,0,10);
        add(plus, gbc);



    JButton mines = new JButton("<=");
    mines.addActionListener(actionListener);
    mines.setActionCommand("SHIFT_MINES");
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridheight = 1;
    gbc.weightx = 1.0f;
    gbc.weighty = 0.0f;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    //mines.addActionListener(e -> MyActions.skip(-1));
    add(mines, gbc);

    JLabel n = new JLabel("N =");
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.weightx = 0.1f;
    gbc.weighty = 0.0f;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.fill = GridBagConstraints.CENTER;
    add(n, gbc);

    jTextField = new JTextField(3);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridheight = 1;
    gbc.weightx = 0.1f;
    gbc.weighty = 0.0f;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.CENTER;
    add(jTextField, gbc);

    JButton skip = new JButton("<= N =>");
    skip.setActionCommand("FORCE_SHIFT");
    skip.addActionListener(actionListener);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridheight = 1;
    gbc.weightx = 1.0f;
    gbc.weighty = 0.0f;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(skip, gbc);

    JLabel label = new JLabel("");
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridheight = 1;
    gbc.weightx = 1.0f;
    gbc.weighty = 1.0f;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.BOTH;
    add(label, gbc);
    }
}
