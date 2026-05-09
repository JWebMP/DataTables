package com.jwebmp.plugins.datatable.implementations;

import com.guicedee.client.services.config.IGuiceScanModuleExclusions;

import java.util.Set;

public class DataTablesExclusionsModule
        implements IGuiceScanModuleExclusions<DataTablesExclusionsModule>
{
    @Override
    public Set<String> excludeModules()
    {
        return Set.of("com.jwebmp.plugins.d3.reingoldtilfordtree");
    }
}
