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

package com.jwebmp.plugins.datatable.enumerations;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.TableHeaderGroup;
import com.jwebmp.plugins.datatable.DataTable;
import com.jwebmp.plugins.datatable.DataTablePageConfigurator;
import org.junit.jupiter.api.Test;

public class DataTablePluginsTest
{

	@Test
	public void testButtonsPlugins()
	{
		Page<?> p = new Page<>();
		DataTable dt = new DataTable("id", new TableHeaderGroup()){};

		dt.getOptions()
		  .getButtons();

		p.getBody()
		 .add(new DivSimple<>().add(dt));


		dt.addCopyButton("btn ")
		  .addCsvButton("btn ")
		  .addExcelButton("btn ")
		  .addPdfButton("btn ")
		  .addPrintButton("btn ");


		System.out.println(p.toString(0));

	}

	@Test
	public void testColReorderPlugins()
	{
		Page<?> p = new Page<>();
		DataTable dt = new DataTable("id", new TableHeaderGroup()){};

		dt.getOptions()
		  .getColReorder();
		
		p.getBody()
		 .add(new DivSimple<>().add(dt));
		System.out.println(p.toString(0));

	}

	@Test
	public void testResponsiveTests()
	{
		Page<?> p = new Page<>();
		DataTable dt = new DataTable("id", new TableHeaderGroup()){};
		p.getBody()
		 .add(new DivSimple<>().add(dt));
		System.out.println(p.toString(0));

	}


	@Test
	public void testFixedHeaderPlugins()
	{
		Page<?> p = new Page<>();
		DataTable dt = new DataTable("id", new TableHeaderGroup()){};

		dt.getOptions()
		  .getFixedHeader();
		
		p.getBody()
		 .add(new DivSimple<>().add(dt));
		System.out.println(p.toString(0));
	}


	@Test
	public void testFixedColumnsPlugins()
	{
		Page<?> p = new Page<>();
		DataTable dt = new DataTable("id", new TableHeaderGroup()){};

		dt.getOptions()
		  .getFixedColumns();
		
		p.getBody()
		 .add(new DivSimple<>().add(dt));
		System.out.println(p.toString(0));
	}

	@Test
	public void testKeyTablePlugins()
	{
		Page<?> p = new Page<>();
		DataTable dt = new DataTable("id", new TableHeaderGroup()){};

		dt.getOptions()
		  .getKeys();
		
		p.getBody()
		 .add(new DivSimple<>().add(dt));
		System.out.println(p.toString(0));
	}

	@Test
	public void testButtonsPluginsJQUI()
	{
		Page<?> p = new Page<>();
		DataTable dt = new DataTable("id", new TableHeaderGroup()){};
		dt.getOptions()
		  .getButtons();
		
		p.getBody()
		 .add(new DivSimple<>().add(dt));
		System.out.println(p.toString(0));

	}
}
