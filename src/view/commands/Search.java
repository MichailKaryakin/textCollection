package view.commands;

import view.console.ConsoleUi;

public class Search extends Command {
    public Search(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Поиск по документу";
    }

    @Override
    public void execute() {
        consoleUi.searchDocument();
    }
}
