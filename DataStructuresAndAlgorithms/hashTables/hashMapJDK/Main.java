package hashTables.hashMapJDK;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Employee joker = new Employee("Joker", "J", 25);
        Employee walterWhite = new Employee("Walter", "White", 56);
        Employee johnWick = new Employee("John", "Wick", 22);
        Employee johnShow = new Employee("John", "Snow", 1);
        Employee tonyStark = new Employee("Tony", "Stark", 23);
        Employee ragnorLothbrok = new Employee("Ragnor", "Lothbrok", 45);

        Map<String, Employee> hashMap = new HashMap<>();
        hashMap.put("joker", joker);
        hashMap.put("walter", walterWhite);
        hashMap.put("john", johnWick);
        hashMap.put("John", johnShow);
        hashMap.put("tony", tonyStark);
        hashMap.put("ragnor", ragnorLothbrok);

//        for (Employee employee : hashMap.values())
//            System.out.println(employee);

        hashMap.put("tony", ragnorLothbrok);
        hashMap.putIfAbsent("tony", johnShow);

        System.out.println(hashMap.containsKey("ragnor"));
        System.out.println(hashMap.containsValue(tonyStark));
        hashMap.forEach((k, v) -> System.out.println("Key= " + k + " Value= " + v));

    }
}