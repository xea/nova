package hu.xea.nova.patterns.design.chainofresponsibility;

public interface Translator {
	
	public Translator setSuccessor(Translator nextTranslator);
	
	public String translate(String word);
}
