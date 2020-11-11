package com.jwebmp.plugins.datatable.options;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.datatable.enumerations.DataTablesSelectItems;
import com.jwebmp.plugins.datatable.enumerations.DataTablesSelectStyles;

import jakarta.validation.constraints.NotNull;

/**
 * selectSince: Select 1.0.0
 * Select configuration object. Please note - this property requires the Select extension for DataTables.
 * <p>
 * Description
 * This option can be used to configure the Select extension for DataTables during the initialisation of a DataTable.
 * <p>
 * When Select has been loaded on a page, all DataTables on that page have the ability to have items selected, but by default this can
 * only be done through the API - i.e. the end user will have no ability to select items in a table by default. To enable end user
 * selection, this option should be used (the select.style() method can also be used after initialisation).
 * <p>
 * Exactly what selection the user can make and how depends upon the options selected.
 *
 * @param <J>
 */
public class DataTablesSelectOptions<J extends DataTablesSelectOptions<J>>
		extends JavaScriptPart<J>
{

	/**
	 * select.blurableSince: Select 1.0.0
	 * Indicate if the selected items will be removed when clicking outside of the table. Please note - this property requires the Select
	 * extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to have a table act like a select list whereby any items that are selected will be automatically
	 * deselected when clicking outside of a DataTable. This can be useful to make a table "feel" more like a native operating system
	 * control, or if you have multiple tables on a page where only one should have selection at a time.
	 * <p>
	 * Type
	 * boolean
	 * Description:
	 * Enable the blurable option of Select (true) or not (false).
	 */
	private Boolean blurable;
	/**
	 * select.classNameSince: Select 1.1.0
	 * Set the class name that will be applied to selected items. Please note - this property requires the Select extension for DataTables.
	 * <p>
	 * Description
	 * Which items are selected in a table, Select will add a class to the item so it can be appropriately highlighted by CSS to show the
	 * end user that the item has been selected
	 * <p>
	 * The Select and DataTables style sheets have appropriate classes to perform this action, however it can often be useful to be able
	 * to specify your own class to perform your own custom highlighting. This option provides that ability.
	 */
	private String className;
	/**
	 * select.infoSince: Select 1.0.0
	 * Enable / disable the display for item selection information in the table summary. Please note - this property requires the Select
	 * extension for DataTables.
	 * <p>
	 * Description
	 * Select has the ability to show the end user summary information about the items they have selected in a table - the number of rows
	 * for example. This option can be used to enable / disable that action.
	 * <p>
	 * When enabled and information is shown the following markup is added to the table's information element:
	 */
	private Boolean info;
	/**
	 * select.itemsSince: Select 1.0.0
	 * Set which table items to select (rows, columns or cells). Please note - this property requires the Select extension for DataTables.
	 * <p>
	 * Description
	 * Select has the ability to select rows, columns or cells in a DataTable. As well as being able to select each table element type you
	 * can also combine the selection to have multiple different item types selected at the same time.
	 * <p>
	 * This option provides the ability to define which table item type will be selected by user interaction with a mouse. The items to be
	 * selected can also be defined at run time using the select.items() method.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * This option can take one of the following values:
	 * <p>
	 * row - select rows
	 * column - select columns
	 * cell - select cells
	 */
	private DataTablesSelectItems items;
	/**
	 * select.selectorSince: Select 1.0.0
	 * Set the element selector used for mouse event capture to select items. Please note - this property requires the Select extension
	 * for DataTables.
	 * <p>
	 * Description
	 * By default when item selection is active (select.style set to anything other than api), Select will select items based on any cell
	 * in the table when it is clicked. However, at times it can be useful to limit this selection to certain cells (based on column for
	 * example), which can be done through this option.
	 * <p>
	 * It is a simple jQuery selector string that is used to attach the event listeners that Select adds to the table.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * jQuery selector that will select the cells that can trigger item selection.
	 */
	private String selector;
	/**
	 * select.styleSince: Select 1.0.0
	 * Set the selection style for end user interaction with the table. Please note - this property requires the Select extension for
	 * DataTables.
	 * <p>
	 * Description
	 * Select provides a number of different built in ways that an end user can interact with the selection of items in the table, which
	 * is controlled by this parameter (and select.style() after initialisation).
	 * <p>
	 * The default mode of operation is based on the selection of files in modern operating systems with the ctrl/cmd and shift keys can
	 * be user to provide complex operations.
	 * <p>
	 * Note that while the api option disables item selection via Select's built in event handler, it is quote possible to use the API to
	 * still provide the end user with the ability to select / deselect items based on your own event handlers.
	 */
	private DataTablesSelectStyles style;

	/**
	 * selectSince: Select 1.0.0
	 * Select configuration object. Please note - this property requires the Select extension for DataTables.
	 * <p>
	 * Description
	 * This option can be used to configure the Select extension for DataTables during the initialisation of a DataTable.
	 * <p>
	 * When Select has been loaded on a page, all DataTables on that page have the ability to have items selected, but by default this can
	 * only be done through the API - i.e. the end user will have no ability to select items in a table by default. To enable end user
	 * selection, this option should be used (the select.style() method can also be used after initialisation).
	 * <p>
	 * Exactly what selection the user can make and how depends upon the options selected.
	 */
	public DataTablesSelectOptions()
	{
		//No config required
	}

	/**
	 * select.blurableSince: Select 1.0.0
	 * Indicate if the selected items will be removed when clicking outside of the table. Please note - this property requires the Select
	 * extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to have a table act like a select list whereby any items that are selected will be automatically
	 * deselected when clicking outside of a DataTable. This can be useful to make a table "feel" more like a native operating system
	 * control, or if you have multiple tables on a page where only one should have selection at a time.
	 * <p>
	 * Type
	 * boolean
	 * Description:
	 * Enable the blurable option of Select (true) or not (false).
	 *
	 * @return
	 */
	public Boolean getBlurable()
	{
		return blurable;
	}

	/**
	 * select.blurableSince: Select 1.0.0
	 * Indicate if the selected items will be removed when clicking outside of the table. Please note - this property requires the Select
	 * extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to have a table act like a select list whereby any items that are selected will be automatically
	 * deselected when clicking outside of a DataTable. This can be useful to make a table "feel" more like a native operating system
	 * control, or if you have multiple tables on a page where only one should have selection at a time.
	 * <p>
	 * Type
	 * boolean
	 * Description:
	 * Enable the blurable option of Select (true) or not (false).
	 *
	 * @param blurable
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setBlurable(Boolean blurable)
	{
		this.blurable = blurable;
		return (J) this;
	}

	/**
	 * select.classNameSince: Select 1.1.0
	 * Set the class name that will be applied to selected items. Please note - this property requires the Select extension for DataTables.
	 * <p>
	 * Description
	 * Which items are selected in a table, Select will add a class to the item so it can be appropriately highlighted by CSS to show the
	 * end user that the item has been selected
	 * <p>
	 * The Select and DataTables style sheets have appropriate classes to perform this action, however it can often be useful to be able
	 * to specify your own class to perform your own custom highlighting. This option provides that ability.
	 *
	 * @return
	 */
	public String getClassName()
	{
		return className;
	}

	/**
	 * select.classNameSince: Select 1.1.0
	 * Set the class name that will be applied to selected items. Please note - this property requires the Select extension for DataTables.
	 * <p>
	 * Description
	 * Which items are selected in a table, Select will add a class to the item so it can be appropriately highlighted by CSS to show the
	 * end user that the item has been selected
	 * <p>
	 * The Select and DataTables style sheets have appropriate classes to perform this action, however it can often be useful to be able
	 * to specify your own class to perform your own custom highlighting. This option provides that ability.
	 *
	 * @param className
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setClassName(String className)
	{
		this.className = className;
		return (J) this;
	}

	/**
	 * select.infoSince: Select 1.0.0
	 * Enable / disable the display for item selection information in the table summary. Please note - this property requires the Select
	 * extension for DataTables.
	 * <p>
	 * Description
	 * Select has the ability to show the end user summary information about the items they have selected in a table - the number of rows
	 * for example. This option can be used to enable / disable that action.
	 * <p>
	 * When enabled and information is shown the following markup is added to the table's information element:
	 *
	 * @return
	 */
	public Boolean getInfo()
	{
		return info;
	}

	/**
	 * select.infoSince: Select 1.0.0
	 * Enable / disable the display for item selection information in the table summary. Please note - this property requires the Select
	 * extension for DataTables.
	 * <p>
	 * Description
	 * Select has the ability to show the end user summary information about the items they have selected in a table - the number of rows
	 * for example. This option can be used to enable / disable that action.
	 * <p>
	 * When enabled and information is shown the following markup is added to the table's information element:
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
	 * select.itemsSince: Select 1.0.0
	 * Set which table items to select (rows, columns or cells). Please note - this property requires the Select extension for DataTables.
	 * <p>
	 * Description
	 * Select has the ability to select rows, columns or cells in a DataTable. As well as being able to select each table element type you
	 * can also combine the selection to have multiple different item types selected at the same time.
	 * <p>
	 * This option provides the ability to define which table item type will be selected by user interaction with a mouse. The items to be
	 * selected can also be defined at run time using the select.items() method.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * This option can take one of the following values:
	 * <p>
	 * row - select rows
	 * column - select columns
	 * cell - select cells
	 *
	 * @return
	 */
	public DataTablesSelectItems getItems()
	{
		return items;
	}

	/**
	 * select.itemsSince: Select 1.0.0
	 * Set which table items to select (rows, columns or cells). Please note - this property requires the Select extension for DataTables.
	 * <p>
	 * Description
	 * Select has the ability to select rows, columns or cells in a DataTable. As well as being able to select each table element type you
	 * can also combine the selection to have multiple different item types selected at the same time.
	 * <p>
	 * This option provides the ability to define which table item type will be selected by user interaction with a mouse. The items to be
	 * selected can also be defined at run time using the select.items() method.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * This option can take one of the following values:
	 * <p>
	 * row - select rows
	 * column - select columns
	 * cell - select cells
	 *
	 * @param items
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setItems(DataTablesSelectItems items)
	{
		this.items = items;
		return (J) this;
	}

	/**
	 * select.selectorSince: Select 1.0.0
	 * Set the element selector used for mouse event capture to select items. Please note - this property requires the Select extension
	 * for DataTables.
	 * <p>
	 * Description
	 * By default when item selection is active (select.style set to anything other than api), Select will select items based on any cell
	 * in the table when it is clicked. However, at times it can be useful to limit this selection to certain cells (based on column for
	 * example), which can be done through this option.
	 * <p>
	 * It is a simple jQuery selector string that is used to attach the event listeners that Select adds to the table.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * jQuery selector that will select the cells that can trigger item selection.
	 *
	 * @return
	 */
	public String getSelector()
	{
		return selector;
	}

	/**
	 * select.selectorSince: Select 1.0.0
	 * Set the element selector used for mouse event capture to select items. Please note - this property requires the Select extension
	 * for DataTables.
	 * <p>
	 * Description
	 * By default when item selection is active (select.style set to anything other than api), Select will select items based on any cell
	 * in the table when it is clicked. However, at times it can be useful to limit this selection to certain cells (based on column for
	 * example), which can be done through this option.
	 * <p>
	 * It is a simple jQuery selector string that is used to attach the event listeners that Select adds to the table.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * jQuery selector that will select the cells that can trigger item selection.
	 *
	 * @param selector
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSelector(String selector)
	{
		this.selector = selector;
		return (J) this;
	}

	/**
	 * select.styleSince: Select 1.0.0
	 * Set the selection style for end user interaction with the table. Please note - this property requires the Select extension for
	 * DataTables.
	 * <p>
	 * Description
	 * Select provides a number of different built in ways that an end user can interact with the selection of items in the table, which
	 * is controlled by this parameter (and select.style() after initialisation).
	 * <p>
	 * The default mode of operation is based on the selection of files in modern operating systems with the ctrl/cmd and shift keys can
	 * be user to provide complex operations.
	 * <p>
	 * Note that while the api option disables item selection via Select's built in event handler, it is quote possible to use the API to
	 * still provide the end user with the ability to select / deselect items based on your own event handlers.
	 *
	 * @return
	 */
	public DataTablesSelectStyles getStyle()
	{
		return style;
	}

	/**
	 * select.styleSince: Select 1.0.0
	 * Set the selection style for end user interaction with the table. Please note - this property requires the Select extension for
	 * DataTables.
	 * <p>
	 * Description
	 * Select provides a number of different built in ways that an end user can interact with the selection of items in the table, which
	 * is controlled by this parameter (and select.style() after initialisation).
	 * <p>
	 * The default mode of operation is based on the selection of files in modern operating systems with the ctrl/cmd and shift keys can
	 * be user to provide complex operations.
	 * <p>
	 * Note that while the api option disables item selection via Select's built in event handler, it is quote possible to use the API to
	 * still provide the end user with the ability to select / deselect items based on your own event handlers.
	 *
	 * @param style
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setStyle(DataTablesSelectStyles style)
	{
		this.style = style;
		return (J) this;
	}
}
