package com.finalTask.tsk.command;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {
    private static Map<String, Command> commands = new TreeMap<String, Command>();

    static {
        commands.put("login", new LoginCommand());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }

}
