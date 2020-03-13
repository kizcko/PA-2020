import java.util.ArrayList;
import java.util.List;

public class Hospital implements Comparable<Hospital> {
    private int capacity;
    List<String> preferences = new ArrayList<>();
    private String name;


    public Hospital(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Hospital o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                ", name='" + name + '\'' +
                '}';
    }
}
