package services.interfaces;

import java.io.IOException;
import java.util.List;

public interface OperationSeparator {
    List<String[]> dataToArray(String[] data) throws IOException;
}
