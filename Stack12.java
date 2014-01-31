/**
 * Filename: Stack12.java
 * 
 * This class implements BooundedStack<E> interface with
 * limited capacity, adopting Deque12<E>.
 * <p>
 * This class provides a public constructor with a single argument
 *  of type <tt>int</tt>, which specifies the capacity of the BoundedStack.
 * The constructor should throws IllegalArgumentException if the specified
 * capacity is negative.
 * @date 05/09/2013
 */
public class Stack12<E> implements BoundedStack<E> {

  private Deque12<E> stack;
  // the top element of the stack is front of the BoundedQueue
  
 /**
  * Constructor, initializing the fields 
  * @throws IllegalArgumentException
  * @see java.lang.Exception
  */   
 public Stack12(int capacity)  {
   if(capacity < 0)  {
     throw new IllegalArgumentException();
   }
   stack = new Deque12<E>(capacity);
 }

  /**
   * Returns the number of elements in this Stack12.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the Stack12 is unchanged.
   * @return the number of elements in this BoundedStack
   */
 public int capacity()  {
   return stack.capacity();
 }
 
  /**
   * Returns the number of elements in this Stack12.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the Stack12 is unchanged.
   * @return the number of elements in this Stack12
   */
 public int size()  {
   return stack.size();
 }
 
  /**
   * Adds the specified element to the top of this Stack12.
   * Returns true if the operation succeeded, else false.
   * <br>PRECONDITION: the Stack12's size is less than its capacity.
   * <br>POSTCONDITION: the element is now the top element in this
   * BoundedStack, none of the other elements have been changed, and
   * the size is increased by 1.
   * @param e the element to add to the stack
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */
 public boolean push(E e)  {
   if(stack.size() >= stack.capacity() || e == null)  {
     throw new NullPointerException();
   }
   return stack.addFront(e);
 }

  /**
   * Removes the element at the top of this Stack12.
   * Returns the element removed, or <tt>null</tt> if there was no such 
   * element.
   * <br>PRECONDITION: the Stack12's size is greater than zero.
   * <br>POSTCONDITION: the top element in this Stack12 has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */
 public E pop()  {
   if(stack.size() == 0)  {
     return null;
   }
   return stack.removeFront();
 }

 /**
   * Returns the element at the top of this Stack12,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Stack12's size is greater than zero.
   * <br>POSTCONDITION: The Stack12 is unchanged.
   * @return  the element at the top, or <tt>null</tt> if the size was zero.
   */ 
 public E peek()  {
   if(stack.size() == 0)  {
     return null;
   }
   return stack.peekFront();
 }

  /**
   * Compares the specified object with this Stack12 for equality.
   * Returns true if and only if the specified object is
   * also a Stack12 of the same type, both have the same size, and the
   * corresponding pairs of elements in the two are
   * equal. Two elements e1 and e2 are equal if e1.equals(e2).
   * "Corresponding pairs" means: the pair of top elements,
   * the pair of next-to-top elements, and so on through to
   * the pair of bottom elements.
   * @return true if the specified Object is equal to this Stack12
   * @param  o the Object to compare to this BoundedStack for equality
   */
 public boolean equals(Object o)  {
   if(o instanceof Deque12)
     return  stack.equals(((Stack12)o).stack);
   else 
     return false;
 }
}
