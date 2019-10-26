package com.jwebmp.plugins.datatable;

import com.google.inject.Key;
import com.jwebmp.guicedservlets.services.GuiceSiteInjectorModule;
import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;
import com.guicedee.logger.LogFactory;

import java.util.logging.Logger;

public class DataTablesSiteBinder
		implements IGuiceSiteBinder<GuiceSiteInjectorModule>
{
	private static final Logger log = LogFactory.getLog("DataTablesSiteBinder");

	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		DataTablesSiteBinder.log.info("Serving Data Tables Data at /jwdatatables");
		module.serve$("/jwdatatables")
		      .with(Key.get(DataTablesServlet.class));
	}
}
