package za.co.mmagon.jwebswing.plugins.jqdatatable.search;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

public class DataTableSearchColumnCriteria<J extends DataTableSearchColumnCriteria<J>> extends JavaScriptPart<J>
		implements Comparable<DataTableSearchColumnCriteria<J>>
{
	private static final long serialVersionUID = 1L;

	private Integer columnNumber;

	private String name;
	private Boolean orderable;
	private Boolean searchable;

	private String searchValue;
	private Boolean searchRegex;


	public DataTableSearchColumnCriteria()
	{
		columnNumber = 0;
	}

	public Integer getColumnNumber()
	{
		return columnNumber;
	}

	public void setColumnNumber(Integer columnNumber)
	{
		this.columnNumber = columnNumber;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Boolean getOrderable()
	{
		return orderable;
	}

	public void setOrderable(Boolean orderable)
	{
		this.orderable = orderable;
	}

	public Boolean getSearchable()
	{
		return searchable;
	}

	public void setSearchable(Boolean searchable)
	{
		this.searchable = searchable;
	}

	public String getSearchValue()
	{
		return searchValue;
	}

	public void setSearchValue(String searchValue)
	{
		this.searchValue = searchValue;
	}

	public Boolean getSearchRegex()
	{
		return searchRegex;
	}

	public void setSearchRegex(Boolean searchRegex)
	{
		this.searchRegex = searchRegex;
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
