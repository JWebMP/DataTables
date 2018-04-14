package com.jwebmp.plugins.jqdatatable.enumerations;

/**
 * Description:
 * The object form of this option provides additional control over which key(s) will activate a particular button, providing the option
 * to define filtering by meta keys such as shift, alt and ctrl.
 * <p>
 * The object properties available are:
 * <p>
 * key - The character to listen for. The character is case insensitive.
 * shiftKey - When set to true activation will only occur if the shift key is also being held.
 * altKey - When set to true activation will only occur if the alt key is also being held.
 * ctrlKey - When set to true activation will only occur if the ctrl key is also being held.
 * metaKey - When set to true activation will only occur if the cmd key (Mac) or Windows key (Windows) is also being held.
 * Multiple options can be defined if you wish to restrict activation to a specific, complex, key combination.
 */
public enum DataTablesButtonKeys
{
	shiftKey,
	altKey,
	ctrlKey,
	metaKey,

	a,
	b,
	c,
	d,
	e,
	f,
	g,
	h,
	i,
	j,
	k,
	l,
	m,
	o,
	p,
	q,
	r,
	s,
	t,
	u,
	v,
	w,
	x,
	y,
	z
}
