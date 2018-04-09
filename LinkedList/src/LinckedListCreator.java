import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhuang on 2018/4/9.
 */
public class LinckedListCreator {

    /**
     * Craetes a linked list.
     *
     * @param data the data to create the list
     * @return head of the linked list.The returned linked list
     * ends with last node width getNext() == null.
     */
    public Node createLinkedList(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }

        Node firstNode = new Node(data.get(0));
        Node headOfSublist = createLinkedList(data.subList(1, data.size()));
        firstNode.setNext(headOfSublist);
        return firstNode;
    }

    public static void main(String[] args) {
        LinckedListCreator creator = new LinckedListCreator();

        Node.printLinkedList(creator.createLinkedList(new ArrayList<Integer>()));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));


    }
}
