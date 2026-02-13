package controller;

import model.Document;
import model.Service;
import view.console.View;

import java.util.*;

public class ControllerImpl implements Controller {
    private final Service service;
    private final View view;

    public ControllerImpl(View view) {
        this.view = view;
        this.service = new Service();
    }

    private void displayByField(Comparator<Document> comparing) {
        List<Document> collection = service.getCollection();
        collection = collection.stream().sorted(comparing).toList();
        for (Document document : collection) {
            view.printAnswer("Автор: " + document.getAuthor() + ", Размер: " + document.getSize() + " симв., Дата создания: " + document.getCreationDate());
        }
    }

    @Override
    public void addDocument(List<String> text, String author, Date creationDate) {
        service.addDocument(text, author, creationDate);
        view.printAnswer("Документ добавлен");
    }

    @Override
    public void changeDocument(String oldSequence, String newSequence, int lineId, int docId) {
        service.changeDocument(oldSequence, newSequence, lineId, docId);
        view.printAnswer("Документ изменён");
    }

    @Override
    public boolean displayPage(int docId) {
        Document document = service.getDocument(docId);
        if (document.getPageNumber() < document.getNumberOfPages()) {
            for (String line : document.getPage()) {
                view.printAnswer(line);
            }
            return true;
        } else {
            document.resetPage();
            return false;
        }
    }

    @Override
    public boolean displayPreviousPage(int docId) {
        Document document = service.getDocument(docId);
        if (document.getPageNumber() - 1 > 0) {
            for (String line : document.getPreviousPage()) {
                view.printAnswer(line);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void displayCollection() {
        List<Document> collection = service.getCollection();
        for (Document document : collection) {
            view.printAnswer("Автор: " + document.getAuthor() + ", Размер: " + document.getSize() + " симв., Дата создания: " + document.getCreationDate());
        }
    }

    @Override
    public void displayCollectionByAuthor() {
        displayByField(Comparator.comparing(Document::getAuthor));
    }

    @Override
    public void displayCollectionByDate() {
        displayByField(Comparator.comparing(Document::getCreationDate));
    }

    @Override
    public void displayCollectionBySize() {
        displayByField(Comparator.comparing(Document::getSize));
    }

    @Override
    public void changeCollectionRoot(String path) {
        service.changeCollectionRoot(path);
        view.printAnswer("Расположение коллекции изменено");
    }

    @Override
    public void searchDocument(String sequence, int docId) {
        HashMap<Integer, List<Integer>> entries = service.searchDocument(sequence, docId);
        for (Map.Entry<Integer, List<Integer>> entry : entries.entrySet()) {
            for (Integer integer : entry.getValue()) {
                view.printAnswer("Строка: " + entry.getKey() + ", Позиция: " + integer + "  " + service.getLine(docId, entry.getKey() - 1));
            }
        }
    }
}
