package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTablesButtonKeys;

import java.util.LinkedHashMap;
import java.util.Map;

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
 * Alternatively, if the extend option is not given, use the text and action options to define a button. Buttons has only a few built in
 * configuration options for each button, but the various button types may provide additional options. Please refer to the documentation
 * for each button type for information on the further options they provide.
 *
 * @param <J>
 */
public class DataTablesButtonButtonsOptions<J extends DataTablesButtonButtonsOptions<J>> extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	/**
	 * buttons.buttons.attrSince: Buttons 1.5.0
	 * Collection of attribute key / values to set for a button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to set any arbitrary attribute on the button's HTML element in the document. This can be useful
	 * for customisation of attributes such as ARIA assistive attributes, setting a custom id for selection / styling, custom data
	 * parameters, etc.
	 */
	@JsonProperty("attr")
	private Map<String, String> buttonAttributes;
	/**
	 * buttons.buttons.classNameSince: Buttons 1.0.0
	 * Set the class name for the button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The ability to set a class name for a button can be useful both for styling the button and also for selection and manipulation via
	 * the API (buttons() for example). This option provides exactly that ability.
	 * <p>
	 * The class name defined here is added to the class name defined by buttons.buttons.className, so the button will likely have two or
	 * more class names assigned to it.
	 * <p>
	 * Please note that most buttons will define their own class name so they will be style-able without being required to add a custom
	 * class name using you are extending an existing button. Please refer to the documentation for each button type for their default
	 * class name.
	 * <p>
	 * Additionally, if you extend a button that has its own class name defined, any classes you set will automatically be appended to the
	 * extended button's class. It will not overwrite the original class.
	 */
	private String className;
	/**
	 * buttons.buttons.enabledSince: Buttons 1.0.0
	 * Set a button's initial enabled state. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to set the initial enabled state of a button using a boolean value. It is most likely to be of use
	 * when using the API methods that can control the button's enabled state after initialisation:
	 * <p>
	 * buttons().enab
	 */
	private Boolean enabled;
	/**
	 * buttons.buttons.keySince: Buttons 1.0.0
	 * Define an activation key for a button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * Buttons has the built in ability to activate buttons through keyboard key presses and key combinations. This is to aid
	 * accessibility and provide complete keyboard navigation of your table. For example, with using Editor, records can be added, edited
	 * and deleted without touching the mouse!
	 * <p>
	 * Key presses are only processed when the document has no element that is actively focused. This means that typing into an input
	 * element will not accidentally trigger a button's action!
	 * <p>
	 * Please note that for Adobe Flash based buttons, key activation simply will not work! This is a security feature implemented by
	 * Adobe - such buttons must be clicked on to activate them.
	 */
	private DataTablesButtonKeys key;
	/**
	 * buttons.buttons.nameSince: Buttons 1.0.0
	 * Set a name for each selection. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The buttons() and button() API methods provide the ability to use a button-selector to be able to select one or more buttons in one
	 * or more Buttons instances. In turn the button selector provides an option to easily select a button by using a predefined name
	 * (thus removing any complexities that might occur if using index selection). This option provides the ability to set that name.
	 * <p>
	 * Multiple buttons can share the same name, they need not be unique, but please be aware that they will always be selected together
	 * if using a name selector.
	 */
	private String name;
	/**
	 * buttons.buttons.textSince: Buttons 1.0.0
	 * The text to show in the button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * Being able to let your users know what will happen when they activate a button is obviously fundamentally important to the Buttons
	 * extension and this option provides exactly that ability
	 */
	private String text;
	@JsonProperty("titleAttr")
	private String titleAttribute;


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
	public DataTablesButtonButtonsOptions()
	{
		//No config required
	}

	/**
	 * buttons.buttons.attrSince: Buttons 1.5.0
	 * Collection of attribute key / values to set for a button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to set any arbitrary attribute on the button's HTML element in the document. This can be useful
	 * for customisation of attributes such as ARIA assistive attributes, setting a custom id for selection / styling, custom data
	 * parameters, etc.
	 *
	 * @return
	 */
	public Map<String, String> getButtonAttributes()
	{
		if (buttonAttributes == null)
		{
			buttonAttributes = new LinkedHashMap<>();
		}
		return buttonAttributes;
	}

	/**
	 * buttons.buttons.attrSince: Buttons 1.5.0
	 * Collection of attribute key / values to set for a button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to set any arbitrary attribute on the button's HTML element in the document. This can be useful
	 * for customisation of attributes such as ARIA assistive attributes, setting a custom id for selection / styling, custom data
	 * parameters, etc.
	 *
	 * @param buttonAttributes
	 *
	 * @return
	 */
	public J setButtonAttributes(Map<String, String> buttonAttributes)
	{
		this.buttonAttributes = buttonAttributes;
		return (J) this;
	}

	/**
	 * buttons.buttons.classNameSince: Buttons 1.0.0
	 * Set the class name for the button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The ability to set a class name for a button can be useful both for styling the button and also for selection and manipulation via
	 * the API (buttons() for example). This option provides exactly that ability.
	 * <p>
	 * The class name defined here is added to the class name defined by buttons.buttons.className, so the button will likely have two or
	 * more class names assigned to it.
	 * <p>
	 * Please note that most buttons will define their own class name so they will be style-able without being required to add a custom
	 * class name using you are extending an existing button. Please refer to the documentation for each button type for their default
	 * class name.
	 * <p>
	 * Additionally, if you extend a button that has its own class name defined, any classes you set will automatically be appended to the
	 * extended button's class. It will not overwrite the original class.
	 *
	 * @return
	 */
	public String getClassName()
	{
		return className;
	}

	/**
	 * buttons.buttons.classNameSince: Buttons 1.0.0
	 * Set the class name for the button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The ability to set a class name for a button can be useful both for styling the button and also for selection and manipulation via
	 * the API (buttons() for example). This option provides exactly that ability.
	 * <p>
	 * The class name defined here is added to the class name defined by buttons.buttons.className, so the button will likely have two or
	 * more class names assigned to it.
	 * <p>
	 * Please note that most buttons will define their own class name so they will be style-able without being required to add a custom
	 * class name using you are extending an existing button. Please refer to the documentation for each button type for their default
	 * class name.
	 * <p>
	 * Additionally, if you extend a button that has its own class name defined, any classes you set will automatically be appended to the
	 * extended button's class. It will not overwrite the original class.
	 *
	 * @param className
	 *
	 * @return
	 */
	public J setClassName(String className)
	{
		this.className = className;
		return (J) this;
	}

	/**
	 * buttons.buttons.enabledSince: Buttons 1.0.0
	 * Set a button's initial enabled state. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to set the initial enabled state of a button using a boolean value. It is most likely to be of use
	 * when using the API methods that can control the button's enabled state after initialisation:
	 * <p>
	 * buttons().enab
	 *
	 * @return
	 */
	public Boolean getEnabled()
	{
		return enabled;
	}

	/**
	 * buttons.buttons.enabledSince: Buttons 1.0.0
	 * Set a button's initial enabled state. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to set the initial enabled state of a button using a boolean value. It is most likely to be of use
	 * when using the API methods that can control the button's enabled state after initialisation:
	 * <p>
	 * buttons().enab
	 *
	 * @param enabled
	 *
	 * @return
	 */
	public J setEnabled(Boolean enabled)
	{
		this.enabled = enabled;
		return (J) this;
	}

	/**
	 * buttons.buttons.keySince: Buttons 1.0.0
	 * Define an activation key for a button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * Buttons has the built in ability to activate buttons through keyboard key presses and key combinations. This is to aid
	 * accessibility and provide complete keyboard navigation of your table. For example, with using Editor, records can be added, edited
	 * and deleted without touching the mouse!
	 * <p>
	 * Key presses are only processed when the document has no element that is actively focused. This means that typing into an input
	 * element will not accidentally trigger a button's action!
	 * <p>
	 * Please note that for Adobe Flash based buttons, key activation simply will not work! This is a security feature implemented by
	 * Adobe - such buttons must be clicked on to activate them.
	 *
	 * @return
	 */
	public DataTablesButtonKeys getKey()
	{
		return key;
	}

	/**
	 * buttons.buttons.keySince: Buttons 1.0.0
	 * Define an activation key for a button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * Buttons has the built in ability to activate buttons through keyboard key presses and key combinations. This is to aid
	 * accessibility and provide complete keyboard navigation of your table. For example, with using Editor, records can be added, edited
	 * and deleted without touching the mouse!
	 * <p>
	 * Key presses are only processed when the document has no element that is actively focused. This means that typing into an input
	 * element will not accidentally trigger a button's action!
	 * <p>
	 * Please note that for Adobe Flash based buttons, key activation simply will not work! This is a security feature implemented by
	 * Adobe - such buttons must be clicked on to activate them.
	 *
	 * @param key
	 *
	 * @return
	 */
	public J setKey(DataTablesButtonKeys key)
	{
		this.key = key;
		return (J) this;
	}

	/**
	 * buttons.buttons.nameSince: Buttons 1.0.0
	 * Set a name for each selection. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The buttons() and button() API methods provide the ability to use a button-selector to be able to select one or more buttons in one
	 * or more Buttons instances. In turn the button selector provides an option to easily select a button by using a predefined name
	 * (thus removing any complexities that might occur if using index selection). This option provides the ability to set that name.
	 * <p>
	 * Multiple buttons can share the same name, they need not be unique, but please be aware that they will always be selected together
	 * if using a name selector.
	 *
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * buttons.buttons.nameSince: Buttons 1.0.0
	 * Set a name for each selection. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * The buttons() and button() API methods provide the ability to use a button-selector to be able to select one or more buttons in one
	 * or more Buttons instances. In turn the button selector provides an option to easily select a button by using a predefined name
	 * (thus removing any complexities that might occur if using index selection). This option provides the ability to set that name.
	 * <p>
	 * Multiple buttons can share the same name, they need not be unique, but please be aware that they will always be selected together
	 * if using a name selector.
	 *
	 * @param name
	 *
	 * @return
	 */
	public J setName(String name)
	{
		this.name = name;
		return (J) this;
	}

	/**
	 * buttons.buttons.textSince: Buttons 1.0.0
	 * The text to show in the button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * Being able to let your users know what will happen when they activate a button is obviously fundamentally important to the Buttons
	 * extension and this option provides exactly that ability
	 *
	 * @return
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * buttons.buttons.textSince: Buttons 1.0.0
	 * The text to show in the button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * Being able to let your users know what will happen when they activate a button is obviously fundamentally important to the Buttons
	 * extension and this option provides exactly that ability
	 *
	 * @param text
	 *
	 * @return
	 */
	public J setText(String text)
	{
		this.text = text;
		return (J) this;
	}

	/**
	 * buttons.buttons.textSince: Buttons 1.0.0
	 * The text to show in the button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * Being able to let your users know what will happen when they activate a button is obviously fundamentally important to the Buttons
	 * extension and this option provides exactly that ability
	 *
	 * @return
	 */
	public String getTitleAttribute()
	{
		return titleAttribute;
	}

	/**
	 * buttons.buttons.textSince: Buttons 1.0.0
	 * The text to show in the button. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * Being able to let your users know what will happen when they activate a button is obviously fundamentally important to the Buttons
	 * extension and this option provides exactly that ability
	 *
	 * @param titleAttribute
	 *
	 * @return
	 */
	public J setTitleAttribute(String titleAttribute)
	{
		this.titleAttribute = titleAttribute;
		return (J) this;
	}
}
