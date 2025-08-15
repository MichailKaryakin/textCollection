package view.commands;

import view.console.ConsoleUi;

public class Exit extends Command {
    public Exit(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Выход";
    }

    @Override
    public void execute() {
        consoleUi.exitProgram();
    }
}
