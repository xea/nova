package hu.xea.nova.patterns.design.chainofresponsibility;

public class NorwegianTranslator implements Translator {
	
	private Translator nextTranslator;

	public NorwegianTranslator() {
		super();
	}
	
	public NorwegianTranslator(final Translator nextTranslator) {
		this.nextTranslator = nextTranslator;
	}
	
	@Override
	public Translator setSuccessor(Translator nextTranslator) {
		return this.nextTranslator = nextTranslator;
	}

	@Override
	public String translate(String word) {
		String result = null;
		
		if ("bjørn".equals(word)) {
			result = "medve (fn): nagy, szőrös állat";
		} else if ("trillebør".equals(word)) {
			result = "talicska (fn): kerekes vödör";
		} else if (result == null && nextTranslator != null) {
			result = nextTranslator.translate(word);
		}
		
		return result;
	}

}
