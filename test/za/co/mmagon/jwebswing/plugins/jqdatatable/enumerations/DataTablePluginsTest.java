package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.TableHeaderGroup;
import za.co.mmagon.jwebswing.plugins.jqdatatable.DataTable;
import za.co.mmagon.jwebswing.plugins.jqdatatable.DataTablePageConfigurator;

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


	@Test
	public void testButtonsPluginsJQUI()
	{
		Page<?> p = new Page<>();
		DataTable dt = new DataTable("id", new TableHeaderGroup());
		DataTablePageConfigurator.getThemes()
				.add(DataTableThemes.JQueryUI);

		dt.getOptions()
				.getButtons();


		p.getBody()
				.add(dt);
		System.out.println(p.toString(0));

	}
}
