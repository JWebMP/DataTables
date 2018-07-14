package com.jwebmp.plugins.datatable.enumerations;

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
