/*
 *  Created by Mohamed Selim
 *  GitHub: github.com/S3L1M
 */

public class Main {

    public static void main(String[] args) {
        SortedList l = new SortedList();
        
        Integer[] x = {5, 4, 9, 4, 0, 4, 2, 1, 5, 6};
        for(Integer a : x) {
            System.out.println(a);
            l.add(a);
            System.out.println(l);
            System.out.println("Size: " + l.size());
            System.out.println("Head: " + l.head);
            System.out.println("Mid: " + l.mid);
            System.out.println("Tail: " + l.tail);
        }
        
    }
}