class SortedList implements SortedListInterface {  // Sorted in accending order
    Node head=null, mid=null, tail=null;
    private int size = 0;

    public SortedList() {}

    @Override
    public void add(Comparable item) {
        
    }

    @Override
    public Comparable least() {
        return head.value;
    }

    @Override
    public Comparable greatest() {
        return tail.value;
    }

    @Override
    public Comparable get(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int indexOf(Comparable item) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void remove(int i) {
        // TODO Auto-generated method stub

    }

    @Override
    public SortedList searchRange(Comparable from, Comparable to) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        String s = "[";
        Node ptr = head;
        while(ptr.hasNext()) {
            s = s.concat(ptr.toString().concat(", "));
            ptr = ptr.getNext();
        }
        s = s.concat(tail.toString().concat("]"));
        return s;
    }
}
