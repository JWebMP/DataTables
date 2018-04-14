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
package com.jwebmp.plugins.jqdatatable;

import com.jwebmp.Page;
import com.jwebmp.PageConfigurator;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.base.references.CSSReference;
import com.jwebmp.base.references.JavascriptReference;
import com.jwebmp.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.plugins.PluginInformation;
import com.jwebmp.plugins.jqdatatable.enumerations.DataTablePlugins;
import com.jwebmp.plugins.jqdatatable.enumerations.DataTableThemes;
import com.jwebmp.plugins.jqdatatable.enumerations.DataTablesSortables;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;

import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.jwebmp.utilities.StaticStrings.*;

/**
 * @author GedMarc
 */
@PluginInformation(pluginName = "Data Tables",
		pluginUniqueName = "data-tables",
		pluginDescription = "DataTables is a plug-in for the " + "jQuery Javascript library. " + "It is a highly flexible " + "tool, based upon the " + "foundations of progressive " + "enhancement, and will add " + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "advanced" + "" + "" + " " + "interaction " + "" + "controls " + "to" + " " + "any " + "HTML " + "table" + ".",
		pluginVersion = "1.10.16",
		pluginDependancyUniqueIDs = "jquery",
		pluginCategories = "jquery,datatables, tables, ui, " + "web, framework",
		pluginSubtitle = "DataTables is very simple to use as a jQuery plug-in with a huge range of customisable option",
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing-DataTablesPlugin",
		pluginSourceUrl = "https://datatables" + "" + ".net/download/index",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-DataTablesPlugin/wiki",
		pluginOriginalHomepage = "https://www.datatables.net/",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/DataTablesPlugin.jar/download",
		pluginIconUrl = "bower_components/datatables/icon.jpg",
		pluginIconImageUrl = "bower_components/datatables/jqdatatables_logo.png",
		pluginLastUpdatedDate = "2017/09/29")
public class DataTablePageConfigurator
		extends PageConfigurator
{

	private static final String DataTablesOperatorString = "dataTables.";
	private static final String DataTablesNameString = "DataTables";
	private static final String BowerComponentsString = "bower_components/";
	private static final String BowerComponentDataTablesString = "datatables.net-";
	private static final String CssString = "/css/";

	private static final String JsMinString = ".min.js";
	private static final String CssMinString = ".min.css";

	private static final long serialVersionUID = 1L;

	private static EnumSet<DataTableThemes> themes;
	private static Set<DataTablePlugins> plugins;
	private static Set<DataTablesSortables> sortables;
	private static Set<JavascriptReference> extensions;

	/**
	 * Switches the theme used for the data table
	 *
	 * @param theme
	 */
	public static void switchTheme(DataTableThemes theme)
	{
		getThemes().clear();
		getThemes().add(theme);
	}

	/**
	 * Gets the list of themes to be rendered with the page
	 *
	 * @return
	 */
	public static Set<DataTableThemes> getThemes()
	{
		if (themes == null)
		{
			themes = EnumSet.of(DataTableThemes.DataTables);
		}
		return themes;
	}

	/**
	 * Configure buttons JS References
	 */
	public static void configureButtons()
	{
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
		if (extensions == null)
		{
			extensions = new LinkedHashSet<>();
		}
		return extensions;
	}

	@Override
	public Page configure(Page page)
	{
		if (!page.isConfigured())
		{
			JQueryPageConfigurator.setRequired(true);
			AngularPageConfigurator.setRequired(true);
			page.getBody()
			    .addJavaScriptReference(DataTableReferencePool.JQueryDataTables.getJavaScriptReference());

			for (DataTableThemes theme : getThemes())
			{
				String themeBasePath = "bower_components/datatables.net-" + theme.getData() + "/js/dataTables." + theme.getFilename();

				String themeBaseCssPath = "bower_components/datatables.net-" + theme.getData() + CssString;
				if (theme.getFilenameOverride() == null || theme.getFilenameOverride()
				                                                .isEmpty())
				{
					themeBaseCssPath += DataTablesOperatorString + theme.getFilename();
				}
				else
				{
					themeBaseCssPath += theme.getFilenameOverride();
				}

				if (!themeBasePath.contains("dataTables.dataTables"))
				{
					page.getBody()
					    .addJavaScriptReference(new JavascriptReference(DataTablesNameString + "-" + theme.toString(), 1.1016, themeBasePath + JsMinString, 16).setPriority(
							    RequirementsPriority.Third));
				}

				page.getBody()
				    .addCssReference(new CSSReference(DataTablesNameString + theme.toString(), 1.1016, themeBaseCssPath + CssMinString));

				configurePlugins(page, theme);
			}

			DataTablePageConfigurator.getExtensions()
			                         .forEach(a -> page.getBody()
			                                           .addJavaScriptReference(a));

		}
		return page;
	}

	/**
	 * Configures all the page plugins with the theme
	 *
	 * @param page
	 * @param theme
	 */
	private void configurePlugins(Page page, DataTableThemes theme)
	{
		int sortOrder = 16;
		for (DataTablePlugins plugin : getPlugins())
		{
			String jsPath = null;
			if (theme == DataTableThemes.DataTables)
			{
				jsPath = BowerComponentsString + BowerComponentDataTablesString + plugin.getFilename() + "/js/" + (plugin.isPlugin()
				                                                                                                   ? DataTablesOperatorString + plugin.getFilename() + JsMinString
				                                                                                                   : STRING_EMPTY);
			}
			else
			{
				jsPath = BowerComponentsString + BowerComponentDataTablesString + plugin.getFilename() + STRING_DASH + theme.getData() + "/js/" + (plugin.isPlugin()
				                                                                                                                                   ? plugin.getFilename() + "." + theme.getFilename() + JsMinString
				                                                                                                                                   : STRING_EMPTY);
			}

			if (theme == DataTableThemes.DataTables)
			{
				page.getBody()
				    .addJavaScriptReference(new JavascriptReference(DataTablesNameString + theme.getData() + plugin.getFilename(), 1.0, jsPath, sortOrder++).setPriority(
						    RequirementsPriority.Fourth));
			}
			else
			{
				page.getBody()
				    .addJavaScriptReference(new JavascriptReference(DataTablesNameString + theme.getData() + plugin.getFilename(), 1.0, jsPath, sortOrder++).setPriority(
						    RequirementsPriority.DontCare));
			}

			if (plugin.isCss())
			{
				String cssPath = null;
				if (theme == DataTableThemes.DataTables)
				{
					cssPath = BowerComponentsString + BowerComponentDataTablesString + plugin.getFilename() + STRING_DASH + theme.getData() + CssString + plugin.getFilename() + STRING_DOT + (
							plugin.isPlugin()
							? DataTablesOperatorString + CssMinString
							: STRING_EMPTY);
				}
				else
				{
					cssPath = BowerComponentsString + BowerComponentDataTablesString + plugin.getFilename() + STRING_DASH + theme.getData() + CssString + plugin.getFilename() + STRING_DOT + theme.getFilename() + CssMinString;
				}
				page.getBody()
				    .addCssReference(new CSSReference(DataTablesNameString + theme.getData() + plugin.getFilename(), 1.0, cssPath.replace("..", ".")));
			}

			getSortables().forEach(a -> page.getBody()
			                                .addJavaScriptReference(a.getReference()));
		}
	}

	/**
	 * Returns the applied plugins
	 *
	 * @return
	 */
	public static Set<DataTablePlugins> getPlugins()
	{
		if (plugins == null)
		{
			plugins = new LinkedHashSet<>();
		}
		return plugins;
	}

	/**
	 * Returns the sortables to apply
	 *
	 * @return
	 */
	public static Set<DataTablesSortables> getSortables()
	{
		if (sortables == null)
		{
			sortables = new LinkedHashSet<>();
		}
		return sortables;
	}
}
