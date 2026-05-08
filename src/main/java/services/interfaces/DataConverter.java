package services.interfaces;

import model.FruitTransaction;

import java.io.IOException;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToFruitTransaction(List<String> list) throws IOException;
}
