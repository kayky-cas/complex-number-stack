import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        boolean isUser = false;
        try {
            File file = new File(args[0]);
            scanner = new Scanner(file);
        }  catch (FileNotFoundException | ArrayIndexOutOfBoundsException ignore) {
            scanner = new Scanner(System.in);
            isUser = true;
        }

        int maxSize = 0;
        int lastSize = 0;

        ComplexStack stack = new ComplexStack();

        String command = "";

        while (!command.equals("quit") && (isUser || scanner.hasNextLine())) {
            if (isUser) {
                System.out.print("[pop, dup, swap, inv, chs, conj, abs]: ");
            }

            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "inv" -> stack.inv();
                case "chs" -> stack.chs();
                case "conj" -> stack.conj();
                case "abs" -> stack.abs();
                case "pop" -> stack.pop();
                case "dup" -> stack.dup();
                case "swap" -> stack.swap();
                case "print" -> stack.print();
                case "+" -> stack.sum();
                case "-" -> stack.sub();
                case "*" -> stack.multi();
                case "/" -> stack.div();
                default -> {
                    String[] complexStrings = command.split(" ");
                    try {
                        double real = Double.parseDouble(complexStrings[0]);
                        double imaginary = complexStrings.length < 2 ? 0 : Double.parseDouble(complexStrings[1]);

                        stack.push(new ComplexNumber(real, imaginary));
                    } catch (NumberFormatException ignored) { }
                }
            }
            if (isUser) {
                stack.print();
            }
            lastSize = stack.size();
            if (lastSize > maxSize) {
                maxSize = lastSize;
            }
        }

        System.out.printf("Last value %s\nCurrent Size: %d\nMax size: %d", stack.pop() == null ? "The stack is empty" : stack.pop(), lastSize, maxSize);
    }
}
