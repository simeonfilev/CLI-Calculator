package com.sap.acad.calculator_cli;

import org.junit.jupiter.api.*;
import com.sap.acad.calculator.Calculator;

import java.io.*;


public class MainTest {
    private static Calculator calculator;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final InputStream inputBackup = System.in;
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(inputBackup);
    }

    @Test
    public void userWantsToExitIsWorkingCorrectly() {
        Assertions.assertTrue(Main.userWantsToQuit("exit"));
        Assertions.assertTrue(Main.userWantsToQuit("ExIt"));
        Assertions.assertTrue(Main.userWantsToQuit("  ExIt   "));
        Assertions.assertFalse(Main.userWantsToQuit("ExIt1"));
    }

    @Test
    public void systemOutIsWorkingCorrectly() {
        outContent.reset();
        Double testString = calculator.calculate("5+2*3");
        System.out.print(testString);
        Assertions.assertEquals("11.0", outContent.toString());

    }

    @Test
    public void calculatorIsWorkingCorrectly() {
        Assertions.assertEquals(11, calculator.calculate("5+2*3"));
        Assertions.assertEquals(11, calculator.calculate("5+3*2"));
        Assertions.assertEquals(2, calculator.calculate("((5+3)/2)/2"));
        Assertions.assertThrows(UnsupportedOperationException.class, () -> calculator.calculate("()5+2))"));
        Assertions.assertEquals(18, calculator.calculate("(2+3*4)+3*2-2"));
    }


    @Test
    public void mainMethodIsWorkingCorrectly() throws IOException {
        outContent.reset();
        String toTest = "5+3*2" + System.lineSeparator() + "exit" + System.lineSeparator();

        ByteArrayInputStream in = new ByteArrayInputStream(toTest.getBytes());
        System.setIn(in);
        Main.main(null);
        String output = outContent.toString();
        String expected = "=========================\r\n" +
                "Calculator\r\n" +
                "Enter 'exit' to exit\r\n" +
                "=========================\r\n" +
                "Enter expression:5+3*2 = 11.0\r\n" +
                "Enter expression:Thank you for using the calculator!\r\n";


        Assertions.assertEquals(expected, output);
    }


}
