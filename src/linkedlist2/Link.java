package linkedlist2;

/**
 * Represents a single link object.
 *
 * @author 55jphillip
 */
public class Link {

    public Friend data; // can replace this with any kind of object
    public Link next;
    public Link previous;

    public Link(Friend data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public String toString() {
        return data.toString();
    }
}
