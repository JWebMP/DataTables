package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;

class DataTablesScrollerOptionsTest extends BaseTestClass
{

	@Test
	void getDisplayBuffer()
	{
		DataTablesScrollerOptions dt = new DataTablesScrollerOptions();
		dt.setDisplayBuffer(5)
				.setLoadingIndicator(true)
				.setServerWait(200)
				.setRowHeight(50);
		System.out.println(dt);
	}
}
