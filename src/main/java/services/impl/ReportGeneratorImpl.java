package services.impl;

import services.interfaces.ReportGenerator;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Map<String, Integer> data) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String,Integer> entry: data.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
