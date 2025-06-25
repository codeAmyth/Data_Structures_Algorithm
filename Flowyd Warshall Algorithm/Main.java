import java.lang.reflect.WildcardType;
import java.util.*;
public class Main {
    public static void main(String[] args) {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();
    nodeList.add(new WeightedNode("A",0));
    nodeList.add(new WeightedNode("B",1));
    nodeList.add(new WeightedNode("C",2));
    nodeList.add(new WeightedNode("D",3));
    weightedGraph wg = new weightedGraph(nodeList);
    wg.addWeightedEdge(0,3,1);
    wg.addWeightedEdge(0,1,8);
    wg.addWeightedEdge(1,2,1);
    wg.addWeightedEdge(2,0,4);
    wg.addWeightedEdge(3,1,2);
    wg.addWeightedEdge(3,2,9);

        System.out.println("Printing from source A");
    //wg.dijkstra(nodeList.get(0));
    wg.floydWarshall();
    }
}
