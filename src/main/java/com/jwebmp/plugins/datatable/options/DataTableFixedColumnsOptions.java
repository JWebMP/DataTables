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

package com.jwebmp.plugins.datatable.options;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.datatable.enumerations.DataTablesFixedColumnsHeightMatch;

import javax.validation.constraints.NotNull;

/**
 * FixedColumns
 * When making use of DataTables' x-axis scrolling feature (scrollX), you may wish to fix the left or right most columns in place. This
 * extension for DataTables provides exactly this option (for non-scrolling tables, please use the FixedHeader extension, which will
 * create sticky headers and footers for tables).
 * <p>
 * Additional complexity
 * It is important to state up front that utilising FixedColumns in your DataTable can significantly increase the complexity of the table
 * and its use should not be undertaken lightly, particularly for complex tables. The reason for this is in how FixedColumns operates -
 * the fixed columns are actually separate tables from the original DataTable (i.e. they are separate table elements) which are styled to
 * look like they are visually part of the original table. These fixed tables are then positioned over the original DataTable.
 * <p>
 * This means that any events attached to the DataTable need to also take into account the fixed tables. Equally, any updates that are
 * made to the original DataTable needs to also update the fixed tables!
 * <p>
 * If you refer to the DataTables compatibility chart you will be able to see that most incompatibilities are between FixedColumns and
 * the other extensions for exactly this reason.
 * <p>
 * This is not to say that FixedColumns is not useful - it absolutely can be. But you need to be aware of the additional complexity that
 * it will introduce into your software.
 *
 * @param <J>
 */
public class DataTableFixedColumnsOptions<J extends DataTableFixedColumnsOptions<J>>
		extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	/**
	 * none - will result in no height matching being applied by FixedColumns (height matching could be forced by CSS in this case)
	 * semiauto - whereby the height calculation will be performed once, and the result cached to be used again
	 * auto - height matching is performed on every draw (slowest but must accurate).
	 */
	private DataTablesFixedColumnsHeightMatch heightMatch;

	/**
	 * fixedColumns.leftColumnsSince: FixedColumns 3.1.0
	 * Number of columns to fix to the left of the table. Please note - this property requires the FixedColumns extension for DataTables.
	 * <p>
	 * Description
	 * FixedColumns, by default, will fix only the left most column in place, however it is also possible to fix two or more columns in
	 * place as required by your application. The number of columns to fix in place is defined by this parameter, which is simply an
	 * integer that indicates how many columns should be fixed
	 */
	private Integer leftColumns;
	/**
	 * fixedColumns.rightColumnsSince: FixedColumns 3.1.0
	 * Number of columns to fix to the right of the table. Please note - this property requires the FixedColumns extension for DataTables.
	 * <p>
	 * Description
	 * FixedColumns can fix columns to both the left and right hand sides of the DataTable. By default only a single left hand column is
	 * fixed in place, but this parameter provides the option to specify how many columns should be fixed on the right. This is a simple
	 * integer that indicates that number of columns
	 */
	private Integer rightColumns;

	/**
	 * FixedColumns
	 * When making use of DataTables' x-axis scrolling feature (scrollX), you may wish to fix the left or right most columns in place.
	 * This extension for DataTables provides exactly this option (for non-scrolling tables, please use the FixedHeader extension, which
	 * will create sticky headers and footers for tables).
	 * <p>
	 * Additional complexity
	 * It is important to state up front that utilising FixedColumns in your DataTable can significantly increase the complexity of the
	 * table and its use should not be undertaken lightly, particularly for complex tables. The reason for this is in how FixedColumns
	 * operates - the fixed columns are actually separate tables from the original DataTable (i.e. they are separate table elements) which
	 * are styled to look like they are visually part of the original table. These fixed tables are then positioned over the original
	 * DataTable.
	 * <p>
	 * This means that any events attached to the DataTable need to also take into account the fixed tables. Equally, any updates that are
	 * made to the original DataTable needs to also update the fixed tables!
	 * <p>
	 * If you refer to the DataTables compatibility chart you will be able to see that most incompatibilities are between FixedColumns and
	 * the other extensions for exactly this reason.
	 * <p>
	 * This is not to say that FixedColumns is not useful - it absolutely can be. But you need to be aware of the additional complexity
	 * that it will introduce into your software.
	 */
	public DataTableFixedColumnsOptions()
	{
		//No config required
	}

	/**
	 * none - will result in no height matching being applied by FixedColumns (height matching could be forced by CSS in this case)
	 * semiauto - whereby the height calculation will be performed once, and the result cached to be used again
	 * auto - height matching is performed on every draw (slowest but must accurate).
	 *
	 * @return
	 */
	public DataTablesFixedColumnsHeightMatch getHeightMatch()
	{
		return heightMatch;
	}

	/**
	 * none - will result in no height matching being applied by FixedColumns (height matching could be forced by CSS in this case)
	 * semiauto - whereby the height calculation will be performed once, and the result cached to be used again
	 * auto - height matching is performed on every draw (slowest but must accurate).
	 *
	 * @param heightMatch
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setHeightMatch(DataTablesFixedColumnsHeightMatch heightMatch)
	{
		this.heightMatch = heightMatch;
		return (J) this;
	}

	/**
	 * fixedColumns.leftColumnsSince: FixedColumns 3.1.0
	 * Number of columns to fix to the left of the table. Please note - this property requires the FixedColumns extension for DataTables.
	 * <p>
	 * Description
	 * FixedColumns, by default, will fix only the left most column in place, however it is also possible to fix two or more columns in
	 * place as required by your application. The number of columns to fix in place is defined by this parameter, which is simply an
	 * integer that indicates how many columns should be fixed
	 *
	 * @return
	 */
	public Integer getLeftColumns()
	{
		return leftColumns;
	}

	/**
	 * fixedColumns.leftColumnsSince: FixedColumns 3.1.0
	 * Number of columns to fix to the left of the table. Please note - this property requires the FixedColumns extension for DataTables.
	 * <p>
	 * Description
	 * FixedColumns, by default, will fix only the left most column in place, however it is also possible to fix two or more columns in
	 * place as required by your application. The number of columns to fix in place is defined by this parameter, which is simply an
	 * integer that indicates how many columns should be fixed
	 *
	 * @param leftColumns
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setLeftColumns(Integer leftColumns)
	{
		this.leftColumns = leftColumns;
		return (J) this;
	}

	/**
	 * fixedColumns.rightColumnsSince: FixedColumns 3.1.0
	 * Number of columns to fix to the right of the table. Please note - this property requires the FixedColumns extension for DataTables.
	 * <p>
	 * Description
	 * FixedColumns can fix columns to both the left and right hand sides of the DataTable. By default only a single left hand column is
	 * fixed in place, but this parameter provides the option to specify how many columns should be fixed on the right. This is a simple
	 * integer that indicates that number of columns
	 *
	 * @return
	 */
	public Integer getRightColumns()
	{
		return rightColumns;
	}

	/**
	 * fixedColumns.rightColumnsSince: FixedColumns 3.1.0
	 * Number of columns to fix to the right of the table. Please note - this property requires the FixedColumns extension for DataTables.
	 * <p>
	 * Description
	 * FixedColumns can fix columns to both the left and right hand sides of the DataTable. By default only a single left hand column is
	 * fixed in place, but this parameter provides the option to specify how many columns should be fixed on the right. This is a simple
	 * integer that indicates that number of columns
	 *
	 * @param rightColumns
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setRightColumns(Integer rightColumns)
	{
		this.rightColumns = rightColumns;
		return (J) this;
	}
}
