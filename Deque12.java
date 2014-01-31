import java.util.*;
/**
 * Filename: Deque12<E>.java
 * This class is implementing BoundedDeque<E> interface, using circular
 * array. which is a sequential structure with restricted adccess and
 * limited capacity.
 * Access is available only at ends of the structure.
 * This class allows duplicate elements, does not permit null
 * elements.
 * This class also provides a public constructor with a single 
 * arguments of type int.
 *
 * @date 05/09/2013
 *
 */ 

public class Deque12<E> implements BoundedDeque<E> {
  private E[] queue;
  private int capacity; // the max number of elements can be in queue
  private int size;  // the number of elements (0<=size<=capacity)
  private int front; // index corresponding to the front of the Deque12
  private 
  int rear; // index  corresponding to the back of the Deque12

 
  /**
   * Constructor, initializing the fields 
   * @param maximum capacity, cannot be negative
   * @throws IllegalArgumentException, if param passed is negative
   * @see java.lang.Exception
   */ 
  public Deque12(int maxCapacity)  
  {
    // initializing fields
    // check the parameter passed cannot be negative
    if( maxCapacity < 0)  {
      throw new IllegalArgumentException();
    }
    queue = (E[]) new Object[maxCapacity];
    size = 0;
    front = 0;
    rear = 0;
    capacity = maxCapacity;
  }

 /**
  * Adds the specified element to the back of the queue.
  * @return true if operation succeeded, else false.
  * @param the new element to add at the back of the queue
  * @throws NullPointerException, if the param passed is negative
  */ 
 public boolean addBack(E e) {
   // pre-condition; size must be less than capacity
   // element passed cannot be null 
   if(size >= capacity) 
      return false;
   if( e == null) 
      throw new NullPointerException();
    // increment rear; do checks on wrapping indeces,
    // set rear to the new element
    //  check if full
   else  {
     rear++;
     if(rear >= capacity)  {
       rear = 0;
     }
     queue[rear] = e;
     size++;
     return true;
    } 
 }

 /**
  * Adds the specified element to the front of the queue.
  * @return true if operation succeeded, else false.
  * @param the new element to be added at the front of the queue
  * @throws NullPointerException if the specified element is null
  * and size is less than capacity.
  */  
 public boolean addFront(E e)  {
   boolean added;
   // pre-condition; size must be less than capacity
   // element passed cannot be null 
   if(size >= capacity) 
      return false;
   if(e == null) 
      throw new NullPointerException();
   else  {
     // set the new element then decrement front; 
     // wrap around if front is negative
     queue[front] = e;
     added = true; 
     size++;
     front = (front - 1 + capacity) % capacity;
   }
   return added; 
 }

 /**
  * Compares the specified object with this queue for equality.
  * @param the object for comparison
  * @return true if and only if the specified object is also Deque12<E>.
  * Namely, both have the same size, and the corresponding pairs of 
  * elements int the two are equal.
  */ 
 public boolean equals(java.lang.Object o) {
    boolean equals = false;
    if( o instanceof Deque12 )  {
      // casting to Deque12
      Deque12<E> p = (Deque12<E>)o;
     
      // check if the size equals
      if(this.size() == p.size())  {
        if(this.size == 0)  {
           equals = true;
        } else {
            equals = false;
          }
         int j = p.rear;
         int k = this.rear;
        // if the sizes of the objects are equals and they
        // are the same type, compare the elements in the 
        // corresponding indeces of the queues
        for(int i = 0; i < p.size(); i++) {
          if(p.queue[j].equals(this.queue[k]))  {
            equals = true;
            j = (j + 1) % p.capacity();
            k = (k + 1) % this.capacity();
            // skip over nulls (capacities are different, so some
            // indeces contain null before any element is stored
            while(p.queue[j] == null)
               j = (j + 1) % p.capacity();
            while(this.queue[k] == null)
               k = (k + 1) % this.capacity();
          }
          else  {
            equals = false;
            break;
          }
        }
      }
    }
    return equals;
 }

 /*
  * Method that returns the element at the back of this Deque12;
  * null if its not there, i.e. size is 0, the state of the Deque12
  * is not changed after this method call.
  * @return the element at the back of the Deque12 or null
  */ 
  public E peekBack() {
    if(size == 0)  {
      return null;
    }
    else {
      return queue[rear];
    }
 }

 /**
  * Removes an element at the back of this Deque12.
  * If the element is not present, returns null. The size of the
  * object decreases by one.
  * @return the element removed, or null if no element 
  */ 
  public E removeBack()  {
    if(size == 0)  {
      return null;
    } 
    E element = queue[rear];
    rear--;
    if(rear < 0)  {
      rear = capacity - 1;
    }
    size--;
    return element;
  }

 /**
  * Returns the element at the front of the BoundedDeque,
  * null if element is not there, i.e. size is 0. The state of the 
  * Deque12 object is not changed after this method call.
  * @return the element removed or null if not there.
  */ 
  public E peekFront()  {
    if(size == 0)  {
      return null;
    }
    else  {
      int tmp = front;
      E element;
      front++;
      // wrap around, since circular array
      if(front >= capacity)  {
        front = 0;
        element = queue[front];
        front = tmp;
      }
      else  {
        element = queue[front];
        front--;
        // wrap around
        if(front < 0)  
           front = capacity - 1;
      }
      return element;
    }
 }
  /**
   * Removes an element at the Front of this Deque12 object.
   * If empty Deque12, returns null. Size decreases by one if the 
   * element was removed.
   * @return the element removed or null if empty Deque12
   */ 
  public E removeFront()  {
    if(size == 0)  {
      return null;
    }
    front++;
    // wrap around
    if (front >= capacity)  {
      front = 0;	
    } 
    size--;
    return queue[front];
  }

 /**
  * This method returns the size of this Deque12 object.
  * @return size of the Deque12.
  */ 
  public int size()  {
    return size;
  }

 /**
  * This method returns the capacity of this Deque12 object.
  * @return capacity of the Deque12
  */ 
  public int capacity()  {
    return capacity;
  }
}
