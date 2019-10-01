//USING AJAX TO PULL INFO FROM THE FRONT CONTROLLER SERVLET
function getAllForms(){
    		let url = "/P1Servlet/creativeconcepts/reimburesmentforms/emp_pending";
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
    					let fOptions = document.createElement("td");
    					
    					fId.innerHTML = f["id_reimburesment"];
    					fCampus.innerHTML = f["campus"];
    					fDate_Received.innerHTML = f["date_received"];
    					fGrading_Format.innerHTML = f["grading_format"];
    					fReason.innerHTML = f["reason"];
    					fDescription.innerHTML = f["description"];
    					fCost.innerHTML = f["cost"];
    					fTimeOfAbsence_FROM.innerHTML = f["timeOfAbsence_FROM"];
    					fTimeOfAbsence_TO.innerHTML = f["timeOfAbsence_TO"];
    					fApproved_By_Sup.innerHTML = f["approved_by_sup"];
    					fOptions.innerHTML = ["<button type='button' class='btn btn-outline-secondary btn-sm' id='view-form' href='../view_form.html'>View</button>"];
	  					
    					
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
				timeOfAbsence_TO){
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
		}
		
		function formPostRequest(){
			let url = "/P1Servlet/FrontController";
			let xhr = new XMLHttpRequest();
			
			let fId = document.getElementById("fId").value;
			let fCampus = document.getElementById("fCampus").value;
			let fDate_Received = document.getElementById("fDate_Received").value;
			let fGrading_Format = document.getElementById("fGrading_Format").value;
			let fReason = document.getElementById("fReason").value;
			let fDescription = document.getElementById("fDescription").value;
			let fCost = document.getElementById("fCost").value;
			let fSupporting_Document = document.getElementById("fSupporting_Document").value;
			let fTimeOfAbsence_FROM = document.getElementById("fTimeOfAbsence_TO").value;
			
			let form = new Form(fid_reimburesment, fcampus, fdate_received, fgrading_format,
					freason, fdescription, fcost, fsupporting_document, ftimeOfAbsence_FROM,
					ftimeOfAbsence_TO);
			
			xhr.onreadystatechange = function(){
				if(xhr.status === 200 && xhr.readyState === 4){
					console.log("Object Sent!")
				}
			}
			
			xhr.open("POST", url);
			xhr.send(JSON.stringify(form));
		}
		
		let loadStatus = document.getElementById("loadStatus");
		let submitButton = document.getElementById("theButton");
		
		loadStatus.addEventListener("click", formPostRequest);
		
		window.onload = function() {
			getAllForms();
		}