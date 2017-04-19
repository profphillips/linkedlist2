package linkedlist;

/**
 *
 * @author 55jphillip
 */
public class LinkedList {

    private Link first;
    private Link last;
    public int length;

    public LinkedList() {
        first = null;
        last = null;
        length = 0;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void push(Friend data) {
        Link newLink = new Link(data);
        newLink.next = first;
        newLink.previous = null;
        if (first != null) {
            first.previous = newLink;
        }
        first = newLink;
        length++;
    }

    public Link pop() {
        if (length > 0) {
            Link temp = first;
            first = first.next;
            if (first != null) {
                first.previous = null;
            }
            length--;
            return temp;
        }
        return null;
    }

    public Link peek() {
        return first;
    }

    public Link remove() {
        if (length > 0) {
            Link temp = last;
            last = last.previous;
            if (last != null) {
                last.next = null;
            }
            length--;
            return temp;
        }
        return null;
    }

    public Link find(String key) {
        Link current = first;
        if (!isEmpty()) {
            while (current.data.getName() != key) {
                if (current.next == null) {
                    return null;
                } else {
                    current = current.next;
                }
            }
        }
        return current;
    }

    public Link delete(int index) {
        Link current = first;
        Link prev = first;

        if (!isEmpty()) {
            int count = 0;
            while (count != index) {
                if (current.next == null) {
                    return null;
                } else {
                    prev = current;
                    current = current.next;
                }
                count++;
            }

            if (current == first) {
                first = first.next;
                if (first != null) {
                    first.previous = null;
                }
                last = first;
            } else if (current == last) {
                Link temp = null; // fix
            } else if (current.next != null) {

                current.next.previous = prev;
                prev.next = current.next;
            }
            length--; // fix later
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
        list.push(new Friend("Tom", 5));
        list.push(new Friend("Mary", 7));
        list.push(new Friend("Steve", 6));
        System.out.println(list);
        System.out.println("Length is " + list.length);

        System.out.println("Peek = " + list.peek());

        System.out.println("Match for item Tom: " + list.find("Tom"));
        System.out.println("Match for item Mary: " + list.find("Mary"));
        System.out.println("Match for item Steve: " + list.find("Steve"));
        System.out.println("Match for item Mark: " + list.find("Mark"));

        Link link = list.pop();
        System.out.println("Pop = " + link);
        System.out.println(list);
        link = list.pop();
        System.out.println("Pop = " + link);
        System.out.println(list);
        link = list.pop();
        System.out.println("Pop = " + link);
        System.out.println(list);
        link = list.pop();
        System.out.println("Pop = " + link);
        System.out.println(list);

//        if (list.delete(0) != null) {
//            System.out.println("Item deleted\n" + list);
//        } else {
//            System.out.println("Null value on delete");
//        }
    }
}
