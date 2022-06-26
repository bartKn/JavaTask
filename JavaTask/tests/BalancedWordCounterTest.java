import pl.bartkn.BalancedWordCounter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BalancedWordCounterTest {
    public static Collection<Object[]> inputsProvider() {
        return Arrays.asList(new Object[][] {
                { "aabbabcccba", 28 },
                { "", 0 }
        });
    }

    @ParameterizedTest
    @MethodSource("inputsProvider")
    public void parTest(String input, int result) {
        BalancedWordCounter wordCounter = new BalancedWordCounter();
        assertEquals(wordCounter.count(input), result);
    }

    @Test
    public void testNullInput() {

        BalancedWordCounter wordCounter = new BalancedWordCounter();

        assertThrows(RuntimeException.class,new Executable(){
            @Override
            public void execute() throws Throwable {
                assertEquals(wordCounter.count(null), 0);
            }
        });


    }

    @Test
    public void incorrectInput() {

        BalancedWordCounter wordCounter = new BalancedWordCounter();

        assertThrows(RuntimeException.class,new Executable(){
            @Override
            public void execute() throws Throwable {
                assertEquals(wordCounter.count("abababa1"), 0);
            }
        });
    }
}


