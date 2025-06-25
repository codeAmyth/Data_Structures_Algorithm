import java.lang.reflect.WildcardType;
import java.util.*;
public class Main {
    public static void main(String[] args) {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();
    nodeList.add(new WeightedNode("A",0));
    nodeList.add(new WeightedNode("B",1));
    nodeList.add(new WeightedNode("C",2));
    nodeList.add(new WeightedNode("D",3));
   DisjointSet ds = new DisjointSet();
   ds.makeSet(nodeList);
   WeightedNode firstNode = nodeList.get(0);
   WeightedNode secondNode = nodeList.get(1);
   DisjointSet output = ds.findSet(secondNode);
   output.printAllNodesOfThisSet();

   ds.union(firstNode , secondNode);
   output = ds.findSet(secondNode);
   output.printAllNodesOfThisSet();


    }
}
