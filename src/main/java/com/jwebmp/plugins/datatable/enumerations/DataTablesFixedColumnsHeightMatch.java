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
 * none - will result in no height matching being applied by FixedColumns (height matching could be forced by CSS in this case)
 * semiauto - whereby the height calculation will be performed once, and the result cached to be used again
 * auto - height matching is performed on every draw (slowest but must accurate).
 */
public enum DataTablesFixedColumnsHeightMatch
{
	none,
	semiAuto,
	auto

}
