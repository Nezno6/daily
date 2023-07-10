import exception.EmptyArrayException
import exception.NullElementException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class UniqueValueFinderTest {

    private val uniqueValueFinder: UniqueValueFinder = UniqueValueFinder()
    val arr = arrayOf<Int?>()

    @Test
    fun testGiven_empty_array_When_running_algorithm_Then_empty_array_exception_should_be_thrown() {
        assertThrows(EmptyArrayException::class.java) {
            uniqueValueFinder.filterOutValuesOccurring3Times(arr)
            println(arr.isEmpty())}
    }

    @Test
    fun testGiven_array_with_null_element_When_running_algorithm_Then_null_element_exception_should_be_thrown() {
        assertThrows(NullElementException::class.java) { uniqueValueFinder
            .filterOutValuesOccurring3Times(arrayOf(null))}
    }

    @ParameterizedTest
    @MethodSource("provideDateAsArrayWithNullObjectOrEmptyArray")
    fun testGiven_array_with_null_element_or_empty_array_When_running_algorithm_Then_appropriate_exception_should_be_thrown(
        numbers: Array<Int?>,
        expected: Class<out Exception>
    ) {
        assertThrows(expected) { uniqueValueFinder.filterOutValuesOccurring3Times(numbers) }
    }

    @ParameterizedTest
    @MethodSource("provideDateAsArrayOfIntegersWhereEveryIntegerOccursThreeTimesExceptOneUniqueInteger")
    fun testGiven_correct_array_When_running_algorithm_Then_unique_number_should_be_found(
        numbers: Array<Int?>,
        expected: Int
    ) {
        val actual = uniqueValueFinder.filterOutValuesOccurring3Times(numbers)[0]
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun provideDateAsArrayOfIntegersWhereEveryIntegerOccursThreeTimesExceptOneUniqueInteger(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(6, 1, 3, 3, 3, 6, 6), 1),
                Arguments.of(arrayOf(13, 19, 13, 13), 19),
                Arguments.of(arrayOf(6, 4, 3, 3, 3, 6, 6), 4)
            )
        }

        @JvmStatic
        fun provideDateAsArrayWithNullObjectOrEmptyArray(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf<Int?>(), EmptyArrayException::class.java),
                Arguments.of(arrayOf<Int?>(null), NullElementException::class.java),
                Arguments.of(arrayOf<Int?>(null, null, null), NullElementException::class.java),
                Arguments.of(arrayOf(13, null, 19, 13), NullElementException::class.java),
                Arguments.of(arrayOf(13, 19, null, 13), NullElementException::class.java),
                Arguments.of(arrayOf(13, 20, 19, null, 13), NullElementException::class.java)
            )
        }
    }


}