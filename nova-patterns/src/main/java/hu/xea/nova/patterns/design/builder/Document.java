package hu.xea.nova.patterns.design.builder;

public class Document {
	
	public String author;

	public String content;

	public String catalog;

	public String footer;

	public String title;

	public Document() {
	}

	public Document(final String author, final String title, final String catalog, final String content, final String footer) {
		this.author = author;
		this.title = title;
		this.catalog = catalog;
		this.content = content;
		this.footer = footer;
	}

}
