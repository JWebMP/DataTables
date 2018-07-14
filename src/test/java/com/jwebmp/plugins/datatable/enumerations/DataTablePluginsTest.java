/*
 * Copyright (C) 2017 Marc Magon
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

import com.jwebmp.Page;
import com.jwebmp.base.html.TableHeaderGroup;
import com.jwebmp.plugins.datatable.DataTable;
import com.jwebmp.plugins.datatable.DataTablePageConfigurator;
import org.junit.jupiter.api.Test;

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
