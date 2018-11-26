import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;
import com.jwebmp.plugins.datatable.DataTablePageConfigurator;
import com.jwebmp.plugins.datatable.DataTablesSiteBinder;

module com.jwebmp.plugins.datatable {
	exports com.jwebmp.plugins.datatable;
	exports com.jwebmp.plugins.datatable.options;
	exports com.jwebmp.plugins.datatable.options.buttons;
	exports com.jwebmp.plugins.datatable.options.responsive;
	exports com.jwebmp.plugins.datatable.enumerations;
	exports com.jwebmp.plugins.datatable.events;
	exports com.jwebmp.plugins.datatable.search;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires com.google.guice;
	requires com.jwebmp.guicedinjection;

	requires javax.servlet.api;

	requires java.logging;
	requires com.google.common;
	requires com.jwebmp.guicedservlets;
	requires org.apache.commons.lang3;

	provides IPageConfigurator with DataTablePageConfigurator;
	provides IGuiceSiteBinder with DataTablesSiteBinder;

	provides IGuiceScanModuleExclusions with com.jwebmp.plugins.datatable.implementations.DataTablesExclusionsModule;
	provides IGuiceScanJarExclusions with com.jwebmp.plugins.datatable.implementations.DataTablesExclusionsModule;

	opens com.jwebmp.plugins.datatable to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.enumerations to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.events to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options.buttons to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options.responsive to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.search to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
}
