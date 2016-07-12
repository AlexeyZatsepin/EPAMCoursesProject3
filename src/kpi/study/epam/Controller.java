package kpi.study.epam;

import kpi.study.epam.config.Resources;
import kpi.study.epam.entity.GemFund;
import kpi.study.epam.entity.Gemstone;

import java.util.Scanner;

import static kpi.study.epam.View.Menu.*;
import static kpi.study.epam.View.XML_INVALID;
import static kpi.study.epam.View.XML_VALID;
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
                Gemstone gemstone = new Gemstone();

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
}
