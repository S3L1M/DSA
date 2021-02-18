class Node {
    Comparable value;
    private Node prev = null, next = null;
    private boolean hasPrev = false, hasNext = false;

    public Node() {
        // empty node
        value = null;
    }

    public Node(Comparable valueComparable) {
        value = valueComparable;
    }

    public Node(Comparable valueComparable, Node previous) {
        value = valueComparable;
        prev = previous;
    }

    public Node(Comparable valueComparable, Node previous, Node next) {
        value = valueComparable;
        prev = previous;
        this.next = next;
    }


    public Node getPrevious() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public void linkPrevious(Node previous) {
        prev = previous;
        hasPrev = true;
    }

    public void linkNext(Node next) {
        this.next = next;
        hasNext = true;
    }

    public void link(Node previous, Node next) {
        prev = previous;
        this.next = next;
        hasPrev = true;
        hasNext = true;
    }

    public Node unlinkPrevious() {
        Node tmp = prev;
        prev = null;
        hasPrev = false;
        return tmp;
    }

    public Node unlinkNext() {
        Node tmp = next;
        next = null;
        hasNext = false;
        return tmp;
    }

    public void unlink() {
        prev = null;
        next = null;
        hasPrev = false;
        hasNext = false;
    }

    public boolean hasPrevious() {
        return hasPrev;
    }

    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
