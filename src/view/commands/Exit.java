package view.commands;

import view.console.ConsoleUI;

public class Exit extends Command {
    public Exit(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Выход";
    }

    @Override
    public void execute() {
        consoleUi.exitProgram();
    }
}
