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

    // Bellman Ford algorithm

    public void bellmanFord(WeightedNode sourceNode){
        sourceNode.distance = 0;
        for(int i = 0 ; i<nodeList.size(); i++){
            for(WeightedNode currentNode : nodeList){
                for(WeightedNode neigbor : currentNode.neighbors){
                    if(neigbor.distance > currentNode.distance+ currentNode.weighMap.get(neigbor)){
                        neigbor.distance = currentNode.distance+ currentNode.weighMap.get(neigbor);
                        neigbor.parent = currentNode;
                    }
                }
            }
        }
        System.out.println("CHecking for negative cycle");
        for(WeightedNode currentNode : nodeList){
            for(WeightedNode neigbor : currentNode.neighbors){
                if(neigbor.distance > currentNode.distance+ currentNode.weighMap.get(neigbor)){
                    System.out.println("Negaive cycle found \n");
                    System.out.println("Vertex Name :" +neigbor.name+"\n");
                    System.out.println("Old cost: " + neigbor.distance);
                    int newDistance = currentNode.distance + currentNode.weighMap.get(neigbor);
                    System.out.println("New cost "+ newDistance );
                    return;
                }
            }
        }
        System.out.println("Negative Cycle not founded");
        for(WeightedNode nodeToCheck : nodeList){
            System.out.print("Node "+nodeToCheck+" , distance: "+nodeToCheck.distance+", Path: ");
            printPath(nodeToCheck);
            System.out.println();

        }



    }

}




























