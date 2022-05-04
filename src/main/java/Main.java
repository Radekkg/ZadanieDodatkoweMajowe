import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int trueCounter = 0;
    static int falseCounter = 0;

    public static void main(String[] args) {
        File file = new File("dane.txt");
        String line = "";
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                passwordTest(line);

            }
            System.out.println("poprawnych: "+ trueCounter + " błendnych: "+ falseCounter);
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }
    }

    private static void passwordTest(String line) {
        int counter= 0;

        //Dzielenie ciągu znaków na części

        //Część z warunkami
        String[] splitLine = line.split(":");
        String[] howMannyTimesAndLetter = splitLine[0].split(" "); //howMannyTimesAndLetter[1] = letter
        char[] character = howMannyTimesAndLetter[1].toCharArray();
        String[] rangeLetters = howMannyTimesAndLetter[0].split("-");

        int firstNumber = Integer.parseInt(rangeLetters[0]);
        int secondNumber = Integer.parseInt(rangeLetters[1]);

        //Część z hasłem do sprawdzenia
        String trim = splitLine[1].trim();
        char[] charsRight = trim.toCharArray();

        //Porównanie hasla z literą i naliczanie ilosci wystąpień
        for (int i = 0; i < charsRight.length; i++) {
            if(character[0] == charsRight[i]){
                counter++;
            }
        }
        //Warunek poprawności
        if ((counter>=firstNumber)&&(counter<=secondNumber)){
            System.out.println("poprawny");
            trueCounter++;
        }else {
            System.out.println("błędny");
            falseCounter++;
        }
    }
}
