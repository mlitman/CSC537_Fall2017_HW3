package com.example.awesomefat.shuntingyard;

import java.util.StringTokenizer;

/**
 * Created by awesomefat on 11/14/17.
 */

public class ShuntingYard
{
    private String input;
    private Queue inputQ;
    private Queue outputQ;
    private Stack opStack;
    private Stack processStack;

    public ShuntingYard(String input)
    {
        this.input = input;
        this.inputQ = new Queue();
        this.outputQ = new Queue();
        this.opStack = new Stack();
        this.processStack = new Stack();

        this.fillInputQ();
        this.processInputQ();
        this.processOutputQ();

    }

    public String getAnswer()
    {
        return this.processStack.peek().getPayload();
    }

    private Node doMath(String op, Node num1, Node num2)
    {
        int n1 = Integer.parseInt(num1.getPayload());
        int n2 = Integer.parseInt(num2.getPayload());
        int answer;
        if(op.equals("+"))
        {
            answer = n2 + n1;
        }
        else if(op.equals("-"))
        {
            answer = n2 - n1;
        }
        else if(op.equals("*"))
        {
            answer = n2 * n1;
        }
        else
        {
            answer = n2 / n1;
        }
        return new Node("" + answer);
    }

    private void processOutputQ()
    {
        Node temp;
        while(!this.outputQ.isEmpty())
        {
            temp = this.outputQ.removeFront();
            if(temp.isOperator())
            {
                Node answer = this.doMath(temp.getPayload(), this.processStack.pop(), this.processStack.pop());
                this.processStack.push(answer);
            }
            else
            {
                this.processStack.push(temp);
            }
        }
    }

    private void tryToAddToOpStack(Node n)
    {
        while(!this.opStack.isEmpty() && n.getOpPower() <= this.opStack.peek().getOpPower())
        {
            this.outputQ.addEnd(this.opStack.pop());
        }
        this.opStack.push(n);
    }

    private void processInputQ()
    {
        Node temp;
        while(!this.inputQ.isEmpty())
        {
            temp = this.inputQ.removeFront();
            if(temp.isOperator())
            {
                this.tryToAddToOpStack(temp);
            }
            else
            {
                this.outputQ.addEnd(temp);
            }
        }

        //clear the opStack
        while(!this.opStack.isEmpty())
        {
            this.outputQ.addEnd(this.opStack.pop());
        }
    }

    private void fillInputQ()
    {
        //fill the inputQ
        StringTokenizer st = new StringTokenizer(this.input, "+-*/", true);
        while(st.hasMoreTokens())
        {
            inputQ.addEnd(st.nextToken().trim());
        }
        /*
        assumes a single space between each element, above solution is more universal
        String currVal = "";
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == ' ')
            {
                inputQ.addEnd(currVal);
                currVal = "";
            }
            else
            {
                currVal = currVal + input.charAt(i);
            }
        }
        if(currVal.length() > 0)
        {
            inputQ.addEnd(currVal);
        }
        */
    }
}
