package com.jwebmp.plugins.datatable.options.responsive;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * responsive.breakpointsSince: Responsive Responsive 1.0.0
 * Set the breakpoints for a Responsive instance. Please note - this property requires the Responsive extension for DataTables.
 * <p>
 * Description
 * The visibility of columns in a DataTable with Responsive enabled can be controlled by breakpoints and class names matching those
 * breakpoints (and other logical operations) . This provides the ability to exactly control which columns in a table will be visible in
 * each device type. See the Responsive manual for more information.
 * <p>
 * The breakpoints that are used by a Responsive instance are unique to that instance (i.e. each table) allowing different breakpoints to
 * be set for different tables is needed.
 * <p>
 * The default breakpoints defined by $.fn.dataTable.Responsive.breakpoints is:
 * <p>
 * Javascript
 * [
 * { name: 'desktop',  width: Infinity },
 * { name: 'tablet-l', width: 1024 },
 * { name: 'tablet-p', width: 768 },
 * { name: 'mobile-l', width: 480 },
 * { name: 'mobile-p', width: 320 }
 * ]
 *
 * @param <J>
 */
public class DataTablesResponsiveBreakpoint<J extends DataTablesResponsiveBreakpoint<J>>
		extends JavaScriptPart<J>
		implements Comparable
{


	/**
	 * name - the breakpoint name allowing class targeting. This can be a single word, or append \-[a-z] to provide sub-breakpoints as the
	 * default does to allow, for example, tablet, tablet landscape or tablet portrait breakpoints.
	 */
	private String name;
	/**
	 * width - the width (pixels) of the page viewport at which this breakpoint will apply. The value given is the maximum size at which
	 * this breakpoint will be applied, and it will be used until the next breakpoint is found. For example, if using the default
	 * breakpoints (above), the tablet-l breakpoint will be applied for 768 &lt; x &lt;= 1024 (where x is the viewport width).
	 */
	private Integer width;

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
	 * <p>
	 * The default breakpoints defined by $.fn.dataTable.Responsive.breakpoints is:
	 * <p>
	 * Javascript
	 * [
	 * { name: 'desktop',  width: Infinity },
	 * { name: 'tablet-l', width: 1024 },
	 * { name: 'tablet-p', width: 768 },
	 * { name: 'mobile-l', width: 480 },
	 * { name: 'mobile-p', width: 320 }
	 * ]
	 */
	public DataTablesResponsiveBreakpoint()
	{
		//No config required
	}

	/**
	 * width - the width (pixels) of the page viewport at which this breakpoint will apply. The value given is the maximum size at which
	 * this breakpoint will be applied, and it will be used until the next breakpoint is found. For example, if using the default
	 * breakpoints (above), the tablet-l breakpoint will be applied for 768 &lt; x &lt;= 1024 (where x is the viewport width).
	 *
	 * @return
	 */
	public Integer getWidth()
	{
		return width;
	}

	/**
	 * width - the width (pixels) of the page viewport at which this breakpoint will apply. The value given is the maximum size at which
	 * this breakpoint will be applied, and it will be used until the next breakpoint is found. For example, if using the default
	 * breakpoints (above), the tablet-l breakpoint will be applied for 768 &lt; x &lt;= 1024 (where x is the viewport width).
	 *
	 * @param width
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setWidth(Integer width)
	{
		this.width = width;
		return (J) this;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	@Override
	@SuppressWarnings("all")
	public int compareTo(Object o)
	{
		if (o == null)
		{
			return -1;
		}
		if (!getClass().isAssignableFrom(o.getClass()))
		{
			return -1;
		}
		return getName().compareTo(((DataTablesResponsiveBreakpoint) o).getName());
	}

	/**
	 * name - the breakpoint name allowing class targeting. This can be a single word, or append \-[a-z] to provide sub-breakpoints as the
	 * default does to allow, for example, tablet, tablet landscape or tablet portrait breakpoints.
	 *
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * name - the breakpoint name allowing class targeting. This can be a single word, or append \-[a-z] to provide sub-breakpoints as the
	 * default does to allow, for example, tablet, tablet landscape or tablet portrait breakpoints.
	 *
	 * @param name
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setName(String name)
	{
		this.name = name;
		return (J) this;
	}
}
