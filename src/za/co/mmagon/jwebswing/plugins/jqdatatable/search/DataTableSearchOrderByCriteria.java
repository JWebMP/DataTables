package za.co.mmagon.jwebswing.plugins.jqdatatable.search;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTableSorts;

public class DataTableSearchOrderByCriteria<J extends DataTableSearchOrderByCriteria<J>> extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	private Integer columnNumber;

	private DataTableSorts dir;


	public DataTableSearchOrderByCriteria()
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

	public DataTableSorts getDir()
	{
		return dir;
	}

	public void setDir(DataTableSorts dir)
	{
		this.dir = dir;
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
