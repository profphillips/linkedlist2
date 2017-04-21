package linkedlist2;

/**
 * Implements a doubly linked list.
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
        System.out.println("isEmpty first is " + first + " length="+length);
        return (first == null);
        //return (length == 0);
    }

    public void append(Friend data) {
        Link newLink = new Link(data);
        
        System.out.println("list is " + this.toString());
        if (isEmpty()) {
            first = newLink;
        } else {
            newLink.next = null;
            newLink.previous = last;
            last.next = newLink;
        }
        last = newLink;
        length++;
    }

    public void push(Friend data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            last = newLink;
        } else {
            newLink.next = first;
            newLink.previous = null;
            first.previous = newLink;
        }
        first = newLink;
        length++;
    }

    public Link pop() {
        System.out.println("pop start: is empty is " + isEmpty() + " first is " + first);
        if (length > 0) {
            Link temp = first;
            first = first.next;
            if (first == null) {
                last = null;
            } else {
                first.previous = null;
            }
            length--;
            return temp;
        }
        System.out.println("pop end: is empty is " + isEmpty() + " first is " + first);
        return null;
    }

    public Link peek() {
        return first;
    }

    public Link remove() {
        System.out.println("remove start: is empty is " + isEmpty() + " first is " + first);
        if (length > 0) {
            Link temp = last;
            last = last.previous;
            
            if (last != null) {
                last.next = null;
            } 
            length--;
            return temp;
        }
        System.out.println("remove end: is empty is " + isEmpty() + " first is " + first);
        return null;
    }

    public Link find(String key) {
        Link current = first;
        if (!isEmpty()) {
            while (!current.data.getName().equalsIgnoreCase(key)) {
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
System.out.println("delete start: is empty is " + isEmpty() + " first is " + first);
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
            } else if (current == last) {
                last = current.previous;
                last.next = null;
            } else {
                System.out.println("Deleting : " + current);
                System.out.println("n = " + length);
                System.out.println("Last = " + last);
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
            length--;
        }
        System.out.println("delete end: is empty is " + isEmpty() + " first is " + first);
        return current;
    }

    public Friend[] toArray() {
        Friend[] friends = new Friend[length];
        Link current = first;
        for (int count = 0; current != null; count++) {
            friends[count] = current.data;
            current = current.next;
        }
        return friends;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        Link current = first;
        int index = 0;
        while (current != null) {
            sb.append(index).append(":").append(current.toString()).append("\n");
            current = current.next;
            index++;
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

        list.push(new Friend("Tom", 5));
        list.push(new Friend("Mary", 7));
        list.push(new Friend("Steve", 6));
        System.out.println(list);
        System.out.println("Length is " + list.length);

        Link gone = list.delete(1);
        System.out.println("is empty is " + list.isEmpty() + " first is " + list.first);
        if (gone != null) {
            System.out.println("Item deleted is " + gone);
        } else {
            System.out.println("Null value on delete");
        }

        gone = list.delete(1);

        if (gone != null) {
            System.out.println("Item deleted is " + gone);
        } else {
            System.out.println("Null value on delete");
        }

        gone = list.delete(0);
;
        if (gone != null) {
            System.out.println("Item deleted is " + gone);
        } else {
            System.out.println("Null value on delete");
        }

        gone = list.delete(2);

        if (gone != null) {
            System.out.println("Item deleted is " + gone);
        } else {
            System.out.println("Null value on delete");
        }

        list.push(new Friend("Tom", 5));
        list.push(new Friend("Mary", 7));
        list.push(new Friend("Steve", 6));
        System.out.println(list);
        System.out.println("Length is " + list.length);

        gone = list.remove();

        if (gone != null) {
            System.out.println("Item deleted is " + gone);
        } else {
            System.out.println("Null value on delete");
        }

        gone = list.remove();

        if (gone != null) {
            System.out.println("Item deleted is " + gone);
        } else {
            System.out.println("Null value on delete");
        }

        gone = list.remove();

        if (gone != null) {
            System.out.println("Item deleted is " + gone);
        } else {
            System.out.println("Null value on delete");
        }

        gone = list.remove();

        if (gone != null) {
            System.out.println("Item deleted is " + gone);
        } else {
            System.out.println("Null value on delete");
        }

        System.out.println("Testing append...");

        System.out.println("length=" + list.length);
        list.append(new Friend("Tom", 5));
        list.append(new Friend("Mary", 7));
        list.append(new Friend("Steve", 6));
        System.out.println(list);
        System.out.println("Length is " + list.length);
    }
}
