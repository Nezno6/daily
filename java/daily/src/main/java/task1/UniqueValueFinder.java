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

    public List<Integer> filterOutValuesOccurring3Times(Integer[] numbers){
        throwsIfNullInArrayOrEmptyArray(numbers);
        return filterOutValuesOccurring3TimesPrivate(numbers);
    }

    private List<Integer> filterOutValuesOccurring3TimesPrivate(Integer[] numbers) {// ==> time O(n), space O(1)
        int ones = 0;
        int twos = 0;
        for (int number : numbers) { // time O(n), space O(1)
            ones = (ones ^ number) & ~twos; // time O(1), space O(1)
            twos = (twos ^ number) & ~ones; // time O(1), space O(1)
        }
        return List.of(ones);
    }

    private void throwsIfNullInArrayOrEmptyArray(Integer[] numbers) {
        if (Arrays.stream(numbers).anyMatch(Objects::isNull)) {
            throw new NullElementException();
        } else if (numbers.length == 0) {
            throw new EmptyArrayException();
        }
    }

}







