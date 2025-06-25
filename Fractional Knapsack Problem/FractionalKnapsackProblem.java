import java.util.*;
public class FractionalKnapsackProblem {
    static void knapSack (ArrayList<KnapsackItems> items, int capacity) {
        Comparator<KnapsackItems> comparator = new Comparator<KnapsackItems>() {
            @Override
            public int compare(KnapsackItems o1, KnapsackItems o2) {
                if (o2.getRatio()>o1.getRatio()) return 1;
                else return -1;
            }
        };
        Collections.sort(items, comparator);
        int usedCapacity = 0;
        double totalValue = 0;

        for (KnapsackItems item : items) {
            if (usedCapacity + item.getWeight()<=capacity) {
                usedCapacity+=item.getWeight();
                System.out.println("Taken: "+item);
                totalValue+=item.getValue();
            } else {
                int usedWeight = capacity - usedCapacity;
                double value = item.getRatio()*usedWeight;
                System.out.println("Taken: item index = "+ item.getIndex()+ ", obtained value= "+ value+ ", used weight =" +usedWeight+ ", ratio = "+ item.getRatio());
                usedCapacity += usedWeight;
                totalValue += value;

            }
            if (usedCapacity == capacity) break;
        }

        System.out.println("\nTotal value obtained: "+ totalValue);

    }
}
