import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void print(Stack<Integer> a){
        Integer p,length=a.length();
        Integer [] temparr=new Integer[length];
       for(int i=0;i<length;i++){
           p=a.pop();
           temparr[i]=p;
           //System.out.print(p+" ");
       }
        System.out.println(" ");
        System.out.print("<");
        for(int i=length-1;i>=0;i--){
            System.out.print(temparr[i]+" ");
        }
        System.out.print(">");
        System.out.println(" ");
        for(int i=length-1;i>=0;i--){
           a.push(temparr[i]);
        }

    }

    public static void main(String[] args) {
        AStack<Integer> sta=new AStack<Integer>();
//        LLStack<Integer> sta=new LLStack<Integer>();
        int a;
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();

        for(int i=0;i<a;i++){
            int temp;
            temp=sc.nextInt();
            sta.push(temp);
        }
        print(sta);

        while(true){
            int p,q;
            q=sc.nextInt();
            p=sc.nextInt();
            if(q==0){

                break;
            }

            else if(q==1){

              sta.clear();
              print(sta);
              System.out.println(-1);


            }else if(q==2){

               sta.push(p);
               print(sta);
                System.out.println(-1);


            }else if(q==3){
                Integer s= sta.pop();;
                print(sta);
                System.out.println(s);

            }else if(q==4){

                print(sta);
                System.out.println(sta.length());

            }
            else if(q==5){
                print(sta);
                System.out.println(sta.topValue());


            }
            else if(q==6){

               sta.setDirection(p);
               print(sta);
               System.out.println(-1);


            }
        }







    }
}
