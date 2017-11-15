package com.example.awesomefat.shuntingyard;

/**
 * Created by awesomefat on 11/14/17.
 */

public class Queue
{
    private Node head;
    private Node tail;

    public Queue()
    {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty()
    {
        return this.head == null;
    }

    public void addEnd(Node n)
    {
        if(this.head == null)
        {
            this.head = n;
            this.tail = n;
        }
        else
        {
            tail.setNextNode(n);
            this.tail = n;
        }
    }

    public void addEnd(String payload)
    {
        Node n = new Node(payload);
        this.addEnd(n);
    }

    public Node removeFront()
    {
        Node nodeToRemove = this.head;

        if(this.head != null)
        {
            if(this.head == this.tail)
            {
                this.tail = null;
            }
            this.head = this.head.getNextNode();
            nodeToRemove.setNextNode(null);
        }
        return nodeToRemove;
    }
}
