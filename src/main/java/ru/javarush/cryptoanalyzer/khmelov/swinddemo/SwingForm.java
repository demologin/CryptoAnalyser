package ru.javarush.cryptoanalyzer.khmelov.swinddemo;

import javax.swing.*;

public class SwingForm extends JFrame {
    private JPanel mainPanel;
    private JPanel top;
    private JPanel left;
    private JPanel bottom;
    private JPanel right;
    private JPanel center;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField login;
    private JLabel label;
    private JPasswordField password;
    private JButton enter;

    public SwingForm() {
        initView();
        initListeners();
        this.setVisible(true);
    }

    private void initView() {
        this.setBounds(300, 300, 400, 200);
        this.add(mainPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initListeners() {
        enter.addActionListener(e -> {
            String passwordTxt = new String(password.getPassword());
            if (passwordTxt.equals("qwerty")) {
                label.setText(login.getText() + " is ok");
            } else {
                label.setText("incorrect password");
            }
        });
    }

}
