package com.company;
import java.util.Arrays;
import java.util.Random;

public class Main {

    static int isNeighbour(String firstString, String secondString) {
        char[] first = firstString.toCharArray();
        char[] second = secondString.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);

        int flag = 0;

        for (int i = 0; i < first.length; i++) {
            if (first[i] == second[i]) {
                flag = 1;
                return flag;
            }
        }
        return flag;
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

        try {

            long N = Integer.parseInt(args[0]);

            long K = Integer.parseInt(args[1]);

            System.out.println("N and K are valid.");

        } catch (NumberFormatException ex) {

            System.out.println("N and K are not valid.");

        }

        long N = Integer.parseInt(args[0]);
        long K = Integer.parseInt(args[1]);

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
        String[] words = new String[(int) N];
        String randomString = "";
        length = (int) K;

        Random rand = new Random();
        char[] text = new char[length];

        if (N < 50)
            System.out.print("The word array generated is: ");
        for (int i = 0; i < N; i++) {
            randomString = "";
            for (int j = 0; j < length; j++) {
                text[j] = alphabet.charAt(rand.nextInt(alphabet.length()));
            }

            for (int j = 0; j < text.length; j++) {
                randomString += text[j];
            }

            words[i] = randomString;
            if (N < 50)
                System.out.print(words[i] + " ");

        }
        System.out.println(" ");

        int[][] Matrix = new int[(int) N][(int) N];
        int adjacent;
        for (int i = 0; i < N; i++) {
            adjacent = 0;
            for (int j = 0; j < N; j++) {
                if (isNeighbour(words[i], words[j]) == 1) {
                    Matrix[i][j] = 1;
                    adjacent++;
                } else
                    Matrix[i][j] = 0;
                if (i == j)
                    Matrix[i][i] = 0;
            }
            Matrix[i][i] = adjacent - 1;
        }

        int max = Matrix[0][0];
        int min = Matrix[0][0];
        int flag = 0;

        if (N > 10)
            flag = 1;

        for (int i = 0; i < N; i++) {
            if (min >= Matrix[i][i])
                min = Matrix[i][i];
            if (max <= Matrix[i][i])
                max = Matrix[i][i];
            if (flag == 0) {
                System.out.print(i + ": ");
                for (int j = 0; j < N; j++) {
                    if (i != j)
                        System.out.print(Matrix[i][j] + " ");
                    else
                        System.out.print('0' + " ");
                }
                System.out.println(" ");
            }
        }

        if (min == max) {
            System.out.println("All the words have the same number of neighbours" + min);
            System.out.print("All the words are connected : ");
            for (String word : words) System.out.print(word + " ");
        } else
            for (int i = 0; i < N; i++) {
                if (Matrix[i][i] == min)
                    System.out.println(words[i] + " has the lowest number of neighbours.");
                if (Matrix[i][i] == max)
                    System.out.println(words[i] + " has the highest number of neighbours.");
            }
        long nano_endTime = System.nanoTime();
        System.out.println("Time taken in nano seconds: " + (nano_endTime - nano_startTime));

    }

}
