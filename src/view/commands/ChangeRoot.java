package view.commands;

import view.console.ConsoleUi;

public class ChangeRoot extends Command {
    public ChangeRoot(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Расположение";
    }

    @Override
    public void execute() {
        consoleUi.changeRoot();
    }
}
