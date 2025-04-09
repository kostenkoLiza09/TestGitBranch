package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        readFile("Students.csv");
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        List<Integer> step1 = list.stream()
                .filter(n -> n %2 ==0)
                .toList();
        System.out.println("Step1" + step1);

        List<Integer> step2 = list.stream()
                .map(n -> n * 2)
                .toList();
        System.out.println("Step2" + step2);

        List<Integer> step3 = list.stream()
                .sorted()
                .toList();
        System.out.println("Step3" + step3);

        Integer step4 = list.stream()
                .reduce(0, Integer::sum);

        System.out.println("Step4: " + step4);

        list.forEach(System.out::println);
        System.out.println( "Step5:" + list);

        List<Integer> step6 = list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .sorted()
                .collect(Collectors.toList());
        System.out.println( "Step6:" + step6);

        Integer step7 = list.stream()
                .max(Integer::compareTo)
                .orElse(null);
        System.out.println("Step7: " + step7);
    }

    public static void readFile (String fileName) throws IOException {
        Path path = Path.of(fileName);
        try (Stream<String> lines = Files.lines(path)) {
            lines.skip(1)
                    .filter(x -> !x.isBlank())
                    .distinct()
                    .forEach(System.out::println);

        }
    }
}