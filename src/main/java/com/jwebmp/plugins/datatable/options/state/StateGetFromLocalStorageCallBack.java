package com.jwebmp.plugins.datatable.options.state;

import com.fasterxml.jackson.annotation.*;
import com.jwebmp.core.htmlbuilder.javascript.*;
import com.jwebmp.plugins.datatable.*;

public class StateGetFromLocalStorageCallBack extends JavascriptLiteralFunction<StateGetFromLocalStorageCallBack>
{
	@JsonIgnore
	private DataTable<?,?> table;
	
	public StateGetFromLocalStorageCallBack(DataTable<?, ?> table)
	{
		this.table = table;
		getFunctionArugments().add("settings : any");
	}
	@Override
	public StringBuilder getLiteralFunction()
	{
		return new StringBuilder("if(localStorage.getItem('DataTables_" + table.getID() + "'))" +
		                         "return JSON.parse( <string>localStorage.getItem( 'DataTables_" + table.getID() + "') )\n");
	}
}
