package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

/**
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
public enum DataTablesSelectItems
{
	/**
	 * Description:
	 * This option can take one of the following values:
	 * <p>
	 * row - select rows
	 * column - select columns
	 * cell - select cells
	 */
	Row,
	/**
	 * Description:
	 * This option can take one of the following values:
	 * <p>
	 * row - select rows
	 * column - select columns
	 * cell - select cells
	 */
	Cell,
	/**
	 * Description:
	 * This option can take one of the following values:
	 * <p>
	 * row - select rows
	 * column - select columns
	 * cell - select cells
	 */
	Column;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
