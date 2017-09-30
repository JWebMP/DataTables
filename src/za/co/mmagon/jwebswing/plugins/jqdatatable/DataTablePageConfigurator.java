/*
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.plugins.jqdatatable;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.plugins.PluginInformation;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTablePlugins;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTableThemes;
import za.co.mmagon.jwebswing.plugins.pools.jquerydatatables.DataTableReferencePool;

import java.util.EnumSet;

/**
 * @author GedMarc
 */
@PluginInformation(pluginName = "Data Tables",
		pluginUniqueName = "data-tables",
		pluginDescription = "DataTables is a plug-in for the jQuery Javascript library. It is a highly flexible tool, based upon the foundations of progressive enhancement, and will add advanced interaction controls to any HTML table.",
		pluginVersion = "1.10.16",
		pluginDependancyUniqueIDs = "jquery",
		pluginCategories = "jquery,datatables, tables, ui, web, framework",
		pluginSubtitle = "DataTables is very simple to use as a jQuery plug-in with a huge range of customisable option",
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing-DataTablesPlugin",
		pluginSourceUrl = "https://datatables.net/download/index",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-DataTablesPlugin/wiki",
		pluginOriginalHomepage = "https://www.datatables.net/",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/DataTablesPlugin.jar/download",
		pluginIconUrl = "bower_components/datatables/icon.jpg",
		pluginIconImageUrl = "bower_components/datatables/jqdatatables_logo.png",
		pluginLastUpdatedDate = "2017/09/29"
)
public class DataTablePageConfigurator extends PageConfigurator
{
	
	private static final long serialVersionUID = 1L;
	
	private static EnumSet<DataTableThemes> themes;
	private static EnumSet<DataTablePlugins> plugins;
	
	/**
	 * Gets the list of themes to be rendered with the page
	 *
	 * @return
	 */
	public static EnumSet<DataTableThemes> getThemes()
	{
		if (themes == null)
		{
			themes = EnumSet.of(DataTableThemes.DataTables);
		}
		return themes;
	}
	
	/**
	 * Returns the applied plugins
	 *
	 * @return
	 */
	public static EnumSet<DataTablePlugins> getPlugins()
	{
		if (plugins == null)
		{
			plugins = EnumSet.of(DataTablePlugins.Responsive);
		}
		return plugins;
	}
	
	@Override
	public Page configure(Page page)
	{
		if (!page.isConfigured())
		{
			page.getBody().addJavaScriptReference(DataTableReferencePool.JQueryDataTables.getJavaScriptReference());
			//page.getBody().addCssReference(DataTableReferencePool.JQueryDataTables.getCssReference());
			
			for (DataTableThemes theme : getThemes())
			{
				String themeBasePath = "bower_components/datatables.net-" + theme.getData() + "/js/dataTables." + theme.getFilename();
				
				String themeBaseCssPath = "bower_components/datatables.net-" + theme.getData() + "/css/";
				if (theme.getFilenameOverride() == null || theme.getFilenameOverride().isEmpty())
				{
					themeBaseCssPath += "dataTables." + theme.getFilename();
				}
				else
				{
					themeBaseCssPath += theme.getFilenameOverride();
				}
				
				page.getBody().addJavaScriptReference(new JavascriptReference("DataTables" + theme.toString(), 1.1016, themeBasePath + ".js"));
				page.getBody().addCssReference(new CSSReference("DataTables" + theme.toString(), 1.1016, themeBaseCssPath + ".css"));
				
				for (DataTablePlugins plugin : getPlugins())
				{
					String jsPath = "bower_components/" + ("datatables.net-") + plugin.getFilename() + "/js/" + (!plugin.isPlugin() ? "dataTables." : "") + plugin.getFilename() + ".js";
					page.getBody().addJavaScriptReference(new JavascriptReference("DataTables" + theme.getData() + plugin.getFilename(), 1.0, jsPath));
					if (plugin.isCss())
					{
						String cssPath = "bower_components/" + ("datatables.net-") + plugin.getFilename() + "/css/" + (!plugin.isPlugin() ? "dataTables." : "") + plugin.getFilename() + ".css";
						page.getBody().addCssReference(new CSSReference("DataTables" + theme.getData() + plugin.getFilename(), 1.0, cssPath));
					}
				}
			}
		}
		return page;
	}
}