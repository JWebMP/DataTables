package com.jwebmp.plugins.datatable.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class DataTablesExclusionsModule
		implements IGuiceScanModuleExclusions<DataTablesExclusionsModule>
{
	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.d3.reingoldtilfordtree");
		return strings;
	}
}
