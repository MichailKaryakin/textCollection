package view.commands;

import view.console.ConsoleUI;

public class Collection extends Command {
    public Collection(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Коллекция";
    }

    @Override
    public void execute() {
        consoleUi.collection();
    }
}
