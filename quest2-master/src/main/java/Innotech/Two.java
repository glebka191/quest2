package Innotech;

public class Two implements Comparable<Two>{
    private int id;
    private String value;

    public Two(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public int compareTo(Two o) {
        int compare = this.getId() - o.getId();
        if (compare == 0)
            return this.value.compareTo(o.getValue());
        return compare;
    }
}