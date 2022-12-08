import javax.swing.*;
import java.io.*;
import java.util.Collections;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //  �������
        //  � ��� ������� ��������� ���� text.txt. ���������� � ���� ������, ��� ����� ����������� ������ �����,
        //   ����� �������� � ��������� ���� result.txt ������ ����������.
        //  �����, � ����� ����� ����� �������� ����� ����� ����������� ����� � ��� �������.

        FileRead fileRead = new FileRead("text.txt");
        fileRead.myRead();
        Map<String, Integer> iAmRead = fileRead.iAmRead1();

        Map.Entry<String, Integer> max = null;
        try (FileWriter fileWriter = new FileWriter("result.txt")) {
            for (Map.Entry<String, Integer> e : iAmRead.entrySet()) {
                String s = String.format("����� %s ����������� %d ��� \n", e.getKey(), e.getValue());
                fileWriter.write(s);
                if (max == null || e.getValue() > max.getValue()) {
                    max = e;
                }
            }
            String s1 = String.format("����� ����� ����������� ����� :" + max + " ���(�) �����������\n");
            fileWriter.write(s1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}