package com.example.brandonkbarnes.newsies;

/**
 * Created by Brandon on 12/3/2017.
 */

public class News {

    /** Headline of the news report */
    private String mainHeadline;

    /** Author of the news report */
    private String mainAuthor;

    /** Category of the news report */
    private String mainCategory;

    /** Time of the news report */
    private String mainTime;

    /** Website URL of the news report */
    private String mainUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param headline is the headline of the article
     * @param author is the author of the article
     * @param time is the time in a String when the article was posted
     * @param url is the website URL to find more details about the article
     */
    public News(String headline, String author, String category, String time, String url) {
        mainHeadline = headline;
        mainAuthor = author;
        mainCategory = category;
        mainTime = time;
        mainUrl = url;
    }

    /**
     * Returns the headline of the article.
     */
    public String getHeadline() {
        return mainHeadline;
    }

    /**
     * Returns the author of the article.
     */
    public String getAuthor() {
        return mainAuthor;
    }

    /**
     * Returns the category of the article.
     */
    public String getCategory() {
        return mainCategory;
    }

    /**
     * Returns the time of the article.
     */
    public String getTime() {
        return mainTime;
    }

    /**
     * Returns the website URL to read the news article.
     */
    public String getUrl() {
        return mainUrl;
    }
}
