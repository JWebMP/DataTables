package com.jwebmp.plugins.jqdatatable.enumerations;

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
