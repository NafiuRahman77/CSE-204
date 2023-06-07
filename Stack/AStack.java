import static java.lang.System.exit;

public class AStack <E> implements Stack{
    private static final int defaultSize = 10;
    private int maxSize; // Maximum size of stack
    private int top; // Index for top Object
    private int direction;
    private E [] listArray; // Array holding stack
    /** Constructors */
    AStack() { this(defaultSize); }
    @SuppressWarnings("unchecked") // Generic array allocation
    AStack(int size) {
        maxSize = size;
        top = 0;
        listArray = (E[])new Object[size]; // Create listArray
        direction=1;
    }
    AStack(int size, int dir) {
        maxSize = size;
        direction=dir;
        if(dir==1){
            top = 0;
        }
        else{
            top=size-1;
        }
        listArray = (E[])new Object[size]; // Create listArray
    }
    AStack(E[] array, int dir) {
        listArray=array; // Create listArray
        maxSize=array.length;
        direction=dir;
        if(dir==1){
            top = 0;
        }
        else{
            top=listArray.length-1;
        }
    }
    /** Reinitialize stack */
    @Override
    public void clear() {
        if(direction==1){
            top = 0;
        }
        else{
            top=maxSize-1;
        }
    }
    /** Push "it" onto stack
     * @param it*/
    @Override
    public void push(Object it) {
       // assert top != maxSize : "Stack is full";
        if(direction==1){
            if(top==maxSize-1){
                E[] tempo=(E[])new Object[maxSize];
                maxSize=2*maxSize;
                int listSize= listArray.length;
                for(int i=0; i< listSize; i++){
                    tempo[i]=listArray[i];
                }

                listArray=(E[])new Object[maxSize];
                for(int i=0; i<listSize; i++){
                    listArray[i]=tempo[i];
                }
            }
            listArray[top++] = (E) it;
        }
        else{
            if(top==0){
                E[] tempo=(E[])new Object[maxSize];
                maxSize=2*maxSize;
                int listSize= listArray.length-1;
                int t=listSize;
                for(int i=0; i< listSize; i++){
                    tempo[i]=listArray[t];
                    t--;
                }
                int j=listSize,k=maxSize-1;
                listArray=(E[])new Object[maxSize];
                for(int i=0; i<listSize; i++){
                    listArray[k]=tempo[i];
                    k--;
                }
                top=maxSize-listSize-1;
            }
            listArray[top--] = (E) it;
        }

    }
    /** Remove and top element */
    @Override
    public E pop() {
       // assert top != 0 : "Stack is empty";
        if(direction==1){
            if(top==0){
                return null;

            }
            return listArray[--top];
        }
        else{
            if(top==maxSize-1){
                return null;

            }
            return listArray[++top];
        }

    }
    /** @return Top element */
    @Override
    public E topValue() {
       // assert top != 0 : "Stack is empty";
        if(direction==1){
            if(this.length()==0){
                return null;
            }
            return listArray[top-1];

        }
        else{
            if(this.length()==0){
              return null;
            }
            return listArray[top+1];
        }
    }
    /** @return Stack size */
    @Override
    public int length() {

        if(direction==1){
            return top;

        }
        else{
            return maxSize-top-1;
        }
    }
    public void setDirection(int dir){
        if((dir==1&&direction==1)||(dir==-1&&direction==-1)){
            return;
        }
        else if(this.length()==0){
            direction=dir;
        }
        else if(this.length()>0){
            System.out.println("Can't change direction of a non empty stack");
        }

//        else if(dir==1&&direction==-1){
//            E[] tempo=(E[])new Object[maxSize];
//            int i=0;
//            while(true){
//                if(top==maxSize-1){
//                    break;
//                }
//                tempo[i]= this.pop();
//                i++;
//            }
//            listArray= (E[]) new Object[maxSize];
//            int k=i-1;
//            for(int j=0; j<=i-1 ;j++){
//                listArray[j]=tempo[k];
//                k--;
//
//            }
//            top=i;
//            direction=1;
//
//        }
//        else if(dir==-1&&direction==1){
//            E[] tempo=(E[])new Object[maxSize];
//            int i=0;
//            while(true){
//                if(top==0){
//                    break;
//                }
//                E p=this.pop();
////                System.out.println(p);
//                tempo[i]= p;
//                i++;
//            }
//            listArray= (E[]) new Object[maxSize];
//            int k=i-1;
//
//            for(int j=maxSize-1; j>=maxSize-i ;j--){
////                System.out.println(j);
////                System.out.println(k);
//                listArray[j]=tempo[k];
//                k--;
//
//            }
//            top=maxSize-i-1;
//            direction=-1;
//
//        }
    }


}
