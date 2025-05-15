package view.commands;

import view.console.ConsoleUi;

public class ExitDoc extends Command {
    public ExitDoc(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Выход";
    }

    @Override
    public void execute() {
        consoleUi.exitDocument();
    }
}
