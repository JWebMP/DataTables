package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

public enum DataTablesDomOptions
{
	LengthChangeControl('l'),
	FilteringIinputControl('f'),
	DataTable('t'),
	InformationSummary('i'),
	PaginationControl('p'),
	ProcessingDisplayElement('r'),
	Buttons('B'),

	Spacer(' '),

	StartDiv('<'),
	EndDiv('>'),;

	private char identifier;

	DataTablesDomOptions(char identifier)
	{
		this.identifier = identifier;
	}

	@Override
	public String toString()
	{
		return Character.toString(identifier);
	}
}
