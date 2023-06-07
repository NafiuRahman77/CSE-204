import java.util.ArrayList;

class AQueue<E> implements Queue<E> {
    private static final int defaultSize = 10;
    private int maxSize; // Maximum size of queue
    private int front; // Index of front element
    private int rear; // Index of rear element
    private int size;
    private E[] listArray; // Array holding queue elements

    /**
     * Constructors
     */
    AQueue() {
        this(defaultSize);
    }

    @SuppressWarnings("unchecked")
        // For generic array
    AQueue(int size) {
        maxSize = size + 1; // One extra space is allocated
        rear = 0;
        front = 1;
        this.size=0;
        listArray = (E[]) new Object[maxSize]; // Create listArray
    }
    AQueue(E[] array) {
        maxSize = size + 1; // One extra space is allocated
        rear = 0;
        front = 1;
        this.size=0;
        listArray = array; // Create listArray
    }

    public void clear() {
        rear = 0;
        front = 1;
        listArray = (E[]) new Object[maxSize];
        size=0;
    }

    /**
     * Put "it" in queue
     */
    public void enqueue(E it) {
     //   assert ((rear + 2) % maxSize) != front : "Queue is full";
        if(!(((rear + 2) % maxSize) != front)){
           // System.out.println("in if");
           // System.out.println(this.length());
            ArrayList<E> arr=new ArrayList<E>();
            while(this.length()!=0){
               // System.out.println(this.length());
                E temp=this.dequeue();
                arr.add(temp);

            }

            maxSize=2*maxSize+1;
            listArray= (E[]) new Object[maxSize];

            rear=0;
            front=1;
            for(int i=0;i<arr.size();i++){
                rear = (rear + 1) % maxSize; // Circular increment
                listArray[rear] = arr.get(i);
            }
            rear = (rear + 1) % maxSize; // Circular increment
            listArray[rear] = it;
          //  System.out.println(this.length());
            size++;

        }
        else {
            rear = (rear + 1) % maxSize; // Circular increment
            listArray[rear] = it;
            size++;
        }
    }

    public E dequeue() {
  //      assert length() != 0 : "Queue is empty";
        if(this.length()==0){
            return null;
        }
        E it = listArray[front];
        listArray[front]=null;
        front = (front + 1) % maxSize; // Circular increment
        size--;
        return it;
    }

    public E frontValue() {
      //  assert length() != 0 : "Queue is empty";
        if(this.length()==0){
            return null;
        }
        return listArray[front];
    }

    @Override
    public E rearValue() {
        if(this.length()==0){
            return null;
        }
        return listArray[rear];
    }

    public int length() {
        return ((rear + maxSize) - front + 1) % maxSize;
    }

    @Override
    public E leaveQueue() {
        if(this.length()==0){
            return null;
        }
        E it=listArray[rear];
        listArray[rear]=null;
        rear = (rear+ maxSize - 1) % maxSize;
        size--;

       // System.out.println("rear "+rear);
        return it;

    }
}