package view.commands;

import view.console.ConsoleUi;

public class ExitCollection extends Command {
    public ExitCollection(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Выход";
    }

    @Override
    public void execute() {
        consoleUi.exitCollection();
    }
}
