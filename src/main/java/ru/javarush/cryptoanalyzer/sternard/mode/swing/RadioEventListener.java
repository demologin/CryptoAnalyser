package ru.javarush.cryptoanalyzer.sternard.mode.swing;

import static ru.javarush.cryptoanalyzer.sternard.constant.Settings.*;

public class RadioEventListener implements FormFields {
    protected void chooseAction() {

        if (radioEncrypt.isSelected()) {
            inputSourceFileName.setText(SOURCE_FILENAME);
            inputDestinationFileName.setText(ENCRYPTED_FILENAME);
            inputKey.setVisible(true);
            labelKey.setVisible(true);
        } else if (radioDecrypt.isSelected()) {
            inputSourceFileName.setText(ENCRYPTED_FILENAME);
            inputDestinationFileName.setText(DECRYPTED_FILENAME);
            inputKey.setVisible(true);
            labelKey.setVisible(true);
        } else {
            inputSourceFileName.setText(ENCRYPTED_FILENAME);
            inputDestinationFileName.setText(DECRYPTED_FILENAME);
            inputKey.setVisible(false);
            labelKey.setVisible(false);
        }
    }
}
