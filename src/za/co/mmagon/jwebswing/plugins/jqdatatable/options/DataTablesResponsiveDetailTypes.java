package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

/**
 * inline - Use the first column to display the control element
 * column - Use a whole column to display the control element. Note that if used as a column type and the target option is set to be a
 * column index, the class assigned to that column in the DataTable should be control to allow the CSS to display a visual show / hide
 * control to the end user.
 */
public enum DataTablesResponsiveDetailTypes
{
	/**
	 * inline - Use the first column to display the control element
	 * column - Use a whole column to display the control element. Note that if used as a column type and the target option is set to be a
	 * column index, the class assigned to that column in the DataTable should be control to allow the CSS to display a visual show / hide
	 * control to the end user.
	 */
	Inline,
	/**
	 * inline - Use the first column to display the control element
	 * column - Use a whole column to display the control element. Note that if used as a column type and the target option is set to be a
	 * column index, the class assigned to that column in the DataTable should be control to allow the CSS to display a visual show / hide
	 * control to the end user.
	 */
	Custom;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
