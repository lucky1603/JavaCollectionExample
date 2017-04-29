/*
 * @decription: Java test application. What we are testing is behaviour of 'MyList' class.
 * @author: Sinisa Ristic <sinisa.ristic@gmail.com>
 * @date: 29.04.2017.
 */
package javacollectiontest;

import java.util.Iterator;

/**
 *
 * @author Sinisa Ristic
 * @version 1.0
 */
public class JavaCollectionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here                        
        MyList lista = new MyList();    
        
        System.out.println("\nInsert at the beginning\n");
        
        // First use insert(CustomElement e)
        lista.insert(new CustomElement(new int[]{1, 2, 3}));
        lista.insert(new CustomElement(new int[]{4, 5, 6}));
        lista.insert(new CustomElement(new int[]{7, 8, 9}));
        lista.insert(new CustomElement(new int[]{10, 11, 12}));
        
        Iterator it = lista.iterator();
                       
        while(it.hasNext())
        {
            CustomElement el = (CustomElement) it.next();
            System.out.println(el.toString());
        }
        
        System.out.println("\nThis list has " + lista.length() + " elements.");        
        
        // Use append(CustomElement e)
        System.out.println("\nAppending at the end\n");        
        lista.clear();
        
        lista.append(new CustomElement(new int[]{1, 2, 3}));
        lista.append(new CustomElement(new int[]{4, 5, 6}));
        lista.append(new CustomElement(new int[]{7, 8, 9}));
        lista.append(new CustomElement(new int[]{10, 11, 12}));
        
        it = lista.iterator();
                       
        while(it.hasNext())
        {
            CustomElement el = (CustomElement) it.next();
            System.out.println(el.toString());
        }
        
        System.out.println("\nThis list has " + lista.length() + " elements.");
        
        lista.clear();
        
        System.out.println("\nSorted entry\n");
        
        // Use sortedInsert(CustomElement e)
        
        lista.sortedInsert(new CustomElement(new int[]{1, 2, 3}));    
        lista.sortedInsert(new CustomElement(new int[]{10, 11, 12}));
        lista.sortedInsert(new CustomElement(new int[]{7, 8, 9}));       
        lista.sortedInsert(new CustomElement(new int[]{7, 8, 9, 11, 23}));       
        lista.sortedInsert(new CustomElement(new int[]{4, 5, 6}));
        
        it = lista.iterator();
                       
        while(it.hasNext())
        {
            CustomElement el = (CustomElement) it.next();
            System.out.println(el.toString());
        }
        
        System.out.println("\nThis list has " + lista.length() + " elements.");
        
        System.out.println("\n\nNow clear the list");
        lista.clear();
        System.out.println("\nThis list has " + lista.length() + " elements.");
        
    }
}
