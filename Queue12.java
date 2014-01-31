/**
 * Filename: Queue12.java
 *
 * This class implements BoundedQueue interface with
 * limited capacity, adapting Deque12<E> class.
 * <p>
 * Provides public constructor with a single argument of type 
 * <tt>int</tt>, which specifies the capacity of the Queue12. 
 * The constructor throws an IllegalArgumentException if the 
 * specified capacity is negative.
 *
 * @date 05/09/2013
 */
  public class Queue12<E> implements BoundedQueue<E>  {
    private Deque12<E> queue;
  
  /**
   * Public constructor.
   * @throw IllegalArgumentException if capacity is negative
   */
  public Queue12(int capacity)  {
    if(capacity < 0)  {
      throw new IllegalArgumentException();
    }
    queue = new Deque12<E>(capacity);
  }

 /**
   * Returns the capacity of the Queue12 object, that is,
   * the maximum number of elements it can hold.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the Queue12 is unchanged.
   * @return the capacity of this Queue12
   */
  public int capacity()  {
    return queue.capacity();
  }

  /**
   * Returns the number of elements in this Queue12.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the Queue12 is unchanged.
   * @return the number of elements in this BoundedQueue
   */
  public int size()  {
    return queue.size(); 
  }
  
 /**
   * Adds the specified element to the tail of this Queue12.
   * Returns true if the operation succeeded, else false.
   * <br>PRECONDITION: the Queue12's size is less than its capacity.
   * <br>POSTCONDITION: the element is now the tail element in this
   * BoundedQueue, none of the other elements have been changed, and
   * the size is increased by 1.
   * @param e the element to add to the queue
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */
  public boolean enqueue(E e)  {
    if(queue.size() >=  queue.capacity() || e == null)  {
      throw new NullPointerException();
    }
    return queue.addBack(e); 
  }
 
 /**
   * Removes the element at the head of this Queue12.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the BoundedQueue's size is greater than zero.
   * <br>POSTCONDITION: the head element in this Queue12 has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */
 public E dequeue()  {
   if(queue.size() == 0)  {
     return null;
   }
   return queue.removeFront();
 }
 
 /**
   * Returns the element at the head of this Queue12,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Queue12's size is greater than zero.
   * <br>POSTCONDITION: The Queue12 is unchanged.
   * @return  the element at the head, or <tt>null</tt> if the size was zero.
   */
 public E peek()  {
   if(queue.size() == 0)  {
     return null;
   }
   return queue.peekFront();
 }

 /**
   * Compares the specified object with this Queue12 for equality.
   * Returns true if and only if the specified object is
   * also a Queue12 of the same type, both have the same size, and the
   * corresponding pairs of elements in the two are
   * equal. Two elements e1 and e2 are equal if e1.equals(e2).
   * "Corresponding pairs" means: the pair of head elements,
   * the pair of next-to-head elements, and so on through to
   * the pair of tail elements.
   * @return true if the specified Object is equal to this Queue12
   * @param  o the Object to compare to this Queue12 for equality
   */
  public boolean equals(java.lang.Object o)  {
    if(o instanceof Stack12)
      return queue.equals(((Queue12)o).queue);
    else 
      return false;
  }
 
}
