import java.io.*;
// Считываем имя файла, подменяем объект System.out написанной ридер-оберткой и выводим текст одновременно и в консоль, и в файл, имя которого вводим в консоль
public class WapperExample {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        /* BufferedReader reader = null;
        FileOutputStream fileOutputStream = null;
        PrintStream consoleStream = null;
        ByteArrayOutputStream outputStream = null;
        PrintStream stream = null;*/
        //используем try-resource для автоматического закрытия потоков
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //имя файла в который будем записывать результат
             FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine()); //открываем поток записи в файл
             PrintStream consoleStream = System.out; //сохраняем System.out в поток для дальнейшего восстановления
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
             PrintStream stream = new PrintStream(outputStream);
                ){
            System.setOut(stream); //Устанавливаем созданный нами stream поток в качестве System.out
            testString.printSomething();
            String result = outputStream.toString();
            System.setOut(consoleStream); //Возвращаем System.out в первоначальное состояние
            byte[] byteArray = result.getBytes();

            fileOutputStream.write(byteArray, 0, byteArray.length);
            fileOutputStream.close();
            reader.close();
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
