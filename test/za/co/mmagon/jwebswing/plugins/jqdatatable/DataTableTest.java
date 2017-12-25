package za.co.mmagon.jwebswing.plugins.jqdatatable;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.TableHeaderGroup;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTablePlugins;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTableThemes;

public class DataTableTest
{
	@Test
	public void testDataTables()
	{
		TableHeaderGroup thg = new TableHeaderGroup();
		DataTable dt = new DataTable(thg);

		Page p = new Page();
		p.add(dt);
		System.out.println(p.toString(0));
	}

	@Test
	public void testDataTablesResponsive()
	{
		TableHeaderGroup thg = new TableHeaderGroup();
		DataTable dt = new DataTable(thg);

		DataTablePageConfigurator.getPlugins().add(DataTablePlugins.Responsive);

		Page p = new Page();
		p.add(dt);
		System.out.println(p.toString(0));
	}

	@Test
	public void testDataTablesResponsiveBs4()
	{
		TableHeaderGroup thg = new TableHeaderGroup();
		DataTable dt = new DataTable(thg);

		DataTablePageConfigurator.getPlugins().add(DataTablePlugins.Responsive);
		DataTablePageConfigurator.switchTheme(DataTableThemes.Bootstrap4);

		Page p = new Page();
		p.add(dt);
		System.out.println(p.toString(0));
	}

	@Test
	public void testDataTablesResponsiveJQUI()
	{
		TableHeaderGroup thg = new TableHeaderGroup();
		DataTable dt = new DataTable(thg);

		DataTablePageConfigurator.getPlugins().add(DataTablePlugins.Responsive);
		DataTablePageConfigurator.switchTheme(DataTableThemes.JQueryUI);

		Page p = new Page();
		p.add(dt);
		System.out.println(p.toString(0));
	}
}
