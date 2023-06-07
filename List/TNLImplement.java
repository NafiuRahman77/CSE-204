import java.util.Scanner;

import static java.lang.System.exit;

public class TNLImplement {
    public static void task1(List<Integer> rickshaw, List<Integer>  bus, List<Integer> train ){
        System.out.println(" ");
        rickshaw.moveToStart();
        for (int i=0;i<rickshaw.length();i++){
            if(rickshaw.currPos()== rickshaw.length()-1){
                System.out.print(rickshaw.getValue());
            }
            else {
                System.out.print(rickshaw.getValue() + ",");
            }
            rickshaw.next();
        }
        System.out.println("");

        bus.moveToStart();
        for (int i=0;i<bus.length();i++){
            if(bus.getValue()==-1){
                System.out.print(",");
            }
            else{
                if(bus.currPos()== bus.length()-1){
                    System.out.print(bus.getValue());
                }
                else {
                    System.out.print(bus.getValue() + ",");
                }
            }
            bus.next();
        }
        System.out.println(" ");
        train.moveToStart();
        for (int i=0;i<train.length();i++){
            if(train.getValue()==-1){
                System.out.print(",");
            }
            else{
                if(train.currPos()== train.length()-1){
                    System.out.print(train.getValue());
                }
                else {
                    System.out.print(train.getValue() + ",");
                }
            }
            train.next();
        }

    }
    public static void main(String[] args) {
        int K, L , M, x;
        Scanner sc=new Scanner(System.in);
        K= sc.nextInt();
        List<Integer> Rickshaw=new LList<Integer>();
        List<Integer> Bus=new LList<Integer>();
        List<Integer> Train=new LList<Integer>();
//        List<Integer> Rickshaw=new AList<Integer>();
//        List<Integer> Bus=new AList<Integer>();
//        List<Integer> Train=new AList<Integer>();

        for (int i=0;i<K;i++){
            Rickshaw.append(i);
        }
        for (int i=0;i<K;i++){
            Bus.append(-1);
        }
        for (int i=0;i<K;i++){
            Train.append(-1);
        }
        L=sc.nextInt();
        for (int i=0;i<L;i++){
           x=sc.nextInt();
           if(x==Rickshaw.length()-1){
               Bus.moveToPos(x);
               Bus.remove();
               Bus.append(x);
           }
           else {
               Bus.moveToPos(x);
               Bus.remove();
               Bus.insert(x);
           }
        }
        M=sc.nextInt();
        for (int i=0;i<M;i++){
            x=sc.nextInt();
            if(x==Rickshaw.length()-1){
                Train.moveToPos(x);
                Train.remove();
                Train.append(x);
            }
            else {
                Train.moveToPos(x);
                Train.remove();
                Train.insert(x);
            }
        }

        int task;
        task=sc.nextInt();

        if(task==1){

            task1(Rickshaw,Bus,Train);
        }
        else{
            exit(1);
        }

    }
}
