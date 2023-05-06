import java.util.Scanner;

public class Meny {

    Anslutning anslutning = new Anslutning();
    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Lägg till Kund");
            System.out.println("2. Uppdatera Kund");
            System.out.println("3. Radera Kund");
            System.out.println("4. Visa alla Kunder");
            System.out.println("----------------");
            System.out.println("5. Lägg till Anställd");
            System.out.println("6. Uppdatera Anställd");
            System.out.println("7. Radera Anställd");
            System.out.println("8. Visa alla Anställda");
            System.out.println("----------------");
            System.out.println("9. Avsluta");
            System.out.print("Gör ditt val: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> DBCRUD.addCustomer();
                case 2 -> DBCRUD.updateCustomer();
                case 3 -> DBCRUD.deleteCustomer();
                case 4 -> DBCRUD.printAllCustomers();
                case 5 -> DBCRUD.addEmployee();
                case 6 -> DBCRUD.updateEmployee();
                case 7 -> DBCRUD.deleteEmployee();
                case 8 -> DBCRUD.printAllEmployees();
                case 9 -> System.out.println("Hejdå!");
                default -> System.out.println("Det är tyvärr inte ett giltigt val.");
            }
            System.out.println();
        } while (choice != 9);
        scanner.close();
        Anslutning.mongoClient.close();     // Skickar till klassen anslutning att den skall stänga anslutningen till databasen, om valet är 9.
    }
}
