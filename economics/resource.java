package algoDS.management;
import java.util.*;

public class resource {
    static ArrayList<Integer> workers = new ArrayList<>(Arrays.asList(0,1,2,3,4,5));
    static ArrayList<Integer> outputs = new ArrayList<>(Arrays.asList(0,5,12,17,17,15));
    static int price = 10; //price of each product
    static int wage = 20; //wage of each worker

    public static int[] MarginalProduct(ArrayList<Integer> output){
        int[] marginalproduct = new int[output.size()];
        marginalproduct[0] = 0;
        for (int i = 0; i < output.size(); i++) {
            try {
                marginalproduct[i + 1] = output.get(i+1) - output.get(i);
            }catch (Exception e) {
                System.out.println("continue...");
            }
        }
        for(int i=0; i<marginalproduct.length; i++) {
            System.out.print(marginalproduct[i]+" ");
        }
        System.out.println("");
        return marginalproduct;
    }
    public static void MarginalRateProduction(int[] marginalproduct, int price, int wage, ArrayList<Integer> workers){
        int[] mrp = new int[workers.size()];
        int hire = 0;
        for(int i =0; i<workers.size(); i++){
            mrp[i] = marginalproduct[i] * price;
            try {
                if (mrp[i] >= wage) {
                    hire = workers.get(i);
                } }catch (Exception e){
                System.out.println("Exception");
            }
        }
        System.out.println("corresponding MRP:" + Arrays.toString(mrp));
        System.out.println("the number of workers you need to hire is "+ hire);
    }
    public static void main(String[] args) {
        MarginalRateProduction(MarginalProduct(outputs),price,wage,workers);
    }
}