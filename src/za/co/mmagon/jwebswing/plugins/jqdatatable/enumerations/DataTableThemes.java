package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

public enum DataTableThemes
{
	DataTables("dt", "dataTables","jquery.dataTables"),
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
	
	public String getData()
	{
		return data;
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	public String getFilename()
	{
		return filename;
	}
	
	public String getFilenameOverride()
	{
		return filenameOverride;
	}
}
