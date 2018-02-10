package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import com.fasterxml.jackson.annotation.*;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTableSorts;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTablesSortables;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * The options allowed for a data table columns
 * This columnDefs.targets option provides the information required by DataTables for which columns in the table the column definition
 * object should be applied.
 * <p>
 * It can be:
 * <p>
 * 0 or a positive integer - column index counting from the left
 * A negative integer - column index counting from the right
 * A string - class name will be matched on the TH for the column (without a leading .)
 * The string "_all" - all columns (i.e. assign a default)
 * Additionally, targets can be either a single option from the list above, or an array of options (the different types can be mixed in
 * the array if required). For example targets: [ -1, -2 ] would target the last and second last columns in the table.
 *
 * @param <J>
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTableColumnOptions<J extends DataTableColumnOptions<J>> extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	private String name;
	/**
	 * This columnDefs.targets option provides the information required by DataTables for which columns in the table the column definition
	 * object should be applied.
	 * <p>
	 * It can be:
	 * <p>
	 * 0 or a positive integer - column index counting from the left
	 * A negative integer - column index counting from the right
	 * A string - class name will be matched on the TH for the column (without a leading .)
	 * The string "_all" - all columns (i.e. assign a default)
	 * Additionally, targets can be either a single option from the list above, or an array of options (the different types can be mixed
	 * in the array if required). For example targets: [ -1, -2 ] would target the last and second last columns in the table.
	 */
	private Integer targets;
	/**
	 * Change the cell type created for the column - either TD cells or TH cells.
	 * <p>
	 * This can be useful as TH cells have semantic meaning in the table body, allowing them to act as a header for a row (you may wish to
	 * add scope='row' to the TH elements using columns.createdCell option).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 * Default
	 */
	private ComponentTypes cellType;
	/**
	 * Description
	 * Quite simply this option adds a class to each cell in a column, regardless of if the table source is from DOM, Javascript or Ajax.
	 * This can be useful for styling columns.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 */
	private String className;
	/**
	 * Description
	 * The first thing to say about this property is that generally you shouldn't need this!
	 * <p>
	 * Having said that, it can be useful on rare occasions. When DataTables calculates the column widths to assign to each column, it
	 * finds the longest string in each column and then constructs a temporary table and reads the widths from that. The problem with this
	 * is that "mmm" is much wider then "iiii", but the latter is a longer string - thus the calculation can go wrong (doing it properly
	 * and putting it into an DOM object and measuring that is horribly slow!). Thus as a "work around" we provide this option. It will
	 * append its value to the text that is found to be the longest string for the column - i.e. padding.
	 */
	private String contentPadding;
	/**
	 * Description
	 * Often you may wish to have static content in a column, for example simple edit and / or delete buttons, which have events assigned
	 * to them. This option is available for those use cases - creating static content for a column. If you wish to create dynamic content
	 * (i.e. based on other data in the row), the columns.render option should be used.
	 * <p>
	 * Additionally, this option can be useful when loading JSON data, as the value set here will be used if the cell value from the JSON
	 * is found to be null (for example, you might set a default string of Not available.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 */
	@JsonIgnore
	private ComponentHierarchyBase defaultContent;
	/**
	 * Description
	 * Using this parameter, you can remove the end user's ability to order upon a column. This might be useful for generated content
	 * columns, for example if you have 'Edit' or 'Delete' buttons in the table.
	 * <p>
	 * Note that this option only effects the end user's ability to order a column. Developers are still able to order a column using the
	 * order option or the order() method if required.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 */
	private Boolean orderable;
	/**
	 * Description
	 * Allows a column's sorting to take either the data from a different (often hidden) column as the data to sort, or data from multiple
	 * columns.
	 * <p>
	 * A common example of this is a table which contains first and last name columns next to each other, it is intuitive that they would
	 * be linked together to multi-column sort. Another example, with a single column, is the case where the data shown to the end user is
	 * not directly sortable itself (a column with images in it), but there is some meta data than can be sorted (e.g. file name) - note
	 * that orthogonal data is an alternative method that can be used for this.
	 */
	private Set<Integer> orderData;
	/**
	 * Description
	 * DataTables' primary order method (the ordering feature) makes use of data that has been cached in memory rather than reading the
	 * data directly from the DOM every time an order is performed for performance reasons (reading from the DOM is inherently slow).
	 * However, there are times when you do actually want to read directly from the DOM, acknowledging that there will be a performance
	 * hit, for example when you have form elements in the table and the end user can alter the values. This configuration option is
	 * provided to allow plug-ins to provide this capability in DataTables.
	 * <p>
	 * Please note that there are no columns.orderDataType plug-ins built into DataTables, they must be added separately. See the
	 * DataTables sorting plug-ins page for further information.
	 */
	private Set<DataTablesSortables> orderDataType;
	/**
	 * Description
	 * You can control the default ordering direction, and even alter the behaviour of the order handler (i.e. only allow ascending
	 * sorting etc) using this parameter.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 * Default
	 * Value: [ 'asc', 'desc' ]
	 */
	private List<DataTableSorts> orderSequence;
	/**
	 * Allows this column to be searchable
	 */
	private Boolean searchable;
	/**
	 * Description
	 * The titles of columns are typically read directly from the DOM (from the cells in the THEAD element), but it can often be useful to
	 * either override existing values, or have DataTables actually construct a header with column titles for you (for example if there is
	 * not THEAD element in the table before DataTables is constructed). This option is available to provide that ability.
	 * <p>
	 * Please note that when constructing a header, DataTables can only construct a simple header with a single cell for each column.
	 * Complex headers with colspan and rowspan attributes must either already be defined in the document, or be constructed using
	 * standard DOM / jQuery methods.
	 */
	private String title;
	/**
	 * escription
	 * DataTables and show and hide columns dynamically through use of this option and the column().visible() / columns().visible()
	 * methods. This option can be used to get the initial visibility state of the column, with the API methods used to alter that state
	 * at a later time.
	 * <p>
	 * This can be particularly useful if your table holds a large number of columns and you wish the user to have the ability to control
	 * which columns they can see, or you have data in the table that the end user shouldn't see (for example a database ID column).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 */
	private Boolean visible;
	/**
	 * Description
	 * This parameter can be used to define the width of a column, and may take any CSS value (3em, 20px etc).
	 * <p>
	 * Please note that pixel perfect column width is virtually impossible to achieve in tables with dynamic content, so do not be
	 * surprised if the width of the column if off by a few pixels from what you assign using this property. Column width in tables
	 * depends upon many properties such as cell borders, table borders, the border-collapse property, the content of the table and many
	 * other properties. Both DataTables and the browsers attempt to lay the table out in an optimal manner taking this options all into
	 * account.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 * Default
	 * Auto-detected from the table's content.
	 */
	private Integer width;
	/**
	 * columns.responsivePrioritySince: Responsive Responsive 2.0.0
	 * Set column's visibility priority. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * Responsive will automatically remove columns from the right-hand-side of the table when it needs to hide columns when a table is
	 * too wide for a given display. Although this is a useful default, this behaviour might not always suit your needs and you want to
	 * control the order in which columns are hidden. This parameter provides that ability by setting a visibility priority order.
	 * <p>
	 * The value given will set the column's visibility priority with a lower number representing a higher priority in terms of staying
	 * visible in the table. For example a column with a priority of 2 will be removed from the display before a column with priority 1,
	 * regardless of the order that they appear in the table.
	 * <p>
	 * This can be particularly useful for cases where you wish to keep the right hand column(s) visible if they contain action buttons or
	 * other important information.
	 * <p>
	 * The column priority can also be defined by a data-priority attribute on the column's header cell (for example <th
	 * data-priority="1">First name</th>). If both a data-priority attribute and a columns.responsivePriority value has been set for a
	 * single column, the columns.responsivePriority value will always be used.
	 */
	private Integer responsivePriority;

	/**
	 * This columnDefs.targets option provides the information required by DataTables for which columns in the table the column definition
	 * object should be applied.
	 * <p>
	 * It can be:
	 * <p>
	 * 0 or a positive integer - column index counting from the left
	 * A negative integer - column index counting from the right
	 * A string - class name will be matched on the TH for the column (without a leading .)
	 * The string "_all" - all columns (i.e. assign a default)
	 * Additionally, targets can be either a single option from the list above, or an array of options (the different types can be mixed
	 * in the array if required). For example targets: [ -1, -2 ] would target the last and second last columns in the table.
	 *
	 * @param name
	 */
	public DataTableColumnOptions(@NotNull String name)
	{
		this.name = name;
	}

	/**
	 * @return
	 */
	@NotNull
	public String getName()
	{
		return name;
	}

	@SuppressWarnings({"unchecked"})
	@NotNull
	public J setName(String name)
	{
		this.name = name;
		return (J) this;
	}

	/**
	 * This columnDefs.targets option provides the information required by DataTables for which columns in the table the column definition
	 * object should be applied.
	 * <p>
	 * It can be:
	 * <p>
	 * 0 or a positive integer - column index counting from the left
	 * A negative integer - column index counting from the right
	 * A string - class name will be matched on the TH for the column (without a leading .)
	 * The string "_all" - all columns (i.e. assign a default)
	 * Additionally, targets can be either a single option from the list above, or an array of options (the different types can be mixed
	 * in the array if required). For example targets: [ -1, -2 ] would target the last and second last columns in the table.
	 *
	 * @return
	 */
	public Integer getTargets()
	{
		return targets;
	}

	/**
	 * This columnDefs.targets option provides the information required by DataTables for which columns in the table the column definition
	 * object should be applied.
	 * <p>
	 * It can be:
	 * <p>
	 * 0 or a positive integer - column index counting from the left
	 * A negative integer - column index counting from the right
	 * A string - class name will be matched on the TH for the column (without a leading .)
	 * The string "_all" - all columns (i.e. assign a default)
	 * Additionally, targets can be either a single option from the list above, or an array of options (the different types can be mixed
	 * in the array if required). For example targets: [ -1, -2 ] would target the last and second last columns in the table.
	 *
	 * @param targets
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setTargets(Integer targets)
	{
		this.targets = targets;
		return (J) this;
	}

	/**
	 * Change the cell type created for the column - either TD cells or TH cells.
	 * <p>
	 * This can be useful as TH cells have semantic meaning in the table body, allowing them to act as a header for a row (you may wish to
	 * add scope='row' to the TH elements using columns.createdCell option).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 * Default
	 *
	 * @return
	 */
	public ComponentTypes getCellType()
	{
		return cellType;
	}

	/**
	 * Change the cell type created for the column - either TD cells or TH cells.
	 * <p>
	 * This can be useful as TH cells have semantic meaning in the table body, allowing them to act as a header for a row (you may wish to
	 * add scope='row' to the TH elements using columns.createdCell option).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 * Default
	 *
	 * @param cellType
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setCellType(ComponentTypes cellType)
	{
		this.cellType = cellType;
		return (J) this;
	}

	/**
	 * Description
	 * Quite simply this option adds a class to each cell in a column, regardless of if the table source is from DOM, Javascript or Ajax.
	 * This can be useful for styling columns.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 *
	 * @return
	 */
	public String getClassName()
	{
		return className;
	}

	/**
	 * Description
	 * Quite simply this option adds a class to each cell in a column, regardless of if the table source is from DOM, Javascript or Ajax.
	 * This can be useful for styling columns.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 *
	 * @param className
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setClassName(String className)
	{
		this.className = className;
		return (J) this;
	}

	/**
	 * Use mmm or iii
	 * Description
	 * The first thing to say about this property is that generally you shouldn't need this!
	 * <p>
	 * Having said that, it can be useful on rare occasions. When DataTables calculates the column widths to assign to each column, it
	 * finds the longest string in each column and then constructs a temporary table and reads the widths from that. The problem with this
	 * is that "mmm" is much wider then "iiii", but the latter is a longer string - thus the calculation can go wrong (doing it properly
	 * and putting it into an DOM object and measuring that is horribly slow!). Thus as a "work around" we provide this option. It will
	 * append its value to the text that is found to be the longest string for the column - i.e. padding.
	 *
	 * @return
	 */
	public String getContentPadding()
	{
		return contentPadding;
	}

	/**
	 * Use mmm or iii
	 * <p>
	 * Description
	 * The first thing to say about this property is that generally you shouldn't need this!
	 * <p>
	 * Having said that, it can be useful on rare occasions. When DataTables calculates the column widths to assign to each column, it
	 * finds the longest string in each column and then constructs a temporary table and reads the widths from that. The problem with this
	 * is that "mmm" is much wider then "iiii", but the latter is a longer string - thus the calculation can go wrong (doing it properly
	 * and putting it into an DOM object and measuring that is horribly slow!). Thus as a "work around" we provide this option. It will
	 * append its value to the text that is found to be the longest string for the column - i.e. padding.
	 *
	 * @param contentPadding
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setContentPadding(String contentPadding)
	{
		this.contentPadding = contentPadding;
		return (J) this;
	}

	@JsonProperty("defaultContent")
	@SuppressWarnings("unused")
	private String getDefaultContentJson()
	{
		if (defaultContent == null)
		{ return null; }
		defaultContent.setTiny(true);
		return defaultContent.toString(0);
	}

	/**
	 * Description
	 * Often you may wish to have static content in a column, for example simple edit and / or delete buttons, which have events assigned
	 * to them. This option is available for those use cases - creating static content for a column. If you wish to create dynamic content
	 * (i.e. based on other data in the row), the columns.render option should be used.
	 * <p>
	 * Additionally, this option can be useful when loading JSON data, as the value set here will be used if the cell value from the JSON
	 * is found to be null (for example, you might set a default string of Not available.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 *
	 * @return
	 */
	public ComponentHierarchyBase getDefaultContent()
	{
		return defaultContent;
	}

	/**
	 * Description
	 * Often you may wish to have static content in a column, for example simple edit and / or delete buttons, which have events assigned
	 * to them. This option is available for those use cases - creating static content for a column. If you wish to create dynamic content
	 * (i.e. based on other data in the row), the columns.render option should be used.
	 * <p>
	 * Additionally, this option can be useful when loading JSON data, as the value set here will be used if the cell value from the JSON
	 * is found to be null (for example, you might set a default string of Not available.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 *
	 * @param defaultContent
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setDefaultContent(ComponentHierarchyBase defaultContent)
	{
		this.defaultContent = defaultContent;
		return (J) this;
	}

	/**
	 * Description
	 * Using this parameter, you can remove the end user's ability to order upon a column. This might be useful for generated content
	 * columns, for example if you have 'Edit' or 'Delete' buttons in the table.
	 * <p>
	 * Note that this option only effects the end user's ability to order a column. Developers are still able to order a column using the
	 * order option or the order() method if required.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 *
	 * @return
	 */
	public Boolean getOrderable()
	{
		return orderable;
	}

	/**
	 * Description
	 * Using this parameter, you can remove the end user's ability to order upon a column. This might be useful for generated content
	 * columns, for example if you have 'Edit' or 'Delete' buttons in the table.
	 * <p>
	 * Note that this option only effects the end user's ability to order a column. Developers are still able to order a column using the
	 * order option or the order() method if required.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 *
	 * @param orderable
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setOrderable(Boolean orderable)
	{
		this.orderable = orderable;
		return (J) this;
	}

	/**
	 * Description
	 * Allows a column's sorting to take either the data from a different (often hidden) column as the data to sort, or data from multiple
	 * columns.
	 * <p>
	 * A common example of this is a table which contains first and last name columns next to each other, it is intuitive that they would
	 * be linked together to multi-column sort. Another example, with a single column, is the case where the data shown to the end user is
	 * not directly sortable itself (a column with images in it), but there is some meta data than can be sorted (e.g. file name) - note
	 * that orthogonal data is an alternative method that can be used for this.
	 *
	 * @return
	 */
	public Set<Integer> getOrderData()
	{
		if (orderData == null)
		{
			orderData = new LinkedHashSet<>();
		}
		return orderData;
	}

	/**
	 * Description
	 * Allows a column's sorting to take either the data from a different (often hidden) column as the data to sort, or data from multiple
	 * columns.
	 * <p>
	 * A common example of this is a table which contains first and last name columns next to each other, it is intuitive that they would
	 * be linked together to multi-column sort. Another example, with a single column, is the case where the data shown to the end user is
	 * not directly sortable itself (a column with images in it), but there is some meta data than can be sorted (e.g. file name) - note
	 * that orthogonal data is an alternative method that can be used for this.
	 *
	 * @param orderData
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setOrderData(Set<Integer> orderData)
	{
		this.orderData = orderData;
		return (J) this;
	}

	/**
	 * Description
	 * DataTables' primary order method (the ordering feature) makes use of data that has been cached in memory rather than reading the
	 * data directly from the DOM every time an order is performed for performance reasons (reading from the DOM is inherently slow).
	 * However, there are times when you do actually want to read directly from the DOM, acknowledging that there will be a performance
	 * hit, for example when you have form elements in the table and the end user can alter the values. This configuration option is
	 * provided to allow plug-ins to provide this capability in DataTables.
	 * <p>
	 * Please note that there are no columns.orderDataType plug-ins built into DataTables, they must be added separately. See the
	 * DataTables sorting plug-ins page for further information.
	 *
	 * @return
	 */
	public Set<DataTablesSortables> getOrderDataType()
	{
		if (orderDataType == null)
		{
			orderDataType = new LinkedHashSet<>();
		}
		return orderDataType;
	}

	/**
	 * Description
	 * DataTables' primary order method (the ordering feature) makes use of data that has been cached in memory rather than reading the
	 * data directly from the DOM every time an order is performed for performance reasons (reading from the DOM is inherently slow).
	 * However, there are times when you do actually want to read directly from the DOM, acknowledging that there will be a performance
	 * hit, for example when you have form elements in the table and the end user can alter the values. This configuration option is
	 * provided to allow plug-ins to provide this capability in DataTables.
	 * <p>
	 * Please note that there are no columns.orderDataType plug-ins built into DataTables, they must be added separately. See the
	 * DataTables sorting plug-ins page for further information.
	 *
	 * @param orderDataType
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setOrderDataType(Set<DataTablesSortables> orderDataType)
	{
		this.orderDataType = orderDataType;
		return (J) this;
	}

	/**
	 * Description
	 * You can control the default ordering direction, and even alter the behaviour of the order handler (i.e. only allow ascending
	 * sorting etc) using this parameter.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 * Default
	 * Value: [ 'asc', 'desc' ]
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public List<DataTableSorts> getOrderSequence()
	{
		if (orderSequence == null)
		{
			orderSequence = new ArrayList<>();
		}
		return orderSequence;
	}

	/**
	 * Description
	 * You can control the default ordering direction, and even alter the behaviour of the order handler (i.e. only allow ascending
	 * sorting etc) using this parameter.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * array
	 * Default
	 * Value: [ 'asc', 'desc' ]
	 *
	 * @param orderSequence
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setOrderSequence(List<DataTableSorts> orderSequence)
	{
		this.orderSequence = orderSequence;
		return (J) this;
	}

	/**
	 * Description
	 * Using this parameter, you can defined if DataTables should include this column in the filterable data in the table. You may want
	 * use this option to display filtering on generated columns such as 'Edit' and 'Delete' buttons for example.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 *
	 * @return
	 */
	public Boolean getSearchable()
	{
		return searchable;
	}

	/**
	 * Description
	 * Using this parameter, you can defined if DataTables should include this column in the filterable data in the table. You may want
	 * use this option to display filtering on generated columns such as 'Edit' and 'Delete' buttons for example.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 *
	 * @param searchable
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setSearchable(Boolean searchable)
	{
		this.searchable = searchable;
		return (J) this;
	}

	/**
	 * Description
	 * The titles of columns are typically read directly from the DOM (from the cells in the THEAD element), but it can often be useful to
	 * either override existing values, or have DataTables actually construct a header with column titles for you (for example if there is
	 * not THEAD element in the table before DataTables is constructed). This option is available to provide that ability.
	 * <p>
	 * Please note that when constructing a header, DataTables can only construct a simple header with a single cell for each column.
	 * Complex headers with colspan and rowspan attributes must either already be defined in the document, or be constructed using
	 * standard DOM / jQuery methods.
	 *
	 * @return
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Description
	 * The titles of columns are typically read directly from the DOM (from the cells in the THEAD element), but it can often be useful to
	 * either override existing values, or have DataTables actually construct a header with column titles for you (for example if there is
	 * not THEAD element in the table before DataTables is constructed). This option is available to provide that ability.
	 * <p>
	 * Please note that when constructing a header, DataTables can only construct a simple header with a single cell for each column.
	 * Complex headers with colspan and rowspan attributes must either already be defined in the document, or be constructed using
	 * standard DOM / jQuery methods.
	 *
	 * @param title
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setTitle(String title)
	{
		this.title = title;
		return (J) this;
	}

	/**
	 * Description
	 * DataTables and show and hide columns dynamically through use of this option and the column().visible() / columns().visible()
	 * methods. This option can be used to get the initial visibility state of the column, with the API methods used to alter that state
	 * at a later time.
	 * <p>
	 * This can be particularly useful if your table holds a large number of columns and you wish the user to have the ability to control
	 * which columns they can see, or you have data in the table that the end user shouldn't see (for example a database ID column).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 *
	 * @return
	 */
	public Boolean getVisible()
	{
		return visible;
	}

	/**
	 * Description
	 * DataTables and show and hide columns dynamically through use of this option and the column().visible() / columns().visible()
	 * methods. This option can be used to get the initial visibility state of the column, with the API methods used to alter that state
	 * at a later time.
	 * <p>
	 * This can be particularly useful if your table holds a large number of columns and you wish the user to have the ability to control
	 * which columns they can see, or you have data in the table that the end user shouldn't see (for example a database ID column).
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 *
	 * @param visible
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setVisible(Boolean visible)
	{
		this.visible = visible;
		return (J) this;
	}

	/**
	 * Description
	 * This parameter can be used to define the width of a column, and may take any CSS value (3em, 20px etc).
	 * <p>
	 * Please note that pixel perfect column width is virtually impossible to achieve in tables with dynamic content, so do not be
	 * surprised if the width of the column if off by a few pixels from what you assign using this property. Column width in tables
	 * depends upon many properties such as cell borders, table borders, the border-collapse property, the content of the table and many
	 * other properties. Both DataTables and the browsers attempt to lay the table out in an optimal manner taking this options all into
	 * account.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 * Default
	 * Auto-detected from the table's content.
	 *
	 * @return
	 */
	public Integer getWidth()
	{
		return width;
	}

	/**
	 * Description
	 * This parameter can be used to define the width of a column, and may take any CSS value (3em, 20px etc).
	 * <p>
	 * Please note that pixel perfect column width is virtually impossible to achieve in tables with dynamic content, so do not be
	 * surprised if the width of the column if off by a few pixels from what you assign using this property. Column width in tables
	 * depends upon many properties such as cell borders, table borders, the border-collapse property, the content of the table and many
	 * other properties. Both DataTables and the browsers attempt to lay the table out in an optimal manner taking this options all into
	 * account.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 * Default
	 * Auto-detected from the table's content.
	 *
	 * @param width
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setWidth(Integer width)
	{
		this.width = width;
		return (J) this;
	}

	/**
	 * columns.responsivePrioritySince: Responsive Responsive 2.0.0
	 * Set column's visibility priority. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * Responsive will automatically remove columns from the right-hand-side of the table when it needs to hide columns when a table is
	 * too wide for a given display. Although this is a useful default, this behaviour might not always suit your needs and you want to
	 * control the order in which columns are hidden. This parameter provides that ability by setting a visibility priority order.
	 * <p>
	 * The value given will set the column's visibility priority with a lower number representing a higher priority in terms of staying
	 * visible in the table. For example a column with a priority of 2 will be removed from the display before a column with priority 1,
	 * regardless of the order that they appear in the table.
	 * <p>
	 * This can be particularly useful for cases where you wish to keep the right hand column(s) visible if they contain action buttons or
	 * other important information.
	 * <p>
	 * The column priority can also be defined by a data-priority attribute on the column's header cell (for example <th
	 * data-priority="1">First name</th>). If both a data-priority attribute and a columns.responsivePriority value has been set for a
	 * single column, the columns.responsivePriority value will always be used.
	 *
	 * @return
	 */
	public Integer getResponsivePriority()
	{
		return responsivePriority;
	}

	/**
	 * columns.responsivePrioritySince: Responsive Responsive 2.0.0
	 * Set column's visibility priority. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * Responsive will automatically remove columns from the right-hand-side of the table when it needs to hide columns when a table is
	 * too wide for a given display. Although this is a useful default, this behaviour might not always suit your needs and you want to
	 * control the order in which columns are hidden. This parameter provides that ability by setting a visibility priority order.
	 * <p>
	 * The value given will set the column's visibility priority with a lower number representing a higher priority in terms of staying
	 * visible in the table. For example a column with a priority of 2 will be removed from the display before a column with priority 1,
	 * regardless of the order that they appear in the table.
	 * <p>
	 * This can be particularly useful for cases where you wish to keep the right hand column(s) visible if they contain action buttons or
	 * other important information.
	 * <p>
	 * The column priority can also be defined by a data-priority attribute on the column's header cell (for example <th
	 * data-priority="1">First name</th>). If both a data-priority attribute and a columns.responsivePriority value has been set for a
	 * single column, the columns.responsivePriority value will always be used.
	 *
	 * @param responsivePriority
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setResponsivePriority(Integer responsivePriority)
	{
		this.responsivePriority = responsivePriority;
		return (J) this;
	}
}
