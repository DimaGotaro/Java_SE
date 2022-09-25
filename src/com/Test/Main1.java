package com.Test;

import java.io.*;
import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\dima\\IdeaProjects\\Java_SE\\src\\com\\Test\\input.txt";
        String outputFile = "C:\\Users\\dima\\IdeaProjects\\Java_SE\\src\\com\\Test\\output.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {

            List<String> allArray = bufferedReader.lines().toList();
            long i = Long.parseLong(allArray.get(0));

            List<String> firstArray = new ArrayList<>(allArray.stream()
                    .skip(1L)
                    .limit(i)
                    .toList());

            List<String> secondArray = allArray.stream()
                    .skip(2L + i)
                    .toList();

            for (String s : comparison(firstArray, secondArray)) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> comparison(List<String> firstArray, List<? extends String> secondArray) {

        List<Map<String, Integer>> listMap = new ArrayList<>(firstArray.size());

        for (String lineFirstArray : firstArray) {
            String lineFirstArrayLower = replaceInLineAndLower(lineFirstArray);
            HashMap<String, Integer> countMap = new HashMap<>();

            for (String lineSecondArray : secondArray) {
                String lineSecondArrayLower = replaceInLineAndLower(lineSecondArray);
                int count = 0;

                for (char cF : lineFirstArrayLower.toCharArray()) {

                    if (lineSecondArrayLower.contains(String.valueOf(cF))) {
                        count++;
                        lineSecondArrayLower =
                                lineSecondArrayLower.replaceFirst(String.valueOf(cF), "");
                    }
                }
                countMap.put(lineSecondArray, count);
            }
            listMap.add(countMap);
        }
        List<List<Integer>> listSecond = new ArrayList<>();
        for (String lineSecondArray : secondArray) {
            List<Integer> listFirst = new ArrayList<>();
            for (Map<String, Integer> countMap : listMap) {
                Integer count = countMap.get(lineSecondArray);
                listFirst.add(count);
            }
            listSecond.add(listFirst);
        }

        for (int i = 0; i < firstArray.size(); i++) {
            String lineFirstArray = firstArray.get(i);
            if (lineFirstArray.contains(":")) {
                firstArray.set(i, lineFirstArray.replaceAll(":", ""));
            }
        }

        int indexSecond = 0;
        for (List<Integer> listFirst : listSecond) {
            Integer countMaxFirst = listFirst.stream().max(Integer::compareTo).orElse(null);
            int indexFirst = listFirst.indexOf(countMaxFirst);
            String resultGood = new String(new StringBuilder(
                    firstArray.get(indexFirst)).append(" : ").append(secondArray.get(indexSecond)));
            firstArray.set(indexFirst, resultGood);
            indexSecond++;
        }

        for (int i = 0; i < firstArray.size(); i++) {
            String lineFirstArray = firstArray.get(i);
            if (!lineFirstArray.contains(":")) {
                firstArray.set(i, lineFirstArray + " : ?");
            }
        }

        return firstArray;
    }

    public static String replaceInLineAndLower(String line) {
        return line
                .replaceAll("[()\\[\\]<>]", " ")
                .replaceAll("[,!.?]", " ")
                .replaceAll("\\s*(\\s)\\s*", "")
                .toLowerCase();
    }
}
