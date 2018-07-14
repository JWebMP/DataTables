package com.jwebmp.plugins.datatable.options;

import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ColReorder adds the ability for the end user to be able to reorder columns in a DataTable through a click and drag operation. This can
 * be useful when presenting data in a table, letting the user move columns that they wish to compare next to each other for easier
 * comparison.
 * <p>
 * It is worth noting that the underlying column data structure of the DataTable is modified as part of this process - this is important
 * if you are interacting with the table using the API.
 *
 * @param <J>
 */
public class DataTableColReOrderOptions<J extends DataTableColReOrderOptions<J>>
		extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	/**
	 * colReorder.fixedColumnsLeft
	 * Disallow x columns from reordering (counting from the left). Please note - this property requires the ColReorder extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When allowing reordering of columns in a table, you may often wish to disallow reordering of certain columns (for example locking
	 * an index, select or action column to the start of a table). This option provides that ability, locking columns counting from the
	 * left (colReorder.fixedColumnsRight provides the option to count from the right).
	 * <p>
	 * This can be particularly useful if using ColReorder with the FixedColumns extension.
	 */
	private Integer fixedColumnsLeft;
	/**
	 * colReorder.fixedColumnsRight
	 * Disallow x columns from reordering (counting from the right). Please note - this property requires the ColReorder extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When allowing reordering of columns in a table, you may often wish to disallow reordering of certain columns (for example locking
	 * an index, select or action column to the start of a table). This option provides that ability, locking columns counting from the
	 * right (colReorder.fixedColumnsLeft provides the option to count from the left).
	 * <p>
	 * This can be particularly useful if using ColReorder with the FixedColumns extension.
	 */
	private Integer fixedColumnsRight;
	/**
	 * colReorder.order
	 * Set a default order for the columns in the table. Please note - this property requires the ColReorder extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the option to define a default order for the columns in a table. Typically you will wish to have the columns
	 * in the order defined in the HTML, or from state saving (stateSave), but if required, this option can be used to define an initial
	 * default order.
	 */
	private Set<Integer> order;
	/**
	 * colReorder.realtime
	 * Enable / disable live reordering of columns during a drag. Please note - this property requires the ColReorder extension for
	 * DataTables.
	 * <p>
	 * Description
	 * ColReorder will visually give the end user feedback about the reordering operation by showing an insert marker and also reordering
	 * the columns during the drag operation (by default). This option provides the option to turn the latter feedback mechanism off. You
	 * may wish to do this if you are targeting older browsers or older computers with complex tables as it can impact performance.
	 */
	private Boolean realtime;

	/**
	 * ColReorder adds the ability for the end user to be able to reorder columns in a DataTable through a click and drag operation. This
	 * can be useful when presenting data in a table, letting the user move columns that they wish to compare next to each other for
	 * easier comparison.
	 * <p>
	 * It is worth noting that the underlying column data structure of the DataTable is modified as part of this process - this is
	 * important if you are interacting with the table using the API.
	 */
	public DataTableColReOrderOptions()
	{
		//No config required
	}

	/**
	 * colReorder.fixedColumnsLeft
	 * Disallow x columns from reordering (counting from the left). Please note - this property requires the ColReorder extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When allowing reordering of columns in a table, you may often wish to disallow reordering of certain columns (for example locking
	 * an index, select or action column to the start of a table). This option provides that ability, locking columns counting from the
	 * left (colReorder.fixedColumnsRight provides the option to count from the right).
	 * <p>
	 * This can be particularly useful if using ColReorder with the FixedColumns extension.
	 *
	 * @return
	 */
	public Integer getFixedColumnsLeft()
	{
		return fixedColumnsLeft;
	}

	/**
	 * colReorder.fixedColumnsLeft
	 * Disallow x columns from reordering (counting from the left). Please note - this property requires the ColReorder extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When allowing reordering of columns in a table, you may often wish to disallow reordering of certain columns (for example locking
	 * an index, select or action column to the start of a table). This option provides that ability, locking columns counting from the
	 * left (colReorder.fixedColumnsRight provides the option to count from the right).
	 * <p>
	 * This can be particularly useful if using ColReorder with the FixedColumns extension.
	 *
	 * @param fixedColumnsLeft
	 *
	 * @return
	 */
	public J setFixedColumnsLeft(Integer fixedColumnsLeft)
	{
		this.fixedColumnsLeft = fixedColumnsLeft;
		return (J) this;
	}

	/**
	 * colReorder.fixedColumnsRight
	 * Disallow x columns from reordering (counting from the right). Please note - this property requires the ColReorder extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When allowing reordering of columns in a table, you may often wish to disallow reordering of certain columns (for example locking
	 * an index, select or action column to the start of a table). This option provides that ability, locking columns counting from the
	 * right (colReorder.fixedColumnsLeft provides the option to count from the left).
	 * <p>
	 * This can be particularly useful if using ColReorder with the FixedColumns extension.
	 *
	 * @return
	 */
	public Integer getFixedColumnsRight()
	{
		return fixedColumnsRight;
	}

	/**
	 * colReorder.fixedColumnsRight
	 * Disallow x columns from reordering (counting from the right). Please note - this property requires the ColReorder extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When allowing reordering of columns in a table, you may often wish to disallow reordering of certain columns (for example locking
	 * an index, select or action column to the start of a table). This option provides that ability, locking columns counting from the
	 * right (colReorder.fixedColumnsLeft provides the option to count from the left).
	 * <p>
	 * This can be particularly useful if using ColReorder with the FixedColumns extension.
	 *
	 * @param fixedColumnsRight
	 *
	 * @return
	 */
	public J setFixedColumnsRight(Integer fixedColumnsRight)
	{
		this.fixedColumnsRight = fixedColumnsRight;
		return (J) this;
	}

	/**
	 * colReorder.order
	 * Set a default order for the columns in the table. Please note - this property requires the ColReorder extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the option to define a default order for the columns in a table. Typically you will wish to have the columns
	 * in the order defined in the HTML, or from state saving (stateSave), but if required, this option can be used to define an initial
	 * default order.
	 *
	 * @return
	 */
	public Set<Integer> getOrder()
	{
		if (order == null)
		{
			order = new LinkedHashSet<>();
		}
		return order;

	}

	/**
	 * colReorder.order
	 * Set a default order for the columns in the table. Please note - this property requires the ColReorder extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the option to define a default order for the columns in a table. Typically you will wish to have the columns
	 * in the order defined in the HTML, or from state saving (stateSave), but if required, this option can be used to define an initial
	 * default order.
	 *
	 * @param order
	 *
	 * @return
	 */
	public J setOrder(Set<Integer> order)
	{
		this.order = order;
		return (J) this;
	}

	/**
	 * colReorder.realtime
	 * Enable / disable live reordering of columns during a drag. Please note - this property requires the ColReorder extension for
	 * DataTables.
	 * <p>
	 * Description
	 * ColReorder will visually give the end user feedback about the reordering operation by showing an insert marker and also reordering
	 * the columns during the drag operation (by default). This option provides the option to turn the latter feedback mechanism off. You
	 * may wish to do this if you are targeting older browsers or older computers with complex tables as it can impact performance.
	 *
	 * @return
	 */
	public Boolean getRealtime()
	{
		return realtime;
	}

	/**
	 * colReorder.realtime
	 * Enable / disable live reordering of columns during a drag. Please note - this property requires the ColReorder extension for
	 * DataTables.
	 * <p>
	 * Description
	 * ColReorder will visually give the end user feedback about the reordering operation by showing an insert marker and also reordering
	 * the columns during the drag operation (by default). This option provides the option to turn the latter feedback mechanism off. You
	 * may wish to do this if you are targeting older browsers or older computers with complex tables as it can impact performance.
	 *
	 * @param realtime
	 *
	 * @return
	 */
	public J setRealtime(Boolean realtime)
	{
		this.realtime = realtime;
		return (J) this;
	}
}
