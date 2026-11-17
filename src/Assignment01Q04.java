import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        final int n = array.length;

        // Edge cases return original array
        if (n <= 1 || (direction != 'R' && direction != 'L') || move == 0) {
            return array;
        }

        // Handle negative moves
        if (move < 0) {
            direction = direction == 'R' ? 'L' : 'R';
            move *= -1;
        }

        // Normalize move
        move %= array.length;

        // Return the original array at edge case
        if (move == 0) {
            return array;
        }

        // Convert Left shifts to Right shifts
        if (direction == 'L') {
            move = n - move;
        }

        // Temp array
        int[] temp = new int[n];

        // Shift the array
        for (int i = 0; i < array.length; i++) {
            final int wantedIndex = (i + move) % n;
            temp[wantedIndex] = array[i];
        }

        // Copy back to original array
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 0, 8, 9, 5, 6 }, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] {}, 3, 'R'))); // []
    }
}