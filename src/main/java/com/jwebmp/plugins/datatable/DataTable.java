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


import com.jwebmp.core.base.angular.client.annotations.angularconfig.*;
import com.jwebmp.core.base.angular.client.annotations.constructors.*;
import com.jwebmp.core.base.angular.client.annotations.functions.*;
import com.jwebmp.core.base.angular.client.annotations.references.*;
import com.jwebmp.core.base.angular.client.annotations.structures.*;
import com.jwebmp.core.base.angular.client.services.interfaces.*;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.plugins.*;
import com.jwebmp.plugins.datatable.enumerations.*;
import com.jwebmp.plugins.datatable.options.*;
import com.jwebmp.plugins.datatable.options.buttons.*;
import jakarta.validation.constraints.*;

import java.util.List;

import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.*;

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

@NgImportReference(value = "ElementRef, ViewChild", reference = "@angular/core")

@NgImportReference(value = "Location", reference = "@angular/common")
@NgConstructorParameter("public location: Location")

@NgField("@ViewChild('datatable')\n" +
         "  private tableRef? : ElementRef;")
@NgField("private datatable? :any;")

//@NgField("private isNew : boolean = false;")



@NgImportReference(value = "Subscription", reference = "rxjs")
@NgField("private subscription? : Subscription")
@NgOnDestroy("this.subscription?.unsubscribe();")

@NgOnDestroy("this.datatable?.destroy();")
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
	public List<String> onInit()
	{
		List<String> out = INgComponent.super.onInit();
		out.add("\t\tthis." + getServiceName() + ".checkData();\n" +
		        "\t\tthis.subscription =  this." + getServiceName() + ".onUpdate\n" +
		        "" +
		        "\t\t.subscribe(data => {\n" +
		        "\t\t\t if (data) {\n" +
		        //   "                alert('new data in');\n" +
		        "\t\t\t\tthis.cdref.detectChanges();\n" +
		     //   "\t\t\t\tthis.isNew = true;\n" +
		        "\t\t\t\tthis.datatable = $('#' + this.tableRef?.nativeElement.id).DataTable({\n" +
		        "\t\t\t\t\t...this.dtOptions\n" +
		        "\t\t\t\t});\n" +
		        "\t\t\t}\n" +
		        "\t\t});\n");
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
		TableRow<?> tableRow = new TableRow<>().addAttribute("*ngFor", "let " + innerLoopVariableName + " of " + getServiceName() + "." + dataService.getAnnotation()
		                                                                                                                                             .variableName());
		getBodyGroup().add(tableRow);
		return tableRow;
	}
	
	
	@Override
	public List<String> componentFields()
	{
		List<String> out = INgComponent.super.componentFields();
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
