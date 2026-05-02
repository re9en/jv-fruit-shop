package services.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import services.interfaces.OperationSeparator;

public class OperationSeparatorImpl implements OperationSeparator {
    @Override
    public List<String[]> dataToArray(String[] data) throws IOException {
        return Arrays.stream(data)
                .map(l -> l.trim().split(","))
                .collect(Collectors.toList());
    }
}
