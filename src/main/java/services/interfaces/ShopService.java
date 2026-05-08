package services.interfaces;

import model.FruitTransaction;

import java.io.IOException;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactions) throws IOException;
}
