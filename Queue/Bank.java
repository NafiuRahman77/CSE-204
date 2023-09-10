import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Integer n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Client[] clients = new Client[n];
        for (int i = 0; i < clients.length; i++) {
            int p, q;
            p = sc.nextInt();
            q = sc.nextInt();
            clients[i] = new Client(p, q);
            clients[i].no = i + 1;
            clients[i].serving = false;
        }
        AQueue<Client> queue1 = new AQueue<>();
        AQueue<Client> queue2 = new AQueue<>();
        // LQueue<Client> queue1=new LQueue<>();
        // LQueue<Client> queue2=new LQueue<>();
        LQueue<Integer> queue1time = new LQueue<>();
        LQueue<Integer> queue2time = new LQueue<>();
        int i = 0, j = 0, time = 0;
        int delay1 = 0, delay2 = 0;
        boolean check1, check2;

        for (time = 0; j < n; time++) {

            if (i < n) {
                while (clients[i].entertime == time) {
                    if (queue1.length() <= queue2.length()) {
                        queue1.enqueue(clients[i]);
                        // System.out.println("c " + clients[i].no + " enters booth" + 1 + " at time " +
                        // time);
                        i++;
                    } else if (queue2.length() < queue1.length()) {
                        queue2.enqueue(clients[i]);
                        // System.out.println("c " + clients[i].no + " enters booth" + 2 + " at time " +
                        // time);
                        i++;
                    }
                    if (i == n) {
                        break;
                    }

                }
            }
            if (delay1 == 0) {
                if (queue1.length() != 0) {
                    Client temp = queue1.frontValue();
                    delay1 += temp.servicetime;
                    temp.serving = true;
                    queue1time.enqueue(time + delay1);
                    // System.out.println("c "+ temp.no+" leaves booth"+ 1+" at time "+
                    // queue1time.rearValue());

                }
            }
            if (delay2 == 0) {
                if (queue2.length() != 0) {
                    Client temp = queue2.frontValue();
                    delay2 += temp.servicetime;
                    temp.serving = true;
                    queue2time.enqueue(time + delay2);
                    // System.out.println("c "+ temp.no+" leaves booth"+ 2+" at time "+
                    // queue2time.rearValue());
                    // j++;
                }
            }
            if (delay1 != 0) {
                delay1--;
                if (delay1 == 0) {
                    queue1.dequeue();
                    j++;
                }
            }
            if (delay2 != 0) {
                delay2--;
                if (delay2 == 0) {
                    queue2.dequeue();
                    j++;
                }
            }
            if (queue1.length() - queue2.length() >= 2) {
                Client temp = queue1.rearValue();
                if (temp.serving != true) {
                    temp = queue1.leaveQueue();
                    queue2.enqueue(temp);
                }
                // System.out.println("c "+ temp.no+" switches to booth"+ 2 +" at time "+time);
            }
            if (queue2.length() - queue1.length() >= 2) {
                Client temp = queue2.rearValue();
                if (temp.serving != true) {
                    temp = queue2.leaveQueue();
                    queue1.enqueue(temp);
                }

                // System.out.println("c "+ temp.no+" switches to booth"+ 1 +" at time "+time);
            }

        }
        System.out.println("Booth 1 finishes service at t= " + queue1time.rearValue());
        System.out.println("Booth 2 finishes service at t= " + queue2time.rearValue());
    }
}
