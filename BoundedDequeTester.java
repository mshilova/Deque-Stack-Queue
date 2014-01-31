import java.util.*;
/**
 * Filename: BoundedDequeTester.java
 * This class is testing methods of Deque12<E> class.
 * @date 05/09/2013
 */ 


public class BoundedDequeTester extends junit.framework.TestCase  {
  
  public static void main (String[] args)  {
    junit.textui.TestRunner.main(new String[] {"BoundedDequeTester"});
  }

  /**
   * Testing constructor of Deque12<E>. Namely, making sure that fields
   * are initialized as expected.
   */ 
  public void testConstructor() {
    // creating object to test
    BoundedDeque<String> test = new Deque12<String>(100);
    // verifying size initialized to 0
    assertTrue(test.size() == 0);
    // verifying capacity is initialized to param
    assertTrue(test.capacity() == 100);
    // verifying size is less than capacity
    assertTrue(test.size() < test.capacity());
  }
    
  /**
   * Testing constructor by passing negative param for capacity.
   * Should throw IllegalArgumentException.
   * @see java.lang.Exception 
   */ 
  public void testExceptionConstructorNeg()  {
    try  {
      // passing negative value
      BoundedDeque<String> testExcNeg = new Deque12<String>(-1);
      fail("Expected IllegalArgumentException!");
    }
    catch(IllegalArgumentException e)  {
    } // test passed
    catch(Throwable e)  {
      fail("An Unexpected Exception Occured!");
    }
  }
  
  /**
   * Method to test addFront() method of Deque12<E> class.
   * Making sure that elements were added successfully, size changed,
   * capacity stayed the same, returns false if capacity == size;
   */ 
  public void testAddFront()  {
    BoundedDeque<Integer> testAddFront = new Deque12<Integer>(1000);
    // adding elements to max capacity
    for (int i = 0; i < testAddFront.capacity(); i++)  {
       // apply mutator
       assertTrue(testAddFront.addFront(new Integer(i)));
    }
    // verifying the size changed and is equals to capacity 
    assertTrue(testAddFront.size() == testAddFront.capacity());
    // verify cannot add more elements when size is same as capacity
    assertFalse(testAddFront.addFront(new Integer(100)));
  }
 
  /**
   * Testing adding to queue with capacity = 0;
   */ 
  public void testAddFront2()  {
    BoundedDeque<Integer> testAdd = new Deque12<Integer>(0);
    // verifying cannot add when capacity is 0
    assertFalse(testAdd.addFront(new Integer(12)));
    assertTrue(testAdd.size() == testAdd.capacity());
  }

  /**
   * Method testing that adding null will throw an exception
   * @see java.lang.Exception
   */  
  public void testAddFrontNull ()  {
     try  {
       BoundedDeque<String> testAddFrNull = new Deque12<String>(1000);
       while(testAddFrNull.size() < testAddFrNull.capacity())  {
         testAddFrNull.addFront(null);
       }
       fail("Expected NullPointerException");
     }
     catch(NullPointerException e)  {
     } // test passed
     catch(Throwable e)  {
       fail("An Unexpected Exception Occurred");
     }
  }

  /**
   * Testing adding elements the back of the Deque12<E>.
   * Making sure the size changed after adding elements and that 
   * cannot add more elements when capacity is same as size/ 
   */ 
   public void testAddBack()  {
     BoundedDeque<Integer> testAddBack = new Deque12<Integer>(1000); 
     for(int i = 0; i < testAddBack.capacity(); i++)  {
       // applying mutator
       assertTrue(testAddBack.addBack(new Integer(i)));
     }
     // verifying that cannot add more when full
     assertFalse(testAddBack.addBack(new Integer(1000)));
     // veryfying size changed and equals to capacity
     assertTrue(testAddBack.size() == testAddBack.capacity());
   }

  /**
   * Testing adding back with capacity 0 
   * Making sure cannot add any elements.
   */ 
   public void testAddBack2()  {
     BoundedDeque<Integer> testAddBack = new Deque12<Integer>(0); 
     assertFalse(testAddBack.addBack(new Integer(12)));
     assertTrue(testAddBack.size() == testAddBack.capacity());
    } 

  /**
   * Testing adding back null. Should throw NullPointerException.
   * @see java.lang.Exception
   */  
  public void testAddBackNull ()  {
     try  {
       BoundedDeque<String> testAddBackNull = new Deque12<String>(1000);
       while(testAddBackNull.size() < testAddBackNull.capacity())  {
         testAddBackNull.addBack(null);
       }
       fail("Expected NullPointerException");
     }
     catch(NullPointerException e)  {
     } // test passed
     catch(Throwable e)  {
       fail("An Unexpected Exception Occurred");
     }
  }
   
  /**
   * Testing adding front and back together. Size should change and 
   * cannot add front or back when full.
   */ 
   public void testAddBackFront()  {
     BoundedDeque<String> testAddBackFront = new Deque12<String>(1000);
     for(int i = 0; i < testAddBackFront.capacity() / 2; i++)  {
       // applying mutators
       assertTrue(testAddBackFront.addBack("A"));
       assertTrue(testAddBackFront.addFront("B"));
     }
     // verifying that the Deque12 is full
     assertTrue(testAddBackFront.size() == testAddBackFront.capacity());
     // verifying cannot add more front or back
     assertFalse(testAddBackFront.addFront("B"));
     assertFalse(testAddBackFront.addBack("A"));
   }

 /**
  * Testing removeBack; suppose to return the element removed, size 
  * decreased by one; if size is 0; return null; 
  * no exceptions are thrown
  */ 
  public void testRemoveBack()  {
    BoundedDeque<Integer> testRemoveBack = new Deque12<Integer> (1000);
    assertEquals(testRemoveBack.size(), 0);
    // should return null if size is 0
    assertNull(testRemoveBack.removeBack());

    for(int i = 0; i < testRemoveBack.capacity(); i++)  {
      // applying mutators
      assertTrue(testRemoveBack.addBack(new Integer(i)));
      assertEquals(testRemoveBack.removeBack(), new Integer(i));
      // verifying the size decreased after removing
      assertEquals(testRemoveBack.size(), 0);
    }
    // should return null if size is 0
    assertNull(testRemoveBack.removeBack());
  }
    
 /**
  * Testing removeFront; suppose to return the element removed, 
  * size decreased by one; if size is 0, returns null 
  */ 
  public void testRemoveFront()  {
    BoundedDeque<Integer> testRemoveFront = new Deque12<Integer> (1000);
    assertEquals(testRemoveFront.size(), 0);
    // should return null if size is 0
    assertNull(testRemoveFront.removeFront());

    for(int i = 0; i < testRemoveFront.capacity(); i++)  {
      // applying mutators
      assertTrue(testRemoveFront.addFront(new Integer(i)));
      assertEquals(testRemoveFront.removeFront(), new Integer(i));
      // verifying the size decreased after removing
      assertEquals(testRemoveFront.size(), 0);
    }
    assertNull(testRemoveFront.removeFront());
  }

 /**
  * Testing adding front and back and removing front and back
  */ 
  public void testAddRemoveFrontBack()  {

    BoundedDeque<String> testAddRemove = new Deque12<String> (6);
    assertTrue(testAddRemove.size() == 0);

    for(int i = 0; i < testAddRemove.capacity() / 2; i++)  {
      assertTrue(testAddRemove.addFront("A"));
      assertTrue(testAddRemove.addBack("B"));
    } // made A B B B A A in a linear form
    
    for(int i = 0; i < testAddRemove.capacity() / 2; i++)  {
      // verifying the elements removed match the elements added
      assertEquals(testAddRemove.removeFront(), new String("A"));
      assertEquals(testAddRemove.removeBack(), new String("B"));
    } 
    // verifying size is 0 after removing all elements
    assertTrue(testAddRemove.size() == 0);
  }

 /**
  * Testing peek front. Should return null if the Deque12 is empty,
  * else the element at the front of the Deque. Size should not
  * change after the method call. 
  */ 
  public void testPeekFront()  {

    BoundedDeque<Integer> testPeek = new Deque12<Integer> (100);
    // verify returns null when empty Deque12     
    assertNull(testPeek.peekFront());

    for(int i = 0; i < testPeek.capacity(); i++)  {
      // adding element
      testPeek.addFront(new Integer(i));
      // verifying returns the element added
      assertEquals(testPeek.peekFront(), new Integer(i));
    }
    // peek should not change the size
    assertEquals(testPeek.peekFront(), new Integer(99));
    assertEquals(testPeek.size(), testPeek.capacity());
  }

 /**
  * Testing peek back. Should return null if the Deque12 is empty,
  * else the element at the back of the Deque12. Size should not 
  * change after the method call.
  */ 
  public void testPeekBack()  {

    BoundedDeque<Integer> testPeek = new Deque12<Integer> (100);
    // verify returns null if emptu Deque12
    assertNull(testPeek.peekBack());
    for(int i = 0; i < testPeek.capacity(); i++)  {
      // adding element
      testPeek.addFront(new Integer(i));
      // verifying returns the element added
      assertEquals(testPeek.peekFront(), new Integer(i));
    }
    // the back element is 0
    assertEquals(testPeek.peekBack(), new Integer(0));
    // peek should not change the size
    assertEquals(testPeek.size(), testPeek.capacity());
  }

 /**
  * Testing peekFront() and removeFront() of Deque12<E> class.
  * The element returned should be the same from both method calls,
  * remove should change size but peek should not.
  */ 
  public void testPeekFrontRemove()  {
    BoundedDeque<String> testPeek = new Deque12<String> (4);
    assertTrue(testPeek.size() == 0);
    // applying mutators
    testPeek.addFront("A");
    testPeek.addFront("B");
    testPeek.addFront("C");
    testPeek.addFront("D");
    // verifying the elements are the same when calling peek and remove 
    assertEquals(testPeek.peekFront(), testPeek.removeFront());
    assertEquals(testPeek.peekFront(), testPeek.removeFront());
    assertEquals(testPeek.peekFront(), testPeek.removeFront());
    assertEquals(testPeek.peekFront(), testPeek.removeFront());
    // verifying the size decreased after each remove
    assertTrue(testPeek.size() == 0);
  }

 /**
  * Testing peekBack() and removeBack() of Deque12<E> class.
  * The element returned should be the same from both method calls,
  * remove should change size but peek should not.
  */ 
  public void testPeekBackRemove()  {
    BoundedDeque<String> testPeek = new Deque12<String> (4);
    assertTrue(testPeek.size() == 0);
    // applying mutators
    testPeek.addFront("A");
    testPeek.addFront("B");
    testPeek.addFront("C");
    testPeek.addFront("D");
    // verifying the elements are the same when calling peek and remove 
    assertEquals(testPeek.peekBack(), testPeek.removeBack());
    assertEquals(testPeek.peekBack(), testPeek.removeBack());
    assertEquals(testPeek.peekBack(), testPeek.removeBack());
    assertEquals(testPeek.peekBack(), testPeek.removeBack());
    // verifying the size decreased after each remove
    assertTrue(testPeek.size() == 0);
  }

  /**
   * Testing removeBack() of the Deque12<E> class. Making sure that
   * the elements removed are the same as added.
   */ 
  public void testRemoveBack2()  {
    BoundedDeque<String> testRemove = new Deque12<String> (4);
    assertTrue(testRemove.size() == 0);
    // applying mutators
    testRemove.addFront("A");
    testRemove.addFront("B");
    testRemove.addFront("C");
    testRemove.addFront("D");
    // verifying elements 
    assertEquals(testRemove.removeBack(), new String("A"));
    assertEquals(testRemove.removeBack(), new String ("B"));
    assertEquals(testRemove.removeBack(), new String("C"));
    assertEquals(testRemove.removeBack(), new String ("D"));
    // verifying the size decreased after each remove
    assertTrue(testRemove.size() == 0);
  }
  
 /**
  * Testing removeFront() of the Deque12<E> class. Making sure that
  * the elements removed are the same as added.
  */ 
  public void testRemoveFront2()  {
    BoundedDeque<String> testRemove = new Deque12<String> (4);
    assertTrue(testRemove.size() == 0);
    // applying mutators
    testRemove.addFront("A");
    testRemove.addFront("B");
    testRemove.addFront("C");
    testRemove.addFront("D");
    // verifying elements 
    assertEquals(testRemove.removeFront(), new String("D"));
    assertEquals(testRemove.removeFront(), new String ("C"));
    assertEquals(testRemove.removeFront(), new String("B"));
    assertEquals(testRemove.removeFront(), new String ("A"));
    // verifying that the size decreased after each remoove
    assertTrue(testRemove.size() == 0);
  }

 /**
  * Method to test capacity() of the Deque12<E> class. Making sure that 
  * capacity of Deque12 object is initialized to the parameter passed
  * in the constructor. Should not change after adding elements to the 
  * Deque12.
  */ 
  public void testCapacity()  {

    BoundedDeque<Integer> testCapacity = new Deque12<Integer>(25);
    assertEquals(testCapacity.size(), 0);
    assertEquals(testCapacity.capacity(), 25);
    testCapacity.addFront(new Integer(12));
    assertEquals(testCapacity.capacity(), 25);
  }

 /**
  * Method to test size() of the Deque12<E> class. Size should be 0 
  * before adding elements, and it should change only after removing
  * or adding elements to the Deque12 object.
  */
  public void testSize()  {
    BoundedDeque<Integer> testSize = new Deque12<Integer>(25);
    assertEquals(testSize.size(), 0);
    // applying mutators
    testSize.addFront(new Integer (12));
    assertEquals(testSize.size(), 1);
    testSize.addFront(new Integer (12));
    assertEquals(testSize.size(), 2);
    // applying mutators
    testSize.removeBack();
    testSize.removeFront();
    // verifying mutators
    assertEquals(testSize.size(), 0);
  }

 /**
  * Method to test equals() of the Deque12<E> class.
  * Creating two objects of type Deque12<E> with different capacities.
  * Adding elements to both Deque12 objects (corresponding elements are
  * the same). Then making sure they are equal
  */ 
  public void testEquals()  {
    BoundedDeque<String> testEqualsA = new Deque12<String> (5);
    BoundedDeque<String> testEqualsB = new Deque12<String> (25);
    // should be equals if two empty Dequq12 objects 
    assertTrue(testEqualsA.equals(testEqualsB));
    // applying mutators
    testEqualsA.addFront("A");
    testEqualsA.addFront("B");
    testEqualsA.addFront("C");
    testEqualsA.addFront("D");
    // applying mutators 
    testEqualsB.addBack("D");
    testEqualsB.addBack("C");
    testEqualsB.addBack("B");
    testEqualsB.addBack("A");
    // verifying that the objects' corresponding elements
    // are equal.
    assertTrue(testEqualsA.equals(testEqualsB));
  }
 /**
  * Testing equals method of Deque12<E> class.
  * Two Deque12<E> objects with the same type elements but different
  * elements.
  */ 
 public void testEquals1()  {
   BoundedDeque<Integer> testEqualsA = new Deque12<Integer> (25);
   BoundedDeque<Integer> testEqualsB = new Deque12<Integer> (25);
   // applying mutators
   testEqualsA.addFront(new Integer(12));
   testEqualsA.addBack(new Integer(21));
   testEqualsB.addBack(new Integer(12));
   testEqualsB.addFront(new Integer(21));
   // verifying the corresponding elements are different
   assertFalse(testEqualsA.equals(testEqualsB));
 }
 /**
  * Testing equals() method of Deque12<E> class. Making two Deque12<E>
  * objects that have different types. Making sure that when two objects
  * are empty they are equal, and when elements are added they are not.
  */ 
  public void testEquals2()  {
    // two Deque12 object with different types
    BoundedDeque<String> testEqualsA = new Deque12<String> (5);
    BoundedDeque<Integer> testEqualsB = new Deque12<Integer> (25);
    // make sure they are equal when empty
    assertTrue(testEqualsA.equals(testEqualsB));
    // appying mutators 
    testEqualsA.addFront("A");
    testEqualsA.addBack("B");
    // verifying that when sizze is different not equal 
    assertFalse(testEqualsA.equals(testEqualsB));
    // applying mutators
    testEqualsB.addFront(new Integer(12));
    testEqualsB.addBack(new Integer(21));
    // verifying that the corresponding elements are not equal
    assertFalse(testEqualsA.equals(testEqualsB));
  }
}
