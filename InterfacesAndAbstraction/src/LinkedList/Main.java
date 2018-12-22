package LinkedList;

public class Main {
    public static void main(String[] args) {
        SearchTree list = new SearchTree(null);
//        MyLinkedList list = new MyLinkedList(null);
//        list.traverse(list.getRoot());

        String stringData = "RlNagar NfcNagar KVSchool Geetanjali IndependaceDay BirthDay White Honey";
        String[] data = stringData.split(" ");
        for (String str : data) {
            list.addItem(new Node(str));
        }
//        list.traverse(list.getRoot());

//        list.removeItem(new Node("BirthDay"));
        list.addItem(new Node("RlNagar"));
        list.addItem(new Node("B1"));
        list.traverse(list.getRoot());


        System.out.println();
//        list.addItem(new Node("B1"));
//        list.traverse(list.getRoot());
    }
}
