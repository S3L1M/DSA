public class Main {

    public static void main(String[] args) {
        Node n = new Node(1);
        n.linkNext(new Node(2));
        System.out.println(n.hasNext()? n.getNext():"None");
    }
}