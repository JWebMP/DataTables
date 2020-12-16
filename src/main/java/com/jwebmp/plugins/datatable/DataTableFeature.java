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
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.datatable.options.DataTableOptions;

import static com.guicedee.guicedinjection.json.StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON;

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
public class DataTableFeature
		extends Feature<GlobalFeatures, DataTableOptions<?>, DataTableFeature>
{
	
	
	private static final String DataTableOpeningString = "DataTable(";
	private DataTableOptions<?> options;
	
	/**
	 * Construct a new JW Data Table
	 * <p>
	 *
	 * @param component The Table to apply the Data Table features to.
	 */
	public DataTableFeature(IComponentHierarchyBase<?, ?> component)
	{
		super("JWDataFeature");
		setComponent(component);
		component.asFeatureBase().addVariable(getDTID());
	}
	
	public String getDTID()
	{
		return "dt_" + getComponent().asBase()
		                             .getID();
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
	public DataTableOptions<?> getOptions()
	{
		if (options == null)
		{
			options = new DataTableOptions<>();
		}
		return options;
	}
	
	@Override
	public void assignFunctionsToComponent()
	{
		addQuery(getComponent().asBase()
		                       .getJQueryID() + DataTableFeature.DataTableOpeningString +
				         getOptions() + STRING_CLOSING_BRACKET_SEMICOLON + getNewLine());
	}
}
