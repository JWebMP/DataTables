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

package com.jwebmp.plugins.datatable.options;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * When displaying tables with a particularly large amount of data shown on each page, it can be useful to have the table's header and /
 * or footer fixed to the top or bottom of the scrolling window. This lets your users quickly determine what each column refers to rather
 * than needing to scroll back to the top of the table.
 * <p>
 * FixedHeader provides the ability to perform this action with DataTables tables. It operates by detaching the header and footer
 * elements from the host table and attaching them to the top or bottom of the screen as required by the scrolling position of the window
 * . This ensures that FixedColumns is fully compatible with DataTables and you can add complex interactions such as search elements in
 * the table footer, just as you would with any other table.
 * <p>
 * Please note that FixedHeader is not currently compatible with tables that have the scrolling features of DataTables enabled (scrollX /
 * scrollY). Please refer to the compatibility table for full compatibility details.
 *
 * @param <J>
 */
public class DataTableFixedHeaderOptions<J extends DataTableFixedHeaderOptions<J>>
		extends JavaScriptPart<J>
{

	/**
	 * fixedHeader.footerSince: FixedHeader 3.0.0
	 * Enable / disable fixed footer. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * This parameter simply provides the ability to enable or disable the fixed footer aspect of the FixedHeader extension. When enabled
	 * the table's footer will be sticky, so it will always be visible while the end user scrolls through a DataTables.
	 */
	private Boolean footer;
	/**
	 * fixedHeader.footerOffsetSince: FixedHeader 3.0.0
	 * Offset the table's fixed footer. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * Although less common that fixed a header in place on a web-page or app, it can sometimes be useful to provide a fixed position
	 * element at the bottom of a page, giving quick access to common functions and links for an end user. The offset introduced by this
	 * fixed element needs to be accounted for when using FixedHeader for correct positioning of the fixed element.
	 * <p>
	 * This parameter provides a method that you can use to inform FixedHeader that an offset should be applied to the footer, and what
	 * that offset should be.
	 */
	private Integer footerOffset;
	/**
	 * fixedHeader.footerOffsetSince: FixedHeader 3.0.0
	 * Offset the table's fixed footer. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * Although less common that fixed a header in place on a web-page or app, it can sometimes be useful to provide a fixed position
	 * element at the bottom of a page, giving quick access to common functions and links for an end user. The offset introduced by this
	 * fixed element needs to be accounted for when using FixedHeader for correct positioning of the fixed element.
	 * <p>
	 * This parameter provides a method that you can use to inform FixedHeader that an offset should be applied to the footer, and what
	 * that offset should be.
	 */
	private Boolean header;
	/**
	 * fixedHeader.headerOffsetSince: FixedHeader 3.0.0
	 * Offset the table's fixed header. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * Many web-pages and apps use a navigation element that has fixed positioning applied to it at the top of the page to to provide
	 * quick access to common functions and links for an end user. This needs to be accounted for when using FixedHeader so the offset
	 * caused by the fixed element doesn't interrupt the correct positioning of the fixed header.
	 * <p>
	 * This parameter provides a method that you can use to inform FixedHeader that an offset should be applied, and what that offset
	 * should be.
	 */
	private Integer headerOffset;

	/**
	 * When displaying tables with a particularly large amount of data shown on each page, it can be useful to have the table's header and
	 * / or footer fixed to the top or bottom of the scrolling window. This lets your users quickly determine what each column refers to
	 * rather than needing to scroll back to the top of the table.
	 * <p>
	 * FixedHeader provides the ability to perform this action with DataTables tables. It operates by detaching the header and footer
	 * elements from the host table and attaching them to the top or bottom of the screen as required by the scrolling position of the
	 * window. This ensures that FixedColumns is fully compatible with DataTables and you can add complex interactions such as search
	 * elements in the table footer, just as you would with any other table.
	 * <p>
	 * Please note that FixedHeader is not currently compatible with tables that have the scrolling features of DataTables enabled
	 * (scrollX / scrollY). Please refer to the compatibility table for full compatibility details.
	 */
	public DataTableFixedHeaderOptions()
	{
		//No config required
	}

	/**
	 * fixedHeader.footerSince: FixedHeader 3.0.0
	 * Enable / disable fixed footer. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * This parameter simply provides the ability to enable or disable the fixed footer aspect of the FixedHeader extension. When enabled
	 * the table's footer will be sticky, so it will always be visible while the end user scrolls through a DataTables.
	 *
	 * @return
	 */
	public Boolean getFooter()
	{
		return footer;
	}

	/**
	 * fixedHeader.footerSince: FixedHeader 3.0.0
	 * Enable / disable fixed footer. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * This parameter simply provides the ability to enable or disable the fixed footer aspect of the FixedHeader extension. When enabled
	 * the table's footer will be sticky, so it will always be visible while the end user scrolls through a DataTables.
	 *
	 * @param footer
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setFooter(Boolean footer)
	{
		this.footer = footer;
		return (J) this;
	}

	/**
	 * fixedHeader.footerOffsetSince: FixedHeader 3.0.0
	 * Offset the table's fixed footer. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * Although less common that fixed a header in place on a web-page or app, it can sometimes be useful to provide a fixed position
	 * element at the bottom of a page, giving quick access to common functions and links for an end user. The offset introduced by this
	 * fixed element needs to be accounted for when using FixedHeader for correct positioning of the fixed element.
	 * <p>
	 * This parameter provides a method that you can use to inform FixedHeader that an offset should be applied to the footer, and what
	 * that offset should be.
	 *
	 * @return
	 */
	public Integer getFooterOffset()
	{
		return footerOffset;
	}

	/**
	 * fixedHeader.footerOffsetSince: FixedHeader 3.0.0
	 * Offset the table's fixed footer. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * Although less common that fixed a header in place on a web-page or app, it can sometimes be useful to provide a fixed position
	 * element at the bottom of a page, giving quick access to common functions and links for an end user. The offset introduced by this
	 * fixed element needs to be accounted for when using FixedHeader for correct positioning of the fixed element.
	 * <p>
	 * This parameter provides a method that you can use to inform FixedHeader that an offset should be applied to the footer, and what
	 * that offset should be.
	 *
	 * @param footerOffset
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setFooterOffset(Integer footerOffset)
	{
		this.footerOffset = footerOffset;
		return (J) this;
	}

	/**
	 * fixedHeader.footerOffsetSince: FixedHeader 3.0.0
	 * Offset the table's fixed footer. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * Although less common that fixed a header in place on a web-page or app, it can sometimes be useful to provide a fixed position
	 * element at the bottom of a page, giving quick access to common functions and links for an end user. The offset introduced by this
	 * fixed element needs to be accounted for when using FixedHeader for correct positioning of the fixed element.
	 * <p>
	 * This parameter provides a method that you can use to inform FixedHeader that an offset should be applied to the footer, and what
	 * that offset should be.
	 *
	 * @return
	 */
	public Boolean getHeader()
	{
		return header;
	}

	/**
	 * fixedHeader.footerOffsetSince: FixedHeader 3.0.0
	 * Offset the table's fixed footer. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * Although less common that fixed a header in place on a web-page or app, it can sometimes be useful to provide a fixed position
	 * element at the bottom of a page, giving quick access to common functions and links for an end user. The offset introduced by this
	 * fixed element needs to be accounted for when using FixedHeader for correct positioning of the fixed element.
	 * <p>
	 * This parameter provides a method that you can use to inform FixedHeader that an offset should be applied to the footer, and what
	 * that offset should be.
	 *
	 * @param header
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setHeader(Boolean header)
	{
		this.header = header;
		return (J) this;
	}

	/**
	 * fixedHeader.headerOffsetSince: FixedHeader 3.0.0
	 * Offset the table's fixed header. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * Many web-pages and apps use a navigation element that has fixed positioning applied to it at the top of the page to to provide
	 * quick access to common functions and links for an end user. This needs to be accounted for when using FixedHeader so the offset
	 * caused by the fixed element doesn't interrupt the correct positioning of the fixed header.
	 * <p>
	 * This parameter provides a method that you can use to inform FixedHeader that an offset should be applied, and what that offset
	 * should be.
	 *
	 * @return
	 */
	public Integer getHeaderOffset()
	{
		return headerOffset;
	}

	/**
	 * fixedHeader.headerOffsetSince: FixedHeader 3.0.0
	 * Offset the table's fixed header. Please note - this property requires the FixedHeader extension for DataTables.
	 * <p>
	 * Description
	 * Many web-pages and apps use a navigation element that has fixed positioning applied to it at the top of the page to to provide
	 * quick access to common functions and links for an end user. This needs to be accounted for when using FixedHeader so the offset
	 * caused by the fixed element doesn't interrupt the correct positioning of the fixed header.
	 * <p>
	 * This parameter provides a method that you can use to inform FixedHeader that an offset should be applied, and what that offset
	 * should be.
	 *
	 * @param headerOffset
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setHeaderOffset(Integer headerOffset)
	{
		this.headerOffset = headerOffset;
		return (J) this;
	}

}
