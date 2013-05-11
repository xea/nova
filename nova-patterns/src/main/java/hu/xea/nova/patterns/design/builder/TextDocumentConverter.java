package hu.xea.nova.patterns.design.builder;

public class TextDocumentConverter extends DocumentConverter {

	@Override
	public void open() {
		// Ennél a formátumnál nincs szükség megnyitásra
	}

	@Override
	public void close() {
		// Ennél a formátumnál nincs szükség lezárásra
	}

	@Override
	public void printTitle(final String title) {
		System.out.println(String.format("Title: %s", title));
	}

	@Override
	public void printAuthor(final String author) {
		System.out.println(String.format("Author: %s", author));
	}
	
	@Override
	public void printCatalog(final String catalog) {
		System.out.println(String.format("Catalog: %s", catalog));
	}
	
	@Override
	public void printContent(final String content) {
		System.out.println(String.format("Content: %s", content));

	}
	@Override
	public void printFooter(final String footer) {
		System.out.println(String.format("Footer: %s", footer));
	}
}
