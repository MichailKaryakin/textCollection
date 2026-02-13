package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Service {
    private final Repository repository;
    private final String pathStoredAt = "C:\\Users\\micha\\Documents\\programming\\code\\java\\textCollection\\src\\data\\path.txt";
    private String filePath;

    public Service() {
        this.repository = new Repository(new ArrayList<>());
        try {
            filePath = Files.readString(Path.of(pathStoredAt));
            repository.setLibraryStorage(readStorage());
        } catch (IOException | ClassNotFoundException ignored) {
        }
    }

    private void writeStorage(List<Document> documentList) throws IOException {
        FileOutputStream fos = new FileOutputStream
                (filePath);
        ObjectOutputStream objOutputStream = new ObjectOutputStream(fos);
        for (Object obj : documentList) {
            objOutputStream.writeObject(obj);
            objOutputStream.reset();
        }
        objOutputStream.close();
    }

    private List<Document> readStorage() throws IOException, ClassNotFoundException {
        List<Document> documentList = new ArrayList<>();
        FileInputStream fis = new FileInputStream
                (filePath);
        ObjectInputStream obj = new ObjectInputStream(fis);
        try {
            while (fis.available() != -1) {
                Document doc = (Document) obj.readObject();
                documentList.add(doc);
            }
        } catch (EOFException ignored) {
        }
        return documentList;
    }

    public List<Document> getCollection() {
        return repository.getLibraryStorage();
    }

    public Document getDocument(int docId) {
        List<Document> libraryStorage = repository.getLibraryStorage();
        return libraryStorage.get(docId);
    }

    public void addDocument(List<String> text, String author, Date creationDate) {
        List<Document> libraryStorage = repository.getLibraryStorage();
        libraryStorage.add(new Document(text, author, creationDate));
        try {
            writeStorage(libraryStorage);
        } catch (IOException ignored) {
        }
    }

    public void changeDocument(String oldSequence, String newSequence, int lineId, int docId) {
        List<Document> libraryStorage = repository.getLibraryStorage();
        Document document = libraryStorage.get(docId);
        List<String> text = document.getText();
        List<String> newText = new ArrayList<>();

        for (int i = 0; i < text.size(); i++) {
            if (i == lineId) {
                String newString = text.get(i).replace(oldSequence, newSequence);
                newText.add(newString);
            } else {
                newText.add(text.get(i));
            }
        }

        document.setText(newText);
        try {
            writeStorage(libraryStorage);
        } catch (IOException ignored) {
        }
    }

    public HashMap<Integer, List<Integer>> searchDocument(String sequence, int docId) {
        List<Document> libraryStorage = repository.getLibraryStorage();
        Document document = libraryStorage.get(docId);
        List<String> text = document.getText();
        HashMap<Integer, List<Integer>> entries = new HashMap<>();
        List<Integer> lineEntries = new ArrayList<>();

        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < text.get(i).length(); j++) {
                int index = text.get(i).indexOf(sequence, j);
                if (index != -1) {
                    lineEntries.add(index + 1);
                    j = index;
                }
            }
            if (lineEntries.size() > 0) {
                entries.put(i + 1, new ArrayList<>(lineEntries));
                lineEntries.clear();
            }
        }
        return entries;
    }

    public void changeCollectionRoot(String path) {
        try {
            filePath = path;
            writeStorage(repository.getLibraryStorage());
            Files.write(Paths.get(pathStoredAt), filePath.getBytes());
        } catch (IOException ignored) {
        }
    }

    public String getLine(int docId, int lineIndex) {
        return repository.getLibraryStorage().get(docId).getLine(lineIndex);
    }
}
