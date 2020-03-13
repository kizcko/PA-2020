import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class Main {


    public static void main(String[] args) {
        Resident[] residents= IntStream.rangeClosed(0,3).mapToObj(i-> new Resident("R" + i)).toArray(Resident[]::new);
        Hospital[] hospitals= IntStream.rangeClosed(0,2).mapToObj(i-> new Hospital("H" + i)).toArray(Hospital[]::new);

        //List
        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(residents));
        Collections.sort(residentList,Comparator.comparing(Resident::getName));
        //Set
        TreeSet<Hospital> hospitalSet = new TreeSet<>();
        hospitalSet.addAll(Arrays.asList(hospitals));
        //Maps
        Map<Resident,List<Hospital>> residentPrefMap=new HashMap<>();

        residentPrefMap.put(residents[0],Arrays.asList(hospitals[0],hospitals[1],hospitals[2]));
        residentPrefMap.put(residents[1],Arrays.asList(hospitals[0],hospitals[1],hospitals[2]));
        residentPrefMap.put(residents[2],Arrays.asList(hospitals[0],hospitals[1]));
        residentPrefMap.put(residents[3], Arrays.asList(hospitals[0],hospitals[2]));


        Map<Hospital,List<Resident>> hospitalPrefMap=new HashMap<>();
        hospitalPrefMap.put(hospitals[0],Arrays.asList(residents[3],residents[0],residents[1],residents[2]));
        hospitalPrefMap.put(hospitals[1],Arrays.asList(residents[0],residents[2],residents[1]));
        hospitalPrefMap.put(hospitals[2],Arrays.asList(residents[0],residents[1],residents[3]));


        //System.out.println(residentPrefMap);

        List<Hospital> target =Arrays.asList(hospitals[0],hospitals[1]);
        List<Resident> result = residentList.stream().filter(resident->residentPrefMap.get(resident).containsAll(target)).collect(Collectors.toList());
        System.out.println(result);


        hospitalSet.stream().filter(hospital -> hospitalPrefMap.get(hospital).contains(residents[0])).forEach(System.out::println);













    }



}
