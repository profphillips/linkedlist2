package linkedlist;

/**
 *
 * @author 55jphillip
 */
public class LinkedList {

    private Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int index, double data) {
        Link newLink = new Link(index, data);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link find(int key) {
        Link current = first;
        while (current.index != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;

        while (current.index != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        return current;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        Link current = first;

        while (current != null) {
            sb.append(current.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(1, 25.1);
        list.insertFirst(2, 39.2);
        list.insertFirst(3, 10.3);
        System.out.println(list);
        
        System.out.println("Match for item 4: " + list.find(4));
        
        list.delete(2);
        System.out.println(list);
    }
}
