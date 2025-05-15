package view.commands;

import view.console.ConsoleUi;

public class Add extends Command {
    public Add(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Добавить документ";
    }

    @Override
    public void execute() {
        consoleUi.addDocument();
    }
}
