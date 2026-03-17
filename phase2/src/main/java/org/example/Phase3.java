package org.example;

public class Phase3 {

    public static String toPrefix(ASTNode node) {
        if(node instanceof NumNode) {
            return String.valueOf(((NumNode) node).getVal());
        }

        OpNode op = (OpNode) node;
        String left = toPrefix(op.getLeft());
        String right = toPrefix(op.getRight());
        return "(" + op.getOp() + " " + left + " " + right + ")";
    }


    public static int evalPrefix(String[] tokens, int[] idx) {
        String token = tokens[idx[0]];
        idx[0]++;

        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            int left = evalPrefix(tokens, idx);
            int right = evalPrefix(tokens, idx);

            if(token.charAt(0)=='+') return left + right;
            else if(token.charAt(0)=='-') return left - right;
            else if(token.charAt(0)=='*') return left * right;
            else { // "/"
                if(right == 0) {
                    System.err.println("You cannot divide by zero!!");
                    return 0;
                }
                return left / right;
            }
        }
        return Integer.parseInt(token);
    }
}