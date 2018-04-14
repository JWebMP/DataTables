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

package com.jwebmp.plugins.jqdatatable.enumerations;

/**
 * Description
 * Select has the ability to select rows, columns or cells in a DataTable. As well as being able to select each table element type you
 * can also combine the selection to have multiple different item types selected at the same time.
 * <p>
 * This option provides the ability to define which table item type will be selected by user interaction with a mouse. The items to be
 * selected can also be defined at run time using the select.items() method.
 * <p>
 * Type
 * string
 * Description:
 * This option can take one of the following values:
 * <p>
 * row - select rows
 * column - select columns
 * cell - select cells
 */
public enum DataTablesSelectItems
{
	/**
	 * Description:
	 * This option can take one of the following values:
	 * <p>
	 * row - select rows
	 * column - select columns
	 * cell - select cells
	 */
	Row,
	/**
	 * Description:
	 * This option can take one of the following values:
	 * <p>
	 * row - select rows
	 * column - select columns
	 * cell - select cells
	 */
	Cell,
	/**
	 * Description:
	 * This option can take one of the following values:
	 * <p>
	 * row - select rows
	 * column - select columns
	 * cell - select cells
	 */
	Column;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
