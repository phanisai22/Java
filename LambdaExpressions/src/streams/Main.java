package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> bingoNumbers = Arrays.asList(
                "B22", "B34",
                "I20", "I33", "I10",
                "N44",
                "G22", "G23", "G45", "G00", "g56",
                "O10", "O13", "O36"
        );

//      Sorting all the bingoNumbers starting with "G"(Ignoring case).

//        List<String> gNumbers = new ArrayList<>();
//        bingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
////                System.out.println(number);
//            }
//        });
//
//        gNumbers.sort(String::compareTo); // (String s1, String s2) -> s1.compareTo(s2)
//        gNumbers.forEach(System.out::println); //(String s) -> System.out.println(s)

//        doing the commented part at once using streams.

//        bingoNumbers.stream() // it contains all the bingoNumbers.
//                .map(String::toUpperCase) // bingoNumbers uppercased.
//                .filter(s->s.startsWith("G")) // filter takes a predicate
////                stream contains all the bingoNumbers starting with "G"
//                .sorted() //stream is sorted.
//                .forEach(System.out::println); // stream is printed.

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I22", "O14");
        Stream<String> inNumberStream = Stream.of("N90", "I23","I26", "I17", "B45", "N10");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
//        System.out.println(concatStream.count());

//        System.out.println(concatStream.distinct().count());
        System.out.println("---------------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

    }
}
