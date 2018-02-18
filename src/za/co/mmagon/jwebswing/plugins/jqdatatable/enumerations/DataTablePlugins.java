package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

public enum DataTablePlugins
{
	AutoFill("autoFill", true, true),

	Buttons("buttons", true, true),

	ColReorder("colreorder"),
	FixedColumns("fixedcolumns"),
	FixedHeader("fixedheader"),
	KeyTable("keyTable"),
	Responsive("responsive", false, true),
	RowGroup("rowGroup"),
	RowReorder("rowReorder"),
	Scroller("scroller"),
	Select("select"),
	Sortable("sortable"),;


	private String filename;
	private boolean isPlugin;
	private boolean isCss;

	DataTablePlugins(String filename)
	{
		this(filename, false);
	}

	DataTablePlugins(String filename, boolean isPlugin)
	{
		this(filename, isPlugin, false);
	}

	DataTablePlugins(String filename, boolean isPlugin, boolean isCss)
	{
		this.filename = filename;
		this.isPlugin = isPlugin;
		this.isCss = isCss;
	}

	public String getFilename()
	{
		return filename;
	}

	public boolean isPlugin()
	{
		return isPlugin;
	}

	public boolean isCss()
	{
		return isCss;
	}


}
