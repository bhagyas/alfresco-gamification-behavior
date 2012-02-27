package com.redpill.alfresco.rewards;

import org.alfresco.repo.policy.PolicyComponent;
import org.alfresco.repo.security.authentication.AuthenticationUtil;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.cmr.security.PersonService;
import org.apache.log4j.Logger;

import com.redpill.alfresco.rewards.model.RewardsModel;

public abstract class RewardsBase {

	protected NodeService nodeService;
	protected PersonService personService;
	protected PolicyComponent policyComponent;
	
	private final static Logger LOG = Logger.getLogger(RewardsBase.class);
	
	public NodeRef getCurrentUser() {
		NodeRef currentUser = getPersonService().getPerson(AuthenticationUtil.getRunAsUser());
		
		//if the user doesnt have rewardable aspect ,add it
		LOG.info("Getting the current user for rewarding behavior...");
		if(!nodeService.hasAspect(currentUser, RewardsModel.ASPECT_REWARDABLE)) {
			nodeService.addAspect(currentUser, RewardsModel.ASPECT_REWARDABLE, null);
		}
		
		return currentUser;
	}
	

	public NodeService getNodeService() {
		return nodeService;
	}

	public void setNodeService(NodeService nodeService) {
		this.nodeService = nodeService;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public PolicyComponent getPolicyComponent() {
		return policyComponent;
	}

	public void setPolicyComponent(PolicyComponent policyComponent) {
		this.policyComponent = policyComponent;
	}


}
