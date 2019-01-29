package stacks;

import java.util.LinkedList;

public class Palindrome {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat i saw?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
    }

    private static boolean checkForPalindrome(String string) {

        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder stringNoPuntuation = new StringBuilder(string.length());
        string = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringNoPuntuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reservedString = new StringBuilder(stack.size());
        while(!stack.isEmpty())
            reservedString.append(stack.pop());

        return stringNoPuntuation.toString().equals(reservedString.toString());
    }
}
