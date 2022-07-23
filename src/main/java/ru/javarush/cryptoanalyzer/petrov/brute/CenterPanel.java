package ru.javarush.cryptoanalyzer.petrov.brute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CenterPanel extends JPanel {

    public JTextArea jTextAreaIn;
    public JTextArea jTextAreaOut;

    public CenterPanel() {
        ActionListener actionListener = BruteFrame.actionListener;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.lightGray);
        JLabel inputFile = new JLabel("Исходный текст");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1.0f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        add(inputFile, gbc);

        JButton addFile = new JButton("Выбрать");
        addFile.setActionCommand("OPEN");
        addFile.addActionListener(actionListener);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.RELATIVE;
        add(addFile, gbc);

        JLabel pathInput = new JLabel("Обработанный файл сохраниться в той же директории с указанием ключа");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.8f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.WEST;
        gbc.anchor = GridBagConstraints.WEST;
        add(pathInput, gbc);

        JButton delInputPath = new JButton("  Очистить");
        delInputPath.addActionListener(actionListener);
        delInputPath.setActionCommand("CLEAR");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.EAST;
        gbc.anchor = GridBagConstraints.EAST;
        add(delInputPath, gbc);

        jTextAreaIn = new JTextArea();
        jTextAreaIn.setLineWrap(true);
        jTextAreaIn.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1.0f;
        gbc.weighty = 1.0f;
        gbc.fill = GridBagConstraints.BOTH;
        add(jTextAreaIn, gbc);
        JScrollPane jsp1 = new JScrollPane(jTextAreaIn);
        jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jsp1, gbc);

        JLabel outputFile = new JLabel("Обработанный текст");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1.0f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        add(outputFile, gbc);

        JButton addFileToSave = new JButton("Сохранить...");
        addFileToSave.setActionCommand("NEW_OUT_DIR");
        addFileToSave.addActionListener(actionListener);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.RELATIVE;
        add(addFileToSave, gbc);

        JLabel pathOutput = new JLabel("<= (сохранить файл в другой директории)");
        //WorkFrame.getInstance().pathOut = pathOutput;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.8f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.WEST;
        gbc.anchor = GridBagConstraints.WEST;
        add(pathOutput, gbc);

        JButton saveOutputText = new JButton("Сохранить");
        saveOutputText.setActionCommand("SAVE");
        saveOutputText.addActionListener(actionListener);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0f;
        gbc.weighty = 0.0f;
        gbc.fill = GridBagConstraints.EAST;
        gbc.anchor = GridBagConstraints.EAST;
        add(saveOutputText, gbc);

        jTextAreaOut = new JTextArea();
        jTextAreaOut.setLineWrap(true);
        jTextAreaOut.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1.0f;
        gbc.weighty = 1.0f;
        gbc.fill = GridBagConstraints.BOTH;
        add(jTextAreaOut, gbc);

        JScrollPane jsp2 = new JScrollPane(jTextAreaOut);
        jsp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jsp2, gbc);
    }
}

