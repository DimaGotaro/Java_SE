package com.Test;

import java.io.*;
import java.util.*;

public class Main {

    private static final HashSet<String> deleteWord = new HashSet<>();

    private static final HashMap<String, String> priorityWord = new HashMap<>();

    static {
        Collections.addAll(deleteWord, "в", "с", "у", "к", "на", "за", "до", "по", "от",
                "из", "под", "над", "про", "без", "для", "через");

        priorityWord.put("бетон с присадкой", "цемент");
    }

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\dima\\IdeaProjects\\Java_SE\\src\\com\\Test\\input.txt";
        String outputFile = "C:\\Users\\dima\\IdeaProjects\\Java_SE\\src\\com\\Test\\output.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {

            String[] allArray = bufferedReader.lines().toArray(String[]::new);
            long i = Long.parseLong(allArray[0]);

            String[] firstArray = Arrays.stream(allArray)
                    .skip(1L)
                    .limit(i)
                    .toArray(String[]::new);

            String[] secondArray = Arrays.stream(allArray)
                    .skip(2L + i)
                    .toArray(String[]::new);

            String[] result = Arrays.stream(firstArray)
                    .map(x -> comparison(x, secondArray))
                    .toArray(String[]::new);

            for (String s : result) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String comparison(String lineFirstArray, String[] secondArray) {

        String lineFirstArrayLower = lineFirstArray.toLowerCase();

        for (String lineSecondArray : secondArray) {

            String lineSecondArrayLower = lineSecondArray.toLowerCase();
            if (priorityWord.containsKey(lineFirstArrayLower) &&
            priorityWord.get(lineFirstArrayLower).equalsIgnoreCase(lineSecondArrayLower)) {
                return new String(new StringBuilder(lineFirstArray).append(" : ").append(lineSecondArray));
            }

            for (String wordFirst : lineFirstArrayLower.split(" ")) {
                if (!deleteWord.contains(wordFirst) &&
                        lineSecondArrayLower.contains(wordFirst.substring(0, wordFirst.length() - 1))) {
                    return new String(new StringBuilder(lineFirstArray).append(" : ").append(lineSecondArray));
                }
            }
        }
        return new String(new StringBuilder(lineFirstArray).append(" : ?"));
    }
}
