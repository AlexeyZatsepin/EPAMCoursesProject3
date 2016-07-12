package kpi.study.epam.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * EPAM_Project_3_XML
 * Created 7/11/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Resources {
    private static final String CONFIG_FILE = "config.properties";
    private static final String XML_FILE_NAME = "resource.file";
    private static final String XML_SCHEMA_FILE_NAME = "resource.schema";
    private static Resources instance;
    private String fileName;
    private String schemaName;

    private Resources() {
        load();
    }

    public String getResourceName() {
        return fileName;
    }
    public String getSchemaName(){
        return schemaName;
    }

    public static Resources getInstance(){
        if(instance == null){
            instance = new Resources();
        }
        return instance;
    }

    private void load() {
        Properties props = new Properties();
        try( InputStream in= new BufferedInputStream(
                new FileInputStream(CONFIG_FILE) ) ){
            props.load(in);
            fileName = props.getProperty(XML_FILE_NAME);
            schemaName = props.getProperty(XML_SCHEMA_FILE_NAME);
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }

    }


}