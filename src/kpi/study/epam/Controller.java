package kpi.study.epam;

import kpi.study.epam.config.Resources;
import kpi.study.epam.entity.*;
import kpi.study.epam.parsers.AbstractGemParser;
import kpi.study.epam.parsers.GemDOMParser;
import kpi.study.epam.parsers.GemSAXParser;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;
import static kpi.study.epam.View.*;
import static kpi.study.epam.View.Menu.*;
import static kpi.study.epam.utils.XMLUtils.isValidXMLbyXSD;
import static kpi.study.epam.utils.XMLUtils.marshalizate;
import static kpi.study.epam.utils.XMLUtils.unmarshlize;

/**
 * EPAM_Project_3_XML
 * Created 7/11/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void start(){
        AbstractGemParser parser = null;
        GemFund fund = null;
        int i=0;
        while (i != EXIT.value){
            view.printMessage(View.MENU);
            i = inputIntValueWithScanner(view.getScanner());
            if(i==INFO.value){
                fund = unmarshlize(Resources.getInstance().getResourceName());
                view.printMessage(fund.toString());
            }else if(i == VALIDATE.value){
                if (isValidXMLbyXSD(Resources.getInstance().getResourceName(), Resources.getInstance().getSchemaName())){
                    view.printMessage(XML_VALID);
                }else{
                    view.printMessage(XML_INVALID);
                }
            }else if(i==ADD.value){
                fund = unmarshlize(Resources.getInstance().getResourceName());
                Gemstone nGemstone = new Gemstone();//TODO: add
                Random random = new Random();
                nGemstone.setId("TT"+ abs(random.nextInt())%100);
                view.printMessage(View.ENTER_NAME);
                nGemstone.setName(inputStringValueWithScanner(view.getScanner()));
                nGemstone.setPreciosness(Preciosness.COMMON);
                view.printMessage(View.ENTER_ORIGIN);
                nGemstone.setOrigin(inputStringValueWithScanner(view.getScanner()));
                view.printMessage(View.ENTER_VALUES);
                VisualParameters vs = new VisualParameters();
                vs.setColor(Color.GREEN);
                vs.setTransparency((float)inputIntValueWithScanner(view.getScanner())/100);
                vs.setVerges(inputIntValueWithScanner(view.getScanner()));
                nGemstone.setVisualParameters(vs);
                nGemstone.setValue(BigInteger.valueOf(inputIntValueWithScanner(view.getScanner())));
                fund.add(nGemstone);
            }else if(i==PARSE.value){

                view.printMessage(View.PARSE_MENU);
                i = inputIntValueWithScanner(view.getScanner());
                fund = new GemFund();
                if(i==PARSER_CHOICE.DOM.getValue()){
                    parser = new GemDOMParser();
                }else if(i==PARSER_CHOICE.SAX.getValue()){
                    parser = new GemSAXParser();
                }else if(i==PARSER_CHOICE.StAX.getValue()){
                    parser = new GemSAXParser();
                }else{
                    fund = unmarshlize(Resources.getInstance().getResourceName());
                }
                parser.buildData(Resources.getInstance().getResourceName());
                fund.setGemstone(parser.getStones());
                view.printMessage(fund.toString());
            }else if (i==SAVE.value){
                marshalizate(fund,Resources.getInstance().getResourceName());
                view.printMessage(View.SUCCESS);
            }
        }
        view.close();
    }


    public int inputIntValueWithScanner(Scanner sc) {
        while(! sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA + View.INPUT_INT_DATA);
            sc.next();

        }
        return sc.nextInt();
    }
    public String inputStringValueWithScanner(Scanner sc) {
        while(! sc.hasNextLine()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA + View.INPUT_INT_DATA);
            sc.next();

        }
        return sc.nextLine();
    }
}
