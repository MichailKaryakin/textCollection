package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Document implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private List<String> text;
    private int size;
    private int pageNumber = 0;
    private final int linesOnPage = 15;
    private final String author;
    private final Date creationDate;

    public Document(List<String> text, String author, Date creationDate) {
        this.text = text;
        this.size = countSize();
        this.author = author;
        this.creationDate = creationDate;
    }

    private int countSize() {
        int size = 0;
        for (String string : text) {
            size += string.length();
        }
        return size;
    }

    public List<String> getPage() {
        int beginLine = pageNumber * linesOnPage;
        List<String> page;
        if (beginLine + linesOnPage < text.size()) {
            page = text.subList(beginLine, beginLine + linesOnPage);
        } else {
            page = text.subList(beginLine, text.size());
        }
        pageNumber++;
        return page;
    }

    public List<String> getPreviousPage() {
        pageNumber -= 2;
        int beginLine = pageNumber * linesOnPage;
        List<String> page = text.subList(beginLine, beginLine + linesOnPage);
        pageNumber++;
        return page;
    }

    public List<String> getText() {
        return text;
    }

    public int getNumberOfPages() {
        return (int) Math.ceil((double) text.size() / linesOnPage);
    }

    public void resetPage() {
        pageNumber = 0;
    }

    public void setText(List<String> text) {
        this.text = text;
        size = countSize();
    }

    public String getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getSize() {
        return size;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getLine(int lineIndex) {
        return text.get(lineIndex);
    }
}
