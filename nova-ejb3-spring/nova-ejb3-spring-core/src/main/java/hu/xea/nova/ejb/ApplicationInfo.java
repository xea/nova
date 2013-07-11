package hu.xea.nova.ejb;

import javax.ejb.Remote;

@Remote({ ApplicationInfo.class })
public interface ApplicationInfo {
	
	String getInfo(String text);

}
