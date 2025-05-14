package view.commands;

import view.console.ConsoleUI;

public abstract class Command {
    String menuText;
    ConsoleUI consoleUi;

    public Command(ConsoleUI consoleUi) {
        this.consoleUi = consoleUi;
    }

    public String getMenuText() {
        return menuText;
    }

    public abstract void execute();
}
