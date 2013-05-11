package hu.xea.nova.chat.impl;

import hu.xea.nova.chat.api.Connection;

/**
 * An offline-only connection that does not allow any operations to be executed on the server.
 * 
 * It fakes all the method requests in order to consistently appear as offline.
 * 
 * @author xea 
 *
 */
public class OfflineConnection implements Connection {

	@Override
	public boolean isConnected() {
		return false;
	}

	@Override
	public boolean disconnect(String reason) {
		return true;
	}

}
