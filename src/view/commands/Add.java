package view.commands;

import view.console.ConsoleUI;

public class Add extends Command {
    public Add(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Добавить документ";
    }

    @Override
    public void execute() {
        consoleUi.addDocument();
    }
}
