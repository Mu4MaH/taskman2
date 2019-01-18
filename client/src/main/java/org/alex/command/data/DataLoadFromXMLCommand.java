package org.alex.command.data;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;

public class DataLoadFromXMLCommand extends AbstractCommand {

    final private String command = "<xml";

    final private String description = "Загрузить данные из формата xml с диска.";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Bootstrap bootstrap) throws Exception {

    }
}
