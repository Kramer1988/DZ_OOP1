import javax.swing.*;
import java.io.*;
import java.util.Collections;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //  Задание
        //  У вас имеется текстовый файл text.txt. Посчитайте в этом тексте, как часто встречается каждое слово,
        //   затем выведите в отдельный файл result.txt данную информацию.
        //  Также, в конец этого файла выведите самое часто встречаемое слово и его частоту.

        FileRead fileRead = new FileRead("text.txt");
        fileRead.myRead();
        Map<String, Integer> iAmRead = fileRead.iAmRead1();

        Map.Entry<String, Integer> max = null;
        try (FileWriter fileWriter = new FileWriter("result.txt")) {
            for (Map.Entry<String, Integer> e : iAmRead.entrySet()) {
                String s = String.format("Слово %s встречается %d раз \n", e.getKey(), e.getValue());
                fileWriter.write(s);
                if (max == null || e.getValue() > max.getValue()) {
                    max = e;
                }
            }
            String s1 = String.format("Самое часто встречаемое слово :" + max + " раз(а) встречается\n");
            fileWriter.write(s1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}