public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("PDF file is now open.");
    }

    @Override
    public void close() {
        System.out.println("PDF file has been closed.");
    }
}