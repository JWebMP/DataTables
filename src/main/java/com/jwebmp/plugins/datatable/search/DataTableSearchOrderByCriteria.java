package com.jwebmp.plugins.datatable.search;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.datatable.enumerations.DataTableSorts;

import jakarta.validation.constraints.NotNull;

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
