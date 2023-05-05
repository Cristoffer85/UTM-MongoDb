import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Scanner;

public class MongoDBFacade {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> customersCollection;
    private MongoCollection<Document> employeesCollection;


    public static void main(String[] args) {
        MongoDBFacade mongoFacade = new MongoDBFacade();
        mongoFacade.runMenu();
    }

    public MongoDBFacade() {
        try {
            // Connect to the MongoDB server
            mongoClient = MongoClients.create("mongodb+srv://cristofferostberg85:Tomtarna1@cluster0.imetavy.mongodb.net/?retryWrites=true&w=majority");
            database = mongoClient.getDatabase("Persons");
            customersCollection = database.getCollection("customers");
            employeesCollection = database.getCollection("employees");
            System.out.println("Connected to MongoDB server.");
        } catch (MongoException e) {
            System.out.println("Failed to connect to MongoDB server: " + e.getMessage());
            System.out.println("Trying to connect locally...");
            try {
                // If connection to the server fails, try to connect to a local instance of MongoDB
                mongoClient = MongoClients.create("mongodb://localhost:27017");
                database = mongoClient.getDatabase("Persons");
                customersCollection = database.getCollection("customers");
                employeesCollection = database.getCollection("employees");
                System.out.println("Connected to MongoDB server locally.");
            } catch (MongoException ex) {
                System.out.println("Failed to connect to MongoDB server locally: " + ex.getMessage());
                System.exit(1);
            }
        }
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add customer");
            System.out.println("2. Update customer");
            System.out.println("3. Delete customer");
            System.out.println("4. Add employee");
            System.out.println("5. Update employee");
            System.out.println("6. Delete employee");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> updateCustomer();
                case 3 -> deleteCustomer();
                case 4 -> addEmployee();
                case 5 -> updateEmployee();
                case 6 -> deleteEmployee();
                case 7 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        } while (choice != 7);
        scanner.close();
        mongoClient.close();
    }

    private void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();
        Document customer = new Document();
        customer.append("name", name);
        customer.append("email", email);
        customer.append("phone", phone);
        customersCollection.insertOne(customer);
        System.out.println("Customer added successfully.");
    }

    private void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer email to update: ");
        String email = scanner.nextLine();
        Document filter = new Document("email", email);
        Document customer = customersCollection.find(filter).first();
        if (customer == null) {
            System.out.println("Customer not found.");
        } else {
            System.out.println("Current customer information:");
            System.out.println("Name: " + customer.getString("name"));
            System.out.println("Email: " + customer.getString("email"));
            System.out.println("Phone: " + customer.getString("phone"));
            System.out.print("Enter new name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            System.out.print("Enter new email (leave blank to keep current): ");
            String newEmail = scanner.nextLine();
            System.out.print("Enter new phone (leave blank to keep current): ");
            String newPhone = scanner.nextLine();
            Document update = new Document();
            if (!newName.isEmpty()) {
                update.append("name", newName);
            }
            if (!newEmail.isEmpty()) {
                update.append("email", newEmail);
            }
            if (!newPhone.isEmpty()) {
                update.append("phone", newPhone);
            }
            UpdateResult result = customersCollection.updateOne(filter, new Document("$set", update));
            if (result.getModifiedCount() == 1) {
                System.out.println("Customer updated successfully.");
            } else {
                System.out.println("Customer not updated.");
            }
        }
    }

    private void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer email to delete: ");
        String email = scanner.nextLine();
        Document filter = new Document("email", email);
        DeleteResult result = customersCollection.deleteOne(filter);
        if (result.getDeletedCount() == 1) {
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee email: ");
        String email = scanner.nextLine();
        System.out.print("Enter employee phone: ");
        String phone = scanner.nextLine();
        Document employee = new Document();
        employee.append("name", name);
        employee.append("email", email);
        employee.append("phone", phone);
        employeesCollection.insertOne(employee);
        System.out.println("Employee added successfully.");
    }

    private void updateEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee email to update: ");
        String email = scanner.nextLine();
        Document filter = new Document("email", email);
        Document employee = employeesCollection.find(filter).first();
        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("Current employee information:");
            System.out.println("Name: " + employee.getString("name"));
            System.out.println("Email: " + employee.getString("email"));
            System.out.println("Phone: " + employee.getString("phone"));
            System.out.print("Enter new name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            System.out.print("Enter new email (leave blank to keep current): ");
            String newEmail = scanner.nextLine();
            System.out.print("Enter new phone (leave blank to keep current): ");
            String newPhone = scanner.nextLine();
            Document update = new Document();
            if (!newName.isEmpty()) {
                update.append("name", newName);
            }
            if (!newEmail.isEmpty()) {
                update.append("email", newEmail);
            }
            if (!newPhone.isEmpty()) {
                update.append("phone", newPhone);
            }
            UpdateResult result = employeesCollection.updateOne(filter, new Document("$set", update));
            if (result.getModifiedCount() == 1) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee not updated.");
            }
        }
    }

    private void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee email to delete: ");
        String email = scanner.nextLine();
        Document filter = new Document("email", email);
        DeleteResult result = employeesCollection.deleteOne(filter);
        if (result.getDeletedCount() == 1) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
