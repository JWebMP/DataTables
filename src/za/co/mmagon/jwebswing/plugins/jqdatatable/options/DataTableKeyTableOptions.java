package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations.DataTableKeyTableEditorKeys;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Spreadsheet navigation of a DataTable can make not only for an attractive and rapid data input interface, but also for a very familiar
 * one well suited for those used to Excel, OpenOffice or similar and now transitioning to web based apps.
 * <p>
 * KeyTable adds keyboard navigation to DataTables, operating in exactly the same way as a traditional spreadsheet application. Combined
 * with AutoFill and Editor's inline editing a true spreadsheet like environment can be created. Furthermore, using the keyboard
 * accessibility features of Buttons allows a fully editable DataTable to be accessed using the keyboard only.
 *
 * @param <J>
 */
public class DataTableKeyTableOptions<J extends DataTableKeyTableOptions<J>> extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;

	/**
	 * keys.blurableSince: KeyTable KeyTable 2.0.0
	 * Allow KeyTable's focus to be blurred (removed) from a table. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * By default KeyTable will make the table act like a normal input element in an HTML page and the tab key can be used to move focus
	 * between fields. Tabbing when focused on the last cell in the table will then move the focus on to the next form element in the
	 * document - thus blurring the table.
	 * <p>
	 * This ability to loose focus (blurring) can be disabled in KeyTable by setting this option to false. That means that once the table
	 * has been focused (which it can be automatically using keys.focus) focus cannot be removed (although interaction can be disabled
	 * using keys.disable()).
	 */
	private Boolean blurable;
	/**
	 * keys.classNameSince: KeyTable KeyTable 2.0.0
	 * Set the class name used for the focused cell. Please note - this property requires the KeyTable extension for DataTables.
	 * <p>
	 * Description
	 * Allowing the end user to visually identify which cell has focus is obviously fundamentally important to KeyTable's abilities, and
	 * this is done by added a class to the focused cell. This class can then be styled using CSS to visually highlight the cell. The CSS
	 * outline property is useful for this, and is the styling option used by the KeyTable default stylesheet.
	 * <p>
	 * This property can be used to alter the class name used to show cell focus.
	 */
	private String className;
	/**
	 * keys.columnsSince: KeyTable 2.0.0
	 * Select the columns that can gain focus. Please note - this property requires the KeyTable extension for DataTables.
	 * <p>
	 * Description
	 * When working with complex tables it is not uncommon to have certain columns that you might not wish to allow spreadsheet like
	 * navigation on (for example a checkbox column for row selection or a column with editing action buttons). This option can be used to
	 * define which columns can receive focus. If a column cannot receive focus KeyTable will skip over it as if it was not present.
	 * <p>
	 * Please note that only visible cells can receive focus, so the columns defined by this option are automatically merged with the
	 * visible columns in the table. Non-visible columns will not receive focus
	 */
	private Set<Integer> columns;
	/**
	 * keys.editAutoSelectSince: KeyTable KeyTable 2.3.0
	 * Set if Editor should automatically select the text in the input. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When KeyTable is used to navigate a table and activate inline editing, it will, by default, automatically select the text in the
	 * input element. This provides an editing interface which acts very much like Excel - start typing and it will replace the existing
	 * values with the new text.
	 */
	private Boolean editAutoSelect;
	/**
	 * keys.editOnFocusSince: KeyTable KeyTable 2.3.0
	 * Control if editing should be activated immediately upon focus. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When used with Editor (keys.editor), inline editing will not be triggered by KeyTable until a key value is pressed when a cell is
	 * focused (similar to Excel). However, you may wish to immediately place the cell into edit mode when the focus happens. This option
	 * provides that ability.
	 */
	private Boolean editOnFocus;
	/**
	 * When using KeyTable with Editor to provide an Excel like inline editing experience for the end user, you may wish to control the
	 * behaviour of the arrow keys. There are currently two options KeyTable supports:
	 * <p>
	 * navigation-only - like Excel the current cell will be blurred and the focus moved per the arrow keys.
	 * tab-only - more like what might be expected on the web - the arrow keys move the cursor through the text box. Tab can be used to
	 * move between cells.
	 * The behaviour you might wish to use can be configured through this option. For applications where end users are used to Excel's
	 * behaviour you might wish to use the default, while for more general use the tab-only option might be appropriate.
	 */
	private DataTableKeyTableEditorKeys editorKeys;
	/**
	 * keys.focusSince: KeyTable KeyTable 2.0.0
	 * Cell to receive initial focus in the table. Please note - this property requires the KeyTable extension for DataTables.
	 * <p>
	 * Description
	 * This option can be used to define what cell in the table (if any) will automatically receive focus when the table is initialised
	 * with KeyTable enabled.
	 * <p>
	 * The value of this option will be over-ridden if state saving is enabled in DataTables (stateSave) and there is a saved focused cell
	 * - i.e. the state saved focused cell will instead receive the focus.
	 * <p>
	 * Type
	 * cell-selector
	 * Description:
	 * The cell that will receive focus when the table is initialised. This accepts all of the options of cell-selector such as class name
	 * selector, jQuery pseudo selects and cell index selectors.
	 * <p>
	 * Default
	 * Value: null
	 * The table will not automatically receive focus when initialised
	 * <p>
	 * Example
	 * Automatically focus on the first cell in the table:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * 4
	 * 5
	 * $('#myTable').DataTable( {
	 * keys: {
	 * focus: ':eq(0)'
	 * }
	 * } );
	 */
	private String focus;
	/**
	 * eys.keysSince: KeyTable KeyTable 2.0.0
	 * Limit the keys that KeyTable will listen for and take action on. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * This option can be used to gain fine control over which keys that KeyTable will listen for. The keys.enable() and keys.disable()
	 * methods can be used to enable and disable KeyTable completely, but this option provides the ability to specify the character codes
	 * that KeyTable will take action on when enabled.
	 * <p>
	 * This can be used, for example, to listen only for arrow and return keys (effectively disabling the tab key), or only the tab key.
	 * <p>
	 * You can hard code the character code values if you wish, but a more flexible and potentially understandable option is to use the
	 * String.charCodeAt() method to obtain a character code - for example to get the tab key use "\t".charCodeAt(0).
	 * <p>
	 * Type
	 * array|null
	 * Description:
	 * As null KeyTable will listen for all key presses, regardless of what key is pressed. As an array you can limit the keys that
	 * KeyTable will take action on to just the key codes given in the array.
	 * <p>
	 * Default
	 * Value: null
	 * Listen for all keys
	 * <p>
	 * Example
	 * Listen for the tab key only:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * 4
	 * 5
	 * $('#myTable').DataTable( {
	 * keys: {
	 * keys: [ "\t".charCodeAt(0) ]
	 * }
	 * } );
	 */
	private Set<Character> keys;
	/**
	 * keys.tabIndexSince: KeyTable KeyTable 2.0.0
	 * Set the table's tab index for when it will receive focus. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * Browser's have complex built in algorithms that define which element will receive focus when the tab key is pressed by the end user
	 * . The tab index attribute for HTML elements can be used to control this behaviour, focusing focus to follow a route defined by the
	 * developer rather than the end user. This option can be used to define the tab index of the KeyTable enhanced DataTable in the
	 * documents tab flow.
	 * <p>
	 * Type
	 * integer
	 * Description:
	 * The tab index for the table. Like all other tab indexes, this can be -1 to disallow tabbing into the table.
	 */
	private Integer tabIndex;

	/**
	 * Spreadsheet navigation of a DataTable can make not only for an attractive and rapid data input interface, but also for a very
	 * familiar one well suited for those used to Excel, OpenOffice or similar and now transitioning to web based apps.
	 * <p>
	 * KeyTable adds keyboard navigation to DataTables, operating in exactly the same way as a traditional spreadsheet application.
	 * Combined with AutoFill and Editor's inline editing a true spreadsheet like environment can be created. Furthermore, using the
	 * keyboard accessibility features of Buttons allows a fully editable DataTable to be accessed using the keyboard only.
	 */
	public DataTableKeyTableOptions()
	{
		//No Config Needed
	}

	/**
	 * keys.blurableSince: KeyTable KeyTable 2.0.0
	 * Allow KeyTable's focus to be blurred (removed) from a table. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * By default KeyTable will make the table act like a normal input element in an HTML page and the tab key can be used to move focus
	 * between fields. Tabbing when focused on the last cell in the table will then move the focus on to the next form element in the
	 * document - thus blurring the table.
	 * <p>
	 * This ability to loose focus (blurring) can be disabled in KeyTable by setting this option to false. That means that once the table
	 * has been focused (which it can be automatically using keys.focus) focus cannot be removed (although interaction can be disabled
	 * using keys.disable()).
	 *
	 * @return
	 */
	public Boolean getBlurable()
	{
		return blurable;
	}

	/**
	 * keys.blurableSince: KeyTable KeyTable 2.0.0
	 * Allow KeyTable's focus to be blurred (removed) from a table. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * By default KeyTable will make the table act like a normal input element in an HTML page and the tab key can be used to move focus
	 * between fields. Tabbing when focused on the last cell in the table will then move the focus on to the next form element in the
	 * document - thus blurring the table.
	 * <p>
	 * This ability to loose focus (blurring) can be disabled in KeyTable by setting this option to false. That means that once the table
	 * has been focused (which it can be automatically using keys.focus) focus cannot be removed (although interaction can be disabled
	 * using keys.disable()).
	 *
	 * @param blurable
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setBlurable(Boolean blurable)
	{
		this.blurable = blurable;
		return (J) this;
	}

	/**
	 * keys.classNameSince: KeyTable KeyTable 2.0.0
	 * Set the class name used for the focused cell. Please note - this property requires the KeyTable extension for DataTables.
	 * <p>
	 * Description
	 * Allowing the end user to visually identify which cell has focus is obviously fundamentally important to KeyTable's abilities, and
	 * this is done by added a class to the focused cell. This class can then be styled using CSS to visually highlight the cell. The CSS
	 * outline property is useful for this, and is the styling option used by the KeyTable default stylesheet.
	 * <p>
	 * This property can be used to alter the class name used to show cell focus.
	 *
	 * @return
	 */
	public String getClassName()
	{
		return className;
	}

	/**
	 * keys.classNameSince: KeyTable KeyTable 2.0.0
	 * Set the class name used for the focused cell. Please note - this property requires the KeyTable extension for DataTables.
	 * <p>
	 * Description
	 * Allowing the end user to visually identify which cell has focus is obviously fundamentally important to KeyTable's abilities, and
	 * this is done by added a class to the focused cell. This class can then be styled using CSS to visually highlight the cell. The CSS
	 * outline property is useful for this, and is the styling option used by the KeyTable default stylesheet.
	 * <p>
	 * This property can be used to alter the class name used to show cell focus.
	 *
	 * @param className
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setClassName(String className)
	{
		this.className = className;
		return (J) this;
	}

	/**
	 * keys.columnsSince: KeyTable 2.0.0
	 * Select the columns that can gain focus. Please note - this property requires the KeyTable extension for DataTables.
	 * <p>
	 * Description
	 * When working with complex tables it is not uncommon to have certain columns that you might not wish to allow spreadsheet like
	 * navigation on (for example a checkbox column for row selection or a column with editing action buttons). This option can be used to
	 * define which columns can receive focus. If a column cannot receive focus KeyTable will skip over it as if it was not present.
	 * <p>
	 * Please note that only visible cells can receive focus, so the columns defined by this option are automatically merged with the
	 * visible columns in the table. Non-visible columns will not receive focus
	 *
	 * @return
	 */
	public Set<Integer> getColumns()
	{
		if (columns == null)
		{
			columns = new HashSet<>();
		}
		return columns;
	}

	/**
	 * keys.columnsSince: KeyTable 2.0.0
	 * Select the columns that can gain focus. Please note - this property requires the KeyTable extension for DataTables.
	 * <p>
	 * Description
	 * When working with complex tables it is not uncommon to have certain columns that you might not wish to allow spreadsheet like
	 * navigation on (for example a checkbox column for row selection or a column with editing action buttons). This option can be used to
	 * define which columns can receive focus. If a column cannot receive focus KeyTable will skip over it as if it was not present.
	 * <p>
	 * Please note that only visible cells can receive focus, so the columns defined by this option are automatically merged with the
	 * visible columns in the table. Non-visible columns will not receive focus
	 *
	 * @param columns
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setColumns(Set<Integer> columns)
	{
		this.columns = columns;
		return (J) this;
	}

	/**
	 * keys.editAutoSelectSince: KeyTable KeyTable 2.3.0
	 * Set if Editor should automatically select the text in the input. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When KeyTable is used to navigate a table and activate inline editing, it will, by default, automatically select the text in the
	 * input element. This provides an editing interface which acts very much like Excel - start typing and it will replace the existing
	 * values with the new text.
	 *
	 * @return
	 */
	public Boolean getEditAutoSelect()
	{
		return editAutoSelect;
	}

	/**
	 * keys.editAutoSelectSince: KeyTable KeyTable 2.3.0
	 * Set if Editor should automatically select the text in the input. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When KeyTable is used to navigate a table and activate inline editing, it will, by default, automatically select the text in the
	 * input element. This provides an editing interface which acts very much like Excel - start typing and it will replace the existing
	 * values with the new text.
	 *
	 * @param editAutoSelect
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setEditAutoSelect(Boolean editAutoSelect)
	{
		this.editAutoSelect = editAutoSelect;
		return (J) this;
	}

	/**
	 * keys.editOnFocusSince: KeyTable KeyTable 2.3.0
	 * Control if editing should be activated immediately upon focus. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When used with Editor (keys.editor), inline editing will not be triggered by KeyTable until a key value is pressed when a cell is
	 * focused (similar to Excel). However, you may wish to immediately place the cell into edit mode when the focus happens. This option
	 * provides that ability.
	 *
	 * @return
	 */
	public Boolean getEditOnFocus()
	{
		return editOnFocus;
	}

	/**
	 * keys.editOnFocusSince: KeyTable KeyTable 2.3.0
	 * Control if editing should be activated immediately upon focus. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * When used with Editor (keys.editor), inline editing will not be triggered by KeyTable until a key value is pressed when a cell is
	 * focused (similar to Excel). However, you may wish to immediately place the cell into edit mode when the focus happens. This option
	 * provides that ability.
	 *
	 * @param editOnFocus
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setEditOnFocus(Boolean editOnFocus)
	{
		this.editOnFocus = editOnFocus;
		return (J) this;
	}

	/**
	 * When using KeyTable with Editor to provide an Excel like inline editing experience for the end user, you may wish to control the
	 * behaviour of the arrow keys. There are currently two options KeyTable supports:
	 * <p>
	 * navigation-only - like Excel the current cell will be blurred and the focus moved per the arrow keys.
	 * tab-only - more like what might be expected on the web - the arrow keys move the cursor through the text box. Tab can be used to
	 * move between cells.
	 * The behaviour you might wish to use can be configured through this option. For applications where end users are used to Excel's
	 * behaviour you might wish to use the default, while for more general use the tab-only option might be appropriate.
	 *
	 * @return
	 */
	public DataTableKeyTableEditorKeys getEditorKeys()
	{
		return editorKeys;
	}

	/**
	 * When using KeyTable with Editor to provide an Excel like inline editing experience for the end user, you may wish to control the
	 * behaviour of the arrow keys. There are currently two options KeyTable supports:
	 * <p>
	 * navigation-only - like Excel the current cell will be blurred and the focus moved per the arrow keys.
	 * tab-only - more like what might be expected on the web - the arrow keys move the cursor through the text box. Tab can be used to
	 * move between cells.
	 * The behaviour you might wish to use can be configured through this option. For applications where end users are used to Excel's
	 * behaviour you might wish to use the default, while for more general use the tab-only option might be appropriate.
	 *
	 * @param editorKeys
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setEditorKeys(DataTableKeyTableEditorKeys editorKeys)
	{
		this.editorKeys = editorKeys;
		return (J) this;
	}

	/**
	 * keys.focusSince: KeyTable KeyTable 2.0.0
	 * Cell to receive initial focus in the table. Please note - this property requires the KeyTable extension for DataTables.
	 * <p>
	 * Description
	 * This option can be used to define what cell in the table (if any) will automatically receive focus when the table is initialised
	 * with KeyTable enabled.
	 * <p>
	 * The value of this option will be over-ridden if state saving is enabled in DataTables (stateSave) and there is a saved focused cell
	 * - i.e. the state saved focused cell will instead receive the focus.
	 * <p>
	 * Type
	 * cell-selector
	 * Description:
	 * The cell that will receive focus when the table is initialised. This accepts all of the options of cell-selector such as class name
	 * selector, jQuery pseudo selects and cell index selectors.
	 * <p>
	 * Default
	 * Value: null
	 * The table will not automatically receive focus when initialised
	 * <p>
	 * Example
	 * Automatically focus on the first cell in the table:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * 4
	 * 5
	 * $('#myTable').DataTable( {
	 * keys: {
	 * focus: ':eq(0)'
	 * }
	 * } );
	 *
	 * @return
	 */
	public String getFocus()
	{
		return focus;
	}

	/**
	 * keys.focusSince: KeyTable KeyTable 2.0.0
	 * Cell to receive initial focus in the table. Please note - this property requires the KeyTable extension for DataTables.
	 * <p>
	 * Description
	 * This option can be used to define what cell in the table (if any) will automatically receive focus when the table is initialised
	 * with KeyTable enabled.
	 * <p>
	 * The value of this option will be over-ridden if state saving is enabled in DataTables (stateSave) and there is a saved focused cell
	 * - i.e. the state saved focused cell will instead receive the focus.
	 * <p>
	 * Type
	 * cell-selector
	 * Description:
	 * The cell that will receive focus when the table is initialised. This accepts all of the options of cell-selector such as class name
	 * selector, jQuery pseudo selects and cell index selectors.
	 * <p>
	 * Default
	 * Value: null
	 * The table will not automatically receive focus when initialised
	 * <p>
	 * Example
	 * Automatically focus on the first cell in the table:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * 4
	 * 5
	 * $('#myTable').DataTable( {
	 * keys: {
	 * focus: ':eq(0)'
	 * }
	 * } );
	 *
	 * @param focus
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setFocus(String focus)
	{
		this.focus = focus;
		return (J) this;
	}

	/**
	 * eys.keysSince: KeyTable KeyTable 2.0.0
	 * Limit the keys that KeyTable will listen for and take action on. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * This option can be used to gain fine control over which keys that KeyTable will listen for. The keys.enable() and keys.disable()
	 * methods can be used to enable and disable KeyTable completely, but this option provides the ability to specify the character codes
	 * that KeyTable will take action on when enabled.
	 * <p>
	 * This can be used, for example, to listen only for arrow and return keys (effectively disabling the tab key), or only the tab key.
	 * <p>
	 * You can hard code the character code values if you wish, but a more flexible and potentially understandable option is to use the
	 * String.charCodeAt() method to obtain a character code - for example to get the tab key use "\t".charCodeAt(0).
	 * <p>
	 * Type
	 * array|null
	 * Description:
	 * As null KeyTable will listen for all key presses, regardless of what key is pressed. As an array you can limit the keys that
	 * KeyTable will take action on to just the key codes given in the array.
	 * <p>
	 * Default
	 * Value: null
	 * Listen for all keys
	 * <p>
	 * Example
	 * Listen for the tab key only:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * 4
	 * 5
	 * $('#myTable').DataTable( {
	 * keys: {
	 * keys: [ "\t".charCodeAt(0) ]
	 * }
	 * } );
	 *
	 * @return
	 */
	public Set<Character> getKeys()
	{
		if (keys == null)
		{
			keys = new LinkedHashSet<>();
		}
		return keys;
	}

	/**
	 * eys.keysSince: KeyTable KeyTable 2.0.0
	 * Limit the keys that KeyTable will listen for and take action on. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * This option can be used to gain fine control over which keys that KeyTable will listen for. The keys.enable() and keys.disable()
	 * methods can be used to enable and disable KeyTable completely, but this option provides the ability to specify the character codes
	 * that KeyTable will take action on when enabled.
	 * <p>
	 * This can be used, for example, to listen only for arrow and return keys (effectively disabling the tab key), or only the tab key.
	 * <p>
	 * You can hard code the character code values if you wish, but a more flexible and potentially understandable option is to use the
	 * String.charCodeAt() method to obtain a character code - for example to get the tab key use "\t".charCodeAt(0).
	 * <p>
	 * Type
	 * array|null
	 * Description:
	 * As null KeyTable will listen for all key presses, regardless of what key is pressed. As an array you can limit the keys that
	 * KeyTable will take action on to just the key codes given in the array.
	 * <p>
	 * Default
	 * Value: null
	 * Listen for all keys
	 * <p>
	 * Example
	 * Listen for the tab key only:
	 * <p>
	 * Javascript
	 * 1
	 * 2
	 * 3
	 * 4
	 * 5
	 * $('#myTable').DataTable( {
	 * keys: {
	 * keys: [ "\t".charCodeAt(0) ]
	 * }
	 * } );
	 *
	 * @param keys
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setKeys(Set<Character> keys)
	{
		this.keys = keys;
		return (J) this;
	}

	/**
	 * keys.tabIndexSince: KeyTable KeyTable 2.0.0
	 * Set the table's tab index for when it will receive focus. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * Browser's have complex built in algorithms that define which element will receive focus when the tab key is pressed by the end user
	 * . The tab index attribute for HTML elements can be used to control this behaviour, focusing focus to follow a route defined by the
	 * developer rather than the end user. This option can be used to define the tab index of the KeyTable enhanced DataTable in the
	 * documents tab flow.
	 * <p>
	 * Type
	 * integer
	 * Description:
	 * The tab index for the table. Like all other tab indexes, this can be -1 to disallow tabbing into the table.
	 *
	 * @return
	 */
	public Integer getTabIndex()
	{
		return tabIndex;
	}

	/**
	 * keys.tabIndexSince: KeyTable KeyTable 2.0.0
	 * Set the table's tab index for when it will receive focus. Please note - this property requires the KeyTable extension for
	 * DataTables.
	 * <p>
	 * Description
	 * Browser's have complex built in algorithms that define which element will receive focus when the tab key is pressed by the end user
	 * . The tab index attribute for HTML elements can be used to control this behaviour, focusing focus to follow a route defined by the
	 * developer rather than the end user. This option can be used to define the tab index of the KeyTable enhanced DataTable in the
	 * documents tab flow.
	 * <p>
	 * Type
	 * integer
	 * Description:
	 * The tab index for the table. Like all other tab indexes, this can be -1 to disallow tabbing into the table.
	 *
	 * @param tabIndex
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTabIndex(Integer tabIndex)
	{
		this.tabIndex = tabIndex;
		return (J) this;
	}
}
