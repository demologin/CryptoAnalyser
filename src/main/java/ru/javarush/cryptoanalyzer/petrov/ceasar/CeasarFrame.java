package ru.javarush.cryptoanalyzer.petrov.ceasar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CeasarFrame extends JFrame {
    //TODO Code style. Many warnings. Skip or fix it.
    private CenterPanel centerPanel;

    private WestPanel westPanel;
    public static ActionListener actionListener = new CeasarListener();
    private static CeasarFrame instance;

    private CeasarFrame() {
        setTitle("Шифровка и расшифровка методом цезаря");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(600, 300));
        setResizable(true);
        setLayout(new BorderLayout());
        centerPanel = new CenterPanel();
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        westPanel = new WestPanel();
        getContentPane().add(westPanel, BorderLayout.WEST);
        setVisible(true);
    }

    public static CeasarFrame getInstance() {
        if (instance == null) instance = new CeasarFrame();
        return instance;
        // TODO в каком-то методе этот вызов сделать или импорт статический

    }

    public CenterPanel getCenterPanel() {
        return centerPanel;
    }

    public WestPanel getWestPanel() {
        return westPanel;
    }

}
