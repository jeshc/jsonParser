package org.example.jsondriver;

import org.example.jsondriver.util.*;
import org.example.jsontypes.ComplexJson;
import org.example.jsontypes.JsonBase;
import org.example.jsontypes.Util;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Json {
    private Deque<JsonBase> offSpring;
    private String rawInput;
    private String key;
    private String value;
    private HashMap<String, String> attributes;
    private BracketToken brackets; // inicio y fin de este texto
    private JsonBraketExtractor pairsExtractor; // pares: token, start , end
    private ArrayList<BracketToken> sons;
    public Json() {
    }

    public Json(String rawInput) {
        this.rawInput = rawInput;
    }

    public Json(String rawInput, String key, String value, HashMap<String, String> attributes, BracketToken brackets) {
        this.rawInput = rawInput;
        this.key = key;
        this.value = value;
        this.attributes = attributes;
        this.brackets = brackets;
    }

    public String getRawInput() {
        return rawInput;
    }

    public void setRawInput(String rawInput) {
        this.rawInput = rawInput;
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

    public BracketToken getBrackets() {
        return brackets;
    }

    public void setBrackets(BracketToken brackets) {
        this.brackets = brackets;
    }

    public JsonBraketExtractor getPairsExtractor() {
        return pairsExtractor;
    }

    public void setPairsExtractor(JsonBraketExtractor pairsExtractor) {
        this.pairsExtractor = pairsExtractor;
    }

    @Override
    public String toString() {
        return "Json{" +
                "offSpring=" + offSpring +
                ", rawInput='" + "rawInput" + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", attributes=" + attributes +
                ", brackets=" + brackets +
                ", pairsExtractor=" + "pairsExtractor" +
                ", sons=" + sons +
                '}';
    }

    public void setBracketPairs(){
        pairsExtractor = new JsonBraketExtractor();
        pairsExtractor.setInput(this.rawInput);
        pairsExtractor.parseBrackets();
        this.brackets = pairsExtractor.getPares().get(0);
        this.selectBrothers();

    }


    private  void selectBrothers(){
        sons= new ArrayList<>();
        for (int i = 1; i < pairsExtractor.getPares().size(); i++) {
            BracketToken actual = pairsExtractor.getPares().get(i);
            if (!isNephew(actual, pairsExtractor.getPares())){
                sons.add(actual);
            }
        }
    }

    private  boolean isNephew(BracketToken familiar, ArrayList<BracketToken> pares ){
        boolean isNephew = false;
        BracketToken actual = null;
        for (int i = 1; i < pares.size(); i++) {
            actual = pares.get(i);
            if (!(familiar.compareTo(actual) == 0 )){ // No es el mismo
                if ( isSon(familiar, actual)  ){
                    return true;
                }
            }
        }
        return isNephew;
    }

    private  boolean isSon(BracketToken par1 , BracketToken par2){
        return (par1.getStart()>par2.getStart()) && (par1.getEnd()< par2.getEnd());
    }

    public void createJsonBrothers(){
        offSpring = new ArrayDeque<>();
        Pattern pattern = Pattern.compile(Util.REGEX_JSON_PAIRS);
        Matcher matcher = null;
        int pivotIndex  = 0;
        for (BracketToken bro:  sons ) {
            System.out.println("HErmano:" + bro);
            System.out.println("-->" + rawInput.substring(pivotIndex, bro.getStart()) + "<---");
            matcher = pattern.matcher(rawInput.substring(pivotIndex, bro.getStart()));
            System.out.println("Matches: " + matcher.groupCount());
            while (matcher.find()){
                System.out.println("Grupo 1" + matcher.group(1));
                System.out.println("Grupo 2" + matcher.group(2));
                System.out.println("Long: " + matcher.group(2).trim().replace(" ","").length());
                if ( matcher.group(2).trim().replace(" ","").length()==0){
                    System.out.println("Es Json complejo");

                    offSpring.add(new ComplexJson(matcher.group(1), rawInput.substring(bro.getStart() ,bro.getEnd()+1)  ));
                } else {
                    System.out.println("Es Json Simple");
                    offSpring.add(new JsonBase(matcher.group(1) , matcher.group(2).trim() ));
                }
            }
            pivotIndex = bro.getEnd() + 1;
        }
        System.out.println("-->" + rawInput.substring(pivotIndex, rawInput.length()-1) + "<---");
        matcher = pattern.matcher(rawInput.substring(pivotIndex, rawInput.length()-1));
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
