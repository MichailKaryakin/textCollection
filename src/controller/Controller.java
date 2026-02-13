package controller;

import java.util.Date;
import java.util.List;

public interface Controller {
    void addDocument(List<String> text, String author, Date creationDate);
    void changeDocument(String oldSequence, String newSequence, int lineId, int docId);
    boolean displayPage(int docId);
    boolean displayPreviousPage(int docId);
    void displayCollection();
    void displayCollectionByAuthor();
    void displayCollectionByDate();
    void displayCollectionBySize();
    void changeCollectionRoot(String path);
    void searchDocument(String sequence, int docId);
}
