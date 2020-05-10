import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

public class MainTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private int countStringOccurences (String input, String toMatch) {
    	int index = input.indexOf(toMatch);
    	int count = 0;
    	while (index != -1) {
    	    count++;
    	    input = input.substring(index + 1);
    	    index = input.indexOf(toMatch);
    	}
    	return count;
    }

    @Test
    public void testCase1() {
    	// Will run one round, then finalize
        provideInput("1\n2\n");
        Main.main(new String[0]);

        String output = getOutput();

        // It should only show "Antigo" and "Novo" strings once
        // It should only show "Finalizado." string once, on the end
        assertEquals(1, countStringOccurences(output, "Antigo"));
        assertEquals(1, countStringOccurences(output, "Novo"));
        assertEquals(1, countStringOccurences(output, "Finalizado."));
    }
}
