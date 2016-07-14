package kpi.study.epam.parsers;

import kpi.study.epam.entity.Gemstone;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * EPAM_Project_3_XML
 * Created 7/12/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class GemSAXParser implements AbstractGemParser{
    private GemHandler handler;
    private SAXParser parser;
    public GemSAXParser(){
        handler = new GemHandler();
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
        }catch (SAXException | ParserConfigurationException e){
            e.printStackTrace();
        }
    }
    public List<Gemstone> getStones(){
        return handler.getResult();
    }
    public void buildData(String filename){
        try{
            parser.parse(new File(filename), handler);
        }catch (IOException ignored){

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
