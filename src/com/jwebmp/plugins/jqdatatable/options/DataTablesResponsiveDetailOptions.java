package com.jwebmp.plugins.jqdatatable.options;

import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * responsive.detailsSince: Responsive Responsive 1.0.0
 * Enable and configure the child rows shown by Responsive for collapsed tables. Please note - this property requires the Responsive
 * extension for DataTables.
 * <p>
 * Description
 * Responsive has the ability to use DataTables' child rows feature to show information about any columns which have been removed from
 * the display as a child row, which can be particularly useful for display complex information on small screen devices. Please see the
 * Responsive manual on the details rows for further information.
 * <p>
 * This options provides the ability to configure how the details rows are handled by Responsive. In its simplest form as a boolean
 * value, the details row display can be enabled or disabled, while as an object you have the ability to control how the rows are
 * displayed and the control to show / hide the child rows.
 * <p>
 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of DataTables
 * options. This property should be set in the DataTables initialisation object.
 *
 * @param <J>
 */
public class DataTablesResponsiveDetailOptions<J extends DataTablesResponsiveDetailOptions<J>> extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	/**
	 * responsive.details.typeSince: Responsive Responsive 1.0.0
	 * Set the child row display control type. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * Responsive has two built in methods of managing how the child row display control is shown to the end user:
	 * <p>
	 * inline - where the first column in the table has additional padding added to it and the :before pseudo element is used to display
	 * the button.
	 * column - where a whole column is dedicated to the show / hide control.
	 */
	private DataTablesResponsiveDetailTypes type;
	/**
	 * responsive.details.targetSince: Responsive Responsive 1.0.0
	 * Column / selector for child row display control when using column details type. Please note - this property requires the Responsive
	 * extension for DataTables.
	 * <p>
	 * Description
	 * When the column type is selected for the responsive.details.type option, this option provides the ability to control what element
	 * in the table will activate the show / hide control in each row. This can be one of an column index, or a jQuery selector, as
	 * detailed below.
	 * <p>
	 * If the inline option is used for responsive.details.type this option has no effect.
	 * <p>
	 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 * <p>
	 * Types
	 * number
	 * Description:
	 * Column index to which the show / hide control should be attached. This can be &gt;0 to count columns from the left, or &lt;0 to
	 * count
	 * from the right.
	 * <p>
	 * Please note that the column defined here should have the class control added to it. This allows the Responsive CSS to display a
	 * control icon to the end user.
	 */
	private Integer target;
	/**
	 * responsive.details.rendererSince: Responsive Responsive 1.0.0
	 * Define the renderer used to display the child rows. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * The information contained in the details rows that are displayed by Responsive are created through this function. By default it
	 * will create a ul / li list showing the data from cells that are hidden, or you can use one of the other built in renderers, or
	 * provide your own.
	 * <p>
	 * The rendering function is executed for details display in a table, and is run whenever the column visibility of the table changes.
	 * <p>
	 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 * <p>
	 * Since v2.1.0 Responsive has a number of built in rendering functions which can be accessed from the $.fn.dataTable.Responsive
	 * .renderer object. The built in renderers are provided as functions that must be executed and will return the required renderer.
	 * This provides the ability to pass in options to the renderer.
	 * <p>
	 * The built in options are:
	 * <p>
	 * listHidden - Show the data that has been hidden in an ul / li list.
	 * No additional options
	 * Default renderer
	 * tableAll - Show the data for all columns (regardless of if they have been hidden or not) in a table.
	 * Single option: tableClass - the class name to apply to the created table.
	 */
	private DataTablesResponsiveDetailRenderer renderer;

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
	public DataTablesResponsiveDetailOptions()
	{
		//No config required
	}

	/**
	 * responsive.details.typeSince: Responsive Responsive 1.0.0
	 * Set the child row display control type. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * Responsive has two built in methods of managing how the child row display control is shown to the end user:
	 * <p>
	 * inline - where the first column in the table has additional padding added to it and the :before pseudo element is used to display
	 * the button.
	 * column - where a whole column is dedicated to the show / hide control.
	 *
	 * @return
	 */
	public DataTablesResponsiveDetailTypes getType()
	{
		return type;
	}

	/**
	 * responsive.details.typeSince: Responsive Responsive 1.0.0
	 * Set the child row display control type. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * Responsive has two built in methods of managing how the child row display control is shown to the end user:
	 * <p>
	 * inline - where the first column in the table has additional padding added to it and the :before pseudo element is used to display
	 * the button.
	 * column - where a whole column is dedicated to the show / hide control.
	 *
	 * @param type
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setType(DataTablesResponsiveDetailTypes type)
	{
		this.type = type;
		return (J) this;
	}

	/**
	 * responsive.details.targetSince: Responsive Responsive 1.0.0
	 * Column / selector for child row display control when using column details type. Please note - this property requires the Responsive
	 * extension for DataTables.
	 * <p>
	 * Description
	 * When the column type is selected for the responsive.details.type option, this option provides the ability to control what element
	 * in the table will activate the show / hide control in each row. This can be one of an column index, or a jQuery selector, as
	 * detailed below.
	 * <p>
	 * If the inline option is used for responsive.details.type this option has no effect.
	 * <p>
	 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 * <p>
	 * Types
	 * number
	 * Description:
	 * Column index to which the show / hide control should be attached. This can be &gt;0 to count columns from the left, or &lt;0 to count
	 * from the right.
	 * <p>
	 * Please note that the column defined here should have the class control added to it. This allows the Responsive CSS to display a
	 * control icon to the end user.
	 *
	 * @return
	 */
	public Integer getTarget()
	{
		return target;
	}

	/**
	 * responsive.details.targetSince: Responsive Responsive 1.0.0
	 * Column / selector for child row display control when using column details type. Please note - this property requires the Responsive
	 * extension for DataTables.
	 * <p>
	 * Description
	 * When the column type is selected for the responsive.details.type option, this option provides the ability to control what element
	 * in the table will activate the show / hide control in each row. This can be one of an column index, or a jQuery selector, as
	 * detailed below.
	 * <p>
	 * If the inline option is used for responsive.details.type this option has no effect.
	 * <p>
	 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 * <p>
	 * Types
	 * number
	 * Description:
	 * Column index to which the show / hide control should be attached. This can be &gt;0 to count columns from the left, or &lt;0 to count
	 * from the right.
	 * <p>
	 * Please note that the column defined here should have the class control added to it. This allows the Responsive CSS to display a
	 * control icon to the end user.
	 *
	 * @param target
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTarget(Integer target)
	{
		this.target = target;
		return (J) this;
	}

	/**
	 * responsive.details.rendererSince: Responsive Responsive 1.0.0
	 * Define the renderer used to display the child rows. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * The information contained in the details rows that are displayed by Responsive are created through this function. By default it
	 * will create a ul / li list showing the data from cells that are hidden, or you can use one of the other built in renderers, or
	 * provide your own.
	 * <p>
	 * The rendering function is executed for details display in a table, and is run whenever the column visibility of the table changes.
	 * <p>
	 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 * <p>
	 * Since v2.1.0 Responsive has a number of built in rendering functions which can be accessed from the $.fn.dataTable.Responsive
	 * .renderer object. The built in renderers are provided as functions that must be executed and will return the required renderer.
	 * This provides the ability to pass in options to the renderer.
	 * <p>
	 * The built in options are:
	 * <p>
	 * listHidden - Show the data that has been hidden in an ul / li list.
	 * No additional options
	 * Default renderer
	 * tableAll - Show the data for all columns (regardless of if they have been hidden or not) in a table.
	 * Single option: tableClass - the class name to apply to the created table.
	 *
	 * @return
	 */
	public DataTablesResponsiveDetailRenderer getRenderer()
	{
		return renderer;
	}

	/**
	 * responsive.details.rendererSince: Responsive Responsive 1.0.0
	 * Define the renderer used to display the child rows. Please note - this property requires the Responsive extension for DataTables.
	 * <p>
	 * Description
	 * The information contained in the details rows that are displayed by Responsive are created through this function. By default it
	 * will create a ul / li list showing the data from cells that are hidden, or you can use one of the other built in renderers, or
	 * provide your own.
	 * <p>
	 * The rendering function is executed for details display in a table, and is run whenever the column visibility of the table changes.
	 * <p>
	 * Please note that as with all other configuration options for Responsive, this option is an extension to the default set of
	 * DataTables options. This property should be set in the DataTables initialisation object.
	 * <p>
	 * Since v2.1.0 Responsive has a number of built in rendering functions which can be accessed from the $.fn.dataTable.Responsive
	 * .renderer object. The built in renderers are provided as functions that must be executed and will return the required renderer.
	 * This provides the ability to pass in options to the renderer.
	 * <p>
	 * The built in options are:
	 * <p>
	 * listHidden - Show the data that has been hidden in an ul / li list.
	 * No additional options
	 * Default renderer
	 * tableAll - Show the data for all columns (regardless of if they have been hidden or not) in a table.
	 * Single option: tableClass - the class name to apply to the created table.
	 *
	 * @param renderer
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRenderer(DataTablesResponsiveDetailRenderer renderer)
	{
		this.renderer = renderer;
		return (J) this;
	}
}
