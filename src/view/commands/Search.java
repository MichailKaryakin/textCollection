package view.commands;

import view.console.ConsoleUI;

public class Search extends Command {
    public Search(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Поиск по документу";
    }

    @Override
    public void execute() {
        consoleUi.searchDocument();
    }
}
