package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your expression:");

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if(line.isEmpty()) continue;

            InputParser parser = new InputParser(line);
            ASTNode tree = parser.parseExpression();
            tree.print("");
            String prefix = Phase3.toPrefix(tree);
            System.out.println("Prefix Notation: " + prefix);

            String[] prefixTokens = prefix
                    .replace("(", "")
                    .replace(")", "")
                    .trim()
                    .split("\\s+");

            int[] idx = {0};
            int result = Phase3.evalPrefix(prefixTokens, idx);
            System.out.println("Result: " + result);
        }
    }
}