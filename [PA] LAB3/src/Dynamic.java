import java.util.ArrayList;
import java.util.List;

public class Dynamic {

    private List<Item> solution = new ArrayList<>();
    private double capacity;

    public Dynamic(List<Item> items,Knapsack knapsack){
        int capacity= (int) knapsack.getCapacity();
        //Knapsack solution = new Knapsack(capacity);


        int NB_ITEMS=items.size();
        int[][] dpMatrix =new int [NB_ITEMS+1][(int)capacity+1];
        for(int i=1;i<=NB_ITEMS;i++){
            for (int j=0;j <=capacity;j++){
                if (j<(int)items.get(i-1).getWeight()){
                    dpMatrix[i][j] = dpMatrix[i-1][j];
                }
                else
                {
                    dpMatrix[i][j]=Math.max(dpMatrix[i-1][j],dpMatrix[i-1][j-(int)items.get(i-1).getWeight()]+(int)items.get(i-1).getValue());
                }
            }
        }

        int result = dpMatrix[NB_ITEMS][(int) capacity];
        int tempCapacity = (int) capacity;
        for(int i=NB_ITEMS;i>0 && result>0;i--){
            if(result != dpMatrix[i-1][tempCapacity]){
                solution.add(items.get(i-1));
                result=result-(int) items.get(i-1).getValue();
                tempCapacity=tempCapacity-(int)items.get(i-1).getWeight();
            }
        }
    }

    public List<Item> getSolution(){
        return solution;
    }

    @Override
    public String toString() {
        return "Dynamic{" +
                "solution=" + solution +
                ", capacity=" + capacity +
                '}';
    }
}
