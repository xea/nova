package hu.xea.nova.patterns.design.builder;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BuilderTest {

	@Test
	public void testIfCanInitialize() {
		DocumentConverter dc;
		final Document doc = new Document("Gerald Durrell", "Susog a táj", "4 fejezet", "SUSOG", "Copyright");
		final WordProcessor wp = new WordProcessor();
		
		dc = new XMLDocumentConverter();
		wp.convert(dc, doc);

		dc = new TextDocumentConverter();
		wp.convert(dc, doc);
	}
}
