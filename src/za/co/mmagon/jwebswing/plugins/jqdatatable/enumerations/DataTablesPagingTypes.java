package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

/**
 * pagingTypeSince: DataTables 1.10
 * Pagination button display options.
 * <p>
 * Description
 * The pagination option of DataTables will display a pagination control below the table (by default, its position can be changed using
 * dom and CSS) with buttons that the end user can use to navigate the pages of the table. Which buttons are shown in the pagination
 * control are defined by the option given here.
 * <p>
 * DataTables has six built-in paging button arrangements:
 * <p>
 * numbers - Page number buttons only (1.10.8)
 * simple - 'Previous' and 'Next' buttons only
 * simple_numbers - 'Previous' and 'Next' buttons, plus page numbers
 * full - 'First', 'Previous', 'Next' and 'Last' buttons
 * full_numbers - 'First', 'Previous', 'Next' and 'Last' buttons, plus page numbers
 * first_last_numbers - 'First' and 'Last' buttons, plus page numbers
 * Further methods can be added using plug-ins.
 * <p>
 * Type
 * This option can be given in the following type(s):
 * <p>
 * string
 */
public enum DataTablesPagingTypes
{
	/**
	 * Page number buttons only (1.10.8)
	 */
	Numbers,
	/**
	 * 'Previous' and 'Next' buttons only
	 */
	Simple,
	/**
	 * 'Previous' and 'Next' buttons, plus page numbers
	 */
	Simple_Numbers,
	/**
	 * 'First', 'Previous', 'Next' and 'Last' buttons
	 */
	Full,
	/**
	 * 'First', 'Previous', 'Next' and 'Last' buttons, plus page numbers
	 */
	Full_Numbers,
	/**
	 * 'First' and 'Last' buttons, plus page numbers
	 */
	First_Last_Numbers;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
