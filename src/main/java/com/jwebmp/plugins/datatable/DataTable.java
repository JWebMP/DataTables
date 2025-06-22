/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.plugins.datatable;

import com.jwebmp.core.base.angular.client.annotations.constructors.NgConstructorParameter;
import com.jwebmp.core.base.angular.client.annotations.functions.NgOnDestroy;
import com.jwebmp.core.base.angular.client.annotations.references.NgComponentReference;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.typescript.TsDevDependency;
import com.jwebmp.core.base.angular.client.services.EventBusListenerDirective;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.core.base.angular.client.services.interfaces.IComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgServiceProvider;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.plugins.datatable.enumerations.DataTableButtons;
import com.jwebmp.plugins.datatable.options.DataTableOptions;
import com.jwebmp.plugins.datatable.options.buttons.DataTablesButtonButtonsOptions;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.getNgComponentReference;

/**
 * The JWDataTable implementation
 *
 * @param <T> The table row type this table reflects
 * @param <J>
 * @author MMagon
 * @version 1.0
 * @since 2014 09 30
 */
@SuppressWarnings("MissingClassJavaDoc")
@ComponentInformation(name = "Data Tables",
        description = "The core data tables component",
        url = "https://www.datatables.net/")

@TsDevDependency(value = "@types/pdfmake", version = "*")

@NgImportReference(value = "jszip", reference = "jszip", wrapValueInBraces = false)
@NgImportReference(value = "pdfmake", reference = "pdfmake", wrapValueInBraces = false)
@NgImportReference(value = "DataTable", reference = "datatables.net-bs5", wrapValueInBraces = false)
@NgImportReference(value = "DateTime", reference = "datatables.net-datetime", wrapValueInBraces = false)

@NgImportReference(value = "datatables.net-autofill-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-buttons-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-buttons/js/buttons.colVis.mjs", reference = "", direct = true)
@NgImportReference(value = "datatables.net-buttons/js/buttons.html5.mjs", reference = "", direct = true)
@NgImportReference(value = "datatables.net-buttons/js/buttons.print.mjs", reference = "", direct = true)
@NgImportReference(value = "datatables.net-colreorder-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-fixedcolumns-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-fixedheader-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-responsive-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-rowgroup-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-rowreorder-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-scroller-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-searchbuilder-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-searchpanes-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-select-bs5", reference = "", direct = true)
@NgImportReference(value = "datatables.net-staterestore-bs5", reference = "", direct = true)


@NgImportReference(value = "ElementRef, ViewChild", reference = "@angular/core")

@NgImportReference(value = "Location", reference = "@angular/common")
@NgConstructorParameter("public location: Location")

@NgField("@ViewChild('datatable')\n" +
        "  private tableRef? : ElementRef;")
@NgField("private datatable? :any;")


@NgImportReference(value = "Subscription", reference = "rxjs")
@NgField("private subscription? : Subscription")
@NgOnDestroy("this.subscription?.unsubscribe();")

@NgOnDestroy("this.datatable?.destroy();")


@NgImportReference(value = "ChangeDetectorRef", reference = "@angular/core")
@NgConstructorParameter("private cdref : ChangeDetectorRef")
@NgComponentReference(EventBusListenerDirective.class)
public abstract class DataTable<T extends TableRow<?>, J extends DataTable<T, J>>
        extends Table<J>
        implements IDataTable<T, J>, INgComponent<J>
{
    private INgServiceProvider<?> dataService;

    private DataTableOptions<?> options;
    /**
     * The header grouping for a data table
     */
    private TableHeaderGroup<?> headerGroup;
    /**
     * The footer grouping for a data table
     */
    private TableFooterGroup<?> footerGroup;
    /**
     * The table grouping for a data table
     */
    private TableBodyGroup<?> bodyGroup;
    /**
     * The caption item for a table
     */
    private TableCaption<?> captionOfTable;


    /**
     * Construct a new interactive table that is theme compatible, with cell spacing and padding as 0. Sets dynamic feature to disabled
     * <p>
     *
     * @param headerGroup The table header group creating for
     */
    public DataTable(String id, TableHeaderGroup<?> headerGroup)
    {
        this(id, headerGroup, null);
    }

    public DataTable(String id, TableHeaderGroup<?> headerGroup, INgServiceProvider<?> dataService)
    {
        setHeaderGroup(headerGroup);
        setID(id);
        this.dataService = dataService;
        if (this.dataService != null)
        {
            addConfiguration(AnnotationUtils.getNgComponentReference((Class<? extends IComponent<?>>) dataService.getClass()));
        }
    }

    @Override
    public List<NgComponentReference> getComponentReferences()
    {
        List<NgComponentReference> out = INgComponent.super.getComponentReferences();
        if (this.dataService != null)
        {
            out.add(getNgComponentReference((Class<? extends IComponent<?>>) this.dataService.getClass()));
        }
        return out;
    }

    /**
     * Returns this class as a trimmed down accessor for ease of use
     *
     * @return
     */
    public IDataTable<T, J> asMe()
    {
        return this;
    }

    @Override
    public List<String> globalFields()
    {
        return List.of(
                //  "declare var $:any;"
        );
    }

    @Override
    protected void init()
    {
        addAttribute("#datatable", "");
        super.init();
    }

    public boolean renderTable()
    {
        return true;
    }

    @Override
    public List<String> onInit()
    {
        List<String> out = INgComponent.super.onInit();
        out.add(
                //"\t\tthis." + getServiceName() + ".checkData();\n" +
                "\t\tthis.subscription =  this." + getServiceName() + ".onUpdate\n" +
                        "" +
                        "\t\t.subscribe(data => {\n" +
                        "\t\t\t if (data) {\n" +
                        //   "                alert('new data in');\n" +
                        "\t\t\t\tthis.cdref.detectChanges();\n" +
                        //   "\t\t\t\tthis.isNew = true;\n" +
                        // "\t\t\t\tthis.datatable.destroy();" +

                        (!renderTable() ? "" :
                                "\t\t\t\tsetTimeout(()=> {\n" +
                                        "                     this.datatable = new DataTable('#' + this.tableRef?.nativeElement.id, {...this.dtOptions});\n" +
                                        "                },50);\n"
                        ) +
                        "\t\t\t}\n" +
                        "\t\t});\n");
        return out;
    }

    @Override
    public List<String> methods()
    {
        List<String> out = INgComponent.super.methods();
        out.add("""
                public renderTable() {
                        this.datatable = new DataTable('#' + this.tableRef?.nativeElement.id, {...this.dtOptions});
                }
                """);

        return out;
    }

    @Override
    public List<String> constructorBody()
    {
        List<String> out = INgComponent.super.constructorBody();

        //	out.add("this." + getServiceName() + ".checkData();");
        return out;
    }

    @Override
    public List<String> afterViewInit()
    {
        List<String> strings = INgComponent.super.afterViewInit();
        strings.add("this." + getServiceName() + ".checkData();");
        return strings;
    }

    @Override
    public List<String> afterViewChecked()
    {
        List<String> out = INgComponent.super.afterViewInit();
		/*	out.add("if(this.isNew && this." + getServiceName() + "." + dataService.getAnnotation().variableName() + ".length > 0) {\n" +
			        "            try {\n" +
			        "                this.datatable = $('#' + this.tableRef?.nativeElement.id).DataTable({\n" +
			        "                    ...this.dtOptions\n" +
			        "                });\n" +
			        "            } catch (e) {\n" +
			        "                console.log('error on dt', e);\n" +
			        "            }\n" +
			        "            this.isNew = false;\n" +
			        "        }");*/
        //out.add("this." + getServiceName() + ".fetchData();");
        return out;
    }

    @Override
    public List<String> afterContentChecked()
    {
        List<String> out = INgComponent.super.afterContentChecked();
        //out.add("this.cdref.detectChanges();");
        return out;
    }

    /**
     * Creates a new row with the variable 'data' available
     *
     * @return
     */
    @Override
    public TableRow<?> addDataRow()
    {
        return addDataRow("data");
    }

    /**
     * Creates a new row with the variable 'data' available
     *
     * @return
     */
    @Override
    public TableRow<?> addDataRow(String innerLoopVariableName)
    {
        //addAttribute("*ngIf",getServiceName() + "." + dataService.getAnnotation().variableName() + "[0]");
        TableRow<?> tableRow = new TableRow<>().addAttribute("*ngFor", "let " + innerLoopVariableName + " of " + getServiceName() + "." + dataService.getAnnotation()
                .variableName());
        getBodyGroup().add(tableRow);
        return tableRow;
    }


    @Override
    public List<String> fields()
    {
        List<String> out = INgComponent.super.fields();
        out.add("private dtOptions :any = " + getOptions().toJson() + ";");
        return out;
    }

    public boolean resetProviderOnDestroy()
    {
        return true;
    }

    @Override
    public List<String> onDestroy()
    {
        List<String> out = INgComponent.super.onDestroy();
        if (resetProviderOnDestroy())
        {
            out.add("this." + getServiceName() + ".reset();");
        }
        return out;
    }

    @Override
    public DataTableOptions<?> getOptions()
    {
        if (options == null)
        {
            options = new DataTableOptions<>();
        }
        return options;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public J addCopyButton(String className)
    {
        DataTablesButtonButtonsOptions dt = new DataTablesButtonButtonsOptions<>().setExtend(DataTableButtons.Copy);
        if (className != null)
        {
            dt.setClassName(className);
        }
        getOptions()
                .getButtons()
                .add(dt);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public J addCsvButton(String className)
    {
        DataTablesButtonButtonsOptions dt = new DataTablesButtonButtonsOptions<>().setExtend(DataTableButtons.Csv);
        if (className != null)
        {
            dt.setClassName(className);
        }
        getOptions()
                .getButtons()
                .add(dt);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public J addExcelButton(String className)
    {
        DataTablesButtonButtonsOptions dt = new DataTablesButtonButtonsOptions<>().setExtend(DataTableButtons.Excel);
        if (className != null)
        {
            dt.setClassName(className);
        }
        getOptions()
                .getButtons()
                .add(dt);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public J addPdfButton(String className)
    {
        DataTablesButtonButtonsOptions dt = new DataTablesButtonButtonsOptions<>().setExtend(DataTableButtons.Pdf);
        if (className != null)
        {
            dt.setClassName(className);
        }
        getOptions()
                .getButtons()
                .add(dt);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public J addPrintButton(String className)
    {
        DataTablesButtonButtonsOptions dt = new DataTablesButtonButtonsOptions<>().setExtend(DataTableButtons.Print);
        if (className != null)
        {
            dt.setClassName(className);
        }
        getOptions()
                .getButtons()
                .add(dt);
        return (J) this;
    }

    /**
     * Gets the header group for this Data Table
     *
     * @return
     */
    @Override
    @NotNull
    public TableHeaderGroup<?> getHeaderGroup()
    {
        if (headerGroup == null)
        {
            setHeaderGroup(new TableHeaderGroup<>());
        }
        return headerGroup;
    }

    /**
     * Sets the header group for this table
     * <p>
     *
     * @param headerGroup
     */
    @Override
    @SuppressWarnings({"unchecked"})
    @NotNull
    public J setHeaderGroup(TableHeaderGroup<?> headerGroup)
    {
        getChildren().remove(this.headerGroup);
        this.headerGroup = headerGroup;
        if (!getChildren().contains(headerGroup))
        {
            add(headerGroup);
        }

        return (J) this;
    }

    /**
     * Gets the footer group for this data table
     *
     * @return
     */
    @Override
    @SuppressWarnings({"unchecked"})
    @NotNull
    public TableFooterGroup<?> getFooterGroup()
    {
        if (footerGroup == null)
        {
            setFooterGroup(new TableFooterGroup<>());
        }
        return footerGroup;
    }

    /**
     * sets the footer group for this table
     * <p>
     *
     * @param footerGroup
     */
    @Override
    @SuppressWarnings({"unchecked"})
    @NotNull
    public J setFooterGroup(TableFooterGroup<?> footerGroup)
    {
        getChildren().remove(this.footerGroup);
        this.footerGroup = footerGroup;
        if (!getChildren().contains(footerGroup))
        {
            add(footerGroup);
        }
        return (J) this;
    }

    /**
     * Gets the body group for this data table
     *
     * @return
     */
    @Override
    @NotNull
    public TableBodyGroup<?> getBodyGroup()
    {
        if (bodyGroup == null)
        {
            setBodyGroup(new TableBodyGroup<>());
        }
        return bodyGroup;
    }

    /**
     * Returns the Table Caption associated with this object plus positioning utilities
     *
     * @return
     */
    @Override
    public TableCaption<?> getCaptionOfTable()
    {
        if (captionOfTable == null)
        {
            setCaptionOfTable(new TableCaption<>(null));
        }
        return captionOfTable;
    }

    /**
     * Sets the caption for the table
     *
     * @param captionOfTable
     */
    @Override
    @SuppressWarnings({"unchecked"})
    @NotNull
    public J setCaptionOfTable(TableCaption<?> captionOfTable)
    {
        this.captionOfTable = captionOfTable;
        return (J) this;
    }

    /**
     * Sets the body group for the table
     * <p>
     *
     * @param bodyGroup
     */
    @Override
    @SuppressWarnings({"unchecked"})
    @NotNull
    public J setBodyGroup(TableBodyGroup<?> bodyGroup)
    {
        bodyGroup.setID(getID() + "_bodygroup");
        getChildren().remove(this.bodyGroup);
        this.bodyGroup = bodyGroup;
        if (!getChildren().contains(bodyGroup))
        {
            add(bodyGroup);
        }
        return (J) this;
    }

    public String getServiceName()
    {
        if (dataService == null)
        {
            return "dataTableDataService";
        }
        return dataService.getAnnotation()
                .referenceName();
    }
}
