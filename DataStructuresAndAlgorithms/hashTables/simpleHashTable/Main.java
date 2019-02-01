package hashTables.simpleHashTable;

public class Main {
    public static void main(String[] args) {
        Employee joker = new Employee("Joker", "J", 25);
        Employee walterWhite = new Employee("Walter", "White", 56);
        Employee johnWick = new Employee("John", "Wick", 22);
        Employee johnShow = new Employee("John", "Snow", 1);
        Employee tonyStark = new Employee("Tony", "Stark", 23);
        Employee ragnorLothbrok = new Employee("Ragnor", "Lothbrok", 45);

        SimpleHashTable table = new SimpleHashTable();
        table.put("joker", joker);
        table.put("walter", walterWhite);
        table.put("john", johnWick);
        table.put("John", johnShow);
        table.put("tony", tonyStark);
        table.put("ragnor", ragnorLothbrok);

        table.printHashTable();

        System.out.println("Retrieve walter " + table.get("walter"));
        System.out.println("Retrieve tony " + table.get("tony"));
        System.out.println("Retrieve joker " + table.get("joker"));
        System.out.println("Retrieve wick " + table.get("john"));
        System.out.println("Retrieve snow " + table.get("John"));
        System.out.println("Retrieve ragnor " + table.get("ragnor"));

        System.out.println("Remove john snow : " + table.remove("John"));

        table.printHashTable();

    }
}