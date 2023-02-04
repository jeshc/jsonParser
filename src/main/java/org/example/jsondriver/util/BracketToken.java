package org.example.jsondriver.util;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BracketToken implements Comparable{
    private char token;
    private int start;
    private int end;


    @Override
    public int compareTo(Object o) {
        BracketToken other = (BracketToken) o;
        int resultado = 0;
        if ((start == other.getStart()) && (end == other.getEnd()) ){
            resultado=0;
        } else {
            resultado = this.start < other.getStart()? -1 : 1;
        }
        return resultado;
    }
}
