package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;

public enum DataTablesSortables
{
	Dom_Checkbox(new JavascriptReference("DomCheckbox", 1.0, "datatables/sorting/custom-data-source/dom-checkbox.min.js")),
	Dom_Select(new JavascriptReference("Dom_Select", 1.0, "datatables/sorting/custom-data-source/dom-select.min.js")),
	Dom_Text(new JavascriptReference("Dom_Text", 1.0, "datatables/sorting/custom-data-source/dom-textg.min.js")),
	Alt_String(new JavascriptReference("Alt_String", 1.0, "datatables/sorting/alt-string.min.js")),
	Anti_The(new JavascriptReference("Anti_The", 1.0, "datatables/sorting/anti-the.min.js")),
	Chinese_String(new JavascriptReference("Chinese_String", 1.0, "datatables/sorting/chinese-string.min.js")),
	Currency(new JavascriptReference("Currency", 1.0, "datatables/sorting/currency.min.js")),
	Date_DD_MMM_YYYY(new JavascriptReference("Date_DD_MMM_YYYY", 1.0, "datatables/sorting/date-dd-MMM-yyyy.min.js")),
	Date_DE(new JavascriptReference("Date_DE", 1.0, "datatables/sorting/date-de.min.js")),
	Date_EU(new JavascriptReference("Date_EU", 1.0, "datatables/sorting/date-eu.min.js")),
	Date_Euro(new JavascriptReference("Date_Euro", 1.0, "datatables/sorting/date-euro.min.js")),
	Date_UK(new JavascriptReference("Date_UK", 1.0, "datatables/sorting/date-us.min.js")),
	DateTime_Moment(new JavascriptReference("DateTime_Moment", 1.0, "datatables/sorting/datetime-moment.min.js")),
	DateTime_US(new JavascriptReference("DateTime_US", 1.0, "datatables/sorting/datetime-us.min.js")),
	Enum(new JavascriptReference("Enum", 1.0, "datatables/sorting/enum.min.js")),
	File_Size(new JavascriptReference("File_Size", 1.0, "datatables/sorting/file-size.min.js")),
	Formatted_Numbers(new JavascriptReference("Formatted_Numbers", 1.0, "datatables/sorting/formatted-numbers.min.js")),
	IP_Address(new JavascriptReference("IP_Address", 1.0, "datatables/sorting/ip-address.min.js")),
	Month_Year(new JavascriptReference("Month_Year", 1.0, "datatables/sorting/monthYear.min.js")),
	Natural(new JavascriptReference("Natural", 1.0, "datatables/sorting/natural.min.js")),
	Num_Html(new JavascriptReference("Num_Html", 1.0, "datatables/sorting/num-html.min.js")),
	Numeric_Comma(new JavascriptReference("Numeric_Comma", 1.0, "datatables/sorting/numeric-comma.min.js")),
	Percent(new JavascriptReference("Percent", 1.0, "datatables/sorting/percent.min.js")),
	Scientific(new JavascriptReference("Scientific", 1.0, "datatables/sorting/scientific.min.js")),
	Signed_Num(new JavascriptReference("Signed_Num", 1.0, "datatables/sorting/signed-num.min.js")),
	String_Month_Year(new JavascriptReference("String_Month_Year", 1.0, "datatables/sorting/stringMonthYear.min.js")),
	Time(new JavascriptReference("Time", 1.0, "datatables/sorting/time.min.js")),
	Title_Numeric(new JavascriptReference("Title_Numeric", 1.0, "datatables/sorting/title-numeric.min.js")),
	Title_String(new JavascriptReference("Title_String", 1.0, "datatables/sorting/title-string.min.js")),;

	private JavascriptReference reference;

	DataTablesSortables()
	{
	}

	DataTablesSortables(JavascriptReference reference)
	{
		this.reference = reference;
	}

	public JavascriptReference getReference()
	{
		return reference;
	}

	public void setReference(JavascriptReference reference)
	{
		this.reference = reference;
	}
}
