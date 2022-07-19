package ru.javarush.cryptoanalyser.sternard.mode.swing;

import javax.swing.*;
import java.awt.*;

import static ru.javarush.cryptoanalyser.sternard.constant.language.English.PROJECT_NAME;

public class RunnerGUI extends JFrame implements FormFields {
    public void runGUI() {
        Container container = setParamsForm();
        addToButtonGroup();
        addToForm(container);
        addAction();
        pack();
        setVisible(true);
    }

    private Container setParamsForm() {
        setTitle(PROJECT_NAME);
        setBounds(600, 200, 200, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Container container = getContentPane();
        container.setLayout(new GridLayout(11, 1, 3, 3));
        return container;
    }

    private void addToButtonGroup() {
        ButtonGroup group = new ButtonGroup();
        group.add(radioEncrypt);
        group.add(radioDecrypt);
        group.add(radioBruteForceDec);
        radioEncrypt.setSelected(true);
    }

    private void addAction() {
        RadioEventListener radioEventListener = new RadioEventListener();
        ButtonEventListener buttonEventListener = new ButtonEventListener();

        radioEncrypt.addActionListener(e -> radioEventListener.chooseAction());
        radioDecrypt.addActionListener(e -> radioEventListener.chooseAction());
        radioBruteForceDec.addActionListener(e -> radioEventListener.chooseAction());
        button.addActionListener(e -> buttonEventListener.executeAction());
    }

    private void addToForm(Container container) {
        container.add(labelSourceFileName);
        container.add(inputSourceFileName);
        container.add(labelDestinationFileName);
        container.add(inputDestinationFileName);
        container.add(labelKey);
        container.add(inputKey);
        container.add(radioEncrypt);
        container.add(radioDecrypt);
        container.add(radioBruteForceDec);
        container.add(button);
    }

}