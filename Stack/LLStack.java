public class LLStack <E> implements Stack{
    private Node<E> top; // Pointer to first element
    private int size; // Number of elements
    /** Constructors */
    public void LLStack() { top = null; size = 0; }
    public void LLStack(int size) { top = null; size = 0; }

    /** Reinitialize stack */
    public void clear() { top = null; size = 0; }

    /** Put "it" on stack
     * @param it*/
    public void push(Object it) {
        top = new Node<E>((E) it, top);
        size++;
    }
    /** Remove "it" from stack */
    public E pop() {
        if(this.length()==0){
            System.out.println("Stack is empty");
        }
        E it = top.element();
        top = top.next();
        size--;
        return it;
    }
    /** @return Top value */
    public E topValue() {
     //   assert top != null : "Stack is empty";
        if(this.length()==0){
            return null;
        }
        return top.element();
    }
    /** @return Stack length */
    public int length() { return size; }
}
