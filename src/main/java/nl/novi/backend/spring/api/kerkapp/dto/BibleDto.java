package nl.novi.backend.spring.api.kerkapp.dto;

import nl.novi.backend.spring.api.kerkapp.Entitiy.FileUploadResponse;

import java.util.List;

public class BibleDto {

    private List<String> verse;

    private String title;

    private List<FileUploadResponse> files;

    public List<String> getVerse() {
        return verse;
    }

    public void setVerse(List<String> verse) {
        this.verse = verse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String newTitle = title.substring(0,1).toUpperCase() + title.substring(1);
        this.title = newTitle;
    }

    public List<FileUploadResponse> getFiles() {
        return files;
    }

    public void setFiles(List<FileUploadResponse> files) {
        this.files = files;
    }

    public void addFile(FileUploadResponse file) {
        files.add(file);
    }
}
