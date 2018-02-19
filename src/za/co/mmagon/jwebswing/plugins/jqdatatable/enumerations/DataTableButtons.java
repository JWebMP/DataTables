package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

public enum DataTableButtons
{
	Copy,
	Excel,
	Print,
	Csv,
	Pdf;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
