package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

public enum DataTableAutoFillFocusType
{
	Click,
	Focus,
	Hover,
	Null;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
