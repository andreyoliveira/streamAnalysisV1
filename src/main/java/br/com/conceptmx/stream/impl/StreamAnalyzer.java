package br.com.conceptmx.stream.impl;

import java.util.*;

/**
 * @author andreyoliveira
 */
public class StreamAnalyzer implements Stream {

    private char[] stream;

    private int posicao = -1;

    private int posicaoFinal = 0;

    private static List<String> vogais = Arrays.asList("a", "e", "i", "o", "u");

    private static List<String> consoantes = Arrays.asList("b", "c", "d", "f", "g", "h", "j",
            "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z", "ç");

    public StreamAnalyzer(String stream){
        this.stream = stream.toCharArray();
        this.posicaoFinal = stream.length() - 1;
    }

    public boolean hasNext(){
        return this.posicao < this.posicaoFinal;
    }

    public char getNext() {
        this.posicao++;
        return this.stream[this.posicao];
    }

    public Character getCaracterePorPosicao(int posicao){
        return this.stream[posicao];
    }

    public int getPosicaoPorCaractere(Character c){
        for(int i = 0; i < this.stream.length; i++) {
            if(stream[i] == c){
                return i;
            }
        }
        return -1;
    }

    public boolean isVogal(Character c) {
        return vogais.contains(c.toString().toLowerCase());
    }

    public boolean isConsoante(Character c) {
        return consoantes.contains(c.toString().toLowerCase());
    }
}
