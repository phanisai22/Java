package Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Employee walt = new Employee("walter white", 63);
        Employee john = new Employee("john wick", 40);
        Employee tony = new Employee("tony stark", 51);
        Employee saul = new Employee("james mcgill", 35);
        Employee show = new Employee("john snow", 22);
        Employee hank = new Employee("hank schrader", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(walt);
        employees.add(john);
        employees.add(tony);
        employees.add(saul);
        employees.add(show);
        employees.add(hank);

//        employees.forEach(employee -> {
//            System.out.println("Name : " +employee.getName());
//            System.out.println("Age : " +employee.getAge());
//        });

//        printEmployeesByAge(employees, "Employee over 40", employee -> employee.getAge() > 40);
//        printEmployeesByAge(employees, "Employee below 40", employee -> employee.getAge() < 40);

        Function<Employee, String> getLastName = (employee) ->
                employee.getName().substring(employee.getName().indexOf(' ') + 1);

//        System.out.println(getLastName.apply(employees.get(0)));

        Function<Employee, String> getFirstName = (employee) ->
                employee.getName().substring(0, employee.getName().indexOf(' '));

        Random random = new Random() ;
        employees.forEach(employee -> {
            if (random.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        });
    }


//    Prints first name or last name
//    according to the Function passed in.

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }


//    Prints employee's details by their predicate condition.

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println("\n" + ageText);
        System.out.println("--------------------------------------------");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName() + " : " + employee.getAge());
            }
        }
    }

}
