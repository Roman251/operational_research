package econ.management;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static Object[] input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of elements...");
        int elem = sc.nextInt();
        int[] workers = new int[elem];
        int[] outputs = new int[elem];
        Object[] arrayObjects = new Object[2];
        for (int i = 0; i < elem; i++) {
            System.out.println("Workers");
            workers[i] = sc.nextInt();
            System.out.println("Output");
            outputs[i] = sc.nextInt();
        }
        arrayObjects[0] = workers;
        arrayObjects[1] = outputs;
        return arrayObjects;
    }
    public static int[] MarginalProduct(int[] output){
        int[] mp = new int[output.length];
        mp[0] = 0;
        for (int i = 0; i < output.length; i++) {
            try {
                mp[i + 1] = output[i + 1] - output[i];
            } catch (Exception e) {
                System.out.println("continue...");
            }
        }
        for(int i=0; i<mp.length; i++) {
            System.out.print(mp[i]+" ");
        }
        System.out.println("");
        return mp;
    }
    public static void MarginalRateProduction(int[] mp, int price, int wage, int[] workers){
        int[] mrp = new int[workers.length];
        int hire = 0;
        for(int i =0; i<workers.length; i++){
            mrp[i] = mp[i] * price;
            try {
                if (mrp[i] >= wage) {
                    hire = workers[i];
                } }catch (Exception e){
                    System.out.println("Exception");
                }
            }
        System.out.println("Corresponding MRP");
        System.out.println(Arrays.toString(mrp));
        System.out.println(hire);
        System.out.println("The number of workers you need to hire is "+ hire);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the price of the product...");
        int price = sc.nextInt();
        System.out.println("Input the wage the worker is willing to work for...");
        int wage = sc.nextInt();
        Object[] values = input();
        int[] workers = (int[])values[0];
        int[] outputs = (int[])values[1];
        MarginalRateProduction(MarginalProduct(outputs),price,wage,workers);
    }
}
