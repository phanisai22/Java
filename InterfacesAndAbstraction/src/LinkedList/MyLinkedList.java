package LinkedList;

public class MyLinkedList implements NodeList {

    private ListItem root ;

    MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {

        if (this.root == null) {
            // The list is empty, the root is the item itself .
            this.root = item;
            return true;
        } else {
            ListItem currentItem = this.root;
            while (currentItem != null) {
                int comparison = (currentItem.compareTO(item));
                if (comparison < 0) {
                    // New item is greater than the current item( move right ) .
                    if (currentItem.next() != null) {
                        currentItem = currentItem.next();
                    } else {
                        // there is no next ( insert at the end ) .
                        currentItem.setNext(item);
                        item.setPrevious(currentItem);
                        return true;
                    }
                } else if (comparison > 0) {
                    // New item is less than the current item( move left) .
                    if (currentItem.previous() != null) {
                        currentItem.previous().setNext(item);
                        item.setPrevious(currentItem.previous());
                        item.setNext(currentItem);
                        currentItem.setPrevious(item);
                    } else {
                        // The current item is root .
                        item.setNext(currentItem);
                        currentItem.setPrevious(item);
                        this.root = item;
                    }
                    return true;
                } else {
                    // comparision = 0 (ie) they are equal .
                    System.out.println(item.getValue() + " is already in the list .");
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (this.root == null) {
            System.out.println("The list is empty to delete the item .");
        } else {
            System.out.println("Deleting item "+item.getValue());

            ListItem currentItem = this.root;

            while (currentItem != null) {
                int comparision = currentItem.compareTO(item);
                if (comparision == 0) {
                    // Found the item to delete .
                    if (currentItem == this.root) {
                        this.root = currentItem.next();
                        this.root.previous().setNext(null);
                    } else {
                        currentItem.previous().setNext(currentItem.next());
                        if (currentItem.next() != null) {
                            currentItem.next().setPrevious(currentItem.previous());
                        }
                    }
                    return true;
                } else if (comparision < 0) {
                    currentItem = currentItem.next();
                } else {
                    // comparison > 0
                    // We are at the item greater than the one to be deleted .
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty .");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }

}