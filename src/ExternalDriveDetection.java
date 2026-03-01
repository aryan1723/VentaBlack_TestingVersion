import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class ExternalDriveDetection {
    public static void main(String[] args){
        File[] roots = File.listRoots();
        String drive="";
        for(File root: roots){
            String type = FileSystemView.getFileSystemView().getSystemTypeDescription(root);
            if(type.equals("USB Drive")){
                drive = ""+root;
            }
        }
        if(!drive.equals("")) {
            System.out.println("External Drive Detected: "+drive);
        }
    }
}
