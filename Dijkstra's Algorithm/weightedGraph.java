import java.util.*;
public class weightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public weightedGraph(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

    // implement of algorithm
    public void dijkstra(WeightedNode node){
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()){
            WeightedNode currentNode = queue.remove();
            for (WeightedNode neighbor : currentNode.neighbors){
                if(neighbor.distance > currentNode.distance + currentNode.weighMap.get(neighbor)){
                    neighbor.distance = currentNode.weighMap.get(neighbor);
                    neighbor.parent = currentNode;
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        for(WeightedNode nodeToCheck : nodeList){
            System.out.print("Node "+nodeToCheck+" , distance: "+nodeToCheck.distance+", Path: ");
            printPath(nodeToCheck);
            System.out.println();

        }
    }
    public  static void printPath(WeightedNode node){
        if(node.parent != null){
            printPath(node.parent);
        }
        System.out.print(node.name+" ");
    }

    public void addWeightedEdge(int i , int j , int d){
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weighMap.put(second , d);
    }

}
