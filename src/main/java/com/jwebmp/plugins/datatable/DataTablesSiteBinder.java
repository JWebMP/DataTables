package com.jwebmp.plugins.datatable;

import com.jwebmp.guicedservlets.services.GuiceSiteInjectorModule;
import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;
import com.jwebmp.logger.LogFactory;

import java.util.logging.Logger;

public class DataTablesSiteBinder
		implements IGuiceSiteBinder<GuiceSiteInjectorModule>
{
	private static final Logger log = LogFactory.getLog("DataTablesSiteBinder");

	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		DataTablesSiteBinder.log.info("Serving Data Tables Data at /jwdatatables");
		module.serveRegex$("/jwdatatables")
		      .with(DataTablesServlet.class);

	}
}
