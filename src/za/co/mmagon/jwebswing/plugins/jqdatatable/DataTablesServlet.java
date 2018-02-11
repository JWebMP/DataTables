package za.co.mmagon.jwebswing.plugins.jqdatatable;

import com.google.inject.Singleton;
import org.apache.commons.lang3.exception.ExceptionUtils;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.jwebswing.base.servlets.JWDefaultServlet;
import za.co.mmagon.jwebswing.plugins.jqdatatable.events.DataTableDataFetchEvent;
import za.co.mmagon.jwebswing.utilities.StaticStrings;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.UTF8;

@Singleton
public class DataTablesServlet extends JWDefaultServlet
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
		allEvents.removeIf(a -> !a.getCanonicalName()
				                         .equals(request.getParameter("clazz")
						                                 .replace('_', '.')));
		if (allEvents.isEmpty())
		{
			writeOutput(output, StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName(UTF8));
			log.fine("DataTablesServlet could not find any specified data search class");
		}
		else
		{
			try
			{
				Class<? extends DataTableDataFetchEvent> event = allEvents.iterator()
						                                                 .next();
				DataTableDataFetchEvent dtd = GuiceContext.getInstance(event);
				DataTableData d = dtd.returnData();
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
