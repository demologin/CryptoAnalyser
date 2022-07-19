package ru.javarush.cryptoanalyser.sternard.mode.swing;

import javax.swing.*;

import static ru.javarush.cryptoanalyser.sternard.constant.Settings.ENCRYPTED_FILENAME;
import static ru.javarush.cryptoanalyser.sternard.constant.Settings.SOURCE_FILENAME;
import static ru.javarush.cryptoanalyser.sternard.constant.language.English.*;

public interface FormFields {
    JTextField inputSourceFileName = new JTextField(SOURCE_FILENAME, 25);
    JTextField inputDestinationFileName = new JTextField(ENCRYPTED_FILENAME, 25);
    JTextField inputKey = new JTextField("10", 5);
    JLabel labelKey = new JLabel(ENTER_KEY);
    JRadioButton radioEncrypt = new JRadioButton(ENCRYPT_WITH_KEY);
    JRadioButton radioDecrypt = new JRadioButton(DECRYPT_WITH_KEY);
    JRadioButton radioBruteForceDec = new JRadioButton(BRUTE_FORCE_DECRYPTION);
    JLabel labelSourceFileName = new JLabel(SOURCE_FILE_NAME);
    JLabel labelDestinationFileName = new JLabel(DESTINATION_FILE_NAME);
    JButton button = new JButton(BUTTON_NAME);
}
