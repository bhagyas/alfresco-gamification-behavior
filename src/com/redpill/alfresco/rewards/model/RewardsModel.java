package com.redpill.alfresco.rewards.model;

import org.alfresco.service.namespace.QName;

public interface RewardsModel {

	final String REWARDS_MODEL_URI = "http://rewards.alfresco.redpill-linpro.com/model/content/1.0";

	final QName ASPECT_REWARDABLE = QName.createQName(REWARDS_MODEL_URI, "rewardable");

	final QName PROP_NO_OF_CONTENT_NODES_CREATED = QName.createQName(REWARDS_MODEL_URI, "noOfContentNodesCreated");
	final QName PROP_NO_OF_CONTENT_NODES_DELETED = QName.createQName(REWARDS_MODEL_URI, "noOfContentNodesDeleted");

	final QName PROP_BADGES = QName.createQName(REWARDS_MODEL_URI, "badges");

}
