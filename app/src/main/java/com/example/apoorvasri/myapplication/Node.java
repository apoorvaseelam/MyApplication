package com.example.apoorvasri.myapplication;

/**
 * Created by ApoorvaSri on 12/2/2015.
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
    public void setPayload(String payload)
    {
     this.payload = payload;
    }
    public String getPayload()
    {
        return payload;
    }
    public Node getNextNode()
    {
        return nextNode;
    }

    public void setNextNode(Node nextNode)
    {
        this.nextNode = nextNode;
    }

}
