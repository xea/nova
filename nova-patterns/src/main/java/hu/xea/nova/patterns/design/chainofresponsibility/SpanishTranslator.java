package hu.xea.nova.patterns.design.chainofresponsibility;

public class SpanishTranslator implements Translator {
	
	private Translator nextTranslator;

	public SpanishTranslator() {
		super();
	}
	
	public SpanishTranslator(final Translator nextTranslator) {
		this.nextTranslator = nextTranslator;
	}
	
	@Override
	public Translator setSuccessor(Translator nextTranslator) {
		return this.nextTranslator = nextTranslator;
	}

	@Override
	public String translate(String word) {
		String result = null;
		
		if ("cero".equals(word)) {
			result = "nulla (szn): a nulla szám";
		} else if ("gato".equals(word)) {
			result = "macska (fn): cica";
		} else if ("pero".equals(word)) {
			result = "kutya (fn): cica";
		} else if ("grape".equals(word)) {
			result = "szőlő (fn): kicsi, sok, zöld vagy bordó gyümölcs";
		} else if (result == null && nextTranslator != null) {
			result = nextTranslator.translate(word);
		}
		
		return result;
	}

}
