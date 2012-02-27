package com.redpill.alfresco.rewards;

import org.alfresco.model.ContentModel;
import org.alfresco.repo.node.NodeServicePolicies;
import org.alfresco.repo.policy.Behaviour.NotificationFrequency;
import org.alfresco.repo.policy.JavaBehaviour;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.namespace.NamespaceService;
import org.alfresco.service.namespace.QName;
import org.apache.log4j.Logger;

import com.redpill.alfresco.rewards.model.RewardsModel;

/**
 * 
 * @author bhagya
 * 
 */
public class AddContentBehavior extends RewardsBase implements NodeServicePolicies.OnCreateNodePolicy {

	private final static Logger LOG = Logger.getLogger(AddContentBehavior.class);

	public void init() {
		this.policyComponent.bindClassBehaviour(QName.createQName(NamespaceService.ALFRESCO_URI, "onCreateNode"), ContentModel.TYPE_CONTENT, new JavaBehaviour(this,
				"onCreateNode", NotificationFrequency.FIRST_EVENT));

		LOG.info("Initializing AddContentBehavior completed.");
	}

	@Override
	public void onCreateNode(ChildAssociationRef nodeRef) {
		LOG.info("Creating new node...");

		Integer contentNodes = (Integer) nodeService.getProperty(getCurrentUser(), RewardsModel.PROP_NO_OF_CONTENT_NODES_CREATED);
		int numberOfDocuments = contentNodes + 1;
		nodeService.setProperty(getCurrentUser(), RewardsModel.PROP_NO_OF_CONTENT_NODES_CREATED, numberOfDocuments);

		// Award every 10 documents (2 for testing purposes)
		if (numberOfDocuments % 2 == 0) {
			nodeService.setProperty(getCurrentUser(), RewardsModel.PROP_BADGES, nodeService.getProperty(getCurrentUser(), RewardsModel.PROP_BADGES) + ",document_junkie");
		}
		LOG.info("Number of documents by user : " + numberOfDocuments);
	}
}
