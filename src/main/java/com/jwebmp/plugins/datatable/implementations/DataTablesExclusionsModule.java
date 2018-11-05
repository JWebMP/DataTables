package com.jwebmp.plugins.datatable.implementations;

import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class DataTablesExclusionsModule
		implements IGuiceScanModuleExclusions<DataTablesExclusionsModule>,
				           IGuiceScanJarExclusions<DataTablesExclusionsModule>
{

	@Override
	public @NotNull Set<String> excludeJars()
	{
		Set<String> strings = new HashSet<>();
		strings.add("jwebmp-data-tables-*");
		return strings;
	}

	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.d3.reingoldtilfordtree");
		return strings;
	}
}
