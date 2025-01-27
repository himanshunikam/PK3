import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class IntList {


  @Test
  public void testList_Empty() {
    // arrange
    IntList intList = new IntList();
    // act
    intList.tail(); // smoke test, i.e., no exception or corrupt state
    int currLength = intList.length();
    Integer emptyHead = intList.head();
    // assert
    assertEquals(0, currLength);
    assertNull(emptyHead);
  }

  @Test
  public void testList_Common() {
    // arrange
    IntList intList = new IntList();
    // act
    intList.add(3);
    intList.add(2);
    Integer interimHead = intList.head();
    intList.add(1);
    intList.add(0);
    intList.tail();
    Integer currHead = intList.head();
    int currLength = intList.length();
    // assert
    assertEquals(2, interimHead);
    assertEquals(1, currHead);
    assertEquals(3, currLength);
  }

  protected class Entry {
    Integer element;
    Entry next;
  }

  Entry head;

  IntList() {
  }

  public Integer head() {
    if (head != null)
      return head.element;
    else
      return null;
  }

  public IntList tail() {
    if (head != null) {
      head = head.next;
    }
    return this;
  }

  public IntList add(Integer newEl) {
    Entry newEntry = new Entry();
    newEntry.element = newEl;
    newEntry.next = head;
    head = newEntry;
    return this;
  }

  public int length() {
    int len = 0;
    Entry e = head;
    while (e != null) {
      e = e.next;
      len++;
    }
    return len;
  }
}