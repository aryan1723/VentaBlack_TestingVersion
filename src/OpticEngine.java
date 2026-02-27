import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class OpticEngine {
    public static void main(String[] args){
        try{
            File imageFile = new File("C:\\Users\\Aryan\\IdeaProjects\\OpticEngine\\src\\Image\\user.jpg");
            BufferedImage image = ImageIO.read(imageFile);

            if(image!=null){
                int width = image.getWidth();
                int height = image.getHeight();
                System.out.println("Image Loaded");
                System.out.println("Width: "+width+" Height: "+height);
                System.out.println("Total Pixels = "+width*height);

                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

                for(int y=0;y<height;y++){
                    for(int x=0;x<width;x++){
                        int pixel = image.getRGB(x,y);
                        int r = (pixel>>16) & 0xff;
                        int g = (pixel>>8) & 0xff;
                        int b = (pixel) & 0xff;

                        messageDigest.update((byte) r);
                        messageDigest.update((byte) g);
                        messageDigest.update((byte) b);
                    }
                }

                byte[] masterKey = messageDigest.digest();

                StringBuilder hexKey = new StringBuilder();
                for(byte bit:masterKey){
                    hexKey.append(String.format("%02x",bit));
                }
                System.out.println(hexKey);
            }
        } catch (IOException e) {
            System.out.println("Error: Could not find or read the file.");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
