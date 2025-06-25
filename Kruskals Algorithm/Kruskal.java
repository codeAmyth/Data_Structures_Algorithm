
import java.lang.reflect.UndeclaredThrowableException;
import java.util.*;
public class Kruskal {

    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
    ArrayList<UndirectedNode> edgeList = new ArrayList<UndirectedNode>();

    public Kruskal(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

   public void addWeightedUndirectedEdge(int firstIndex , int secondIndex , int weight){
        UndirectedNode edge = new UndirectedNode(nodeList.get(firstIndex),nodeList.get(secondIndex),weight);
        WeightedNode first = edge.first;
        WeightedNode second = edge.second;
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weighMap.put(second , weight);
        second.weighMap.put(first, weight);
        edgeList.add(edge);
   }

    void Kruskal(){
       DisjointSet.makeSet(nodeList);
       Comparator<UndirectedNode> comparator = new Comparator<UndirectedNode>() {
           @Override
           public int compare(UndirectedNode o1, UndirectedNode o2) {
               return o1.weight - o2.weight;
           }
       };
       Collections.sort(edgeList , comparator);
       int cost = 0;
       for(UndirectedNode edge : edgeList){
           WeightedNode first = edge.first;
           WeightedNode second = edge.second;
           if(!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))){
               DisjointSet.union(first,second);
               cost+= edge.weight;
               System.out.println("Taken " + edge);
           }
       }
        System.out.println("\nTotal cost of MST: "+cost);

    }


}























