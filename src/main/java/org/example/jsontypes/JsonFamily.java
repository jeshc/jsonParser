package org.example.jsontypes;

import org.example.BracketToken;
import org.example.Main;
import org.example.jsontypes.JsonBase;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonFamily {
    private ArrayList<BracketToken> brothers;
    private Deque<JsonBase> offSpring;
    private String rawJson;
    public JsonFamily() {
        offSpring = new ArrayDeque<>();
    }

    public JsonFamily(String rawJson) {
        this.rawJson = rawJson;
    }

    public JsonFamily(Deque<JsonBase> offSpring) {
        this.offSpring = offSpring;
        offSpring = new ArrayDeque<>();
    }
    public JsonFamily(Deque<JsonBase> offSpring, String rawJson) {
        this.offSpring = offSpring;
        this.rawJson = rawJson;
        offSpring = new ArrayDeque<>();
    }

    public JsonFamily(ArrayList<BracketToken> brothers, String rawJson) {
        this.brothers = brothers;
        this.rawJson = rawJson;
        offSpring = new ArrayDeque<>();
    }

    public ArrayList<BracketToken> getBrothers() {
        return brothers;
    }

    public void setBrothers(ArrayList<BracketToken> brothers) {
        this.brothers = brothers;
    }

    public String getRawJson() {
        return rawJson;
    }

    public void setRawJson(String rawJson) {
        this.rawJson = rawJson;
    }

    public Deque<JsonBase> getOffSpring() {
        return offSpring;
    }

    public void setOffSpring(Deque<JsonBase> offSpring) {
        this.offSpring = offSpring;
    }

    @Override
    public String toString() {
        return "JsonFamily{" +
                "brothers=" + brothers +
                ", offSpring=" + offSpring +
                ", rawJson='" + rawJson + '\'' +
                '}';
    }

    public void addChild(JsonBase child){
        offSpring.add(child);
    }

    public void clear(){
        offSpring.clear();
    }


    public void createJsonBrothers(){
        Pattern pattern = Pattern.compile(Util.REGEX_JSON_PAIRS);
        Matcher matcher = null;
        int pivotIndex  = 0;
        for (BracketToken bro:  brothers ) {
            System.out.println("HErmano:" + bro);
            System.out.println("-->" + rawJson.substring(pivotIndex, bro.getStart()) + "<---");
            matcher = pattern.matcher(rawJson.substring(pivotIndex, bro.getStart()));
            System.out.println("Matches: " + matcher.groupCount());
            while (matcher.find()){
                System.out.println("Grupo 1" + matcher.group(1));
                System.out.println("Grupo 2" + matcher.group(2));
                System.out.println("Long: " + matcher.group(2).trim().replace(" ","").length());
                if ( matcher.group(2).trim().replace(" ","").length()==0){
                    System.out.println("Es Json complejo");

                    offSpring.add(new ComplexJson(matcher.group(1), rawJson.substring(bro.getStart() ,bro.getEnd()+1)  ));
                } else {
                    System.out.println("Es Json Simple");
                    offSpring.add(new JsonBase(matcher.group(1) , matcher.group(2).trim() ));
                }
            }
            pivotIndex = bro.getEnd() + 1;
        }
        System.out.println("-->" + rawJson.substring(pivotIndex, rawJson.length()-1) + "<---");
        matcher = pattern.matcher(rawJson.substring(pivotIndex, rawJson.length()-1));
        while (matcher.find()){
            System.out.println("Grupo 1" + matcher.group(1));
            System.out.println("Grupo 2" + matcher.group(2));
            if ( matcher.group(2).trim().replace(" ","").length()==0){
                System.out.println("Es Json complejo");
            } else {
                System.out.println("Es Json Simple");
                offSpring.add(new JsonBase(matcher.group(1) , matcher.group(2).trim() ));
            }
        }

    }


}
