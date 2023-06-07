import java.io.*;
import java.util.*;

public class SnakeLadder {
    static class Node {
        int v;
        int dist;
    }

    static int getMinDiceThrows(int move[], int n, int x, boolean[] visited, int[] parent) {

        for (int i = 1; i <= x; i++)
            visited[i] = false;

        Queue<Node> q = new LinkedList<>();

        int v = 1;
        visited[1] = true;
        Node node = new Node();
        node.dist = 0;
        node.v = 1;
        q.add(node);

        while (q.isEmpty() == false) {
            node = q.remove();
            v = node.v;
            if (v == x)
                break;

            for (int j = v; j <= (v + n) && j <= x; ++j) {

                if (visited[j] == false) {

                    Node a = new Node();
                    a.dist = (node.dist + 1);
                    visited[j] = true;

                    if (move[j] != -1) {
                        a.v = move[j];
                        parent[move[j]] = j;
                        parent[j] = v;
                    } else {
                        a.v = j;
                        if (parent[j] == -1) {
                            parent[j] = v;
                        }
                    }

                    q.add(a);

                }
            }
        }

        if (v != x) {
            return -1;
        }
        return node.dist;
    }

    static int[] fileReader(BufferedReader br) throws IOException {
        String line_2 = br.readLine();
        String[] s = line_2.split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int[] move = new int[x+1] ;
        move[0] = n;
        for (int i = 1; i <= x; i++) {
           move[i] = -1;
        }
        line_2 = br.readLine();
        int l = Integer.parseInt(line_2);
        for(int j=0; j<l; j++){
            String line_l = br.readLine();
            String[] s1 = line_l.split(" ");
            move[Integer.parseInt(s1[0])] = Integer.parseInt(s1[1]);
        }
        line_2 = br.readLine();
        int sn = Integer.parseInt(line_2);
        for(int j=0; j<sn; j++){
            String line_s = br.readLine();
            String[] s1 = line_s.split(" ");
            move[Integer.parseInt(s1[0])] = Integer.parseInt(s1[1]);
        }
        return move;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/output.txt"));
        String line = br.readLine();
        int t = Integer.parseInt(line);
       // System.out.println(t);
        for (int i = 0; i < t; i++) {

            int[] move = fileReader(br);
            int n=move[0], x=move.length-1;
            int dest=x, flag=1;
            int parent[] = new int[x + 1];

            for (int k = 1; k <= x; k++) {
                parent[k] = -1;
            }
            Stack<Integer> st=new Stack<Integer>();

        boolean visited[] = new boolean[x + 1];
        int result = getMinDiceThrows(move, n, x, visited, parent);
        //System.out.println(result);
            bw.write(String.valueOf(result));
            bw.write("\n");
        if(result==-1){
            //System.out.println("No solution");
            bw.write("No solution");
            bw.write("\n");
        }
        else {
            while (dest != 1) {
                st.push(dest);
                dest = parent[dest];
            }
            StringBuilder sb=new StringBuilder();
            //System.out.print(1);
            sb.append("1");
            while (st.isEmpty() == false) {
                //System.out.print("->" + st.peek());
                sb.append("->"+st.peek());
                st.pop();
            }
            //System.out.println();
            bw.write(String.valueOf(sb));
            bw.write("\n");
        }
        StringBuilder sb1=new StringBuilder();
        for (int j = 1; j <= x; j++) {
            if (visited[j] == false) {
                //System.out.print(j + " ");
                sb1.append(j+" ");
                flag = 0;
            }
        }
        if(flag==0) {
            bw.write(String.valueOf(sb1));
            bw.write("\n");
        }
        if (flag == 1) {
            //System.out.println("All reachable");
            bw.write("All reachable");
            bw.write("\n");
        }
        bw.write("\n");

        }
        bw.close();
    }
}
