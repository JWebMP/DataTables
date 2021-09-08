package com.jwebmp.plugins.datatable.options.searchpanes;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class DataTablesSearchPanesDTOptions extends JavaScriptPart<DataTablesSearchPanesDTOptions>
{
	private Boolean paging;
	private String pagingType;
	private Boolean search;
	
	public Boolean getPaging()
	{
		return paging;
	}
	
	public DataTablesSearchPanesDTOptions setPaging(Boolean paging)
	{
		this.paging = paging;
		return this;
	}
	
	public String getPagingType()
	{
		return pagingType;
	}
	
	public DataTablesSearchPanesDTOptions setPagingType(String pagingType)
	{
		this.pagingType = pagingType;
		return this;
	}
	
	public Boolean getSearch()
	{
		return search;
	}
	
	public DataTablesSearchPanesDTOptions setSearch(Boolean search)
	{
		this.search = search;
		return this;
	}
}
