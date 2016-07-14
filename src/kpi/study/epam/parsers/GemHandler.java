package kpi.study.epam.parsers;

import kpi.study.epam.entity.Color;
import kpi.study.epam.entity.Gemstone;
import kpi.study.epam.entity.Preciosness;
import kpi.study.epam.entity.VisualParameters;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * EPAM_Project_3_XML
 * Created 7/12/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class GemHandler extends DefaultHandler {
    private List<Gemstone> list = new ArrayList<>();
    private Gemstone gem = new Gemstone();
    private VisualParameters vs = new VisualParameters();
    private String tId = null;
    private boolean bName = false;
    private boolean bPreciosness = false;
    private boolean bOrigin = false;
    private boolean bVS = false;
    private boolean bValue = false;

    private boolean bColor = false;
    private boolean bTransparency = false;
    private boolean bVerges = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("gemstone")){
            tId = attributes.getValue("id");
        }else if(qName.equalsIgnoreCase("name")){
            bName = true;
        }else if(qName.equalsIgnoreCase("preciosness")){
            bPreciosness = true;
        }else if(qName.equalsIgnoreCase("origin")){
            bOrigin = true;
        }else if(qName.equalsIgnoreCase("visualParameters")){
            bVS = true;
        }else if(qName.equalsIgnoreCase("value")){
            bValue = true;
        }else if(qName.equalsIgnoreCase("color")){
            bColor = true;
        }else if(qName.equalsIgnoreCase("transparency")){
            bTransparency = true;
        }else if(qName.equalsIgnoreCase("verges")){
            bVerges = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("gemstone")){
            list.add(gem);
            gem = new Gemstone();
        }
        if(qName.equalsIgnoreCase("visualParameters")){
            gem.setVisualParameters(vs);
            vs = new VisualParameters();
            bVS = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(bName){
            gem.setName(new String(ch,start,length));
            bName = false;
        }else if(bPreciosness){
            gem.setPreciosness(Preciosness.valueOf(new String(ch,start,length)));
            bPreciosness = false;
        }else if(bOrigin){
            gem.setOrigin(new String(ch,start,length));
            bOrigin = false;
        }else if(bVS){
            if (bColor){
                vs.setColor(Color.valueOf(new String(ch,start,length)));
                bColor = false;
            }else if(bTransparency){
                vs.setTransparency(Float.valueOf(new String(ch,start,length)));
                bTransparency = false;
            }else if(bVerges){
                vs.setVerges(Integer.valueOf(new String(ch,start,length)));
                bVerges = false;
            }
        }else if(bValue){
            gem.setValue(BigInteger.valueOf(Long.valueOf(new String(ch,start,length))));
            bValue = false;
        }
    }
    public List<Gemstone> getResult(){
        return list;
    }
}
