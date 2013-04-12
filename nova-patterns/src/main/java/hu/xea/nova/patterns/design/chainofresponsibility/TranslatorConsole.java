package hu.xea.nova.patterns.design.chainofresponsibility;

public class TranslatorConsole {
	
	public static void main(final String[] args) {
		final Translator enTranslator = new EnglishTranslator();
		final Translator deTranslator = new GermanTranslator(enTranslator);
		final Translator frTranslator = new FrenchTranslator(deTranslator);
		final Translator noTranslator = new NorwegianTranslator(frTranslator);
		final Translator esTranslator = new SpanishTranslator(noTranslator);
		
		final String[] words = new String[] {
				"cero", "mädchen", "strawberry", "bjørn", "ordinateur"
		};
		
		for (final String word : words) {
			final String translated = esTranslator.translate(word);
			
			final String output = String.format("Keresett szó: %-12s jelentés: %s", word, translated);
			
			System.out.println(output);
		}
	}

}
