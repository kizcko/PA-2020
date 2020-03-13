import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Resident {
    List<Resident> residentList =new ArrayList<>();


    List<String> preferences = new ArrayList<>();
    private String name;

    public Resident(String name) {
        this.name = name;
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
    public String toString() {
        return "Resident{" +
                "name='" + name + '\'' +
                '}';
    }
}
