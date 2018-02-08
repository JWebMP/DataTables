package za.co.mmagon.jwebswing.plugins.jqdatatable.options;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * searchSince: DataTables 1.10
 * Set an initial filter in DataTables and / or filtering options.
 * <p>
 * Description
 * The search option allows the way DataTables performs filtering to be set during the initialisation, and to set an initial global filter.
 * <p>
 * The options that control how the filtering is performs are:
 * <p>
 * search.caseInsensitive - Indicate is case-insensitive sorting should be performed.
 * search.regex - Treat the search as a regular expression or not
 * search.smart - Use DataTables' smart filtering or not
 * Additionally, to set an initial filter:
 * <p>
 * search.search - Set an initial global filter.
 *
 * @param <J>
 */
public class DataTablesSearchOptions<J extends DataTablesSearchOptions<J>> extends JavaScriptPart<J>
{
	/**
	 * search.caseInsensitiveSince: DataTables 1.10
	 * Control case-sensitive filtering option.
	 * <p>
	 * Description
	 * Flag to indicate if the filtering should be case insensitive or not.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * true
	 */
	private Boolean caseInsensitive;
	/**
	 * search.regexSince: DataTables 1.10
	 * Enable / disable escaping of regular expression characters in the search term.
	 * <p>
	 * Description
	 * Regular expressions can be used to build fantastically complex filtering terms, but also it is perfectly valid for users to enter
	 * characters such as * into the filter, so a decision needs to be made if you wish to escape regular expression special characters or
	 * not. This option controls that ability in DataTables.
	 * <p>
	 * It is simply a flag to indicate if the search term should be interpreted as a regular expression (true) or not (false) and
	 * therefore and special regex characters escaped.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: false
	 */
	private Boolean regex;
	/**
	 * search.searchSince: DataTables 1.10
	 * Set an initial filtering condition on the table.
	 * <p>
	 * Description
	 * Search term that should be applied to the table.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 */
	private String search;
	/**
	 * search.smartSince: DataTables 1.10
	 * Enable / disable DataTables' smart filtering.
	 * <p>
	 * Description
	 * DataTables' built-in filtering is "smart" in that it breaks the user's input into individual words and then matches those words in
	 * any position and in any order in the table (rather than simple doing a simple string compare).
	 * <p>
	 * Although this can significantly enhance usability of the filtering feature, it uses a complex regular expression to perform this
	 * task, and as such it can interfere with a custom regular expression input if you enable that option (search.regex). As such, this
	 * option is provided to disable this smart filtering ability.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: true
	 */
	private Boolean smart;

	public DataTablesSearchOptions()
	{
		//No Config Needed
	}

	/**
	 * search.caseInsensitiveSince: DataTables 1.10
	 * Control case-sensitive filtering option.
	 * <p>
	 * Description
	 * Flag to indicate if the filtering should be case insensitive or not.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * true
	 *
	 * @return
	 */
	public Boolean getCaseInsensitive()
	{
		return caseInsensitive;
	}

	/**
	 * search.caseInsensitiveSince: DataTables 1.10
	 * Control case-sensitive filtering option.
	 * <p>
	 * Description
	 * Flag to indicate if the filtering should be case insensitive or not.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * true
	 *
	 * @param caseInsensitive
	 *
	 * @return
	 */
	public J setCaseInsensitive(Boolean caseInsensitive)
	{
		this.caseInsensitive = caseInsensitive;
		return (J) this;
	}

	/**
	 * search.regexSince: DataTables 1.10
	 * Enable / disable escaping of regular expression characters in the search term.
	 * <p>
	 * Description
	 * Regular expressions can be used to build fantastically complex filtering terms, but also it is perfectly valid for users to enter
	 * characters such as * into the filter, so a decision needs to be made if you wish to escape regular expression special characters or
	 * not. This option controls that ability in DataTables.
	 * <p>
	 * It is simply a flag to indicate if the search term should be interpreted as a regular expression (true) or not (false) and
	 * therefore and special regex characters escaped.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: false
	 *
	 * @return
	 */
	public Boolean getRegex()
	{
		return regex;
	}

	/**
	 * search.regexSince: DataTables 1.10
	 * Enable / disable escaping of regular expression characters in the search term.
	 * <p>
	 * Description
	 * Regular expressions can be used to build fantastically complex filtering terms, but also it is perfectly valid for users to enter
	 * characters such as * into the filter, so a decision needs to be made if you wish to escape regular expression special characters or
	 * not. This option controls that ability in DataTables.
	 * <p>
	 * It is simply a flag to indicate if the search term should be interpreted as a regular expression (true) or not (false) and
	 * therefore and special regex characters escaped.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: false
	 *
	 * @param regex
	 *
	 * @return
	 */
	public J setRegex(Boolean regex)
	{
		this.regex = regex;
		return (J) this;
	}

	/**
	 * search.searchSince: DataTables 1.10
	 * Set an initial filtering condition on the table.
	 * <p>
	 * Description
	 * Search term that should be applied to the table.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 *
	 * @return
	 */
	public String getSearch()
	{
		return search;
	}

	/**
	 * search.searchSince: DataTables 1.10
	 * Set an initial filtering condition on the table.
	 * <p>
	 * Description
	 * Search term that should be applied to the table.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * string
	 *
	 * @param search
	 *
	 * @return
	 */
	public J setSearch(String search)
	{
		this.search = search;
		return (J) this;
	}

	/**
	 * search.smartSince: DataTables 1.10
	 * Enable / disable DataTables' smart filtering.
	 * <p>
	 * Description
	 * DataTables' built-in filtering is "smart" in that it breaks the user's input into individual words and then matches those words in
	 * any position and in any order in the table (rather than simple doing a simple string compare).
	 * <p>
	 * Although this can significantly enhance usability of the filtering feature, it uses a complex regular expression to perform this
	 * task, and as such it can interfere with a custom regular expression input if you enable that option (search.regex). As such, this
	 * option is provided to disable this smart filtering ability.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: true
	 *
	 * @return
	 */
	public Boolean getSmart()
	{
		return smart;
	}

	/**
	 * search.smartSince: DataTables 1.10
	 * Enable / disable DataTables' smart filtering.
	 * <p>
	 * Description
	 * DataTables' built-in filtering is "smart" in that it breaks the user's input into individual words and then matches those words in
	 * any position and in any order in the table (rather than simple doing a simple string compare).
	 * <p>
	 * Although this can significantly enhance usability of the filtering feature, it uses a complex regular expression to perform this
	 * task, and as such it can interfere with a custom regular expression input if you enable that option (search.regex). As such, this
	 * option is provided to disable this smart filtering ability.
	 * <p>
	 * Type
	 * This option can be given in the following type(s):
	 * <p>
	 * boolean
	 * Default
	 * Value: true
	 *
	 * @param smart
	 *
	 * @return
	 */
	public J setSmart(Boolean smart)
	{
		this.smart = smart;
		return (J) this;
	}
}
