package hu.xea.nova.ejb;
import javax.ejb.Stateful;

import hu.xea.nova.ejb.ApplicationInfo;

@Stateful(mappedName = "ejb/appinfo", name = "ejb/appinfo")
public class ApplicationInfoBean implements ApplicationInfo {

	@Override
	public String getInfo(final String text) {
		return "Hurrá örülünk " + text;
	}

}
