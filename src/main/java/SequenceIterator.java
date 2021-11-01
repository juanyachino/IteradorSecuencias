import java.util.*;


public class SequenceIterator<T extends Comparable> {
    private final Collection<Iterator<T>> inputs;
    private final Map<Iterator<T>, T> currentElements;

    public SequenceIterator(Collection<Iterator<T>> inputs){
        this.inputs = inputs;
        this.currentElements = new HashMap<>();
        initializeCurrentElements();
    }
    public boolean hasNext() {
        return !currentElements.isEmpty();
    }
    public T next() {
        T minimum = null;
        Iterator<T> input = null;
        for (Map.Entry<Iterator<T>, T> currentElement : currentElements.entrySet()) {
            minimum = currentElement.getValue();
            input = currentElement.getKey();
            break;
        }

        for (Map.Entry<Iterator<T>, T> currentElement : currentElements.entrySet()) {
            if (currentElement.getValue().compareTo(minimum) < 0) {
                minimum = currentElement.getValue();
                input = currentElement.getKey();
            }
        }
        moveCursor(input);
        return minimum;
    }
    private void initializeCurrentElements(){
        for (Iterator<T> input : inputs) {
            currentElements.put(input,input.next());
        }
    }
    private void moveCursor(Iterator<T> input){
        if (input.hasNext()) {
            currentElements.put(input,input.next());
        } else {
            currentElements.remove(input);
        }
    }
}