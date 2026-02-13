package view.commands;

import view.console.ConsoleUi;

public class Open extends Command {
    public Open(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Открыть документ";
    }

    @Override
    public void execute() {
        consoleUi.openDocument();
    }
}
