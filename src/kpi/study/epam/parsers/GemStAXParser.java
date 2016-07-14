package kpi.study.epam.parsers;

import kpi.study.epam.entity.Color;
import kpi.study.epam.entity.Gemstone;
import kpi.study.epam.entity.Preciosness;
import kpi.study.epam.entity.VisualParameters;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.*;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * EPAM_Project_3_XML
 * Created 7/14/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class GemStAXParser implements AbstractGemParser {
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
    public void buildData(String filename) {
        try{
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(filename));
            while (eventReader.hasNext()){
                XMLEvent event = eventReader.nextEvent();
                switch(event.getEventType()){
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if(qName.equalsIgnoreCase(GemEnum.gemstone.get())){
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            tId = attributes.next().getValue();
                        }else if(qName.equalsIgnoreCase(GemEnum.name.get())){
                            bName = true;
                        }else if(qName.equalsIgnoreCase(GemEnum.preciosness.get())){
                            bPreciosness = true;
                        }else if(qName.equalsIgnoreCase(GemEnum.origin.get())){
                            bOrigin = true;
                        }else if(qName.equalsIgnoreCase(GemEnum.visualParameters.get())){
                            bVS = true;
                        }else if(qName.equalsIgnoreCase(GemEnum.value.get())){
                            bValue = true;
                        }else if(qName.equalsIgnoreCase(GemEnum.color.get())){
                            bColor = true;
                        }else if(qName.equalsIgnoreCase(GemEnum.transparency.get())){
                            bTransparency = true;
                        }else if(qName.equalsIgnoreCase(GemEnum.verges.get())){
                            bVerges = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(bName){
                            gem.setName(characters.getData());
                            bName = false;
                        }else if(bPreciosness){
                            gem.setPreciosness(Preciosness.valueOf(characters.getData()));
                            bPreciosness = false;
                        }else if(bOrigin){
                            gem.setOrigin(characters.getData());
                            bOrigin = false;
                        }else if(bVS){
                            if (bColor){
                                vs.setColor(Color.valueOf(characters.getData()));
                                bColor = false;
                            }else if(bTransparency){
                                vs.setTransparency(Float.valueOf(characters.getData()));
                                bTransparency = false;
                            }else if(bVerges){
                                vs.setVerges(Integer.valueOf(characters.getData()));
                                bVerges = false;
                            }
                        }else if(bValue){
                            gem.setValue(BigInteger.valueOf(Long.parseLong(characters.getData())));
                            bValue = false;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if(endElement.getName().getLocalPart().equalsIgnoreCase("gemstone")){
                            list.add(gem);
                            gem = new Gemstone();
                        }
                        if(endElement.getName().getLocalPart().equalsIgnoreCase("visualParameters")){
                            gem.setVisualParameters(vs);
                            vs = new VisualParameters();
                            bVS = false;
                        }
                        break;
                }
            }
        } catch (Exception ignored){}
    }

    @Override
    public List<Gemstone> getStones() {
        return list;
    }
}
