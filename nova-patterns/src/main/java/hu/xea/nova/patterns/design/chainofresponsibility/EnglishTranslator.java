package hu.xea.nova.patterns.design.chainofresponsibility;

public class EnglishTranslator implements Translator {
	
	private Translator nextTranslator;

	public EnglishTranslator() {
		super();
	}
	
	public EnglishTranslator(final Translator nextTranslator) {
		this.nextTranslator = nextTranslator;
	}
	
	@Override
	public Translator setSuccessor(Translator nextTranslator) {
		return this.nextTranslator = nextTranslator;
	}

	@Override
	public String translate(String word) {
		String result = "";
		
		if ("apple".equals(word)) {
			result = "alma (fn): nagy, piros gyümölcs";
		} else if ("pear".equals(word)) {
			result = "körte (fn): sárga gyümölcs";
		} else if ("strawberry".equals(word)) {
			result = "eper (fn): kicsi, piros gyümölcs";
		} else if ("grape".equals(word)) {
			result = "szőlő (fn): kicsi, sok, zöld vagy bordó gyümölcs";
		} else if (nextTranslator != null) {
			result = nextTranslator.translate(word);
		}
		
		return result;
	}

}
