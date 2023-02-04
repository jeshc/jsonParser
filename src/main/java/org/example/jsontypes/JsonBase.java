package org.example.jsontypes;

import java.util.HashMap;

public class JsonBase {
    private String key;
    private String value;
    private HashMap<String, String> attributes;
    private String text;
    public JsonBase(String key, String value, HashMap<String, String> attributes) {
        this.key = key;
        this.value = value;
        this.attributes = attributes;
    }

    public JsonBase(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public JsonBase() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "JsonBase{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
