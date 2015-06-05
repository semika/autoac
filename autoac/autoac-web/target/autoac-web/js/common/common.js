/**
 * This method navigates all the DOM elements within the specified container
 * elements and set the values for each input field from the data object. It is
 * required to have same property names in the data object as in the field name
 * of the DOM.
 * @param dataObject
 * @param containerEl
 * @return
 */
function autoFill(dataObj, containerEl) {
	
	var elArray = Ext.DomQuery.jsSelect("input");
	
	Ext.each(elArray, function(el, index, elArray){
		var val = eval("dataObj." + el.name)
		el.value = val;
	});
}
/**
 * Disable all elements within the specified container.
 * @param containerEl
 * @return
 */
function disableAll(containerEl) {
	var elArray = Ext.DomQuery.jsSelect("input", containerEl);
	
	Ext.each(elArray, function(el, index, elArray){
		Ext.getCmp(el.id).disable();
	});
}

function addDefaultListeners(){
	Ext.EventManager.addListener("btnAdd", 'click', handleClick);
	Ext.EventManager.addListener("btnEdit", 'click', handleClick);
	//Ext.EventManager.addListener("myDiv", 'click', handleClick);
}
/**
 * e is not a standard event object, it is a Ext.EventObject
 * @param e
 * @param t
 * @return
 */

function showMessage(type, message){
	
	var sb = Ext.getCmp('basic-statusbar');
	switch(type){
		case 'E':
			sb.setStatus({
		        text: message,
		        wait:20000,
		        iconCls: 'x-status-error',
		        clear: false // auto-clear after a set interval
		    });
			break;
		case 'S':
			sb.setStatus({
		        text: "Record saved successfully.",
		        wait:10000,
		        iconCls: 'x-status-valid',
		        clear: false // auto-clear after a set interval
		    });
			break;
		case 'U':
			sb.setStatus({
		        text: "Record updated successfully.",
		        wait:10000,
		        iconCls: 'x-status-valid',
		        clear: false // auto-clear after a set interval
		    });
			break;
		case 'D':
			sb.setStatus({
		        text: "Record deleted successfully.",
		        wait:10000,
		        iconCls: 'x-status-valid',
		        clear: false // auto-clear after a set interval
		    });
			break;
		case 'F':
			sb.setStatus({
		        text: "Internal server failed.",
		        wait:10000,
		        iconCls: 'x-status-valid',
		        clear: false // auto-clear after a set interval
		    });
			break;
	}  
}

function getGridData(dataList, fieldList) {
	var data = [];
	for (var i = 0; i < dataList.length; i++) {
		var obj = dataList[i];
		var tmp = [];
		for (var j = 0; j < fieldList.length; j++) {
			tmp.push(eval("obj." + fieldList[j]));  
		}
		data.push(tmp);
	}
	return data;
}