package strategy.impl;

import model.FruitTransaction;
import db.Storage;
import strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final Storage storage;

    public BalanceOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.set(transaction.getFruit(), transaction.getQuantity());
    }
}
