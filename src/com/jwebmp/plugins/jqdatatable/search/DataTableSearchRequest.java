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

package com.jwebmp.plugins.jqdatatable.search;

import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.jqdatatable.enumerations.DataTableSorts;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Denotes a search request from a data table. All fields should be filled in
 *
 * @param <J>
 */
public class DataTableSearchRequest<J extends DataTableSearchRequest<J>>
		extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	private static final Pattern columnPattern = Pattern.compile("columns\\[(\\d)\\]\\[(.*)\\].*");
	private static final Pattern orderPattern = Pattern.compile("order\\[(\\d)\\]\\[(.*)\\].*");

	private Map<Integer, DataTableSearchColumnCriteria> columns;
	private Map<Integer, DataTableSearchOrderByCriteria> orderBys;

	private Integer length;
	private Integer start;
	private Integer draw;

	private Boolean searchRegex;
	private String searchValue;

	public void fromRequestMap(Map<String, String[]> params)
	{
		Map<String, String> readable = new TreeMap<>();
		params.forEach((key, value) ->
		               {
			               if (value != null)
			               {
				               readable.put(key, value[0]);
			               }
		               });

		readable.forEach((key, value) ->
		                 {
			                 switch (key)
			                 {
				                 case "c":
				                 {
					                 break;
				                 }
				                 case "length":
				                 {
					                 length = Integer.parseInt(value);
					                 break;
				                 }
				                 case "start":
				                 {
					                 start = Integer.parseInt(value);
					                 break;
				                 }
				                 case "draw":
				                 {
					                 draw = Integer.parseInt(value);
					                 break;
				                 }
				                 case "search[regex]":
				                 {
					                 searchRegex = Boolean.parseBoolean(value);
					                 break;
				                 }
				                 case "search[value]":
				                 {
					                 searchValue = value;
					                 break;
				                 }
				                 default:
				                 {
					                 if (key.startsWith("column"))
					                 {
						                 processColumn(key, value);
					                 }
					                 else if (key.startsWith("order"))
					                 {
						                 processOrder(key, value);

					                 }
				                 }
			                 }
		                 });
	}

	private void processColumn(String key, String value)
	{
		Matcher match = columnPattern.matcher(key);
		if (match.find())
		{
			String group1 = match.group(1);
			String group2 = match.group(2);
			group2 = group2.replaceAll("\\]", "\\.")
			               .replaceAll("\\[", "");

			if (getColumns().get(Integer.parseInt(group1)) == null)
			{
				getColumns().put(Integer.parseInt(group1), new DataTableSearchColumnCriteria());
			}
			DataTableSearchColumnCriteria column = getColumns().get(Integer.parseInt(group1));
			switch (group2)
			{
				case "name":
				{
					column.setName(value);
					break;
				}
				case "orderable":
				{
					column.setOrderable(Boolean.parseBoolean(value));
					break;
				}
				case "search.regex":
				{
					column.setSearchRegex(Boolean.parseBoolean(value));
					break;
				}
				case "search.value":
				{
					column.setSearchValue(value);
					break;
				}
				case "searchable":
				{
					column.setSearchable(Boolean.parseBoolean(value));
					break;
				}
				default:
				{
					break;
				}
			}
		}
	}

	private void processOrder(String key, String value)
	{
		Matcher match = orderPattern.matcher(key);
		if (match.find())
		{
			String group1 = match.group(1);
			String group2 = match.group(2);
			group2 = group2.replaceAll("\\]", "\\.")
			               .replaceAll("\\[", "");
			if (getOrderBys().get(Integer.parseInt(group1)) == null)
			{
				getOrderBys().put(Integer.parseInt(group1), new DataTableSearchOrderByCriteria());
			}
			DataTableSearchOrderByCriteria column = getOrderBys().get(Integer.parseInt(group1));
			switch (group2)
			{
				case "column":
				{
					column.setColumnNumber(Integer.parseInt(value));
					break;
				}
				case "dir":
				{
					column.setDirection(DataTableSorts.fromValue(value));
					break;
				}
				default:
				{
					break;
				}
			}
		}
	}

	/**
	 * Gets the columns
	 *
	 * @return
	 */
	@NotNull
	public Map<Integer, DataTableSearchColumnCriteria> getColumns()
	{
		if (columns == null)
		{
			columns = new TreeMap<>();
		}
		return columns;
	}

	/**
	 * Gets the order by criteria's map
	 *
	 * @return
	 */
	public Map<Integer, DataTableSearchOrderByCriteria> getOrderBys()
	{
		if (orderBys == null)
		{
			orderBys = new TreeMap<>();
		}
		return orderBys;
	}

	/**
	 * Sets the order bys map
	 *
	 * @param orderBys
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setOrderBys(Map<Integer, DataTableSearchOrderByCriteria> orderBys)
	{
		this.orderBys = orderBys;
		return (J) this;
	}

	/**
	 * Sets the columns
	 *
	 * @param columns
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setColumns(Map<Integer, DataTableSearchColumnCriteria> columns)
	{
		this.columns = columns;
		return (J) this;
	}

	/**
	 * Returns the number of rows to return
	 *
	 * @return
	 */
	public Integer getLength()
	{
		return length;
	}

	/**
	 * Sets the number of rows to retrieve
	 *
	 * @param length
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setLength(Integer length)
	{
		this.length = length;
		return (J) this;
	}

	/**
	 * Gets the starting row this table needs data from
	 *
	 * @return
	 */
	public Integer getStart()
	{
		return start;
	}

	/**
	 * The numberth time this table has been called
	 *
	 * @param start
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setStart(Integer start)
	{
		this.start = start;
		return (J) this;
	}

	/**
	 * The numberth time this table has called
	 *
	 * @return
	 */
	public Integer getDraw()
	{
		return draw;
	}

	/**
	 * The numberth time this data table has called
	 *
	 * @param draw
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDraw(Integer draw)
	{
		this.draw = draw;
		return (J) this;
	}

	/**
	 * If the search value should be regex
	 *
	 * @return
	 */
	public Boolean getSearchRegex()
	{
		return searchRegex;
	}

	/**
	 * If the search value should be regex
	 *
	 * @param searchRegex
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearchRegex(Boolean searchRegex)
	{
		this.searchRegex = searchRegex;
		return (J) this;
	}

	/**
	 * Gets the search value
	 *
	 * @return
	 */
	public String getSearchValue()
	{
		return searchValue;
	}

	/**
	 * Sets the search value
	 *
	 * @param searchValue
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearchValue(String searchValue)
	{
		this.searchValue = searchValue;
		return (J) this;
	}
}
