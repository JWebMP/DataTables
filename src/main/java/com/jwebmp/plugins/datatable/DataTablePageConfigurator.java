package com.jwebmp.plugins.datatable;

import com.jwebmp.core.base.angular.client.annotations.typescript.TsDependency;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.datatable.enumerations.DataTablesSortables;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DataTables page configurator — registers DataTables.net dependencies for
 * advanced interactive HTML tables with sorting, filtering, pagination, and extensions.
 */
@PluginInformation(pluginName = "Data Tables",
        pluginUniqueName = "data-tables",
        pluginDescription = "DataTables is a jQuery plug-in that adds advanced interaction controls to HTML tables — sorting, filtering, pagination, AJAX data loading, and dozens of extensions.",
        pluginVersion = "2.3.8",
        pluginDependancyUniqueIDs = "jquery",
        pluginCategories = "jquery, datatables, tables, ui, web, framework",
        pluginSubtitle = "Advanced interaction controls for HTML tables with sorting, filtering, pagination, and extensions.",
        pluginGitUrl = "https://github.com/JWebMP/JWebMP",
        pluginSourceUrl = "https://datatables.net/",
        pluginWikiUrl = "https://datatables.net/manual/",
        pluginOriginalHomepage = "https://www.datatables.net/",
        pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins/data-tables",
        pluginIconUrl = "",
        pluginIconImageUrl = "",
        pluginLastUpdatedDate = "2026/05/04",
        pluginGroupId = "com.jwebmp.plugins",
        pluginArtifactId = "data-tables",
        pluginModuleName = "com.jwebmp.plugins.datatable",
        pluginStatus = PluginStatus.Released
)
@TsDependency(value = "datatables.net", version = "^2.3.8")
@TsDependency(value = "datatables.net-dt", version = "^2.3.8")
@TsDependency(value = "jszip", version = "^3.10.1")
@TsDependency(value = "pdfmake", version = "^0.3.7")
public class DataTablePageConfigurator
        implements IPageConfigurator<DataTablePageConfigurator>
{
    private static Set<DataTablesSortables> sortables;

    /**
     * Returns the sortables to apply
     *
     * @return
     */
    public static Set<DataTablesSortables> getSortables()
    {
        if (DataTablePageConfigurator.sortables == null)
        {
            DataTablePageConfigurator.sortables = new LinkedHashSet<>();
        }
        return DataTablePageConfigurator.sortables;
    }

    @Override
    public IPage<?> configure(IPage<?> page)
    {
        return page;
    }

    @Override
    public boolean enabled()
    {
        return true;
    }
}
