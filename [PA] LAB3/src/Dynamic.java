import java.util.ArrayList;
import java.util.List;

public class Dynamic {

    private List<Item> solution = new ArrayList<>();
    private double capacity;

    public Dynamic(List<Item> items, Knapsack knapsack) {
        Item[] itemsArray = new Item[items.size()];
        itemsArray=items.toArray(itemsArray);


        capacity=knapsack.getCapacity();
        int NB_ITEMS = itemsArray.length;
        int[][] matrix = new int[NB_ITEMS + 1][(int) (capacity + 1)];

        for(int i=0;i<=capacity;i++)
            matrix[0][i]=0;

        for (int i=1;i<=NB_ITEMS;i++){
            for (int j=0;j<=capacity;j++){
                if (itemsArray[i-1].getWeight()>j)
                    matrix[i][j]=matrix[i-1][j-1];
                else
                    matrix[i][j]= (int) Math.max(matrix[i-1][j], matrix[i-1][(int) (j- itemsArray[i-1].getWeight())]+itemsArray[i-1].getValue());
            }
        }


        int res=matrix[NB_ITEMS][(int) capacity];
        int w= (int) capacity;

        for(int i= NB_ITEMS;i>1 && res>1;i--){
            if (res!= matrix[i-1][w]) {
                solution.add(itemsArray[i - 1]);
                //remove value and weight
                res-=itemsArray[i-1].getValue();
                w-= itemsArray[i-1].getWeight();
            }
        }

    }

    public List<Item> getSolution() {
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
