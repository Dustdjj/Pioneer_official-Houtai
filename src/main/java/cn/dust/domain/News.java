package cn.dust.domain;

import java.sql.Timestamp;

public class News {
    private int newsId;
    private String newsTitle;
    private Timestamp newsTime;
    private String newsContent;
    private int newsClicks;
    private String newsImg;

    public News() {
    }

    public News(int newsId, String newsTitle, Timestamp newsTime, String newsContent, int newsClicks, String newsImg) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsTime = newsTime;
        this.newsContent = newsContent;
        this.newsClicks = newsClicks;
        this.newsImg = newsImg;
    }

    public News(int newsId, String newsTitle) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
    }

    public News(String newsTitle, Timestamp newsTime, String newsContent, int newsClicks, String newsImg) {
        this.newsTitle = newsTitle;
        this.newsTime = newsTime;
        this.newsContent = newsContent;
        this.newsClicks = newsClicks;
        this.newsImg = newsImg;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public Timestamp getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Timestamp newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public int getNewsClicks() {
        return newsClicks;
    }

    public void setNewsClicks(int newClicks) {
        this.newsClicks = newClicks;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsTime='" + newsTime + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newClicks=" + newsClicks +
                ", newsImg='" + newsImg + '\'' +
                '}';
    }
}
