package com.jwebmp.plugins.datatable.implementations;

import com.guicedee.client.services.config.IGuiceScanModuleInclusions;

import java.util.Set;

public class DataTablesInclusionModule implements IGuiceScanModuleInclusions<DataTablesInclusionModule>
{
    @Override
    public Set<String> includeModules()
    {
        return Set.of("com.jwebmp.plugins.datatable");
    }
}
