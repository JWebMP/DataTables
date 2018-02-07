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

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.plugins.jqdatatable.options.DataTableColumnOptions;

import java.util.ArrayList;
import java.util.List;

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
	private String dom;

	/**
	 * Add or modify data submitted to the server upon an Ajax request
	 */
	@JsonProperty("ajax_data")
	private String ajaxData;
	/**
	 * Data property or manipulation method for table data
	 */
	@JsonProperty("ajax_dataSrc")
	private String ajaxDataSrc;
	/**
	 * Load data for the table's content from an Ajax source
	 */
	private String ajax;
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
	 */
	private Boolean jQueryUI;
	/**
	 * Feature control the end user's ability to change the paging display length of the table.
	 */
	private Boolean lengthChange;
	/**
	 * Feature control ordering (sorting) abilities in DataTables.
	 */
	private Boolean ordering;
	/**
	 * Enable or disable table pagination.
	 */
	private Boolean paging;
	/**
	 * Feature control the processing indicator.
	 */
	private Boolean processing;
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
	private Boolean scrollY;
	/**
	 * Vertical scrolling
	 */
	private Integer scrollYNum;
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
	 * State saving - restore table state on page reload
	 */
	private Boolean retrieve = true;
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
	 * The list of data table options
	 */
	public DataTableOptions()
	{
		//Nothing Needed
	}

	public Boolean getAutoWidth()
	{
		return autoWidth;
	}

	public J setAutoWidth(Boolean autoWidth)
	{
		this.autoWidth = autoWidth;
		return (J) this;
	}

	public Boolean getDeferRender()
	{
		return deferRender;
	}

	public J setDeferRender(Boolean deferRender)
	{
		this.deferRender = deferRender;
		return (J) this;
	}

	public Boolean getInfo()
	{
		return info;
	}

	public J setInfo(Boolean info)
	{
		this.info = info;
		return (J) this;
	}

	/**
	 * @return
	 */
	public Boolean getjQueryUI()
	{
		return jQueryUI;
	}

	/**
	 * @param jQueryUI
	 */
	public J setjQueryUI(Boolean jQueryUI)
	{
		this.jQueryUI = jQueryUI;
		return (J) this;
	}

	public Boolean getLengthChange()
	{
		return lengthChange;
	}

	public J setLengthChange(Boolean lengthChange)
	{
		this.lengthChange = lengthChange;
		return (J) this;
	}

	public Boolean getOrdering()
	{
		return ordering;
	}

	public J setOrdering(Boolean ordering)
	{
		this.ordering = ordering;
		return (J) this;
	}

	public Boolean getPaging()
	{
		return paging;
	}

	public J setPaging(Boolean paging)
	{
		this.paging = paging;
		return (J) this;
	}

	public Boolean getProcessing()
	{
		return processing;
	}

	public J setProcessing(Boolean processing)
	{
		this.processing = processing;
		return (J) this;
	}

	public Boolean getScrollX()
	{
		return scrollX;
	}

	public J setScrollX(Boolean scrollX)
	{
		this.scrollX = scrollX;
		return (J) this;
	}

	public Integer getScrollXNum()
	{
		return scrollXNum;
	}

	public J setScrollXNum(Integer scrollXNum)
	{
		this.scrollXNum = scrollXNum;
		return (J) this;
	}

	public Boolean getScrollY()
	{
		return scrollY;
	}

	public J setScrollY(Boolean scrollY)
	{
		this.scrollY = scrollY;
		return (J) this;
	}

	public Integer getScrollYNum()
	{
		return scrollYNum;
	}

	public J setScrollYNum(Integer scrollYNum)
	{
		this.scrollYNum = scrollYNum;
		return (J) this;
	}

	public Boolean getSearching()
	{
		return searching;
	}

	public J setSearching(Boolean searching)
	{
		this.searching = searching;
		return (J) this;
	}

	public Boolean getServerSide()
	{
		return serverSide;
	}

	public J setServerSide(Boolean serverSide)
	{
		this.serverSide = serverSide;
		return (J) this;
	}

	public Boolean getStateSave()
	{
		return stateSave;
	}

	public J setStateSave(Boolean stateSave)
	{
		this.stateSave = stateSave;
		return (J) this;
	}

	public String getAjaxData()
	{
		return ajaxData;
	}

	public J setAjaxData(String ajaxData)
	{
		this.ajaxData = ajaxData;
		return (J) this;
	}

	public String getAjaxDataSrc()
	{
		return ajaxDataSrc;
	}

	public J setAjaxDataSrc(String ajaxDataSrc)
	{
		this.ajaxDataSrc = ajaxDataSrc;
		return (J) this;
	}

	public String getAjax()
	{
		return ajax;
	}

	public J setAjax(String ajax)
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

	public Boolean getRetrieve()
	{
		return retrieve;
	}

	public J setRetrieve(Boolean retrieve)
	{
		this.retrieve = retrieve;
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
	 * As is described by the basic DOM positioning example you can use the dom initialisation parameter to move DataTables features around the table to where you want them.
	 * <p>
	 * In addition to this, you can also use dom to create multiple instances of these table controls. Simply include the feature's identification letter where you want it to appear, as many times as
	 * you wish, and the controls will all sync up (note that obviously the table (t) should be included only once).
	 * <p>
	 * This is shown in the demo below where for four key build-in features are duplicated above and below the table.
	 *
	 * @return
	 */
	public String getDom()
	{
		return dom;
	}

	/**
	 * <p>
	 * As is described by the basic DOM positioning example you can use the dom initialisation parameter to move DataTables features around the table to where you want them.
	 * <p>
	 * In addition to this, you can also use dom to create multiple instances of these table controls. Simply include the feature's identification letter where you want it to appear, as many times as
	 * you wish, and the controls will all sync up (note that obviously the table (t) should be included only once).
	 * <p>
	 * This is shown in the demo below where for four key build-in features are duplicated above and below the table.
	 *
	 * @param dom
	 */
	public J setDom(String dom)
	{
		this.dom = dom;
		return (J) this;
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
}
