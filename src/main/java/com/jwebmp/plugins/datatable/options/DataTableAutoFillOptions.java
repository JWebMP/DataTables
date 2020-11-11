package com.jwebmp.plugins.datatable.options;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.datatable.enumerations.DataTableAutoFillFocusType;

import jakarta.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Spreadsheets such as Excel and Google Docs have a very handy data duplication option of an auto fill tool. The AutoFill library for
 * DataTables provides a similar interface for DataTables and extends upon this interface paradigm to provide complex data interaction
 * options that the user can select between.
 * <p>
 * Description
 * This option provides the ability to enable and configure AutoFill for DataTables. In its simplest form as the boolean true it will
 * enable AutoFill with the default configuration options (as defined by $.fn.dataTable.AutoFill.defaults). It can also be used as an
 * object to provide custom configuration options as described below.
 *
 * @param <J>
 */
public class DataTableAutoFillOptions<J extends DataTableAutoFillOptions<J>>
		extends JavaScriptPart<J>
{


	/**
	 * Description
	 * When an auto fill is completed by the end user, AutoFill will determine how many data fill plug-ins can be used for the data that
	 * has been dragged over. If there are multiple options it will display a list of those options to the end user allowing them to
	 * select the action to perform - a cancel button is also shown.
	 * <p>
	 * By default, if there is only a single data fill plug-in that can operate on the data, it will be immediately acted upon, no
	 * confirmation required by the end user and no option to cancel the action.
	 * <p>
	 * This option can be used to force AutoFill to confirm the action to take, even if there is only one option. This provides the end
	 * user with the ability to cancel the action if they made a mistake during the drag.
	 */
	private Boolean alwaysAsk;
	/**
	 * Description
	 * When working with complex tables it is not uncommon to have certain columns that you might not wish to allow a data fill on - for
	 * example a checkbox column that is used for row selection or a column with editing action buttons. This option can be used to define
	 * which columns can be auto filled. If a column cannot be auto filled, cells in it will not show the fill drag handle and will not be
	 * selectable during a drag.
	 * <p>
	 * Please note that only visible cells can be auto filled, so the columns defined by this option are automatically merged with the
	 * visible columns in the table. Non-visible columns will cannot be auto filled.
	 */
	private Set<Integer> columns;

	/**
	 * Description
	 * It can be useful to disable AutoFill's user input controls at certain times, depending on the state of your application. This
	 * option provides that ability when the table is initially created, while the autoFill().enable() and autoFill().disable() methods
	 * provide the option to enabling the user interaction after the table has been created.
	 */
	private Boolean enable;
	/**
	 * Description
	 * The click-to-drag auto fill drag handle can be attached to the table cells using a number of different methods, depending on how
	 * you wish the end user to interact with your table. This option provides the ability to switch between the various options which are
	 * detailed below.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * Action that will cause the drag handle to appear in a cell. It can be one of:
	 * <p>
	 * click - Display when a cell is clicked upon
	 * focus - Display when a cell gains focus - for integration with KeyTable
	 * hover - Display when a cell is hovered over
	 * null - Automatic detection - focus if KeyTable is enabled on a table and hover otherwise.
	 */
	private DataTableAutoFillFocusType focus;
	/**
	 * Description
	 * At the end of a fill action you will typically wish to take some action to reflect the change from the data fill. By default
	 * AutoFill will write the filled values to the DataTable and then redraw the table to account for any changes in ordering.
	 * <p>
	 * This action is not always desirable, particularly if you are using server-side processing or which to have an external process
	 * update the data. In such circumstances this option can be used to disable the automatic data update and draw.
	 * <p>
	 * Type
	 * boolean
	 * Description:
	 * true - DataTables data is automatically updated as a result of the auto fill action and the table redrawn.
	 * false - No data update or draw is performed.
	 */
	private Boolean update;

	/**
	 * Spreadsheets such as Excel and Google Docs have a very handy data duplication option of an auto fill tool. The AutoFill library for
	 * DataTables provides a similar interface for DataTables and extends upon this interface paradigm to provide complex data interaction
	 * options that the user can select between.
	 * <p>
	 * Description
	 * This option provides the ability to enable and configure AutoFill for DataTables. In its simplest form as the boolean true it will
	 * enable AutoFill with the default configuration options (as defined by $.fn.dataTable.AutoFill.defaults). It can also be used as an
	 * object to provide custom configuration options as described below.
	 */
	public DataTableAutoFillOptions()
	{
		//No config required
	}

	/**
	 * Description
	 * When an auto fill is completed by the end user, AutoFill will determine how many data fill plug-ins can be used for the data that
	 * has been dragged over. If there are multiple options it will display a list of those options to the end user allowing them to
	 * select the action to perform - a cancel button is also shown.
	 * <p>
	 * By default, if there is only a single data fill plug-in that can operate on the data, it will be immediately acted upon, no
	 * confirmation required by the end user and no option to cancel the action.
	 * <p>
	 * This option can be used to force AutoFill to confirm the action to take, even if there is only one option. This provides the end
	 * user with the ability to cancel the action if they made a mistake during the drag.
	 *
	 * @return
	 */
	public Boolean getAlwaysAsk()
	{
		return alwaysAsk;
	}

	/**
	 * Description
	 * When an auto fill is completed by the end user, AutoFill will determine how many data fill plug-ins can be used for the data that
	 * has been dragged over. If there are multiple options it will display a list of those options to the end user allowing them to
	 * select the action to perform - a cancel button is also shown.
	 * <p>
	 * By default, if there is only a single data fill plug-in that can operate on the data, it will be immediately acted upon, no
	 * confirmation required by the end user and no option to cancel the action.
	 * <p>
	 * This option can be used to force AutoFill to confirm the action to take, even if there is only one option. This provides the end
	 * user with the ability to cancel the action if they made a mistake during the drag.
	 *
	 * @param alwaysAsk
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setAlwaysAsk(Boolean alwaysAsk)
	{
		this.alwaysAsk = alwaysAsk;
		return (J) this;
	}

	/**
	 * Description
	 * When working with complex tables it is not uncommon to have certain columns that you might not wish to allow a data fill on - for
	 * example a checkbox column that is used for row selection or a column with editing action buttons. This option can be used to define
	 * which columns can be auto filled. If a column cannot be auto filled, cells in it will not show the fill drag handle and will not be
	 * selectable during a drag.
	 * <p>
	 * Please note that only visible cells can be auto filled, so the columns defined by this option are automatically merged with the
	 * visible columns in the table. Non-visible columns will cannot be auto filled.
	 *
	 * @return
	 */
	public Set<Integer> getColumns()
	{
		if (columns == null)
		{
			columns = new LinkedHashSet<>();
		}
		return columns;
	}

	/**
	 * Description
	 * When working with complex tables it is not uncommon to have certain columns that you might not wish to allow a data fill on - for
	 * example a checkbox column that is used for row selection or a column with editing action buttons. This option can be used to define
	 * which columns can be auto filled. If a column cannot be auto filled, cells in it will not show the fill drag handle and will not be
	 * selectable during a drag.
	 * <p>
	 * Please note that only visible cells can be auto filled, so the columns defined by this option are automatically merged with the
	 * visible columns in the table. Non-visible columns will cannot be auto filled.
	 *
	 * @param columns
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setColumns(Set<Integer> columns)
	{
		this.columns = columns;
		return (J) this;
	}

	/**
	 * Description
	 * It can be useful to disable AutoFill's user input controls at certain times, depending on the state of your application. This
	 * option provides that ability when the table is initially created, while the autoFill().enable() and autoFill().disable() methods
	 * provide the option to enabling the user interaction after the table has been created.
	 *
	 * @return
	 */
	public Boolean getEnable()
	{
		return enable;
	}

	/**
	 * Description
	 * It can be useful to disable AutoFill's user input controls at certain times, depending on the state of your application. This
	 * option provides that ability when the table is initially created, while the autoFill().enable() and autoFill().disable() methods
	 * provide the option to enabling the user interaction after the table has been created.
	 *
	 * @param enable
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setEnable(Boolean enable)
	{
		this.enable = enable;
		return (J) this;
	}

	/**
	 * Description
	 * The click-to-drag auto fill drag handle can be attached to the table cells using a number of different methods, depending on how
	 * you wish the end user to interact with your table. This option provides the ability to switch between the various options which are
	 * detailed below.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * Action that will cause the drag handle to appear in a cell. It can be one of:
	 * <p>
	 * click - Display when a cell is clicked upon
	 * focus - Display when a cell gains focus - for integration with KeyTable
	 * hover - Display when a cell is hovered over
	 * null - Automatic detection - focus if KeyTable is enabled on a table and hover otherwise.
	 *
	 * @return
	 */
	public DataTableAutoFillFocusType getFocus()
	{
		return focus;
	}

	/**
	 * Description
	 * The click-to-drag auto fill drag handle can be attached to the table cells using a number of different methods, depending on how
	 * you wish the end user to interact with your table. This option provides the ability to switch between the various options which are
	 * detailed below.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * Action that will cause the drag handle to appear in a cell. It can be one of:
	 * <p>
	 * click - Display when a cell is clicked upon
	 * focus - Display when a cell gains focus - for integration with KeyTable
	 * hover - Display when a cell is hovered over
	 * null - Automatic detection - focus if KeyTable is enabled on a table and hover otherwise.
	 *
	 * @param focus
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setFocus(DataTableAutoFillFocusType focus)
	{
		this.focus = focus;
		return (J) this;
	}

	/**
	 * Description
	 * At the end of a fill action you will typically wish to take some action to reflect the change from the data fill. By default
	 * AutoFill will write the filled values to the DataTable and then redraw the table to account for any changes in ordering.
	 * <p>
	 * This action is not always desirable, particularly if you are using server-side processing or which to have an external process
	 * update the data. In such circumstances this option can be used to disable the automatic data update and draw.
	 * <p>
	 * Type
	 * boolean
	 * Description:
	 * true - DataTables data is automatically updated as a result of the auto fill action and the table redrawn.
	 * false - No data update or draw is performed.
	 *
	 * @return
	 */
	public Boolean getUpdate()
	{
		return update;
	}

	/**
	 * Description
	 * At the end of a fill action you will typically wish to take some action to reflect the change from the data fill. By default
	 * AutoFill will write the filled values to the DataTable and then redraw the table to account for any changes in ordering.
	 * <p>
	 * This action is not always desirable, particularly if you are using server-side processing or which to have an external process
	 * update the data. In such circumstances this option can be used to disable the automatic data update and draw.
	 * <p>
	 * Type
	 * boolean
	 * Description:
	 * true - DataTables data is automatically updated as a result of the auto fill action and the table redrawn.
	 * false - No data update or draw is performed.
	 *
	 * @param update
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setUpdate(Boolean update)
	{
		this.update = update;
		return (J) this;
	}

}
