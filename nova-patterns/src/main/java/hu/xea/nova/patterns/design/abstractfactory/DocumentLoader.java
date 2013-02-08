package hu.xea.nova.patterns.design.abstractfactory;

/**
 * Ez az Abstract Factory szerepet betöltő osztály, a kliens számára ez a
 * mintába a belépési pont. A {@link DocumentLoader} osztály implementációi
 * zárják magukba a {@link Document} objektumok betöltésének mikéntjét. 
 * 
 * @author sandor.pecsi
 *
 */
public abstract class DocumentLoader {
	
	/**
	 * Betölti az adott dokumentumot.
	 * 
	 * @return az implementáció által megadott forrásból származó dokumentum
	 */
	public abstract Document loadDocument();

}
