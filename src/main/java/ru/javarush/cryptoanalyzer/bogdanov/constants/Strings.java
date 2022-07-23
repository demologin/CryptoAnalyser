package ru.javarush.cryptoanalyzer.bogdanov.constants;

import java.util.Locale;

public class Strings {
    public static final String rus ="абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final String eng ="abcdefghijklmnopqrstuvwxyz";
    private static final String num ="1234567890";
    private static final String symbol =".,?!";

    public static final String patternsStr="мо|без|бес|во|воз|вос|возо|вз|вс|вы|до|за|из|изо|на|наи|недо|над|надо|не|низ|нис|низо|об|обо|обез|обес|ото|па|пра|по|под|подо|пере|пре|пред|предо|при|про|раз|рас|разо|со|су|через|черес|чрез|ана|анти|архи|гипер|гипо|де|дез|дис|ин|интер|инфра|квази|кило|контр|макро|микро|мега|мата|мульти|орто|пан|пара|пост|прото|ре|суб|супер|транс|ультра|зкстра|сказ|экс";

    public static String allSymbols = rus+ rus.toUpperCase()+eng+ eng.toUpperCase()+num+symbol;

}
