package view.menu;

import view.commands.*;
import view.console.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class CollectionMenu implements Menu {
    private final List<Command> commands;

    public CollectionMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new ByAuthor(consoleUI));
        commands.add(new ByDate(consoleUI));
        commands.add(new BySize(consoleUI));
        commands.add(new ChangeRoot(consoleUI));
        commands.add(new ExitCollection(consoleUI));
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
