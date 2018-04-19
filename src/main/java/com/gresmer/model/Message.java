package com.gresmer.model;

/**
 * Spring will use the Jackson library to convert our model object to and from JSON.
 */
public class Message {

    private String from;
    private String text;

    public String getFrom() { return from; }

    public String getText() { return text; }
}
