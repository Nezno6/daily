package task1;
//This problem was asked by Google.
//Given an array of integers where every integer occurs three times except for one integer,
//which only occurs once, find and return the non-duplicated integer.
//For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
//Do this in O(N) time and O(1) space.

import java.util.*;
import task1.exception.EmptyArrayException;
import task1.exception.NullElementException;

public class UniqueValueFinder {

    public List<Integer> filterOutValuesOccurring3TimesSpaceComplexityNSquared(Integer[] numbers){
        throwsIfNullInArrayOrEmptyArray(numbers);
        return filterOutValuesOccurring3TimesSpaceComplexityNNSquaredPrivate(numbers);
    }

    private List<Integer> filterOutValuesOccurring3TimesSpaceComplexityNNSquaredPrivate(Integer[] numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>(); // time O(1), space O(1)
        List<Integer> integers = new ArrayList<>(Arrays.asList(numbers)); //time 0(n), space O(n)
        // Arrays.asList() is generally faster than using streams for small arrays.
        // However, for larger arrays, streams may be faster due to their parallel processing capabilities.

        for (Integer number : numbers) { // time O(n), space O(n)
            integers.remove(number); // time O(n), space O(n)
            if (!integers.contains(number)) { // time O(n), space O(n)
                uniqueNumbers.add(number); // time amortized O(1), space amortized O(1)
            }
        }
        return uniqueNumbers;
        // time O(n), space O(n)
    }

    private void throwsIfNullInArrayOrEmptyArray(Integer[] numbers) {
        if (Arrays.stream(numbers).anyMatch(Objects::isNull)) {
            throw new NullElementException();
        } else if (numbers.length == 0) {
            throw new EmptyArrayException();
        }
    }

}







