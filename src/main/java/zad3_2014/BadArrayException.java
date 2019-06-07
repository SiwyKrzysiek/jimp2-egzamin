package zad3_2014;

public class BadArrayException extends IllegalStateException {
    private final int invalidRowNumber;

    public BadArrayException(String message, int invalidRowNumber) {
        super(message);
        this.invalidRowNumber = invalidRowNumber;
    }

    public int getInvalidRowNumber() {
        return invalidRowNumber;
    }
}
