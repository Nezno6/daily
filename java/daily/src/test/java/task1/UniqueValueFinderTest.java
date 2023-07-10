package task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import task1.exception.EmptyArrayException;
import task1.exception.NullElementException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UniqueValueFinderTest {

    static Stream<Arguments> provideDateAsArrayOfIntegersWhereEveryIntegerOccursThreeTimesExceptOneUniqueInteger() {
        return Stream.of(
                Arguments.of(new Integer[]{6, 1, 3, 3, 3, 6, 6}, 1),
                Arguments.of(new Integer[]{13, 19, 13, 13}, 19),
                Arguments.of(new Integer[]{6, 4, 3, 3, 3, 6, 6}, 4)
        );
    }

    static Stream<Arguments> provideDateAsArrayWithNullObjectOrEmptyArray() {
        return Stream.of(
                Arguments.of(new Integer[]{}, EmptyArrayException.class),
                Arguments.of(new Integer[]{null}, NullElementException.class),
                Arguments.of(new Integer[]{null, null, null}, NullElementException.class),
                Arguments.of(new Integer[]{13, null, 19, 13}, NullElementException.class),
                Arguments.of(new Integer[]{13, 19, null, 13}, NullElementException.class),
                Arguments.of(new Integer[]{13, 20, 19, null, 13}, NullElementException.class)
        );
    }

    @Test
    void testGiven_empty_array_When_running_algorithm_Then_empty_array_exception_should_be_thrown() {
        assertThrows(EmptyArrayException.class, () -> new UniqueValueFinder().filterOutValuesOccurring3Times(new Integer[]{}));
    }

    @Test
    void testGiven_array_with_null_element_When_running_algorithm_Then_null_element_exception_should_be_thrown() {
        assertThrows(NullElementException.class, () -> new UniqueValueFinder().filterOutValuesOccurring3Times(new Integer[]{null}));
    }

    @ParameterizedTest
    @MethodSource("provideDateAsArrayWithNullObjectOrEmptyArray")
    void testGiven_array_with_null_element_or_empty_array_When_running_algorithm_Then_appropriate_exception_should_be_thrown
            (Integer[] numbers, Class<Exception> expected) {
        assertThrows(expected, () -> new UniqueValueFinder().filterOutValuesOccurring3Times(numbers));
    }

    @ParameterizedTest
    @MethodSource("provideDateAsArrayOfIntegersWhereEveryIntegerOccursThreeTimesExceptOneUniqueInteger")
    void testGiven_correct_array_When_running_algorithm_Then_unique_number_should_be_found(Integer[] numbers,
                                                                                           Integer expected) {
        UniqueValueFinder uniqueValueFinder = new UniqueValueFinder();
        Integer actual = uniqueValueFinder.filterOutValuesOccurring3Times(numbers).get(0);
        assertEquals(expected, actual);
    }
}