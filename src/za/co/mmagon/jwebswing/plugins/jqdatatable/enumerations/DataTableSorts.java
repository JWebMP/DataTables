package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

public enum DataTableSorts
{
	Asc,
	Desc;

	public static DataTableSorts fromValue(String value)
	{
		for (DataTableSorts dataTableSorts : values())
		{
			if (dataTableSorts.toString()
					    .equals(value))
			{ return dataTableSorts; }
		}
		return null;
	}

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
