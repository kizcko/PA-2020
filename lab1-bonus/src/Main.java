import java.util.Arrays;
import java.util.Random;

public class Main {

    static boolean isAdiacent(String firstString, String secondString, int k) {
        char[] first = firstString.toCharArray();
        char[] second = secondString.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        for (int i = 0; i < k; i++) {
            if (first[i] == second[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        //Compulsory

        /*final long startTime = System.nanoTime();
        System.out.println("Hello World");
        System.out.println();
        String[] languages = {"C", "C++", "C#", "Go", "JavaScript", "Perl", "PHP", "Python", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        int result = 0;
        int ok = 0;
        while ((n / 10) > 0)
        {
            int sum = 0;
            while (n != 0) {
                sum = n % 10;
                n = n / 10;
            }
            result = sum;
        }
        System.out.println("Willy-nilly, this semester i will learn " + languages[result] + ".");
        System.out.println();
        */

        //Optional


        long nano_startTime = System.nanoTime();

        int n = Integer.parseInt(args[0]);
        int K = Integer.parseInt(args[1]);

        //Verificam daca literele din input pot fi un alfabet.

        char[] letter;
        letter = new char[args.length - 2];

        for (int i = 2; i < args.length; i++) {

            letter[i - 2] = args[i].charAt(0);

            if (!Character.isLetter(letter[i - 2])) {
                System.out.println("The input is not an alphabet, " + args[i] + " is not a letter.");
                break;
            }

        }

        System.out.println("The input is a valid alphabet.");

        //Sortam alfabetul dat si eliminam duplicatele.

        Arrays.sort(letter);

        char[] alphabetAux = new char[letter.length];
        int k = 0;
        int length = 1;
        alphabetAux[k++] = letter[0];

        for (int i = 1; i < letter.length; i++) {
            if (alphabetAux[k - 1] == letter[i])
                i++;
            else {
                alphabetAux[k++] = letter[i];
                length++;
            }
        }

        char[] dictionary = new char[length];

        for (int i = 0; i < length; i++)
            dictionary[i] = alphabetAux[i];

        //Generam cuvintele.

        String alphabet = new String(dictionary);
        String[] words = new String[(int) n];
        StringBuilder randomString = new StringBuilder();
        length = (int) K;

        Random rand = new Random();
        char[] text = new char[length];

        if (n < 50)
            System.out.print("The word array generated is: ");
        for (int i = 0; i < n; i++) {
            randomString = new StringBuilder();
            for (int j = 0; j < length; j++) {
                text[j] = alphabet.charAt(rand.nextInt(alphabet.length()));
            }

            for (char c : text) {
                randomString.append(c);
            }

            words[i] = randomString.toString();
            if (n < 50)
                System.out.print(words[i] + " ");

        }
        System.out.println(" ");







        boolean[][] adjacency = new boolean[n][n];
        int max = 0;
        int min = Integer.MAX_VALUE;
        int[] nrOfNeighbors = new int[n];
        Arrays.fill(nrOfNeighbors, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (isAdiacent(words[i], words[j], k)) {
                        adjacency[i][j] = true;
                        nrOfNeighbors[i]++;
                    } else {
                        adjacency[i][j] = false;
                    }
                }
                System.out.print(adjacency[i][j] ? "1 " : "0 ");
            }


            if (nrOfNeighbors[i] > max) {
                max = nrOfNeighbors[i];
            }

            if (nrOfNeighbors[i] < min) {
                min = nrOfNeighbors[i];
            }
            System.out.println();
            }

            if (min == max) {
                System.out.println("All the words have the same number of neighbours" + min);
                System.out.print("All the words are connected : ");
                for (String word : words) System.out.print(word + " ");
            }
        System.out.println("MIN : "+ min);

        System.out.println("MAX : "+ max);


            long nano_endTime = System.nanoTime();


            System.out.println("Time taken in nano seconds: " + (nano_endTime - nano_startTime));





        Graph graph = new Graph(adjacency, n);

        System.out.println("Componente conexe: " + graph.getConexNumber());
        System.out.println();

        for(Integer component : graph.getConexComponents().keySet()){
            System.out.println("Componenta " + component);
            for(Integer wordIndex : graph.getConexComponents().get(component)){
                System.out.print(words[wordIndex] + " ");
            }
            System.out.println();
        }


        }




    }
