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
package com.jwebmp.plugins.datatable;

import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.core.base.servlets.interfaces.ReferencePool;

/**
 * @author GedMarc
 * @since 09 May 2015
 */
public enum DataTableReferencePool
		implements ReferencePool
{

	JQueryDataTables(new JavascriptReference("JQueryDataTables", 1.1010, "bower_components/datatables.net/js/jquery.dataTables.min.js",
	                                         "https://cdn.datatables.net/1.10.10/js/jquery.datatables.js", 15).setPriority(
			RequirementsPriority.Second),
	                 new CSSReference("JQueryDTCss", 1.1010, "bower_components/datatables.net-dt/css/jquery.dataTables.min.css",
	                                  "https://cdn.datatables.net/1.10.10/css/jquery.dataTables.css"), 15),

	PDFMake(new JavascriptReference("PDFMake", 1.1010, "bower_components/pdfmake/build/pdfmake.min.js"), null, 19),
	PDFMakeVFSFonts(new JavascriptReference("PDFMakeVSFonts", 1.1010, "bower_components/pdfmake/build/vfs_fonts.min.js"), null, 19),

	Buttons(new JavascriptReference("DTButtons", 1.0, "bower_components/datatables.net-buttons/js/dataTables.buttons.min.js"), null, 18),

	ButtonsColVis(new JavascriptReference("DYButtonsColVis", 1.0, "bower_components/datatables.net-buttons/js/buttons.colVis.min.js"),
	              null, 21),
	ButtonsHtml(new JavascriptReference("DTButtonsHtml5", 1.0, "bower_components/datatables.net-buttons/js/buttons.html5.min.js"), null,
	            20),
	ButtonsPrint(new JavascriptReference("DTButtonsPrint", 1.0, "bower_components/datatables.net-buttons/js/buttons.print.min.js"), null,
	             22),

	ColReorder(new JavascriptReference("DTColReorder", 1.0, "bower_components/datatables.net-colreorder/js/dataTables.colReorder.min.js"), null, 18),
	FixedColumns(new JavascriptReference("DTFixedColumns", 1.0, "bower_components/datatables.net-fixedcolumns/js/dataTables.fixedColumns.min.js"), null, 18),
	FixedHeaders(new JavascriptReference("DTFixedHeaders", 1.0, "bower_components/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"), null, 18),
	KeyTable(new JavascriptReference("DTKeyTable", 1.0, "bower_components/datatables.net-keytable/js/dataTables.keyTable.min.js"), null, 18),

	JSZip(new JavascriptReference("JSZip", 1.1010, "bower_components/jszip/dist/jszip.min.js"), null, 17),
	;

	private JavascriptReference javaScriptReference;
	private CSSReference cssReference;

	DataTableReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference, int sortOrder)
	{
		this.javaScriptReference = javaScriptReference;
		this.cssReference = cssReference;

		if (this.javaScriptReference != null)
		{
			this.javaScriptReference.setSortOrder(sortOrder);
		}

		if (this.cssReference != null)
		{
			this.cssReference.setSortOrder(sortOrder);
		}
	}

	@Override
	public CSSReference getCssReference()
	{
		return cssReference;
	}

	@Override
	public void setCssReference(CSSReference cssReference)
	{
		this.cssReference = cssReference;
	}

	@Override
	public JavascriptReference getJavaScriptReference()
	{
		return javaScriptReference;
	}

	@Override
	public void setJavaScriptReference(JavascriptReference javaScriptReference)
	{
		this.javaScriptReference = javaScriptReference;
	}
}
