package noteVault;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//this class holds information for each note
public class Note {
    private String title;
    private String content;
    private LocalDateTime createdDate;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now(); //setting the timestamp when creating the note
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getFormattedDate() {
        if (createdDate == null) {
            return "Date not available";
        }
        return createdDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "\n" + title + "\n" + content + "\n" + getFormattedDate();
    }
}
