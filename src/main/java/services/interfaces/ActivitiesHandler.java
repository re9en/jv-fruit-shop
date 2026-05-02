package services.interfaces;

import java.io.IOException;
import java.util.List;

public interface ActivitiesHandler {
    void findAction(List<String[]> data) throws IOException;
}
