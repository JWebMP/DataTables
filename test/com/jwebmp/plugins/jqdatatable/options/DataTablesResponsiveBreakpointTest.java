package com.jwebmp.plugins.jqdatatable.options;

import com.jwebmp.BaseTestClass;
import org.junit.jupiter.api.Test;

class DataTablesResponsiveBreakpointTest
		extends BaseTestClass
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
