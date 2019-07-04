package cn.dust.domain;

import java.sql.Timestamp;

public class Technology {
    private int tecId;
    private String tecTitle;
    private Timestamp tecTime;
    private String tecContent;
    private int tecClicks;
    private String tecImg;

    public Technology() {
    }

    public Technology(int tecId, String tecTitle) {
        this.tecId = tecId;
        this.tecTitle = tecTitle;
    }

    public Technology(String tecTitle, Timestamp tecTime, String tecContent, int tecClicks, String tecImg) {
        this.tecTitle = tecTitle;
        this.tecTime = tecTime;
        this.tecContent = tecContent;
        this.tecClicks = tecClicks;
        this.tecImg = tecImg;
    }

    public Technology(int tecId, String tecTitle, Timestamp tecTime, String tecContent, int tecClicks, String tecImg) {
        this.tecId = tecId;
        this.tecTitle = tecTitle;
        this.tecTime = tecTime;
        this.tecContent = tecContent;
        this.tecClicks = tecClicks;
        this.tecImg = tecImg;
    }

    public int getTecId() {
        return tecId;
    }

    public void setTecId(int tecId) {
        this.tecId = tecId;
    }

    public String getTecTitle() {
        return tecTitle;
    }

    public void setTecTitle(String tecTitle) {
        this.tecTitle = tecTitle;
    }

    public Timestamp getTecTime() {
        return tecTime;
    }

    public void setTecTime(Timestamp tecTime) {
        this.tecTime = tecTime;
    }

    public String getTecContent() {
        return tecContent;
    }

    public void setTecContent(String tecContent) {
        this.tecContent = tecContent;
    }

    public int getTecClicks() {
        return tecClicks;
    }

    public void setTecClicks(int tecClicks) {
        this.tecClicks = tecClicks;
    }

    public String getTecImg() {
        return tecImg;
    }

    public void setTecImg(String tecImg) {
        this.tecImg = tecImg;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "tecId=" + tecId +
                ", tecTitle='" + tecTitle + '\'' +
                ", tecTime=" + tecTime +
                ", tecContent='" + tecContent + '\'' +
                ", tecClicks=" + tecClicks +
                ", tecImg='" + tecImg + '\'' +
                '}';
    }
}
