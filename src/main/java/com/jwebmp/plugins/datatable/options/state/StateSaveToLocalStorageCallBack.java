package com.jwebmp.plugins.datatable.options.state;

import com.fasterxml.jackson.annotation.*;
import com.jwebmp.core.htmlbuilder.javascript.*;
import com.jwebmp.plugins.datatable.*;

public class StateSaveToLocalStorageCallBack extends JavascriptLiteralFunction<StateSaveToLocalStorageCallBack>
{
	@JsonIgnore
	private DataTable<?,?> table;
	
	public StateSaveToLocalStorageCallBack(DataTable<?, ?> table)
	{
		this.table = table;
		getFunctionArugments().add("settings : any");
		getFunctionArugments().add("data : any");
	}
	@Override
	public StringBuilder getLiteralFunction()
	{
		return new StringBuilder("localStorage.setItem( 'DataTables_ + " + table.getID() + "', JSON.stringify(data) );");
	}
}
