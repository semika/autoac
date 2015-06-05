Ext.Autoac = Ext.extend(Object, {
	
	layout: null,
	menuBar : null,
	tabPanel: null,
	
	constructor: function() {
	},
	
	initTab: function() {
		this.tabPanel = new Ext.AutoacTab();
	},
	
	initMenu: function() {
		this.menuBar  = new Ext.AutoacMenu();
	},
	
	initLayOut: function() {
		this.layout   = new Ext.AutoacLayout();
	}
});