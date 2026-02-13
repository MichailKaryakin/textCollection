package view.commands;

import view.console.ConsoleUi;

public class ByAuthor extends Command {
    public ByAuthor(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Сортировать по автору";
    }

    @Override
    public void execute() {
        consoleUi.displayByAuthor();
    }
}
