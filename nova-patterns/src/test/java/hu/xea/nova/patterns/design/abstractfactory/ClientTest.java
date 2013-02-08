package hu.xea.nova.patterns.design.abstractfactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ClientTest {

	@Test
	public void testPattern() {
		DocumentLoader loader = new PDFDocumentLoader();

		Document document = loader.loadDocument();
		assertNotNull(document);
		assertEquals("PDF", document.getContents());

		loader = new XMLDocumentLoader();
		document = loader.loadDocument();
		assertNotNull(document);
		assertEquals("XML", document.getContents());
	}
}