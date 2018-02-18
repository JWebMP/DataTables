package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.TableHeaderGroup;
import za.co.mmagon.jwebswing.plugins.jqdatatable.DataTable;

class DataTablePluginsTest
{

	@Test
	public void testButtonsPlugins()
	{
		Page<?> p = new Page<>();
		DataTable dt = new DataTable("id", new TableHeaderGroup());


		dt.getOptions()
				.getButtons();


		p.getBody()
				.add(dt);
		System.out.println(p.toString(0));

	}
}
