class RomanNumber extends Numeral {
    enum Romans {Nothing, I, II, III, IV, V, VI, VII, VIII, IX, X;}

    public RomanNumber(String value) throws InvalidInputDataException {
        int temp = Romans.valueOf(value).ordinal();
        if (temp < 1 || temp > 10) throw new InvalidInputDataException("input data out of range");
        this.value = temp;
    }
}
