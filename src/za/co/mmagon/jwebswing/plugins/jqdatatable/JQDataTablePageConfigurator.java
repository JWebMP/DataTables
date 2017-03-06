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
package za.co.mmagon.jwebswing.plugins.jqdatatable;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.plugins.PluginInformation;

/**
 *
 * @author GedMarc
 */
@PluginInformation(pluginName = "Data Tables",
                   pluginUniqueName = "data-tables",
                   pluginDescription = "DataTables is a plug-in for the jQuery Javascript library. It is a highly flexible tool, based upon the foundations of progressive enhancement, and will add advanced interaction controls to any HTML table.",
                   pluginVersion = "1.10.13",
                   pluginDependancyUniqueIDs = "jquery",
                   pluginCategories = "jquery,datatables, tables, ui, web, framework",
                   pluginSubtitle = "DataTables is very simple to use as a jQuery plug-in with a huge range of customisable option",
                   pluginGitUrl = "https://github.com/GedMarc/JWebSwing-DataTablesPlugin",
                   pluginSourceUrl = "https://datatables.net/download/index",
                   pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-DataTablesPlugin/wiki",
                   pluginOriginalHomepage = "https://www.datatables.net/",
                   pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/DataTablesPlugin.jar/download",
                   pluginIconUrl = "bower_components/datatables/icon.jpg",
                   pluginIconImageUrl = "bower_components/datatables/jqdatatables_logo.png",
                   pluginLastUpdatedDate = "2017/03/04"
)
public class JQDataTablePageConfigurator extends PageConfigurator
{

    private static final long serialVersionUID = 1L;

    @Override
    public Page configure(Page page)
    {
        return page;
    }

}
