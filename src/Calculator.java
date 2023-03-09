public class Calculator {

    public static String calc(String input) throws InvalidInputDataException {
        String[] operands = input.split("[+\\-*/]");
        if (operands.length != 2) throw new InvalidInputDataException("illegal number of operands");
        char operator = input.charAt(operands[0].length());
        operands[0] = operands[0].trim();
        operands[1] = operands[1].trim();
        CountingSystem countingSystem = CountingSystem.typeOfCountingSystem(operands);
        Numeral a = null, b = null;
        switch (countingSystem) {
            case Arabic -> {
                a = new ArabicNumber(operands[0]);
                b = new ArabicNumber(operands[1]);
            }
            case Roman -> {
                a = new RomanNumber(operands[0]);
                b = new RomanNumber(operands[1]);
            }
        }
        int result = switch (operator) {
            case '+' -> a.sum(b);
            case '-' -> a.subtract(b);
            case '*' -> a.multiply(b);
            case '/' -> a.divide(b);
            default -> throw new InvalidInputDataException("unknown operator");
        };
        if (countingSystem == CountingSystem.Arabic) return String.valueOf(result);
        if (result < 1) throw new InvalidInputDataException("roman number result < 1");
        final String[] ONES = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        final String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        return TENS[result / 10] + ONES[result % 10];
    }
}
