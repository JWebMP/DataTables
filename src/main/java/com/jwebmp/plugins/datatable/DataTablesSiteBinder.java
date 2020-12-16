package com.jwebmp.plugins.datatable;

import com.google.inject.Key;
import com.guicedee.guicedservlets.services.GuiceSiteInjectorModule;
import com.guicedee.guicedservlets.services.IGuiceSiteBinder;
import com.guicedee.logger.LogFactory;

import java.util.logging.Logger;

public class DataTablesSiteBinder
		implements IGuiceSiteBinder<GuiceSiteInjectorModule>
{
	private static final Logger log = LogFactory.getLog("DataTablesSiteBinder");

	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		DataTablesSiteBinder.log.config("Serving Data Tables Data at /jwdatatables");
		module.serve$("/jwdatatables")
		      .with(Key.get(DataTablesServlet.class));
	}
}
