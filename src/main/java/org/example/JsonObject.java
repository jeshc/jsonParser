package org.example;

import lombok.*;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JsonObject <T>{
    private String key;
    private T value;
    private String jsonString;
    private HashMap<String, String> attributes;


}
