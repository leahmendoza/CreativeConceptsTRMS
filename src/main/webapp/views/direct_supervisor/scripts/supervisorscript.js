//USING AJAX TO PULL INFO FROM FRONT CRONTROLLER SERVLET

      function getAllSuperForms(){
    		let url = "/P1Servlet/creativeconcepts/reimburesmentforms/supervisor_pending";
    		let xhr = new XMLHttpRequest();
    		let body = document.getElementById("bodied");
    		
    		xhr.onreadystatechange = function(){
    			if(xhr.status === 200 && xhr.readyState === 4){
    				let forms = JSON.parse(xhr.responseText);
    				console.log(forms);
    				for(let f of forms){
    					let row = document.createElement("tr");
    					let fId = document.createElement("td");
    					let fCampus = document.createElement("td");
    					let fDate_Received = document.createElement("td");
    					let fGrading_Format = document.createElement("td");
    					let fReason = document.createElement("td");
    					let fDescription = document.createElement("td");
    					let fCost = document.createElement("td");
    					let fTimeOfAbsence_FROM = document.createElement("td");
    					let fTimeOfAbsence_TO = document.createElement("td");
    					let fApproved_By_Sup = document.createElement("td");
    					
    					fId.innerHTML = f["id_reimburesment"];
    					fCampus.innerHTML = f["campus"];
    					fDate_Received.innerHTML = f["date_received"];
    					fGrading_Format.innerHTML = f["grading_format"];
    					fReason.innerHTML = f["reason"];
    					fDescription.innerHTML = f["description"];
    					fCost.innerHTML = f["cost"];
    					fTimeOfAbsence_FROM.innerHTML = f["timeOfAbsence_FROM"];
    					fTimeOfAbsence_TO.innerHTML = f["timeOfAbsence_TO"];
    					fApproved_By_Sup.innerHTML = f["approved_by_dh"];
    					
    					row.appendChild(fId);
    					row.appendChild(fCampus);
    					row.appendChild(fDate_Received);
    					row.appendChild(fGrading_Format);
    					row.appendChild(fReason);
    					row.appendChild(fDescription);
    					row.appendChild(fCost);
    					row.appendChild(fTimeOfAbsence_FROM);
    					row.appendChild(fTimeOfAbsence_TO);
    					row.appendChild(fApproved_By_Sup);
    					body.appendChild(row);
    				}
    			}
    		}
    		
    		xhr.open("GET", url);
    		xhr.send();
    	}
      
	      function getAllEmpForms(){
	  		let url = "/P1Servlet/creativeconcepts/reimburesmentforms/emp_pending";
	  		let xhr = new XMLHttpRequest();
	  		let body = document.getElementById("loweremployeesbodied");
	  		
	  		xhr.onreadystatechange = function(){
	  			if(xhr.status === 200 && xhr.readyState === 4){
	  				let forms = JSON.parse(xhr.responseText);
	  				console.log(forms);
	  				for(let f of forms){
	  					let row = document.createElement("tr");
	  					let fId = document.createElement("td");
	  					let fUsername = document.createElement("td");
	  					let fCampus = document.createElement("td");
	  					let fDate_Received = document.createElement("td");
	  					let fGrading_Format = document.createElement("td");
	  					let fReason = document.createElement("td");
	  					let fDescription = document.createElement("td");
	  					let fCost = document.createElement("td");
	  					let fApproved_By_Sup = document.createElement("td");
	  					let fOptions = document.createElement("td");
	  					
	  					fId.innerHTML = f["id_reimburesment"];
	  					fUsername.innerHTML = f["username"];
	  					fCampus.innerHTML = f["campus"];
	  					fDate_Received.innerHTML = f["date_received"];
	  					fGrading_Format.innerHTML = f["grading_format"];
	  					fReason.innerHTML = f["reason"];
	  					fDescription.innerHTML = f["description"];
	  					fCost.innerHTML = f["cost"];
	  					fOptions.innerHTML = ["<form action='http://localhost:8080/P1Servlet/creativeconcepts/sub_action' method='post'><div class='btn-group'> <input type='hidden' name='username' value ='" + f["username"] +"' ><input name='id_reimbursement' type='hidden' value='" + f["id_reimburesment"] +"' ><button name='action' type='submit' value='1' class='btn btn-outline-success btn-sm' id='approved_by_super'>Approve</button> <button name='action' type='submit' class='btn btn-outline-secondary btn-sm' id='view-form'>View</button> <button name='action' type='submit' value='2' class='btn btn-outline-danger btn-sm' id='super-deny-form'>Deny</button> </div></form>"];
	  					
	  					row.appendChild(fId);
	  					row.appendChild(fUsername);
	  					row.appendChild(fCampus);
	  					row.appendChild(fDate_Received);
	  					row.appendChild(fGrading_Format);
	  					row.appendChild(fReason);
	  					row.appendChild(fDescription);
	  					row.appendChild(fCost);
	  					row.appendChild(fOptions);
	  					body.appendChild(row);
	  				}
	  			}
	  		}
	  		
	  		xhr.open("GET", url);
	  		xhr.send();
	  	}

    	function Form(id_reimburesment, campus, date_received, grading_format,
    			reason, description, cost, supporting_document, timeOfAbsence_FROM,
    			timeOfAbsence_TO, exceeding_funds, urgent, approved_by_sup, 
    			approved_by_dh, approved_by_benco){
    		this.id_reimburesment = id_reimburesment;
    		this.campus = campus;
    		this.date_received = date_received;
    		this.grading_format = grading_format;
    		this.reason = reason;
    		this.description = description;
    		this.cost = cost;
    		this.supporting_document = supporting_document;
    		this.timeOfAbsence_FROM = timeOfAbsence_FROM;
    		this.timeOfAbsence_TO = timeOfAbsence_TO;
    		this.exceeding_funds = exceeding_funds;
    		this.urgent = urgent;
    		this.approved_by_sup = approved_by_sup;
    		this.approved_by_dh = approved_by_dh;
    		this.approved_by_benco = approved_by_benco;
    	}

    	let loadStatus = document.getElementById("loadStatus");
    	let loadLowerEmployeesStatus = document.getElementById("loadLowerEmployeesStatus");

    	window.onload = function() {
    		getAllSuperForms();
    		getAllEmpForms();
    		
    	}