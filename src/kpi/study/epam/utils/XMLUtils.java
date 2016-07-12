package kpi.study.epam.utils;

import kpi.study.epam.config.Resources;
import kpi.study.epam.entity.GemFund;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

/**
 * EPAM_Project_3_XML
 * Created 7/11/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class XMLUtils {  //SAX
    private static String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;

    public static boolean isValidXMLbyXSD(String filename,String schemaName) {
        SchemaFactory factory = SchemaFactory.newInstance(lang);
        boolean isValid = false;
        try {
            Schema schema = factory.newSchema(new File(schemaName));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);
            validator.validate(source);
            isValid = true;
        } catch (SAXException | IOException e) {
            e.getStackTrace();
        }
        return isValid;
    }

    public static void marshalizate(GemFund fund, String filename){
        try{
            JAXBContext context = JAXBContext.newInstance(GemFund.class);
            Marshaller m = context.createMarshaller();
//            GemFund gf = new GemFund();
//            VisualParameters vp = new VisualParameters(Color.RED , 0.5f , 6);
//            Gemstone stone = new Gemstone("Yantar", Preciosness.COMMON,
//                        "Kiev",vp, BigInteger.valueOf(10),"TT-10");
//            gf.add(stone);
            m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, Resources.getInstance().getSchemaName().replaceFirst("res/",""));
            //m.marshal(gf,new FileOutputStream("res/result.xml"));
            m.marshal(fund,new FileOutputStream(filename));
        }catch (FileNotFoundException | JAXBException e){
            e.getStackTrace();
        }
    }

    public static GemFund unmarshlize(String filename) {
        try{
            JAXBContext context = JAXBContext.newInstance(GemFund.class);
            Unmarshaller u = context.createUnmarshaller();
            FileReader reader = new FileReader(filename);
            return (GemFund) u.unmarshal(reader);
        }catch (FileNotFoundException | JAXBException e){
            e.getStackTrace();
        }
        return null;
    }
}
