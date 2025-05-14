package model;

import java.util.List;

public class Repository {
    private List<Document> libraryStorage;

    public Repository(List<Document> libraryStorage) {
        this.libraryStorage = libraryStorage;
    }

    public List<Document> getLibraryStorage() {
        return libraryStorage;
    }

    public void setLibraryStorage(List<Document> libraryStorage) {
        this.libraryStorage = libraryStorage;
    }
}
