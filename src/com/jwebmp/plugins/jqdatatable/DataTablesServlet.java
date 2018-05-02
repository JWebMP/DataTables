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

package com.jwebmp.plugins.jqdatatable;

import com.google.inject.Singleton;
import com.jwebmp.base.servlets.JWDefaultServlet;
import com.jwebmp.plugins.jqdatatable.events.DataTableDataFetchEvent;
import com.jwebmp.plugins.jqdatatable.search.DataTableSearchRequest;
import com.jwebmp.utilities.StaticStrings;
import org.apache.commons.lang3.exception.ExceptionUtils;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.jwebmp.utilities.StaticStrings.UTF8;

@Singleton
public class DataTablesServlet
		extends JWDefaultServlet
{
	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("DataTablesServlet");

	/**
	 * Post handler
	 *
	 * @param request
	 * @param response
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		super.doGet(request, response);
		processRequest(request);
	}

	/**
	 * Post handler
	 *
	 * @param request
	 * @param response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		super.doGet(request, response);
		processRequest(request);
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request
	 * 		Servlet request
	 */
	protected void processRequest(HttpServletRequest request)
	{
		StringBuilder output = new StringBuilder();
		Set<Class<? extends DataTableDataFetchEvent>> allEvents = GuiceContext.reflect()
		                                                                      .getSubTypesOf(DataTableDataFetchEvent.class);
		Map<String, String[]> params = request.getParameterMap();
		String className = params.get("c")[0];
		allEvents.removeIf(a -> !a.getCanonicalName()
		                          .equals(className.replace('_', '.')));
		if (allEvents.isEmpty())
		{
			writeOutput(output, StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName(UTF8));
			log.fine("DataTablesServlet could not find any specified data search class");
		}
		else
		{
			DataTableSearchRequest searchRequest = new DataTableSearchRequest();
			searchRequest.fromRequestMap(params);
			try
			{
				Class<? extends DataTableDataFetchEvent> event = allEvents.iterator()
				                                                          .next();
				DataTableDataFetchEvent dtd = GuiceContext.getInstance(event);
				DataTableData d = dtd.returnData(searchRequest);
				output.append(d.toString());
				writeOutput(output, StaticStrings.HTML_HEADER_JSON, Charset.forName(UTF8));
			}
			catch (Exception e)
			{
				output.append(ExceptionUtils.getStackTrace(e));
				writeOutput(output, StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName(UTF8));
				log.log(Level.SEVERE, "Unable to execute datatables ajax data fetch", e);
			}
		}
	}
}