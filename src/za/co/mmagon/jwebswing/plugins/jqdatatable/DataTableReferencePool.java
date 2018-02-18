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

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;

/**
 * @author GedMarc
 * @since 09 May 2015
 */
public enum DataTableReferencePool implements ReferencePool
{

	JQueryDataTables(new JavascriptReference("JQueryDataTables", 1.1010, "bower_components/datatables.net/js/jquery.dataTables.min.js",
	                                         "https://cdn.datatables.net/1.10.10/js/jquery.datatables.js"),
	                 new CSSReference("JQueryDTCss", 1.1010, "bower_components/datatables.net-dt/css/jquery.dataTables.min.css",
	                                  "https://cdn.datatables.net/1.10.10/css/jquery.dataTables.css"), 15),


	PDFMake(new JavascriptReference("PDFMake", 1.1010, "bower_components/pdfmake/build/pdfmake.min.js"), null, 16),
	PDFMakeVFSFonts(new JavascriptReference("PDFMakeVSFonts", 1.1010, "bower_components/pdfmake/build/vfs_fonts.min.js"), null, 17),


	Buttons(new JavascriptReference("DTButtons", 1.0, "bower_components/datatables.net-buttons/js/dataTables.buttons.min.js"), null, 18),
	ButtonsColVis(new JavascriptReference("DYButtonsColVis", 1.0, "bower_components/datatables.net-buttons/js/buttons.colVis.min.js"),
	              null,
	              18),
	ButtonsHtml(new JavascriptReference("DTButtonsHtml5", 1.0, "bower_components/datatables.net-buttons/js/buttons.html5.min.js"), null,
	            18),
	ButtonsPrint(new JavascriptReference("DTButtonsPrint", 1.0, "bower_components/datatables.net-buttons/js/buttons.print.min.js"), null,
	             18),


	JSZip(new JavascriptReference("JSZip", 1.1010, "bower_components/jszip/dist/jszip.min.js"), null, 16),;


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
