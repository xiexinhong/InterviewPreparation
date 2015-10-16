package org.xiexh.appcore.xmlparser;

import org.xiexh.appcore.global.InterviewPreparationApplication;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 此段带吗有待完善
 * Created by Administrator on 2015/10/16.
 */
public class SAXParserTest {

    public List<River> getRiversFormXml(String fileName) {
        List<River> rivers = new ArrayList<River>();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            RiverHandler handler = new RiverHandler();
            parser.parse(new InputSource(InterviewPreparationApplication.getContext().getAssets().open(fileName)), handler);
            rivers = handler.getRivers();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rivers;
    }
    class RiverHandler extends DefaultHandler {

        List<River> rivers = null;
        private River river = null;
        private String preTAg = null;
        public List<River> getRivers() {
            return rivers;
        }

        @Override
        public void startDocument() throws SAXException {
            rivers = new ArrayList<River>();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(River.RIVER.equals(qName)) {
                river = new River();
                river.setName(attributes.getValue(River.NAME));
                river.setLength(Integer.parseInt(attributes.getValue(River.LENGTH)));
            }
            preTAg = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(River.RIVER.equals(qName)) {
                rivers.add(river);
                river = null;
            }
            preTAg = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(preTAg != null) {
                String content = new String(ch,start,length) ;

                if(River.INTRODUCTION.equals(preTAg)) {
                    river.setIntroduction(content);
                } else  if(River.IMAGEURL.equals(preTAg)) {
                    river.setImageurl(content);
                }
            }
        }
    }

}
