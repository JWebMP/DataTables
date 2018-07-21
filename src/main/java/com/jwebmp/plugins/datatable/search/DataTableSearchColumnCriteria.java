package com.jwebmp.plugins.datatable.search;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * The search criteria returned from a data tables search
 *
 * @param <J>
 */
public class DataTableSearchColumnCriteria<J extends DataTableSearchColumnCriteria<J>>
		extends JavaScriptPart<J>
		implements Comparable<DataTableSearchColumnCriteria<J>>
{
	private static final long serialVersionUID = 1L;

	private Integer columnNumber;
	/**
	 * The name of the column
	 */
	private String name;
	/**
	 * If the column is ordered
	 */
	private Boolean orderable;
	/**
	 * If the column is searchable
	 */
	private Boolean searchable;
	/**
	 * If the search value is altered
	 */
	private String searchValue;
	/**
	 * If the regex is altered
	 */
	private Boolean searchRegex;

	/**
	 * The search columns criteria with a default column number of 0 applied
	 */
	public DataTableSearchColumnCriteria()
	{
		columnNumber = 0;
	}

	/**
	 * Returns the given column number from the set of results
	 *
	 * @return
	 */
	public Integer getColumnNumber()
	{
		return columnNumber;
	}

	/**
	 * Sets the column number these results apply for
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
	 * The the name of the column (if deffined)
	 *
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the column defined
	 *
	 * @param name
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setName(String name)
	{
		this.name = name;
		return (J) this;
	}

	/**
	 * Gets the orderable of the columns defined
	 *
	 * @return
	 */
	public Boolean getOrderable()
	{
		return orderable;
	}

	/**
	 * Sets the columns of the orderable defined
	 *
	 * @param orderable
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setOrderable(Boolean orderable)
	{
		this.orderable = orderable;
		return (J) this;
	}

	/**
	 * Gets if the column is searchable
	 *
	 * @return
	 */
	public Boolean getSearchable()
	{
		return searchable;
	}

	/**
	 * Sets if the column is searchable
	 *
	 * @param searchable
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearchable(Boolean searchable)
	{
		this.searchable = searchable;
		return (J) this;
	}

	/**
	 * Gets the actual search value
	 *
	 * @return
	 */
	public String getSearchValue()
	{
		return searchValue;
	}

	/**
	 * Sets the actual search value
	 *
	 * @param searchValue
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearchValue(String searchValue)
	{
		this.searchValue = searchValue;
		return (J) this;
	}

	/**
	 * Gets the search regular expressions
	 *
	 * @return
	 */
	public Boolean getSearchRegex()
	{
		return searchRegex;
	}

	/**
	 * Sets the given search regular expression
	 *
	 * @param searchRegex
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearchRegex(Boolean searchRegex)
	{
		this.searchRegex = searchRegex;
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

	@Override
	public int compareTo(DataTableSearchColumnCriteria<J> o)
	{
		return columnNumber.compareTo(o.columnNumber);
	}
}
