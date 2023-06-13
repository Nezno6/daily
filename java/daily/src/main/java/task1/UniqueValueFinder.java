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

    public List<Integer> filterOutValuesOccurring3TimesSpaceComplexityN(Integer[] numbers){
        throwsIfNullInArrayOrEmptyArray(numbers);
        return filterOutValuesOccurring3TimesSpaceComplexityNPrivate(numbers);
    }

    private List<Integer> filterOutValuesOccurring3TimesSpaceComplexityNPrivate(Integer[] numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>(); // space O(n)
        List<Integer> integers = new ArrayList<>(Arrays.stream(numbers).toList()); //time 0(n) space O(2n)
        for (Integer number : numbers) { // time O(2n)
            integers.remove(number); // time O(3n)
            if (!integers.contains(number)) { // time O(4n)
                uniqueNumbers.add(number); // time O(5n) => time O(n), space O(n)
            }
        }
        return uniqueNumbers;
    }

    private void throwsIfNullInArrayOrEmptyArray(Integer[] numbers) {
        if (Arrays.stream(numbers).anyMatch(Objects::isNull)) {
            throw new NullElementException();
        } else if (numbers.length == 0) {
            throw new EmptyArrayException();
        }
    }

}







