package view.commands;

import view.console.ConsoleUI;

public class ExitCollection extends Command {
    public ExitCollection(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Выход";
    }

    @Override
    public void execute() {
        consoleUi.exitCollection();
    }
}
