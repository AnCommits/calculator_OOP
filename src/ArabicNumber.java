class ArabicNumber extends Numeral {

    public ArabicNumber(String value) throws InvalidInputDataException {
        int temp = Integer.parseInt(value);
        if (temp < 1 || temp > 10) throw new InvalidInputDataException("input data out of range");
        this.value = temp;
    }
}
