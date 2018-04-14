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

package com.jwebmp.plugins.jqdatatable.enumerations;

/**
 * When using KeyTable with Editor to provide an Excel like inline editing experience for the end user, you may wish to control the
 * behaviour of the arrow keys. There are currently two options KeyTable supports:
 * <p>
 * navigation-only - like Excel the current cell will be blurred and the focus moved per the arrow keys.
 * tab-only - more like what might be expected on the web - the arrow keys move the cursor through the text box. Tab can be used to move
 * between cells.
 * The behaviour you might wish to use can be configured through this option. For applications where end users are used to Excel's
 * behaviour you might wish to use the default, while for more general use the tab-only option might be appropriate.
 */
public enum DataTableKeyTableEditorKeys
{
	Naviation_Only,
	Tab_Only;

	@Override
	public String toString()
	{

		return name().toLowerCase();
	}
}
