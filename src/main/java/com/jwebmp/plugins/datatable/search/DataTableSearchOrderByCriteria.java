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

package com.jwebmp.plugins.datatable.search;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.datatable.enumerations.DataTableSorts;

import javax.validation.constraints.NotNull;

/**
 * A Search Order By Criteria
 *
 * @param <J>
 */
public class DataTableSearchOrderByCriteria<J extends DataTableSearchOrderByCriteria<J>>
		extends JavaScriptPart<J>
{

	private Integer columnNumber;
	private DataTableSorts dir;

	/**
	 * Creates a new order by criteria with 0 as the number
	 */
	public DataTableSearchOrderByCriteria()
	{
		columnNumber = 0;
	}

	/**
	 * Gets the column number
	 *
	 * @return
	 */
	public Integer getColumnNumber()
	{
		return columnNumber;
	}

	/**
	 * Sets the given column number
	 *
	 * @param columnNumber
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setColumnNumber(Integer columnNumber)
	{
		this.columnNumber = columnNumber;
		return (J) this;
	}

	/**
	 * Gets the directions
	 *
	 * @return
	 */
	public DataTableSorts getDirection()
	{
		return dir;
	}

	/**
	 * Sets the direction
	 *
	 * @param dir
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDirection(DataTableSorts dir)
	{
		this.dir = dir;
		return (J) this;
	}

	@Override
	public int hashCode()
	{
		return columnNumber.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return columnNumber.equals(obj);
	}
}
