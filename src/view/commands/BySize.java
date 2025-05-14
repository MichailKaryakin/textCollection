package view.commands;

import view.console.ConsoleUI;

public class BySize extends Command {
    public BySize(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Сортировать по размеру";
    }

    @Override
    public void execute() {
        consoleUi.displayBySize();
    }
}