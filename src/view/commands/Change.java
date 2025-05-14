package view.commands;

import view.console.ConsoleUI;

public class Change extends Command {
    public Change(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Изменить документ";
    }

    @Override
    public void execute() {
        consoleUi.changeDocument();
    }
}
