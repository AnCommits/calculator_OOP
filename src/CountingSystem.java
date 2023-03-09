public enum CountingSystem {
    Arabic,
    Roman;

    static CountingSystem typeOfCountingSystem(String[] operands) throws InvalidInputDataException {
        CountingSystem cs = typeOfCountingSystem(operands[0]);
        if (cs != typeOfCountingSystem(operands[1])) throw new InvalidInputDataException("dissimilar counting systems");
        return cs;
    }

    static CountingSystem typeOfCountingSystem(String operand) {
        return Character.isDigit(operand.charAt(0)) ? CountingSystem.Arabic : CountingSystem.Roman;
    }
}
