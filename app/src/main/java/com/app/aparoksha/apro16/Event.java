package com.app.aparoksha.apro16;

/**
 * Created by Anurag on 18-01-2016.
 */
public class Event {
    String name;
    int id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Event(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
