package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                String string = "Let's split this into an array";
//                String[] array = string.split(" ");
//                for (String s : array) {
//                    System.out.println(s);
//                }
//            }
//        };

        Runnable runnable = () -> {
            String string = "Let's split this into an array";
            String[] array = string.split(" ");
            for (String s : array) {
                System.out.println(s);
            }
        };

//        everySecondChar() method using lambdaFuntions.

        Function<String, String> lambdaFuntion = string -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                if (i % 2 == 1) {
                    sb.append(string.charAt(i));
                }
            }
            return sb.toString();
        };

        System.out.println(lambdaFuntion.apply("1234567890"));

        List<String> topNames2019 = Arrays.asList(
                "Olivia",
                "Amelia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "charlie",
                "harry",
                "Jacob"
        );

        List<String> firstLetterUpperCaseList = new ArrayList<>();

//        topNames2019.forEach(name ->
//                firstLetterUpperCaseList.add(name.substring(0, 1).toUpperCase()
//                        + name.substring(1)));
//        firstLetterUpperCaseList.sort(String::compareTo); // s1.compareTo(s2);
//        firstLetterUpperCaseList.forEach(System.out::println);

        topNames2019
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

    private static String everySecondCharacter(Function<String, String> fn, String source) {
        return fn.apply(source);
    }


//    Takes string as parameter and returns
//    concatinated string of even positioned letters of string.

//    private static String everySecondChar(String string) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < string.length(); i++) {
//            if (i % 2 == 1) {
//                sb.append(string.charAt(i));
//            }
//        }
//        return sb.toString();
//    }
}
