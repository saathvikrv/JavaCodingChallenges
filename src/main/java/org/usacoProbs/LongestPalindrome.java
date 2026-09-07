package org.usacoProbs;

import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str= "Confucius say: Madam, I'm Ada<&•ºª¶••••ª§´£©˙˚>m.";
//                "/* Prob #3: The Errant Physicist */\n" +
//                "/*\n" +
//                "Wed Jan 19 13:17:15 EST 2000\n" +
//                "Wed Jan 19 13:42:20 EST 2000\n" +
//                "*/\n" +
//                "#include <stdio.h>\n" +
//                "#include <stdlib.h>\n" +
//                "#include <string.h>\n" +
//                "\n" +
//                "FILE *fout, *fin;\n" +
//                "\n" +
//                "typedef short term_set[100][3];\n" +
//                "\n" +
//                "int terms[201][201];\n" +
//                "\n" +
//                "term_set term1; /* coeff, xpow, ypow */\n" +
//                "term_set term2; /* coeff, xpow, ypow */\n" +
//                "\n" +
//                "char output[2][5000];\n" +
//                "int opos;\n" +
//                "\n" +
//                "int read_term(term_set *term)\n" +
//                " {\n" +
//                "  char str[100];\n" +
//                "  int state; /* 0 => coeff, 1 => xpow, 2 => ypow */\n" +
//                "  int sign, val;\n" +
//                "  int n, pos;\n" +
//                "  if (fscanf (fin, ...SNIP...   if (terms[lv][lv2] < 0)\n" +
//                "\t      add_char('-', 1);\n" +
//                "\t    state = 1;\n" +
//                "\t   }\n" +
//                "\t  if (abs(terms[lv][lv2]) != 1 || (lv == 0 && lv2 == 0))\n" +
//                "\t    add_int(abs(terms[lv][lv2]), 1);\n" +
//                "\t  if (lv != 0)\n" +
//                "\t   {\n" +
//                "\t    add_char('x', 1);\n" +
//                "\t    if (lv != 1)\n" +
//                "\t      add_int(lv, 0);\n" +
//                "\t   }\n" +
//                "\t  if (lv2 != 0)\n" +
//                "\t   {\n" +
//                "\t    add_char('y', 1);\n" +
//                "\t    if (lv2 != 1)\n" +
//                "\t      add_int(lv2, 0);\n" +
//                "\t   }\n" +
//                "\t }\n" +
//                "       }\n" +
//                "     }\n" +
//                "    finish_strings();\n" +
//                "    fprintf (fout, \"%s\\n\", output[0]);\n" +
//                "    fprintf (fout, \"%s\\n\", output[1]);\n" +
//                "    opos = 0;\n" +
//                "   }\n" +
//                " }";

//        while (s.hasNextLine()) {
//            str += s.nextLine() + "\n";
//        }


        StringBuilder modifiedText = new StringBuilder(str);
        for(int t = 0; t < modifiedText.length(); t++){
            if(!Character.isLetter(modifiedText.charAt(t))){
                modifiedText.deleteCharAt(t);
                t--;
            } else if(!Character.isLowerCase(modifiedText.charAt(t))){
                modifiedText.replace(t, t+1, String.valueOf(Character.toLowerCase(modifiedText.charAt(t))));
            }
        }
        int maxStart = 0;
        int maxEnd = 0;
        for(int i = 0; i < modifiedText.length(); i++){
            for(int j = i + 1; j < modifiedText.length(); j++){
                if(j - i > maxEnd - maxStart && isPalindrome(modifiedText.toString(), i, j)){
                    maxEnd = j;
                    maxStart = i;
                }
            }
        }
        int n = 0;
        for(int i = 0; i < maxStart; i++){
            n++;
            while(!Character.isLetter(str.charAt(n))){
                n++;
            }
        }
        int start = n;
        for(int i = maxStart; i < maxEnd; i++){
            n++;
            while(!Character.isLetter(str.charAt(n))){
                n++;
            }
        }
        int end = n;
        System.out.println(maxEnd - maxStart);
        System.out.println(str.substring(start, end));
        System.out.println(modifiedText.substring(maxStart, maxEnd));
        System.out.println(str.charAt(end));
    }

    public static boolean isPalindrome(String s, int start, int end){
        int j = end;
        for(int i = start; i < (end - start) / 2 + start; i++){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            j--;
        }
        return true;
    }
}

