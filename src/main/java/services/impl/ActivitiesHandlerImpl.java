package services.impl;

import java.io.IOException;
import java.util.List;
import services.interfaces.ActivitiesHandler;
import services.interfaces.Storage;

public class ActivitiesHandlerImpl implements ActivitiesHandler {
    private static final int OPERATION = 0;
    private static final int ITEM = 1;
    private static final int QUANTITY = 2;

    private final Storage storage;

    public ActivitiesHandlerImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void findAction(List<String[]> data) throws IOException {

        for (String[] record : data) {

            Action action = Action.from(record[OPERATION]);
            String item = record[ITEM];
            Integer quantity = Integer.parseInt(record[QUANTITY]);

            switch (action) {
                case BALANCE -> {
                    System.out.println("Balance logic");
                    storage.set(item,quantity);
                }
                case SUPPLY -> {
                    System.out.println("Supply logic");
                    storage.add(item,quantity);
                }
                case PURCHASE -> {
                    System.out.println("Purchase logic");
                    storage.remove(item,quantity);
                }
                case RETURN -> {
                    System.out.println("Return logic");
                    storage.add(item,quantity);
                }
                default -> throw new RuntimeException("WRONG COMMAND");
            }
        }
    }

    enum Action {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Action(String operation) {
            this.operation = operation;
        }

        String getOperation() {
            return operation;
        }

        public static Action from(String value) {
            for (Action a : values()) {
                if (a.operation.equals(value)) {
                    return a;
                }
            }
            throw new IllegalArgumentException("Unknown operation: " + value);
        }
    }
}
