package stacks;

public class Main {
    public static void main(String[] args) {
        Employee joker = new Employee("Joker", "J", 25);
        Employee walterWhite = new Employee("Walter", "White", 56);
        Employee johnWick = new Employee("John", "Wick", 22);
        Employee johnShow = new Employee("John", "Snow", 1);
        Employee tonyStark = new Employee("Tony", "Stark", 23);
        Employee ragnorLothbrok = new Employee("Ragnor", "Lothbrok", 45);

//        ArrayStack stack = new ArrayStack(10);
        LinkedStack stack = new LinkedStack();
        stack.push(joker);
        stack.push(walterWhite);
        stack.push(johnShow);
        stack.push(johnWick);
        stack.push(tonyStark);
        stack.push(ragnorLothbrok);

        System.out.println("Popped : " + stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());

        stack.printStack();
    }
}
