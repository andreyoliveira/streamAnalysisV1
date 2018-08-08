package br.com.conceptmx.stream.impl;

import java.util.*;

/**
 * @author andreyoliveira
 */
public class StringAnalysis {

    Stream stream;

    public StringAnalysis(String phrase){
        this.stream = new StreamAnalyzer(phrase);
    }

    public String analisarStream(){
        Character c = analisador();
        if(c != null){
            return c.toString();
        }
        return "Não foi encontrado na Stream um caractere que atende as especificações!";
    }

    private Character analisador(){

        //Mapa que armazena as ocorrências de cada caractere da Stream
        HashMap<Character, Integer> ocorrencias = new LinkedHashMap<Character, Integer>();

        //Preenchendo as ocorrências de cada caractere da stream
        while(this.stream.hasNext()) {
            Character c = this.stream.getNext();
            Integer ocorrenciasChar = 0;
            if(ocorrencias.get(c) == null){
                ocorrenciasChar++;
            } else {
                ocorrenciasChar = ocorrencias.get(c);
                ocorrenciasChar++;
            }
            ocorrencias.put(c, ocorrenciasChar);
        }

        //Buscando a primeira ocorrência de vogal única
        List<Character> vogaisUnicas = new ArrayList<Character>();
        Iterator<Character> it = ocorrencias.keySet().iterator();
        while(it.hasNext()){
            Character charAnalisado = it.next();
            if(this.stream.isVogal(charAnalisado)) {
                Integer numeroOcorrencias = ocorrencias.get(charAnalisado);
                if (numeroOcorrencias.intValue() == 1) {
                    vogaisUnicas.add(charAnalisado);
                }
            }
        }

        //Para cada vogal única, verifica se atende o especificado: se é precedida por
        //uma consoante, e se essa consoante é precedida por uma vogal.
        Character vogalAnalisada = null;
        for(Character vogal : vogaisUnicas){
            int posicaoVogal = this.stream.getPosicaoPorCaractere(vogal);
            if(posicaoVogal == 0 || posicaoVogal == 1){
                continue;
            } else {
                Character caractereAnterior = this.stream.getCaracterePorPosicao(posicaoVogal - 1);
                if(this.stream.isConsoante(caractereAnterior)){
                    caractereAnterior = this.stream.getCaracterePorPosicao(posicaoVogal - 2);
                    if(this.stream.isVogal(caractereAnterior)){
                        vogalAnalisada = vogal;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }

        return vogalAnalisada;
    }

    public static void main(String[] args){

        StringAnalysis sa = new StringAnalysis("aAbBABacafe");
        System.out.println(sa.analisarStream());

        sa = new StringAnalysis("dceffassd");
        System.out.println(sa.analisarStream());
    }

}
