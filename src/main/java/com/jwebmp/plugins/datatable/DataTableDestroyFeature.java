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

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.plugins.datatable.options.DataTableOptions;

/**
 * Implements the jQuery DataTable plugin
 * <p>
 *
 * @author MMagon
 * <p>
 * <p>
 * @version 1.0
 * @since 2014 09 30
 */
public class DataTableDestroyFeature
		extends Feature<GlobalFeatures, DataTableOptions<?>, DataTableDestroyFeature>
{
	/**
	 * Construct a new JW Data Table
	 * <p>
	 *
	 * @param component The Table to apply the Data Table features to.
	 */
	public DataTableDestroyFeature(DataTable<?, ?> component)
	{
		super("JWDataTableDestroyFeature");
		setComponent(component);
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
	
	@Override
	public void assignFunctionsToComponent()
	{
		addQuery("if(jw.datatables." + getComponent().asBase()
		                                             .getID() + " !== null) {jw.datatables." + getComponent().asBase()
		                                                                                                     .getID() + ".clear().destroy();" +
		         getComponent().asBase()
		                       .getJQueryID() + "empty();" +
		         //"alert('destroyed datatable');" +
		         "}");
	}
}