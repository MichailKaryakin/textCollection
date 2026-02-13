package view.commands;

import view.console.ConsoleUi;

public class Change extends Command {
    public Change(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Изменить документ";
    }

    @Override
    public void execute() {
        consoleUi.changeDocument();
    }
}
