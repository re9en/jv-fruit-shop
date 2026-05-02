package core.basesyntax;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import services.impl.ActivitiesHandlerImpl;
import services.impl.DataHandlerImpl;
import services.impl.OperationSeparatorImpl;
import services.impl.RawDataConverterImpl;
import services.impl.StorageImpl;
import services.interfaces.ActivitiesHandler;
import services.interfaces.DataHandler;
import services.interfaces.OperationSeparator;
import services.interfaces.RawDataConverter;
import services.interfaces.Storage;

public class Main {
    public static void main(String[] args) throws IOException {
        RawDataConverter rawDataConverter = new RawDataConverterImpl();

        String[] data = rawDataConverter.dataConvert();

        for (String item: data) {
            System.out.println(item);
        }

        OperationSeparator operationSeparator = new OperationSeparatorImpl();

        List<String[]> separatedData = operationSeparator.dataToArray(data);

        for (String[] item: separatedData) {
            System.out.println(Arrays.toString(item));
        }

        Storage storage = new StorageImpl();

        ActivitiesHandler activitiesHandler = new ActivitiesHandlerImpl(storage);

        activitiesHandler.findAction(separatedData);

        System.out.println(storage.getAllData());

        DataHandler dataHandler = new DataHandlerImpl();

        dataHandler.writeReport("src/main/java/resources/dataOutput.csv", storage.getAllData());
    }
}
