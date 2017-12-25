package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

/**
 * All the themes for data tables
 */
public enum DataTableThemes
{
	DataTables("dt", "dataTables", "jquery.dataTables"),
	Bootstrap("bs", "bootstrap"),
	Bootstrap4("bs4", "bootstrap4"),
	JQueryUI("jqui", "jqueryui"),;

	private String data;
	private String filename;
	private String filenameOverride;

	DataTableThemes(String data, String filename)
	{
		this.data = data;
		this.filename = filename;
	}

	DataTableThemes(String data, String filename, String filenameOverride)
	{
		this.data = data;
		this.filename = filename;
		this.filenameOverride = filenameOverride;
	}

	/**
	 * Returns the short name data for the given theme
	 *
	 * @return
	 */
	public String getData()
	{
		return data;
	}

	@Override
	public String toString()
	{
		return super.toString();
	}

	/**
	 * Returns the filename portion of the data table
	 *
	 * @return
	 */
	public String getFilename()
	{
		return filename;
	}

	/**
	 * Returns the overriding name (data tables uses jquery. format plugins don't)
	 *
	 * @return
	 */
	public String getFilenameOverride()
	{
		return filenameOverride;
	}
}
