package org.example;


class NumNode extends ASTNode{
    private int val;

    public NumNode(int val) {
        this.val = val;
    }

    @Override
    public int evaluate() {
        return val;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + val);
    }



    public int getVal() {
        return val;
    }
}
