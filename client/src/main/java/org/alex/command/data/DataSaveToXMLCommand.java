package org.alex.command.data;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;

public class DataSaveToXMLCommand extends AbstractCommand {

    final private String command = ">xml";

    final private String description = "Сохранить данные на диск в формате xml.";

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
