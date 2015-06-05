Ext.Company = Ext.extend(Object, {
	
	top: null,
	gridData:[],
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
	                id       :'name',
	                header   : 'Company Name', 
	                width    : '30%', 
	                sortable : true, 
	                dataIndex: 'name'
	            },
	            {
	                header   : 'Address Line1', 
	                width    : '30%', 
	                sortable : true, 
	                dataIndex: 'addressLineOne'
	            },
	            {
	                header   : 'Address Line2', 
	                width    : '40%', 
	                sortable : true, 
	                renderer : this.change, 
	                dataIndex: 'addressLineTwo'
	            },
	            {
	                header   : 'Telephone', 
	                width    : '40%', 
	                sortable : true, 
	                renderer : this.change, 
	                dataIndex: 'telephone'
	            },
	            {
	                header   : 'Fax', 
	                width    : '40%', 
	                sortable : true, 
	                renderer : this.change, 
	                dataIndex: 'fax'
	            }
	        ],
	        stripeRows: true,
	        autoExpandColumn: 'name',
	        height: 200,
	        width: '100%',
	        title: 'Company Listing',
	        // config options for stateful behavior
	        stateful: true,
	        stateId: 'grid'
	    });
	    this.grid.on('rowclick', this.onRowClick, this);
	    this.grid.render('grid');
	},
	
	onRowClick: function(grid, rowIndex, event) {
		this.initialize();
		autoFill(this.gridData[rowIndex], "form-container");
		Ext.getCmp('btnEdit').enable();
		Ext.getCmp('btnDelete').enable();
	},
	
	initDataStore: function() {
		// create the data store
	    this.store = new Ext.data.ArrayStore({
	        fields: [
	           {name: 'name'},
	           {name: 'addressLineOne'},
	           {name: 'addressLineTwo'},
	           {name: 'telephone'},
	           {name: 'fax'} 
	        ]
	    });
	    this.store.loadData(this.gridData);
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
		var self = this;
		Ext.Ajax.request({
			   url: CONTEXT_ROOT + '/secure/company!search.action',
			   success: function(response, opts) {
			      var obj = Ext.decode(response.responseText);
			      var model = obj.model;
			      if (model.status == "success") {
			    	  var searchResults = obj.map.searchResults;
			    	  var data = getGridData(searchResults, ['name','addressLineOne','addressLineTwo','telephone','fax']);
			    	  self.store.loadData(data);
			    	  self.gridData = searchResults;
			      } else {
			    	  showMessage(model.errorMessage, "E");
			      }
			   },
			   failure: function(response, opts) {
			      console.log('server-side failure with status code ' + response.status);
			   },
			   params:""
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
			   url: CONTEXT_ROOT + '/secure/company!delete.action',
			   success: function(response, opts){
					var obj = Ext.decode(response.responseText);
					var searchResults = obj.map.searchResults;
					var data = getGridData(searchResults, ['name','addressLineOne','addressLineTwo','telephone','fax']);
					self.store.loadData(data);
					self.gridData = searchResults;
					company.initialize();
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
		var params = {};
		params['id'] = Ext.get('id').getValue();
		params['name'] = Ext.get('name').getValue();
		params['addressLineOne'] = Ext.get('addressLineOne').getValue();
		params['addressLineTwo'] = Ext.get('addressLineTwo').getValue();
		params['telephone'] = Ext.get('telephone').getValue();
		params['fax'] = Ext.get('fax').getValue();
		
		var self = this;
		Ext.Ajax.request({
			   url: CONTEXT_ROOT + '/secure/company!save.action',
			   success: function(response, opts){
					var obj = Ext.decode(response.responseText);
			        var model = obj.model;
					if (model.status == "success") {
						var obj = Ext.decode(response.responseText);
						var searchResults = obj.map.searchResults;
						var data = getGridData(searchResults, ['name','addressLineOne','addressLineTwo','telephone','fax']);
						self.store.loadData(data);
						self.gridData = searchResults;
						company.initialize();
						showMessage("S");
					} else {
						showMessage("E", model.errorMessage);
					}
			   },
			   failure: function(){
				   			showMessage("F");
						},
			   headers: {
			       'my-header': 'foo'
			   },
			   params: params
		});
	},
	
	createFormPanel: function() {
		
		var form = new Ext.FormPanel({
	        labelWidth: 125, // label settings here cascade unless overridden
	        autoHeight: true,
	        bodyStyle:'padding:5px 5px 0',
	        width: 350,
	        defaults: {width: 230},
	        defaultType: 'textfield',

	        items: [{id:'id',xtype:'hidden',name:'id'}, 
	                {id:'name',xtype:'textfield',name: 'name',fieldLabel: 'Company Name',allowBlank:false},
	                {id:'addressLineOne',xtype:'textfield',name: 'addressLineOne', fieldLabel: 'Address Line One',allowBlank:false},
	                {id:'addressLineTwo',xtype:'textfield',name: 'addressLineTwo', fieldLabel: 'Address Line Two',allowBlank:true},
	                {id:'telephone',xtype:'textfield',name: 'telephone', fieldLabel: 'Telephone',allowBlank:false},
	                {id:'fax',xtype:'textfield',name: 'fax', fieldLabel: 'Fax',allowBlank:true},
	                {id:'version',  xtype:'hidden',   name: 'version'}
	        ]
	    });

	    this.btnPanel = new Ext.Panel({
	    	autoHeight: true,
	    	frame:false,
	    	buttonAlign:'left',
	    	title:'User Details',
	    	collapsible: true,
	    	items: form,
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