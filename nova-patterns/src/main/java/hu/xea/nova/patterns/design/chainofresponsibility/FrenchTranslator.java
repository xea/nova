package hu.xea.nova.patterns.design.chainofresponsibility;

public class FrenchTranslator implements Translator {
	
	private Translator nextTranslator;

	public FrenchTranslator() {
		super();
	}
	
	public FrenchTranslator(final Translator nextTranslator) {
		this.nextTranslator = nextTranslator;
	}
	
	@Override
	public Translator setSuccessor(Translator nextTranslator) {
		return this.nextTranslator = nextTranslator;
	}

	@Override
	public String translate(String word) {
		String result = null;
		
		if ("pan".equals(word)) {
			result = "kenyér (fn): kemencében sült tészta";
		} else if ("ordinateur".equals(word)) {
			result = "számítógép (fn): internetdoboz";
		} else if (result == null && nextTranslator != null) {
			result = nextTranslator.translate(word);
		}
		
		return result;
	}

}
