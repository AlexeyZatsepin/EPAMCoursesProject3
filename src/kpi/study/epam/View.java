package kpi.study.epam;

import java.util.Scanner;

/**
 * EPAM_Project_3_XML
 * Created 7/11/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class View {
    public static final String MENU = "1.Get info\n2.Validate exist data with XSD. \n3.Add new note.\n4.Save\n5.Parse choicer\n6.Exit\n";
    public static final String ENTER_NAME = "Enter name(String):";
    public static final String ENTER_ORIGIN = "Enter origin(String):";
    public static final String ENTER_VALUES = "Enter transparency(%),verges , value of stone:";
    public static final String XML_VALID = "XML is valid.";
    public static final String XML_INVALID = "XML is invalid. ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String SUCCESS = "SUCCESS";
    public static final String PARSE_MENU = "1.DOM\n2.SAX \n3.StAX\n";

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
        INFO(1),VALIDATE(2),ADD(3),SAVE(4),PARSE(5),EXIT(6);
        final int value;

        Menu(int number) {
            value = number;
        }
    }
    public enum PARSER_CHOICE{
        SAX(2),DOM(1),StAX(3);
        final int value;

        PARSER_CHOICE(int number) {
            value = number;
        }

        public int getValue() {
            return value;
        }
    }
}
