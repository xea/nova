package hu.xea.nova.patterns.design.builder;

public abstract class DocumentConverter {

	public abstract void open();

	public abstract void close();
	
	public abstract void printTitle(final String title);

	public abstract void printAuthor(final String author);
	
	public abstract void printCatalog(final String catalog);

	public abstract void printContent(final String content);

	public abstract void printFooter(final String footer);
}
