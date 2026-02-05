import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Node in a doubly linked list.
 */
public class Node {
  /** The value stored in this node. */
  public int value;

  /** The previous node in the linked list. */
  public Node prev;

  /** The next node in the linked list. */
  public Node next;

  /**
   * Creates a single node with the specified value.
   * prev and next are kept as null.
   *
   * @param value The value to store in this node.
   */
  public Node(int value) {
    this.value = value;
  }

  /**
   * Creates a doubly linked list from the given list of integers.
   * The head of the list will be the constructed Node.
   * 
   * For example, if there were the list:
   * [5, 7, 3]
   * 
   * Then the linked list that would be created would be:
   * 5 <-> 7 <-> 3
   * And this node would be the head, holding a value of 5.
   *
   * @param list The list of integers to initialize the doubly linked list.
   * @throws IllegalArgumentException If the list is null or empty.
   */
  public Node(List<Integer> list) {
    // TODO: implement this
     if (list == null || list.isEmpty()) {
      throw new IllegalArgumentException("List should not bw empty or null");
    }
    // set the head value
    this.value = list.get(0);
    
    Node current = this;
    int i = 1; //start at index 1

    // loop over the list
    while (i < list.size()) {
      // make a new node from the current value
      Node newNode = new Node(list.get(i));

      // the current nodes next is the new node
      current.next = newNode;
      // the new nodes previous is the current 
      newNode.prev = current;

      // currrent becomes the new node
      current = newNode;

      i++;
    }
  }

  /**
   * Converts the linked list starting from this node into a list of integers.
   * Treats this node as the head, even if it has a previous value.
   *
   * @return A list of integers representing the values in the linked list.
   */
  public List<Integer> toList() {
    // TODO: Implement this
    // Used ArrayList Option
  List<Integer> result = new ArrayList<>();

    // the node starts at this
    Node walker = this;
    // while loop moves throught the pointers
    while(walker != null) {
      // add the current node to the list
      result.add(walker.value);
      // moves to the next node
      walker = walker.next;
    }
    return null;
  }
}
