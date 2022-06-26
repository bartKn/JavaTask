package pl.bartkn;

import java.util.Collections;
import java.util.List;

public class BubbleSort {

    public <E extends Comparable<E>> List<E> sort(List<E> input) throws RuntimeException {
        // check if input is null
        if (input == null)
            throw new RuntimeException();

        // remove null elements from list
        input.removeAll(Collections.singleton(null));

        int n = input.size() - 1;
        boolean swapFlag;

        do {
            swapFlag = false;
            for(int i = 0; i < n; i++){

                if (input.get(i).compareTo(input.get(i + 1)) > 0) {
                    Collections.swap(input, i, i + 1);
                    swapFlag = true;
                }
            }
            n--;
        } while(swapFlag);

        return input;
    }
}
