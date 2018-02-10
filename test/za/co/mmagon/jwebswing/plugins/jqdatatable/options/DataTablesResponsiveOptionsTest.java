package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;

class DataTablesResponsiveOptionsTest extends BaseTestClass
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
