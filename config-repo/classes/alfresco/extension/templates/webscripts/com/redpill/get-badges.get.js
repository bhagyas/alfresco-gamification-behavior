function main() {
	var badgesText = person.properties["rm:badges"];
	
	if (badgesText != null) {

		model.badges = badgesText.split(",");
	} else {

		model.badges = [];
	}

}

main();