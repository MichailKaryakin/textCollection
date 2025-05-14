package view.commands;

import view.console.ConsoleUI;

public class ByAuthor extends Command {
    public ByAuthor(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Сортировать по автору";
    }

    @Override
    public void execute() {
        consoleUi.displayByAuthor();
    }
}
