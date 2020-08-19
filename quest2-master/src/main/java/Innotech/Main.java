package Innotech;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Two> arrayListA = (ArrayList<Two>) ReadFile.readInList(args[0]);
            ArrayList<Two> arrayListB = (ArrayList<Two>) ReadFile.readInList(args[1]);
            List<Triple> resultArrayList = InnerJoin.IJoinArrayList(arrayListA, arrayListB);
            resultArrayList.forEach(triple -> System.out.println(triple));

            System.out.println("-----------------------------");

            LinkedList<Two> linkedListA = new LinkedList<>(arrayListA);
            LinkedList<Two> linkedListB = new LinkedList<>(arrayListB);
            Collections.sort(linkedListA);
            Collections.sort(linkedListB);
            List<Triple> resultLinkedList = InnerJoin.IJoinLinkedList(linkedListA, linkedListB);
            resultLinkedList.forEach(triple -> System.out.println(triple));

            System.out.println("-----------------------------");

            List<Triple> resultHashMap = InnerJoin.IJpinHashMap(arrayListA, arrayListB);
            resultHashMap.forEach(triple -> System.out.println(triple));

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Не указаны файлы для чтения или записи");
        }
    }
}
