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

import static com.guicedee.services.jsonrepresentation.json.StaticStrings.CHAR_PLUS;
import static com.guicedee.services.jsonrepresentation.json.StaticStrings.CHAR_UNDERSCORE;

/**
 * select.styleSince: Select 1.0.0
 * Set the selection style for end user interaction with the table. Please note - this property requires the Select extension for
 * DataTables.
 * <p>
 * Description
 * Select provides a number of different built in ways that an end user can interact with the selection of items in the table, which is
 * controlled by this parameter (and select.style() after initialisation).
 * <p>
 * The default mode of operation is based on the selection of files in modern operating systems with the ctrl/cmd and shift keys can be
 * user to provide complex operations.
 * <p>
 * Note that while the api option disables item selection via Select's built in event handler, it is quote possible to use the API to
 * still provide the end user with the ability to select / deselect items based on your own event handlers.
 */
public enum DataTablesSelectStyles
{
    /**
     * - Selection can only be performed via the API
     */
    Api,
    /**
     * Only a single item can be selected, any other selected items will be automatically deselected when a new item is selected
     */
    Single,
    /**
     * Multiple items can be selected. Selection is performed by simply clicking on the items to be selected
     */
    Multi,
    /**
     * Operating System (OS) style selection. This is the most comprehensive option and provides complex behaviours such as ctrl/cmd
     * clicking to select / deselect individual items, shift clicking to select ranges and an unmodified click to select a single item.
     */
    Os,
    /**
     * a hybrid between the os style and multi, allowing easy multi-row selection without immediate de-selection when clicking on a row.
     */
    Multi_Shift;

    @Override
    public String toString()
    {
        return name().toLowerCase()
                     .replace(CHAR_UNDERSCORE, CHAR_PLUS);
    }
}
