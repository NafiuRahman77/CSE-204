import static java.lang.System.exit;

public class AList<E> implements List{

    private static final int defaultSize = 1; // Default size
    private int initialSize;
    private int maxSize; // Maximum size of list
    private int listSize; // Current # of list items
    private int curr; // Position of current element
    public E[] listArray; // Array holding list elements

    AList() {
        this(defaultSize);
    }

    AList(int size) {
        initialSize=size;
        maxSize = size;
        listSize = curr = 0;
        listArray = (E[])new Object[size]; // Create listArray
    }


    AList(int init ,int size, E[] temp) {
        initialSize=init;
        maxSize = size;
        listSize = temp.length;
        curr = 0;
        listArray = (E[])new Object[size]; // Create listArray
        for(int i=0; i<listSize; i++){
            listArray[i]=temp[i];
        }
    }

    AList(int init ,int size, List<E> temp) {
        initialSize=init;
        maxSize = size;
        listSize = temp.length();
        temp.moveToStart();
        curr = 0;
        listArray = (E[])new Object[size]; // Create listArray
        for(int i=0; i<listSize; i++){
            listArray[i]=temp.getValue();
            temp.next();
        }
    }

    @Override
    public void clear() {
        listSize = curr = 0;
    }

    @Override
    public void insert(Object item) {

        if(listSize==maxSize){

            E[] tempo=(E[])new Object[maxSize];
            maxSize=initialSize+maxSize;
            for(int i=0; i<listSize; i++){
                tempo[i]=listArray[i];
            }
            listArray=(E[])new Object[maxSize];
            for(int i=0; i<listSize; i++){
                listArray[i]=tempo[i];
            }

        }
       // assert listSize < maxSize : "List capacity exceeded";

        for (int i=listSize; i>curr; i--)  // Shift elements up
            {
            listArray[i] = listArray[i-1]; // to make room
        }

        listArray[curr] = (E) item;
        listSize++; // Increment list size

    }

    @Override
    public void append(Object item) {

        if(listSize ==maxSize){
            E[] tempo=(E[])new Object[maxSize];
            maxSize=initialSize+maxSize;
            for(int i=0; i<listSize; i++){
                tempo[i]=listArray[i];
            }
            listArray=(E[])new Object[maxSize];
            for(int i=0; i<listSize; i++){
                listArray[i]=tempo[i];
            }

        }
//        assert listSize < maxSize : "List capacity exceeded";
        listArray[listSize++] = (E) item;

    }

    @Override
    public E remove() {
        if(!((curr>=0) && (curr<listSize) )){
            exit(1);
        }
        E it = listArray[curr]; // Copy the element
        for(int i=curr; i<listSize-1; i++) // Shift them down
            listArray[i] = listArray[i+1];
        listSize--; // Decrement size
        if(listSize==curr){
            curr--;
        }
        return it;
    }

    @Override
    public void moveToStart() {
        curr = 0;
    }

    @Override
    public void moveToEnd() {
        curr = listSize-1;
    }

    @Override
    public void prev() {
        if (curr != 0) curr--;
    }

    @Override
    public void next() {
        if (curr < listSize - 1) curr++;
        else return;
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public int currPos() {
        return curr;
    }

    @Override
    public void moveToPos(int pos) {
        if(!((pos>=0) && (pos<listSize))){
            return;
        }
//        assert (pos>=0) && (pos<=listSize) : "Pos out of range";
        curr=pos;
    }

    @Override
    public Object getValue() {
        if(!((curr>=0) && (curr<listSize) )){
            exit(1);
        }
//        assert (curr>=0) && (curr<listSize) :
//                "No current element";
        return listArray[curr];
    }

    @Override
    public int Search(Object item) {
        for(int i=0; i<listSize; i++){
            if((E)item==listArray[i]){
                return 1;
            }
        }
        return -1;
    }


}
