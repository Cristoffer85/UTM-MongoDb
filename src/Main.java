import java.util.logging.Level;                                                 //Relaterade imports till Driver-systemmeddelanden
import java.util.logging.Logger;                                                //Relaterade imports till Driver-systemmeddelanden
public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);    //Visar bara allvarliga Driver-fel, ignorerar nivå mindre

        Meny huvudmeny = new Meny();                                            //Startar menyn för Databasen med menyval, etc.
        huvudmeny.runMenu();
    }
}
