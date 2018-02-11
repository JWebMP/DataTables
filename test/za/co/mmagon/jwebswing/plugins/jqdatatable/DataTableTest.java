package za.co.mmagon.jwebswing.plugins.jqdatatable;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.TableHeaderGroup;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTableThemes;

import static za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTablePlugins.Responsive;
import static za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTableThemes.JQueryUI;

public class DataTableTest
{
	@Test
	public void testDataTables()
	{
		TableHeaderGroup thg = new TableHeaderGroup();
		DataTable dt = new DataTable("id", thg);

		Page p = new Page();
		p.add(dt);
		System.out.println(p.toString(0));
	}

	@Test
	public void testDataTablesResponsive()
	{
		TableHeaderGroup thg = new TableHeaderGroup();
		DataTable dt = new DataTable("id", thg);

		DataTablePageConfigurator.getPlugins()
				.add(Responsive);

		Page p = new Page();
		p.add(dt);
		System.out.println(p.toString(0));
	}

	@Test
	public void testDataTablesResponsiveBs4()
	{
		TableHeaderGroup thg = new TableHeaderGroup();
		DataTable dt = new DataTable("id", thg);

		DataTablePageConfigurator.getPlugins()
				.add(Responsive);
		DataTablePageConfigurator.switchTheme(DataTableThemes.Bootstrap4);

		Page p = new Page();
		p.add(dt);
		System.out.println(p.toString(0));
	}

	@Test
	public void testDataTablesResponsiveJQUI()
	{
		TableHeaderGroup thg = new TableHeaderGroup();
		DataTable dt = new DataTable("id", thg);

		DataTablePageConfigurator.getPlugins()
				.add(Responsive);
		DataTablePageConfigurator.switchTheme(JQueryUI);

		Page p = new Page();
		p.add(dt);
		System.out.println(p.toString(0));
	}
}
