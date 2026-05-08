package strategy.impl;

import model.FruitTransaction;
import db.Storage;
import strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final Storage storage;

    public SupplyOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
