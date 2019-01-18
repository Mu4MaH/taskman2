package org.alex.command.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Domain;

import java.io.File;

public class DataLoadFromJsonCommand extends AbstractCommand {

    final String command = "<json";

    final String description = "Загрузить базу данных с файла";

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
        final File file = new File("./data.json");
        final ObjectMapper mapper = new ObjectMapper();
        final Domain domain = mapper.getFactory().createParser(file).readValueAs(Domain.class);
        bootstrap.getDomain().loadDomain(bootstrap, domain);
    }

}
