import java.util.ArrayList;
import java.util.List;
// doc ra tu file
import java.io.ObjectInputStream;
import java.io.FileInputStream;
// ghi vao file
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOFile {
    // read from file
    public static <T> List<T> read(String file){
        List<T> list = new ArrayList<>();
        try{
            try (ObjectInputStream o = new ObjectInputStream(
                    new FileInputStream(file))) {
                list = (List<T>) o.readObject();
            }
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        return list;
    }
    // write to file
    public static <T> void write(String file, List<T> arr){
        try{
            try (ObjectOutputStream o = new ObjectOutputStream(
                    new FileOutputStream(file))) {
                o.writeObject(arr);
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
