/*
 * @description: Definition of the list interface.
 * @author: Sinisa Ristic <sinisa.ristic@gmail.com>
 * @date: 29.04.2017.
 */
package javacollectiontest;

import java.util.Iterator;

/**
 *
 * @author Sinisa Ristic
 */
public interface CustomCollection {

    /**
     * Checks if the collection is empty.
     * @return
     */
    boolean isEmpty();
    
    /**
     * Returns the number of elements in the collection.
     * @return
     */
    int length();
    
    /**
     * Returns the first object in the collection.
     * @return The first object in the array.
     */
    Object first();
    
    /**
     * Inserts the element at the beginning of the list.
     * @param Object e
     * @return Inserted object.
     */
    Object insert(Object e);
    
    /**
     * Inserts the object e to the end of the list.
     * @param Object e
     * @return The newly inserted object.
     */
    Object append(Object e);
    
    /**
     * Inserts the object to the list and places it based on the implemented sorting algorithm.
     * @param e
     * @return 
     */
    Object sortedInsert(Object e);
    
    /**
     * Deletes the object from the list
     * @param Object e - object to be deleted.
     * @return The deleted object.
     */
    Object delete(Object e);
    
    /**
     * Returns the iterator
     * @return 
     */
    Iterator iterator();    
}
