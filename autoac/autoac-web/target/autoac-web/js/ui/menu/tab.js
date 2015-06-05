Ext.AutoacTab = Ext.extend(Object, {
	
	tabPanel: null,
	
	constructor: function() {
		this.createTabPanel();
	},
	
	createTabPanel: function() {
		this.tabPanel = new Ext.TabPanel({
        	region: 'center', // a center region is ALWAYS required for border layout
        	deferredRender: false,
        	activeTab: 0,     // first tab initially active
	        resizeTabs:true, // turn on tab resizing
	        minTabWidth: 115,
	        tabWidth:135,
	        enableTabScroll:true,
	        width:'100%',
	        height:575,
	        defaults: {autoScroll:true},
	        plugins: new Ext.ux.TabCloseMenu()
	    });
	}
});