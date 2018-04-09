import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Zhuang on 2018/4/9.
 */
public class LinkedListReverser {


    /**
     * Reverses a linked list
     *
     * @param head head the linked list to reverse
     * @return headof the reversed linked list
     */
    public Node reverseLinkedList(Node head) {
        if(head == null || head.getNext() == null)
            return head;

        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return newHead;
    }

    public static void main(String[] args) {
        LinckedListCreator creator = new LinckedListCreator();
        LinkedListReverser reverser  = new LinkedListReverser();

        Node.printLinkedList(reverser.reverseLinkedList(creator.createLinkedList(new ArrayList<Integer>())));
        Node.printLinkedList(reverser.reverseLinkedList(creator.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(reverser.reverseLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));


    }
}
