package main.bulksmsFlow;

import java.util.HashMap;
import java.util.Map;

public interface Flow {
    void execute(Client client, Map<String, Object> data);

}
