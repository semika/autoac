Ext.User = Ext.extend(Object, {
	
	top: null,
	userList:[],
	store:null,
	grid:null,
	btnPanel: null,
	
	change:function(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '</span>';
        } else if (val < 0) {
            return '<span style="color:red;">' + val + '</span>';
        }
        return val;
    },
    
    pctChange:function(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '%</span>';
        } else if (val < 0) {
            return '<span style="color:red;">' + val + '%</span>';
        }
        return val;
    },
    
    enableDataControl: function(){
    	var elArray = Ext.DomQuery.jsSelect("input", "form-container");
		
		Ext.each(elArray, function(el, index, elArray){
			Ext.getCmp(el.id).enable();
		});
    },
    
    disableDataControl: function(){
    	var elArray = Ext.DomQuery.jsSelect("input", "form-container");
		
		Ext.each(elArray, function(el, index, elArray){
			Ext.getCmp(el.id).disable();
		});
    },
    
    handleButtons: function(){
    	Ext.getCmp('btnEdit').disable();
    	Ext.getCmp('btnDelete').disable();
    },
    
	initDataGrid: function() {
		// create the Grid
	    this.grid = new Ext.grid.GridPanel({
	        store: this.store,
	        columns: [
	            {
	                id       :'userName',
	                header   : 'User Name', 
	                width    : '30%', 
	                sortable : true, 
	                dataIndex: 'userName'
	            },
	            {
	                header   : 'Password', 
	                width    : '30%', 
	                sortable : true, 
	                dataIndex: 'password'
	            },
	            {
	                header   : 'Lock', 
	                width    : '40%', 
	                sortable : true, 
	                renderer : this.change, 
	                dataIndex: 'version'
	            }
	        ],
	        stripeRows: true,
	        autoExpandColumn: 'userName',
	        height: 200,
	        width: '100%',
	        title: 'User Listing',
	        // config options for stateful behavior
	        stateful: true,
	        stateId: 'grid'
	    });
	    this.grid.on('rowclick', this.onRowClick, this);
	    this.grid.render('grid-example');
	},
	
	onRowClick: function(grid, rowIndex, event) {
		this.initialize();
		autoFill(user.userList[rowIndex], "form-container");
		Ext.getCmp('btnEdit').enable();
		Ext.getCmp('btnDelete').enable();
	},
	
	initDataStore: function() {
		// create the data store
	    this.store = new Ext.data.ArrayStore({
	        fields: [
	           {name: 'userName'},
	           {name: 'password'},
	           {name: 'version',type: 'int'}
	        ]
	    });
	    this.store.loadData(this.userList);
	},
	
	add: function(){
		this.clear();
		this.enableDataControl();
	},
	
	clear: function(){
		var elArray = Ext.DomQuery.jsSelect("input", "form-container");
		
		Ext.each(elArray, function(el, index, elArray){
			el.value = ""; 
		});
	},
	
	
	search: function() {
		var _self = this;
		Ext.Ajax.request({
			   url: CONTEXT_ROOT + '/secure/user!search.action',
			   success: function(response, opts) {
			      var obj = Ext.decode(response.responseText);
			      var model = obj.model;
			      if (model.status == "success") {
			    	  var searchResults = obj.map.searchResults;
			    	  var data = [];
			    	  for (var i = 0; i < searchResults.length; i++) {
			    		  data.push([searchResults[i].userName, searchResults[i].password, searchResults[i].version]);
			    	  }
			    	  _self.store.loadData(data);
			    	  _self.userList = searchResults;
			      } else {
			    	  showMessage(model.errorMessage, "E");
			      }
			   },
			   failure: function(response, opts) {
			      console.log('server-side failure with status code ' + response.status);
			   },
			   params:"userName='semika'&password='lasanthi'"
		});
	},
	
	del: function() {
		var userName = Ext.get('id').getValue();
		var password = Ext.get("version").getValue();
		
		var params = {};
		params['id'] = userName;
		params['version'] = password;
		
		var self = this;
		Ext.Ajax.request({
			   url: CONTEXT_ROOT + '/secure/user!delete.action',
			   success: function(response, opts){
					var obj = Ext.decode(response.responseText);
				    var searchResults = obj.map.searchResults;
				    var data = [];
				    for (var i = 0; i < searchResults.length; i++) {
				    	data.push([searchResults[i].userName, searchResults[i].password, searchResults[i].version]);
				    }
				    self.store.loadData(data);
				    self.userList = searchResults;
					user.initialize();
					showMessage("D");
				},
			   failure: function(){
							alert("save failed");
						},
			   headers: {
			       'my-header': 'foo'
			   },
			   params: params
		});
	},
	
	save: function() {
		var userName = Ext.get('userName').getValue();
		var password = Ext.get("password").getValue();
		
		var params = {};
		params['userName'] = userName;
		params['password'] = password;
		
		var self = this;
		Ext.Ajax.request({
			   url: CONTEXT_ROOT + '/secure/user!save.action',
			   success: function(response, opts){
					var obj = Ext.decode(response.responseText);
			        var model = obj.model;
					if (model.status == "success") {
						var obj = Ext.decode(response.responseText);
						var searchResults = obj.map.searchResults;
						var data = [];
						for (var i = 0; i < searchResults.length; i++) {
							data.push([searchResults[i].userName, searchResults[i].password, searchResults[i].version]);
						}
						self.store.loadData(data);
						self.userList = searchResults;
						user.initialize();
						showMessage("S");
					} else {
						showMessage(model.errorMessage, "E");
					}
			   },
			   failure: function(){
							alert("save failed");
						},
			   headers: {
			       'my-header': 'foo'
			   },
			   params: params
		});
	},
	
	createFormPanel: function() {
		
		var userForm = new Ext.FormPanel({
	        labelWidth: 75, // label settings here cascade unless overridden
	        autoHeight: true,
	        bodyStyle:'padding:5px 5px 0',
	        width: 350,
	        defaults: {width: 230},
	        defaultType: 'textfield',

	        items: [{id:'id',       xtype:'hidden',   name:'id'},
	                {id:'userName', xtype:'textfield',name: 'userName',fieldLabel: 'User Name', allowBlank:false},
	                {id:'password', xtype:'textfield',name: 'password',fieldLabel: 'Password',allowBlank:false},
	                {id:'version',  xtype:'hidden',   name: 'version'}
	        ]
	    });

	    this.btnPanel = new Ext.Panel({
	    	autoHeight: true,
	    	frame:false,
	    	buttonAlign:'left',
	    	title:'User Details',
	    	collapsible: true,
	    	items: userForm,
	    	layout: 'fit',
	    	buttons: [{id:'btnAdd'   ,text: 'Add',   handler: this.add,   scope:this},
	                  {id:'btnEdit'  ,text: 'Edit',  handler: this.edit,  scope:this},
	                  {id:'btnDelete',text: 'Delete',handler: this.del,   scope:this},
	                  {id:'btnClear' ,text: 'Clear' ,handler: this.clear, scope:this},
	                  {id:'btnSave'  ,text: 'Save',  handler: this.save,  scope:this},
	                  {id:'btnClose' ,text: 'Close', handler: this.close, scope:this}
	        ],
	        bbar:new Ext.ux.StatusBar({
                id: 'basic-statusbar',
                region: 'south',
                height: 32, // give north and south regions a height
                // defaults to use when the status is cleared:
                defaultText: 'Default status text',
                //defaultIconCls: 'default-icon',
            
                // values to set initially:
                text: 'Ready',
                iconCls: 'x-status-valid'
            })
	    });
	    
	    this.btnPanel.render("form-container");
	    
	},
	
	initialize: function(){
		this.disableDataControl();
		Ext.getCmp('btnEdit').disable();
    	Ext.getCmp('btnDelete').disable();
    	this.clear();
	},
	
	onLoad: function() {
		this.initialize();
		this.search();
	},
	
	constructor: function() {
		this.top = parent;
		this.initDataStore();
		this.initDataGrid();
		this.createFormPanel();
	}
});