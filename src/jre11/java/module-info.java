module com.jwebmp.plugins.datatable {
	exports com.jwebmp.plugins.datatable;
	exports com.jwebmp.plugins.datatable.options;
	exports com.jwebmp.plugins.datatable.options.buttons;
	exports com.jwebmp.plugins.datatable.options.responsive;
	exports com.jwebmp.plugins.datatable.enumerations;
	exports com.jwebmp.plugins.datatable.events;
	exports com.jwebmp.plugins.datatable.search;

	requires com.jwebmp.core;
	requires com.guicedee.logmaster;

	requires jakarta.validation;
	requires com.google.guice;
	requires com.guicedee.guicedinjection;

	requires java.servlet;

	requires java.logging;
	requires com.google.common;
	requires com.guicedee.guicedservlets;
	requires org.apache.commons.lang3;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.datatable.DataTablePageConfigurator;
	provides com.guicedee.guicedservlets.services.IGuiceSiteBinder with com.jwebmp.plugins.datatable.DataTablesSiteBinder;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.datatable.implementations.DataTablesExclusionsModule;

	opens com.jwebmp.plugins.datatable to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.enumerations to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.events to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options.buttons to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options.responsive to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.search to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
}
