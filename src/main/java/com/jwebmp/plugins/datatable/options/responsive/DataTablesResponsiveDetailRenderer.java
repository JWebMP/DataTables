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

package com.jwebmp.plugins.datatable.options.responsive;

/**
 * responsive.details.rendererSince: Responsive Responsive 1.0.0
 * Define the renderer used to display the child rows. Please note - this property requires the Responsive extension for DataTables.
 * <p>
 * Description
 * The information contained in the details rows that are displayed by Responsive are created through this function. By default it will
 * create a ul / li list showing the data from cells that are hidden, or you can use one of the other built in renderers, or provide your
 * own.
 * <p>
 * The rendering function is executed for details display in a table, and is run whenever the column visibility of the table changes.
 * <p>
 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of DataTables
 * options. This property should be set in the DataTables initialisation object.
 * <p>
 * Since v2.1.0 Responsive has a number of built in rendering functions which can be accessed from the $.fn.dataTable.Responsive.renderer
 * object. The built in renderers are provided as functions that must be executed and will return the required renderer. This provides
 * the ability to pass in options to the renderer.
 * <p>
 * The built in options are:
 * <p>
 * listHidden - Show the data that has been hidden in an ul / li list.
 * No additional options
 * Default renderer
 * tableAll - Show the data for all columns (regardless of if they have been hidden or not) in a table.
 * Single option: tableClass - the class name to apply to the created table.
 */
public enum DataTablesResponsiveDetailRenderer
{
	/**
	 * The built in options are:
	 * <p>
	 * listHidden - Show the data that has been hidden in an ul / li list.
	 * No additional options
	 * Default renderer
	 * tableAll - Show the data for all columns (regardless of if they have been hidden or not) in a table.
	 * Single option: tableClass - the class name to apply to the created table.
	 */
	listHidden,
	/**
	 * The built in options are:
	 * <p>
	 * listHidden - Show the data that has been hidden in an ul / li list.
	 * No additional options
	 * Default renderer
	 * tableAll - Show the data for all columns (regardless of if they have been hidden or not) in a table.
	 * Single option: tableClass - the class name to apply to the created table.
	 */
	tableAll;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
