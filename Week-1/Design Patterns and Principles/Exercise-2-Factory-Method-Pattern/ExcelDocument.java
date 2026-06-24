public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Excel file is now open.");
    }

    @Override
    public void close() {
        System.out.println("Excel file has been closed.");
    }
}