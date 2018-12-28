package org.alex.service;

import org.alex.entity.Assignee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AssigneeFlushDataService {
    private final Assignee[] toSave;

    public AssigneeFlushDataService(Assignee... toSave) {
        this.toSave = toSave;
    }

    public boolean flush(File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(toSave);
            fos.close();
            oos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
