package view.commands;

import view.console.ConsoleUI;

public class ByDate extends Command {
    public ByDate(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Сортировать по дате";
    }

    @Override
    public void execute() {
        consoleUi.displayByDate();
    }
}
