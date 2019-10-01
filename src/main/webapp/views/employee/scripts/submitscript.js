
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
    	
    	let submitButton = document.getElementById("theButton");

    	submitButton.addEventListener("click", formPostRequest);