package Innotech;

import java.util.*;
import java.util.stream.Collectors;

public class InnerJoin {

    public static List<Triple> IJoinArrayList(ArrayList<Two> listA, ArrayList<Two> listB){
        List <Triple> result = new ArrayList<>();
        for (Two twoA : listA){
            for (Two twoB : listB){
                if (twoA.getId() == twoB.getId())
                    result.add(new Triple(twoB.getId(),twoA.getValue(),twoB.getValue()));
            }
        }
        return result;
    }



    public static List<Triple> IJoinLinkedList(LinkedList<Two> listA, LinkedList<Two> listB){
        List<Triple> result = listA.stream()
                .flatMap(two -> listB.stream()
                        .filter(two1 -> two.getId()==two1.getId())
                        .map(two1 -> new Triple(two1.getId(), two.getValue(),two1.getValue())))
                .collect(Collectors.toList());

        return result;
             }




    public static List<Triple> IJpinHashMap(List<Two> listA, List<Two> listB){
        List<Triple> result = new ArrayList<>();
        Map<Integer, List<String>> mapA = new HashMap<>();
        Map<Integer, List<String>> mapB = new HashMap<>();

        for (Two twoA : listA) {
            List<String> variants = mapA.getOrDefault(twoA.getId(), new ArrayList<>());
            variants.add(twoA.getValue());
            mapA.put(twoA.getId(), variants);
        }

        for (Two twoB : listB) {
            List<String> variants = mapB.getOrDefault(twoB.getId(), new ArrayList<>());
            variants.add(twoB.getValue());
            mapB.put(twoB.getId(), variants);
        }

        for (Map.Entry<Integer, List<String>> twoB : mapB.entrySet()) {
            List<String> VariantsA = mapA.get(twoB.getKey());
            if (VariantsA != null) {
                for (String valueA : VariantsA){
                    for (String valueB : twoB.getValue())
                        result.add(new Triple(twoB.getKey(), valueA, valueB));
                }
            }
        }
        return result;
    }
}
