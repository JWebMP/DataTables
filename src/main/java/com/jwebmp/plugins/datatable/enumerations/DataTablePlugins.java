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
	AutoFill("autoFill", true, true),

	Buttons("buttons", true, true),

	ColReorder("colReorder", true, true),
	FixedColumns("fixedColumns", true, true),
	FixedHeader("fixedHeader", true, true),
	KeyTable("keyTable"),
	Responsive("responsive", true, true),
	RowGroup("rowGroup"),
	RowReorder("rowReorder"),
	Scroller("scroller"),
	Select("select"),
	Sortable("sortable"),
	;

	private String filename;
	private boolean isPlugin;
	private boolean isCss;

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

}
