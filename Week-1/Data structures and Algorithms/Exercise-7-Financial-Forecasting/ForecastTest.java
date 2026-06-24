import java.util.Scanner;

public class ForecastTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Financial Forecasting Tool ===\n");

        System.out.print("Enter initial investment amount: ");
        double presentValue = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter annual growth rate (as decimal): ");
        double growthRate = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter number of years: ");
        int years = Integer.parseInt(scanner.nextLine());

        // Recursive result
        double recursiveResult = FinancialForecaster.calculateFutureValue(presentValue, growthRate, years);
        System.out.println("\nRecursive Forecast: " + recursiveResult);

        // Iterative result (for comparison)
        double iterativeResult = presentValue;
        for (int i = 0; i < years; i++) {
            iterativeResult *= (1 + growthRate);
        }
        System.out.println("Iterative Forecast: " + iterativeResult);

        scanner.close();
    }
}