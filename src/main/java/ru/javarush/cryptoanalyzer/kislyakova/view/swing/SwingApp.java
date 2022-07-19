package ru.javarush.cryptoanalyzer.kislyakova.view.swing;

import javax.swing.*;

public class SwingApp extends JFrame {
    private JPanel panel;
    private JLabel label;
    private JTextField login;
    private JPasswordField password;
    private JButton button1;


    public SwingApp() {
        //TODO свинг доделать
        panel = new JPanel();
        add(panel);
        //поставить размеры окна
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        label = new JLabel("this label");
        //скок символов поле займет в скобках указываем
        login = new JTextField(10);
        password = new JPasswordField(10);

        panel.add(label);
        panel.add(login);
        panel.add(password);


        button1 = new JButton("кнопка 1");
//        JButton button2 = new JButton("кнопка 2");
//        JButton button3 = new JButton("кнопка 3");
//        JButton button4 = new JButton("кнопка 4");

        panel.add(button1);

        //сделать реакцию по кнопке - это приклеить слушателя
        button1.addActionListener(e -> {
            //здесь можно чет извлечь из события
            String passTxt = new String(password.getPassword());
            if(passTxt.equals("qwerty")){
                label.setText(login.getText()+"is ok");
            } else {
                label.setText(login.getText()+"incorrect pass");
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //чтобы программа завершала работу после закрытия фрейма
        setVisible(true); //без этого окошко не отобразится
    }
}
