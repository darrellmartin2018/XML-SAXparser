/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author darrellmartin
 */
public class Loader {
    private static String text="";
    public static void loadXML(File xmlCourseFile) throws Exception{
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
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
            saxParser.parse(xmlCourseFile.getAbsoluteFile(), handler);
        } catch(IOException | SAXException ex){
            throw ex;
        }
    }
    public String getTextBody(){
        return this.text;
    }
    public void setTextBody(){
        this.text = "";
    }
}
