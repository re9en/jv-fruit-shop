package services.interfaces;

import java.util.Map;

public interface DataHandler {
    void writeReport(String filePath, Map<String, Integer> finalData);
}
