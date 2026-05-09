package com.jwebmp.plugins.datatable;

import com.jwebmp.core.base.html.*;
import com.jwebmp.plugins.datatable.options.*;
import jakarta.validation.constraints.*;

public interface IDataTable<T extends TableRow<?>, J extends IDataTable<T, J>>
{
	/**
	 * Gets the header group for this Data Table
	 *
	 * @return
	 */
	@NotNull
	TableHeaderGroup<?> getHeaderGroup();

	/**
	 * Sets the header group for this table
	 * <p>
	 *
	 * @param headerGroup
	 */
	@NotNull
	J setHeaderGroup(TableHeaderGroup<?> headerGroup);
	
	TableRow<?> addDataRow();
	
	TableRow<?> addDataRow(String innerLoopVariableName);
	
	/**
	 * Returns all the options with this class
	 *
	 * @return
	 */
	@NotNull
	DataTableOptions<?> getOptions();
	
	/**
	 * Gets the footer group for this data table
	 *
	 * @return
	 */
	
	@NotNull
	TableFooterGroup<?> getFooterGroup();

	/**
	 * sets the footer group for this table
	 * <p>
	 *
	 * @param footerGroup
	 */
	
	@NotNull
	J setFooterGroup(TableFooterGroup<?> footerGroup);

	/**
	 * Gets the body group for this data table
	 *
	 * @return
	 */
	
	@NotNull
	TableBodyGroup<?> getBodyGroup();

	/**
	 * Returns the Table Caption associated with this object plus positioning utilities
	 *
	 * @return
	 */
	TableCaption<?> getCaptionOfTable();

	/**
	 * Sets the body group for the table
	 * <p>
	 *
	 * @param bodyGroup
	 */
	
	@NotNull
	J setBodyGroup(TableBodyGroup<?> bodyGroup);

	/**
	 * Sets the caption for the table
	 *
	 * @param captionOfTable
	 */
	
	@NotNull
	J setCaptionOfTable(TableCaption<?> captionOfTable);
}
