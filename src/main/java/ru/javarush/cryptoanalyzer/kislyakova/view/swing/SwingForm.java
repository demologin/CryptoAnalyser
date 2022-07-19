package ru.javarush.cryptoanalyzer.kislyakova.view.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingForm extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel cipher;
    private JPanel decipher;
    private JTabbedPane bruteforce;
    private JTextField hintForPathField;
    private JTextField inputPathField;
    private JTextField hintForKey;
    private JTextField inputKey;
    private JButton executeButton;
    private JTextPane fieldForResult;

//    //в каком виде сюда тогда из свингаппа перенесется
//    public SwingApp() {
        //setSize(600, 400);
        //this.add(panel);
//        //сделать реакцию по кнопке - это приклеить слушателя

    //вынес в отдельный метод
//        button1.addActionListener(e -> {
//            //здесь можно чет извлечь из события
//            String passTxt = new String(password.getPassword());
//            if(passTxt.equals("qwerty")){
//                label.setText(login.getText()+"is ok");
//            } else {
//                label.setText(login.getText()+"incorrect pass");
//            }
//        });
//
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //чтобы программа завершала работу после закрытия фрейма
//        setVisible(true); //без этого окошко не отобразится
//    }

    public SwingForm() {
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
