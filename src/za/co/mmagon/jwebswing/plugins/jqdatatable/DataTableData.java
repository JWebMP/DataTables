package za.co.mmagon.jwebswing.plugins.jqdatatable;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * Any DataTables data class that can be returned as data from a asynchronous servlet
 * <p>
 * set records total to use with paging
 *
 * @param <J>
 */
public abstract class DataTableData<J extends DataTableData<J>> extends JavaScriptPart<J>
{
	private Integer recordsFiltered;
	private Integer recordsTotal;
	private Integer draw;

	/**
	 * Gets the number of records that are filtered
	 *
	 * @return
	 */
	public Integer getRecordsFiltered()
	{
		return recordsFiltered;
	}

	/**
	 * Set the number of records that are filtered
	 *
	 * @param recordsFiltered
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRecordsFiltered(Integer recordsFiltered)
	{
		this.recordsFiltered = recordsFiltered;
		return (J) this;
	}

	/**
	 * Get the total records
	 *
	 * @return
	 */
	public Integer getRecordsTotal()
	{
		return recordsTotal;
	}

	/**
	 * Sets the total records
	 *
	 * @param recordsTotal
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRecordsTotal(Integer recordsTotal)
	{
		this.recordsTotal = recordsTotal;
		return (J) this;
	}

	/**
	 * Gets the amount to draw per turn
	 *
	 * @return
	 */
	public Integer getDraw()
	{
		return draw;
	}

	/**
	 * Sets the amount to draw per turn
	 *
	 * @param draw
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDraw(Integer draw)
	{
		this.draw = draw;
		return (J) this;
	}
}
