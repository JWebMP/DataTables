package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import org.junit.jupiter.api.Test;

import java.util.List;

class DataTablesDomOptionsTest
{

	@Test
	void fromString()
	{
		List<DataTablesDomOptions> rets = DataTablesDomOptions.fromString("Bfrtip");
		System.out.println(rets);
	}
}
