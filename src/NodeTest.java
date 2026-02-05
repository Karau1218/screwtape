import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

  // -------- WAVE 1 -------

  @Test 
  void testListConstructorWithThreeValues() {
    // Arrange
    List<Integer> values = List.of(5, 7, 3);

    // Act
    Node head = new Node(values);

    // Assert
    assertEquals(5, head.value);
    assertNotNull(head.next);
    assertEquals(7, head.next.value);
    assertNotNull(head.next.next);
    assertEquals(3, head.next.next.value);
    assertNull(head.next.next.next);
    assertEquals(head, head.next.prev);
    assertEquals(head.next, head.next.next.prev);
  }

  @Test
  void testListConstructorWithEmptyList() {
    // Arrange
    List<Integer> emptyList = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Node(emptyList),
        "Expected constructor to throw IllegalArgumentException for an empty list."
    );
  }

  
  // TODO: Add test for list constructor when passed null list
  // TODO: Add at least one more test for list constructor that would be useful and cover new ground.

  @Test
  void testListConstructorWithSingleValue() {
    List<Integer> values = List.of(42);
    Node head = new Node(values);

    // Head value is correct
    assertEquals(42, head.value);
    // No next node
    assertNull(head.next);
    // No previous node
    assertNull(head.prev);
  }

  @Test
void testListConstructorWithTwoValues() {
    List<Integer> values = List.of(10, 20);
    Node head = new Node(values);

    // Check values
    assertEquals(10, head.value);
    assertEquals(20, head.next.value);

    // Check next/prev links
    assertEquals(head, head.next.prev);
    assertNull(head.prev);
    assertNull(head.next.next);  // tail has no next
}

  // -------- WAVE 2 -------

  @Test
  void testToListWithThreeValues() {
    // Arrange
    Node head = new Node(5);
    Node middle = new Node(7);
    Node tail = new Node(3);

    head.next = middle;
    middle.prev = head;
    middle.next = tail;
    tail.prev = middle;

    // Act
    List<Integer> values = head.toList();

    // Assert
    assertEquals(List.of(5, 7, 3), values);
  }

  // TODO: Add test for Node with no next or prev

  // TODO: Add at least one more test for list constructor that would be useful and cover new ground.
   @Test
  void testToListWithFiveValues() {
    Node head = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);

    head.next = n2;
    n2.prev = head;
    n2.next = n3;
    n3.prev = n2;
    n3.next = n4;
    n4.prev = n3;
    n4.next = n5;
    n5.prev = n4;

    List<Integer> values = head.toList();
    assertEquals(List.of(1, 2, 3, 4, 5), values);
  }
  @Test
void testToListWithNegativeAndZeroValues() {
    // Arrange: create a linked list manually
    Node head = new Node(-5);
    Node n2 = new Node(0);
    Node n3 = new Node(10);
    Node n4 = new Node(-3);

    // Link the nodes
    head.next = n2;
    n2.prev = head;
    n2.next = n3;
    n3.prev = n2;
    n3.next = n4;
    n4.prev = n3;

    // Act: convert linked list to a list of integers
    List<Integer> values = head.toList();

    // Assert: check that the list has the correct values in order
    assertEquals(List.of(-5, 0, 10, -3), values);
}
}
