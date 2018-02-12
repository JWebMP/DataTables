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
package za.co.mmagon.jwebswing.plugins.jqdatatable;

import com.google.common.base.Strings;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.TableAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;
import za.co.mmagon.jwebswing.plugins.jqdatatable.events.DataTableDataFetchEvent;
import za.co.mmagon.jwebswing.plugins.jqdatatable.options.DataTableColumnOptions;
import za.co.mmagon.jwebswing.plugins.jqdatatable.options.DataTableOptions;

import javax.validation.constraints.NotNull;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.CHAR_DOT;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.CHAR_UNDERSCORE;

/**
 * The JWDataTable implementation
 *
 * @param <T>
 * 		The table row type this table reflects
 * @param <J>
 *
 * @author MMagon
 * @version 1.0
 * @since 2014 09 30
 */
@ComponentInformation(name = "Data Tables", description = "The core data tables component", url = "https://www.datatables.net/")
public class DataTable<T extends TableRow, J extends DataTable<T, J>> extends Table<J> implements GlobalChildren, IDataTable<T, J>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The associated feature for the data table
	 */
	private DataTableFeature feature;
	/**
	 * The header grouping for a data table
	 */
	private TableHeaderGroup headerGroup;
	/**
	 * The footer grouping for a data table
	 */
	private TableFooterGroup footerGroup;
	/**
	 * The table grouping for a data table
	 */
	private TableBodyGroup bodyGroup;
	/**
	 * The caption item for a table
	 */
	private TableCaption captionOfTable;
	/**
	 * If the dynamic features are enabled on this data table
	 */
	private boolean enableDynamicFeature;

	/**
	 * Construct a new interactive table that is theme compatible, with cell spacing and padding as 0. Sets dynamic feature to disabled
	 * <p>
	 *
	 * @param headerGroup
	 * 		The table header group creating for
	 */
	public DataTable(String id, TableHeaderGroup headerGroup)
	{
		this(id, headerGroup, false);
	}

	/**
	 * Construct a new interactive table that is theme compatible, with cell spacing and padding as 0.
	 * <p>
	 *
	 * @param headerGroup
	 * 		The table header group creating for
	 * @param enableDynamicFeature
	 * 		Enables the DataTable Feature
	 */
	public DataTable(String id, TableHeaderGroup headerGroup, boolean enableDynamicFeature)
	{
		this.enableDynamicFeature = enableDynamicFeature;
		addAttribute(TableAttributes.CellSpacing, 0);
		addAttribute(TableAttributes.CellPadding, 0);
		setHeaderGroup(headerGroup);
		setID(id);
		addFeature(getFeature());
	}

	/**
	 * Returns this class as a trimmed down accessor for ease of use
	 *
	 * @return
	 */
	public IDataTable<T, J> asMe()
	{
		return this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void init()
	{
		if (!isInitialized() && isEnableDynamicFeature())
		{
			TableHeaderGroup<? extends TableHeaderGroup> group = getHeaderGroup();
			for (ComponentHierarchyBase child : group.getChildren())
			{
				TableRow<? extends TableRow> tr = (TableRow) child;
				for (ComponentHierarchyBase rowChild : tr.getChildren())
				{
					DataTableColumnOptions columnOptions = new DataTableColumnOptions(rowChild.getText(0)
							                                                                  .toString());
					getOptions().getColumns()
							.add(columnOptions);
				}
			}
		}
		super.init();
	}

	/**
	 * Configures the data table to use the AJAX data loading
	 *
	 * @param event
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addServerDataSource(Class<? extends DataTableDataFetchEvent> event)
	{
		getOptions().setServerSide(true);
		getOptions().getAjax()
				.setUrl("/jwdatatables?c=" + event.getCanonicalName()
						                             .replace(CHAR_DOT, CHAR_UNDERSCORE));

		TableRow row = (TableRow) getHeaderGroup().getChildren()
				                          .iterator()
				                          .next();

		int headers = row.getChildren()
				              .size();

		for (int i = 0; i < headers; i++)
		{
			ComponentHierarchyBase[] arrs = new ComponentHierarchyBase[headers];
			arrs = (ComponentHierarchyBase[]) row.getChildren()
					                                  .toArray(arrs);
			ComponentHierarchyBase me = arrs[i];
			String text = me.getText(0)
					              .toString();
			if (Strings.isNullOrEmpty(text))
			{
				if (!me.getChildren()
						     .isEmpty())
				{
					me = (ComponentHierarchyBase) me.getChildren()
							                              .iterator()
							                              .next();
					text = me.getText(0)
							       .toString();
				}
			}
			getOptions().getColumns()
					.add(new DataTableColumnOptions<>(text));
		}


		return (J) this;
	}

	/**
	 * If dynamic features are enabled
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean isEnableDynamicFeature()
	{
		return enableDynamicFeature;
	}

	@SuppressWarnings({"unchecked"})
	@NotNull
	public final DataTableFeature getFeature()
	{
		if (feature == null)
		{
			feature = new DataTableFeature(this);
		}
		return feature;
	}

	/**
	 * Gets the header group for this Data Table
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	@NotNull
	public TableHeaderGroup getHeaderGroup()
	{
		if (headerGroup == null)
		{
			setHeaderGroup(new TableHeaderGroup());
		}
		return headerGroup;
	}

	/**
	 * Sets the header group for this table
	 * <p>
	 *
	 * @param headerGroup
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	@NotNull
	public J setHeaderGroup(TableHeaderGroup headerGroup)
	{
		getChildren().remove(this.headerGroup);
		this.headerGroup = headerGroup;
		if (!getChildren().contains(headerGroup))
		{
			add(headerGroup);
		}

		return (J) this;
	}

	/**
	 * Sets if the dynamic features of this table must be rendered
	 *
	 * @param enableDynamicFeature
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	@NotNull
	public J setEnableDynamicFeature(boolean enableDynamicFeature)
	{
		this.enableDynamicFeature = enableDynamicFeature;
		return (J) this;
	}

	/**
	 * Gets the footer group for this data table
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	@NotNull
	public TableFooterGroup getFooterGroup()
	{

		if (footerGroup == null)
		{
			setFooterGroup(new TableFooterGroup());
		}
		return footerGroup;
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	/**
	 * sets the footer group for this table
	 * <p>
	 *
	 * @param footerGroup
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	@NotNull
	public J setFooterGroup(TableFooterGroup footerGroup)
	{
		getChildren().remove(this.footerGroup);
		this.footerGroup = footerGroup;
		if (!getChildren().contains(footerGroup))
		{
			add(footerGroup);
		}
		return (J) this;
	}

	/**
	 * Gets the body group for this data table
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	@NotNull
	public TableBodyGroup getBodyGroup()
	{
		if (bodyGroup == null)
		{
			setBodyGroup(new TableBodyGroup());
		}
		return bodyGroup;
	}

	/**
	 * Returns the Table Caption associated with this object plus positioning utilities
	 *
	 * @return
	 */
	@Override
	public TableCaption getCaptionOfTable()
	{
		if (captionOfTable == null)
		{
			setCaptionOfTable(new TableCaption(null));
		}
		return captionOfTable;
	}

	/**
	 * Sets the caption for the table
	 *
	 * @param captionOfTable
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	@NotNull
	public J setCaptionOfTable(TableCaption captionOfTable)
	{
		this.captionOfTable = captionOfTable;
		return (J) this;
	}

	/**
	 * Sets the body group for the table
	 * <p>
	 *
	 * @param bodyGroup
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	@NotNull
	public J setBodyGroup(TableBodyGroup bodyGroup)
	{
		getChildren().remove(this.bodyGroup);
		this.bodyGroup = bodyGroup;
		if (!getChildren().contains(bodyGroup))
		{
			add(bodyGroup);
		}
		return (J) this;
	}

	@Override
	public DataTableOptions<?> getOptions()
	{
		return getFeature().getOptions();
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
