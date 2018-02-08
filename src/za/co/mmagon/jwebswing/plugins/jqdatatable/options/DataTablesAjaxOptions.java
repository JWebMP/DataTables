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
package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import za.co.mmagon.jwebswing.base.client.HttpMethodTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * ajaxSince: DataTables 1.10
 * Load data for the table's content from an Ajax source.
 * <p>
 * Description
 * DataTables can obtain the data that it is to display in the table body from a number of sources, including from an Ajax data source,
 * using this initialisation parameter. As with other dynamic data sources, arrays or objects can be used for the data source for each
 * row, with columns.data employed to read from specific object properties.
 * <p>
 * The ajax property has three different modes of operation, depending on how it is defined. These are:
 * <p>
 * string - Set the URL from where the data should be loaded from.
 * object - Define properties for jQuery.ajax.
 * function - Custom data get function
 *
 * @author GedMarc
 * @since 10 May 2015
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTablesAjaxOptions<J extends DataTablesAjaxOptions<J>> extends JavaScriptPart<J>
{
	/**
	 * The url to hit for the call
	 */
	private String url;
	/**
	 * The method type to hit for the call
	 */
	private HttpMethodTypes type;
	/**
	 * Data Property (locatoion in json returned er var.name.this for table data
	 */
	private String dataSrc;

	private static final long serialVersionUID = 1L;


	/**
	 * ajaxSince: DataTables 1.10
	 * Load data for the table's content from an Ajax source.
	 * <p>
	 * Description
	 * DataTables can obtain the data that it is to display in the table body from a number of sources, including from an Ajax data
	 * source, using this initialisation parameter. As with other dynamic data sources, arrays or objects can be used for the data source
	 * for each row, with columns.data employed to read from specific object properties.
	 * <p>
	 * The ajax property has three different modes of operation, depending on how it is defined. These are:
	 * <p>
	 * string - Set the URL from where the data should be loaded from.
	 * object - Define properties for jQuery.ajax.
	 * function - Custom data get function
	 */
	public DataTablesAjaxOptions()
	{
		//Nothing Needed
	}

	/**
	 * Gets the URL
	 *
	 * @return
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Sets the XHR url to hit
	 *
	 * @param url
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setUrl(String url)
	{
		this.url = url;
		return (J) this;
	}

	/**
	 * Gets the method type for the call
	 *
	 * @return
	 */
	public HttpMethodTypes getType()
	{
		return type;
	}

	/**
	 * Sets the method type for the call
	 *
	 * @param type
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setType(HttpMethodTypes type)
	{
		this.type = type;
		return (J) this;
	}

	/**
	 * Data Property (locatoion in json returned er var.name.this for table data
	 *
	 * @return
	 */
	public String getDataSrc()
	{
		return dataSrc;
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public J setDataSrc(String dataSrc)
	{
		this.dataSrc = dataSrc;
		return (J) this;
	}
}
