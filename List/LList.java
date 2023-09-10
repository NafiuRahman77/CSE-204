public class LList<E> implements List {
    private Node<E> headptr; // headptrer
    private Node<E> tailptr; // last element
    private Node<E> currptr; // currptrent element pointer
    private int cnt;

    LList() {
        currptr = tailptr = headptr = new Node<E>(null); // Create headptrer
        cnt = 0;
    }

    LList(E[] temp) {
        currptr = tailptr = headptr = new Node<E>(null); // Create headptrer
        for (int i = 0; i < temp.length; i++) {
            this.append(temp[i]);
        }
    }

    LList(int init, int size, E[] temp) {
        currptr = tailptr = headptr = new Node<E>(null); // Create headptrer
        for (int i = 0; i < temp.length; i++) {
            this.append(temp[i]);
        }
    }

    LList(int init, int size, List<E> temp) {
        temp.moveToStart();
        currptr = tailptr = headptr = new Node<E>(null); // Create headptrer
        for (int i = 0; i < temp.length(); i++) {
            this.append(temp.getValue());
            temp.next();
        }
    }

    @Override
    public void clear() {
        headptr.setNext(null); // Drop access to Nodes
        currptr = tailptr = headptr = new Node<E>(null); // Create headptrer
        cnt = 0;

    }

    @Override
    public void insert(Object item) {
        currptr.setNext(new Node<E>((E) item, currptr.next()));
        if (tailptr == currptr) {
            tailptr = currptr.next(); // New tailptr
        }
        cnt++;
    }

    @Override
    public void append(Object item) {
        tailptr = tailptr.setNext(new Node<E>((E) item, null));
        cnt++;
    }

    @Override
    public Object remove() {
        if (currptr.next() == null || headptr.next() == null) {
            return null; // Nothing to remove
        }
        E it = currptr.next().element(); // Remember value
        if (tailptr == currptr.next()) { // If the currptr points to last element

            if (headptr == currptr) {
                cnt--;
                headptr.setNext(null); // Drop access to Nodes
                currptr = tailptr = headptr = new Node<E>(null);
                return it;
            }
            Node<E> temp = headptr;
            Node<E> temp2 = headptr;
            while (temp.next() != currptr) {
                temp = temp.next();
            }
            currptr = temp;
            while (temp2.next() != tailptr) {
                temp2 = temp2.next();
            }
            tailptr = temp2;
            cnt--; // Decrement count
            return it;
        }
        currptr.setNext(currptr.next().next()); // Remove from list
        cnt--; // Decrement count
        return it;
    }

    @Override
    public void moveToStart() {
        currptr = headptr;
    }

    @Override
    public void moveToEnd() {

        Node<E> temp = headptr;
        // March down list until we find the last element
        while (temp.next() != tailptr) {
            temp = temp.next();
        }
        currptr = temp;
    }

    @Override
    public void prev() {
        if (currptr == headptr) {
            return; // No previous element
        }
        Node<E> tempo = headptr;
        // March down list until we find the previous element
        while (tempo.next() != currptr) {
            tempo = tempo.next();
        }
        currptr = tempo;
    }

    @Override
    public void next() {
        if (currptr.next() != tailptr) {
            currptr = currptr.next();
        } else {
            return;
        }

    }

    @Override
    public int length() {
        return cnt;
    }

    @Override
    public int currPos() {
        Node<E> temp = headptr;
        int i;
        for (i = 0; currptr != temp; i++)
            temp = temp.next();
        return i;
    }

    @Override
    public void moveToPos(int pos) {
        if (!((pos >= 0) && (pos < cnt))) {
            return;
        }

        // assert (pos>=0) && (pos<=cnt) : "Position out of range";
        currptr = headptr;
        for (int i = 0; i < pos; i++) {
            currptr = currptr.next();
        }
    }

    @Override
    public Object getValue() {
        if (currptr.next() == null) {
            return null;
        }
        return currptr.next().element();
    }

    @Override
    public int Search(Object item) {
        Node<E> temp = headptr;
        for (int i = 0; i < cnt; i++) {
            temp = temp.next();
            if (temp.element() == item) {
                return 1;
            }

        }
        return -1;
    }

}
