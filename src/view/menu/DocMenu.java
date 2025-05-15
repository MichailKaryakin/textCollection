package view.menu;

import view.console.ConsoleUi;
import view.commands.Change;
import view.commands.Command;
import view.commands.ExitDoc;
import view.commands.Search;

import java.util.ArrayList;
import java.util.List;

public class DocMenu implements Menu {
    private final List<Command> commands;

    public DocMenu(ConsoleUi consoleUI) {
        commands = new ArrayList<>();
        commands.add(new Search(consoleUI));
        commands.add(new Change(consoleUI));
        commands.add(new ExitDoc(consoleUI));
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
