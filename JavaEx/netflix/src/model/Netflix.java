package model;

public class Netflix {
    private int id;
    private String title;
    private String category;
    private String actor;
    private String language;
    private int publishingYear;
    private String publishCompany;
    private int time;

    public Netflix(int id, String title, String category, String actor, String language, int publishingYear, String publishCompany, int time) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.actor = actor;
        this.language = language;
        this.publishingYear = publishingYear;
        this.publishCompany = publishCompany;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getPublishCompany() {
        return publishCompany;
    }

    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return id + "-" + title + "-" + category + "-" + time + "-" + language;
    }
}
