package view.commands;

import view.console.ConsoleUI;

public class ExitDoc extends Command {
    public ExitDoc(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Выход";
    }

    @Override
    public void execute() {
        consoleUi.exitDocument();
    }
}
