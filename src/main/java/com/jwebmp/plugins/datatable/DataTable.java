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

import com.jwebmp.core.base.angular.services.annotations.angularconfig.*;
import com.jwebmp.core.base.angular.services.annotations.references.*;
import com.jwebmp.core.base.angular.services.annotations.structures.*;
import com.jwebmp.core.base.angular.services.interfaces.*;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.html.attributes.*;
import com.jwebmp.core.plugins.*;
import com.jwebmp.plugins.datatable.enumerations.*;
import com.jwebmp.plugins.datatable.options.*;
import com.jwebmp.plugins.datatable.options.buttons.*;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.*;

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

@NgImportReference(name = "AfterViewInit,AfterViewChecked", reference = "@angular/core")

@NgScript(value = "jszip/dist/jszip.min.js", sortOrder = 50)
@NgScript(value = "pdfmake/build/pdfmake.min.js", sortOrder = 50)
@NgScript(value = "pdfmake/build/vfs_fonts.js", sortOrder = 50)

@NgScript(value = "datatables.net/js/jquery.dataTables.js", sortOrder = 51)

@NgScript(value = "datatables.net-autofill/js/dataTables.autoFill.js", sortOrder = 52)
@NgScript(value = "datatables.net-buttons/js/dataTables.buttons.js", sortOrder = 52)
@NgScript(value = "datatables.net-buttons/js/buttons.colVis.js", sortOrder = 52)
@NgScript(value = "datatables.net-buttons/js/buttons.flash.js", sortOrder = 52)
@NgScript(value = "datatables.net-buttons/js/buttons.html5.js", sortOrder = 52)
@NgScript(value = "datatables.net-buttons/js/buttons.print.js", sortOrder = 52)
@NgScript(value = "datatables.net-colreorder/js/dataTables.colReorder.js", sortOrder = 52)
@NgStyleSheet(value = "datatables.net-datetime/dist/dataTables.dateTime.css", sortOrder = 52)
@NgScript(value = "datatables.net-datetime/dist/dataTables.dateTime.js", sortOrder = 52)
@NgScript(value = "datatables.net-fixedcolumns/js/dataTables.fixedColumns.js", sortOrder = 52)
@NgScript(value = "datatables.net-fixedheader/js/dataTables.fixedHeader.js", sortOrder = 52)
@NgScript(value = "datatables.net-keytable/js/dataTables.keyTable.js", sortOrder = 52)
@NgScript(value = "datatables.net-responsive/js/dataTables.responsive.js", sortOrder = 52)
@NgScript(value = "datatables.net-rowgroup/js/dataTables.rowGroup.js", sortOrder = 52)
@NgScript(value = "datatables.net-scroller/js/dataTables.scroller.js", sortOrder = 52)
@NgScript(value = "datatables.net-searchbuilder/js/dataTables.searchBuilder.js", sortOrder = 52)
@NgScript(value = "datatables.net-searchpanes/js/dataTables.searchPanes.js", sortOrder = 52)
@NgScript(value = "datatables.net-select/js/dataTables.select.js", sortOrder = 52)
@NgScript(value = "datatables.net-staterestore/js/dataTables.stateRestore.js", sortOrder = 52)

@NgImportReference(name = "ElementRef, ViewChild, OnDestroy", reference = "@angular/core")

@NgField("@ViewChild('datatable')\n" +
         "  private tableRef? : ElementRef;")

public abstract class DataTable<T extends TableRow<?>, J extends DataTable<T, J>>
		extends Table<J>
		implements IDataTable<T, J>, INgComponent<J>
{
	private DataTableDataService<?> dataService;
	
	/**
	 *
	 */
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
	
	public DataTable(String id, TableHeaderGroup<?> headerGroup, DataTableDataService<?> dataService)
	{
		addAttribute(TableAttributes.CellSpacing, 0);
		addAttribute(TableAttributes.CellPadding, 0);
		setHeaderGroup(headerGroup);
		setID(id);
		this.dataService = dataService;
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
				"declare var $:any;"
		);
	}
	
	@Override
	public void init()
	{
		addAttribute("#datatable", "");
		super.init();
	}
	
	@Override
	public List<String> componentInterfaces()
	{
		return List.of("AfterViewInit",
				"OnDestroy",
				"AfterViewChecked"
		);
	}
	
	@Override
	public List<String> componentMethods()
	{
		return List.of(
				"ngAfterViewInit(): void {\n" +
				"        this.dataTableDataServiceExample.data.subscribe((dd) => {\n" +
			//	"            console.log(\"data loaded///\");\n" +
				"            this.data = dd;\n" +
				"            this.updated = true;\n" +
				"        });\n" +
				"    }" +
				"" +
				"ngOnDestroy(): void {\n" +
				"this.datatable?.destroy();" +
				"\t}" +
				"" +
				"ngAfterViewChecked(): void {\n" +
			//	"        console.log(\"after view changed///\");\n" +
				"\n" +
				"        if(this.data && this.data.out && this.data.out.length > 0 && this.updated) {\n" +
		//		"            console.log(\"doing table...\");\n" +
				"            this.updated = false;\n" +
				"            if (!this.datatable) {\n" +
				"                this.datatable = $('#' + this.tableRef?.nativeElement.id).dataTable({\n" +
				"                    ...this.dtOptions\n" +
				"                });\n" +
				"            } else {\n" +
		//		"                console.log(\"recreating the table...\"); " +
				"               this.datatable = $('#' + this.tableRef?.nativeElement.id).dataTable({\n" +
				"                    ...this.dtOptions,\n" +
				"                    retrieve: true\n" +
				"                });\n" +
				"            }\n" +
				"        }\n" +
				"    }"
		);
	}
	
	/**
	 * Creates a new row with the variable 'data' available
	 *
	 * @return
	 */
	@Override
	public TableRow<?> addDataRow()
	{
		TableRow<?> tableRow = new TableRow<>().addAttribute("*ngFor", "let data of data?.out");
		getBodyGroup().add(tableRow);
		return tableRow;
	}
	
	@Override
	public List<String> componentFields()
	{
		return List.of("private dtOptions :any = " + getOptions().toJson() + ";",
				"private datatable? :any;" +
				"" +
				"data?: any;" +
				"private updated : boolean = false;"
		);
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
		String name = ITSComponent.getTsFilename(dataService.getClass());
		name = name.substring(0, 1)
		           .toLowerCase() + name.substring(1);
		return name;
	}
	
	@Override
	public List<String> componentConstructorParameters()
	{
		List<String> out = new ArrayList<>();
		if (dataService != null)
		{
			out.add("public " + getServiceName() + " : " + dataService.getClass()
			                                                          .getSimpleName());
		}
		return out;
	}
	
}
