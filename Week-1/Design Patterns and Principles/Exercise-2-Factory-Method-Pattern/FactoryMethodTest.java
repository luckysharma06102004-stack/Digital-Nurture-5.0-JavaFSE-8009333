public class FactoryMethodTest {
    public static void main(String[] args) {

        System.out.println("[TEST] Creating and working with a Word document:");
        Document wordDoc = new WordDocumentFactory().createDocument();
        wordDoc.open();
        wordDoc.close();

        System.out.println("\n[TEST] Creating and working with a PDF document:");
        Document pdfDoc = new PdfDocumentFactory().createDocument();
        pdfDoc.open();
        pdfDoc.close();

        System.out.println("\n[TEST] Creating and working with an Excel document:");
        Document excelDoc = new ExcelDocumentFactory().createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}