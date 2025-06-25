import java.lang.reflect.WildcardType;
import java.util.*;
public class Main {
    public static void main(String[] args) {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();
    nodeList.add(new WeightedNode("A",0));
    nodeList.add(new WeightedNode("B",1));
    nodeList.add(new WeightedNode("C",2));
    nodeList.add(new WeightedNode("D",3));
    nodeList.add(new WeightedNode("E",4));
    nodeList.add(new WeightedNode("F",5));
    nodeList.add(new WeightedNode("g",6));
    weightedGraph wg = new weightedGraph(nodeList);
    wg.addWeightedEdge(0,1,2);
    wg.addWeightedEdge(0,2,5);
    wg.addWeightedEdge(1,2,6);
    wg.addWeightedEdge(1,3,1);
    wg.addWeightedEdge(1,4,3);
    wg.addWeightedEdge(2,5,8);
    wg.addWeightedEdge(3,4,4);
    wg.addWeightedEdge(4,6,0);
    wg.addWeightedEdge(5,6,7);
        System.out.println("Printing from source A");
    //wg.dijkstra(nodeList.get(0));
        wg.bellmanFord(nodeList.get(0));
    }
}
