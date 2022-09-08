public record ComplexNumber(double real, double imaginary) {
    @Override
    public String toString() {
        return real + (imaginary != 0 && !Double.isNaN(imaginary) ? (imaginary < 0 ? " - " : " + ") + (Math.abs(imaginary) + "i") : "");
    }
}
