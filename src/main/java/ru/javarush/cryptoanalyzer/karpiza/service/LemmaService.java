package ru.javarush.cryptoanalyzer.karpiza.service;

import org.apache.lucene.morphology.LuceneMorphology;
import org.apache.lucene.morphology.russian.RussianLuceneMorphology;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class LemmaService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private static final String DELIMITER = " ";

    public Set<String> getLemmas(String text) throws IOException {
        Set<String> lemmas = new HashSet<>();
        LuceneMorphology luceneMorph = new RussianLuceneMorphology();

        String[] words = text.toLowerCase().split(DELIMITER);

        for (String word : words) {
            List<String> forms = new ArrayList<>();
            try {
                forms = luceneMorph.getNormalForms(word);
            } catch (Exception e) {
                logger.info(e.getMessage());
            }

            lemmas.addAll(forms);
        }

        return lemmas;
    }

}
