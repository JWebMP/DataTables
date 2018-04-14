package com.jwebmp.plugins.jqdatatable.options;

import com.jwebmp.BaseTestClass;
import org.junit.jupiter.api.Test;

class DataTablesResponsiveOptionsTest
		extends BaseTestClass
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
