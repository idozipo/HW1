public class Assignment01Q01 {
    public static void main(String[] args) {
        for (final String arg : args) {
            if (arg.charAt(0) % 5 == 0) { // Check divisible by 5
                System.out.println(arg.charAt(0));
            }
        }
    }
}
