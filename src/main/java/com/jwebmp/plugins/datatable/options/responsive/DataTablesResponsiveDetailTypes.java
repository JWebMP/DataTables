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

package com.jwebmp.plugins.datatable.options.responsive;

/**
 * inline - Use the first column to display the control element
 * column - Use a whole column to display the control element. Note that if used as a column type and the target option is set to be a
 * column index, the class assigned to that column in the DataTable should be control to allow the CSS to display a visual show / hide
 * control to the end user.
 */
public enum DataTablesResponsiveDetailTypes
{
	/**
	 * inline - Use the first column to display the control element
	 * column - Use a whole column to display the control element. Note that if used as a column type and the target option is set to be a
	 * column index, the class assigned to that column in the DataTable should be control to allow the CSS to display a visual show / hide
	 * control to the end user.
	 */
	Inline,
	/**
	 * inline - Use the first column to display the control element
	 * column - Use a whole column to display the control element. Note that if used as a column type and the target option is set to be a
	 * column index, the class assigned to that column in the DataTable should be control to allow the CSS to display a visual show / hide
	 * control to the end user.
	 */
	Custom;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
