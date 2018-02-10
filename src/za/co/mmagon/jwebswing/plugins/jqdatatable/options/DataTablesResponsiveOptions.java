package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.TreeSet;

/**
 * responsiveSince: Responsive Responsive 1.0.0
 * Enable and configure the Responsive extension for DataTables. Please note - this property requires the Responsive extension for
 * DataTables.
 * <p>
 * Description
 * This option provides the ability to enable and configure Responsive for DataTables. In its simplest form as the boolean true it will
 * enable Responsive with the default configuration options (as defined by $.fn.dataTable.Responsive.defaults). It can also be used as an
 * object to provide custom configuration options as described below.
 * <p>
 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of DataTables
 * options. This property should be set in the DataTables initialisation object.
 *
 * @param <J>
 */
public class DataTablesResponsiveOptions<J extends DataTablesResponsiveOptions<J>> extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;
	/**
	 * responsive.breakpointsSince: Responsive Responsive 1.0.0
	 * Set the breakpoints for a Responsive instance. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * The visibility of columns in a DataTable with Responsive enabled can be controlled by breakpoints and class names matching those
	 * breakpoints (and other logical operations) . This provides the ability to exactly control which columns in a table will be visible
	 * in each device type. See the Responsive manual for more information.
	 * <p>
	 * The breakpoints that are used by a Responsive instance are unique to that instance (i.e. each table) allowing different breakpoints
	 * to be set for different tables is needed.
	 */
	private Set<DataTablesResponsiveBreakpoint<?>> breakpoints;
	/**
	 * responsive.detailsSince: Responsive Responsive 1.0.0
	 * Enable and configure the child rows shown by Responsive for collapsed tables. Please note - this property requires the Responsive
	 * extension for DataTables.
	 * <p>
	 * Description
	 * Responsive has the ability to use DataTables' child rows feature to show information about any columns which have been removed from
	 * the display as a child row, which can be particularly useful for display complex information on small screen devices. Please see
	 * the Responsive manual on the details rows for further information.
	 * <p>
	 * This options provides the ability to configure how the details rows are handled by Responsive. In its simplest form as a boolean
	 * value, the details row display can be enabled or disabled, while as an object you have the ability to control how the rows are
	 * displayed and the control to show / hide the child rows.
	 * <p>
	 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 */
	private DataTablesResponsiveDetailOptions<?> details;

	/**
	 * responsiveSince: Responsive Responsive 1.0.0
	 * Enable and configure the Responsive extension for DataTables. Please note - this property requires the Responsive extension for
	 * DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to enable and configure Responsive for DataTables. In its simplest form as the boolean true it
	 * will enable Responsive with the default configuration options (as defined by $.fn.dataTable.Responsive.defaults). It can also be
	 * used as an object to provide custom configuration options as described below.
	 * <p>
	 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 */
	public DataTablesResponsiveOptions()
	{
		//No config required
	}

	/**
	 * responsive.breakpointsSince: Responsive Responsive 1.0.0
	 * Set the breakpoints for a Responsive instance. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * The visibility of columns in a DataTable with Responsive enabled can be controlled by breakpoints and class names matching those
	 * breakpoints (and other logical operations) . This provides the ability to exactly control which columns in a table will be visible
	 * in each device type. See the Responsive manual for more information.
	 * <p>
	 * The breakpoints that are used by a Responsive instance are unique to that instance (i.e. each table) allowing different breakpoints
	 * to be set for different tables is needed.
	 *
	 * @return
	 */
	@NotNull
	public Set<DataTablesResponsiveBreakpoint<?>> getBreakpoints()
	{
		if (breakpoints == null)
		{
			breakpoints = new TreeSet<>();
		}
		return breakpoints;
	}

	/**
	 * responsive.breakpointsSince: Responsive Responsive 1.0.0
	 * Set the breakpoints for a Responsive instance. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * The visibility of columns in a DataTable with Responsive enabled can be controlled by breakpoints and class names matching those
	 * breakpoints (and other logical operations) . This provides the ability to exactly control which columns in a table will be visible
	 * in each device type. See the Responsive manual for more information.
	 * <p>
	 * The breakpoints that are used by a Responsive instance are unique to that instance (i.e. each table) allowing different breakpoints
	 * to be set for different tables is needed.
	 *
	 * @param breakpoints
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setBreakpoints(Set<DataTablesResponsiveBreakpoint<?>> breakpoints)
	{
		this.breakpoints = breakpoints;
		return (J) this;
	}

	/**
	 * responsive.detailsSince: Responsive Responsive 1.0.0
	 * Enable and configure the child rows shown by Responsive for collapsed tables. Please note - this property requires the Responsive
	 * extension for DataTables.
	 * <p>
	 * Description
	 * Responsive has the ability to use DataTables' child rows feature to show information about any columns which have been removed from
	 * the display as a child row, which can be particularly useful for display complex information on small screen devices. Please see
	 * the Responsive manual on the details rows for further information.
	 * <p>
	 * This options provides the ability to configure how the details rows are handled by Responsive. In its simplest form as a boolean
	 * value, the details row display can be enabled or disabled, while as an object you have the ability to control how the rows are
	 * displayed and the control to show / hide the child rows.
	 * <p>
	 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 *
	 * @return
	 */
	public DataTablesResponsiveDetailOptions<?> getDetails()
	{
		if (details == null)
		{
			details = new DataTablesResponsiveDetailOptions<>();
		}
		return details;
	}

	/**
	 * responsive.detailsSince: Responsive Responsive 1.0.0
	 * Enable and configure the child rows shown by Responsive for collapsed tables. Please note - this property requires the Responsive
	 * extension for DataTables.
	 * <p>
	 * Description
	 * Responsive has the ability to use DataTables' child rows feature to show information about any columns which have been removed from
	 * the display as a child row, which can be particularly useful for display complex information on small screen devices. Please see
	 * the Responsive manual on the details rows for further information.
	 * <p>
	 * This options provides the ability to configure how the details rows are handled by Responsive. In its simplest form as a boolean
	 * value, the details row display can be enabled or disabled, while as an object you have the ability to control how the rows are
	 * displayed and the control to show / hide the child rows.
	 * <p>
	 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 *
	 * @param details
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDetails(DataTablesResponsiveDetailOptions<?> details)
	{
		this.details = details;
		return (J) this;
	}
}
