package view.commands;

import view.console.ConsoleUi;

public abstract class Command {
    String menuText;
    ConsoleUi consoleUi;

    public Command(ConsoleUi consoleUi) {
        this.consoleUi = consoleUi;
    }

    public String getMenuText() {
        return menuText;
    }

    public abstract void execute();
}
