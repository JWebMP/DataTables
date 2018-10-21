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

package com.jwebmp.plugins.datatable.options.buttons;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * buttons.domSince: Buttons 1.0.0
 * Options to control the DOM structure Buttons creates. Please note - this property requires the Buttons extension for DataTables.
 * <p>
 * Description
 * The markup that is created by Buttons is quite flexible in that you can control the tags used and the class names. You can also
 * optionally control the structure of the markup for the buttons.
 *
 * @param <J>
 */
public class DataTablesButtonsDomOptions<J extends DataTablesButtonsDomOptions<J>>
		extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;
	/**
	 * buttons.dom.containerSince: Buttons 1.0.0
	 * DOM configuration of the Buttons container element. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used for the element that contains the buttons that are created for the Buttons control.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <div class="dt-buttons">...</div> that is shown in the example HTML there.
	 */
	private String container;
	/**
	 * buttons.dom.collectionSince: Buttons 1.0.0
	 * DOM configuration of the collection display. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used for the element that is displayed when a collection button is triggered. It in turn
	 * contains the sub-buttons of the collection.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <div class="dt-button-collection">...</div> tag that is shown in the example HTML there.
	 */
	private String collection;
	/**
	 * buttons.dom.buttonLinerSince: Buttons 1.0.0
	 * DOM configuration of a button liner element. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used as the liner for each button. This can be particularly useful for adding complex
	 * styling rules to buttons. It can also be disabled if you wish to have minimal markup in your document.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <span>...</span> button liner element that is shown in the example HTML there.
	 */
	private String buttonLiner;
	/**
	 * buttons.dom.buttonContainerSince: Buttons 1.0.0
	 * DOM configuration of a button container element. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability for each button to be wrapped in another element. This can be useful for cases where the styling
	 * framework requires a list of buttons, where the list element is just a container and not the button itself (Zurb Foundation
	 * requires this for example).
	 * <p>
	 * By default this option is null which means that the button is not wrapped in a container element.
	 */
	private String buttonContainer;
	/**
	 * buttons.dom.buttonSince: Buttons 1.0.0
	 * DOM configuration for individual button elements. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used to create each individual button. With this option the tag type and class name can
	 * be specified using the tag and className properties of this object.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <a class="dt-button">...</a> that is shown in the example HTML there.
	 * <p>
	 * Type
	 * object
	 * Description:
	 * Plain object which will can have the following properties set:
	 * <p>
	 * tag - a string value which defines the HTML tag to use. There should be no spaces or any other formatting - e.g. it should simply
	 * be span, div, a etc.
	 * className - a string value which defines the element's class name. Multiple classes can be given using space separation.
	 * disabled - The class name to assign to the button when the button is in the disabled state.
	 * active - The class name to assign to the button when the button is in the active state.
	 */
	private String button;

	/**
	 * buttonsSince: Buttons 1.0.0
	 * Buttons configuration object. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability to have a Buttons instance created automatically when a new DataTable is created. The button
	 * collection can then be inserted into the DataTables controlled DOM by using the B option in the dom parameter, or through the
	 * buttons().container() API method.
	 */
	public DataTablesButtonsDomOptions()
	{
		//No config required
	}

	/**
	 * buttons.dom.containerSince: Buttons 1.0.0
	 * DOM configuration of the Buttons container element. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used for the element that contains the buttons that are created for the Buttons control.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <div class="dt-buttons">...</div> that is shown in the example HTML there.
	 *
	 * @return
	 */
	public String getContainer()
	{
		return container;
	}

	/**
	 * buttons.dom.containerSince: Buttons 1.0.0
	 * DOM configuration of the Buttons container element. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used for the element that contains the buttons that are created for the Buttons control.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <div class="dt-buttons">...</div> that is shown in the example HTML there.
	 *
	 * @param container
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setContainer(String container)
	{
		this.container = container;
		return (J) this;
	}

	/**
	 * buttons.dom.collectionSince: Buttons 1.0.0
	 * DOM configuration of the collection display. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used for the element that is displayed when a collection button is triggered. It in turn
	 * contains the sub-buttons of the collection.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <div class="dt-button-collection">...</div> tag that is shown in the example HTML there.
	 *
	 * @return
	 */
	public String getCollection()
	{
		return collection;
	}

	/**
	 * buttons.dom.collectionSince: Buttons 1.0.0
	 * DOM configuration of the collection display. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used for the element that is displayed when a collection button is triggered. It in turn
	 * contains the sub-buttons of the collection.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <div class="dt-button-collection">...</div> tag that is shown in the example HTML there.
	 *
	 * @param collection
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCollection(String collection)
	{
		this.collection = collection;
		return (J) this;
	}

	/**
	 * buttons.dom.buttonLinerSince: Buttons 1.0.0
	 * DOM configuration of a button liner element. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used as the liner for each button. This can be particularly useful for adding complex
	 * styling rules to buttons. It can also be disabled if you wish to have minimal markup in your document.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <span>...</span> button liner element that is shown in the example HTML there.
	 *
	 * @return
	 */
	public String getButtonLiner()
	{
		return buttonLiner;
	}

	/**
	 * buttons.dom.buttonLinerSince: Buttons 1.0.0
	 * DOM configuration of a button liner element. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used as the liner for each button. This can be particularly useful for adding complex
	 * styling rules to buttons. It can also be disabled if you wish to have minimal markup in your document.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <span>...</span> button liner element that is shown in the example HTML there.
	 *
	 * @param buttonLiner
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setButtonLiner(String buttonLiner)
	{
		this.buttonLiner = buttonLiner;
		return (J) this;
	}

	/**
	 * buttons.dom.buttonContainerSince: Buttons 1.0.0
	 * DOM configuration of a button container element. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability for each button to be wrapped in another element. This can be useful for cases where the styling
	 * framework requires a list of buttons, where the list element is just a container and not the button itself (Zurb Foundation
	 * requires this for example).
	 * <p>
	 * By default this option is null which means that the button is not wrapped in a container element.
	 *
	 * @return
	 */
	public String getButtonContainer()
	{
		return buttonContainer;
	}

	/**
	 * buttons.dom.buttonContainerSince: Buttons 1.0.0
	 * DOM configuration of a button container element. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option provides the ability for each button to be wrapped in another element. This can be useful for cases where the styling
	 * framework requires a list of buttons, where the list element is just a container and not the button itself (Zurb Foundation
	 * requires this for example).
	 * <p>
	 * By default this option is null which means that the button is not wrapped in a container element.
	 *
	 * @param buttonContainer
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setButtonContainer(String buttonContainer)
	{
		this.buttonContainer = buttonContainer;
		return (J) this;
	}

	/**
	 * buttons.dom.buttonSince: Buttons 1.0.0
	 * DOM configuration for individual button elements. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used to create each individual button. With this option the tag type and class name can
	 * be specified using the tag and className properties of this object.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <a class="dt-button">...</a> that is shown in the example HTML there.
	 * <p>
	 * Type
	 * object
	 * Description:
	 * Plain object which will can have the following properties set:
	 * <p>
	 * tag - a string value which defines the HTML tag to use. There should be no spaces or any other formatting - e.g. it should simply
	 * be span, div, a etc.
	 * className - a string value which defines the element's class name. Multiple classes can be given using space separation.
	 * disabled - The class name to assign to the button when the button is in the disabled state.
	 * active - The class name to assign to the button when the button is in the active state.
	 *
	 * @return
	 */
	public String getButton()
	{
		return button;
	}

	/**
	 * buttons.dom.buttonSince: Buttons 1.0.0
	 * DOM configuration for individual button elements. Please note - this property requires the Buttons extension for DataTables.
	 * <p>
	 * Description
	 * This option controls the HTML tag that is used to create each individual button. With this option the tag type and class name can
	 * be specified using the tag and className properties of this object.
	 * <p>
	 * Please refer to the buttons.dom documentation for an overview of the DOM structure that Buttons will create. In this specific case,
	 * this option controls the <a class="dt-button">...</a> that is shown in the example HTML there.
	 * <p>
	 * Type
	 * object
	 * Description:
	 * Plain object which will can have the following properties set:
	 * <p>
	 * tag - a string value which defines the HTML tag to use. There should be no spaces or any other formatting - e.g. it should simply
	 * be span, div, a etc.
	 * className - a string value which defines the element's class name. Multiple classes can be given using space separation.
	 * disabled - The class name to assign to the button when the button is in the disabled state.
	 * active - The class name to assign to the button when the button is in the active state.
	 *
	 * @param button
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setButton(String button)
	{
		this.button = button;
		return (J) this;
	}
}
