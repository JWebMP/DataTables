package za.co.mmagon.jwebswing.plugins.jqdatatable;

import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.plugins.jqdatatable.events.DataTableDataFetchEvent;
import za.co.mmagon.jwebswing.plugins.jqdatatable.options.DataTableOptions;

import javax.validation.constraints.NotNull;

public interface IDataTable<T extends TableRow, J extends DataTable<T, J>>
{
	/**
	 * Configures the data table to use the AJAX data loading
	 *
	 * @param event
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J addServerDataSource(Class<? extends DataTableDataFetchEvent> event);

	/**
	 * If dynamic features are enabled
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	boolean isEnableDynamicFeature();

	/**
	 * Gets the header group for this Data Table
	 *
	 * @return
	 */
	@SuppressWarnings({"unchecked"})
	@NotNull
	TableHeaderGroup getHeaderGroup();

	/**
	 * Sets the header group for this table
	 * <p>
	 *
	 * @param headerGroup
	 */
	@SuppressWarnings({"unchecked"})
	@NotNull
	J setHeaderGroup(TableHeaderGroup headerGroup);

	/**
	 * Returns all the options with this class
	 *
	 * @return
	 */
	@NotNull
	DataTableOptions getOptions();

	/**
	 * Sets if the dynamic features of this table must be rendered
	 *
	 * @param enableDynamicFeature
	 *
	 * @return
	 */
	@SuppressWarnings({"unchecked"})
	@NotNull
	J setEnableDynamicFeature(boolean enableDynamicFeature);

	/**
	 * Gets the footer group for this data table
	 *
	 * @return
	 */
	@SuppressWarnings({"unchecked"})
	@NotNull
	TableFooterGroup getFooterGroup();

	/**
	 * sets the footer group for this table
	 * <p>
	 *
	 * @param footerGroup
	 */
	@SuppressWarnings({"unchecked"})
	@NotNull
	J setFooterGroup(TableFooterGroup footerGroup);

	/**
	 * Gets the body group for this data table
	 *
	 * @return
	 */
	@SuppressWarnings({"unchecked"})
	@NotNull
	TableBodyGroup getBodyGroup();

	/**
	 * Returns the Table Caption associated with this object plus positioning utilities
	 *
	 * @return
	 */
	TableCaption getCaptionOfTable();

	/**
	 * Sets the body group for the table
	 * <p>
	 *
	 * @param bodyGroup
	 */
	@SuppressWarnings({"unchecked"})
	@NotNull
	J setBodyGroup(TableBodyGroup bodyGroup);

	/**
	 * Sets the caption for the table
	 *
	 * @param captionOfTable
	 */
	@SuppressWarnings({"unchecked"})
	@NotNull
	J setCaptionOfTable(TableCaption captionOfTable);
}
