package com.example.design_patterns.creational.abstract_factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class abstract_factory {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                              .map(Integer::parseInt)
                              .collect(toList())
                           );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = arrayManipulation(n, queries);



        bufferedReader.close();
    }

    public static long arrayManipulation2(int n, List<List<Integer>> queries) {
        // Write your code here
        long[] array = new long[n];

        for (List<Integer> query : queries) {
            int a = query.get(0) - 1;
            int b = query.get(1) - 1;
            int k = query.get(2);

            for (int i = a; i <= b; i++) {
                array[i] += k;
            }
        }

        long max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long max = 0;

        while (queries.size() > 1) {
            long maxInterval = 0;
            for (int i = 0; i < queries.size() - 1 && queries.size() > 1; i++) {
                int a1 = queries.get(i).get(0);
                int b1 = queries.get(i).get(1);
                int k1 = queries.get(i).get(2);
                int a2 = queries.get(i+1).get(0);
                int b2 = queries.get(i+1).get(1);
                int k2 = queries.get(i+1).get(2);

                if (b1 >= a2 || b2 >= a1) {
                    maxInterval += k1 + k2;
                    queries.remove(i+1);
                    queries.remove(i);
                    i--;
                }
            }
            if (max < maxInterval) {
                max = maxInterval;
            }
        }

        int k = queries.get(0).get(2);
        if (max < k) {
            max = k;
        }
        return max;
    }
}
