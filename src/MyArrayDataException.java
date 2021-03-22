public class MyArrayDataException extends NumberFormatException{
    String notNumber;
    int numberString;
    int numberColumn;


    public MyArrayDataException(String s, String notNumber, int numberString, int numberColumn) {
        super(s);
        this.notNumber = notNumber;
        this.numberString = numberString;
        this.numberColumn = numberColumn;
    }

    public String getNotNumber() {
        return notNumber;
    }

    public int getNumberString() {
        return numberString;
    }

    public int getNumberColumn() {
        return numberColumn;
    }
}
