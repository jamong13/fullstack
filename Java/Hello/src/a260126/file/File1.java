package a260126.file;

import java.io.FileOutputStream;
import java.io.IOException;

public class File1 {
    public static void main(String[] args) throws IOException{
        FileOutputStream output = new FileOutputStream("c:/Users/limeh/out.txt");
        output.close();
        // c:/ 드라이브 루트는 액세스거부
        // c:/Users/본인계정명/
    }
}
