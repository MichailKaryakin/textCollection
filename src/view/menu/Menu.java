package view.menu;

import view.commands.Command;

import java.util.List;

public interface Menu {
    String getMenu();
    void execute(int choice);
    static String getMenuString(List<Command> commands) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder
                    .append(i + 1)
                    .append(" - ")
                    .append(commands.get(i).getMenuText());
            if ((i + 1) != commands.size()) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();
    }
}
