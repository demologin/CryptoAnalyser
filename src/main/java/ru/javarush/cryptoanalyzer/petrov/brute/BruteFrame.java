package ru.javarush.cryptoanalyzer.petrov.brute;

import javax.swing.*;
import java.awt.*;

public class BruteFrame extends JFrame {
    private CenterPanel centerPanel;
    private JPanel northPanel;
    private JPanel eastPanel;
    private SouthPanel southPanel;
    private JPanel westPanel;
    public static BruteListener actionListener = new BruteListener();
    private static BruteFrame instance;

    private BruteFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(600, 300));
        setResizable(true);
        setLayout(new BorderLayout());
        setTitle("Подбор ключа");
        centerPanel = new CenterPanel();
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        southPanel = new SouthPanel();
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static BruteFrame getInstance() {
        if (instance == null) instance = new BruteFrame();
        return instance;
    }

    public CenterPanel getCenterPanel() {
        return centerPanel;
    }

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public JPanel getEastPanel() {
        return eastPanel;
    }

    public SouthPanel getSouthPanel() {
        return southPanel;
    }

    public JPanel getWestPanel() {
        return westPanel;
    }
}


