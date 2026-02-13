package view.commands;

import view.console.ConsoleUi;

public class Collection extends Command {
    public Collection(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Коллекция";
    }

    @Override
    public void execute() {
        consoleUi.collection();
    }
}
