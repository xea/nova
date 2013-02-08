package hu.xea.nova.patterns.design.abstractfactory;

/**
 * PDF Fileokból betölti a tartalmat és {@link Document} objektumokat készít belőlük
 * 
 * @author sandor.pecsi
 *
 */
public class PDFDocumentLoader extends DocumentLoader {

	@Override
	public Document loadDocument() {
		// TODO PDF fileok betöltését implementálni
		return new PDFDocument();
	}

}
