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
package com.jwebmp.plugins.datatable;

import com.jwebmp.Component;
import com.jwebmp.Feature;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.plugins.datatable.options.DataTableOptions;

import static com.jwebmp.utilities.StaticStrings.*;

/**
 * Implements the jQuery DataTable plugin
 * <p>
 *
 * @author MMagon
 * 		<p>
 * 		<p>
 * @version 1.0
 * @since 2014 09 30
 */
public class DataTableFeature
		extends Feature<DataTableOptions, DataTableFeature>
		implements GlobalFeatures
{

	private static final long serialVersionUID = 1L;
	private static final String DataTableOpeningString = "DataTable(";
	private DataTableOptions options;

	/**
	 * Construct a new JW Data Table
	 * <p>
	 *
	 * @param component
	 * 		The Table to apply the Data Table features to.
	 */
	public DataTableFeature(Component component)
	{
		super("JWDataFeature");
		setComponent(component);
		component.addVariable(getDTID());
	}

	public String getDTID()
	{
		return "dt_" + getComponent().getID();
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
	public DataTableOptions getOptions()
	{
		if (options == null)
		{
			options = new DataTableOptions();
		}
		return options;
	}

	@Override
	public void assignFunctionsToComponent()
	{
		addQuery(getComponent().getJQueryID() + DataTableOpeningString + getOptions() + STRING_CLOSING_BRACKET_SEMICOLON + getNewLine());

		StringBuilder sb = new StringBuilder();
		sb.append("if (typeof " + getDTID() + " === \"undefined\")" + getNewLine());
		sb.append("{" + getNewLine());
		sb.append(getDTID() + " = " + getComponent().getJQueryID() + DataTableOpeningString + getOptions() + STRING_CLOSING_BRACKET_SEMICOLON + getNewLine());
		sb.append("}" + getNewLine());
		sb.append("else" + getNewLine());
		sb.append("{" + getNewLine());
		sb.append(getComponent().getJQueryID() + DataTableOpeningString + getOptions() + STRING_CLOSING_BRACKET_SEMICOLON + getNewLine());
		sb.append(getDTID() + " = " + getComponent().getJQueryID() + DataTableOpeningString + getOptions() + STRING_CLOSING_BRACKET_SEMICOLON + getNewLine());
		sb.append("}" + getNewLine());

		addQuery(sb.toString());
	}
}
