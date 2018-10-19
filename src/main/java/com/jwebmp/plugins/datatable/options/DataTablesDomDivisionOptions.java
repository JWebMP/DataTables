package com.jwebmp.plugins.datatable.options;

/**
 * The default sections for the data tables
 */
public enum DataTablesDomDivisionOptions
		implements IDataTableDomOptionType<DataTablesDomDivisionOptions>
{
	TopSection("\"top\""),
	TopRowSection("\"top row\""),
	TopRowSectionJustified("\"top row d-flex justify-content-between\""),
	ClearSection("\"clear\""),
	BottomSection("\"bottom\""),
	BottomRowSection("\"bottom row\""),
	BottomRowJustifiedSection("\"bottom row d-flex justify-content-between\"");

	private String identifier;

	DataTablesDomDivisionOptions(String identifier)
	{
		this.identifier = identifier;
	}


	@Override
	public String toString()
	{
		return identifier;
	}
}
