package hu.xea.nova.patterns.design.abstractfactory;

/**
 * Az Abstract Product szerepet betöltő osztály, általános dokumentumleíró. 
 * A kliens kód ezen keresztül érheti el az adott implementáció által elért
 * tartalmat.
 * 
 * @author sandor.pecsi
 *
 */
public abstract class Document {

	/**
	 * Visszaadja a dokumentum tartalmát.
	 * 
	 * @return a tartalom szöveges reprezentációja
	 */
	public abstract String getContents();
}
