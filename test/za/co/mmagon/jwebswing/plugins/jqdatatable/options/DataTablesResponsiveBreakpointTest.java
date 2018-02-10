package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;

class DataTablesResponsiveBreakpointTest extends BaseTestClass
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
