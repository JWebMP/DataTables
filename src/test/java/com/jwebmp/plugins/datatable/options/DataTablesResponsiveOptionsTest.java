package com.jwebmp.plugins.datatable.options;

import com.jwebmp.plugins.datatable.options.responsive.DataTablesResponsiveBreakpoint;
import com.jwebmp.plugins.datatable.options.responsive.DataTablesResponsiveDetailTypes;
import com.jwebmp.plugins.datatable.options.responsive.DataTablesResponsiveOptions;
import org.junit.jupiter.api.Test;

public class DataTablesResponsiveOptionsTest

{

	@Test
	void getBreakpoints()
	{
		DataTablesResponsiveOptions<?> dt = new DataTablesResponsiveOptions();
		dt.getBreakpoints()
		  .add(new DataTablesResponsiveBreakpoint<>().setName("name")
		                                             .setWidth(1000));
		dt.getDetails()
		  .setType(DataTablesResponsiveDetailTypes.Inline);

		System.out.println(dt);

	}
}
