package hu.xea.nova.patterns.design.builder;

public class XMLDocumentConverter extends DocumentConverter {

	@Override
	public void open() {
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		System.out.println("<document>");
	}

	@Override
	public void close() {
		System.out.println("</document>");
	}

	@Override
	public void printTitle(final String title) {
		System.out.println(String.format("<title>%s</title>", title));
	}

	@Override
	public void printAuthor(final String author) {
		System.out.println(String.format("<author>%s</author>", author));
	}
	
	@Override
	public void printCatalog(final String catalog) {
		System.out.println(String.format("<catalog>%s</catalog>", catalog));
	}
	
	@Override
	public void printContent(final String content) {
		System.out.println(String.format("<content>%s</content>", content));

	}
	@Override
	public void printFooter(final String footer) {
		System.out.println(String.format("<footer>%s</footer>", footer));
	}
}
