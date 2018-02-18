package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * buttonsSince: Buttons 1.0.0
 * Buttons configuration object. Please note - this property requires the Buttons extension for DataTables.
 * <p>
 * Description
 * This option provides the ability to have a Buttons instance created automatically when a new DataTable is created. The button
 * collection can then be inserted into the DataTables controlled DOM by using the B option in the dom parameter, or through the buttons
 * ().container() API method.
 *
 * @param <J>
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class DataTablesButtonsOptions<J extends DataTablesButtonsOptions<J>> extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	/**
	 * buttons.nameSince: Buttons 1.0.0
	 * Set a name for the instance for the group selector. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * As multiple Buttons instances can be attached to a single DataTable, it can be useful to be able to select each instance
	 * individually. This option provides the ability to set a name for the instance so it can later be selected using the
	 * button-group-selector option of the buttons() and button() API methods.
	 * <p>
	 * The instance name does not need to be unique. If a group selector is given that matches multiple instances, all matching instances
	 * will be selected.
	 */
	private String name;
	/**
	 * buttons.domSince: Buttons 1.0.0
	 * Options to control the DOM structure Buttons creates. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The markup that is created by Buttons is quite flexible in that you can control the tags used and the class names. You can also
	 * optionally control the structure of the markup for the buttons.
	 */
	private DataTablesButtonsDomOptions dom;
	/**
	 * buttons.buttonsSince: Buttons 1.0.0
	 * List of buttons to be created. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The buttons array defines the buttons that will appear in the document to the end user. Each element in the array can be one of:
	 * <p>
	 * string - The name of a built-in button type or plug-in button type. This is the equivalent of using { extend: ... }.
	 * object - A custom button or a customisation of an existing button type. The extend property (see buttons.buttons.extend) can be
	 * defined to tell Buttons which button type to base the button on, and any of the configuration options you wish to customise.
	 * Alternatively, if the extend option is not given, use the text and action options to define a button. Buttons has only a few built
	 * in configuration options for each button, but the various button types may provide additional options. Please refer to the
	 * documentation for each button type for information on the further options they provide.
	 */
	private Set<DataTablesButtonButtonsOptions<?>> buttons;

	/**
	 * buttonsSince: Buttons 1.0.0
	 * Buttons configuration object. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to have a Buttons instance created automatically when a new DataTable is created. The button
	 * collection can then be inserted into the DataTables controlled DOM by using the B option in the dom parameter, or through the
	 * buttons().container() API method.
	 */
	public DataTablesButtonsOptions()
	{
		//No config required
	}

	/**
	 * buttons.nameSince: Buttons 1.0.0
	 * Set a name for the instance for the group selector. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * As multiple Buttons instances can be attached to a single DataTable, it can be useful to be able to select each instance
	 * individually. This option provides the ability to set a name for the instance so it can later be selected using the
	 * button-group-selector option of the buttons() and button() API methods.
	 * <p>
	 * The instance name does not need to be unique. If a group selector is given that matches multiple instances, all matching instances
	 * will be selected.
	 *
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * buttons.nameSince: Buttons 1.0.0
	 * Set a name for the instance for the group selector. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * As multiple Buttons instances can be attached to a single DataTable, it can be useful to be able to select each instance
	 * individually. This option provides the ability to set a name for the instance so it can later be selected using the
	 * button-group-selector option of the buttons() and button() API methods.
	 * <p>
	 * The instance name does not need to be unique. If a group selector is given that matches multiple instances, all matching instances
	 * will be selected.
	 *
	 * @param name
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setName(String name)
	{
		this.name = name;
		return (J) this;
	}

	/**
	 * buttons.domSince: Buttons 1.0.0
	 * Options to control the DOM structure Buttons creates. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The markup that is created by Buttons is quite flexible in that you can control the tags used and the class names. You can also
	 * optionally control the structure of the markup for the buttons.
	 *
	 * @return
	 */
	public DataTablesButtonsDomOptions getDom()
	{
		if (dom == null)
		{
			dom = new DataTablesButtonsDomOptions();
		}
		return dom;
	}

	/**
	 * buttons.domSince: Buttons 1.0.0
	 * Options to control the DOM structure Buttons creates. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The markup that is created by Buttons is quite flexible in that you can control the tags used and the class names. You can also
	 * optionally control the structure of the markup for the buttons.
	 *
	 * @param dom
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDom(DataTablesButtonsDomOptions dom)
	{
		this.dom = dom;
		return (J) this;
	}

	/**
	 * buttons.buttonsSince: Buttons 1.0.0
	 * List of buttons to be created. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The buttons array defines the buttons that will appear in the document to the end user. Each element in the array can be one of:
	 * <p>
	 * string - The name of a built-in button type or plug-in button type. This is the equivalent of using { extend: ... }.
	 * object - A custom button or a customisation of an existing button type. The extend property (see buttons.buttons.extend) can be
	 * defined to tell Buttons which button type to base the button on, and any of the configuration options you wish to customise.
	 * Alternatively, if the extend option is not given, use the text and action options to define a button. Buttons has only a few built
	 * in configuration options for each button, but the various button types may provide additional options. Please refer to the
	 * documentation for each button type for information on the further options they provide.
	 *
	 * @return
	 */
	@NotNull
	public Set<DataTablesButtonButtonsOptions<?>> getButtons()
	{
		if (buttons == null)
		{
			buttons = new LinkedHashSet<>();
		}
		return buttons;
	}

	/**
	 * buttons.buttonsSince: Buttons 1.0.0
	 * List of buttons to be created. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The buttons array defines the buttons that will appear in the document to the end user. Each element in the array can be one of:
	 * <p>
	 * string - The name of a built-in button type or plug-in button type. This is the equivalent of using { extend: ... }.
	 * object - A custom button or a customisation of an existing button type. The extend property (see buttons.buttons.extend) can be
	 * defined to tell Buttons which button type to base the button on, and any of the configuration options you wish to customise.
	 * Alternatively, if the extend option is not given, use the text and action options to define a button. Buttons has only a few built
	 * in configuration options for each button, but the various button types may provide additional options. Please refer to the
	 * documentation for each button type for information on the further options they provide.
	 *
	 * @param buttons
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setButtons(Set<DataTablesButtonButtonsOptions<?>> buttons)
	{
		this.buttons = buttons;
		return (J) this;
	}
}
