interface SortedListInterface<T extends Comparable<T>> {
    void add(T item); // add a new item to the List
    T least(); // return the least element
    T greatest(); // return the greatest element
    T get(int i); // return the i-th least element
    int indexOf(T item); // return the index of an element (in a sorted sequence)
    void remove(int i); // remove i-th least element from the list
    SortedListInterface<T> searchRange(T from, T to); // find all items between from and to
    int size(); // return the size of the list
    boolean isEmpty(); // return whether the list is empty
}