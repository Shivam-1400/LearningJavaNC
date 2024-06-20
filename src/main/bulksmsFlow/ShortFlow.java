package main.bulksmsFlow;

import java.lang.reflect.Field;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public  class ShortFlow implements Flow{
    @Override
    public void execute(Client client, Map<String, Object> data) {
        System.out.println("Client= "+ client.name+"\nFeedId= "+ client.feedId+ "\ndate= "+ data);
    }
}
