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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTableThemes;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTablesPagingTypes;
import za.co.mmagon.jwebswing.plugins.jqdatatable.options.*;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * The Options for the Data Table
 * <p>
 *
 * @author GedMarc
 * @since 09 May 2015
 */
public class DataTableOptions<J extends DataTableOptions<J>> extends JavaScriptPart<J>
{

	private static final long serialVersionUID = 1L;

	/**
	 * the document object model layout
	 */
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	private EnumSet<DataTablesDomOptions> dom;

	/**
	 * ajaxSince: DataTables 1.10
	 * Load data for the table's content from an Ajax source.
	 * <p>
	 * Description
	 * DataTables can obtain the data that it is to display in the table body from a number of sources, including from an Ajax data
	 * source, using this initialisation parameter. As with other dynamic data sources, arrays or objects can be used for the data source
	 * for each row, with columns.data employed to read from specific object properties.
	 * <p>
	 * The ajax property has three different modes of operation, depending on how it is defined. These are:
	 * <p>
	 * string - Set the URL from where the data should be loaded from.
	 * object - Define properties for jQuery.ajax.
	 * function - Custom data get function
	 */
	private DataTablesAjaxOptions<?> ajax;

	/**
	 * Data to use as the display data for the table.
	 */
	private String data;
	/**
	 * Feature control DataTables' smart column width handling
	 */
	private Boolean autoWidth;
	/**
	 * Feature control deferred rendering for additional speed of initialization.
	 */
	private Boolean deferRender;
	/**
	 * Feature control table information display field
	 */
	private Boolean info;
	/**
	 * Use markup and classes for the table to be themed by jQuery UI ThemeRoller.
	 * <p>
	 * In addition to the above control options, there are two constants DataTables understands (note that these two options are
	 * deprecated in 1.10 and will be removed in 1.11 along side the separation of the jQueryUI option into its own theme file):
	 */
	private Boolean jQueryUI;
	/**
	 * Feature control the end user's ability to change the paging display length of the table.
	 */
	private Boolean lengthChange;
	/**
	 * Description
	 * This parameter allows you to readily specify the entries in the length drop down select list that DataTables shows when pagination
	 * is enabled. It can be either:
	 * <p>
	 * 1D array of integer values which will be used for both the displayed option and the value to use for the display length, or
	 * <p>
	 * 2D array which will use the first inner array as the page length values and the second inner array as the displayed options. This
	 * is useful for language strings such as 'All').
	 * <p>
	 * The page length values must always be integer values&gt;0, with the sole exception of -1. When -1 is used as a value this tells
	 * DataTables to disable pagination (i.e. display all rows).
	 * <p>
	 * Note that the pageLength property will be automatically set to the first value given in this array, unless pageLength is also
	 * provided.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 * Default
	 * [ 10, 25, 50, 100 ]
	 */
	private Set<Integer> lengthMenu;
	/**
	 * Description
	 * Allows control over whether DataTables should use the top (true) unique cell that is found for a single column, or the bottom
	 * (false - default) to attach the default order listener. This is useful when using complex headers.
	 */
	private Boolean orderCellsTop;

	/**
	 * Description
	 * DataTables highlight the columns which are used to order the content in the table's body by adding a class to the cells in that
	 * column, which in turn has CSS applied to those classes to highlight those cells.
	 * <p>
	 * This is done by the addition of the classes sorting_1, sorting_2 and sorting_3 to the columns which are currently being ordered on.
	 * The integer value indicates the level of sorting when mutli-column sorting. If more than 3 columns are being ordered upon, the
	 * sorting_3 class is repeated.
	 * <p>
	 * Please note that this feature can affect performance, particularly in old browsers and when there are a lot of rows to be displayed
	 * as it is manipulating a large number of DOM elements. As such, this option is available as a feature switch to allow this feature
	 * to be disabled with working with old browsers or large data sets.
	 */
	private Boolean orderClasses;

	/**
	 * orderFixedSince: DataTables 1.10
	 * Ordering to always be applied to the table.
	 * <p>
	 * Description
	 * The option works in tandem with the order option which provides an initial ordering state for the table which can then be modified
	 * by the user clicking on column headings, while the ordering specified by this option will always be applied to the table,
	 * regardless of user interaction.
	 * <p>
	 * This fixed ordering can be applied before (pre) or after (post) the user's own ordering criteria using the two different forms of
	 * this option (array or object) described below.
	 * <p>
	 * The values that are used to describe the ordering conditions for the table are given as two element arrays:
	 * <p>
	 * Column index to order upon
	 * Direction so order to apply (asc for ascending order or desc for descending order).
	 * It is also possible to give a set of nested arrays (i.e. arrays in arrays) to allow multi-column ordering to be assigned.
	 * <p>
	 * This option can be useful if you a column (visible or hidden) which must always be sorted upon first - a priority order or index
	 * column for example, or for grouping similar rows together.
	 */
	private Boolean orderFixed;
	/**
	 * orderMultiSince: DataTables 1.10
	 * Multiple column ordering ability control.
	 * <p>
	 * Description
	 * When ordering is enabled (ordering), by default DataTables allows users to sort multiple columns by shift clicking upon the header
	 * cell for each column. Although this can be quite useful for users, it can also increase the complexity of the order, potentiality
	 * increasing the processing time of ordering the data. Therefore, this option is provided to allow this shift-click multiple column
	 * ability.
	 * <p>
	 * Note that disabling this ability does not impede your ability as a developer to do multiple column ordering using columns
	 * .orderData, order or order(), it just disallows the user from performing their own multi-column order.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * true
	 */
	private Boolean orderMulti;

	/**
	 * Feature control ordering (sorting) abilities in DataTables.
	 */
	private Boolean ordering;
	/**
	 * pageLengthSince: DataTables 1.10
	 * Change the initial page length (number of rows per page).
	 * <p>
	 * Description
	 * Number of rows to display on a single page when using pagination.
	 * <p>
	 * If lengthChange is feature enabled (it is by default) then the end user will be able to override the value set here to a custom
	 * setting using a pop-up menu (see lengthMenu).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * integer
	 * Default
	 * Value: 10
	 */
	private Integer pageLength;
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
	private DataTablesPagingTypes pagingType;

	/**
	 * Enable or disable table pagination.
	 */
	private Boolean paging;
	/**
	 * Feature control the processing indicator.
	 */
	private Boolean processing;
	/**
	 * rendererSince: DataTables 1.10
	 * Display component renderer types.
	 * <p>
	 * Description
	 * DataTables adds some complex components to your HTML page, such as the pagination control. The business logic used to calculate
	 * information should be displayed (what buttons in the case of the pagination buttons) is core to DataTables and generally doesn't
	 * vary how the buttons are actually displayed does based on the styling requirements of the page. For example the pagination buttons
	 * might be displayed as li elements in a ul list, or simply as a collection of a buttons.
	 * <p>
	 * This ability to use different renderers, while maintaining the same core business logic, is fundamental to how DataTables provides
	 * integration options for CSS frameworks such as Bootstrap, Foundation and jQuery UI, customising the HTML it uses to fit the
	 * requirements of each framework.
	 * <p>
	 * This parameter controls which renderers will be used. The value given will be used is such a renderer exists, otherwise the default
	 * renderer will be used. Additional renderers can be added by plug-ins.
	 * <p>
	 * DataTables currently supports two different types of renderers:
	 * <p>
	 * header - header cell renderer
	 * pageButton - pagination buttons
	 * This list will likely expand significantly in future versions of DataTables!
	 * <p>
	 * Types
	 * string
	 * Description:
	 * Attempt to use renderers of this name for all available renderers. If a renderer is not found matching this name for the renderer
	 * type requested, the default renderer will be used.
	 * <p>
	 * object
	 * Description:
	 * Specify specific renderers for the different renderer types. For a list of the available renderer types, please see the
	 * documentation below.
	 * <p>
	 * Examples
	 * Using the Bootstrap plug-in renderer:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * $('#example').dataTable( {
	 * renderer: "bootstrap"
	 * } );
	 */
	private DataTableThemes renderer;
	/**
	 * retrieveSince: DataTables 1.10
	 * Retrieve an existing DataTables instance.
	 * <p>
	 * Description
	 * Retrieve the DataTables object for the given selector. Note that if the table has already been initialised, this parameter will
	 * cause DataTables to simply return the object that has already been set up - it will not take account of any changes you might have
	 * made to the initialisation object passed to DataTables (setting this parameter to true is an acknowledgement that you understand
	 * this!).
	 * <p>
	 * The destroy option can be used to reinitialise a table with different options if required.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: false
	 */
	private Boolean retrieve = true;
	/**
	 * rowIdSince: DataTables 1.10.8
	 * Data property name that DataTables will use to set tr element DOM IDs.
	 * <p>
	 * Description
	 * It can often be useful to have a id attribute on each tr element in a DataTable for row selection and data source identification,
	 * particularly when using events.
	 * <p>
	 * DataTables will attempt to automatically read an id value from the data source for each row using the property defined by this
	 * option. By default it is DT_RowId but can be set to any other name. As with columns.data it can also read from a nested JSON data
	 * source by using Javascript dotted object notation (e.g. DT_RowId: 'image.id').
	 * <p>
	 * If no id value for the row is found, the id property will not be automatically set.
	 * <p>
	 * Any row id values that are given in the data source should match the HTML specification for what values it can take:
	 * <p>
	 * The value must be unique amongst all the IDs in the element's home subtree and must contain at least one character. The value must
	 * not contain any space characters.
	 * <p>
	 * You may also wish to consider the CSS 2.1 specification of an identifier which is more restrictive than HTML5's and will provide
	 * maximum compatibility with jQuery:
	 * <p>
	 * identifiers (including element names, classes, and IDs in selectors) can contain only the characters [a-zA-Z0-9] and ISO 10646
	 * characters U+00A0 and higher, plus the hyphen (-) and the underscore (_); they cannot start with a digit, two hyphens, or a hyphen
	 * followed by a digit. Identifiers can also contain escaped characters and any ISO 10646 character as a numeric code.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 */
	private String rowId;
	/**
	 * scrollCollapseSince: DataTables 1.10
	 * Allow the table to reduce in height when a limited number of rows are shown.
	 * <p>
	 * Description
	 * When vertical (y) scrolling is enabled through the use of the scrollY option, DataTables will force the height of the table's
	 * viewport to the given height at all times (useful for layout). However, this can look odd when filtering data down to a small data
	 * set, and the footer is left "floating" further down. This parameter (when enabled) will cause DataTables to collapse the table's
	 * viewport down when the result set will fit within the given Y height.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 */
	private Boolean scrollCollapse;

	/**
	 * Horizontal scrolling
	 */
	private Boolean scrollX;
	/**
	 * Horizontal scrolling
	 */
	private Integer scrollXNum;
	/**
	 * Vertical scrolling
	 */
	private MeasurementCSSImpl scrollY;

	/**
	 * searchSince: DataTables 1.10
	 * Set an initial filter in DataTables and / or filtering options.
	 * <p>
	 * Description
	 * The search option allows the way DataTables performs filtering to be set during the initialisation, and to set an initial global
	 * filter.
	 * <p>
	 * The options that control how the filtering is performs are:
	 * <p>
	 * search.caseInsensitive - Indicate is case-insensitive sorting should be performed.
	 * search.regex - Treat the search as a regular expression or not
	 * search.smart - Use DataTables' smart filtering or not
	 * Additionally, to set an initial filter:
	 * <p>
	 * search.search - Set an initial global filter.
	 */
	private DataTablesSearchOptions search;

	/**
	 * searchColsSince: DataTables 1.10
	 * Define an initial search for individual columns.
	 * <p>
	 * Description
	 * Basically the same as the search option, but in this case for individual columns, rather than the global filter, this option
	 * defined the filtering to apply to the table during initialisation.
	 * <p>
	 * The array must be of the same size as the number of columns, and each element be an object with the parameters search and
	 * escapeRegex (the latter is optional). 'null' is also accepted and the default will be used.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 */
	private List<DataTablesSearchOptions> searchCols;

	/**
	 * searchDelaySince: DataTables 1.10.3
	 * Set a throttle frequency for searching.
	 * <p>
	 * Description
	 * The built in DataTables global search (by default at the top right of every DataTable)will instantly search the table on every
	 * keypress when in client-side processing mode and reduce the search call frequency automatically to 400mS when in server-side
	 * processing mode. This call frequency (throttling) can be controlled using the searchDelay parameter for both client-side and
	 * server-side processing.
	 * <p>
	 * Being able to control the call frequency has a number of uses:
	 * <p>
	 * Older browsers and slower computers can have their processing load reduced by reducing the search frequency
	 * Fewer table redraws while search can be less distracting for the user
	 * Reduce the load on the server when using server-side processing by making fewer calls
	 * Conversely, you can speed up the search when using server-side processing by reducing the default of 400mS to instant (0).
	 * As with many other parts of DataTables, it is up to yourself how you configure it to suit your needs!
	 * <p>
	 * The value given for searchDelay is in milliseconds (mS).
	 * <p>
	 * Please note that this option effects only the built in global search box that DataTables provides. It does not effect the search()
	 * or column().search() methods at all. If you wish to be able to throttle calls to those API methods use the utility method $.fn
	 * .dataTable.util.throttle().
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 */
	private Integer searchDelay;

	/**
	 * stateDurationSince: DataTables 1.10
	 * Saved state validity duration.
	 * <p>
	 * Description
	 * Duration for which the saved state information is considered valid. After this period has elapsed the state will be returned to the
	 * default.
	 * <p>
	 * This option is also used to indicate to DataTables if localStorage or sessionStorage should be used for storing the table's state.
	 * When set to -1 sessionStorage will be used, while for 0 or greater localStorage will be used.
	 * <p>
	 * The difference between the two storage APIs is that sessionStorage retains data only for the current session (i..e the current
	 * browser window). For more information on these two HTML APIs please refer to the Mozilla Storage documentation.
	 * <p>
	 * Please note that the value is given in seconds. The value 0 is a special value as it indicates that the state can be stored and
	 * retrieved indefinitely with no time limit.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * integer
	 */
	private Integer stateDuration;
	/**
	 * stripeClassesSince: DataTables 1.10
	 * Set the zebra stripe class names for the rows in the table.
	 * <p>
	 * Description
	 * An array of CSS classes that should be applied to displayed rows, in sequence. This array may be of any length, and DataTables will
	 * apply each class sequentially, looping when required.
	 * <p>
	 * Note that by default this option will take the values determined by the $.fn.dataTable.ext.classes.stripe* options (these are odd
	 * and even by default).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 * Example
	 * Use three stripe classes:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * $('#example').dataTable( {
	 * "stripeClasses": [ 'strip1', 'strip2', 'strip3' ]
	 * } );
	 */
	private Set<String> stripeClasses;

	/**
	 * Feature control search (filtering) abilities
	 */
	private Boolean searching;
	/**
	 * Feature control DataTables' server-side processing mode.
	 */
	private Boolean serverSide;
	/**
	 * State saving - restore table state on page reload
	 */
	private Boolean stateSave;
	/**
	 * tabIndexSince: DataTables 1.10
	 * Tab index control for keyboard navigation.
	 * <p>
	 * Description
	 * By default DataTables allows keyboard navigation of the table (sorting, paging, and filtering) by adding a tabindex attribute to
	 * the required elements. This allows the end user to tab through the controls and press the enter key to activate them, allowing the
	 * table controls to be accessible without a mouse.
	 * <p>
	 * The default tabindex is 0, meaning that the tab follows the flow of the document. You can overrule this using this parameter if you
	 * wish. Use a value of -1 to disable built-in keyboard navigation, although this is not recommended for accessibility reasons.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * integer
	 * Default
	 * Value: 0
	 */
	private Integer tabIndex;

	/**
	 * If the data table should be destroyed
	 */
	private Boolean destroy;
	/**
	 * The list of columns
	 */
	@JsonProperty("columnDefs")
	private List<DataTableColumnOptions> columns;


	/**
	 * AUTO FILL STUFF
	 */
	/**
	 * autoFillSince: AutoFill 2.0.0
	 * Enable and configure the AutoFill extension for DataTables. Please note - this property requires the AutoFill extension for
	 * DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to enable and configure AutoFill for DataTables. In its simplest form as the boolean true it will
	 * enable AutoFill with the default configuration options (as defined by $.fn.dataTable.AutoFill.defaults). It can also be used as an
	 * object to provide custom configuration options as described below.
	 * <p>
	 * Please note that as with all other configuration options for AutoFill, this option is an extension to the default set of DataTables
	 * options. This property should be set in the DataTables initialisation object.
	 */
	private DataTableAutoFillOptions autoFill;
	/**
	 * Buttons
	 * A common UI paradigm to use with interactive tables is to present buttons that will trigger some action - that may be to alter the
	 * table's state, modify the data in the table, gather the data from the table or even to activate some external process. Showing such
	 * buttons is an interface that end users are comfortable with, making them feel at home with the table.
	 * <p>
	 * The Buttons library for DataTables provides a framework with common options and API that can be used with DataTables, but is also
	 * very extensible, recognising that you will likely want to use buttons which perform an action unique to your applications.
	 * <p>
	 * Buttons has four sets of plug-ins that are part of the core software - they are not built into the core, but rather than be
	 * included as and when you need them, selecting only the software you require. Other extensions such as Editor and Select also
	 * provide buttons for use with this library, with actions unique to their own behaviours. This ensures a consistent interface for the
	 * interactions performed with your tables.
	 */
	private DataTablesButtonsOptions buttons;

	/**
	 * ColReorder adds the ability for the end user to be able to reorder columns in a DataTable through a click and drag operation. This
	 * can be useful when presenting data in a table, letting the user move columns that they wish to compare next to each other for
	 * easier comparison.
	 * <p>
	 * It is worth noting that the underlying column data structure of the DataTable is modified as part of this process - this is
	 * important if you are interacting with the table using the API.
	 */
	private DataTableColReOrderOptions colReorder;
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
	private DataTableFixedColumnsOptions fixedColumns;
	/**
	 * When displaying tables with a particularly large amount of data shown on each page, it can be useful to have the table's header and
	 * / or footer fixed to the top or bottom of the scrolling window. This lets your users quickly determine what each column refers to
	 * rather than needing to scroll back to the top of the table.
	 * <p>
	 * FixedHeader provides the ability to perform this action with DataTables tables. It operates by detaching the header and footer
	 * elements from the host table and attaching them to the top or bottom of the screen as required by the scrolling position of the
	 * window. This ensures that FixedColumns is fully compatible with DataTables and you can add complex interactions such as search
	 * elements in the table footer, just as you would with any other table.
	 * <p>
	 * Please note that FixedHeader is not currently compatible with tables that have the scrolling features of DataTables enabled
	 * (scrollX / scrollY). Please refer to the compatibility table for full compatibility details.
	 */
	private DataTableFixedHeaderOptions fixedHeader;

	/**
	 * The list of data table options
	 */
	public DataTableOptions()
	{
		//Nothing Needed
	}


	/**
	 * autoWidthSince: DataTables 1.10
	 * Feature control DataTables' smart column width handling.
	 * <p>
	 * Description
	 * Enable or disable automatic column width calculation. This can be disabled as an optimisation (it takes a finite amount of time to
	 * calculate the widths) if the tables widths are passed in using columns.width.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 *
	 * @return
	 */
	public Boolean getAutoWidth()
	{
		return autoWidth;
	}

	/**
	 * autoWidthSince: DataTables 1.10
	 * Feature control DataTables' smart column width handling.
	 * <p>
	 * Description
	 * Enable or disable automatic column width calculation. This can be disabled as an optimisation (it takes a finite amount of time to
	 * calculate the widths) if the tables widths are passed in using columns.width.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 *
	 * @param autoWidth
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setAutoWidth(Boolean autoWidth)
	{
		this.autoWidth = autoWidth;
		return (J) this;
	}

	/**
	 * deferLoadingSince: DataTables 1.10
	 * Delay the loading of server-side data until second draw.
	 * <p>
	 * Description
	 * When using server-side processing, the default mode of operation for DataTables is to simply throw away any data that currently
	 * exists in the table and make a request to the server to get the first page of data to display. This is fine for an empty table, but
	 * if you already have the first page of data displayed in the plain HTML, it is a waste of resources. As such, this option exists to
	 * allow you to instruct DataTables to not make that initial request, rather it will use the data already on the page (no sorting etc
	 * will be applied to it).
	 * <p>
	 * deferLoading is used to indicate that deferred loading is required, but it is also used to tell DataTables how many records there
	 * are in the full table (allowing the information element and pagination to be displayed correctly). In the case where a filtering is
	 * applied to the table on initial load, this can be indicated by giving the parameter as an array, where the first element is the
	 * number of records available after filtering and the second element is the number of records without filtering (allowing the table
	 * information element to be shown correctly).
	 * <p>
	 * Note that this option only has effect when serverSide is enabled. It does not have any effect when using client-side processing.
	 *
	 * @return
	 */
	public Boolean getDeferRender()
	{
		return deferRender;
	}

	/**
	 * deferLoadingSince: DataTables 1.10
	 * Delay the loading of server-side data until second draw.
	 * <p>
	 * Description
	 * When using server-side processing, the default mode of operation for DataTables is to simply throw away any data that currently
	 * exists in the table and make a request to the server to get the first page of data to display. This is fine for an empty table, but
	 * if you already have the first page of data displayed in the plain HTML, it is a waste of resources. As such, this option exists to
	 * allow you to instruct DataTables to not make that initial request, rather it will use the data already on the page (no sorting etc
	 * will be applied to it).
	 * <p>
	 * deferLoading is used to indicate that deferred loading is required, but it is also used to tell DataTables how many records there
	 * are in the full table (allowing the information element and pagination to be displayed correctly). In the case where a filtering is
	 * applied to the table on initial load, this can be indicated by giving the parameter as an array, where the first element is the
	 * number of records available after filtering and the second element is the number of records without filtering (allowing the table
	 * information element to be shown correctly).
	 * <p>
	 * Note that this option only has effect when serverSide is enabled. It does not have any effect when using client-side processing.
	 *
	 * @param deferRender
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDeferRender(Boolean deferRender)
	{
		this.deferRender = deferRender;
		return (J) this;
	}

	/**
	 * nfoSince: DataTables 1.10
	 * Feature control table information display field.
	 * <p>
	 * Description
	 * When this option is enabled, Datatables will show information about the table including information about filtered data if that
	 * action is being performed. This option allows that feature to be enabled or disabled.
	 * <p>
	 * Note that by default the information display is shown below the table on the left, but this can be controlled using dom and CSS).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: true
	 *
	 * @return
	 */
	public Boolean getInfo()
	{
		return info;
	}

	/**
	 * nfoSince: DataTables 1.10
	 * Feature control table information display field.
	 * <p>
	 * Description
	 * When this option is enabled, Datatables will show information about the table including information about filtered data if that
	 * action is being performed. This option allows that feature to be enabled or disabled.
	 * <p>
	 * Note that by default the information display is shown below the table on the left, but this can be controlled using dom and CSS).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: true
	 *
	 * @param info
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setInfo(Boolean info)
	{
		this.info = info;
		return (J) this;
	}

	/**
	 * Enables JQuery UI Theming within the data table
	 * <p>
	 * In addition to the above control options, there are two constants DataTables understands (note that these two options are
	 * deprecated in 1.10 and will be removed in 1.11 along side the separation of the jQueryUI option into its own theme file):
	 *
	 * @return
	 */
	public Boolean getjQueryUI()
	{
		return jQueryUI;
	}

	/**
	 * Enables JQuery UI Theming within the data table
	 * <p>
	 * In addition to the above control options, there are two constants DataTables understands (note that these two options are
	 * deprecated in 1.10 and will be removed in 1.11 along side the separation of the jQueryUI option into its own theme file):
	 *
	 * @param jQueryUI
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setjQueryUI(Boolean jQueryUI)
	{
		this.jQueryUI = jQueryUI;
		return (J) this;
	}

	/**
	 * lengthChangeSince: DataTables 1.10
	 * Feature control the end user's ability to change the paging display length of the table.
	 * <p>
	 * Description
	 * When pagination is enabled, this option will control the display of an option for the end user to change number of records to be
	 * shown per page. The options shown in the list are controlled by the lengthMenu configuration option.
	 * <p>
	 * Note that by default the control is shown at the top left of the table. That can be controlled using dom and CSS.
	 * <p>
	 * If this option is disabled (false) the length change input control is removed - although the page.len() method can still be used if
	 * you wish to programmatically change the page size and pageLength can be used to specify the initial page length. Paging itself is
	 * not effected.
	 * <p>
	 * Additionally, if pagination is disabled using the paging option, this option is automatically disabled since it has no relevance
	 * when the is no pagination.
	 *
	 * @return
	 */
	public Boolean getLengthChange()
	{
		return lengthChange;
	}

	/**
	 * lengthChangeSince: DataTables 1.10
	 * Feature control the end user's ability to change the paging display length of the table.
	 * <p>
	 * Description
	 * When pagination is enabled, this option will control the display of an option for the end user to change number of records to be
	 * shown per page. The options shown in the list are controlled by the lengthMenu configuration option.
	 * <p>
	 * Note that by default the control is shown at the top left of the table. That can be controlled using dom and CSS.
	 * <p>
	 * If this option is disabled (false) the length change input control is removed - although the page.len() method can still be used if
	 * you wish to programmatically change the page size and pageLength can be used to specify the initial page length. Paging itself is
	 * not effected.
	 * <p>
	 * Additionally, if pagination is disabled using the paging option, this option is automatically disabled since it has no relevance
	 * when the is no pagination.
	 *
	 * @param lengthChange
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setLengthChange(Boolean lengthChange)
	{
		this.lengthChange = lengthChange;
		return (J) this;
	}

	/**
	 * Description
	 * This parameter allows you to readily specify the entries in the length drop down select list that DataTables shows when pagination
	 * is enabled. It can be either:
	 * <p>
	 * 1D array of integer values which will be used for both the displayed option and the value to use for the display length, or
	 * <p>
	 * 2D array which will use the first inner array as the page length values and the second inner array as the displayed options. This
	 * is useful for language strings such as 'All').
	 * <p>
	 * The page length values must always be integer values&gt;0, with the sole exception of -1. When -1 is used as a value this tells
	 * DataTables to disable pagination (i.e. display all rows).
	 * <p>
	 * Note that the pageLength property will be automatically set to the first value given in this array, unless pageLength is also
	 * provided.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 * Default
	 * [ 10, 25, 50, 100 ]
	 *
	 * @return
	 */
	public Set<Integer> getLengthMenu()
	{
		return lengthMenu;
	}

	/**
	 * Description
	 * This parameter allows you to readily specify the entries in the length drop down select list that DataTables shows when pagination
	 * is enabled. It can be either:
	 * <p>
	 * 1D array of integer values which will be used for both the displayed option and the value to use for the display length, or
	 * <p>
	 * 2D array which will use the first inner array as the page length values and the second inner array as the displayed options. This
	 * is useful for language strings such as 'All').
	 * <p>
	 * The page length values must always be integer values&gt;0, with the sole exception of -1. When -1 is used as a value this tells
	 * DataTables to disable pagination (i.e. display all rows).
	 * <p>
	 * Note that the pageLength property will be automatically set to the first value given in this array, unless pageLength is also
	 * provided.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 * Default
	 * [ 10, 25, 50, 100 ]
	 *
	 * @param lengthMenu
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setLengthMenu(Set<Integer> lengthMenu)
	{
		if (lengthMenu == null)
		{
			lengthMenu = new LinkedHashSet<>();
		}
		this.lengthMenu = lengthMenu;
		return (J) this;
	}


	/**
	 * Description
	 * Allows control over whether DataTables should use the top (true) unique cell that is found for a single column, or the bottom
	 * (false - default) to attach the default order listener. This is useful when using complex headers.
	 *
	 * @return
	 */
	public Boolean getOrderCellsTop()
	{
		return orderCellsTop;
	}

	/**
	 * Description
	 * Allows control over whether DataTables should use the top (true) unique cell that is found for a single column, or the bottom
	 * (false - default) to attach the default order listener. This is useful when using complex headers.
	 *
	 * @param orderCellsTop
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setOrderCellsTop(Boolean orderCellsTop)
	{
		this.orderCellsTop = orderCellsTop;
		return (J) this;
	}

	/**
	 * Description
	 * DataTables highlight the columns which are used to order the content in the table's body by adding a class to the cells in that
	 * column, which in turn has CSS applied to those classes to highlight those cells.
	 * <p>
	 * This is done by the addition of the classes sorting_1, sorting_2 and sorting_3 to the columns which are currently being ordered on.
	 * The integer value indicates the level of sorting when mutli-column sorting. If more than 3 columns are being ordered upon, the
	 * sorting_3 class is repeated.
	 * <p>
	 * Please note that this feature can affect performance, particularly in old browsers and when there are a lot of rows to be displayed
	 * as it is manipulating a large number of DOM elements. As such, this option is available as a feature switch to allow this feature
	 * to be disabled with working with old browsers or large data sets.
	 *
	 * @return
	 */
	public Boolean getOrderClasses()
	{
		return orderClasses;
	}

	/**
	 * Description
	 * DataTables highlight the columns which are used to order the content in the table's body by adding a class to the cells in that
	 * column, which in turn has CSS applied to those classes to highlight those cells.
	 * <p>
	 * This is done by the addition of the classes sorting_1, sorting_2 and sorting_3 to the columns which are currently being ordered on.
	 * The integer value indicates the level of sorting when mutli-column sorting. If more than 3 columns are being ordered upon, the
	 * sorting_3 class is repeated.
	 * <p>
	 * Please note that this feature can affect performance, particularly in old browsers and when there are a lot of rows to be displayed
	 * as it is manipulating a large number of DOM elements. As such, this option is available as a feature switch to allow this feature
	 * to be disabled with working with old browsers or large data sets.
	 *
	 * @param orderClasses
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setOrderClasses(Boolean orderClasses)
	{
		this.orderClasses = orderClasses;
		return (J) this;
	}

	/**
	 * orderFixedSince: DataTables 1.10
	 * Ordering to always be applied to the table.
	 * <p>
	 * Description
	 * The option works in tandem with the order option which provides an initial ordering state for the table which can then be modified
	 * by the user clicking on column headings, while the ordering specified by this option will always be applied to the table,
	 * regardless of user interaction.
	 * <p>
	 * This fixed ordering can be applied before (pre) or after (post) the user's own ordering criteria using the two different forms of
	 * this option (array or object) described below.
	 * <p>
	 * The values that are used to describe the ordering conditions for the table are given as two element arrays:
	 * <p>
	 * Column index to order upon
	 * Direction so order to apply (asc for ascending order or desc for descending order).
	 * It is also possible to give a set of nested arrays (i.e. arrays in arrays) to allow multi-column ordering to be assigned.
	 * <p>
	 * This option can be useful if you a column (visible or hidden) which must always be sorted upon first - a priority order or index
	 * column for example, or for grouping similar rows together.
	 *
	 * @return
	 */
	public Boolean getOrderFixed()
	{
		return orderFixed;
	}

	/**
	 * orderFixedSince: DataTables 1.10
	 * Ordering to always be applied to the table.
	 * <p>
	 * Description
	 * The option works in tandem with the order option which provides an initial ordering state for the table which can then be modified
	 * by the user clicking on column headings, while the ordering specified by this option will always be applied to the table,
	 * regardless of user interaction.
	 * <p>
	 * This fixed ordering can be applied before (pre) or after (post) the user's own ordering criteria using the two different forms of
	 * this option (array or object) described below.
	 * <p>
	 * The values that are used to describe the ordering conditions for the table are given as two element arrays:
	 * <p>
	 * Column index to order upon
	 * Direction so order to apply (asc for ascending order or desc for descending order).
	 * It is also possible to give a set of nested arrays (i.e. arrays in arrays) to allow multi-column ordering to be assigned.
	 * <p>
	 * This option can be useful if you a column (visible or hidden) which must always be sorted upon first - a priority order or index
	 * column for example, or for grouping similar rows together.
	 *
	 * @param orderFixed
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setOrderFixed(Boolean orderFixed)
	{
		this.orderFixed = orderFixed;
		return (J) this;
	}

	/**
	 * orderMultiSince: DataTables 1.10
	 * Multiple column ordering ability control.
	 * <p>
	 * Description
	 * When ordering is enabled (ordering), by default DataTables allows users to sort multiple columns by shift clicking upon the header
	 * cell for each column. Although this can be quite useful for users, it can also increase the complexity of the order, potentiality
	 * increasing the processing time of ordering the data. Therefore, this option is provided to allow this shift-click multiple column
	 * ability.
	 * <p>
	 * Note that disabling this ability does not impede your ability as a developer to do multiple column ordering using columns
	 * .orderData, order or order(), it just disallows the user from performing their own multi-column order.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * true
	 *
	 * @return
	 */
	public Boolean getOrderMulti()
	{
		return orderMulti;
	}

	/**
	 * orderMultiSince: DataTables 1.10
	 * Multiple column ordering ability control.
	 * <p>
	 * Description
	 * When ordering is enabled (ordering), by default DataTables allows users to sort multiple columns by shift clicking upon the header
	 * cell for each column. Although this can be quite useful for users, it can also increase the complexity of the order, potentiality
	 * increasing the processing time of ordering the data. Therefore, this option is provided to allow this shift-click multiple column
	 * ability.
	 * <p>
	 * Note that disabling this ability does not impede your ability as a developer to do multiple column ordering using columns
	 * .orderData, order or order(), it just disallows the user from performing their own multi-column order.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * true
	 *
	 * @param orderMulti
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setOrderMulti(Boolean orderMulti)
	{
		this.orderMulti = orderMulti;
		return (J) this;
	}


	/**
	 * orderingSince: DataTables 1.10
	 * Feature control ordering (sorting) abilities in DataTables.
	 * <p>
	 * Description
	 * Enable or disable ordering of columns - it is as simple as that! DataTables, by default, allows end users to click on the header
	 * cell for each column, ordering the table by the data in that column. The ability to order data can be disabled using this option.
	 * <p>
	 * Note that the ability to add or remove sorting of individual columns can be disabled by the columns.orderable option for each
	 * column. This parameter is a global option - when disabled, there are no sorting actions applied by DataTables at all.
	 *
	 * @return
	 */
	public Boolean getOrdering()
	{
		return ordering;
	}

	/**
	 * orderingSince: DataTables 1.10
	 * Feature control ordering (sorting) abilities in DataTables.
	 * <p>
	 * Description
	 * Enable or disable ordering of columns - it is as simple as that! DataTables, by default, allows end users to click on the header
	 * cell for each column, ordering the table by the data in that column. The ability to order data can be disabled using this option.
	 * <p>
	 * Note that the ability to add or remove sorting of individual columns can be disabled by the columns.orderable option for each
	 * column. This parameter is a global option - when disabled, there are no sorting actions applied by DataTables at all.
	 *
	 * @param ordering
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setOrdering(Boolean ordering)
	{
		this.ordering = ordering;
		return (J) this;
	}

	/**
	 * pageLengthSince: DataTables 1.10
	 * Change the initial page length (number of rows per page).
	 * <p>
	 * Description
	 * Number of rows to display on a single page when using pagination.
	 * <p>
	 * If lengthChange is feature enabled (it is by default) then the end user will be able to override the value set here to a custom
	 * setting using a pop-up menu (see lengthMenu).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * integer
	 * Default
	 * Value: 10
	 *
	 * @return
	 */
	public Integer getPageLength()
	{
		return pageLength;
	}

	/**
	 * pageLengthSince: DataTables 1.10
	 * Change the initial page length (number of rows per page).
	 * <p>
	 * Description
	 * Number of rows to display on a single page when using pagination.
	 * <p>
	 * If lengthChange is feature enabled (it is by default) then the end user will be able to override the value set here to a custom
	 * setting using a pop-up menu (see lengthMenu).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * integer
	 * Default
	 * Value: 10
	 *
	 * @param pageLength
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setPageLength(Integer pageLength)
	{
		this.pageLength = pageLength;
		return (J) this;
	}

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
	 *
	 * @return
	 */
	public DataTablesPagingTypes getPagingType()
	{
		return pagingType;
	}

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
	 *
	 * @param pagingType
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setPagingType(DataTablesPagingTypes pagingType)
	{
		this.pagingType = pagingType;
		return (J) this;
	}

	/**
	 * pagingSince: DataTables 1.10
	 * Enable or disable table pagination.
	 * <p>
	 * Description
	 * DataTables can split the rows in tables into individual pages, which is an efficient method of showing a large number of records in
	 * a small space. The end user is provided with controls to request the display of different data as the navigate through the data.
	 * This feature is enabled by default, but if you wish to disable it, you may do so with this parameter.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * true
	 *
	 * @return
	 */
	public Boolean getPaging()
	{
		return paging;
	}

	/**
	 * pagingSince: DataTables 1.10
	 * Enable or disable table pagination.
	 * <p>
	 * Description
	 * DataTables can split the rows in tables into individual pages, which is an efficient method of showing a large number of records in
	 * a small space. The end user is provided with controls to request the display of different data as the navigate through the data.
	 * This feature is enabled by default, but if you wish to disable it, you may do so with this parameter.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * true
	 *
	 * @param paging
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setPaging(Boolean paging)
	{
		this.paging = paging;
		return (J) this;
	}

	/**
	 * processingSince: DataTables 1.10
	 * Feature control the processing indicator.
	 * <p>
	 * Description
	 * Enable or disable the display of a 'processing' indicator when the table is being processed (e.g. a sort). This is particularly
	 * useful for tables with large amounts of data where it can take a noticeable amount of time to sort the entries.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * false
	 *
	 * @return
	 */
	public Boolean getProcessing()
	{
		return processing;
	}

	/**
	 * processingSince: DataTables 1.10
	 * Feature control the processing indicator.
	 * <p>
	 * Description
	 * Enable or disable the display of a 'processing' indicator when the table is being processed (e.g. a sort). This is particularly
	 * useful for tables with large amounts of data where it can take a noticeable amount of time to sort the entries.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * false
	 *
	 * @param processing
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setProcessing(Boolean processing)
	{
		this.processing = processing;
		return (J) this;
	}

	/**
	 * rendererSince: DataTables 1.10
	 * Display component renderer types.
	 * <p>
	 * Description
	 * DataTables adds some complex components to your HTML page, such as the pagination control. The business logic used to calculate
	 * information should be displayed (what buttons in the case of the pagination buttons) is core to DataTables and generally doesn't
	 * vary how the buttons are actually displayed does based on the styling requirements of the page. For example the pagination buttons
	 * might be displayed as li elements in a ul list, or simply as a collection of a buttons.
	 * <p>
	 * This ability to use different renderers, while maintaining the same core business logic, is fundamental to how DataTables provides
	 * integration options for CSS frameworks such as Bootstrap, Foundation and jQuery UI, customising the HTML it uses to fit the
	 * requirements of each framework.
	 * <p>
	 * This parameter controls which renderers will be used. The value given will be used is such a renderer exists, otherwise the default
	 * renderer will be used. Additional renderers can be added by plug-ins.
	 * <p>
	 * DataTables currently supports two different types of renderers:
	 * <p>
	 * header - header cell renderer
	 * pageButton - pagination buttons
	 * This list will likely expand significantly in future versions of DataTables!
	 * <p>
	 * Types
	 * string
	 * Description:
	 * Attempt to use renderers of this name for all available renderers. If a renderer is not found matching this name for the renderer
	 * type requested, the default renderer will be used.
	 * <p>
	 * object
	 * Description:
	 * Specify specific renderers for the different renderer types. For a list of the available renderer types, please see the
	 * documentation below.
	 * <p>
	 * Examples
	 * Using the Bootstrap plug-in renderer:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * $('#example').dataTable( {
	 * renderer: "bootstrap"
	 * } );
	 *
	 * @return
	 */
	public DataTableThemes getRenderer()
	{
		return renderer;
	}

	/**
	 * rendererSince: DataTables 1.10
	 * Display component renderer types.
	 * <p>
	 * Description
	 * DataTables adds some complex components to your HTML page, such as the pagination control. The business logic used to calculate
	 * information should be displayed (what buttons in the case of the pagination buttons) is core to DataTables and generally doesn't
	 * vary how the buttons are actually displayed does based on the styling requirements of the page. For example the pagination buttons
	 * might be displayed as li elements in a ul list, or simply as a collection of a buttons.
	 * <p>
	 * This ability to use different renderers, while maintaining the same core business logic, is fundamental to how DataTables provides
	 * integration options for CSS frameworks such as Bootstrap, Foundation and jQuery UI, customising the HTML it uses to fit the
	 * requirements of each framework.
	 * <p>
	 * This parameter controls which renderers will be used. The value given will be used is such a renderer exists, otherwise the default
	 * renderer will be used. Additional renderers can be added by plug-ins.
	 * <p>
	 * DataTables currently supports two different types of renderers:
	 * <p>
	 * header - header cell renderer
	 * pageButton - pagination buttons
	 * This list will likely expand significantly in future versions of DataTables!
	 * <p>
	 * Types
	 * string
	 * Description:
	 * Attempt to use renderers of this name for all available renderers. If a renderer is not found matching this name for the renderer
	 * type requested, the default renderer will be used.
	 * <p>
	 * object
	 * Description:
	 * Specify specific renderers for the different renderer types. For a list of the available renderer types, please see the
	 * documentation below.
	 * <p>
	 * Examples
	 * Using the Bootstrap plug-in renderer:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * $('#example').dataTable( {
	 * renderer: "bootstrap"
	 * } );
	 *
	 * @param renderer
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRenderer(DataTableThemes renderer)
	{
		this.renderer = renderer;
		return (J) this;
	}

	/**
	 * retrieveSince: DataTables 1.10
	 * Retrieve an existing DataTables instance.
	 * <p>
	 * Description
	 * Retrieve the DataTables object for the given selector. Note that if the table has already been initialised, this parameter will
	 * cause DataTables to simply return the object that has already been set up - it will not take account of any changes you might have
	 * made to the initialisation object passed to DataTables (setting this parameter to true is an acknowledgement that you understand
	 * this!).
	 * <p>
	 * The destroy option can be used to reinitialise a table with different options if required.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: false
	 *
	 * @return
	 */
	public Boolean getRetrieve()
	{
		return retrieve;
	}

	/**
	 * retrieveSince: DataTables 1.10
	 * Retrieve an existing DataTables instance.
	 * <p>
	 * Description
	 * Retrieve the DataTables object for the given selector. Note that if the table has already been initialised, this parameter will
	 * cause DataTables to simply return the object that has already been set up - it will not take account of any changes you might have
	 * made to the initialisation object passed to DataTables (setting this parameter to true is an acknowledgement that you understand
	 * this!).
	 * <p>
	 * The destroy option can be used to reinitialise a table with different options if required.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: true
	 *
	 * @param retrieve
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRetrieve(Boolean retrieve)
	{
		this.retrieve = retrieve;
		return (J) this;
	}

	public String getRowId()
	{
		return rowId;
	}

	/**
	 * rowIdSince: DataTables 1.10.8
	 * Data property name that DataTables will use to set tr element DOM IDs.
	 * <p>
	 * Description
	 * It can often be useful to have a id attribute on each tr element in a DataTable for row selection and data source identification,
	 * particularly when using events.
	 * <p>
	 * DataTables will attempt to automatically read an id value from the data source for each row using the property defined by this
	 * option. By default it is DT_RowId but can be set to any other name. As with columns.data it can also read from a nested JSON data
	 * source by using Javascript dotted object notation (e.g. DT_RowId: 'image.id').
	 * <p>
	 * If no id value for the row is found, the id property will not be automatically set.
	 * <p>
	 * Any row id values that are given in the data source should match the HTML specification for what values it can take:
	 * <p>
	 * The value must be unique amongst all the IDs in the element's home subtree and must contain at least one character. The value must
	 * not contain any space characters.
	 * <p>
	 * You may also wish to consider the CSS 2.1 specification of an identifier which is more restrictive than HTML5's and will provide
	 * maximum compatibility with jQuery:
	 * <p>
	 * identifiers (including element names, classes, and IDs in selectors) can contain only the characters [a-zA-Z0-9] and ISO 10646
	 * characters U+00A0 and higher, plus the hyphen (-) and the underscore (_); they cannot start with a digit, two hyphens, or a hyphen
	 * followed by a digit. Identifiers can also contain escaped characters and any ISO 10646 character as a numeric code.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 *
	 * @param rowId
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRowId(String rowId)
	{
		this.rowId = rowId;
		return (J) this;
	}

	/**
	 * scrollCollapseSince: DataTables 1.10
	 * Allow the table to reduce in height when a limited number of rows are shown.
	 * <p>
	 * Description
	 * When vertical (y) scrolling is enabled through the use of the scrollY option, DataTables will force the height of the table's
	 * viewport to the given height at all times (useful for layout). However, this can look odd when filtering data down to a small data
	 * set, and the footer is left "floating" further down. This parameter (when enabled) will cause DataTables to collapse the table's
	 * viewport down when the result set will fit within the given Y height.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 *
	 * @return
	 */
	public Boolean getScrollCollapse()
	{
		return scrollCollapse;
	}

	/**
	 * scrollCollapseSince: DataTables 1.10
	 * Allow the table to reduce in height when a limited number of rows are shown.
	 * <p>
	 * Description
	 * When vertical (y) scrolling is enabled through the use of the scrollY option, DataTables will force the height of the table's
	 * viewport to the given height at all times (useful for layout). However, this can look odd when filtering data down to a small data
	 * set, and the footer is left "floating" further down. This parameter (when enabled) will cause DataTables to collapse the table's
	 * viewport down when the result set will fit within the given Y height.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 *
	 * @param scrollCollapse
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setScrollCollapse(Boolean scrollCollapse)
	{
		this.scrollCollapse = scrollCollapse;
		return (J) this;
	}

	/**
	 * scrollXSince: DataTables 1.10
	 * Horizontal scrolling.
	 * <p>
	 * Description
	 * Enable horizontal scrolling. When a table is too wide to fit into a certain layout, or you have a large number of columns in the
	 * table, you can enable horizontal (x) scrolling to show the table in a viewport, which can be scrolled.
	 * <p>
	 * This property can be true which will allow the table to scroll horizontally when needed (recommended), or any CSS unit, or a number
	 * (in which case it will be treated as a pixel measurement).
	 *
	 * @return
	 */
	public Boolean getScrollX()
	{
		return scrollX;
	}

	/**
	 * scrollXSince: DataTables 1.10
	 * Horizontal scrolling.
	 * <p>
	 * Description
	 * Enable horizontal scrolling. When a table is too wide to fit into a certain layout, or you have a large number of columns in the
	 * table, you can enable horizontal (x) scrolling to show the table in a viewport, which can be scrolled.
	 * <p>
	 * This property can be true which will allow the table to scroll horizontally when needed (recommended), or any CSS unit, or a number
	 * (in which case it will be treated as a pixel measurement).
	 *
	 * @param scrollX
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setScrollX(Boolean scrollX)
	{
		this.scrollX = scrollX;
		return (J) this;
	}

	/**
	 * scrollXSince: DataTables 1.10
	 * Horizontal scrolling.
	 * <p>
	 * Description
	 * Enable horizontal scrolling. When a table is too wide to fit into a certain layout, or you have a large number of columns in the
	 * table, you can enable horizontal (x) scrolling to show the table in a viewport, which can be scrolled.
	 * <p>
	 * This property can be true which will allow the table to scroll horizontally when needed (recommended), or any CSS unit, or a number
	 * (in which case it will be treated as a pixel measurement).
	 *
	 * @return
	 */
	public Integer getScrollXNum()
	{
		return scrollXNum;
	}

	/**
	 * scrollXSince: DataTables 1.10
	 * Horizontal scrolling.
	 * <p>
	 * Description
	 * Enable horizontal scrolling. When a table is too wide to fit into a certain layout, or you have a large number of columns in the
	 * table, you can enable horizontal (x) scrolling to show the table in a viewport, which can be scrolled.
	 * <p>
	 * This property can be true which will allow the table to scroll horizontally when needed (recommended), or any CSS unit, or a number
	 * (in which case it will be treated as a pixel measurement).
	 *
	 * @param scrollXNum
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setScrollXNum(Integer scrollXNum)
	{
		this.scrollXNum = scrollXNum;
		return (J) this;
	}

	/**
	 * scrollYSince: DataTables 1.10
	 * Vertical scrolling.
	 * <p>
	 * Description
	 * Enable vertical scrolling. Vertical scrolling will constrain the DataTable to the given height, and enable scrolling for any data
	 * which overflows the current viewport. This can be used as an alternative to paging to display a lot of data in a small area
	 * (although paging and scrolling can both be enabled at the same time if desired).
	 * <p>
	 * The value given here can be any CSS unit, or a number (in which case it will be treated as a pixel measurement) and is applied to
	 * the table body (i.e. it does not take into account the header or footer height directly).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 *
	 * @return
	 */
	public MeasurementCSSImpl getScrollY()
	{
		return scrollY;
	}

	/**
	 * scrollYSince: DataTables 1.10
	 * Vertical scrolling.
	 * <p>
	 * Description
	 * Enable vertical scrolling. Vertical scrolling will constrain the DataTable to the given height, and enable scrolling for any data
	 * which overflows the current viewport. This can be used as an alternative to paging to display a lot of data in a small area
	 * (although paging and scrolling can both be enabled at the same time if desired).
	 * <p>
	 * The value given here can be any CSS unit, or a number (in which case it will be treated as a pixel measurement) and is applied to
	 * the table body (i.e. it does not take into account the header or footer height directly).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 *
	 * @param scrollY
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setScrollY(MeasurementCSSImpl scrollY)
	{
		this.scrollY = scrollY;
		return (J) this;
	}

	/**
	 * searchSince: DataTables 1.10
	 * Set an initial filter in DataTables and / or filtering options.
	 * <p>
	 * Description
	 * The search option allows the way DataTables performs filtering to be set during the initialisation, and to set an initial global
	 * filter.
	 * <p>
	 * The options that control how the filtering is performs are:
	 * <p>
	 * search.caseInsensitive - Indicate is case-insensitive sorting should be performed.
	 * search.regex - Treat the search as a regular expression or not
	 * search.smart - Use DataTables' smart filtering or not
	 * Additionally, to set an initial filter:
	 * <p>
	 * search.search - Set an initial global filter.
	 *
	 * @return
	 */
	@NotNull
	public DataTablesSearchOptions getSearch()
	{
		if (search == null)
		{
			search = new DataTablesSearchOptions();
		}
		return search;
	}

	/**
	 * searchSince: DataTables 1.10
	 * Set an initial filter in DataTables and / or filtering options.
	 * <p>
	 * Description
	 * The search option allows the way DataTables performs filtering to be set during the initialisation, and to set an initial global
	 * filter.
	 * <p>
	 * The options that control how the filtering is performs are:
	 * <p>
	 * search.caseInsensitive - Indicate is case-insensitive sorting should be performed.
	 * search.regex - Treat the search as a regular expression or not
	 * search.smart - Use DataTables' smart filtering or not
	 * Additionally, to set an initial filter:
	 * <p>
	 * search.search - Set an initial global filter.
	 *
	 * @param search
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearch(DataTablesSearchOptions search)
	{
		this.search = search;
		return (J) this;
	}

	/**
	 * searchColsSince: DataTables 1.10
	 * Define an initial search for individual columns.
	 * <p>
	 * Description
	 * Basically the same as the search option, but in this case for individual columns, rather than the global filter, this option
	 * defined the filtering to apply to the table during initialisation.
	 * <p>
	 * The array must be of the same size as the number of columns, and each element be an object with the parameters search and
	 * escapeRegex (the latter is optional). 'null' is also accepted and the default will be used.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 *
	 * @return
	 */
	public List<DataTablesSearchOptions> getSearchCols()
	{
		if (searchCols == null)
		{
			searchCols = new ArrayList<>();
		}
		return searchCols;
	}

	/**
	 * searchColsSince: DataTables 1.10
	 * Define an initial search for individual columns.
	 * <p>
	 * Description
	 * Basically the same as the search option, but in this case for individual columns, rather than the global filter, this option
	 * defined the filtering to apply to the table during initialisation.
	 * <p>
	 * The array must be of the same size as the number of columns, and each element be an object with the parameters search and
	 * escapeRegex (the latter is optional). 'null' is also accepted and the default will be used.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 *
	 * @param searchCols
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearchCols(List<DataTablesSearchOptions> searchCols)
	{
		this.searchCols = searchCols;
		return (J) this;
	}

	/**
	 * searchDelaySince: DataTables 1.10.3
	 * Set a throttle frequency for searching.
	 * <p>
	 * Description
	 * The built in DataTables global search (by default at the top right of every DataTable)will instantly search the table on every
	 * keypress when in client-side processing mode and reduce the search call frequency automatically to 400mS when in server-side
	 * processing mode. This call frequency (throttling) can be controlled using the searchDelay parameter for both client-side and
	 * server-side processing.
	 * <p>
	 * Being able to control the call frequency has a number of uses:
	 * <p>
	 * Older browsers and slower computers can have their processing load reduced by reducing the search frequency
	 * Fewer table redraws while search can be less distracting for the user
	 * Reduce the load on the server when using server-side processing by making fewer calls
	 * Conversely, you can speed up the search when using server-side processing by reducing the default of 400mS to instant (0).
	 * As with many other parts of DataTables, it is up to yourself how you configure it to suit your needs!
	 * <p>
	 * The value given for searchDelay is in milliseconds (mS).
	 * <p>
	 * Please note that this option effects only the built in global search box that DataTables provides. It does not effect the search()
	 * or column().search() methods at all. If you wish to be able to throttle calls to those API methods use the utility method $.fn
	 * .dataTable.util.throttle().
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 *
	 * @return
	 */
	public Integer getSearchDelay()
	{
		return searchDelay;
	}

	/**
	 * searchDelaySince: DataTables 1.10.3
	 * Set a throttle frequency for searching.
	 * <p>
	 * Description
	 * The built in DataTables global search (by default at the top right of every DataTable)will instantly search the table on every
	 * keypress when in client-side processing mode and reduce the search call frequency automatically to 400mS when in server-side
	 * processing mode. This call frequency (throttling) can be controlled using the searchDelay parameter for both client-side and
	 * server-side processing.
	 * <p>
	 * Being able to control the call frequency has a number of uses:
	 * <p>
	 * Older browsers and slower computers can have their processing load reduced by reducing the search frequency
	 * Fewer table redraws while search can be less distracting for the user
	 * Reduce the load on the server when using server-side processing by making fewer calls
	 * Conversely, you can speed up the search when using server-side processing by reducing the default of 400mS to instant (0).
	 * As with many other parts of DataTables, it is up to yourself how you configure it to suit your needs!
	 * <p>
	 * The value given for searchDelay is in milliseconds (mS).
	 * <p>
	 * Please note that this option effects only the built in global search box that DataTables provides. It does not effect the search()
	 * or column().search() methods at all. If you wish to be able to throttle calls to those API methods use the utility method $.fn
	 * .dataTable.util.throttle().
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 *
	 * @param searchDelay
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearchDelay(Integer searchDelay)
	{
		this.searchDelay = searchDelay;
		return (J) this;
	}

	/**
	 * stateDurationSince: DataTables 1.10
	 * Saved state validity duration.
	 * <p>
	 * Description
	 * Duration for which the saved state information is considered valid. After this period has elapsed the state will be returned to the
	 * default.
	 * <p>
	 * This option is also used to indicate to DataTables if localStorage or sessionStorage should be used for storing the table's state.
	 * When set to -1 sessionStorage will be used, while for 0 or greater localStorage will be used.
	 * <p>
	 * The difference between the two storage APIs is that sessionStorage retains data only for the current session (i..e the current
	 * browser window). For more information on these two HTML APIs please refer to the Mozilla Storage documentation.
	 * <p>
	 * Please note that the value is given in seconds. The value 0 is a special value as it indicates that the state can be stored and
	 * retrieved indefinitely with no time limit.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * integer
	 *
	 * @return
	 */
	public Integer getStateDuration()
	{
		return stateDuration;
	}

	/**
	 * stateDurationSince: DataTables 1.10
	 * Saved state validity duration.
	 * <p>
	 * Description
	 * Duration for which the saved state information is considered valid. After this period has elapsed the state will be returned to the
	 * default.
	 * <p>
	 * This option is also used to indicate to DataTables if localStorage or sessionStorage should be used for storing the table's state.
	 * When set to -1 sessionStorage will be used, while for 0 or greater localStorage will be used.
	 * <p>
	 * The difference between the two storage APIs is that sessionStorage retains data only for the current session (i..e the current
	 * browser window). For more information on these two HTML APIs please refer to the Mozilla Storage documentation.
	 * <p>
	 * Please note that the value is given in seconds. The value 0 is a special value as it indicates that the state can be stored and
	 * retrieved indefinitely with no time limit.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * integer
	 *
	 * @param stateDuration
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setStateDuration(Integer stateDuration)
	{
		this.stateDuration = stateDuration;
		return (J) this;
	}

	/**
	 * stripeClassesSince: DataTables 1.10
	 * Set the zebra stripe class names for the rows in the table.
	 * <p>
	 * Description
	 * An array of CSS classes that should be applied to displayed rows, in sequence. This array may be of any length, and DataTables will
	 * apply each class sequentially, looping when required.
	 * <p>
	 * Note that by default this option will take the values determined by the $.fn.dataTable.ext.classes.stripe* options (these are odd
	 * and even by default).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 * Example
	 * Use three stripe classes:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * $('#example').dataTable( {
	 * "stripeClasses": [ 'strip1', 'strip2', 'strip3' ]
	 * } );
	 *
	 * @return
	 */
	public Set<String> getStripeClasses()
	{
		if (stripeClasses == null)
		{
			stripeClasses = new LinkedHashSet<>();
		}
		return stripeClasses;
	}

	/**
	 * stripeClassesSince: DataTables 1.10
	 * Set the zebra stripe class names for the rows in the table.
	 * <p>
	 * Description
	 * An array of CSS classes that should be applied to displayed rows, in sequence. This array may be of any length, and DataTables will
	 * apply each class sequentially, looping when required.
	 * <p>
	 * Note that by default this option will take the values determined by the $.fn.dataTable.ext.classes.stripe* options (these are odd
	 * and even by default).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 * Example
	 * Use three stripe classes:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * $('#example').dataTable( {
	 * "stripeClasses": [ 'strip1', 'strip2', 'strip3' ]
	 * } );
	 *
	 * @param stripeClasses
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setStripeClasses(Set<String> stripeClasses)
	{
		this.stripeClasses = stripeClasses;
		return (J) this;
	}

	/**
	 * searchingSince: DataTables 1.10
	 * Feature control search (filtering) abilities.
	 * <p>
	 * Description
	 * This option allows the search abilities of DataTables to be enabled or disabled. Searching in DataTables is "smart" in that it
	 * allows the end user to input multiple words (space separated) and will match a row containing those words, even if not in the order
	 * that was specified (this allow matching across multiple columns).
	 * <p>
	 * Please be aware that technically the search in DataTables is actually a filter, since it is subtractive, removing data from the
	 * data set as the input becomes more complex. It is named "search" here, and else where in the DataTables API for consistency and to
	 * ensure there are no conflicts with other methods of a similar name (specific the filter() API method).
	 * <p>
	 * Note that if you wish to use the search abilities of DataTables this must remain true - to remove the default search input box
	 * whilst retaining searching abilities (for example you might use the search() method), use the dom option.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: true
	 *
	 * @return
	 */
	public Boolean getSearching()
	{
		return searching;
	}

	/**
	 * searchingSince: DataTables 1.10
	 * Feature control search (filtering) abilities.
	 * <p>
	 * Description
	 * This option allows the search abilities of DataTables to be enabled or disabled. Searching in DataTables is "smart" in that it
	 * allows the end user to input multiple words (space separated) and will match a row containing those words, even if not in the order
	 * that was specified (this allow matching across multiple columns).
	 * <p>
	 * Please be aware that technically the search in DataTables is actually a filter, since it is subtractive, removing data from the
	 * data set as the input becomes more complex. It is named "search" here, and else where in the DataTables API for consistency and to
	 * ensure there are no conflicts with other methods of a similar name (specific the filter() API method).
	 * <p>
	 * Note that if you wish to use the search abilities of DataTables this must remain true - to remove the default search input box
	 * whilst retaining searching abilities (for example you might use the search() method), use the dom option.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: true
	 *
	 * @param searching
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearching(Boolean searching)
	{
		this.searching = searching;
		return (J) this;
	}

	/**
	 * serverSideSince: DataTables 1.10
	 * Feature control DataTables' server-side processing mode.
	 * <p>
	 * Description
	 * DataTables has two fundamental modes of operation:
	 * <p>
	 * Client-side processing - where filtering, paging and sorting calculations are all performed in the web-browser.
	 * <p>
	 * Server-side processing - where filtering, paging and sorting calculations are all performed by a server.
	 * <p>
	 * By default DataTables operates in client-side processing mode, but can be switched to server-side processing mode using this option
	 * . Server-side processing is useful when working with large data sets (typically &gt; 50'000 records) as it means a database engine
	 * can
	 * be used to perform the sorting etc calculations - operations that modern database engines are highly optimised for, allowing use of
	 * DataTables with massive data sets (millions of rows).
	 * <p>
	 * When operating in server-side processing mode, DataTables will send parameters to the server indicating what data it needs (what
	 * page, what filters are applied etc), and also expects certain parameters back in order that it has all the information required to
	 * display the table. The client-server communication protocol DataTables uses is detailed in the DataTables documentation.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * false
	 *
	 * @return
	 */
	public Boolean getServerSide()
	{
		return serverSide;
	}

	/**
	 * serverSideSince: DataTables 1.10
	 * Feature control DataTables' server-side processing mode.
	 * <p>
	 * Description
	 * DataTables has two fundamental modes of operation:
	 * <p>
	 * Client-side processing - where filtering, paging and sorting calculations are all performed in the web-browser.
	 * <p>
	 * Server-side processing - where filtering, paging and sorting calculations are all performed by a server.
	 * <p>
	 * By default DataTables operates in client-side processing mode, but can be switched to server-side processing mode using this option
	 * . Server-side processing is useful when working with large data sets (typically &gt;50'000 records) as it means a database engine
	 * can
	 * be used to perform the sorting etc calculations - operations that modern database engines are highly optimised for, allowing use of
	 * DataTables with massive data sets (millions of rows).
	 * <p>
	 * When operating in server-side processing mode, DataTables will send parameters to the server indicating what data it needs (what
	 * page, what filters are applied etc), and also expects certain parameters back in order that it has all the information required to
	 * display the table. The client-server communication protocol DataTables uses is detailed in the DataTables documentation.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * false
	 *
	 * @param serverSide
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setServerSide(Boolean serverSide)
	{
		this.serverSide = serverSide;
		return (J) this;
	}

	/**
	 * stateSaveSince: DataTables 1.10
	 * State saving - restore table state on page reload.
	 * <p>
	 * Description
	 * Enable or disable state saving. When enabled aDataTables will store state information such as pagination position, display length,
	 * filtering and sorting. When the end user reloads the page the table's state will be altered to match what they had previously set
	 * up.
	 * <p>
	 * Data storage for the state information in the browser is performed by use of the localStorage or sessionStorage HTML5 APIs. The
	 * stateDuration indicated to DataTables which API should be used (localStorage: 0 or greater, or sessionStorage: -1).
	 * <p>
	 * To be able to uniquely identify each table's state data, information is stored using a combination of the table's DOM id and the
	 * current page's pathname. If the table's id changes, or the page URL changes, the state information will be lost.
	 * <p>
	 * Please note that the use of the HTML5 APIs for data storage means that the built in state saving option will not work with IE6/7 as
	 * these browsers do not support these APIs. Alternative options of using cookies or saving the state on the server through Ajax can
	 * be used through the stateSaveCallback and stateLoadCallback options.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: false
	 *
	 * @return
	 */
	public Boolean getStateSave()
	{
		return stateSave;
	}

	/**
	 * stateSaveSince: DataTables 1.10
	 * State saving - restore table state on page reload.
	 * <p>
	 * Description
	 * Enable or disable state saving. When enabled aDataTables will store state information such as pagination position, display length,
	 * filtering and sorting. When the end user reloads the page the table's state will be altered to match what they had previously set
	 * up.
	 * <p>
	 * Data storage for the state information in the browser is performed by use of the localStorage or sessionStorage HTML5 APIs. The
	 * stateDuration indicated to DataTables which API should be used (localStorage: 0 or greater, or sessionStorage: -1).
	 * <p>
	 * To be able to uniquely identify each table's state data, information is stored using a combination of the table's DOM id and the
	 * current page's pathname. If the table's id changes, or the page URL changes, the state information will be lost.
	 * <p>
	 * Please note that the use of the HTML5 APIs for data storage means that the built in state saving option will not work with IE6/7 as
	 * these browsers do not support these APIs. Alternative options of using cookies or saving the state on the server through Ajax can
	 * be used through the stateSaveCallback and stateLoadCallback options.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: false
	 *
	 * @param stateSave
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setStateSave(Boolean stateSave)
	{
		this.stateSave = stateSave;
		return (J) this;
	}


	/**
	 * tabIndexSince: DataTables 1.10
	 * Tab index control for keyboard navigation.
	 * <p>
	 * Description
	 * By default DataTables allows keyboard navigation of the table (sorting, paging, and filtering) by adding a tabindex attribute to
	 * the required elements. This allows the end user to tab through the controls and press the enter key to activate them, allowing the
	 * table controls to be accessible without a mouse.
	 * <p>
	 * The default tabindex is 0, meaning that the tab follows the flow of the document. You can overrule this using this parameter if you
	 * wish. Use a value of -1 to disable built-in keyboard navigation, although this is not recommended for accessibility reasons.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * integer
	 * Default
	 * Value: 0
	 *
	 * @return
	 */
	public Integer getTabIndex()
	{
		return tabIndex;
	}

	/**
	 * tabIndexSince: DataTables 1.10
	 * Tab index control for keyboard navigation.
	 * <p>
	 * Description
	 * By default DataTables allows keyboard navigation of the table (sorting, paging, and filtering) by adding a tabindex attribute to
	 * the required elements. This allows the end user to tab through the controls and press the enter key to activate them, allowing the
	 * table controls to be accessible without a mouse.
	 * <p>
	 * The default tabindex is 0, meaning that the tab follows the flow of the document. You can overrule this using this parameter if you
	 * wish. Use a value of -1 to disable built-in keyboard navigation, although this is not recommended for accessibility reasons.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * integer
	 * Default
	 * Value: 0
	 *
	 * @param tabIndex
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTabIndex(Integer tabIndex)
	{
		this.tabIndex = tabIndex;
		return (J) this;
	}

	/**
	 * ajaxSince: DataTables 1.10
	 * Load data for the table's content from an Ajax source.
	 * <p>
	 * Description
	 * DataTables can obtain the data that it is to display in the table body from a number of sources, including from an Ajax data
	 * source, using this initialisation parameter. As with other dynamic data sources, arrays or objects can be used for the data source
	 * for each row, with columns.data employed to read from specific object properties.
	 * <p>
	 * The ajax property has three different modes of operation, depending on how it is defined. These are:
	 * <p>
	 * string - Set the URL from where the data should be loaded from.
	 * object - Define properties for jQuery.ajax.
	 * function - Custom data get function
	 *
	 * @return
	 */
	public DataTablesAjaxOptions getAjax()
	{
		if (ajax == null)
		{
			ajax = new DataTablesAjaxOptions();
		}
		return ajax;
	}

	/**
	 * ajaxSince: DataTables 1.10
	 * Load data for the table's content from an Ajax source.
	 * <p>
	 * Description
	 * DataTables can obtain the data that it is to display in the table body from a number of sources, including from an Ajax data
	 * source, using this initialisation parameter. As with other dynamic data sources, arrays or objects can be used for the data source
	 * for each row, with columns.data employed to read from specific object properties.
	 * <p>
	 * The ajax property has three different modes of operation, depending on how it is defined. These are:
	 * <p>
	 * string - Set the URL from where the data should be loaded from.
	 * object - Define properties for jQuery.ajax.
	 * function - Custom data get function
	 *
	 * @param ajax
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setAjax(DataTablesAjaxOptions ajax)
	{
		this.ajax = ajax;
		return (J) this;
	}

	public String getData()
	{
		return data;
	}

	public J setData(String data)
	{
		this.data = data;
		return (J) this;
	}

	/**
	 * If the data table should be destroyed
	 *
	 * @return
	 */
	public Boolean getDestroy()
	{
		return destroy;
	}

	/**
	 * If the data table should be destroyed
	 *
	 * @param destroy
	 *
	 * @return
	 */
	public J setDestroy(Boolean destroy)
	{
		this.destroy = destroy;
		return (J) this;
	}

	/**
	 * <p>
	 * As is described by the basic DOM positioning example you can use the dom initialisation parameter to move DataTables features
	 * around the table to where you want them.
	 * <p>
	 * In addition to this, you can also use dom to create multiple instances of these table controls. Simply include the feature's
	 * identification letter where you want it to appear, as many times as
	 * you wish, and the controls will all sync up (note that obviously the table (t) should be included only once).
	 * <p>
	 * This is shown in the demo below where for four key build-in features are duplicated above and below the table.
	 *
	 * @return
	 */
	public EnumSet<DataTablesDomOptions> getDom()
	{
		return dom;
	}

	/**
	 * Returns the list of columns
	 *
	 * @return
	 */
	public List<DataTableColumnOptions> getColumns()
	{
		if (columns == null)
		{
			columns = new ArrayList<>();
		}
		return columns;
	}

	/**
	 * Sets the list of columns
	 *
	 * @param columns
	 *
	 * @return
	 */
	public J setColumns(List<DataTableColumnOptions> columns)
	{
		this.columns = columns;
		return (J) this;
	}

	public DataTableAutoFillOptions getAutoFill()
	{
		if (autoFill == null)
		{
			autoFill = new DataTableAutoFillOptions();
		}
		return autoFill;
	}

	/**
	 * Sets the auto fill object
	 *
	 * @param autoFill
	 *
	 * @return
	 */
	public J setAutoFill(DataTableAutoFillOptions autoFill)
	{
		this.autoFill = autoFill;
		return (J) this;
	}

	/**
	 * Buttons
	 * A common UI paradigm to use with interactive tables is to present buttons that will trigger some action - that may be to alter the
	 * table's state, modify the data in the table, gather the data from the table or even to activate some external process. Showing such
	 * buttons is an interface that end users are comfortable with, making them feel at home with the table.
	 * <p>
	 * The Buttons library for DataTables provides a framework with common options and API that can be used with DataTables, but is also
	 * very extensible, recognising that you will likely want to use buttons which perform an action unique to your applications.
	 * <p>
	 * Buttons has four sets of plug-ins that are part of the core software - they are not built into the core, but rather than be
	 * included as and when you need them, selecting only the software you require. Other extensions such as Editor and Select also
	 * provide buttons for use with this library, with actions unique to their own behaviours. This ensures a consistent interface for the
	 * interactions performed with your tables.
	 *
	 * @return
	 */
	public DataTablesButtonsOptions getButtons()
	{
		return buttons;
	}

	/**
	 * Buttons
	 * A common UI paradigm to use with interactive tables is to present buttons that will trigger some action - that may be to alter the
	 * table's state, modify the data in the table, gather the data from the table or even to activate some external process. Showing such
	 * buttons is an interface that end users are comfortable with, making them feel at home with the table.
	 * <p>
	 * The Buttons library for DataTables provides a framework with common options and API that can be used with DataTables, but is also
	 * very extensible, recognising that you will likely want to use buttons which perform an action unique to your applications.
	 * <p>
	 * Buttons has four sets of plug-ins that are part of the core software - they are not built into the core, but rather than be
	 * included as and when you need them, selecting only the software you require. Other extensions such as Editor and Select also
	 * provide buttons for use with this library, with actions unique to their own behaviours. This ensures a consistent interface for the
	 * interactions performed with your tables.
	 *
	 * @param buttons
	 *
	 * @return
	 */
	public J setButtons(DataTablesButtonsOptions buttons)
	{
		this.buttons = buttons;
		return (J) this;
	}

	/**
	 * ColReorder adds the ability for the end user to be able to reorder columns in a DataTable through a click and drag operation. This
	 * can be useful when presenting data in a table, letting the user move columns that they wish to compare next to each other for
	 * easier comparison.
	 * <p>
	 * It is worth noting that the underlying column data structure of the DataTable is modified as part of this process - this is
	 * important if you are interacting with the table using the API.
	 *
	 * @return
	 */
	public DataTableColReOrderOptions getColReorder()
	{
		if (colReorder == null)
		{
			colReorder = new DataTableColReOrderOptions();
		}
		return colReorder;
	}

	/**
	 * ColReorder adds the ability for the end user to be able to reorder columns in a DataTable through a click and drag operation. This
	 * can be useful when presenting data in a table, letting the user move columns that they wish to compare next to each other for
	 * easier comparison.
	 * <p>
	 * It is worth noting that the underlying column data structure of the DataTable is modified as part of this process - this is
	 * important if you are interacting with the table using the API.
	 *
	 * @param colReorder
	 *
	 * @return
	 */
	public J setColReorder(DataTableColReOrderOptions colReorder)
	{
		this.colReorder = colReorder;
		return (J) this;
	}

	/**
	 * ColReorder adds the ability for the end user to be able to reorder columns in a DataTable through a click and drag operation. This
	 * can be useful when presenting data in a table, letting the user move columns that they wish to compare next to each other for
	 * easier comparison.
	 * <p>
	 * It is worth noting that the underlying column data structure of the DataTable is modified as part of this process - this is
	 * important if you are interacting with the table using the API.
	 *
	 * @param dom
	 *
	 * @return
	 */
	public J setDom(EnumSet<DataTablesDomOptions> dom)
	{
		this.dom = dom;
		return (J) this;
	}

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
	 *
	 * @return
	 */
	public DataTableFixedColumnsOptions getFixedColumns()
	{
		if (fixedColumns == null)
		{
			fixedColumns = new DataTableFixedColumnsOptions();
		}
		return fixedColumns;
	}

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
	 *
	 * @param fixedColumns
	 *
	 * @return
	 */
	public J setFixedColumns(DataTableFixedColumnsOptions fixedColumns)
	{
		this.fixedColumns = fixedColumns;
		return (J) this;
	}

	/**
	 * When displaying tables with a particularly large amount of data shown on each page, it can be useful to have the table's header and
	 * / or footer fixed to the top or bottom of the scrolling window. This lets your users quickly determine what each column refers to
	 * rather than needing to scroll back to the top of the table.
	 * <p>
	 * FixedHeader provides the ability to perform this action with DataTables tables. It operates by detaching the header and footer
	 * elements from the host table and attaching them to the top or bottom of the screen as required by the scrolling position of the
	 * window. This ensures that FixedColumns is fully compatible with DataTables and you can add complex interactions such as search
	 * elements in the table footer, just as you would with any other table.
	 * <p>
	 * Please note that FixedHeader is not currently compatible with tables that have the scrolling features of DataTables enabled
	 * (scrollX / scrollY). Please refer to the compatibility table for full compatibility details.
	 *
	 * @return
	 */
	public DataTableFixedHeaderOptions getFixedHeader()
	{
		if (fixedHeader == null)
		{
			fixedHeader = new DataTableFixedHeaderOptions();
		}
		return fixedHeader;
	}

	/**
	 * When displaying tables with a particularly large amount of data shown on each page, it can be useful to have the table's header and
	 * / or footer fixed to the top or bottom of the scrolling window. This lets your users quickly determine what each column refers to
	 * rather than needing to scroll back to the top of the table.
	 * <p>
	 * FixedHeader provides the ability to perform this action with DataTables tables. It operates by detaching the header and footer
	 * elements from the host table and attaching them to the top or bottom of the screen as required by the scrolling position of the
	 * window. This ensures that FixedColumns is fully compatible with DataTables and you can add complex interactions such as search
	 * elements in the table footer, just as you would with any other table.
	 * <p>
	 * Please note that FixedHeader is not currently compatible with tables that have the scrolling features of DataTables enabled
	 * (scrollX / scrollY). Please refer to the compatibility table for full compatibility details.
	 *
	 * @param fixedHeader
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setFixedHeader(DataTableFixedHeaderOptions fixedHeader)
	{
		this.fixedHeader = fixedHeader;
		return (J) this;
	}
}
