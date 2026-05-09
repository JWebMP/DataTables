package com.jwebmp.plugins.datatable.enumerations;

public enum DataTableButtons
{
	Copy,
	Excel,
	Print,
	Csv,
	Pdf,
	Colvis,
	ColumnsToggle("columnsToggle");

	private String data;

	DataTableButtons()
	{
	}

	DataTableButtons(String data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		if(data == null)
		return name().toLowerCase();
		else return data;
	}
}
