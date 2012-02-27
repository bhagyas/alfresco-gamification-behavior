package com.redpill.alfresco.rewards;

import org.alfresco.model.ContentModel;
import org.alfresco.repo.node.NodeServicePolicies;
import org.alfresco.repo.policy.Behaviour.NotificationFrequency;
import org.alfresco.repo.policy.JavaBehaviour;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.namespace.NamespaceService;
import org.alfresco.service.namespace.QName;
import org.apache.log4j.Logger;

/**
 * 
 * @author bhagya
 * 
 */
public class DeleteContentBehavior extends RewardsBase implements NodeServicePolicies.OnDeleteNodePolicy {

	private final static Logger LOG = Logger.getLogger(DeleteContentBehavior.class);

	public void init() {
		this.getPolicyComponent().bindClassBehaviour(QName.createQName(NamespaceService.ALFRESCO_URI, "onDeleteNode"), ContentModel.TYPE_CONTENT,
				new JavaBehaviour(this, "onDeleteNode", NotificationFrequency.FIRST_EVENT));

		LOG.info("Initializing PublishWithShortUrlBehavior completed.");
	}

	@Override
	public void onDeleteNode(ChildAssociationRef nodeRef, boolean arg1) {
		// if (!nodeService.exists(nodeRef)) {
		// LOG.error("Executed behaviour on non existing node: " + nodeRef);
		// return;
		// }
		// LOG.warn("OnAddAsepct for " + nodeRef + " with aspect " + aspectTypeQName);
		// createNewShortLinkItem(nodeRef);
		LOG.info("To be implemented.");
	}

}
