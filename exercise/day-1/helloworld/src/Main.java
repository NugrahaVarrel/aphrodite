import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello World");

        long myNumberLong = 12304;
        int myNumber = 10;
        float myNumberFloat = 1.52F;
        double myNumberDouble = 1.52235;
        char myNumberChar = 'A';
        boolean myNumberBool = true;
        String myString = "Bismillah";
        int [] nilaiArrays = {1,2,3,4,5,6};


        System.out.println("myNumberLong : " + myNumberLong);
        System.out.println("myNumberInt : " + myNumber);
        System.out.println("myNumberFloat : " + myNumberFloat);
        System.out.println("myNumberDouble : " + myNumberDouble);
        System.out.println("myNumberChar : " + myNumberChar);
        System.out.println("myNumberBoolean : " + myNumberBool);
        System.out.println("myNumberString : " + myString);
        System.out.println("Array : " + Arrays.toString(nilaiArrays));
    }
}