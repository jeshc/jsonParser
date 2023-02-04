package org.example.jsondriver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.jsondriver.util.BracketToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


@AllArgsConstructor
@Setter
@Getter
@ToString
public class JsonBraketExtractor {

    private String input;
    private Stack<BracketToken> stack;
    private ArrayList<BracketToken> pares;

    public JsonBraketExtractor(){
        stack = new Stack<>();
        stack.push(new BracketToken('#',-1, -1));
        pares = new ArrayList<>();
    }


    public void parseBrackets(){
        BracketToken actual = null;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{'){
                stack.push(new BracketToken('{', i, -1));
            } else if (input.charAt(i) == '}') {
                actual = stack.pop();
                if (actual.getToken() == '{' ){
                  actual.setEnd(i);
                  pares.add(actual);
                } else if (actual.getToken() == '#') {
                    System.out.println("No balanceado");
                }
            }
        }
        Collections.sort(this.pares);
    }
}
