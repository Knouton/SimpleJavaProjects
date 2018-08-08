import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Считываем имя файла с консоли, который содержит слова разделённые пробелами. Ищем среди них те слова, которые является обратной версией друг друга.
Пример: 
Среди слов: бот кот сок ток тор рот
Обратными версиями друг друга будут: кот, ток и тор, рот
Добавляем такие слова в список result 
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
    //Открываем поток для чтения имени файла
        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(readerFileName.readLine()));
    //Читаем из файла, которое ввели
        int numRead;
        char[] buf = new char[1024];
        StringBuilder builder = new StringBuilder();
        while (fileReader.ready()) {
            numRead = fileReader.read(buf);
            String readData = String.valueOf(buf, 0, numRead);
            builder.append(readData);
        }
        //Полученные слова из файла записываем в массив стрингов, разделяя слова по пробелу
        String[] string = String.valueOf(builder).split("\\s+");
        //Ищем обратные друг для друга слова и добавляем в result
        for (int i = 0; i < string.length; i++) {
            String s1 = new StringBuilder(string[i]).reverse().toString();

            for (int j = 0; j < string.length; j++) {

                if (i != j && s1.equals(string[j])) {
                    Pair pair1 = new Pair(string[i], string[j]);
                    Pair pair2 = new Pair(string[j], string[i]);
                    if( !result.contains(pair1) && !result.contains(pair2)){
                        result.add(pair1);
                    }
                }
            }
        }
        //Закрываем потоки
       readerFileName.close();
       fileReader.close();
    }

    public static class Pair {
        String first;
        String second;

        protected Pair() {
        }

        public Pair(String str1, String str2) {
            first = str1;
            second = str2;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
