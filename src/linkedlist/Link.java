package linkedlist;

/**
 * Represents a single link object.
 *
 * @author 55jphillip
 */
public class Link {

    public int index;
    public double data; // can replace this with any kind of object
    public Link next;

    public Link(int index, double data) {
        this.index = index;
        this.data = data;
        this.next = null;
    }

    public String toString() {
        return index + ", " + data;
    }
}
