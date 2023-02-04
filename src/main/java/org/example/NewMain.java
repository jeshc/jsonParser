package org.example;

import org.example.jsondriver.Json;
import org.example.jsontypes.Util;
import org.example.jsondriver.util.BracketToken;
public class NewMain {


    public static void main(String[] args) {
        String input = Util.TEST4;
        Json json = new Json(input);
        json.setBracketPairs();
        System.out.println(input);
        System.out.println("[*[*[*[*[*[*[*");

        for (BracketToken bracket:   json.getPairsExtractor().getPares()) {
            System.out.println("start: " + bracket.getStart() + " End: " + bracket.getEnd());
        }
        json.createJsonBrothers();
        System.out.println(".-.-.-.-.-.-.-");
        System.out.println(json);
    }

}
