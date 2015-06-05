Ext.AutoacLayout = Ext.extend(Object, {
	
	layout: null,
	
	constructor: function() {
		this.initLayout();
	},
	
	initLayout: function() {
		
        Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
        
        var viewport = new Ext.Viewport({
            layout: 'border',
            items: [
            
            /** Panel Item One: North section, menu bar should be placed here. **/        
            // create instance immediately
            new Ext.BoxComponent({
                region: 'north',
                height: 32, // give north and south regions a height
                autoEl: {
                    tag: 'div',
                    html:'<div id="toolbar"></div>'
                }
            }), 
            
            /** Panel Item Tow: South section, status bar should be place here. ***/
            /*{
                // lazily created panel (xtype:'panel' is default)
                region: 'south',
                contentEl: 'south',
                split: true,
                height: 30,
                html: '<div id="statusMessage"></div>',
                minSize: 100,
                maxSize: 200,
                collapsible: false,
                title: 'South',
                margins: '0 0 0 0'
            }, */
           /* new Ext.BoxComponent({
                region: 'south',
                height: 32, // give north and south regions a height
                el:'statusMessage'
            }),*/
            
          /*  new Ext.ux.StatusBar({
                id: 'basic-statusbar',
                region: 'south',
                height: 32, // give north and south regions a height
                // defaults to use when the status is cleared:
                defaultText: 'Default status text',
                //defaultIconCls: 'default-icon',
            
                // values to set initially:
                text: 'Ready',
                iconCls: 'x-status-valid'
            }),*/
            
            /********* Panel Item Three:East side panel **************/
            {
                region: 'east',
                id:'east-panel',
                collapsible: true,
                split: true,
                width: 225, // give east and west regions a width
                minSize: 175,
                maxSize: 400,
                margins: '0 5 0 0',
                layout: 'fit', // specify layout manager for items
                items:            // this TabPanel is wrapped by another Panel so the title will be applied
                new Ext.TabPanel({
                    border: false, // already wrapped so don't add another border
                    activeTab: 1, // second tab initially active
                    tabPosition: 'bottom',
                    items: [{html: '<p>A TabPanel component can be a region.</p>',
                        	 title: 'A Tab',
                        	 autoScroll: true
                    		}, 
                    		new Ext.grid.PropertyGrid({
                    			title: 'Property Grid',
                    			closable: true,
		                        source: {
		                            "(name)": "Properties Grid",
		                            "grouping": false,
		                            "autoFitColumns": true,
		                            "productionQuality": false,
		                            "created": new Date(Date.parse('10/15/2006')),
		                            "tested": false,
		                            "version": 0.01,
		                            "borderWidth": 1
		                        }
                    		})]
                	})
            }, 
            
            /** Panel Item Four : Left side**/
            {
                region: 'west',
                id: 'west-panel', // see Ext.getCmp() below
                title: 'West',
                split: true,
                width: 200,
                minSize: 175,
                maxSize: 400,
                collapsible: true,
                margins: '0 0 0 5',
                layout: {
                    type: 'accordion',
                    animate: true
                },
                items: [{
                    contentEl: 'west',
                    title: 'Navigation',
                    border: false,
                    iconCls: 'nav' // see the HEAD section for style used
                }, {
                    title: 'Settings',
                    html: '<p>Some settings in here.</p>',
                    border: false,
                    iconCls: 'settings'
                }]
            },
            
            /*********** Panel Item Five : Center area *********/
            
            // in this instance the TabPanel is not wrapped by another panel
            // since no title is needed, this Panel is added directly
            // as a Container
            AUTOAC.tabPanel.tabPanel
            
            ]
        });
        var e = Ext.getCmp('east-panel');
        e.collapse();
        // get a reference to the HTML element with id "hideit" and add a click listener to it 
        /*Ext.get("hideit").on('click', function(){
            // get a reference to the Panel that was created with id = 'west-panel' 
            var w = Ext.getCmp('west-panel');
            // expand or collapse that Panel based on its collapsed property state
            //w.collapsed ? w.expand() : w.collapse();
            w.collapse();
            
            var e = Ext.getCmp('east-panel');
            e.collapse();
        });*/
	}
});