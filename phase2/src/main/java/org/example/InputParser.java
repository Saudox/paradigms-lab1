package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputParser {
    private List<String> tokens;
    private int idx=0;

    public InputParser(String input) {
        this.tokens = tokenize(input);
        this.idx=0;
    }

    private List<String> tokenize(String input) {
        List<String> lst = new ArrayList<>();
        Collections.addAll(lst, input.trim().split("\\s+"));
        return lst;
    }


    private String getIdxVal() {
        if(idx<tokens.size()) return tokens.get(idx);
        else return null;
    }

    //BNF EXPRESSION
    public ASTNode parseExpression() {
        ASTNode left = parseTerm();

        while(getIdxVal()!=null && (getIdxVal().equals("+") || getIdxVal().equals("-"))) {
            char op = getIdxVal().charAt(0);
            idx++;
            ASTNode right = parseTerm();
            left = new OpNode(op, left, right);
        }
        return left;
    }

    //BNF TERM
    private ASTNode parseTerm() {
        ASTNode left = parseFactor();

        while(getIdxVal()!=null && (getIdxVal().equals("*") || getIdxVal().equals("/"))) {
            char op = getIdxVal().charAt(0);
            idx++;
            ASTNode right = parseFactor();
            left = new OpNode(op, left, right);
        }
        return left;
    }

    private ASTNode parseFactor() {
        String token = getIdxVal();
        if(token == null){
            System.err.println("Invalid expression");
            return new NumNode(0);
        }
        idx++;
        return new NumNode(Integer.parseInt(token));
    }

}

