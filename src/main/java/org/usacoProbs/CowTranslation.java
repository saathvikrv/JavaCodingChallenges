package org.usacoProbs;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CowTranslation {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int amtOfPrefixes = Integer.parseInt(st.nextToken());
        int amtOfLines = Integer.parseInt(st.nextToken());
        String[] prefixes = new String[amtOfPrefixes];
        for(int i = 0; i < amtOfPrefixes; i++){
            prefixes[i] = r.readLine();
        }
        Set<String> prefixPrefixes = new HashSet<>();

        String s;
        for(int j = 0; j < amtOfPrefixes; j++){
            s = prefixes[j];
            prefixPrefixes.add("");
            StringBuilder prev = new StringBuilder();
            for(int i = 1; i <= s.length(); i++){
                prefixPrefixes.add(prev.toString() + s.charAt(i-1));
                prev.append(s.charAt(i - 1));
            }
        }
        int count = 0;
        for(int i = 0; i < amtOfLines; i++){
            if(prefixPrefixes.contains(r.readLine())){
                count++;
            }

        }

        System.out.println(count);
    }
}
