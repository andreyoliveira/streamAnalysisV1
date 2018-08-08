package br.com.conceptmx.stream.test;

import br.com.conceptmx.stream.impl.StringAnalysis;
import junit.framework.TestCase;
import org.junit.Assert;

public class StreamAnalyzerTest extends TestCase {

    public void testAnalisarStream(){

        StringAnalysis stringAnalysis = new StringAnalysis("aAbBABacafe");
        Assert.assertEquals(stringAnalysis.analisarStream(), "e");

        stringAnalysis = new StringAnalysis("hhjdgdaedfibu");
        Assert.assertEquals(stringAnalysis.analisarStream(), "u");

        stringAnalysis = new StringAnalysis("abcde");
        Assert.assertEquals(stringAnalysis.analisarStream(), "Não foi encontrado na Stream um caractere que atende as especificações!");
    }
}
