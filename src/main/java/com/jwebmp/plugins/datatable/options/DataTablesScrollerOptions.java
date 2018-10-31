package com.jwebmp.plugins.datatable.options;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * scroller
 * Enable and configure the Scroller extension for DataTables. Please note - this property requires the Scroller extension for DataTables.
 * <p>
 * Description
 * Scroller is an extension for DataTables that provides virtual rendering support - i.e. it will draw only the small visible section of
 * the table (plus a small overlap for smooth scrolling), even although in the scrolling viewport it will appear visually to the end user
 * that the whole table is available. This can significantly improve performance for large data sets where you don't wish to display
 * paging controls.
 * <p>
 * There are two important requirements to consider when using Scroller:
 * <p>
 * Paging must be enabled in DataTables (paging - it is by default)
 * All rows must be of equal height. This is to allow row height calculations for rows which have not yet been rendered.
 * This option provides the ability to enable and configure Scroller for DataTables. In its simplest form as the boolean true it will
 * enable Scroller with the default configuration options (as defined by $.fn.dataTable.Scroller.defaults). It can also be used as an
 * object to provide custom configuration options as described below.
 * <p>
 * Please note that as with all other configuration options for Scroller, this option is an extension to the default set of DataTables
 * options. This property should be set in the DataTables initialisation object.
 *
 * @param <J>
 */
public class DataTablesScrollerOptions<J extends DataTablesScrollerOptions<J>>
		extends JavaScriptPart<J>
{


	/**
	 * scroller.boundaryScale
	 * Set the point at which new data will be loaded and drawn. Please note - this property requires the Scroller extension for
	 * DataTables.
	 * <p>
	 * Description
	 * Scroller uses the boundary scaling factor to decide when to redraw the table - which it typically does before you reach the end of
	 * the currently loaded data set (in order to allow the data to look continuous to a user scrolling through the data). If given as 0
	 * then the table will be redrawn whenever the viewport is scrolled, while 1 would not redraw the table until the currently loaded
	 * data has all been shown. You will want something in the middle - the default factor of 0.5 is usually suitable.
	 */
	private Double boundaryScale;
	/**
	 * scroller.displayBuffer
	 * The amount of data that Scroller should pre-buffer to ensure smooth scrolling. Please note - this property requires the Scroller
	 * extension for DataTables.
	 * <p>
	 * Description
	 * To display a smooth scrolling table, Scroller will load more data than it actually needs to display in the viewport. This allows
	 * the end user to scroll by small increments without the table needing to redraw.
	 * <p>
	 * The value given here determines how many rows of data Scroller will pre-fetch and draw. It is a multiplier that will be multiplied
	 * by the number of rows that Scroller determines can fit into a viewport. For example if a viewport of 400px is used with 20px height
	 * rows and the default of 9 is used for the display buffer, 180 rows will be loaded. The range of records will be split equally
	 * between records before and after the instantaneous display start point.
	 * <p>
	 * Setting this value gives the ability to customise the balance between the performance enhancements offered by Scroller through its
	 * ability to draw only a sub-set of the rows in the table, and the fact that a data redraw can be an expensive operation,
	 * particularly if server-side processing is used and data must be loaded via Ajax.
	 */
	private Integer displayBuffer;
	/**
	 * scroller.loadingIndicator
	 * Display a loading message while Scroller is loading additional data. Please note - this property requires the Scroller extension
	 * for DataTables.
	 * <p>
	 * Description
	 * While scrolling quickly through a table it is quite possible that Scroller will not be able to display the data to shown in the
	 * table as quickly as the user is scrolling (particularly if server-side processing is used - serverSide).
	 * <p>
	 * To indicate to the end user that something is happening while new data is being loaded, this option can be used to display a
	 * loading message. The text shown is taken from the language.loadingRecords option.
	 */
	private Boolean loadingIndicator;
	/**
	 * scroller.rowHeight
	 * Set the row height, or how the row height is calculated. Please note - this property requires the Scroller extension for DataTables.
	 * <p>
	 * Description
	 * It is important for Scroller to know the height of the rows in the DataTable so it can perform its virtual display calculations.
	 * All rows must be of the same height, and Scroller will attempt to automatically calculate the height of rows itself.
	 * <p>
	 * However, the value that is used can be overridden using this parameter. Generally it is not recommended that this be used - it
	 * offers little in the way of performance enhancements, although it can be useful if styling that alters the height of the rows is
	 * applied to the table after initialisation.
	 */
	private Integer rowHeight;
	/**
	 * scroller.serverWait
	 * Time delay before new data is requested when server-side processing is enabled. Please note - this property requires the Scroller
	 * extension for DataTables.
	 * <p>
	 * Description
	 * When using server-side processing (serverSide), Scroller will wait a small amount of time to allow the scrolling to finish before
	 * requesting more data from the server. This can be useful to help prevent you from DDoSing your own server with frequent Ajax
	 * requests as the user scrolls through a table!
	 * <p>
	 * The wait time can be configured by this parameter.
	 */
	private Integer serverWait;

	/**
	 * scroller
	 * Enable and configure the Scroller extension for DataTables. Please note - this property requires the Scroller extension for
	 * DataTables.
	 * <p>
	 * Description
	 * Scroller is an extension for DataTables that provides virtual rendering support - i.e. it will draw only the small visible section
	 * of the table (plus a small overlap for smooth scrolling), even although in the scrolling viewport it will appear visually to the
	 * end user that the whole table is available. This can significantly improve performance for large data sets where you don't wish to
	 * display paging controls.
	 * <p>
	 * There are two important requirements to consider when using Scroller:
	 * <p>
	 * Paging must be enabled in DataTables (paging - it is by default)
	 * All rows must be of equal height. This is to allow row height calculations for rows which have not yet been rendered.
	 * This option provides the ability to enable and configure Scroller for DataTables. In its simplest form as the boolean true it will
	 * enable Scroller with the default configuration options (as defined by $.fn.dataTable.Scroller.defaults). It can also be used as an
	 * object to provide custom configuration options as described below.
	 * <p>
	 * Please note that as with all other configuration options for Scroller, this option is an extension to the default set of DataTables
	 * options. This property should be set in the DataTables initialisation object.
	 */
	public DataTablesScrollerOptions()
	{
		//No config required
	}

	/**
	 * scroller.boundaryScale
	 * Set the point at which new data will be loaded and drawn. Please note - this property requires the Scroller extension for
	 * DataTables.
	 * <p>
	 * Description
	 * Scroller uses the boundary scaling factor to decide when to redraw the table - which it typically does before you reach the end of
	 * the currently loaded data set (in order to allow the data to look continuous to a user scrolling through the data). If given as 0
	 * then the table will be redrawn whenever the viewport is scrolled, while 1 would not redraw the table until the currently loaded
	 * data has all been shown. You will want something in the middle - the default factor of 0.5 is usually suitable.
	 *
	 * @return
	 */
	public Double getBoundaryScale()
	{
		return boundaryScale;
	}

	/**
	 * scroller.boundaryScale
	 * Set the point at which new data will be loaded and drawn. Please note - this property requires the Scroller extension for
	 * DataTables.
	 * <p>
	 * Description
	 * Scroller uses the boundary scaling factor to decide when to redraw the table - which it typically does before you reach the end of
	 * the currently loaded data set (in order to allow the data to look continuous to a user scrolling through the data). If given as 0
	 * then the table will be redrawn whenever the viewport is scrolled, while 1 would not redraw the table until the currently loaded
	 * data has all been shown. You will want something in the middle - the default factor of 0.5 is usually suitable.
	 *
	 * @param boundaryScale
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setBoundaryScale(Double boundaryScale)
	{
		this.boundaryScale = boundaryScale;
		return (J) this;
	}

	/**
	 * scroller.displayBuffer
	 * The amount of data that Scroller should pre-buffer to ensure smooth scrolling. Please note - this property requires the Scroller
	 * extension for DataTables.
	 * <p>
	 * Description
	 * To display a smooth scrolling table, Scroller will load more data than it actually needs to display in the viewport. This allows
	 * the end user to scroll by small increments without the table needing to redraw.
	 * <p>
	 * The value given here determines how many rows of data Scroller will pre-fetch and draw. It is a multiplier that will be multiplied
	 * by the number of rows that Scroller determines can fit into a viewport. For example if a viewport of 400px is used with 20px height
	 * rows and the default of 9 is used for the display buffer, 180 rows will be loaded. The range of records will be split equally
	 * between records before and after the instantaneous display start point.
	 * <p>
	 * Setting this value gives the ability to customise the balance between the performance enhancements offered by Scroller through its
	 * ability to draw only a sub-set of the rows in the table, and the fact that a data redraw can be an expensive operation,
	 * particularly if server-side processing is used and data must be loaded via Ajax.
	 *
	 * @return
	 */
	public Integer getDisplayBuffer()
	{
		return displayBuffer;
	}

	/**
	 * scroller.displayBuffer
	 * The amount of data that Scroller should pre-buffer to ensure smooth scrolling. Please note - this property requires the Scroller
	 * extension for DataTables.
	 * <p>
	 * Description
	 * To display a smooth scrolling table, Scroller will load more data than it actually needs to display in the viewport. This allows
	 * the end user to scroll by small increments without the table needing to redraw.
	 * <p>
	 * The value given here determines how many rows of data Scroller will pre-fetch and draw. It is a multiplier that will be multiplied
	 * by the number of rows that Scroller determines can fit into a viewport. For example if a viewport of 400px is used with 20px height
	 * rows and the default of 9 is used for the display buffer, 180 rows will be loaded. The range of records will be split equally
	 * between records before and after the instantaneous display start point.
	 * <p>
	 * Setting this value gives the ability to customise the balance between the performance enhancements offered by Scroller through its
	 * ability to draw only a sub-set of the rows in the table, and the fact that a data redraw can be an expensive operation,
	 * particularly if server-side processing is used and data must be loaded via Ajax.
	 *
	 * @param displayBuffer
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDisplayBuffer(Integer displayBuffer)
	{
		this.displayBuffer = displayBuffer;
		return (J) this;
	}

	/**
	 * scroller.loadingIndicator
	 * Display a loading message while Scroller is loading additional data. Please note - this property requires the Scroller extension
	 * for DataTables.
	 * <p>
	 * Description
	 * While scrolling quickly through a table it is quite possible that Scroller will not be able to display the data to shown in the
	 * table as quickly as the user is scrolling (particularly if server-side processing is used - serverSide).
	 * <p>
	 * To indicate to the end user that something is happening while new data is being loaded, this option can be used to display a
	 * loading message. The text shown is taken from the language.loadingRecords option.
	 *
	 * @return
	 */
	public Boolean getLoadingIndicator()
	{
		return loadingIndicator;
	}

	/**
	 * scroller.loadingIndicator
	 * Display a loading message while Scroller is loading additional data. Please note - this property requires the Scroller extension
	 * for DataTables.
	 * <p>
	 * Description
	 * While scrolling quickly through a table it is quite possible that Scroller will not be able to display the data to shown in the
	 * table as quickly as the user is scrolling (particularly if server-side processing is used - serverSide).
	 * <p>
	 * To indicate to the end user that something is happening while new data is being loaded, this option can be used to display a
	 * loading message. The text shown is taken from the language.loadingRecords option.
	 *
	 * @param loadingIndicator
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setLoadingIndicator(Boolean loadingIndicator)
	{
		this.loadingIndicator = loadingIndicator;
		return (J) this;
	}

	/**
	 * scroller.rowHeight
	 * Set the row height, or how the row height is calculated. Please note - this property requires the Scroller extension for DataTables.
	 * <p>
	 * Description
	 * It is important for Scroller to know the height of the rows in the DataTable so it can perform its virtual display calculations.
	 * All rows must be of the same height, and Scroller will attempt to automatically calculate the height of rows itself.
	 * <p>
	 * However, the value that is used can be overridden using this parameter. Generally it is not recommended that this be used - it
	 * offers little in the way of performance enhancements, although it can be useful if styling that alters the height of the rows is
	 * applied to the table after initialisation.
	 *
	 * @return
	 */
	public Integer getRowHeight()
	{
		return rowHeight;
	}

	/**
	 * scroller.rowHeight
	 * Set the row height, or how the row height is calculated. Please note - this property requires the Scroller extension for DataTables.
	 * <p>
	 * Description
	 * It is important for Scroller to know the height of the rows in the DataTable so it can perform its virtual display calculations.
	 * All rows must be of the same height, and Scroller will attempt to automatically calculate the height of rows itself.
	 * <p>
	 * However, the value that is used can be overridden using this parameter. Generally it is not recommended that this be used - it
	 * offers little in the way of performance enhancements, although it can be useful if styling that alters the height of the rows is
	 * applied to the table after initialisation.
	 *
	 * @param rowHeight
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRowHeight(Integer rowHeight)
	{
		this.rowHeight = rowHeight;
		return (J) this;
	}

	/**
	 * scroller.serverWait
	 * Time delay before new data is requested when server-side processing is enabled. Please note - this property requires the Scroller
	 * extension for DataTables.
	 * <p>
	 * Description
	 * When using server-side processing (serverSide), Scroller will wait a small amount of time to allow the scrolling to finish before
	 * requesting more data from the server. This can be useful to help prevent you from DDoSing your own server with frequent Ajax
	 * requests as the user scrolls through a table!
	 * <p>
	 * The wait time can be configured by this parameter.
	 *
	 * @return
	 */
	public Integer getServerWait()
	{
		return serverWait;
	}

	/**
	 * scroller.serverWait
	 * Time delay before new data is requested when server-side processing is enabled. Please note - this property requires the Scroller
	 * extension for DataTables.
	 * <p>
	 * Description
	 * When using server-side processing (serverSide), Scroller will wait a small amount of time to allow the scrolling to finish before
	 * requesting more data from the server. This can be useful to help prevent you from DDoSing your own server with frequent Ajax
	 * requests as the user scrolls through a table!
	 * <p>
	 * The wait time can be configured by this parameter.
	 *
	 * @param serverWait
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setServerWait(Integer serverWait)
	{
		this.serverWait = serverWait;
		return (J) this;
	}
}
