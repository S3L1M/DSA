import java.util.Random;

/*
 *  Created by Mohamed Selim
 *  GitHub: github.com/S3L1M
 */



 public class Main {

    public static void main(String[] args) {
        SortedList l = new SortedList();
        for(int i=0; i<15; i++) {

            Random rand = new Random();
            l.add(rand.nextInt(100));
            System.out.println(l);
            System.out.println("Size: " + l.size());
            System.out.println("Head: " + l.head);
            System.out.println("Mid: " + l.mid);
            System.out.println("Tail: " + l.tail);
        }
        
    }
}