
import java.util.*;

public class NumbersArray {

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 1, 5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));

        System.out.println();

        input = new Integer[]{1, 2, 3, 4, 1, 2, 5, 3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));
    }

    // Write your methods here =========================================================
    
    public static int findMax(Integer[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            if (result < input[i]) {
                result = input[i];
            }
        }

        return result;
    }

    public static HashMap<Integer, Boolean> mapIntDupes(Integer[] input) {
        HashMap<Integer, Boolean> intMap = new HashMap<>();
        
        for (Integer number : input) {
            if (intMap.containsKey(number)) {
                intMap.put(number, true);
            } else {
                intMap.put(number, false);
            }
        }

        return intMap;
    }

    public static Integer[] findDuplicates(Integer[] input) {
        HashMap<Integer, Boolean> intMap = mapIntDupes(input);
        
        Integer[] results = intMap.entrySet().stream()
                .filter((entry) -> entry.getValue())
                .map(entry -> entry.getKey())
                .toArray(Integer[]::new);

        return results;
    }

    public static Integer[] findUnique(Integer[] input) {
        HashMap<Integer, Boolean> intMap = mapIntDupes(input);

        Integer[] results = intMap.entrySet().stream()
                .filter((entry) -> entry.getValue() == false)
                .map(entry -> entry.getKey())
                .toArray(Integer[]::new);

        return results;
    }

}
