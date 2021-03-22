public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

    private int qStrings; //количество строк
    private int [] qColumns; //количество столбцов


    public MyArraySizeException(String s, int qStrings, int [] qColumns) {
        super(s);
        this.qStrings = qStrings;
        this.qColumns = qColumns;
    }

    public int getqStrings() {
        return qStrings;
    }

    public int[] getqColumns() {
        return qColumns;
    }
}
