import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SampleTest {

    private val testSample: Sample = Sample()

    @Test
    fun testSum() {
        val expected = 42
        val actual = testSample.sum(40,2)
        assertEquals(expected, actual)
    }
}