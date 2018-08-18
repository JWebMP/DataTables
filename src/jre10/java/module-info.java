import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.datatable.DataTablePageConfigurator;

module com.jwebmp.plugins.datatable {
	exports com.jwebmp.plugins.datatable;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires com.google.guice;
	requires com.jwebmp.guicedinjection;

	requires javax.servlet.api;
	requires java.logging;
	requires com.google.common;

	provides IPageConfigurator with DataTablePageConfigurator;

	opens com.jwebmp.plugins.datatable to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.datatable.enumerations to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.datatable.events to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.datatable.options to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.datatable.search to com.fasterxml.jackson.databind, com.jwebmp.core;
}
