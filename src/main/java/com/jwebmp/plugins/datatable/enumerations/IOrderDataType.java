package com.jwebmp.plugins.datatable.enumerations;

import java.io.Serializable;

/**
 * IOrderType values for defaults, and extensions through Sortable plugin
 */
@FunctionalInterface
public interface IOrderDataType
		extends Serializable
{
	String name();
}
