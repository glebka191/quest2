package Innotech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<Two> readInList(String fileName){
        List<Two> list = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            String line = fileReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                list.add(new Two(Integer.parseInt(data[0]), data[1]));
                line = fileReader.readLine();
            }
        }catch (IOException e){
            System.out.printf("Ошибка чтения");
        }
        return list;
    }
}
