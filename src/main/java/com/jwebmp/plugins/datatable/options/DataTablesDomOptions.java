package com.jwebmp.plugins.datatable.options;

import java.util.ArrayList;
import java.util.List;

/**
 * The default sections for the data tables
 */
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
	EndDiv('>'),
	;

	private char identifier;

	DataTablesDomOptions(char identifier)
	{
		this.identifier = identifier;
	}

	public static List<DataTablesDomOptions> fromString(String input)
	{
		List<DataTablesDomOptions> returnable = new ArrayList<>();
		char[] chars = input.toCharArray();
		for (char aChar : chars)
		{
			for (DataTablesDomOptions dataTablesDomOptions : DataTablesDomOptions.values())
			{
				if (dataTablesDomOptions.identifier == aChar)
				{
					returnable.add(dataTablesDomOptions);
				}
			}
		}
		return returnable;
	}

	@Override
	public String toString()
	{
		return Character.toString(identifier);
	}
}
