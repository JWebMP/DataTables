import com.jwebmp.plugins.datatable.angularjs.*;
import com.jwebmp.plugins.datatable.implementations.DataTablesInclusionModule;

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

	requires jakarta.servlet;

	requires java.logging;
	requires com.google.common;
	requires com.guicedee.guicedservlets;
	requires org.apache.commons.lang3;
	requires com.jwebmp.core.angularjs;
	
	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.datatable.DataTablePageConfigurator;
	provides com.guicedee.guicedservlets.services.IGuiceSiteBinder with com.jwebmp.plugins.datatable.DataTablesSiteBinder;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with DataTablesInclusionModule;
	provides com.jwebmp.core.base.angular.services.IAngularDirective with DataTablesDirective;
	
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.datatable.implementations.DataTablesExclusionsModule;
	
	opens com.jwebmp.plugins.datatable.angularjs to com.google.guice,com.fasterxml.jackson.databind,com.jwebmp.core.angularjs,com.jwebmp.core;
	
	opens com.jwebmp.plugins.datatable to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.enumerations to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.events to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options.buttons to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options.responsive to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.search to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	exports com.jwebmp.plugins.datatable.options.searchpanes;
	opens com.jwebmp.plugins.datatable.options.searchpanes to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core;
}
