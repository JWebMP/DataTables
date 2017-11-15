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

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.TableAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;
import za.co.mmagon.jwebswing.plugins.jqdatatable.options.DataTableColumnOptions;

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
@ComponentInformation(name = "Data Tables",
		description = "The core data tables component",
		url = "https://www.datatables.net/")
public class DataTable<T extends TableRow, J extends DataTable<T, J>> extends Table<J> implements GlobalChildren
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
	public DataTable(TableHeaderGroup headerGroup)
	{
		this(headerGroup, true);
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
	public DataTable(TableHeaderGroup headerGroup, boolean enableDynamicFeature)
	{
		this.enableDynamicFeature = enableDynamicFeature;
		addAttribute(TableAttributes.CellSpacing, 0);
		addAttribute(TableAttributes.CellPadding, 0);
		setHeaderGroup(headerGroup);
	}

	/**
	 * Sets the header group for this table
	 * <p>
	 *
	 * @param headerGroup
	 */
	@SuppressWarnings("unchecked")
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

	@Override
	public DataTableOptions getOptions()
	{
		return getFeature().getOptions();
	}

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
	public TableHeaderGroup getHeaderGroup()
	{
		if (headerGroup == null)
		{
			setHeaderGroup(new TableHeaderGroup());
		}
		return headerGroup;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void init()
	{
		if (!isInitialized() && isEnableDynamicFeature())
		{
			addFeature(getFeature());
			TableHeaderGroup<? extends TableHeaderGroup> group = getHeaderGroup();
			for (ComponentHierarchyBase child : group.getChildren())
			{
				TableRow<? extends TableRow> tr = (TableRow) child;
				for (ComponentHierarchyBase rowChild : tr.getChildren())
				{
					DataTableColumnOptions columnOptions = new DataTableColumnOptions(rowChild.getText(0).toString());
					getOptions().getColumns().add(columnOptions);
				}
			}

		}
		super.init();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof DataTable))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		DataTable<?, ?> dataTable = (DataTable<?, ?>) o;

		if (isEnableDynamicFeature() != dataTable.isEnableDynamicFeature())
		{
			return false;
		}
		if (getHeaderGroup() != null ? !getHeaderGroup().equals(dataTable.getHeaderGroup()) : dataTable.getHeaderGroup() != null)
		{
			return false;
		}
		if (getFooterGroup() != null ? !getFooterGroup().equals(dataTable.getFooterGroup()) : dataTable.getFooterGroup() != null)
		{
			return false;
		}
		if (getBodyGroup() != null ? !getBodyGroup().equals(dataTable.getBodyGroup()) : dataTable.getBodyGroup() != null)
		{
			return false;
		}
		return getCaptionOfTable() != null ? getCaptionOfTable().equals(dataTable.getCaptionOfTable()) : dataTable.getCaptionOfTable() == null;
	}

	/**
	 * If dynamic features are enabled
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean isEnableDynamicFeature()
	{
		return enableDynamicFeature;
	}

	/**
	 * Gets the body group for this data table
	 *
	 * @return
	 */
	public TableBodyGroup getBodyGroup()
	{
		if (bodyGroup == null)
		{
			setBodyGroup(new TableBodyGroup());
		}
		return bodyGroup;
	}

	/**
	 * sets the footer group for this table
	 * <p>
	 *
	 * @param footerGroup
	 */
	@SuppressWarnings("unchecked")
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
	 * Returns the Table Caption associated with this object plus positioning utilities
	 *
	 * @return
	 */
	public TableCaption getCaptionOfTable()
	{
		if (captionOfTable == null)
		{
			setCaptionOfTable(new TableCaption(null));
		}
		return captionOfTable;
	}

	/**
	 * Sets the body group for the table
	 * <p>
	 *
	 * @param bodyGroup
	 */
	@SuppressWarnings("unchecked")
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

	/**
	 * Sets the caption for the table
	 *
	 * @param captionOfTable
	 */
	@SuppressWarnings("unchecked")
	public J setCaptionOfTable(TableCaption captionOfTable)
	{
		this.captionOfTable = captionOfTable;
		return (J) this;
	}

	/**
	 * Sets if the dynamic features of this table must be rendered
	 *
	 * @param enableDynamicFeature
	 *
	 * @return
	 */
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
	public TableFooterGroup getFooterGroup()
	{

		if (footerGroup == null)
		{
			setFooterGroup(new TableFooterGroup());
		}
		return footerGroup;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
