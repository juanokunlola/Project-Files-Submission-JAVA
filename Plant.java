package javaTrashTracker;


public enum Plant {
	OAK(10, "Tree", "a hardwood tree or shrub in the genus Quercus."),
	PINE(10, "Tree", "a conifer in the genus Pinus."),
	WILLOW(10, "Tree", "a deciduous tree or shrub of the genus Salix."),
	BIRCH(10, "Tree", "a thin-leaved deciduous hardwood tree of the genus Betula."),
	CEDAR(10, "Tree", "a coniferous tree in the genus Cedrus."),
	SNAPDRAGON(5, "Flower", "a flowering plant of the genus Antirrhinum."),
	PEONY(5, "Flower", "a flowering plant in the genus Paeonia."),
	ROSE(5, "Flower", "a woody perennial flowering plant of the genus Rosa."),
	ORCHID(5, "Flower", "a flowering plant of the genus Orchis."),
	LILY(5, "Flower", "a herbaceous flowering plant in the genus Lilium.");
	
	private final int price;
	private final String type;
	private final String description;
	
	private Plant(int price, String type, String description) {
		this.price = price;
		this.type = type;
		this.description = description;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String plantDisplay() {
        return name().charAt(0) + name().substring(1).toLowerCase() + ", " + description;
    }//display name and description in a user friendly manner
}
