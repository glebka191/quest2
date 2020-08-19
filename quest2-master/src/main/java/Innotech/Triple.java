package Innotech;

public class Triple {
    private int id;
    private String valueA;
    private String valueB;

    public Triple(int id, String valueA, String valueB) {
        this.id = id;
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public int getId() {
        return id;
    }

    public String getValueA() {
        return valueA;
    }

    public String getValueB() {
        return valueB;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "id=" + id +
                ", valueA='" + valueA + '\'' +
                ", valueB='" + valueB + '\'' +
                '}';
    }
}
