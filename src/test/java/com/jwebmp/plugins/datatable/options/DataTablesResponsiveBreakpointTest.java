package com.jwebmp.plugins.datatable.options;

import com.jwebmp.plugins.datatable.options.responsive.DataTablesResponsiveBreakpoint;
import org.junit.jupiter.api.Test;

public class DataTablesResponsiveBreakpointTest
{
	@Test
	public void getWidth()
	{
		DataTablesResponsiveBreakpoint dt = new DataTablesResponsiveBreakpoint();
		dt.setName("Namne");
		dt.setWidth(500);
		System.out.println(dt.toString());
	}
}
