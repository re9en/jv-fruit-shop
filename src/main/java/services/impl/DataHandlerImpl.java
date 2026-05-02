package services.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import services.interfaces.DataHandler;

public class DataHandlerImpl implements DataHandler {
    @Override
    public void writeReport(String filePath, Map<String, Integer> finalData) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write("fruit,quantity");
            bufferedWriter.newLine();

            for (Map.Entry<String, Integer> entry : finalData.entrySet()) {
                bufferedWriter.write(entry.getKey() + "," + entry.getValue());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + filePath, e);
        }

    }
}
