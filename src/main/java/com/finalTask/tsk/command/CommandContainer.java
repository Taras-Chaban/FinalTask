package com.finalTask.tsk.command;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {
    private static final Map<String, Command> commands = new TreeMap<>();

    static {
        Command forwards = new ForwardCommand();
        commands.put("welcome_forward", forwards);
        commands.put("archive_forward", forwards);
        commands.put("payment_forward", forwards);
        commands.put("refunds_forward", forwards);
        commands.put("reports_forward", forwards);
        commands.put("sales_forward", forwards);

        commands.put("login", new LoginCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("add_product", new AddProductCommand());
        commands.put("display_product", new DisplayProductsCommand());
        commands.put("display_users", new DisplayUsersCommand());

    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }

}
