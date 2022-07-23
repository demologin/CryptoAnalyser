package ru.javarush.cryptoanalyzer.letashko.swing;

import ru.javarush.cryptoanalyzer.letashko.commands.Anylaiz;
import ru.javarush.cryptoanalyzer.letashko.commands.BruteForce;
import ru.javarush.cryptoanalyzer.letashko.commands.Decoder;
import ru.javarush.cryptoanalyzer.letashko.commands.Encoder;

import javax.swing.*;


public class SwingInter extends JFrame{
    private JButton Anylise;
    private JButton Decod;
    private JButton Encod;
    private JButton BruteForse;
    private JPanel Inter;

    private void createUIComponents() {
        this.add(Inter);
        Encod.addActionListener( e -> {
                Encoder encoder = new Encoder();
        });

        Anylise.addActionListener(e -> {
            Anylaiz anylaiz = new Anylaiz();
        });

        BruteForse.addActionListener( e -> {
            BruteForce bruteForce = new BruteForce();

        });

        Decod.addActionListener( e -> {
            Decoder decoder = new Decoder();
        });

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
}}
