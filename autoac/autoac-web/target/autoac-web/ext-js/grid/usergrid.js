/*Ext.User = Ext.extend(Object, {
	
	top: null,
	userList:[],
	store:null,
	grid:null,
	
	constructor: function(test) {
		alert("user constructor called");
		//this.top = parent;
		//this.initDataStore();
		//this.initDataGrid();
		//this.renderGrid();
		//this.search();
	},
	
	*//**
     * Custom function used for column renderer
     * @param {Object} val
     *//*
    change:function(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '</span>';
        } else if (val < 0) {
            return '<span style="color:red;">' + val + '</span>';
        }
        return val;
    },

    *//**
     * Custom function used for column renderer
     * @param {Object} val
     *//*
    pctChange:function(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '%</span>';
        } else if (val < 0) {
            return '<span style="color:red;">' + val + '%</span>';
        }
        return val;
    },
    
	renderGrid: function() {
		// render the grid to the specified div in the page
	    this.grid.render('grid-example');
	},
	
	initDataGrid: function() {
		// create the Grid
	    this.grid = new Ext.grid.GridPanel({
	        store: this.store,
	        columns: [
	            {
	                id       :'userName',
	                header   : 'User Name', 
	                width    : 300, 
	                sortable : true, 
	                dataIndex: 'userName'
	            },
	            {
	                header   : 'Password', 
	                width    : 300, 
	                sortable : true, 
	                dataIndex: 'password'
	            },
	            {
	                header   : 'Lock', 
	                width    : 375, 
	                sortable : true, 
	                renderer : this.change, 
	                dataIndex: 'version'
	            }
	        ],
	        stripeRows: true,
	        autoExpandColumn: 'userName',
	        height: 250,
	        width: 975,
	        title: 'User Listing',
	        // config options for stateful behavior
	        stateful: true,
	        stateId: 'grid'
	    });
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
	
	search: function() {
		var _self = this;
		Ext.Ajax.request({
			   url: CONTEXT_ROOT +'/userSearch',
			   success: function(response, opts) {
			      var obj = Ext.decode(response.responseText);
			      var userList = obj.map.test;
			      
			      var userList = obj.map.test;
			      var data = [];
			      for (var i = 0; i < userList.length; i++) {
			    	  data.push([userList[i].userName, userList[i].password, userList[i]].version]);
			      }
			      //store.loadData(data);
			      _self.store.loadData(data);
			      _self.grid.doLayout();
			   },
			   failure: function(response, opts) {
			      console.log('server-side failure with status code ' + response.status);
			   }
		});
	},
	
	init: function() {
		alert("Init called");
	}
});*/

/*Ext.onReady(function() {
	alert("hi");
	//var user = new Ext.User();
	user.init();
});*/
function test() {
	alert("test");
}