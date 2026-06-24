import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testSetup() {
        assertEquals(5, 2 + 3);
        assertTrue(5 > 3);
        assertNotNull(new Object());
    }
}