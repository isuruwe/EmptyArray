import java.util.ArrayList;
import java.util.List;

public class EmptyArray extends Exception {}

float avg(int[] nums) throws EmptyArray, NegativeNumberFoundException {
    int sum = 0;
    if (nums == null || nums.length == 0)
        throw new EmptyArray();

    List<String> negativeIndices = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] < 0) {
            negativeIndices.add((i + 1) + "-th number " + nums[i]);
        }
        sum += nums[i];
    }

    if (!negativeIndices.isEmpty()) {
        throw new NegativeNumberFoundException(negativeIndices);
    }

    return (float) sum / nums.length;
}

public void main(String[] args) {
    int[] nums = new int[]{1, 2};
    Float result = null;
    try {
        result = avg(nums);
    } catch (EmptyArray e) {
        System.out.println("Array is empty");
    } catch (NegativeNumberFoundException e) {
        for (String s : e.getNegativeIndices()) {
            System.out.println("The " + s + " in your array is invalid");
        }
    }
    System.out.println("Result: " + result);


    int[] numsWithNegatives = new int[]{1, -2, -3, 4};
    try {
        result = avg(numsWithNegatives);
    } catch (EmptyArray e) {
        System.out.println("Array is empty");
    } catch (NegativeNumberFoundException e) {
        for (String s : e.getNegativeIndices()) {
            System.out.println("The " + s + " in your array is invalid");
        }
    }
    System.out.println("Result: " + result);
}
