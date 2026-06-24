import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AAATest {

    private int number;

    @Before
    public void setUp() { 
        number = 10;
        System.out.println("Setup completed");
    }

    @After
    public void tearDown() { 
        System.out.println("Teardown completed");
    }

    @Test
    public void testAddition() { 
        int a = number;
        int b = 5;
 
        int result = a + b;
 
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
       
        int a = number;
        int b = 3;
 
        int result = a - b;
 
        assertEquals(7, result);
    }
}