import exception.EmptyArrayException
import exception.NullElementException

class UniqueValueFinder() {

        public fun filterOutValuesOccurring3Times(numbers: Array<Int?>): List<Int> {
                throwsIfNullInArrayOrEmptyArray(numbers)
                return filterOutValuesOccurring3TimesPrivate(numbers)
        }

        private fun throwsIfNullInArrayOrEmptyArray(numbers: Array<Int?>) {
                        if (numbers.any { it == null }) {
                                throw NullElementException()
                        } else if (numbers.isEmpty()) {
                                throw EmptyArrayException()
                        }
        }

        private fun filterOutValuesOccurring3TimesPrivate(numbers: Array<Int?>): List<Int> {
                var ones = 0
                var twos = 0
                for (number in numbers) {
                        ones = (ones xor number!!) and twos.inv()
                        twos = (twos xor number) and ones.inv()
                }
                return listOf(ones)
        }
}
