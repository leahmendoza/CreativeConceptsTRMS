function getAllForms(){
    		let url = "/P1Servlet/creativeconcepts/reimburesmentforms/sup_log";
    		let xhr = new XMLHttpRequest();
    		let body = document.getElementById("bodied");
    		
    		xhr.onreadystatechange = function(){
    			if(xhr.status === 200 && xhr.readyState === 4){
    				let forms = JSON.parse(xhr.responseText);
    				console.log(forms);
    				for(let f of forms){
    					let row = document.createElement("tr");
    					let fId = document.createElement("td");
    					let fDate_Received = document.createElement("td");
    					let fReason = document.createElement("td");
    					let fDescription = document.createElement("td");
    					let fCost = document.createElement("td");
    					let fApproved_By_DH = document.createElement("td");
    					let fApproved_By_Benco = document.createElement("td");
    					let fOptions = document.createElement("td");
    					
    					fId.innerHTML = f["id_reimburesment"];
    					fDate_Received.innerHTML = f["date_received"];
    					fReason.innerHTML = f["reason"];
    					fDescription.innerHTML = f["description"];
    					fCost.innerHTML = f["cost"];
    					fApproved_By_DH.innerHTML = f["approved_by_dh"];
    					fApproved_By_Benco.innerHTML = f["approved_by_benco"];
    					fOptions.innerHTML = ["<button type='button' class='btn btn-outline-secondary btn-sm' id='view-form' href='../view_form.html'>View</button>"];
	  					
    					
    					row.appendChild(fId);
    					row.appendChild(fDate_Received);
    					row.appendChild(fReason);
    					row.appendChild(fDescription);
    					row.appendChild(fCost);
    					row.appendChild(fApproved_By_DH);
    					row.appendChild(fApproved_By_Benco);
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
			let fDate_Received = document.getElementById("fDate_Received").value;
			let fReason = document.getElementById("fReason").value;
			let fDescription = document.getElementById("fDescription").value;
			let fCost = document.getElementById("fCost").value;
			let fApproved_By_DH = document.getElementById("fApproved_By_DH").value;
			let fApproved_By_Benco = document.getElementById("fApproved_By_Benco").value;
			
			let form = new Form(fid_reimburesment, fcampus, fdate_received, fgrading_format,
					freason, fdescription, fcost, fapproved_by_sup, fapproved_by_dh,
					fapproved_by_benco);
			
			xhr.onreadystatechange = function(){
				if(xhr.status === 200 && xhr.readyState === 4){
					console.log("Object Sent!")
				}
			}
			
			xhr.open("POST", url);
			xhr.send(JSON.stringify(form));
		}
		
		let loadLog = document.getElementById("loadLog");
		let submitButton = document.getElementById("theButton");
		
		loadLog.addEventListener("click", formPostRequest);
		
		window.onload = function() {
			getAllForms();
		}