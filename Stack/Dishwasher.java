import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {

        Integer n, x;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();

        Integer[] courses = new Integer[x + 1];
        Integer[] friends = new Integer[n + 1];
        Dish[] single = new Dish[2 * n * x + 1];

        // AStack<Dish> cleanstack = new AStack<Dish>(single,-1);
        // AStack<Dish> dirtystack = new AStack<Dish>(single,1);
        // AStack<Dish> cleanstack = new AStack<Dish>();
        // AStack<Dish> dirtystack = new AStack<Dish>();
        LLStack<Dish> cleanstack = new LLStack<Dish>();
        LLStack<Dish> dirtystack = new LLStack<Dish>();
        LLStack<Integer> runtimestack = new LLStack<>();
        LLStack<Integer> completemealstack = new LLStack<>();
        courses[0] = 0;
        friends[0] = 0;

        for (int i = 1; i < courses.length; i++) {
            int p;
            p = sc.nextInt();
            courses[i] = p;

        }

        Dish[] dishes = new Dish[n * x];
        int k, t, s;
        int p = 0, totaldish, tWash = 0;
        while (true) {
            k = sc.nextInt();
            t = sc.nextInt();
            s = sc.nextInt();
            if (k == 0) {
                break;
            }
            dishes[p] = new Dish(k, t, s);
            p++;

        }

        totaldish = p;
        int pusheddish = 0, poppeddish = 0, time = 0, delay = 0;

        for (time = 0; poppeddish < totaldish; time++) {

            if (pusheddish < totaldish) {
                if (dishes[pusheddish].pushTime == time) {
                    dirtystack.push(dishes[pusheddish]); // push dish at desired time
                    pusheddish++;// increment count
                }
            }
            if (delay == 0) {
                if (dirtystack.length() != 0) {
                    Dish temp = dirtystack.pop();// pop from dirty stack
                    cleanstack.push(temp);// push into the clean stack
                    if (temp.courseTime == x) {
                        completemealstack.push(temp.friendNo);// pushes friend if he has completed full meal
                    }
                    delay += courses[temp.courseTime]; // set the delay to new washing time
                    runtimestack.push(time + courses[temp.courseTime] - 1); // insert the ending time of washing of
                                                                            // newly popped dish
                    poppeddish++;
                }
            }
            if (delay != 0) {
                delay--; // Dishwashing time decreasing
            }

        }
        System.out.println(runtimestack.topValue());
        int[] runtimearray = new int[runtimestack.length()];
        for (int i = runtimearray.length - 1; i >= 0; i--) {
            runtimearray[i] = runtimestack.pop();
        }
        for (int i = 0; i <= runtimearray.length - 1; i++) {
            if (i == runtimearray.length - 1) {

                System.out.print(runtimearray[i]);
            } else {
                System.out.print(runtimearray[i] + ",");
            }
        }
        System.out.println(" ");
        if (n * x == cleanstack.length()) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }

        while (completemealstack.length() != 0) {
            Integer a = completemealstack.pop();
            System.out.print(a + ",");

        }
        System.out.print("\b");

    }
}
