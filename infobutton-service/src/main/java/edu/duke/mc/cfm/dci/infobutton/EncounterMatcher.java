package edu.duke.mc.cfm.dci.infobutton;

import java.util.List;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CodedContextElement;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Id;

/*
$Rev:: 1095          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2010-10-01 1#$:  Date of last commit
*/

public class EncounterMatcher extends ContextMatcher {

	public Encounter encounter;
	public CodedContextElement encounterType;
    public List<Id> serviceDeliveryLocation;
    KnowledgeRequest request;
    List<String> supportedCodeSystems;
	
	public EncounterMatcher(CodedContextElement encounterType, List<Id> serviceDeliveryLocation, 
			KnowledgeRequest request,List<String> supportedCodeSystems) {
		
		this.encounter = request.getEncounter();
		this.encounterType = encounterType;
		this.serviceDeliveryLocation = serviceDeliveryLocation;
		this.request= request;
		this.supportedCodeSystems = supportedCodeSystems;
	}
	

	@Override
	public Boolean MatchContext() {
		if (!CodeMatch(encounter.getCode(), encounterType, supportedCodeSystems,false, request)) {
			return false;
		}
		return true;
	}

}
