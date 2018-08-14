import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//заменяем все точки на "!"
public class replacementOfPunctuation {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader readerFile = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter writerFile = new BufferedWriter(new FileWriter(reader.readLine()));) {
            StringBuilder stringBuilder = new StringBuilder();
            int numRead;
            char[] buff = new char[1024];
            while (readerFile.ready()) {
                numRead = readerFile.read(buff);
                String readData = String.valueOf(buff, 0, numRead);
                stringBuilder.append(readData);
            }
            String a = String.valueOf(stringBuilder);
            String point = "\\.";
            String exclamationMark = "!";
            Pattern pattern = Pattern.compile(point);
            Matcher matcher = pattern.matcher(a);
            a = matcher.replaceAll(exclamationMark);
            writerFile.write(a);
    }
}
