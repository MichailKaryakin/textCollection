package view.commands;

import view.console.ConsoleUi;

public class BySize extends Command {
    public BySize(ConsoleUi consoleUi) {
        super(consoleUi);
        menuText = "Сортировать по размеру";
    }

    @Override
    public void execute() {
        consoleUi.displayBySize();
    }
}