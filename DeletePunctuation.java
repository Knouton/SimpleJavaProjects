import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Считать с консоли 2 имени файла.
//Первый Файл содержит текст.
//Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
            BufferedReader readerFile = null;
            BufferedWriter writerFile = null;
            try{
                reader = new BufferedReader(new InputStreamReader(System.in));
                readerFile = new BufferedReader(new FileReader(reader.readLine()));
                writerFile = new BufferedWriter(new FileWriter(reader.readLine()));
                int numRead;
                char buf[] = new char[1024];
                StringBuilder stringBuilder = new StringBuilder();
                while (readerFile.ready()) {
                    numRead  = readerFile.read(buf);
                    String readData = String.valueOf(buf, 0, numRead);
                    stringBuilder.append(readData);
                }
                Pattern pattern = Pattern.compile("\\p{Punct}");
                Matcher matcher = pattern.matcher(stringBuilder);
                String space = "";
                String s = String.valueOf(stringBuilder);
                s = matcher.replaceAll(space);
                writerFile.write(s);
            } finally {
                writerFile.close();
                reader.close();
                readerFile.close();
            }
    }
}
