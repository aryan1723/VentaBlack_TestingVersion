import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmbeddingKey {
    public static void main(String[] args){

        //Temperory Static Data
        String drive="F:\\";
        String masterKey = "0fc030ba29b2ed3aac411091476bf529d1dc94d2d0ff03cbee96566222bd3fedf808a6b48cfe7f7e73d1ef322ac23b61596c672db77cf6982211a68f542ea135";

        try{
            File keyFile = new File(drive + ".vanta");
            FileOutputStream fileOutputStream = new FileOutputStream(keyFile);
            fileOutputStream.write(masterKey.getBytes());
            Files.setAttribute(Paths.get(keyFile.getAbsolutePath()), "dos:hidden", true);
            fileOutputStream.close();
            System.out.println("Master Key successfully forged onto drive: " + keyFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

