package br.com.conceptmx.stream.impl;

/**
 * @author andreyoliveira
 */
public interface Stream {

    public char getNext();

    public boolean hasNext();

    public Character getCaracterePorPosicao(int posicao);

    public int getPosicaoPorCaractere(Character c);

    public boolean isVogal(Character c);

    public boolean isConsoante(Character c);


}
