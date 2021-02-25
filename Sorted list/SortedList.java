class SortedList implements SortedListInterface {  // Sorted in accending order
    final byte BEFORE_HEAD=0x01, MID_TO_HEAD=0x21, MID_TO_TAIL=0x23, AFTER_TAIL=0x34;

    // TODO set access modifiers of vars and funcs
    Node head=null, mid=null, tail=null;
    float midMovement = 0;
    private int size = 0;

    public SortedList() {}
    public SortedList(Comparable[] array) {
        for(Comparable c : array)
            add(c);
    }    


    private void push_back(Node node) {
        tail.linkNext(node);
        node.linkPrevious(tail);
        tail = node;
        midMovement += 0.5;
        size += 1;
        updateMidPos();
    }

    private void push_front(Node node) {
        node.linkNext(head);
        head.linkPrevious(node);
        head = node;
        midMovement -= 0.5;
        size += 1;
        updateMidPos();
    }

    private void insertBefore(Node node, Node beforeNode) {
        System.out.println("insertBefore "+ beforeNode.value);
        Node previousBeforeNode = beforeNode.getPrevious();
        node.link(previousBeforeNode, beforeNode);
        previousBeforeNode.linkNext(node);
        beforeNode.linkPrevious(node);
        midMovement = (node.value.compareTo(mid.value) > 0)? midMovement+0.5f : midMovement-0.5f;
        size += 1;
        updateMidPos();
    }
    
    private void insertAfter(Node node, Node afterNode) {
        System.out.println("insertAfter "+ afterNode.value);
        Node nextAfterNode = afterNode.getNext();
        node.link(afterNode, nextAfterNode);
        nextAfterNode.linkPrevious(node);
        afterNode.linkNext(node);
        midMovement = (node.value.compareTo(mid.value) > 0)? midMovement+0.5f : midMovement-0.5f;
        size += 1;
        updateMidPos();
    }

    private void updateMidPos() {
        if(midMovement == 1.0f) {
            System.out.println("Going to next");
            mid = mid.getNext();
            midMovement = 0;
        }
        else if(midMovement == -1.0f) {
            System.out.println("Going to previous");
            mid = mid.getPrevious();
            midMovement = 0;
        }
    }

    private byte findRange(Comparable value) {
        // TODO add else case to insert near head/tail
        if(value.compareTo(head.value) < 0) return BEFORE_HEAD;
        if(value.compareTo(tail.value) > 0) return AFTER_TAIL;
        if(value.compareTo(mid.value) < 0)
            return MID_TO_HEAD;
        else
            return MID_TO_TAIL;
    }

    @Override
    public void add(Comparable item) {
        Node entry = new Node(item);
        switch(size) {
            case 0:
                System.out.println("Case 0");
                head = mid = tail = entry;
                size = 1;
                break;

            case 1:
                System.out.println("Case 1");
                if(item.compareTo(head.value) >= 0) {
                    tail.linkNext(entry);
                    entry.linkPrevious(tail);
                    tail = entry;
                } else {
                    entry.linkNext(head);
                    head.linkPrevious(entry);
                    head = entry;
                }
                mid = head;
                size = 2;
                break;

            case 2:
                System.out.println("Case 2");
                if(item.compareTo(tail.value) >= 0) {
                    tail.linkNext(entry);
                    entry.linkPrevious(tail);
                    mid = tail;
                    tail = entry;
                }
                else if(item.compareTo(head.value) <= 0) {
                    entry.linkNext(head);
                    head.linkPrevious(entry);
                    mid = head;
                    head = entry;
                } else {
                    mid = entry;
                    mid.link(head, tail);
                }
                size = 3;
                break;
                
            default:
                System.out.println("Default");
                switch(findRange(item)) {
                    case MID_TO_HEAD:
                        System.out.println("Mid to Head");
                        Node ptr = mid;
                        while(ptr.toBoolean()) {
                            if(item.compareTo(ptr.value) >= 0) {
                                insertAfter(entry, ptr);
                                break;
                            }
                            ptr = ptr.getPrevious();
                        }
                        break;
                    case MID_TO_TAIL:
                        System.out.println("Mid to tail");
                        ptr = mid;
                        while(ptr.toBoolean()) {
                            if(item.compareTo(ptr.value) <= 0) {
                                insertBefore(entry, ptr);
                                break;
                            }
                            ptr = ptr.getNext();
                        }
                        break;
                    case AFTER_TAIL:
                        System.out.println("After tail");
                        push_back(entry);
                        break;
                    case BEFORE_HEAD:
                        System.out.println("Before head");
                        push_front(entry);
                }
        }
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
        if(head==null) return "[]";
        StringBuilder s = new StringBuilder("[");
        Node ptr = head;
        while(ptr.hasNext()) {
            s.append(ptr.toString()).append(", ");
            ptr = ptr.getNext();
        }
        s.append(tail.toString()).append("]");
        return s.toString();
    }
}
