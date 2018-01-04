var _table_ = document.createElement('table'),
    _tr_ = document.createElement('tr'),
    _th_ = document.createElement('th'),
    _td_ = document.createElement('td');

// Builds the HTML Table out of myList json data from Ivy restful service.
 function buildHtmlTable(arr) {
     var table = _table_.cloneNode(false),
         columns = addAllColumnHeaders(arr, table);
     for (var i=0, maxi=arr.length; i < maxi; ++i) {
         var tr = _tr_.cloneNode(false);
         for (var j=0, maxj=columns.length; j < maxj ; ++j) {
             var td = _td_.cloneNode(false);
                 cellValue = arr[i][columns[j]];
             td.appendChild(document.createTextNode(arr[i][columns[j]] || ''));
             tr.appendChild(td);
         }
         table.appendChild(tr);
     }
     return table;
 }

 // Adds a header row to the table and returns the set of columns.
 // Need to do union of keys from all records as some records may not contain
 // all records
 function addAllColumnHeaders(arr, table)
 {
     var columnSet = [],
         tr = _tr_.cloneNode(false);
     for (var i=0, l=arr.length; i < l; i++) {
         for (var key in arr[i]) {
             if (arr[i].hasOwnProperty(key) && columnSet.indexOf(key)===-1) {
                 columnSet.push(key);
                 var th = _th_.cloneNode(false);
                 th.appendChild(document.createTextNode(key));
                 tr.appendChild(th);
             }
         }
     }
     table.appendChild(tr);
     return columnSet;
 }
function loadTestJSON() {
  var empReimHttp = new XMLHttpRequest();
  var empReimbursements = document.getElementById("empReimbursements");
  empReimHttp.open("GET", "http://localhost:8080/trms/reimbursementsJSON", true);
  empReimHttp.onreadystatechange = function() {
  if(this.readyState==4 && this.status==200) {
    console.log(empReimHttp.responseText);
    var jsonresponse = empReimHttp.responseText;
    var tabString = buildHtmlTable(jsonresponse);
    console.log(tabString);
    empReimbursements.append(tabString);
  }
  else if(this.readyState == 4) {
    alert('status other than 200');
  }
  };
  empReimHttp.send();
};


function loadTest() {
  var assignReimHttp = new XMLHttpRequest();
  var assignedReimbursements = document.getElementById("assignedReimbursements");
  
  assignedReimbursements.innerHTML = '<p><em>Loading Reimbursements</em></p>';

  assignReimHttp.open("GET", "http://localhost:8080/trms/assignedReimbursements", true);

  assignReimHttp.onreadystatechange = function() {
    if(this.readyState == 4 && this.status == 200) {
      assignedReimbursements.innerHTML = assignReimHttp.responseText;
    }
    else if(this.readyState == 4) {
      alert('status other than 200');
      assignedReimbursements.innerHTML = "";
    }
  };

  assignReimHttp.send();

  var empReimHttp = new XMLHttpRequest();
  var empReimbursements = document.getElementById("empReimbursements");

  empReimbursements.innerHTML= '<p><em>Loading Reimbursements</em></p>';

  empReimHttp.open("GET", "http://localhost:8080/trms/reimbursements", true);

  empReimHttp.onreadystatechange = function() {
    if(this.readyState == 4 && this.status == 200) {
      empReimbursements.innerHTML = empReimHttp.responseText;
    }
    else if(this.readyState == 4) {
      alert('status other than 200');
      empReimbursements.innerHTML = "";
    }
  };
  empReimHttp.send();
};

window.ready = loadTest();
