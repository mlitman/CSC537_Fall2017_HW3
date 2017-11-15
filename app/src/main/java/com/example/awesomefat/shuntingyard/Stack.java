package com.example.awesomefat.shuntingyard;

/**
 * Created by awesomefat on 11/14/17.
 */

public class Stack
{
    private Node top;

    public Stack()
    {
        this.top = null;
    }

    public void push(Node n)
    {
        if(this.top == null)
        {
            this.top = n;
        }
        else
        {
            n.setNextNode(this.top);
            this.top = n;
        }
    }

    public Node pop()
    {
        Node nodeToRemove = this.top;

        if(this.top != null)
        {
            this.top = this.top.getNextNode();
            nodeToRemove.setNextNode(null);
        }
        return nodeToRemove;
    }

    public Node peek()
    {
        return this.top;
    }

    public boolean isEmpty()
    {
        return this.top == null;
    }
}
