public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Word file is now open.");
    }

    @Override
    public void close() {
        System.out.println("Word file has been closed.");
    }
}