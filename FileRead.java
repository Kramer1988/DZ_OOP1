import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FileRead implements TextRead {
    private String fileName;
    private Map<String, Integer> iRead;

    public FileRead(String fileName) {
        this.fileName = fileName;
        iRead = new TreeMap<>();
    }

    public FileRead() {

    }

    @Override
    public void myRead() {
        if (!iRead.isEmpty())
            return;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                String[] str = s.split("[^a-zA-Z]+");
                for (String a : str) {
                    if (!a.equals("")) //проверка на пустые строки
                        if (iRead.get(a.toLowerCase()) == null) {
                            iRead.put(a.toLowerCase(), 1);
                        } else {
                            Integer oldIRead = iRead.get(a.toLowerCase());
                            iRead.replace(a.toLowerCase(), oldIRead + 1);
                        }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<String, Integer> iAmRead1() {
        return iRead;
    }

}
