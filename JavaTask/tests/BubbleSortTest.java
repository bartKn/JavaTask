import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pl.bartkn.BubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BubbleSortTest {
    public static Collection<Object[]> inputsProvider() {

        List<Number> list1 = Arrays.asList(1,4,5,6,8,3,8);
        List<Number> list2 = Arrays.asList(-9.3,0.2,4.,0.1,5.,9.);
        List<Number> list3 = new ArrayList<>();
        List<Number> list4 = new ArrayList<>();
        list4.add(null);
        list4.add(5.0001);
        return Arrays.asList(new Object[][] {
                { list1, Arrays.asList(1,3,4,5,6,8,8) },
                { list2, Arrays.asList(-9.3,0.1,0.2,4.,5.,9.) },
                { list3, Arrays.asList() },
                { list4, Arrays.asList(5.0001)}
        });
    }

    @ParameterizedTest
    @MethodSource("inputsProvider")
    public void parTest(List input, List result) {
        BubbleSort bubbleSort = new BubbleSort();
        assertEquals(bubbleSort.sort(input), result);
    }

    @Test
    public void testNullInput() {
        assertThrows(RuntimeException.class,new Executable(){
            @Override
            public void execute() throws Throwable {
                BubbleSort bubbleSort = new BubbleSort();
                assertEquals(bubbleSort.sort(null), null);
            }
        });
    }
}
