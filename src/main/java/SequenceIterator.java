import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class SequenceIterator {
    private final Collection<Iterator<Integer>> inputs;
    private final ArrayList<Integer> currentElements;
    private int inputsCompleted;

    public SequenceIterator(Collection<Iterator<Integer>> inputs){
        this.inputs = inputs;
        this.currentElements = new ArrayList<>();
        this.inputsCompleted = 0;
        initializeCurrentElements();
    }
    public boolean hasNext() {
        return inputsCompleted <= inputs.size() - 1;
    }
    public Integer next() {
        Integer minimum = Integer.MAX_VALUE;
        int inputNumber = 0;
        for (int i = 0; i< currentElements.size(); i++) {
            if (currentElements.get(i) < minimum){
                minimum = currentElements.get(i);
                inputNumber = i;
            }
        }
        moveCursor(inputNumber);
        return minimum;
    }
    private void initializeCurrentElements(){
        int i = 0;
        for (Iterator<Integer> input : inputs){
            this.currentElements.add(i,input.next());
            i++;
        }
    }
    private void moveCursor(int inputNumber){
        int cycle = 0;
        for (Iterator<Integer> input : inputs){
            if (cycle == inputNumber){
                if (input.hasNext()) {
                    this.currentElements.set(inputNumber, input.next());
                } else {
                    this.currentElements.set(inputNumber, Integer.MAX_VALUE);
                    inputsCompleted++;
                }
                break;
            }
            cycle++;
        }
    }
}