package hu.xea.nova.patterns.design.abstractfactory;

/**
 * XML Fileokból tölt be dokumentumokat, majd {@link Document} objektumot készít belőlük
 * 
 * @author sandor.pecsi
 *
 */
public class XMLDocumentLoader extends DocumentLoader {

	@Override
	public Document loadDocument() {
		// TODO XML file betöltést implementálni
		return new XMLDocument();
	}

}
