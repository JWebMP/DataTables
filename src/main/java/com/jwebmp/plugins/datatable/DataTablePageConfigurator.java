/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.datatable;

import com.google.common.base.Strings;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.datatable.enumerations.*;
import jakarta.validation.constraints.NotNull;

import java.util.*;

import static com.guicedee.guicedinjection.json.StaticStrings.*;
import static com.jwebmp.core.base.servlets.enumarations.RequirementsPriority.*;

/**
 * @author GedMarc
 */
@PluginInformation(pluginName = "Data Tables",
                   pluginUniqueName = "data-tables",
                   pluginDescription = "DataTables is a plug-in for the " +
                                       "jQuery Javascript library. " +
                                       "It is a highly flexible " +
                                       "tool, based upon the " +
                                       "foundations of progressive " +
                                       "enhancement, and will add advanced interaction  controls  to any  HTML  table .",
                   pluginVersion = "1.10.22",
                   pluginDependancyUniqueIDs = "jquery",
                   pluginCategories = "jquery,datatables, tables, ui, " + "web, framework",
                   pluginSubtitle = "DataTables is very simple to use as a jQuery plug-in with a huge range of customisable option",
                   pluginGitUrl = "https://github.com/GedMarc/JWebMP-DataTablesPlugin",
                   pluginSourceUrl = "https://datatables" + "" + ".net/download/index",
                   pluginWikiUrl = "https://github.com/GedMarc/JWebMP-DataTablesPlugin/wiki",
                   pluginOriginalHomepage = "https://www.datatables.net/",
                   pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins.forms/jwebmp-data-tables",
                   pluginIconUrl = "",
                   pluginIconImageUrl = "",
                   pluginLastUpdatedDate = "2021/09/05",
                   pluginGroupId = "com.jwebmp.plugins.forms",
                   pluginArtifactId = "jwebmp-data-tables",
                   pluginModuleName = "com.jwebmp.plugins.datatable",
                   pluginStatus = PluginStatus.Released
)
public class DataTablePageConfigurator
		implements IPageConfigurator<DataTablePageConfigurator>
{
	/**
	 * If this configurator is enabled
	 */
	private static boolean enabled = true;
	private static Set<DataTablesSortables> sortables;
	
	/**
	 * Method isEnabled returns the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @return the enabled (type boolean) of this AngularAnimatedChangePageConfigurator object.
	 */
	public static boolean isEnabled()
	{
		return DataTablePageConfigurator.enabled;
	}
	
	/**
	 * Method setEnabled sets the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @param mustEnable the enabled of this AngularAnimatedChangePageConfigurator object.
	 */
	public static void setEnabled(boolean mustEnable)
	{
		DataTablePageConfigurator.enabled = mustEnable;
	}

	/**
	 * Returns the sortables to apply
	 *
	 * @return
	 */
	public static Set<DataTablesSortables> getSortables()
	{
		if (DataTablePageConfigurator.sortables == null)
		{
			DataTablePageConfigurator.sortables = new LinkedHashSet<>();
		}
		return DataTablePageConfigurator.sortables;
	}
	
	@NotNull
	@Override
	public Page<?> configure(Page<?> page)
	{
		if (!page.isConfigured() && enabled())
		{
			page.getBody()
			    .addJavaScriptReference(DataTableReferencePool.JQueryDataTables.getJavaScriptReference());
			page.getBody()
			    .addCssReference(DataTableReferencePool.JQueryDataTables.getCssReference());
		}
		return page;
	}
	
	@Override
	public boolean enabled()
	{
		return DataTablePageConfigurator.enabled;
	}
}
