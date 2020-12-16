package com.jwebmp.plugins.datatable.options;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.TableHeader;
import com.jwebmp.core.base.html.TableHeaderGroup;
import com.jwebmp.core.base.html.TableRow;
import com.jwebmp.plugins.datatable.DataTable;
import com.jwebmp.plugins.datatable.DataTablePageConfigurator;
import com.jwebmp.plugins.datatable.enumerations.DataTablePlugins;
import com.jwebmp.plugins.datatable.enumerations.DataTableThemes;
import org.junit.jupiter.api.Test;

public class DataTablesButtonsTest
{
	@Test
	public void testDatatablesButtons()
	{
		DataTable table = new DataTable("newDT", new TableHeaderGroup<>().add(new TableRow<>().add(new TableHeader("Test Header"))));
		DataTablePageConfigurator.switchTheme(DataTableThemes.Bootstrap4);



		DataTablePageConfigurator.getPlugins()
		                         .add(DataTablePlugins.Buttons);

		Page<?> page = new Page<>();
		page.getBody()
		    .add(new DivSimple<>().add(table));
		System.out.println(page.toString(0));

	}
}
