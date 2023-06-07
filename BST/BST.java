class BST<Key extends Comparable<? super Key>, E> {

    private BSTNode<Key, E> root; // Root of the BST
    //private int nodecount; // Number of nodes in the BST

    BST() {
        root = null;
        //nodecount = 0;
    }

    public void clear() {
        root = null;
        //nodecount = 0;
    }

    public void insert(Key k, E e) {
        root = inserthelp(root, k, e);
        //nodecount++;
    }

    private BSTNode<Key, E> inserthelp(BSTNode<Key, E> rt, Key k, E e) {
        if (rt == null) return new BSTNode<Key, E>(k, e);
        if (rt.key().compareTo(k) > 0)
            rt.setLeft(inserthelp(rt.left(), k, e));
        else
            rt.setRight(inserthelp(rt.right(), k, e));
        return rt;
    }


    private BSTNode<Key, E> getmax(BSTNode<Key, E> rt) {
        if (rt.right() == null) return rt;
        return getmax(rt.right());
    }

    private BSTNode<Key, E> deletemax(BSTNode<Key, E> rt) {
        if (rt.right() == null) return rt.left();
        rt.setRight(deletemax(rt.right()));
        return rt;
    }

    public E remove(Key k) {
        E temp = findhelp(root, k); // First find it

        if (temp == null) {
            return null;
        }
        if (temp != null) {
            root = removehelp(root, k); // Now remove it
            // nodecount--;
        }
        return temp;
    }


    private BSTNode<Key, E> removehelp(BSTNode<Key, E> rt, Key k) {
        if (rt == null) return null;
        if (rt.key().compareTo(k) > 0)
            rt.setLeft(removehelp(rt.left(), k));
        else if (rt.key().compareTo(k) < 0)
            rt.setRight(removehelp(rt.right(), k));
        else { // Found it
            if (rt.left() == null) return rt.right();
            else if (rt.right() == null) return rt.left();
            else { // Two children
                BSTNode<Key, E> temp = getmax(rt.left());
                rt.setElement(temp.element());
                rt.setKey(temp.key());
                rt.setLeft(deletemax(rt.left()));
            }
        }
        return rt;
    }

    public E find(Key k) {
        return findhelp(root, k);
    }

    private E findhelp(BSTNode<Key, E> rt, Key k) {
        if (rt == null) return null;
        if (rt.key().compareTo(k) > 0)
            return findhelp(rt.left(), k);
        else if (rt.key().compareTo(k) == 0) return rt.element();
        else return findhelp(rt.right(), k);
    }


    public void preorder() {
        preorderhelp(root);
        System.out.println("");
    }

    private void preorderhelp(BSTNode<Key, E> rt) {
        if (rt == null) return; // Empty subtree - do nothing
        System.out.print(rt.element() + " ");

        preorderhelp(rt.left()); // Process all nodes in left
        preorderhelp(rt.right()); // Process all nodes in right
    }

    public void inorder() {
        inorderhelp(root);
        System.out.println("");
    }

    private void inorderhelp(BSTNode<Key, E> rt) {
        if (rt == null) return; // Empty subtree - do nothing
        inorderhelp(rt.left()); // Process all nodes in left
        System.out.print(rt.element() + " ");
        inorderhelp(rt.right()); // Process all nodes in right
    }

    public void postorder() {
        postorderhelp(root);
        System.out.println("");
    }

    private void postorderhelp(BSTNode<Key, E> rt) {
        if (rt == null) return; // Empty subtree - do nothing
        postorderhelp(rt.left()); // Process all nodes in left
        postorderhelp(rt.right()); // Process all nodes in right
        System.out.print(rt.element() + " ");

    }

    public void print() {
        StringBuilder str = new StringBuilder("");
        printhelp(root, str);
        System.out.println(str);
    }

    private void printhelp(BSTNode<Key, E> rt, StringBuilder str) {
        if (rt == null) return;

        str = str.append(new StringBuilder(String.valueOf(rt.element())));

        if (rt.left() == null && rt.right() == null) {
            //System.out.println(str);
            return;
        }
        str = str.append(new StringBuilder("("));
        printhelp(rt.left(), str);
        str = str.append(new StringBuilder(")"));

        str = str.append(new StringBuilder("("));
        printhelp(rt.right(), str);
        str = str.append(new StringBuilder(")"));


    }

}