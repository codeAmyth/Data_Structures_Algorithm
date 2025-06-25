public class UndirectedNode {

    // defining the parameters of undirected graph

    public WeightedNode first;
    public WeightedNode second;
    public int weight;

    // defining the constructors


    public UndirectedNode(WeightedNode first, WeightedNode second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    // defining toString to display


    @Override
    public String toString() {
        return "UndirectedNode{" +
                "first=" + first +
                ", second=" + second +
                ", weight=" + weight +
                '}';
    }
}
