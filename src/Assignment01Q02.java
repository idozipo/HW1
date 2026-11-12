public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;

        int termCount = Integer.parseInt(args[0]); // Amount of terms in summation

        // Calculate (PI / 4) sum
        for (int i = 0; i < termCount; i++) {
            double term = Math.pow(-1, i) / (2 * i + 1);
            approxPi += term;
        }

        approxPi *= 4; // Don't forget to multiply by 4 :)

        System.out.println(approxPi + " " + actualPi);
    }
}
