package za.co.mmagon.jwebswing.plugins.jqdatatable.events;

import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.plugins.jqdatatable.DataTableData;
import za.co.mmagon.jwebswing.plugins.jqdatatable.search.DataTableSearchRequest;

/**
 * Data Tables Ajax fetch data.
 *
 * @param <J>
 */
public abstract class DataTableDataFetchEvent<J extends DataTableDataFetchEvent<J>> extends Event<J>
{
	public DataTableDataFetchEvent()
	{
		this(null);
	}

	public DataTableDataFetchEvent(ComponentHierarchyBase component)
	{
		super(component);
	}

	/**
	 * Returns the data object to be rendered as json to the server
	 *
	 * @return
	 */
	public abstract DataTableData returnData(DataTableSearchRequest searchRequest);
}
