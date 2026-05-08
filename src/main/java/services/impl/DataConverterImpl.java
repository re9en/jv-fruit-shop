package services.impl;

import model.FruitTransaction;
import services.interfaces.DataConverter;

import java.io.IOException;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private final static int CODE = 0;
    private final static int FRUIT = 1;
    private final static int AMOUNT = 2;

    @Override
    public List<FruitTransaction> convertToFruitTransaction(List<String> list) throws IOException {
        return list.stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(record -> new FruitTransaction(
                        FruitTransaction.Operation.from(record[CODE]),
                        record[FRUIT],
                        Integer.parseInt(record[AMOUNT]))
                ).toList();
    }
}
