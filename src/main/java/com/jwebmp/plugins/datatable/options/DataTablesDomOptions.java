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
	
	
	ColReorder('R'),
	Scroller('S'),
	SearchPanes('P'),
	SearchBuilder('Q'),
	
	Spacer(' '),
	
	StartDiv('<'),
	EndDiv('>'),
	
	;
	
	private char identifier;
	
	DataTablesDomOptions(char identifier)
	{
		this.identifier = identifier;
	}
	
	/**
	 * /* Results in:
	 * {length}
	 * {processing}
	 * {table}
	 * {information}
	 * {pagination}
	 *
	 * @return
	 */
	public static List<IDataTableDomOptionType<?>> getNoFilteringInputControls()
	{
		List<IDataTableDomOptionType<?>> options = new ArrayList<>();
		options.add(LengthChangeControl);
		options.add(ProcessingDisplayElement);
		options.add(DataTable);
		options.add(InformationSummary);
		options.add(PaginationControl);
		return options;
	}
	
	public static List<IDataTableDomOptionType<?>> getDefault()
	{
		List<IDataTableDomOptionType<?>> options = new ArrayList<>();
		options.add(StartDiv);
		options.add(TopSection);
		options.add(LengthChangeControl);
		options.add(FilteringIinputControl);
		
		options.add(EndDiv);
		
		options.add(StartDiv);
		options.add(ClearSection);
		options.add(EndDiv);
		
		options.add(ProcessingDisplayElement);
		options.add(DataTable);
		
		options.add(StartDiv);
		options.add(BottomSection);
		options.add(InformationSummary);
		options.add(PaginationControl);
		
		options.add(EndDiv);
		
		return options;
	}
	
	@SuppressWarnings("Duplicates")
	public static List<IDataTableDomOptionType<?>> getDefaultTopAndBottom()
	{
		List<IDataTableDomOptionType<?>> options = new ArrayList<>();
		options.add(StartDiv);
		options.add(TopSection);
		options.add(FilteringIinputControl);
		options.add(LengthChangeControl);
		options.add(EndDiv);
		
		options.add(StartDiv);
		options.add(TopRowSectionJustified);
		options.add(PaginationControl);
		options.add(InformationSummary);
		options.add(EndDiv);
		
		options.add(StartDiv);
		options.add(ClearSection);
		options.add(EndDiv);
		
		options.add(ProcessingDisplayElement);
		options.add(DataTable);
		
		options.add(StartDiv);
		options.add(BottomSection);
		options.add(PaginationControl);
		options.add(InformationSummary);
		options.add(EndDiv);
		
		return options;
	}
	
	@SuppressWarnings("Duplicates")
	public static List<IDataTableDomOptionType<?>> getDefaultTopAndBottomBS()
	{
		List<IDataTableDomOptionType<?>> options = new ArrayList<>();
		options.add(StartDiv);
		options.add(TopRowSection);
		options.add(FilteringIinputControl);
		options.add(LengthChangeControl);
		options.add(EndDiv);
		
		options.add(StartDiv);
		options.add(TopRowSection);
		options.add(PaginationControl);
		options.add(InformationSummary);
		options.add(EndDiv);
		
		options.add(StartDiv);
		options.add(ClearSection);
		options.add(EndDiv);
		
		options.add(ProcessingDisplayElement);
		options.add(DataTable);
		
		options.add(StartDiv);
		options.add(BottomRowSection);
		options.add(PaginationControl);
		options.add(InformationSummary);
		options.add(EndDiv);
		
		return options;
	}
	
	@SuppressWarnings("Duplicates")
	public static List<IDataTableDomOptionType<?>> getDefaultTopAndBottomBSJustified()
	{
		List<IDataTableDomOptionType<?>> options = new ArrayList<>();
		options.add(StartDiv);
		options.add(TopRowSectionJustified);
		options.add(FilteringIinputControl);
		options.add(LengthChangeControl);
		options.add(EndDiv);
		
		options.add(StartDiv);
		options.add(TopRowSectionJustified);
		options.add(PaginationControl);
		options.add(InformationSummary);
		options.add(EndDiv);
		
		options.add(StartDiv);
		options.add(ClearSection);
		options.add(EndDiv);
		
		options.add(ProcessingDisplayElement);
		options.add(DataTable);
		
		options.add(StartDiv);
		options.add(BottomRowJustifiedSection);
		options.add(PaginationControl);
		options.add(InformationSummary);
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
