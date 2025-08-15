package view.commands;

import view.console.ConsoleUi;

public class ByDate extends Command {
    public ByDate(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Сортировать по дате";
    }

    @Override
    public void execute() {
        consoleUi.displayByDate();
    }
}
