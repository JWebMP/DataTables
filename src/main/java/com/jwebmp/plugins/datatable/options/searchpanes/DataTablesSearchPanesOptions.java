package com.jwebmp.plugins.datatable.options.searchpanes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.datatable.options.DataTableOptions;
import com.jwebmp.plugins.datatable.options.DataTablesDomOptions;

import java.util.List;

public class DataTablesSearchPanesOptions extends JavaScriptPart<DataTablesSearchPanesOptions>
{
	@JsonIgnore
	private final DataTableOptions<?> dataTableOptions;
	
	
	/**
	 * Allow panes to cascade under selected
	 */
	private Boolean cascadePanes;
	/**
	 * Disable buttons to allow quick clearing of selections in panes
	 */
	private Boolean clear;
	/**
	 * Allow the SearchPanes to be collapsed
	 */
	private Boolean collapse;
	/**
	 * By setting the searchPanes.columns option to an array of integers, only the columns with index of those numbers will be considered when creating the searchPanes.
	 */
	private List<Integer> columns;
	/**
	 * By setting the searchPanes.controls option to false the control buttons will be hidden and searching will be disabled in all of the panes.
	 */
	private Boolean controls;
	@JsonProperty("dtOpts")
	private DataTablesSearchPanesDTOptions datatableOptions;
	/**
	 * Deprecated. Set custom empty message
	 */
	@Deprecated
	private String emptyMessage;
	/**
	 * Deprecated. Hide the count column in all panes
	 */
	private Boolean hideCount;
	/**
	 * Collapse the SearchPanes on initialisation
	 */
	private Boolean initCollapsed;
	/**
	 * Set the layout of how the panes are displayed on the page
	 */
	private String layout;
	
	/**
	 * For a specific column show the selection pane
	 */
	private Boolean show;
	
	/**
	 * Hide the ordering buttons in all panes
	 */
	private Boolean orderable;
	/**
	 * Set the minimum ratio of unique values to total values needed in a column to display it's pane
	 */
	private Double threshold;
	/**
	 * Show the count column in all panes
	 */
	private Boolean viewCount;
	/**
	 * By setting the searchPanes.viewTotal to true, when a search is applied to the table, the message in the count columns of the panes will change to represent the currently visible entries.
	 */
	private Boolean viewTotal;
	
	
	public DataTablesSearchPanesOptions(DataTableOptions<?> dataTableOptions)
	{
		this(dataTableOptions, true);
	}
	
	public DataTablesSearchPanesOptions(DataTableOptions<?> dataTableOptions, boolean top)
	{
		this.dataTableOptions = dataTableOptions;
	}
	
	public DataTablesSearchPanesOptions setColumnCount(int columnCount)
	{
		this.layout = "columns-" + columnCount;
		return this;
	}
	
	/**
	 * Allow panes to cascade under selected
	 *
	 * @return
	 */
	public Boolean getCascadePanes()
	{
		return cascadePanes;
	}
	
	/**
	 * Allow panes to cascade under selected
	 *
	 * @param cascadePanes
	 * @return
	 */
	public DataTablesSearchPanesOptions setCascadePanes(Boolean cascadePanes)
	{
		this.cascadePanes = cascadePanes;
		return this;
	}
	
	/**
	 * Disable buttons to allow quick clearing of selections in panes
	 *
	 * @return
	 */
	public Boolean getClear()
	{
		return clear;
	}
	
	/**
	 * Disable buttons to allow quick clearing of selections in panes
	 *
	 * @param clear
	 * @return
	 */
	public DataTablesSearchPanesOptions setClear(Boolean clear)
	{
		this.clear = clear;
		return this;
	}
	
	/**
	 * Allow the SearchPanes to be collapsed
	 *
	 * @return
	 */
	public Boolean getCollapse()
	{
		return collapse;
	}
	
	/**
	 * Allow the SearchPanes to be collapsed
	 *
	 * @param collapse
	 * @return
	 */
	public DataTablesSearchPanesOptions setCollapse(Boolean collapse)
	{
		this.collapse = collapse;
		return this;
	}
	
	/**
	 * By setting the searchPanes.columns option to an array of integers, only the columns with index of those numbers will be considered when creating the searchPanes.
	 *
	 * @return
	 */
	public List<Integer> getColumns()
	{
		return columns;
	}
	
	/**
	 * By setting the searchPanes.columns option to an array of integers, only the columns with index of those numbers will be considered when creating the searchPanes.
	 *
	 * @param columns
	 * @return
	 */
	public DataTablesSearchPanesOptions setColumns(List<Integer> columns)
	{
		this.columns = columns;
		return this;
	}
	
	/**
	 * By setting the searchPanes.controls option to false the control buttons will be hidden and searching will be disabled in all of the panes.
	 *
	 * @return
	 */
	public Boolean getControls()
	{
		return controls;
	}
	
	/**
	 * By setting the searchPanes.controls option to false the control buttons will be hidden and searching will be disabled in all of the panes.
	 *
	 * @param controls
	 * @return
	 */
	public DataTablesSearchPanesOptions setControls(Boolean controls)
	{
		this.controls = controls;
		return this;
	}
	
	/**
	 * By setting the searchPanes.controls option to false the control buttons will be hidden and searching will be disabled in all of the panes.
	 *
	 * @return
	 */
	public DataTablesSearchPanesDTOptions getDatatableOptions()
	{
		return datatableOptions;
	}
	
	/**
	 * By setting the searchPanes.controls option to false the control buttons will be hidden and searching will be disabled in all of the panes.
	 *
	 * @param datatableOptions
	 * @return
	 */
	public DataTablesSearchPanesOptions setDatatableOptions(DataTablesSearchPanesDTOptions datatableOptions)
	{
		this.datatableOptions = datatableOptions;
		return this;
	}
	
	/**
	 * Deprecated. Set custom empty message
	 *
	 * @return
	 */
	@Deprecated
	public String getEmptyMessage()
	{
		return emptyMessage;
	}
	
	/**
	 * Deprecated. Set custom empty message
	 *
	 * @param emptyMessage
	 * @return
	 */
	@Deprecated
	public DataTablesSearchPanesOptions setEmptyMessage(String emptyMessage)
	{
		this.emptyMessage = emptyMessage;
		return this;
	}
	
	/**
	 * Deprecated. Hide the count column in all panes
	 *
	 * @return
	 */
	public Boolean getHideCount()
	{
		return hideCount;
	}
	
	/**
	 * Deprecated. Hide the count column in all panes
	 *
	 * @param hideCount
	 * @return
	 */
	public DataTablesSearchPanesOptions setHideCount(Boolean hideCount)
	{
		this.hideCount = hideCount;
		return this;
	}
	
	/**
	 * Collapse the SearchPanes on initialisation
	 *
	 * @return
	 */
	public Boolean getInitCollapsed()
	{
		return initCollapsed;
	}
	
	/**
	 * Collapse the SearchPanes on initialisation
	 *
	 * @param initCollapsed
	 * @return
	 */
	public DataTablesSearchPanesOptions setInitCollapsed(Boolean initCollapsed)
	{
		this.initCollapsed = initCollapsed;
		return this;
	}
	
	/**
	 * Set the layout of how the panes are displayed on the page
	 *
	 * @return
	 */
	public String getLayout()
	{
		return layout;
	}
	
	/**
	 * Set the layout of how the panes are displayed on the page
	 *
	 * @param layout
	 * @return
	 */
	public DataTablesSearchPanesOptions setLayout(String layout)
	{
		this.layout = layout;
		return this;
	}
	
	/**
	 * Hide the ordering buttons in all panes
	 *
	 * @return
	 */
	public Boolean getOrderable()
	{
		return orderable;
	}
	
	/**
	 * Hide the ordering buttons in all panes
	 *
	 * @param orderable
	 * @return
	 */
	public DataTablesSearchPanesOptions setOrderable(Boolean orderable)
	{
		this.orderable = orderable;
		return this;
	}
	
	/**
	 * Set the minimum ratio of unique values to total values needed in a column to display it's pane
	 *
	 * @return
	 */
	public Double getThreshold()
	{
		return threshold;
	}
	
	/**
	 * Set the minimum ratio of unique values to total values needed in a column to display it's pane
	 *
	 * @param threshold
	 * @return
	 */
	public DataTablesSearchPanesOptions setThreshold(Double threshold)
	{
		this.threshold = threshold;
		return this;
	}
	
	/**
	 * Show the count column in all panes
	 *
	 * @return
	 */
	public Boolean getViewCount()
	{
		return viewCount;
	}
	
	/**
	 * Show the count column in all panes
	 *
	 * @param viewCount
	 * @return
	 */
	public DataTablesSearchPanesOptions setViewCount(Boolean viewCount)
	{
		this.viewCount = viewCount;
		return this;
	}
	
	/**
	 * By setting the searchPanes.viewTotal to true, when a search is applied to the table, the message in the count columns of the panes will change to represent the currently visible entries.
	 *
	 * @return
	 */
	public Boolean getViewTotal()
	{
		return viewTotal;
	}
	
	/**
	 * By setting the searchPanes.viewTotal to true, when a search is applied to the table, the message in the count columns of the panes will change to represent the currently visible entries.
	 *
	 * @param viewTotal
	 * @return
	 */
	public DataTablesSearchPanesOptions setViewTotal(Boolean viewTotal)
	{
		this.viewTotal = viewTotal;
		return this;
	}
	
	/**
	 * For a specific column show the selection pane
	 *
	 * @return
	 */
	public Boolean getShow()
	{
		return show;
	}
	
	/**
	 * For a specific column show the selection pane
	 *
	 * @param show
	 * @return
	 */
	public DataTablesSearchPanesOptions setShow(Boolean show)
	{
		this.show = show;
		return this;
	}
}
