package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

public enum DataTableSorts
{
	Asc,
	Desc;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
