package parser;

public class PasswordConfig {
    private int size;
    private boolean hasSymbol;
    private boolean hasCapital;
    private boolean hasNumber;

    public PasswordConfig(int size, boolean hasSymbol, boolean hasCapital, boolean hasNumber) {
        this.size = size;
        this.hasSymbol = hasSymbol;
        this.hasCapital = hasCapital;
        this.hasNumber = hasNumber;
    }

    public int getSize() {
        return size;
    }

    public boolean isHasSymbol() {
        return hasSymbol;
    }

    public boolean isHasCapital() {
        return hasCapital;
    }

    public boolean isHasNumber() {
        return hasNumber;
    }
}
