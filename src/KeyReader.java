import java.io.FileInputStream;
import java.util.Properties;
public class KeyReader {        //Klass för att läsa lösenord ifrån textfil, istället för att lägga in det publikt över internet så inte hackarna får tag i de.

    Properties props;

    public KeyReader(String file){

        props = new Properties();

        String userHome = System.getProperty("user.home");

        try {
                                                //Hämtar textfilen, skall EJ ligga i Onedrive = Ex: C:\Users\*Användare*\Documents\Pass
            FileInputStream input = new FileInputStream(userHome + "/Documents/Pass/" + file +".txt");
            props.load(input);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public String getPasscode(){
        return props.getProperty("Pass");  //läs lösenordet i filen

        // OBSOBS lösenord skall i filen anges --> Pass=lösenord <-- OBSOBS
    }
}