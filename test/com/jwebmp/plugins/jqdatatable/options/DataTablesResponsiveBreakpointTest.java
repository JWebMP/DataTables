package com.jwebmp.plugins.jqdatatable.options;

import org.junit.jupiter.api.Test;

class DataTablesResponsiveBreakpointTest

{

	@Test
	void getWidth()
	{
		DataTablesResponsiveBreakpoint dt = new DataTablesResponsiveBreakpoint();
		dt.setName("Namne");
		dt.setWidth(500);
		System.out.println(dt.toString());
	}
}
