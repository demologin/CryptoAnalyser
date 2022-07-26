package ru.javarush.cryptoanalyzer.sapun.ui;

import ru.javarush.cryptoanalyzer.sapun.Runner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingMenu {
    private static final String ENCODE = "Шифровка текста";
    private static final String DECODE = "Расшифровка текста с помощью ключа";
    private static final String BRUTEFORCE = "Расшифровка текста с помощью brute force";
    private static final String STATISTIC = "Расшифровка с помощью статистического анализа текста";

    public static void main(String[] args) {
        String[] optionsToChoose = {ENCODE, DECODE, BRUTEFORCE, STATISTIC};

        JFrame jFrame = new JFrame();

        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(30, 50, 370, 20);

        JButton jButton = new JButton("Выбор");
        jButton.setBounds(30, 100, 90, 20);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(30, 100, 400, 100);

        jFrame.add(jButton);
        jFrame.add(jComboBox);
        jFrame.add(jLabel);

        jFrame.setLayout(null);
        jFrame.setSize(450, 350);
        jFrame.setVisible(true);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] args = new String[4];
                String item = jComboBox.getItemAt(jComboBox.getSelectedIndex());
                switch (item) {
                    case ENCODE -> {
                        args[0] = "ENCODE";
                        args[1] = "text.txt";
                        args[2] = "out.txt";
                    }
                    case DECODE -> {
                        args[0] = "DECODE";
                        args[1] = "out.txt";
                        args[2] = "decoded.txt";
                    }
                    case BRUTEFORCE -> {
                        args[0] = "BRUTEFORCE";
                        args[1] = "out.txt";
                    }
                    case STATISTIC -> {
                        args[0] = "STATISTIC";
                        args[1] = "encoded.txt";
                        args[2] = "sample.txt";
                        args[3] = "out.txt";
                    }
                }
                Runner.start(args);
            }
        });
    }
}