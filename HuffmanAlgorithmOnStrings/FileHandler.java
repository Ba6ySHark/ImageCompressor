import java.io.FileOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;

public class FileHandler {
    public void writeBytes(byte[] bytes_array, String file_path) {
        try {
            OutputStream os = new FileOutputStream(new File(file_path));
            for (int i = 0; i < bytes_array.length; i++) {
                System.out.print(bytes_array[i] + " ");
            }
            os.write(bytes_array);
            os.close();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}
