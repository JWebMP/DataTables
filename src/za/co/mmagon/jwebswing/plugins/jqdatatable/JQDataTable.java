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

import za.co.mmagon.jwebswing.base.html.Table;
import za.co.mmagon.jwebswing.base.html.TableBodyGroup;
import za.co.mmagon.jwebswing.base.html.TableCaption;
import za.co.mmagon.jwebswing.base.html.TableFooterGroup;
import za.co.mmagon.jwebswing.base.html.TableHeaderGroup;
import za.co.mmagon.jwebswing.base.html.TableRow;
import za.co.mmagon.jwebswing.base.html.attributes.TableAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;

/**
 * The JWDataTable implementation
 *
 * @param <T> The table row type this table reflects
 * @param <J>
 * @since 2014 09 30
 * @version 1.0
 * @author MMagon
 *
 *
 */
@ComponentInformation(name = "Data Tables",
                      description = "The core data tables component",
                      url = "https://www.datatables.net/")
public class JQDataTable<T extends TableRow, J extends JQDataTable> extends Table<J> implements GlobalChildren
{

    private static final long serialVersionUID = 1L;
    /**
     * The associated feature for the data table
     */
    private JQDataTableFeature feature;
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
     * Construct a new interactive table that is theme compatible, with cell spacing and padding as 0. Sets dynamic feature to disabled
     * <p>
     * @param headerGroup The table header group creating for
     */
    public JQDataTable(TableHeaderGroup headerGroup)
    {
        this(headerGroup, false);
    }

    /**
     * Construct a new interactive table that is theme compatible, with cell spacing and padding as 0.
     * <p>
     * @param headerGroup          The table header group creating for
     * @param enableDynamicFeature Enables the JQDataTable Feature
     */
    public JQDataTable(TableHeaderGroup headerGroup, boolean enableDynamicFeature)
    {
        addAttribute(TableAttributes.CellSpacing, 0);
        addAttribute(TableAttributes.CellPadding, 0);
        this.headerGroup = headerGroup;
        if (enableDynamicFeature)
        {
            addFeature(getFeature());
        }
    }

    @Override
    public JQDataTableOptions getOptions()
    {
        return getFeature().getOptions();
    }

    public final JQDataTableFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQDataTableFeature(this);
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
            headerGroup = new TableHeaderGroup();
        }
        if (!getChildren().contains(headerGroup))
        {
            add(headerGroup);
        }
        return headerGroup;
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
            footerGroup = new TableFooterGroup();
        }
        if (!getChildren().contains(footerGroup))
        {
            add(footerGroup);
        }
        return footerGroup;
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
            bodyGroup = new TableBodyGroup();
        }
        if (!getChildren().contains(bodyGroup))
        {
            add(bodyGroup);
        }
        return bodyGroup;
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
            captionOfTable = new TableCaption(null);
        }
        return captionOfTable;
    }

    /**
     * Sets the header group for this table
     * <p>
     * @param headerGroup
     */
    public void setHeaderGroup(TableHeaderGroup headerGroup)
    {
        this.headerGroup = headerGroup;
    }

    /**
     * sets the footer group for this table
     * <p>
     * @param footerGroup
     */
    public void setFooterGroup(TableFooterGroup footerGroup)
    {
        this.footerGroup = footerGroup;
    }

    /**
     * Sets the body group for the table
     * <p>
     * @param bodyGroup
     */
    public void setBodyGroup(TableBodyGroup bodyGroup)
    {
        this.bodyGroup = bodyGroup;
    }

    /**
     * Sets the caption for the table
     *
     * @param captionOfTable
     */
    public void setCaptionOfTable(TableCaption captionOfTable)
    {
        this.captionOfTable = captionOfTable;
    }

}
