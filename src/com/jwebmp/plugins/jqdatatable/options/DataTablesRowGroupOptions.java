package com.jwebmp.plugins.jqdatatable.options;

import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * rowGroupSince: RowGroup RowGroup 1.0.0
 * Enable and configure the RowGroup extension for DataTables. Please note - this property requires the RowGroup extension for DataTables.
 * <p>
 * Description
 * RowGroup is an extension for DataTables that provides grouping capabilities (like all other DataTables extensions, the clue is in the
 * name!). A data point in the table's data is used to group information and then display grouping rows before and / or after the group,
 * with options to customise the display of those rows.
 * <p>
 * This option provides the ability to enable and configure RowGroup for DataTables. In its simplest form as the boolean true it will
 * enable RowGroup with the default configuration options (as defined by $.fn.dataTable.RowGroup.defaults). However, it is more likely
 * that you will wish to use it as an object to provide custom configuration options, particularly for the data parameter to use for the
 * grouping (rowGroup.dataSrc).
 * <p>
 * Please note that as with all other configuration options for RowGroup, this option is an extension to the default set of DataTables
 * options. This property should be set in the DataTables initialisation object.
 *
 * @param <J>
 */
public class DataTablesRowGroupOptions<J extends DataTablesRowGroupOptions<J>> extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;
	/**
	 * rowGroup.startClassNameSince: RowGroup RowGroup 1.0.0
	 * Set the class name to be used for the grouping start rows. Please note - this property requires the RowGroup extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When styling a grouped table, you will likely wish to visually distinguish between the start and end grouping rows (if you are
	 * using both), applying different styles to each. This parameter provides the ability to customise the class name that is assigned to
	 * the grouping start rows.
	 * <p>
	 * Note that this class is assigned in addition to the rowGroup.className property, which can be used to provide common styling to
	 * both the start and end rows.
	 */
	private String startClassName;
	/**
	 * rowGroup.endClassNameSince: RowGroup RowGroup 1.0.0
	 * Set the class name to be used for the grouping end rows. Please note - this property requires the RowGroup extension for DataTables.
	 * <p>
	 * Description
	 * When styling a grouped table, you will likely wish to visually distinguish between the end and end grouping rows (if you are using
	 * both), applying different styles to each. This parameter provides the ability to customise the class name that is assigned to the
	 * grouping end rows.
	 * <p>
	 * Note that this class is assigned in addition to the rowGroup.className property, which can be used to provide common styling to
	 * both the end and end rows.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * The class name that will be applied to the grouping end rows, allowing them to be styled in the table.
	 * <p>
	 * Default
	 * Value: group-end
	 */
	private String endClassName;
	/**
	 * rowGroup.enableSince: RowGroup RowGroup 1.0.0
	 * Provides the ability to disable row grouping at initialisation. Please note - this property requires the RowGroup extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When using RowGroup you are most likely to set up an initial grouping configuration for the end user (using the rowGroup.dataSrc)
	 * option. But if you wish to provide the option to have the table initially un-grouped and let the user select the group (rowGroup()
	 * .dataSrc()) this option provides that ability.
	 */
	private Boolean enable;
	/**
	 * rowGroup.dataSrcSince: RowGroup RowGroup 1.0.0
	 * Set the data point to use as the grouping data source. Please note - this property requires the RowGroup extension for DataTables.
	 * <p>
	 * Description
	 * When using RowGroup you are very likely to wish to set this parameter as it provides the software with the information needed to
	 * find the data by which to group the rows in the table.
	 * <p>
	 * It is important to note that if you are using objects as a data source for the table, this property should be set to a string (the
	 * value being the property name for the grouping data), while if you are using arrays, it should be an index matching the column
	 * index for the grouping data.
	 * <p>
	 * When using objects it is not required that the data used for grouping be used in a column (unless you wish to be able to order the
	 * table by that data as well).
	 * <p>
	 * The data source for grouping can be dynamically altered using the rowGroup().dataSrc() method, after the table has been initialised.
	 */
	private String dataSrc;
	/**
	 * rowGroup.classNameSince: RowGroup RowGroup 1.0.0
	 * Set the class name to be used for the grouping rows. Please note - this property requires the RowGroup extension for DataTables.
	 * <p>
	 * Description
	 * When using RowGroup it is important that your end users be able to distinguish between the regular rows in the table and the
	 * grouping rows. This is typically done with CSS and this property provides the ability to customise the class that RowGroup assigns
	 * to each grouping row.
	 * <p>
	 * Note that this class is assigned to both start and end rows.
	 */
	private String className;

	/**
	 * rowGroupSince: RowGroup RowGroup 1.0.0
	 * Enable and configure the RowGroup extension for DataTables. Please note - this property requires the RowGroup extension for
	 * DataTables.
	 * <p>
	 * Description
	 * RowGroup is an extension for DataTables that provides grouping capabilities (like all other DataTables extensions, the clue is in
	 * the name!). A data point in the table's data is used to group information and then display grouping rows before and / or after the
	 * group, with options to customise the display of those rows.
	 * <p>
	 * This option provides the ability to enable and configure RowGroup for DataTables. In its simplest form as the boolean true it will
	 * enable RowGroup with the default configuration options (as defined by $.fn.dataTable.RowGroup.defaults). However, it is more likely
	 * that you will wish to use it as an object to provide custom configuration options, particularly for the data parameter to use for
	 * the grouping (rowGroup.dataSrc).
	 * <p>
	 * Please note that as with all other configuration options for RowGroup, this option is an extension to the default set of DataTables
	 * options. This property should be set in the DataTables initialisation object.
	 */
	public DataTablesRowGroupOptions()
	{
		//No config required
	}

	/**
	 * rowGroup.startClassNameSince: RowGroup RowGroup 1.0.0
	 * Set the class name to be used for the grouping start rows. Please note - this property requires the RowGroup extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When styling a grouped table, you will likely wish to visually distinguish between the start and end grouping rows (if you are
	 * using both), applying different styles to each. This parameter provides the ability to customise the class name that is assigned to
	 * the grouping start rows.
	 * <p>
	 * Note that this class is assigned in addition to the rowGroup.className property, which can be used to provide common styling to
	 * both the start and end rows.
	 *
	 * @return
	 */
	public String getStartClassName()
	{
		return startClassName;
	}

	/**
	 * rowGroup.startClassNameSince: RowGroup RowGroup 1.0.0
	 * Set the class name to be used for the grouping start rows. Please note - this property requires the RowGroup extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When styling a grouped table, you will likely wish to visually distinguish between the start and end grouping rows (if you are
	 * using both), applying different styles to each. This parameter provides the ability to customise the class name that is assigned to
	 * the grouping start rows.
	 * <p>
	 * Note that this class is assigned in addition to the rowGroup.className property, which can be used to provide common styling to
	 * both the start and end rows.
	 *
	 * @param startClassName
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setStartClassName(String startClassName)
	{
		this.startClassName = startClassName;
		return (J) this;
	}

	/**
	 * rowGroup.endClassNameSince: RowGroup RowGroup 1.0.0
	 * Set the class name to be used for the grouping end rows. Please note - this property requires the RowGroup extension for DataTables.
	 * <p>
	 * Description
	 * When styling a grouped table, you will likely wish to visually distinguish between the end and end grouping rows (if you are using
	 * both), applying different styles to each. This parameter provides the ability to customise the class name that is assigned to the
	 * grouping end rows.
	 * <p>
	 * Note that this class is assigned in addition to the rowGroup.className property, which can be used to provide common styling to
	 * both the end and end rows.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * The class name that will be applied to the grouping end rows, allowing them to be styled in the table.
	 * <p>
	 * Default
	 * Value: group-end
	 *
	 * @return
	 */
	public String getEndClassName()
	{
		return endClassName;
	}

	/**
	 * rowGroup.endClassNameSince: RowGroup RowGroup 1.0.0
	 * Set the class name to be used for the grouping end rows. Please note - this property requires the RowGroup extension for DataTables.
	 * <p>
	 * Description
	 * When styling a grouped table, you will likely wish to visually distinguish between the end and end grouping rows (if you are using
	 * both), applying different styles to each. This parameter provides the ability to customise the class name that is assigned to the
	 * grouping end rows.
	 * <p>
	 * Note that this class is assigned in addition to the rowGroup.className property, which can be used to provide common styling to
	 * both the end and end rows.
	 * <p>
	 * Type
	 * string
	 * Description:
	 * The class name that will be applied to the grouping end rows, allowing them to be styled in the table.
	 * <p>
	 * Default
	 * Value: group-end
	 *
	 * @param endClassName
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setEndClassName(String endClassName)
	{
		this.endClassName = endClassName;
		return (J) this;
	}

	/**
	 * rowGroup.enableSince: RowGroup RowGroup 1.0.0
	 * Provides the ability to disable row grouping at initialisation. Please note - this property requires the RowGroup extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When using RowGroup you are most likely to set up an initial grouping configuration for the end user (using the rowGroup.dataSrc)
	 * option. But if you wish to provide the option to have the table initially un-grouped and let the user select the group (rowGroup()
	 * .dataSrc()) this option provides that ability.
	 *
	 * @return
	 */
	public Boolean getEnable()
	{
		return enable;
	}

	/**
	 * rowGroup.enableSince: RowGroup RowGroup 1.0.0
	 * Provides the ability to disable row grouping at initialisation. Please note - this property requires the RowGroup extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When using RowGroup you are most likely to set up an initial grouping configuration for the end user (using the rowGroup.dataSrc)
	 * option. But if you wish to provide the option to have the table initially un-grouped and let the user select the group (rowGroup()
	 * .dataSrc()) this option provides that ability.
	 *
	 * @param enable
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setEnable(Boolean enable)
	{
		this.enable = enable;
		return (J) this;
	}

	/**
	 * rowGroup.dataSrcSince: RowGroup RowGroup 1.0.0
	 * Set the data point to use as the grouping data source. Please note - this property requires the RowGroup extension for DataTables.
	 * <p>
	 * Description
	 * When using RowGroup you are very likely to wish to set this parameter as it provides the software with the information needed to
	 * find the data by which to group the rows in the table.
	 * <p>
	 * It is important to note that if you are using objects as a data source for the table, this property should be set to a string (the
	 * value being the property name for the grouping data), while if you are using arrays, it should be an index matching the column
	 * index for the grouping data.
	 * <p>
	 * When using objects it is not required that the data used for grouping be used in a column (unless you wish to be able to order the
	 * table by that data as well).
	 * <p>
	 * The data source for grouping can be dynamically altered using the rowGroup().dataSrc() method, after the table has been initialised.
	 *
	 * @return
	 */
	public String getDataSrc()
	{
		return dataSrc;
	}

	/**
	 * rowGroup.dataSrcSince: RowGroup RowGroup 1.0.0
	 * Set the data point to use as the grouping data source. Please note - this property requires the RowGroup extension for DataTables.
	 * <p>
	 * Description
	 * When using RowGroup you are very likely to wish to set this parameter as it provides the software with the information needed to
	 * find the data by which to group the rows in the table.
	 * <p>
	 * It is important to note that if you are using objects as a data source for the table, this property should be set to a string (the
	 * value being the property name for the grouping data), while if you are using arrays, it should be an index matching the column
	 * index for the grouping data.
	 * <p>
	 * When using objects it is not required that the data used for grouping be used in a column (unless you wish to be able to order the
	 * table by that data as well).
	 * <p>
	 * The data source for grouping can be dynamically altered using the rowGroup().dataSrc() method, after the table has been initialised.
	 *
	 * @param dataSrc
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDataSrc(String dataSrc)
	{
		this.dataSrc = dataSrc;
		return (J) this;
	}

	/**
	 * rowGroup.classNameSince: RowGroup RowGroup 1.0.0
	 * Set the class name to be used for the grouping rows. Please note - this property requires the RowGroup extension for DataTables.
	 * <p>
	 * Description
	 * When using RowGroup it is important that your end users be able to distinguish between the regular rows in the table and the
	 * grouping rows. This is typically done with CSS and this property provides the ability to customise the class that RowGroup assigns
	 * to each grouping row.
	 * <p>
	 * Note that this class is assigned to both start and end rows.
	 *
	 * @return
	 */
	public String getClassName()
	{
		return className;
	}

	/**
	 * rowGroup.classNameSince: RowGroup RowGroup 1.0.0
	 * Set the class name to be used for the grouping rows. Please note - this property requires the RowGroup extension for DataTables.
	 * <p>
	 * Description
	 * When using RowGroup it is important that your end users be able to distinguish between the regular rows in the table and the
	 * grouping rows. This is typically done with CSS and this property provides the ability to customise the class that RowGroup assigns
	 * to each grouping row.
	 * <p>
	 * Note that this class is assigned to both start and end rows.
	 *
	 * @param className
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setClassName(String className)
	{
		this.className = className;
		return (J) this;
	}
}
