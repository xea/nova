package hu.xea.nova.patterns.design.builder;

public class TextDocumentConverter extends DocumentConverter {

	public void open() {
		// Ennél a formátumnál nincs szükség megnyitásra
	}

	public void close() {
		// Ennél a formátumnál nincs szükség lezárásra
	}

	public void printTitle(final String title) {
		System.out.println(String.format("Title: %s", title));
	}

	public void printAuthor(final String author) {
		System.out.println(String.format("Author: %s", author));
	}
	
	public void printCatalog(final String catalog) {
		System.out.println(String.format("Catalog: %s", catalog));
	}
	
	public void printContent(final String content) {
		System.out.println(String.format("Content: %s", content));

	}
	public void printFooter(final String footer) {
		System.out.println(String.format("Footer: %s", footer));
	}
}
