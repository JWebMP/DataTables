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
import com.jwebmp.plugins.datatable.enumerations.DataTablePlugins;
import com.jwebmp.plugins.datatable.enumerations.DataTableThemes;
import com.jwebmp.plugins.datatable.enumerations.DataTablesSortables;

import jakarta.validation.constraints.NotNull;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.guicedee.guicedinjection.json.StaticStrings.*;
import static com.jwebmp.core.base.servlets.enumarations.RequirementsPriority.*;
import static com.jwebmp.core.utilities.StaticStrings.*;

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
		pluginLastUpdatedDate = "2020/12/16",
		pluginGroupId = "com.jwebmp.plugins.forms",
		pluginArtifactId = "jwebmp-data-tables",
		pluginModuleName = "com.jwebmp.plugins.datatable",
		pluginStatus = PluginStatus.Released
)
public class DataTablePageConfigurator
		implements IPageConfigurator<DataTablePageConfigurator>
{
	private static final String DataTablesOperatorString = "dataTables.";
	private static final String DataTablesNameString = "DataTables";
	private static final String BowerComponentsString = "bower_components/";
	private static final String BowerComponentDataTablesString = "datatables.net-";
	private static final String CssString = "/css/";
	private static final String JsMinString = ".min.js";
	private static final String CssMinString = ".min.css";
	/**
	 * If this configurator is enabled
	 */
	private static boolean enabled = true;
	private static EnumSet<DataTableThemes> themes;
	private static Set<DataTablePlugins> plugins;
	private static Set<DataTablesSortables> sortables;
	private static Set<JavascriptReference> extensions;

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
	 * @param mustEnable
	 * 		the enabled of this AngularAnimatedChangePageConfigurator object.
	 */
	public static void setEnabled(boolean mustEnable)
	{
		DataTablePageConfigurator.enabled = mustEnable;
	}

	/**
	 * Switches the theme used for the data table
	 *
	 * @param theme
	 */
	public static void switchTheme(DataTableThemes theme)
	{
		DataTablePageConfigurator.getThemes()
		                         .clear();
		DataTablePageConfigurator.getThemes()
		                         .add(theme);
	}

	/**
	 * Gets the list of themes to be rendered with the page
	 *
	 * @return
	 */
	public static Set<DataTableThemes> getThemes()
	{
		if (DataTablePageConfigurator.themes == null)
		{
			DataTablePageConfigurator.themes = EnumSet.of(DataTableThemes.DataTables);
		}
		return DataTablePageConfigurator.themes;
	}

	/**
	 * Configure buttons JS References
	 */
	public static void configureButtons()
	{
		DataTablePageConfigurator.getPlugins()
		                         .add(DataTablePlugins.Buttons);

		DataTablePageConfigurator.getExtensions()
		                         .add(DataTableReferencePool.Buttons.getJavaScriptReference());

		DataTablePageConfigurator.getExtensions()
		                         .add(DataTableReferencePool.JSZip.getJavaScriptReference());
		DataTablePageConfigurator.getExtensions()
		                         .add(DataTableReferencePool.PDFMake.getJavaScriptReference());
		DataTablePageConfigurator.getExtensions()
		                         .add(DataTableReferencePool.PDFMakeVFSFonts.getJavaScriptReference());

		DataTablePageConfigurator.getExtensions()
		                         .add(DataTableReferencePool.ButtonsColVis.getJavaScriptReference());
		DataTablePageConfigurator.getExtensions()
		                         .add(DataTableReferencePool.ButtonsHtml.getJavaScriptReference());
		DataTablePageConfigurator.getExtensions()
		                         .add(DataTableReferencePool.ButtonsPrint.getJavaScriptReference());
	}

	/**
	 * Any additional JavaScript references to apply
	 * <p>
	 * Usually with getOptions().getButtons() to addon the required buttons javascripts
	 *
	 * @return
	 */
	public static Set<JavascriptReference> getExtensions()
	{
		if (DataTablePageConfigurator.extensions == null)
		{
			DataTablePageConfigurator.extensions = new LinkedHashSet<>();
		}
		return DataTablePageConfigurator.extensions;
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

			for (DataTableThemes theme : DataTablePageConfigurator.getThemes())
			{
				String themeBasePath = "bower_components/datatables.net-" + theme.getData().toLowerCase() + "/js/dataTables." + theme.getFilename();

				String themeBaseCssPath = "bower_components/datatables.net-" + theme.getData().toLowerCase() + DataTablePageConfigurator.CssString;
				if (theme.getFilenameOverride() == null || theme.getFilenameOverride()
				                                                .isEmpty())
				{
					themeBaseCssPath += DataTablePageConfigurator.DataTablesOperatorString + theme.getFilename();
				}
				else
				{
					themeBaseCssPath += theme.getFilenameOverride();
				}

				if (!themeBasePath.contains("dataTables.dataTables"))
				{
					page.getBody()
					    .addJavaScriptReference(new JavascriptReference(DataTablePageConfigurator.DataTablesNameString + "-" + theme.toString(), 1.1016, themeBasePath +
					                                                                                                                                     DataTablePageConfigurator.JsMinString,
					                                                    16).setPriority(
							    RequirementsPriority.Third));
				}

				page.getBody()
				    .addCssReference(new CSSReference(DataTablePageConfigurator.DataTablesNameString + theme.toString(), 1.1016, themeBaseCssPath +
				                                                                                                                 DataTablePageConfigurator.CssMinString));

				configurePlugins(page, theme);
			}
			DataTablePageConfigurator.getExtensions()
			                         .forEach(a -> page.getBody()
			                                           .addJavaScriptReference(a));
		}
		return page;
	}

	@Override
	public boolean enabled()
	{
		return DataTablePageConfigurator.enabled;
	}

	/**
	 * Configures all the page plugins with the theme
	 *
	 * @param page
	 * @param theme
	 */
	private void configurePlugins(Page<?> page, DataTableThemes theme)
	{
		int sortOrder = 160;
		for (DataTablePlugins plugin : DataTablePageConfigurator.getPlugins())
		{
			if(!Strings.isNullOrEmpty(plugin.getPluginRootJSPath()))
			{
				page.addJavaScriptReference(new JavascriptReference("dtplugin" + plugin.name(), 1.0, plugin.getPluginRootJSPath(),Third));
			}

			String jsPath = null;
			if (theme == DataTableThemes.DataTables)
			{
				jsPath = DataTablePageConfigurator.BowerComponentsString +
				         DataTablePageConfigurator.BowerComponentDataTablesString + plugin.getFilename().toLowerCase() + "/js/" + (plugin.isPlugin()
				                                                                                                     ? DataTablePageConfigurator.DataTablesOperatorString +
				                                                                                                       plugin.getFilename() +
				                                                                                                       DataTablePageConfigurator.JsMinString
				                                                                                                     : STRING_EMPTY);
			}
			else
			{
				if(!plugin.getDirectoryName().contains("sortable"))
				jsPath = DataTablePageConfigurator.BowerComponentsString +
				         DataTablePageConfigurator.BowerComponentDataTablesString + plugin.getDirectoryName().toLowerCase() + STRING_DASH + theme.getData() + "/js/" + (plugin.isPlugin()
				                                                                                                                                     ? plugin.getFilename() +
				                                                                                                                                       "." +
				                                                                                                                                       theme.getFilename() +
				                                                                                                                                       DataTablePageConfigurator.JsMinString
				                                                                                                                                     : STRING_EMPTY);
			}
			if(jsPath != null)
			if (theme == DataTableThemes.DataTables)
			{
				page.getBody()
				    .addJavaScriptReference(
						    new JavascriptReference(DataTablePageConfigurator.DataTablesNameString + theme.getData() + plugin.getFilename(), 1.0, jsPath, sortOrder++).setPriority(
								    RequirementsPriority.Fourth));
			}
			else
			{
				page.getBody()
				    .addJavaScriptReference(
						    new JavascriptReference(DataTablePageConfigurator.DataTablesNameString + theme.getData() + plugin.getFilename(), 1.0, jsPath, sortOrder++).setPriority(
								    RequirementsPriority.DontCare));
			}

			if (plugin.isCss())
			{
				String cssPath = null;
				if (theme == DataTableThemes.DataTables)
				{
					cssPath = DataTablePageConfigurator.BowerComponentsString +
					          DataTablePageConfigurator.BowerComponentDataTablesString +
					          plugin.getDirectoryName() +
					          STRING_DASH +
					          theme.getData() +
					          DataTablePageConfigurator.CssString +
					          plugin.getFilename() +
					          STRING_DOT +
					          (
							          plugin.isPlugin()
							          ? DataTablePageConfigurator.DataTablesOperatorString + DataTablePageConfigurator.CssMinString
							          : STRING_EMPTY);
				}
				else
				{
					cssPath = DataTablePageConfigurator.BowerComponentsString +
					          DataTablePageConfigurator.BowerComponentDataTablesString +
					          plugin.getDirectoryName() +
					          STRING_DASH +
					          theme.getData() +
					          DataTablePageConfigurator.CssString +
					          plugin.getFilename() +
					          STRING_DOT +
					          theme.getFilename() +
					          DataTablePageConfigurator.CssMinString;
				}
				page.getBody()
				    .addCssReference(new CSSReference(DataTablePageConfigurator.DataTablesNameString + theme.getData() + plugin.getFilename(), 1.0, cssPath.replace("..", ".")));
			}
		}
	}

	/**
	 * Returns the applied plugins
	 *
	 * @return
	 */
	public static Set<DataTablePlugins> getPlugins()
	{
		if (DataTablePageConfigurator.plugins == null)
		{
			DataTablePageConfigurator.plugins = new LinkedHashSet<>();
		}
		return DataTablePageConfigurator.plugins;
	}
}
