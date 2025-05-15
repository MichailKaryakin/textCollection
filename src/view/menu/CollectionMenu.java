package view.menu;

import view.commands.*;
import view.console.ConsoleUi;

import java.util.ArrayList;
import java.util.List;

public class CollectionMenu implements Menu {
    private final List<Command> commands;

    public CollectionMenu(ConsoleUi consoleUi) {
        commands = new ArrayList<>();
        commands.add(new ByAuthor(consoleUi));
        commands.add(new ByDate(consoleUi));
        commands.add(new BySize(consoleUi));
        commands.add(new ChangeRoot(consoleUi));
        commands.add(new ExitCollection(consoleUi));
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
