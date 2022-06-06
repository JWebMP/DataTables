import com.jwebmp.plugins.datatable.implementations.DataTablesInclusionModule;

module com.jwebmp.plugins.datatable {
	exports com.jwebmp.plugins.datatable;
	exports com.jwebmp.plugins.datatable.options;
	exports com.jwebmp.plugins.datatable.options.buttons;
	exports com.jwebmp.plugins.datatable.options.responsive;
	exports com.jwebmp.plugins.datatable.enumerations;
	exports com.jwebmp.plugins.datatable.search;
	exports com.jwebmp.plugins.datatable.options.searchpanes;
	
	
	requires org.apache.commons.lang3;
	requires transitive com.jwebmp.core.base.angular.client ;
	
	requires com.jwebmp.plugins.jquery;
	
	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.datatable.DataTablePageConfigurator;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with DataTablesInclusionModule;
	
	
	opens com.jwebmp.plugins.datatable to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.enumerations to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options.buttons to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options.responsive to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.search to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.datatable.options.searchpanes to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core;
}
