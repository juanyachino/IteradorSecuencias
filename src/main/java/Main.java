import java.util.*;

public class Main {
    public static void main(String[] args){
        Iterator<Integer> input1 = Arrays.asList(1,3,5,7,9).listIterator();
        Iterator<Integer> input2 = Arrays.asList(2,4,6,8).listIterator();
        Iterator<Integer> input3 = Arrays.asList(0,10,20,30,40).listIterator();
        Iterator<Integer> input4 = Arrays.asList(12,24,48,96).listIterator();
        Collection<Iterator<Integer>> collection = new ArrayList<>();
        collection.add(input1);
        collection.add(input2);
        collection.add(input3);
        collection.add(input4);
        SequenceIterator sequenceIterator = new SequenceIterator(collection);

        while (sequenceIterator.hasNext()) {
            System.out.println(sequenceIterator.next());
        }
    }
}
