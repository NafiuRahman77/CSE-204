class LQueue<E> implements Queue<E> {
    public Node<E> front; // Pointer to front queue node
    public Node<E> rear; // Pointer to rear queuenode
    private int size; // Number of elements in queue

    /**
     * Constructors
     */
    public LQueue() {
        init();
    }

    public LQueue(int size) {
        init();
    } // Ignore size

    /**
     * Initialize queue
     */
    private void init() {
        front = rear = new Node<E>(null);
        size = 0;
    }

    public void clear() {
        init();
    }

    /**
     * Put element on rear
     */
    public void enqueue(E it) {
        rear.setNext(new Node<E>(it, null));
        rear = rear.next();
        size++;
    }

    public E dequeue() {
        if(size==0){
            return null;
        }
        E it = front.next().element(); // Store dequeued value
        front.setNext(front.next().next()); // Advance front
        if (front.next() == null) {
            rear=front; // Last Object
            //System.out.println("if");
        }
        size--;
        return it; // Return Object
    }

    public E frontValue() {
       // assert size != 0 : "Queue is empty";
            if(size==0){
                return null;
            }
        return front.next().element();
    }
    public E rearValue() {
        if(this.length()==0){
            return null;
        }
        return rear.element();
    }

    public int length() {
        return size;
    }

    @Override
    public E leaveQueue() {
        if(size==0){
            return null;
        }
        Node<E> temp=front;
        ;
        while(true){
            if(temp.next()==rear){
                break;
            }
            temp=temp.next();
        }
        E it=rear.element();
        rear=temp;
        rear.setNext(null);
        size--;
        return it;
    }
}