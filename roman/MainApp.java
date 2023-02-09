import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException;

class MainApp {
    public static void main(String[] args) {

        System.out.println("Test Application for the RomanNumeral class\n");

        // DECLARE TWO ROMAN NUMERALS USING EXPLICIT AND DEFAULT CONSTRUCTORS.
        RomanNumeral x1 = new RomanNumeral("DXI");
        RomanNumeral x2 = new RomanNumeral("");

        // BUILD A STRING CONTAINING ALL THE REQUIRED TEST CASE SCENARIOS
        String testCaseResults = "";

        // TEST 1: VERIFY THE INITIAL VALUES OF x1 AND x2. COMPARE BOTH OBJECTS
        testCaseResults += "x1 is " + x1.getRomanValue() + " with a decimal value of " + x1.getDecimalValue() + "\n";
        testCaseResults += "x2 is " + x2.getRomanValue() + " with a decimal value of " + x2.getDecimalValue() + "\n";
        testCaseResults += "x1 and x2 are equal?  " + x1.equalTo(x2) + "\n";

        // TEST 2: RESET THE ROMAN VALUE FOR X2 AND COMPARE BOTH OBJECTS AGAIN
        testCaseResults += "\nReset x2:" + "\n";
        x2.setRomanValue("XID");
        testCaseResults += "x2 is now " + x2.getRomanValue() + " with a decimal value of " + x2.getDecimalValue()
                + "\n";
        testCaseResults += "x1 and x2 are equal?  " + x1.equalTo(x2) + "\n";

        // TEST 3: INCREMENT X2 by 2 AND COMPARE BOTH OBECTS AGAIN
        testCaseResults += "\nIncrement x2:" + "\n";
        x2.increment();
        testCaseResults += "x2 is now " + x2.getRomanValue() + " with a decimal value of " + x2.getDecimalValue()
                + "\n";
        testCaseResults += "x1 and x2 are equal?  " + x1.equalTo(x2) + "\n";

        // DISPLAY THE TEST CASE RESULTS STRING TO THE CONSOLE
        System.out.print(testCaseResults);

        // FINAL TASK: WRITE THE TEST CASE RESULTS TO A TEXT FILE
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(testCaseResults);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
