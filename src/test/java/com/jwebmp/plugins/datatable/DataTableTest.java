/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.plugins.datatable;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.TableHeaderGroup;
import com.jwebmp.plugins.datatable.enumerations.DataTableThemes;
import org.junit.jupiter.api.Test;

import static com.jwebmp.plugins.datatable.enumerations.DataTablePlugins.*;
import static com.jwebmp.plugins.datatable.enumerations.DataTableThemes.*;

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
