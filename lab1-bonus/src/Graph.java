import java.util.*;

public class Graph {
    private final int conexNumber;
    private final Map<Integer, ArrayList<Integer>> conexComponents = new HashMap<>();

    public boolean nodesToVisit(boolean[] visited){
        for (boolean b : visited) {
            if (!b) {
                return true;
            }

        }
        return false;
    }

    public int firstNodeToVisit(boolean[] visited){
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                return i;
            };
        }
        return 0;
    }


    public Graph(boolean[][] adjacency, int n){
        int index = 0;

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);


        Queue<Integer> queue = new LinkedList<>();

        while(nodesToVisit(visited)){
            index++;

            int tempNode = firstNodeToVisit(visited);
            queue.add(tempNode);
            conexComponents.put(index, new ArrayList<>());
            conexComponents.get(index).add(tempNode);
            visited[tempNode] = true;

            while (!queue.isEmpty()) {
                int node = queue.remove();
                for(int i = 0; i<n; i++){
                    if(adjacency[node][i] && !visited[i]){
                        queue.add(i);
                        conexComponents.get(index).add(i);
                        visited[i] = true;
                    }
                }
            }
        }

        this.conexNumber = index;

    }



    public Map<Integer, ArrayList<Integer>> getConexComponents() {
        return conexComponents;
    }

    public int getConexNumber() {
        return conexNumber;
    }
}