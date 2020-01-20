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

package com.jwebmp.plugins.datatable.enumerations;

public enum DataTablePlugins
{
	AutoFill("autoFill", true, true, "bower_components/datatables.net-autofill/js/dataTables.autoFill.min.js"),

	Buttons("buttons", true, true,"bower_components/datatables.net-buttons/js/dataTables.buttons.min.js"),

	ColReorder("colReorder","colreorder", true, true,"bower_components/datatables.net-colreorder/js/dataTables.colReorder.min.js"),
	FixedColumns("fixedColumns","fixedcolumns", true, true,"bower_components/datatables.net-fixedcolumns/js/dataTables.fixedColumns.min.js"),
	FixedHeader("fixedHeader","fixedheader", true, true,"bower_components/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"),
	KeyTable("keyTable","keytable",true,true,"bower_components/datatables.net-keytable/js/dataTables.keyTable.min.js"),
	Responsive("responsive", true, true, "bower_components/datatables.net-responsive/js/dataTables.responsive.min.js"),
	RowGroup("rowGroup","rowgroup",true,true,"bower_components/datatables.net-rowgroup/js/dataTables.rowGroup.min.js"),
	RowReorder("rowReorder","rowreorder",true,true,"bower_components/datatables.net-rowreorder/js/dataTables.rowReorder.min.js"),
	Scroller("scroller",true,true,"bower_components/datatables.net-scroller/js/dataTables.scroller.min.js"),
	Select("select",true,true,"bower_components/datatables.net-select/js/dataTables.select.min.js"),
	Sortable("sortable",false,false,null),
	;

	private String filename;
	private String directoryName;
	private boolean isPlugin;
	private boolean isCss;
	private String pluginRootJSPath;

	DataTablePlugins(String filename)
	{
		this(filename, false);
	}

	DataTablePlugins(String filename, boolean isPlugin)
	{
		this(filename, isPlugin, false);
	}

	DataTablePlugins(String filename, boolean isPlugin, boolean isCss)
	{
		this(filename, isPlugin, isCss, null);
	}

	DataTablePlugins(String filename, boolean isPlugin, boolean isCss, String pluginRootJSPath)
	{
		this(filename,filename,isPlugin,isCss,pluginRootJSPath);
	}
	DataTablePlugins(String filename, String directoryName,boolean isPlugin, boolean isCss, String pluginRootJSPath)
	{
		this.pluginRootJSPath = pluginRootJSPath;
		this.directoryName = directoryName;
		this.filename = filename;
		this.isPlugin = isPlugin;
		this.isCss = isCss;
	}

	public String getFilename()
	{
		return filename;
	}

	public boolean isPlugin()
	{
		return isPlugin;
	}

	public boolean isCss()
	{
		return isCss;
	}

	public String getPluginRootJSPath()
	{
		return pluginRootJSPath;
	}

	public String getDirectoryName()
	{
		return directoryName;
	}
}
