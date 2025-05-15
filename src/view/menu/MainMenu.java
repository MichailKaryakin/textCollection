package view.menu;

import view.commands.*;
import view.console.ConsoleUi;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu {
    private final List<Command> commands;

    public MainMenu(ConsoleUi consoleUi) {
        commands = new ArrayList<>();
        commands.add(new Add(consoleUi));
        commands.add(new Open(consoleUi));
        commands.add(new Collection(consoleUi));
        commands.add(new Exit(consoleUi));
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
