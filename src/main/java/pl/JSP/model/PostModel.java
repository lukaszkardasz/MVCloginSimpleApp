package pl.JSP.model;


import java.time.LocalDateTime;

public class PostModel {

    private String title;
    private String text;
    private String author;
    private LocalDateTime createdDate;

    public PostModel(String title, String text, String author, LocalDateTime createdDate) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.createdDate = createdDate;
    }

    public PostModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
