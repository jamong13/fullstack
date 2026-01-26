package a260126.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("c:/Users/limeh/out.txt"));
        while (true) {
            String line = br.readLine();
            if(line == null) break; // 더 이상 읽을 라인이 없을 경우 while 문을 빠져 나간다.
            System.out.println(line);
        }
    }
}
