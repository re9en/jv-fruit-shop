package services.impl;

import java.io.IOException;
import java.util.List;

import model.FruitTransaction;
import services.interfaces.ShopService;
import db.Storage;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy storage) {
        this.strategy = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategy.getHandler(transaction.getOperation()).handle(transaction);
        }
    }
}
