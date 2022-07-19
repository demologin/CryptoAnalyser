package ru.javarush.cryptoanalyser.sternard.mode.swing;

import ru.javarush.cryptoanalyser.sternard.application.Application;
import ru.javarush.cryptoanalyser.sternard.application.EActions;

import javax.swing.*;

import static ru.javarush.cryptoanalyser.sternard.constant.Settings.INFORMATION_MESSAGE_ICON;
import static ru.javarush.cryptoanalyser.sternard.constant.language.English.PROJECT_NAME;

public class ButtonEventListener implements FormFields {
    protected void executeAction() {
        String action;
        String sourceFileName = inputSourceFileName.getText();
        String destinationFileName = inputDestinationFileName.getText();
        String[] args;

        if (radioEncrypt.isSelected() || radioDecrypt.isSelected()) {
            String key = inputKey.getText();
            action = (radioEncrypt.isSelected()) ? EActions.ENCRYPTION.name() : EActions.KEY_DECRYPTION.name();
            args = new String[]{action, sourceFileName, destinationFileName, key};
        } else {
            action = EActions.BRUTE_FORCE_DECRYPTION.name();
            args = new String[]{action, sourceFileName, destinationFileName};
        }

        JOptionPane.showMessageDialog(null, new Application().execute(args).getMessage(),
                PROJECT_NAME, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(INFORMATION_MESSAGE_ICON));
    }

}