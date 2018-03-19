package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * rowReorder
 * Enable and configure the RowReorder extension for DataTables. Please note - this property requires the RowReorder extension for
 * DataTables.
 * <p>
 * Description
 * This option provides the ability to enable and configure RowReorder for DataTables. In its simplest form as the boolean true it will
 * enable RowReorder with the default configuration options (as defined by $.fn.dataTable.RowReorder.defaults). It can also be used as an
 * object to provide custom configuration options as described below.
 * <p>
 * Please note that as with all other configuration options for RowReorder, this option is an extension to the default set of DataTables
 * options. This property should be set in the DataTables initialisation object.
 *
 * @param <J>
 */
public class DataTablesRowReorder<J extends DataTablesRowReorder<J>>
		extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	/**
	 * rowReorder.dataSrc
	 * Configure the data point that will be used for the reordering data. Please note - this property requires the RowReorder extension
	 * for DataTables.
	 * <p>
	 * Description
	 * When rows are reordered, RowReorder will automatically adjust the data in the DataTable to reflect the change made by the
	 * reordering. This option tells RowReorder what data property in the data source object / array for each row (see row().data())
	 * should be read and set.
	 * <p>
	 * Typically this option will be used to point to a column with a sequence number that defines an order. However, this need not be the
	 * case - any property in the data source object can be used, even one that is not used in a DataTables column.
	 */
	private String dataSrc;
	/**
	 * rowReorder.enable
	 * Enable / disable RowReorder's user interaction. Please note - this property requires the RowReorder extension for DataTables.
	 * <p>
	 * Description
	 * This option can be used to disable RowReorder's end user interaction when the DataTable is first created. It can then later be
	 * enabled using the rowReorder.enable() API method.
	 */
	private Boolean enable;
	/**
	 * rowReorder.selector
	 * Define the selector used to pick the elements that will start a drag. Please note - this property requires the RowReorder extension
	 * for DataTables.
	 * <p>
	 * Description
	 * In order to be able to start a row drag and drop reorder, the user needs to be able to click and drag an element in the row. This
	 * option defines what element in the table row performs that option.
	 * <p>
	 * The value of this option can take any jQuery selector, providing the option to provide potentially complex selection options, but
	 * typically you will wish to select either a specific cell (the default value is to select the first visible cell in the table), the
	 * whole row or a specific button in the table that is styles to appear as a drag start handle to the end user.
	 */
	private String selector;
	/**
	 * rowReorder.snapX
	 * Horizontal position control of the row being dragged. Please note - this property requires the RowReorder extension for DataTables.
	 * <p>
	 * Description
	 * When RowReorder starts a drag, it clones the original target row and the clone is moved with the mouse, giving the end user visual
	 * feedback about the drag action.
	 * <p>
	 * By default the cloned row will be moved with the mouse both horizontally and vertically. However, only the virtual position is
	 * particularly important and it can be nice to lock the row to the host table vertically. This option provides that ability.
	 * <p>
	 * Types
	 * boolean
	 * Description:
	 * true - the dragged row follows the mouse only vertically. It is locked to the left of the table horizontally.
	 * false - the dragged row follows the mouse both horizontally and vertically
	 */
	private Boolean snapX;
	/**
	 * rowReorder.update
	 * Control automatic of data when a row is dropped. Please note - this property requires the RowReorder extension for DataTables.
	 * <p>
	 * Description
	 * At the end of a row reordering action you will typically wish to take some action to reflect the change from the reordering action.
	 * By default RowReorder will read the data from the reordered rows and update that same data based on the row's new position in the
	 * table. It will then redraw the table to account for any changes in ordering.
	 * <p>
	 * This action is not always desirable, particularly if you are using server-side processing or which to have an external process
	 * update the data. In such circumstances this option can be used to disable the automatic data update and draw. The row-reorder event
	 * can then be used to determine what actions should be taken based on the reordered rows.
	 * <p>
	 * Type
	 * boolean
	 * Description:
	 * true - DataTables data is automatically updated as a result of the row reordering and the table redrawn.
	 * false - No data update or draw is performed.
	 */
	private Boolean update;

	/**
	 * rowReorder
	 * Enable and configure the RowReorder extension for DataTables. Please note - this property requires the RowReorder extension for
	 * DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to enable and configure RowReorder for DataTables. In its simplest form as the boolean true it
	 * will enable RowReorder with the default configuration options (as defined by $.fn.dataTable.RowReorder.defaults). It can also be
	 * used as an object to provide custom configuration options as described below.
	 * <p>
	 * Please note that as with all other configuration options for RowReorder, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 */
	public DataTablesRowReorder()
	{
		//no config required
	}

	/**
	 * rowReorder.dataSrc
	 * Configure the data point that will be used for the reordering data. Please note - this property requires the RowReorder extension
	 * for DataTables.
	 * <p>
	 * Description
	 * When rows are reordered, RowReorder will automatically adjust the data in the DataTable to reflect the change made by the
	 * reordering. This option tells RowReorder what data property in the data source object / array for each row (see row().data())
	 * should be read and set.
	 * <p>
	 * Typically this option will be used to point to a column with a sequence number that defines an order. However, this need not be the
	 * case - any property in the data source object can be used, even one that is not used in a DataTables column.
	 *
	 * @return
	 */
	public String getDataSrc()
	{
		return dataSrc;
	}

	/**
	 * rowReorder.dataSrc
	 * Configure the data point that will be used for the reordering data. Please note - this property requires the RowReorder extension
	 * for DataTables.
	 * <p>
	 * Description
	 * When rows are reordered, RowReorder will automatically adjust the data in the DataTable to reflect the change made by the
	 * reordering. This option tells RowReorder what data property in the data source object / array for each row (see row().data())
	 * should be read and set.
	 * <p>
	 * Typically this option will be used to point to a column with a sequence number that defines an order. However, this need not be the
	 * case - any property in the data source object can be used, even one that is not used in a DataTables column.
	 *
	 * @param dataSrc
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDataSrc(String dataSrc)
	{
		this.dataSrc = dataSrc;
		return (J) this;
	}

	/**
	 * rowReorder.enable
	 * Enable / disable RowReorder's user interaction. Please note - this property requires the RowReorder extension for DataTables.
	 * <p>
	 * Description
	 * This option can be used to disable RowReorder's end user interaction when the DataTable is first created. It can then later be
	 * enabled using the rowReorder.enable() API method.
	 *
	 * @return
	 */
	public Boolean getEnable()
	{
		return enable;
	}

	/**
	 * rowReorder.enable
	 * Enable / disable RowReorder's user interaction. Please note - this property requires the RowReorder extension for DataTables.
	 * <p>
	 * Description
	 * This option can be used to disable RowReorder's end user interaction when the DataTable is first created. It can then later be
	 * enabled using the rowReorder.enable() API method.
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
	 * rowReorder.selector
	 * Define the selector used to pick the elements that will start a drag. Please note - this property requires the RowReorder extension
	 * for DataTables.
	 * <p>
	 * Description
	 * In order to be able to start a row drag and drop reorder, the user needs to be able to click and drag an element in the row. This
	 * option defines what element in the table row performs that option.
	 * <p>
	 * The value of this option can take any jQuery selector, providing the option to provide potentially complex selection options, but
	 * typically you will wish to select either a specific cell (the default value is to select the first visible cell in the table), the
	 * whole row or a specific button in the table that is styles to appear as a drag start handle to the end user.
	 *
	 * @return
	 */
	public String getSelector()
	{
		return selector;
	}

	/**
	 * rowReorder.selector
	 * Define the selector used to pick the elements that will start a drag. Please note - this property requires the RowReorder extension
	 * for DataTables.
	 * <p>
	 * Description
	 * In order to be able to start a row drag and drop reorder, the user needs to be able to click and drag an element in the row. This
	 * option defines what element in the table row performs that option.
	 * <p>
	 * The value of this option can take any jQuery selector, providing the option to provide potentially complex selection options, but
	 * typically you will wish to select either a specific cell (the default value is to select the first visible cell in the table), the
	 * whole row or a specific button in the table that is styles to appear as a drag start handle to the end user.
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
	 * rowReorder.snapX
	 * Horizontal position control of the row being dragged. Please note - this property requires the RowReorder extension for DataTables.
	 * <p>
	 * Description
	 * When RowReorder starts a drag, it clones the original target row and the clone is moved with the mouse, giving the end user
	 * visual feedback about the drag action.
	 * <p>
	 * By default the cloned row will be moved with the mouse both horizontally and vertically. However, only the virtual position is
	 * particularly important and it can be nice to lock the row to the host table vertically. This option provides that ability.
	 * <p>
	 * Types
	 * boolean
	 * Description:
	 * true - the dragged row follows the mouse only vertically. It is locked to the left of the table horizontally.
	 * false - the dragged row follows the mouse both horizontally and vertically
	 *
	 * @return
	 */
	public Boolean getSnapX()
	{
		return snapX;
	}

	/**
	 * rowReorder.snapX
	 * Horizontal position control of the row being dragged. Please note - this property requires the RowReorder extension for DataTables.
	 * <p>
	 * Description
	 * When RowReorder starts a drag, it clones the original target row and the clone is moved with the mouse, giving the end user visual
	 * feedback about the drag action.
	 * <p>
	 * By default the cloned row will be moved with the mouse both horizontally and vertically. However, only the virtual position is
	 * particularly important and it can be nice to lock the row to the host table vertically. This option provides that ability.
	 * <p>
	 * Types
	 * boolean
	 * Description:
	 * true - the dragged row follows the mouse only vertically. It is locked to the left of the table horizontally.
	 * false - the dragged row follows the mouse both horizontally and vertically
	 *
	 * @param snapX
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSnapX(Boolean snapX)
	{
		this.snapX = snapX;
		return (J) this;
	}

	/**
	 * rowReorder.update
	 * Control automatic of data when a row is dropped. Please note - this property requires the RowReorder extension for DataTables.
	 * <p>
	 * Description
	 * At the end of a row reordering action you will typically wish to take some action to reflect the change from the reordering action.
	 * By default RowReorder will read the data from the reordered rows and update that same data based on the row's new position in the
	 * table. It will then redraw the table to account for any changes in ordering.
	 * <p>
	 * This action is not always desirable, particularly if you are using server-side processing or which to have an external process
	 * update the data. In such circumstances this option can be used to disable the automatic data update and draw. The row-reorder event
	 * can then be used to determine what actions should be taken based on the reordered rows.
	 * <p>
	 * Type
	 * boolean
	 * Description:
	 * true - DataTables data is automatically updated as a result of the row reordering and the table redrawn.
	 * false - No data update or draw is performed.
	 *
	 * @return
	 */
	public Boolean getUpdate()
	{
		return update;
	}

	/**
	 * rowReorder.update
	 * Control automatic of data when a row is dropped. Please note - this property requires the RowReorder extension for DataTables.
	 * <p>
	 * Description
	 * At the end of a row reordering action you will typically wish to take some action to reflect the change from the reordering action.
	 * By default RowReorder will read the data from the reordered rows and update that same data based on the row's new position in the
	 * table. It will then redraw the table to account for any changes in ordering.
	 * <p>
	 * This action is not always desirable, particularly if you are using server-side processing or which to have an external process
	 * update the data. In such circumstances this option can be used to disable the automatic data update and draw. The row-reorder event
	 * can then be used to determine what actions should be taken based on the reordered rows.
	 * <p>
	 * Type
	 * boolean
	 * Description:
	 * true - DataTables data is automatically updated as a result of the row reordering and the table redrawn.
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
