package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

/**
 * When using KeyTable with Editor to provide an Excel like inline editing experience for the end user, you may wish to control the
 * behaviour of the arrow keys. There are currently two options KeyTable supports:
 * <p>
 * navigation-only - like Excel the current cell will be blurred and the focus moved per the arrow keys.
 * tab-only - more like what might be expected on the web - the arrow keys move the cursor through the text box. Tab can be used to move
 * between cells.
 * The behaviour you might wish to use can be configured through this option. For applications where end users are used to Excel's
 * behaviour you might wish to use the default, while for more general use the tab-only option might be appropriate.
 */
public enum DataTableKeyTableEditorKeys
{
	Naviation_Only,
	Tab_Only;

	@Override
	public String toString()
	{

		return name().toLowerCase();
	}
}
