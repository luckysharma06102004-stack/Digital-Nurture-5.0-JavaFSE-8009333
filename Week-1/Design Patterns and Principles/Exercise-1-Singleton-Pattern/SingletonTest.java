public class SingletonTest {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");

        Logger logger2 = Logger.getInstance();
        logger2.log("User logged in.");

        System.out.println("logger1 hashcode: " + logger1.hashCode());
        System.out.println("logger2 hashcode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("SUCCESS: logger1 and logger2 are the SAME instance.");
        } else {
            System.out.println("FAILURE: Singleton pattern broken — different instances.");
        }
    }
}