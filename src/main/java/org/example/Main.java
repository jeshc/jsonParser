package org.example;

import org.example.jsontypes.JsonBase;
import org.example.jsondriver.util.JsonFamily;
import org.example.jsontypes.Util;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         String json = Util.TEST1;

        System.out.println(json);
        JsonBraketExtractor jsonObject = new JsonBraketExtractor();
        jsonObject.setInput(json);
        jsonObject.parseBrackets();  // verificar balanceo y obtener pares

        ArrayList<BracketToken> pares = jsonObject.getPares();
        Collections.sort(pares);

        for (BracketToken bracket:   pares) {
            System.out.println("start: " + bracket.getStart() + " End: " + bracket.getEnd());
        }
        System.out.println("-----------");
        ArrayList<BracketToken> hermanos = selectBrothers(json, pares);
        for (BracketToken token: hermanos) {
            System.out.println(token);
            System.out.println(json.substring(token.getStart(), token.getEnd()));
        }

        System.out.println("--<-<-<-<--<-<-<--<--<");
        System.out.println(hermanos);
        JsonFamily familia = new JsonFamily(hermanos, json);
        familia.createJsonBrothers();
        familia.setRawJson("---");
        for (JsonBase jsonRes: familia.getOffSpring() ) {
            System.out.println("::::::::::::::::::");
            System.out.println(jsonRes);
            System.out.println(":_:_:_:_:_:_:_:_:_");
        }


    }

    private static ArrayList<BracketToken> selectBrothers(String json, ArrayList<BracketToken> pares){
        ArrayList<BracketToken> bross= new ArrayList<>();
        ArrayList<String> chunks = new ArrayList<>();
        System.out.println("--- inicio de armado de familia ------");
        for (int i = 1; i < pares.size(); i++) {
            BracketToken actual = pares.get(i);
            if (!isNephew(actual, pares)){
                bross.add(actual);
            }
        }
        return bross;
    }

    private static boolean isNephew(BracketToken familiar, ArrayList<BracketToken> pares ){
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

    private static boolean isSon(BracketToken par1 , BracketToken par2){
        return (par1.getStart()>par2.getStart()) && (par1.getEnd()< par2.getEnd());
    }
}