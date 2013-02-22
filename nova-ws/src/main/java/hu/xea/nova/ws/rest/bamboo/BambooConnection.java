package hu.xea.nova.ws.rest.bamboo;

/**
 * Describes a connection to any Bamboo server
 * 
 * @author xea
 */
public class BambooConnection {

	/**
	 * The default protocol scheme used to connect to the server. eg. "http"
	 */
	public static final String DEFAULT_SCHEME = "http";

	/**
	 * The default hostname where the Bamboo server is listening on. eg.
	 * "localhost"
	 */
	public static final String DEFAULT_HOSTNAME = "localhost";

	/**
	 * The default port number where the Bamboo server is listening on. eg. 8085
	 */
	public static final int DEFAULT_PORT = 8085;

	/**
	 * The URI path where the Bamboo servers REST API is available. eg.
	 * "/rest/api/latest"
	 */
	public static final String DEFAULT_PATH = "/rest/api/latest";

	/**
	 * The default username that is used for authentication
	 */
	public static final String DEFAULT_USERNAME = "bamboo";

	/**
	 * The default password that is used for authentication
	 */
	public static final String DEFAULT_PASSWORD = "bamboo";

	/**
	 * The actual protocol scheme that is used for connecting to the server
	 */
	private String scheme = DEFAULT_SCHEME;

	/**
	 * The actual hostname where the server is listening on
	 */
	private String hostname = DEFAULT_HOSTNAME;

	/**
	 * The actual TCP port number where the server is listening on
	 */
	private int port = DEFAULT_PORT;

	/**
	 * The actual path where the servers REST API is available
	 */
	private String path = DEFAULT_PATH;

	/**
	 * The actual user name that is used for authentication
	 */
	private String username = DEFAULT_USERNAME;

	/**
	 * The actual password that is used for authentication
	 */
	private String password = DEFAULT_PASSWORD;

	/**
	 * No-argument constructor which sets all properties to their default
	 * values.
	 */
	public BambooConnection() {
		super();
	}

	/**
	 * Instantiates a new {@link BambooConnection} with overriding the
	 * <code>hostname</code>, <code>username</code> and <code>password</code>
	 * properites
	 * 
	 * @param hostname hostname of the server
	 * @param username user name for authentication
	 * @param password password for authentication
	 */
	public BambooConnection(final String hostname, final String username, final String password) {
		this();
		this.hostname = hostname;
		this.username = username;
		this.password = password;
	}

	/**
	 * Instantiates a new {@link BambooConnection} object with overriding every property
	 * 
	 * @param scheme protocol scheme
	 * @param hostname host name of the server
	 * @param port port number of the server
	 * @param path REST API path of the server
	 * @param username user name for authentication
	 * @param password password for authentication
	 */
	public BambooConnection(final String scheme, final String hostname, final int port, final String path,
			final String username, final String password) {
		this(hostname, username, password);
	}
	
	@Override
	public String toString() {
		return scheme + "://" + hostname + ":" + port + path;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
