package strategy.impl;

import model.FruitTransaction;
import db.Storage;
import strategy.OperationHandler;

public class RemoveOperationHandler implements OperationHandler {
    private final Storage storage;

    public RemoveOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
