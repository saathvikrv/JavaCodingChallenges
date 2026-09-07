package org.usacoProbs;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Usaco2020WordProcessor {
    public static void main(String[] args) throws IOException {
        String in = "word.in";
        String out = "word.out";

        BufferedReader r = new BufferedReader(new FileReader(in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));

        StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken());
        int lineLength = Integer.parseInt(st.nextToken());


        String essay = r.readLine();//"if it passes all of the cases during the contest If you achieve a particularly high score often required to be a perfect score during a contest you may qualify for an in contest promotion otherwise promotions will be granted after a contest ends to all participants with scores above the promotion threshold for that contest If you receive an in contest promotion you will be able to start working on the next contest any time within the larger contest window and with a full timer that is time you spent on the earlier contest does not count against the";

        String[] words = essay.split(" ");

        r.close();

        List<String> ans = wordProcessor(words, lineLength);

        for(int i =0; i < ans.size(); i++) {
            pw.println(ans.get(i));
        }
        pw.close();
    }

    public static List<String> wordProcessor(String[] words, int maxLength) {
        List<String> wordGroups = new ArrayList<>();
        String wordMush = "";
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (wordMush.length() + words[i].length() <= maxLength) {
                wordMush += words[i];
            } else {
                wordGroups.add(listToWords(Arrays.copyOfRange(words, j, i)));
                j = i;
                wordMush = words[i];
            }
        }
        wordGroups.add(listToWords(Arrays.copyOfRange(words, j, words.length)));
        return wordGroups;
    }


    public static String listToWords(String[] wordsToCombine) {
        String wordMush = "";

        for (int i = 0; i < wordsToCombine.length; i++) {
            wordMush = wordMush + wordsToCombine[i] + " ";
        }

        return wordMush.substring(0, wordMush.length()-1);
    }


}