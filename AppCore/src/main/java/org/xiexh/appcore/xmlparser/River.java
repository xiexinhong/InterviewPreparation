package org.xiexh.appcore.xmlparser;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/16.
 */
public class River implements Serializable {

    public static String RIVER = "river";
    public static String NAME = "name";
    public static String LENGTH = "length";
    public static String INTRODUCTION = "introduction";
    public static String IMAGEURL = "imageurl";

    private static final long serialVersionUID = 1L;

    private String name;
    private int length;
    private String introduction;
    private String imageurl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "River{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", introduction='" + introduction + '\'' +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }
}
