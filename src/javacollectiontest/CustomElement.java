/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollectiontest;

/**
 *
 * @author Sinisa Ristic
 */
public class CustomElement extends Object implements Comparable 
{
    private int[] numbers; 
    private CustomElement next;
    private CustomElement previous;
    
    public CustomElement(int[] numbers)
    {
        this.numbers = numbers.clone();
    }
    
    public CustomElement getNext()
    {
        return this.next;
    }
    
    public void setNext(CustomElement el)
    {
        this.next = el;
    }
    
    public CustomElement getPrevious()
    {
        return this.previous;
    }
    
    public void setPrevious(CustomElement el)
    {
        this.previous = el;
    }
    
    public int[] getNumbers()
    {
        return this.numbers;
    }
    
    @Override
    public int compareTo(Object o) 
    {
        if(o == null)
            return 1;
        
        CustomElement copy = (CustomElement)o;
        
        if(this.numbers.length < copy.numbers.length)
        {
            return -1;
        }
        else if(this.numbers.length > copy.numbers.length)
        {
            return 1;
        }
        else 
        {
            int retVal = 0;
            for(int i = 0; i < this.numbers.length; i++)
            {
                if(this.numbers[i] < copy.numbers[i])
                    return -1;
                if(this.numbers[i] > copy.numbers[i])
                    return 1;
            }                        
        }
        
        return 0;
    }
    
    @Override
    public boolean equals(Object e)
    {
        return this.numbers.equals(e);
    }
    
    @Override
    public String toString()
    {
        String outVal = "";
        for(int number : this.numbers)
        {
            outVal += "[";
            outVal += number;
            outVal += "] ";
        }
        
        return outVal;
    }        
    
}
