package view.console;

import controller.Controller;
import view.menu.CollectionMenu;
import view.menu.MainMenu;
import view.menu.Menu;
import view.menu.DocMenu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsoleUI implements View {
    private final InputOutput inputOutput;
    private final Controller controller;
    private final MainMenu mainMenu;
    private final DocMenu docMenu;
    private final CollectionMenu collectionMenu;
    private boolean exit;
    private boolean exitDoc;
    private boolean exitCollection;
    private int documentId;

    private void displayCollection() {
        controller.displayCollection();
    }

    private void execute(Menu menu) {
        int numMenu = inputOutput.scanInt();
        menu.execute(numMenu);
    }

    public ConsoleUI() {
        inputOutput = new InputOutput();
        controller = new Controller(this);
        docMenu = new DocMenu(this);
        mainMenu = new MainMenu(this);
        collectionMenu = new CollectionMenu(this);
        exit = false;
        exitDoc = false;
        exitCollection = false;
    }

    @Override
    public void printAnswer(String info) {
        inputOutput.printLine(info);
    }

    public void run() {
        displayCollection();
        while (!exit) {
            System.out.println(mainMenu.getMenu());
            execute(mainMenu);
        }
    }

    public void addDocument() {
        inputOutput.clearBuffer();
        List<String> text = new ArrayList<>();
        inputOutput.printLine("Нажмите 0 для прекращения ввода");

        boolean endWrite = false;
        while (!endWrite) {
            inputOutput.printLine("Введите строку документа:");
            String line = inputOutput.scanLine();
            if (line.equals("0")) {
                endWrite = true;
            } else {
                text.add(line);
            }
        }

        inputOutput.printLine("Введите автора документа:");
        String author = inputOutput.scanLine();
        controller.addDocument(text, author, new Date());
    }

    public void openDocument() {
        inputOutput.printLine("Введите номер документа:");
        documentId = inputOutput.scanInt() - 1;
        while (controller.displayPage(documentId)) {
            boolean proceed = false;
            while (!proceed) {
                inputOutput.blankLine();
                inputOutput.printLine("Любое число - следующая страница, единица - предыдушая.");
                int userChoice = inputOutput.scanInt();
                if (userChoice == 1) {
                    if (!controller.displayPreviousPage(documentId)) {
                        inputOutput.printLine("Вы на первой странице.");
                    }
                } else {
                    proceed = true;
                }
            }
        }
        while (!exitDoc) {
            System.out.println(docMenu.getMenu());
            execute(docMenu);
        }
        exitDoc = false;
    }

    public void collection() {
        displayCollection();
        while (!exitCollection) {
            System.out.println(collectionMenu.getMenu());
            execute(collectionMenu);
        }
        exitCollection = false;
    }

    public void changeDocument() {
        inputOutput.printLine("Введите номер строки:");
        int lineId = inputOutput.scanInt() - 1;
        inputOutput.clearBuffer();
        inputOutput.printLine("Введите старую последовательность:");
        String oldSequence = inputOutput.scanLine();
        inputOutput.printLine("Введите новую последовательность:");
        String newSequence = inputOutput.scanLine();
        controller.changeDocument(oldSequence, newSequence, lineId, documentId);
    }

    public void searchDocument() {
        inputOutput.clearBuffer();
        inputOutput.printLine("Введите последовательность:");
        String sequence = inputOutput.scanLine();
        controller.searchDocument(sequence, documentId);
    }

    public void displayBySize() {
        controller.displayCollectionBySize();
    }

    public void displayByDate() {
        controller.displayCollectionByDate();
    }

    public void displayByAuthor() {
        controller.displayCollectionByAuthor();
    }

    public void changeRoot() {
        inputOutput.clearBuffer();
        inputOutput.printLine("Введите директорию и имя файла:");
        String directory = inputOutput.scanLine();
        String fileName = inputOutput.scanLine();
        String newPath = "C:\\Users\\micha\\Documents\\programming\\code\\java\\textCollection\\src\\" + directory + "\\" + fileName + ".txt";
        controller.changeCollectionRoot(newPath);
    }

    public void exitProgram() {
        exit = true;
    }

    public void exitDocument() {
        exitDoc = true;
    }

    public void exitCollection() {
        exitCollection = true;
    }
}
