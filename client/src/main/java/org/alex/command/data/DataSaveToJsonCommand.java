package org.alex.command.data;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Domain;

import java.io.File;
import java.io.FileWriter;

public class DataSaveToJsonCommand extends AbstractCommand {

    final String command = ">json";
    final String description = "Сохранить все данные в формате json на диск";

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
        final File file;
        file = new File("./data.json");
        if (!file.exists()) file.createNewFile();
        final ObjectMapper mapper = new ObjectMapper();
        final FileWriter fileWriter = new FileWriter(file);
        final Domain domain = bootstrap.getDomain().createDomain(bootstrap);
        final JsonGenerator jsonGenerator = mapper.getFactory().createGenerator(fileWriter);
        jsonGenerator.writeObject(domain);
        jsonGenerator.close();
        fileWriter.close();
    }

}
