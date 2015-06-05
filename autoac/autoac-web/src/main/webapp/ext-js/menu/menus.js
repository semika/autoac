Ext.onReady(function() {
	var menu1 = new Ext.menu.Menu({
	    id: 'reparation',
	    iconCls:'reparation',
	    items: [
	            {text: 'Create Reparation',handler: clickHandler},
	            {text: 'Manage Reparation',handler: clickHandler}
	           ]
	});
	
	var menu2 = new Ext.menu.Menu({
	    id: 'maintenance',
	    items: [
	            {text: 'Company',handler: clickHandler},
	            {
	            	text: 'Vehicle',
	            	menu: {items:[{text:'Model', handler: clickHandler},
	            	             {text:'Make',  handler: clickHandler}]}
	            }
	           ]
	});
	
	var tb = new Ext.Toolbar();
    tb.render('toolbar');

    tb.add({text:'Reparation', menu: menu1});
    tb.add({text:'Maintenence',menu: menu2});
    
    tb.doLayout();
    
	function clickHandler(item) {
		tabs.add({
            title: item.text,
            iconCls: 'tabs',
            html: item.text,
            closable:true
        }).show();
	}
});