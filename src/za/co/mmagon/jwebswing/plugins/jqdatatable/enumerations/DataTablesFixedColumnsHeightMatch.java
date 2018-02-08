package za.co.mmagon.jwebswing.plugins.jqdatatable.enumerations;

/**
 * none - will result in no height matching being applied by FixedColumns (height matching could be forced by CSS in this case)
 * semiauto - whereby the height calculation will be performed once, and the result cached to be used again
 * auto - height matching is performed on every draw (slowest but must accurate).
 */
public enum DataTablesFixedColumnsHeightMatch
{
	none,
	semiAuto,
	auto

}
