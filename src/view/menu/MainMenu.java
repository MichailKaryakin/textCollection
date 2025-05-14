package view.menu;

import view.commands.*;
import view.console.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu {
    private final List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new Add(consoleUI));
        commands.add(new Open(consoleUI));
        commands.add(new Collection(consoleUI));
        commands.add(new Exit(consoleUI));
    }

    @Override
    public String getMenu() {
        return Menu.getMenuString(commands);
    }

    @Override
    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }
}
