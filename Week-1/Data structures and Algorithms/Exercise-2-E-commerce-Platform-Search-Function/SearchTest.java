import java.util.Scanner;

public class SearchTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = Integer.parseInt(scanner.nextLine());

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Product " + (i + 1) + " ---");

            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Category: ");
            String category = scanner.nextLine();

            products[i] = new Product(id, name, category);
        }
 
        Product[] sortedProducts = products.clone();
        java.util.Arrays.sort(sortedProducts, (a, b) -> Integer.compare(a.getProductId(), b.getProductId()));

        System.out.print("\nEnter Product ID to search: ");
        int targetId = Integer.parseInt(scanner.nextLine());
 
        long startLinear = System.nanoTime();
        Product resultLinear = SearchAlgorithms.linearSearch(products, targetId);
        long endLinear = System.nanoTime();
        double linearTimeMs = (endLinear - startLinear) / 1_000_000.0;

        System.out.println();
        if (resultLinear != null) {
            System.out.println("[Linear Search] Found: " + resultLinear);
        } else {
            System.out.println("[Linear Search] Not Found");
        }
        System.out.println("[Linear Search] Time taken: " + linearTimeMs + " ms");

        long startBinary = System.nanoTime();
        Product resultBinary = SearchAlgorithms.binarySearch(sortedProducts, targetId);
        long endBinary = System.nanoTime();
        double binaryTimeMs = (endBinary - startBinary) / 1_000_000.0;

        System.out.println();
        if (resultBinary != null) {
            System.out.println("[Binary Search] Found: " + resultBinary);
        } else {
            System.out.println("[Binary Search] Not Found");
        }
        System.out.println("[Binary Search] Time taken: " + binaryTimeMs + " ms");

        scanner.close();
    }
}