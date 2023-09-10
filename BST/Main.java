import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        File file = new File("src/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String[] s = new String[2];

        while ((st = br.readLine()) != null) {

            s = st.split(" ");

            if (s[0].equals("F")) {
                Integer i = bst.find(Integer.valueOf(s[1]));
                if (i == null) {
                    System.out.println("False");
                } else {
                    System.out.println("True");
                }
            }

            else if (s[0].equals("I")) {

                bst.insert(Integer.valueOf(s[1]), Integer.valueOf(s[1]));
                bst.print();
            }

            else if (s[0].equals("T")) {

                if (s[1].equals("Pre")) {
                    bst.preorder();
                } else if (s[1].equals("In")) {
                    bst.inorder();
                } else if (s[1].equals("Post")) {
                    bst.postorder();
                }
            } else if (s[0].equals("D")) {

                if (bst.find(Integer.valueOf(s[1])) == null) {
                    System.out.println("Invalid Operation");
                } else {
                    bst.remove(Integer.valueOf(s[1]));
                    bst.print();
                }
            }
        }
    }
}
