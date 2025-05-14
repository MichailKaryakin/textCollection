package view.commands;

import view.console.ConsoleUI;

public class Open extends Command {
    public Open(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Открыть документ";
    }

    @Override
    public void execute() {
        consoleUi.openDocument();
    }
}
