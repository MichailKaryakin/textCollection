package view.commands;

import view.console.ConsoleUI;

public class ChangeRoot extends Command {
    public ChangeRoot(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Расположение";
    }

    @Override
    public void execute() {
        consoleUi.changeRoot();
    }
}
