package hu.xea.nova.chat;

/**
 * A ConnectionException is thrown if a problem occurs upon connecting to a server or within an active
 * connection.
 * 
 * @author xea
 *
 */
public class ConnectionException extends Exception {

	private static final long serialVersionUID = -1457867558392811966L;
	
	/**
	 * The {@link Connection} object which caused the exception
	 */
	private Connection connection;

	/**
	 * Creates a new {@link ConnectionException} object pointing at the {@link Connection} object that
	 * caused the creation of this exception.
	 * 
	 * @param connection the connection object causing the problem
	 */
	public ConnectionException(final Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}
	
}
