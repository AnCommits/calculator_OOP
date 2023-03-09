public class Numeral implements Operations {
    int value;

    public int getValue() {
        return value;
    }

    @Override
    public int sum(Numeral n) {
        return this.value + n.getValue();
    }

    @Override
    public int subtract(Numeral n) {
        return this.value - n.getValue();
    }

    @Override
    public int multiply(Numeral n) {
        return this.value * n.getValue();
    }

    @Override
    public int divide(Numeral n) {
        return this.value / n.getValue();
    }
}
