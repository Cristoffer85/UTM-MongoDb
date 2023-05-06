import com.mongodb.client.FindIterable;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Scanner;

public class DBCRUD {


    // ############################################# KUND #############################################
    public static void addCustomer() {                      //Lägger till en Kund.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange namn på kund: ");
        String namn = scanner.nextLine();
        System.out.print("Ange kundnummer för kund: ");
        String kundnummer = scanner.nextLine();
        System.out.print("Ange ålder på kund: ");
        String ålder = scanner.nextLine();
        System.out.print("Ange kunds adress: ");
        String adress = scanner.nextLine();
        Document customer = new Document();
        customer.append("Namn", namn);
        customer.append("Kundnummer", kundnummer);
        customer.append("Ålder", ålder);
        customer.append("Adress", adress);
        Anslutning.customersCollection.insertOne(customer);
        System.out.println("Kund tillagd.");
    }

    public static void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in kundnummer: ");
        String kundnummer = scanner.nextLine();
        Document filter = new Document("Kundnummer", kundnummer);
        Document customer = Anslutning.customersCollection.find(filter).first();
        if (customer == null) {
            System.out.println("Kund ej funnen.");
        } else {
            //------------------------------------------------------------------
            System.out.println("Aktuell kundinformation:");
            System.out.println("Namn: " + customer.getString("namn"));
            System.out.println("Kundnummer: " + customer.getString("kundnummer"));
            System.out.println("Ålder: " + customer.getString("ålder"));
            System.out.println("Adress: " + customer.getString("adress"));
            //------------------------------------------------------------------
            System.out.print("Skriv in nytt namn (Lämna blankt för att behålla befintligt): ");
            String nyttNamn = scanner.nextLine();
            System.out.print("Skriv in nytt kundnummer (Lämna blankt för att behålla befintligt): ");
            String nyttKundnummer = scanner.nextLine();
            System.out.print("Skriv in ny ålder (Lämna blankt för att behålla befintligt): ");
            String nyÅlder = scanner.nextLine();
            System.out.print("Skriv in ny adress (Lämna blankt för att behålla befintligt): ");
            String nyAdress = scanner.nextLine();
            //------------------------------------------------------------------
            Document update = new Document();
            if (!nyttNamn.isEmpty()) {
                update.append("Namn", nyttNamn);
            }
            if (!nyttKundnummer.isEmpty()) {
                update.append("Kundnummer", nyttKundnummer);
            }
            if (!nyÅlder.isEmpty()) {
                update.append("Ålder", nyÅlder);
            }
            if (!nyAdress.isEmpty()) {
                update.append("Adress", nyAdress);
            }
            //------------------------------------------------------------------
            UpdateResult result = Anslutning.customersCollection.updateOne(filter, new Document("$set", update));
            if (result.getModifiedCount() == 1) {
                System.out.println("Kund uppdaterad.");
            } else {
                System.out.println("Kund ej uppdaterad.");
            }
        }
    }

    public static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange kundnummer för att radera kund: ");
        String kundnummer = scanner.nextLine();
        Document filter = new Document("Kundnummer", kundnummer);
        DeleteResult result = Anslutning.customersCollection.deleteOne(filter);
        if (result.getDeletedCount() == 1) {
            System.out.println("Kund raderad.");
        } else {
            System.out.println("Kund ej raderad.");
        }
    }

    public static void printAllCustomers() {
        if (Anslutning.customersCollection == null || Anslutning.customersCollection.getNamespace().getCollectionName().equals("Kunder")){
            System.out.println(Anslutning.customersCollection);
        }
    }

    // ############################################# ANSTÄLLD #############################################
    public static void addEmployee() {                      //Lägger till en anställd
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange namn på anställd: ");
        String namn = scanner.nextLine();
        System.out.print("Ange anställningsnummer för anställd: ");
        String anställningsnummer = scanner.nextLine();
        System.out.print("Ange ålder på anställd: ");
        String ålder = scanner.nextLine();
        System.out.print("Ange anställds adress: ");
        String adress = scanner.nextLine();
        Document customer = new Document();
        customer.append("Namn", namn);
        customer.append("Anställningsnummer", anställningsnummer);
        customer.append("Ålder", ålder);
        customer.append("Adress", adress);
        Anslutning.employeesCollection.insertOne(customer);
        System.out.println("Kund tillagd.");
    }

    public static void updateEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in anställningsnummer: ");
        String anställningsnummer = scanner.nextLine();
        Document filter = new Document("Anställningsnummer", anställningsnummer);       //Söker och uppdaterar anställd baserat på anställningsnummer
        Document employee = Anslutning.employeesCollection.find(filter).first();
        if (employee == null) {
            System.out.println("Anställd ej funnen.");
        } else {
            //------------------------------------------------------------------
            System.out.println("Aktuell information om anställd:");
            System.out.println("Namn: " + employee.getString("namn"));
            System.out.println("Anställningsnummer: " + employee.getString("anställningsnummer"));
            System.out.println("Ålder: " + employee.getString("ålder"));
            System.out.println("Adress: " + employee.getString("adress"));
            //------------------------------------------------------------------
            System.out.print("Skriv in nytt namn (Lämna blankt för att behålla befintligt): ");
            String nyttNamn = scanner.nextLine();
            System.out.print("Skriv in nytt anställningsnummer (Lämna blankt för att behålla befintligt): ");
            String nyttAnställningsnummer = scanner.nextLine();
            System.out.print("Skriv in ny ålder (Lämna blankt för att behålla befintligt): ");
            String nyÅlder = scanner.nextLine();
            System.out.print("Skriv in ny adress (Lämna blankt för att behålla befintligt): ");
            String nyAdress = scanner.nextLine();
            //------------------------------------------------------------------
            Document update = new Document();
            if (!nyttNamn.isEmpty()) {
                update.append("Namn", nyttNamn);
            }
            if (!nyttAnställningsnummer.isEmpty()) {
                update.append("Anställningsnummer", nyttAnställningsnummer);
            }
            if (!nyÅlder.isEmpty()) {
                update.append("Ålder", nyÅlder);
            }
            if (!nyAdress.isEmpty()) {
                update.append("Adress", nyAdress);
            }
            //------------------------------------------------------------------
            UpdateResult result = Anslutning.employeesCollection.updateOne(filter, new Document("$set", update));
            if (result.getModifiedCount() == 1) {
                System.out.println("Anställd uppdaterad.");
            } else {
                System.out.println("Anställd ej uppdaterad.");
            }
        }
    }

    public static void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee email to delete: ");
        String email = scanner.nextLine();
        Document filter = new Document("email", email);
        DeleteResult result = Anslutning.employeesCollection.deleteOne(filter);
        if (result.getDeletedCount() == 1) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void printAllEmployees() {
        if (Anslutning.employeesCollection == null || Anslutning.employeesCollection.getNamespace().getCollectionName().equals("Anställda")){
            System.out.println(Anslutning.employeesCollection);
        }
    }
}
