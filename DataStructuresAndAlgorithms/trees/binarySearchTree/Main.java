package trees.binarySearchTree;

public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(22);
        tree.insert(-1);
        tree.insert(23);
        tree.insert(45);
        tree.insert(9);
        tree.insert(0);
        tree.insert(0);
        tree.insert(22);
        tree.insert(526);
        tree.insert(8);

        tree.InOrder();

        System.out.println("Got 22 :" + tree.get(22));
        System.out.println("Got 444 :" + tree.get(444));
        System.out.println("Got 0 :" + tree.get(0));

        System.out.println("Min : "+tree.min());
        System.out.println("Max : "+tree.max());

    }
}
