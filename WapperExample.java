import java.io.*;
// Считываем имя файла, подменяем объект System.out написанной ридер-оберткой и выводим на консоль получившийся результат.
public class WapperExample {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        byte[] byteArray = result.getBytes();

        fileOutputStream.write(byteArray, 0, byteArray.length);
        fileOutputStream.close();
        reader.close();
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}