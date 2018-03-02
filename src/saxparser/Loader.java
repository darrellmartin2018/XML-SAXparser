/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author dale/darrellmartin
 */
public class Loader {
    
    private static String text="";
    
    public static void loadXML(File xmlFile) throws Exception{
        
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)throws SAXException {
                    text += " <" + qName + "> ";
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    text += " <" + qName + "> ";
                }
                @Override
                public void characters(char[] ch, int start, int length) {
                    text += " " + new String(ch, start, length);
                }
                
            };
            parser.parse(xmlFile.getAbsoluteFile(), handler);
        } catch(SAXException ex){
            throw ex;
        }
    }
    public String getText(){
        return this.text;
    }
    public void setText(){
        this.text = "";
    }
}
