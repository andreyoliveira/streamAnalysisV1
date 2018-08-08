package br.com.conceptmx.stream.test;

import br.com.conceptmx.stream.impl.Stream;
import br.com.conceptmx.stream.impl.StreamAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class StringAnalysisTest {

    @Test
    public void testIsVogal() {
        Stream stream = new StreamAnalyzer("abcde");
        Assert.assertTrue(stream.isVogal('a'));

        Assert.assertFalse(stream.isVogal('b'));
    }

    @Test
    public void testIsConsoante(){
        Stream stream = new StreamAnalyzer("abcde");
        Assert.assertTrue(stream.isConsoante('b'));

        Assert.assertFalse(stream.isConsoante('a'));
    }

    @Test
    public void testHasNext(){
        Stream stream = new StreamAnalyzer("abc");
        Assert.assertTrue(stream.hasNext());
        Character c = stream.getNext();

        Assert.assertTrue(stream.hasNext());
        c = stream.getNext();

        Assert.assertTrue(stream.hasNext());
        c = stream.getNext();

        Assert.assertFalse(stream.hasNext());
    }

    @Test
    public void testGetNext(){
        Stream stream = new StreamAnalyzer("abc");
        while(stream.hasNext()){
            Assert.assertNotNull(stream.getNext());
        }
    }
}
