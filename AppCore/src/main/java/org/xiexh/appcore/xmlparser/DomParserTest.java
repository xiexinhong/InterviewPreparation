package org.xiexh.appcore.xmlparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xiexh.appcore.global.InterviewPreparationApplication;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/16.
 */
public class DomParserTest {


    public List<River> getRiverForXml(String fileName) {
        List<River> rivers = new ArrayList<River>();
        DocumentBuilderFactory factory = null;
        DocumentBuilder builder = null;
        Document document = null;
        InputStream inputStream = null;
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            inputStream = InterviewPreparationApplication.getContext().getResources().getAssets().open(fileName);
            document = builder.parse(inputStream);
            Element root = document.getDocumentElement();
            NodeList nodes = root.getElementsByTagName(River.RIVER);

            River river = null;
            for(int i=0;i<nodes.getLength();i++) {
                river = new River();
                Element riverElement = (Element) (nodes.item(i));
                river.setName(riverElement.getAttribute(River.NAME));
                river.setLength(Integer.parseInt(riverElement.getAttribute(River.LENGTH)));
                Element introduction = (Element) riverElement.getElementsByTagName(River.INTRODUCTION).item(0);
                river.setIntroduction(introduction.getFirstChild().getNodeValue());
                Element imageUrl = (Element) riverElement.getElementsByTagName(River.IMAGEURL).item(0);
                river.setImageurl(imageUrl.getFirstChild().getNodeValue());
                rivers.add(river);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return rivers;
    }

}
