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

    // FW algo

  public void floydWarshall(){
      int size = nodeList.size();
      int [] [] V = new int[size][size];
      for(int i = 0 ; i < size ; i++){
            WeightedNode first = nodeList.get(i);
            for(int j = 0 ; j<size ; j++){
                WeightedNode second = nodeList.get(j);
                if(i==j){
                    V[i][j] = 0;
                }
                else if(first.weighMap.containsKey(second)){
                    V[i][j] = first.weighMap.get(second);
                }
                else{
                    V[i][j] = Integer.MAX_VALUE/10;
                }
            }
      }
      for(int k = 0 ; k<nodeList.size();k++){
          for(int i = 0 ; i<nodeList.size();i++){
              for(int j = 0 ; j < nodeList.size() ; j++){
                  if(V[i][j]>V[i][k]+V[k][j]){
                      V[i][j]=V[i][k]+V[k][j];
                  }
              }
          }
      }
      for(int i = 0 ; i<size ; i++){
          System.out.print("Printing distance list for node " + nodeList.get(i)+":");
          for(int j = 0 ; j<size ; j++){
              System.out.print(V[i][j]+" ");
          }
          System.out.println();

      }
  }



}




























