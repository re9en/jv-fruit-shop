package services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import services.interfaces.RawDataConverter;

public class RawDataConverterImpl implements RawDataConverter {

    @Override
    public String[] dataConvert() throws IOException {
        try (Stream<String> lines = Files.lines(Path.of("src/main/java/resources/data.csv"))) {
            return lines
                   .skip(1)
                   .toArray(String[]::new);
        }
    }
}
