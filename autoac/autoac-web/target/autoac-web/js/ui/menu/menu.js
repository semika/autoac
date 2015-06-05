Ext.AutoacMenu = Ext.extend(Object, {
	
	menuBar: null,
	menuLinks:{},
	
	constructor: function() {
		this.initMenuUrl();
		this.initMenu();
		this.addMenus();
		this.renderMenu();
	},
	
	initMenuUrl: function(){
		this.menuLinks["create_reparation"] = "create-reparation.action"; 
		this.menuLinks["manage_reparation"] = "manage-reparation.action";
		this.menuLinks["company"] = "company.action";
		this.menuLinks["model"] = "model.action";
		this.menuLinks["make"] = "make.action";
		this.menuLinks["user"] = "user.action";
		this.menuLinks["role"] = "role.action";
		this.menuLinks["change_password"] = "change-password.action";
		
	},
	
	getUrl: function(id) {
		var action = this.menuLinks[id];
		var url = CONTEXT_ROOT + "/secure/" + action;
		return url;
	},
	
	getReparationMenu: function() {
		var menu = new Ext.menu.Menu({
		    id: 'reparation',
		    iconCls:'reparation',
		    items: [
		            {id:'create_reparation', text: 'Create Reparation',handler: this.clickHandler, scope:this},
		            {id:'manage_reparation', text: 'Manage Reparation',handler: this.clickHandler, scope:this}
		           ]
		});
		return menu;
	},
	
	getMaintenanceMenu: function() {
		var menu = new Ext.menu.Menu({
			id: 'maintenance',
			items: [
			        {id:'company', text: 'Company',handler: this.clickHandler, scope:this},
			        {
			        	text: 'Vehicle',
			        	menu: {items:[{id:'model', text:'Model', handler: this.clickHandler, scope:this},
			        	              {id:'make', text:'Make',  handler: this.clickHandler, scope:this}]}
			        }
			        ]
		});
		return menu;
	},
	
	getSecurityMenu: function() {
		var menu = new Ext.menu.Menu({
			id: 'security',
			items: [
			        {id:'user', text: 'User', handler: this.clickHandler, scope:this},
			        {id:'role', text: 'Role', handler: this.clickHandler, scope:this},
			        {id:'change_password', text: 'Change Password', handler: this.clickHandler, scope:this}
			        ]
		}); 
		return menu;
	},
	
	
	renderMenu: function() {
		this.menuBar.render('toolbar');
	},
	
	addMenus: function(title) {
		this.menuBar.add({text:'Reparation', menu: this.getReparationMenu()});
		this.menuBar.add({text:'Maintenance', menu: this.getMaintenanceMenu()});
		this.menuBar.add({text:'Security', menu: this.getSecurityMenu()});
	},
	
	clickHandler: function(item) {
		var url = this.getUrl(item.id);
		AUTOAC.tabPanel.tabPanel.add({
            title: item.text,
            iconCls: 'tabs',
            html: '<iframe src="'+ url +'" frameborder="0" width="100%" height="100%">',
            closable:true
        }).show();
	},
	
	initMenu: function() {
		this.menuBar = new Ext.Toolbar();
	}
});