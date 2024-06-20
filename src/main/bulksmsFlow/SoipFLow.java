package main.bulksmsFlow;

import java.util.Map;

public class SoipFLow implements Flow {
    @Override
    public void execute(Client client, Map<String, Object> data) {
        System.out.println("Client= " + client.name + "\nFeedId= " + client.feedId + "\ndate= " + data);
    }
}