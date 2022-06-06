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

/**
 * pagingTypeSince: DataTables 1.10
 * Pagination button display options.
 * <p>
 * Description
 * The pagination option of DataTables will display a pagination control below the table (by default, its position can be changed using
 * dom and CSS) with buttons that the end user can use to navigate the pages of the table. Which buttons are shown in the pagination
 * control are defined by the option given here.
 * <p>
 * DataTables has six built-in paging button arrangements:
 * <p>
 * numbers - Page number buttons only (1.10.8)
 * simple - 'Previous' and 'Next' buttons only
 * simple_numbers - 'Previous' and 'Next' buttons, plus page numbers
 * full - 'First', 'Previous', 'Next' and 'Last' buttons
 * full_numbers - 'First', 'Previous', 'Next' and 'Last' buttons, plus page numbers
 * first_last_numbers - 'First' and 'Last' buttons, plus page numbers
 * Further methods can be added using plug-ins.
 * <p>
 * Type
 * This option can be given in the following type(s):
 * <p>
 * string
 */
public enum DataTablesPagingTypes
{
	/**
	 * Page number buttons only (1.10.8)
	 */
	numbers,
	/**
	 * 'Previous' and 'Next' buttons only
	 */
	simple,
	/**
	 * 'Previous' and 'Next' buttons, plus page numbers
	 */
	simple_numbers,
	/**
	 * 'First', 'Previous', 'Next' and 'Last' buttons
	 */
	full,
	/**
	 * 'First', 'Previous', 'Next' and 'Last' buttons, plus page numbers
	 */
	full_numbers,
	/**
	 * 'First' and 'Last' buttons, plus page numbers
	 */
	first_last_numbers;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
