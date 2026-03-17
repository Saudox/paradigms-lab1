package org.example;


class OpNode extends ASTNode {
    private char op;
    private ASTNode left;
    private ASTNode right;

    public OpNode(char op, ASTNode left, ASTNode right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        int leftVal = left.evaluate();
        int rightVal = right.evaluate();

        if(op == '+'){
            return leftVal + rightVal;
        }
        else if(op == '-'){
            return leftVal - rightVal;
        }
        else if(op == '*'){
            return leftVal * rightVal;
        }
        else if(op == '/'){
            if(rightVal == 0){
                System.err.println("Division By ZERO!!" );
                return 0;
            }
            return leftVal / rightVal;
        }
        else {
            System.err.println("Unknown operator: " + op);
            return 0;
        }
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + op);

        String childPrefix = prefix.replace("|-- ", "|   ")
                .replace("\\-- ", "    ");

        left.print(childPrefix + "|-- ");
        right.print(childPrefix + "\\-- ");
    }




    public char getOp() {
        return op;
    }

    public ASTNode getLeft() {
        return left;
    }

    public ASTNode getRight() {
        return right;
    }

}
