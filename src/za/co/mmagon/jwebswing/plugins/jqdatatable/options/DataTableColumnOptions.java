package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

public class DataTableColumnOptions<J extends DataTableColumnOptions<J>> extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	private String name;

	public DataTableColumnOptions(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public J setName(String name)
	{
		this.name = name;
		return (J) this;
	}

}
