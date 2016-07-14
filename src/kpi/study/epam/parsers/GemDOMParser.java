package kpi.study.epam.parsers;

import kpi.study.epam.entity.Color;
import kpi.study.epam.entity.Gemstone;
import kpi.study.epam.entity.Preciosness;
import kpi.study.epam.entity.VisualParameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * EPAM_Project_3_XML
 * Created 7/13/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class GemDOMParser implements AbstractGemParser{
    private List<Gemstone> gemstones;
    private DocumentBuilder dBuilder;
    private Document doc;
    public GemDOMParser() {
        gemstones = new ArrayList<>();
        try {
            dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public List<Gemstone> getStones(){
        return gemstones;
    }
    public void buildData(String filename){
        try {
            doc = dBuilder.parse(filename);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        Gemstone current = new Gemstone();
        NodeList nodeList = doc.getElementsByTagName(GemEnum.gemstone.get());
        for(int i = 0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                current.setId(element.getAttribute(GemEnum.id.get()));
                current.setName(element.getElementsByTagName(GemEnum.name.get()).item(0).getTextContent());
                current.setPreciosness(Preciosness.valueOf(element.getElementsByTagName(GemEnum.preciosness.get()).item(0).getTextContent()));
                current.setOrigin(element.getElementsByTagName(GemEnum.origin.get()).item(0).getTextContent());
                current.setValue(BigInteger.valueOf(Long.parseLong(element.getElementsByTagName(GemEnum.value.get()).item(0).getTextContent())));
                NodeList list = element.getElementsByTagName(GemEnum.visualParameters.get());
                VisualParameters vs = new VisualParameters();
                for (int j = 0; j < list.getLength(); j++) {
                    Node nNode = nodeList.item(i);
                    Element eElement = (Element) nNode;
                    vs.setColor(Color.valueOf(eElement.getElementsByTagName(GemEnum.color.get()).item(0).getTextContent()));
                    vs.setTransparency(Float.parseFloat(eElement.getElementsByTagName(GemEnum.transparency.get()).item(0).getTextContent()));
                    vs.setVerges(Integer.parseInt(eElement.getElementsByTagName(GemEnum.verges.get()).item(0).getTextContent()));
                }
                current.setVisualParameters(vs);
            }
            gemstones.add(current);
        }

    }
}
