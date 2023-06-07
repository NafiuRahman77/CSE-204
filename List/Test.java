public class Test {
    public static void main(String[] args) {
        Integer[] a={1};
       // LList<Integer> al=new LList<Integer>(3,4, a);
        AList<Integer> al=new AList<Integer>(1,2,a);



        Main.print(al);
        al.remove();
        Main.print(al);
        al.remove();
        Main.print(al);




    }
}
