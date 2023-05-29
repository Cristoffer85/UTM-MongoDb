import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;

public class Anslutning {
    static MongoClient mongoClient;
    static MongoDatabase database;
    static MongoCollection<Document> customersCollection;
    static MongoCollection<Document> employeesCollection;

    KeyReader KeyReader = new KeyReader("Pass");

    DBCRUD dbcrud = new DBCRUD();

    public Anslutning() {  // Ansluter till Server + ansluter lokalt ifall den anslutningen inte skulle fungera.
        try {
            mongoClient = MongoClients.create("mongodb+srv://cristofferostberg85:" + KeyReader.getPasscode() + "@cluster0.imetavy.mongodb.net/?retryWrites=true&w=majority");
            database = mongoClient.getDatabase("Personer");
            customersCollection = database.getCollection("Kunder");
            employeesCollection = database.getCollection("Anställda");
            System.out.println("Ansluten till extern MongoDB Server.");
        } catch (MongoException e) {
            System.out.println("Tyvärr lyckades inte ansluta till extern server: " + e.getMessage());
            System.out.println("Försöker ansluta lokalt istället...");
            try {
                mongoClient = MongoClients.create("mongodb://localhost:27017");
                database = mongoClient.getDatabase("Personer");
                customersCollection = database.getCollection("Kunder");
                employeesCollection = database.getCollection("Anställda");
                System.out.println("Ansluten till lokal MongoDB server.");
            } catch (MongoException ex) {
                System.out.println("Tyvärr lyckades inte ansluta till lokal server heller: " + ex.getMessage());
            }
        }
    }
}