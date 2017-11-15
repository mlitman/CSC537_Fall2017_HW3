package com.example.awesomefat.shuntingyard;

/**
 * Created by awesomefat on 11/14/17.
 */

public class Node
{
    private String payload;
    private Node nextNode;

    public Node(String payload)
    {
        this.payload = payload;
        this.nextNode = null;
    }

    public boolean isOperator()
    {
        return "+-*/".indexOf(this.payload) > -1;
    }

    public int getOpPower()
    {
        if(this.payload.equals("+") || this.payload.equals("-"))
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }

    public String getPayload() {
        return payload;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
