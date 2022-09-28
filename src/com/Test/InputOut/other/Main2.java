package com.Test.InputOut.other;

import java.io.*;
import java.util.*;

public class Main2 {

    private static final HashSet<String> deleteWord = new HashSet<>();

    private static final HashMap<String, String> priorityWord = new HashMap<>();

    static {
        Collections.addAll(deleteWord, "в", "с", "у", "к", "на", "за", "до", "по", "от",
                "из", "под", "над", "про", "без", "для", "через", "вместе");

        priorityWord.put("бетон с присадкой", "цемент");
    }

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\dima\\IdeaProjects\\Java_SE\\src\\com\\Test\\input.txt";
        String outputFile = "C:\\Users\\dima\\IdeaProjects\\Java_SE\\src\\com\\Test\\output.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {

            List<String> allArray = bufferedReader.lines().toList();
            long i = Long.parseLong(allArray.get(0));

            List<String> firstArray = allArray.stream()
                    .skip(1L)
                    .limit(i)
                    .toList();

            List<String> secondArray = allArray.stream()
                    .skip(2L + i)
                    .toList();

            List<String> result = firstArray.stream()
                    .map(x -> comparison(x, secondArray))
                    .toList();

            for (String s : result) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String comparison(String lineFirstArray, List<? extends String> secondArray) {

        String lineFirstArrayLower = lineFirstArray
                .replaceAll("[()\\[\\]<>]", "")
                .replaceAll("\\s*(\\s)\\s*", " ")
                .toLowerCase();

        for (String lineSecondArray : secondArray) {

            String lineSecondArrayLower = lineSecondArray.toLowerCase();
            if (priorityWord.containsKey(lineFirstArrayLower) &&
            priorityWord.get(lineFirstArrayLower).equalsIgnoreCase(lineSecondArrayLower)) {
                return new String(new StringBuilder(lineFirstArray).append(" : ").append(lineSecondArray));
            }
            for (String wordFirst : lineFirstArrayLower.split("\\s*(\\s|,|!|\\.)\\s*")) {
                int j = 0;
                if (wordFirst.length() == 6) {
                    j = 1;
                } else if (wordFirst.length() == 7) {
                    j = 2;
                } else if (wordFirst.length() > 7) {
                    j = 3;
                }
                if (!deleteWord.contains(wordFirst) &&
                        lineSecondArrayLower.contains(wordFirst.substring(0, wordFirst.length() - j))) {
                    return new String(new StringBuilder(lineFirstArray).append(" : ").append(lineSecondArray));
                }
            }
        }
        return new String(new StringBuilder(lineFirstArray).append(" : ?"));
    }
}
