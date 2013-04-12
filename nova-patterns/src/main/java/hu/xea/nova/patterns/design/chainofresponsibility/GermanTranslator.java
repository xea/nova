package hu.xea.nova.patterns.design.chainofresponsibility;

public class GermanTranslator implements Translator {
	
	private Translator nextTranslator;

	public GermanTranslator() {
		super();
	}
	
	public GermanTranslator(final Translator nextTranslator) {
		this.nextTranslator = nextTranslator;
	}
	
	@Override
	public Translator setSuccessor(Translator nextTranslator) {
		return this.nextTranslator = nextTranslator;
	}

	@Override
	public String translate(String word) {
		String result = "";
		
		if ("mädchen".equals(word)) {
			result = "lány (fn): fiatal nőember";
		} else if ("stuhl".equals(word)) {
			result = "szék (fn): ülőalkalmatosság";
		} else if ("kaufen".equals(word)) {
			result = "vásárolni (i): pénzért portékát szerezni";
		} else if ("was".equals(word)) {
			result = "mi?: kérdőszó";
		} else if (nextTranslator != null) {
			result = nextTranslator.translate(word);
		}
		
		return result;
	}

}
