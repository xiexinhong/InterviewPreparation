package org.xiexh.appcore.xmlparser;

import android.util.Xml;
import org.xiexh.appcore.global.InterviewPreparationApplication;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/16.
 */
public class PullPraserTest {

    public List<River> getRiversFromXml(String fileName) {
        List<River> rivers = new ArrayList<River>();
        River river = null;
        InputStream inputStream = null;
        XmlPullParser xmlParser = Xml.newPullParser();

        try {
            inputStream = InterviewPreparationApplication.getContext().getResources().getAssets().open(fileName);
            xmlParser.setInput(inputStream,"utf-8");
            int evtType = xmlParser.getEventType();
            while(evtType != XmlPullParser.END_DOCUMENT) {
                switch (evtType) {
                    case XmlPullParser.START_TAG:
                        String tag = xmlParser.getName();
                        if(tag.equalsIgnoreCase(River.RIVER)){
                            river = new River();
                            river.setName(xmlParser.getAttributeValue(null,River.NAME));
                            river.setLength(Integer.parseInt(xmlParser.getAttributeValue(null, River.LENGTH)));
                        } else if(river != null) {
                            if(tag.equalsIgnoreCase(River.INTRODUCTION)) {
                                river.setIntroduction(xmlParser.nextText());
                            } else if(tag.equalsIgnoreCase(River.IMAGEURL)) {
                                river.setImageurl(xmlParser.nextText());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(xmlParser.getName().equalsIgnoreCase(River.RIVER) && river != null) {
                            rivers.add(river);
                            river = null;
                        }
                        break;
                }
                evtType = xmlParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
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
