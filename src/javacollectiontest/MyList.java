/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollectiontest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Sinisa Ristic
 */public class MyList implements CustomCollection, Iterator<CustomElement>, Cloneable {
    
    private CustomElement first, current;
    private int length = 0;

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public Object first() {
        return this.first;
    }

    /**
     * Insert element to the beginning of the list.
     */
    @Override    
    public Object insert(Object e) {
        if(this.first == null)
        {                    
            this.current = this.first = (CustomElement) e;
            this.length ++;
        }
        else 
        {
            CustomElement priv = this.first;
            this.current = this.first = (CustomElement)e;
            this.current.setNext(priv);
            priv.setPrevious(this.current);
            this.length ++;
        }
        
        return e;
    }

    @Override
    public Object append(Object e) {
        if(e == null)
            return null;
        
        CustomElement newElement = (CustomElement) e;
        if(newElement == null)
            return null;
        
        if(this.length == 0)
        {
            this.first = this.current = newElement;       
            this.length ++;
            return newElement;
        }
        
        CustomElement lastElement = null;
        Iterator it = this.iterator();
        while(it.hasNext())
        {
            lastElement = (CustomElement) it.next();
        }
        
        lastElement.setNext(newElement);
        newElement.setPrevious(lastElement);
        this.length ++;
        return newElement;
    }

    @Override
    public Object sortedInsert(Object e) {
        if(e == null)
            return null;
        
        CustomElement newElement = (CustomElement) e;
        if(newElement == null)
            return null;
        
        if(this.length == 0)
        {
            this.first = this.current = newElement;       
            this.length ++;
            return newElement;
        }
        
        CustomElement currentElement = null;
        Iterator it = this.iterator();
        int result = -1;
        boolean hasLowers = false;
        while(it.hasNext() || result == -1)
        {
            currentElement = (CustomElement) it.next();
            result = currentElement.compareTo(newElement);
            if(result == 1)
            {
                CustomElement previousElement = currentElement.getPrevious();
                if(previousElement != null)
                {
                    previousElement.setNext(newElement);
                    newElement.setPrevious(previousElement);
                }
                newElement.setNext(currentElement);
                currentElement.setPrevious(newElement);
                this.length ++;
                return newElement;
            }
            
            if(currentElement.getNext() == null && currentElement != newElement)
            {
                currentElement.setNext(newElement);
                newElement.setPrevious(currentElement);
                newElement.setNext(null);
                this.length ++;
                return newElement;
            }
            
            hasLowers = true;
        }
        
        return newElement;
    }

    @Override
    public Object delete(Object e) {                
        // Find the element in the collection
        Iterator it = this.iterator();
        while(it.hasNext())
        {
            CustomElement el = (CustomElement) it.next();
            if(el.equals(e))
            {
                if(this.first.equals(e))
                {
                    CustomElement next = this.first.getNext();
                    if(next != null) {
                        this.first = next;
                        this.current = next;
                    }
                    else 
                    {
                        this.first = null;
                        this.current = null;
                    }   
                }
                else if (el.getNext() == null) { // the last one in the list
                    CustomElement prevEl = el.getPrevious();
                    prevEl.setNext(null);
                }
                else {
                    CustomElement nextEl = el.getNext();
                    CustomElement prevEl = el.getPrevious();
                    prevEl.setNext(nextEl);
                    this.current = prevEl;
                }
                
                this.length --;
            }
        }
                
        return e;                
    }

    @Override
    public Iterator iterator() {
        this.current = null;
        return this;
    }

    @Override
    public boolean hasNext() 
    {
        if(this.current != null && this.current.getNext() != null)
        {
            return true;        
        }
        else if(this.current == null && this.first != null)
        {
            return true;
        }
        
        return false;
    }

    @Override
    public CustomElement next() 
    {
        if(this.current == null)
        {
            if(this.first != null)
            {
                this.current = this.first;    
            }
            else 
            {
                return null;
            }
        }
        else 
        {
            CustomElement next = this.current.getNext();
            this.current = next;  
        }
        
        return this.current;
    }
    
    public void clear()
    {
        if(this.length == 0)
        {
            return;
        }
        
        CustomElement nextEl = this.first.getNext();
        if(nextEl == null)
        {
            this.first = null;
            this.current = null;
            this.length = 0;
            return;
        }
        
        while(nextEl != null)
        {
            this.first.setNext(null);
            nextEl.setPrevious(null);
            this.first = nextEl;
            nextEl = this.first.getNext();
        }
        
        this.first = null;
        this.current = null;
        this.length = 0;        
    }

    
    
}
