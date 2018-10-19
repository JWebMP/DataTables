package com.jwebmp.plugins.datatable.options;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.datatable.options.DataTablesDomDivisionOptions.*;

/**
 * The default sections for the data tables
 */
public enum DataTablesDomOptions
		implements IDataTableDomOptionType<DataTablesDomOptions>
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

	public static List<IDataTableDomOptionType> getDefault()
	{
		List<IDataTableDomOptionType> options = new ArrayList<>();
		options.add(StartDiv);
		options.add(TopRowSectionJustified);
		options.add(FilteringIinputControl);
		options.add(LengthChangeControl);
		options.add(PaginationControl);
		options.add(DataTablesDomOptions.InformationSummary);
		options.add(EndDiv);
		options.add(StartDiv);
		options.add(ClearSection);
		options.add(EndDiv);

		options.add(DataTablesDomOptions.ProcessingDisplayElement);
		options.add(DataTablesDomOptions.DataTable);

		options.add(StartDiv);
		options.add(DataTablesDomDivisionOptions.BottomRowJustifiedSection);
		options.add(DataTablesDomOptions.InformationSummary);
		options.add(EndDiv);

		return options;
	}

	public List<DataTablesDomOptions> fromString(String input)
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
