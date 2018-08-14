import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
// Подменяем объект System.out написанной ридер-оберткой
//ридер-обертка должна выводить на консоль решенный пример.
/* Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.*/

Пример вывода:
3 + 6 = 9
public class WrappedExample2 {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //используем try-resource для автоматического закрытия потоков
            try (PrintStream consoleStream = System.out;
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                 PrintStream stream = new PrintStream(outputStream);
                 ){
                System.setOut(stream);
                testString.printSomething();
                String result = outputStream.toString();
                System.setOut(consoleStream);
                String[] array = result.split(" ");
                int x = Integer.valueOf(array[0]);
                int y = Integer.valueOf(array[2]);
                int z = 0;
                if (array[1].equals("+")) {
                    z = x + y;
                }
                if (array[1].equals("-")) {
                    z = x - y;
                }
                if (array[1].equals("*")) {
                    z = x * y;
                }
                System.out.println(x + " " + array[1] + " " + y + " = " + z);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

