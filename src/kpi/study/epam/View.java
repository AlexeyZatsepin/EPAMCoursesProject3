package kpi.study.epam;

import java.util.Scanner;

/**
 * EPAM_Project_3_XML
 * Created 7/11/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class View {
    public static final String MENU = "1.Get info\n2.Validate exist data with XSD. \n3.Add new note.\n4.Save\n5.Exit";
    public static final String ASK_TO_PARSE = "Do you want to parse XML file?(y/n)";
    public static final String ENTER_PARSER = "Enter parser type (sax, stax, dom): ";
    public static final String ADD_QUETION = "Do you want add some info? (y/n)";
    public static final String XML_VALID = "XML is valid.";
    public static final String XML_INVALID = "XML is invalid. ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String SUCCESS = "SUCCESS";

    public static final String YES ="y";
    public static final String NO ="n";

    private Scanner sc = new Scanner(System.in);

    public void printMessage(String message){
        System.out.println(message);
    }

    public Scanner getScanner(){
        return sc;
    }
    public void close(){
        sc.close();
    }

    public enum Menu{
        INFO(1),VALIDATE(2),ADD(3),SAVE(4),EXIT(5);
        final int value;

        Menu(int number) {
            value = number;
        }
    }
}
