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

    public void push(double data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
    }

    public Link pop() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link peek() {
        return first;
    }

    public Link find(double key) {
        Link current = first;
        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int index) {
        Link current = first;
        Link previous = first;

        if (!isEmpty()) {
            int count = 0;
            while (count != index) {
                if (current.next == null) {
                    return null;
                } else {
                    previous = current;
                    current = current.next;
                }
                count++;
            }

            if (current == first) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
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
        list.push(25.1);
        list.push(39.2);
        list.push(10.3);
        System.out.println(list);
        
        System.out.println("Peek = " + list.peek());

        System.out.println("Match for item 25.1: " + list.find(25.1));
        System.out.println("Match for item 39.2: " + list.find(39.2));
        System.out.println("Match for item 10.3: " + list.find(10.3));
        System.out.println("Match for item 0: " + list.find(0));
        
        Link link = list.pop();
        System.out.println("Pop = " + link);
        System.out.println(list);

        if (list.delete(0) != null) {
            System.out.println("Item deleted\n" + list);
        } else {
            System.out.println("Null value on delete");
        }

//        if (list.delete(0) != null) {
//            System.out.println("Item deleted\n" + list);
//        } else {
//            System.out.println("Null value on delete");
//        }
//
//        if (list.delete(0) != null) {
//            System.out.println("Item deleted\n" + list);
//        } else {
//            System.out.println("Null value on delete");
//        }
//
//        if (list.delete(0) != null) {
//            System.out.println("Item deleted\n" + list);
//        } else {
//            System.out.println("Null value on delete");
//        }
    }
}
