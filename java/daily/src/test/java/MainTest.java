import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void main() {
        String expected = "Hello Word!!";
        String actual = Main.texting();
        Assertions.assertEquals(expected, actual);
    }
}