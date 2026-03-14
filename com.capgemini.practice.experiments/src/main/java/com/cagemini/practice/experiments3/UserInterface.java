package com.cagemini.practice.experiments3;

import java.util.Scanner;

abstract class GoodsTransport {

    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    // 3-argument constructor
    public GoodsTransport(String transportId, String transportDate, int transportRating) {
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    // getters and setters
    public String getTransportId() { return transportId; }
    public void setTransportId(String transportId) { this.transportId = transportId; }

    public String getTransportDate() { return transportDate; }
    public void setTransportDate(String transportDate) { this.transportDate = transportDate; }

    public int getTransportRating() { return transportRating; }
    public void setTransportRating(int transportRating) { this.transportRating = transportRating; }

    // abstract methods
    public abstract String vehicleSelection();
    public abstract float calculateTotalCharge();
}

class BrickTransport extends GoodsTransport {

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    // 6 argument constructor
    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {

        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    // getters and setters
    public float getBrickSize() { return brickSize; }
    public void setBrickSize(float brickSize) { this.brickSize = brickSize; }

    public int getBrickQuantity() { return brickQuantity; }
    public void setBrickQuantity(int brickQuantity) { this.brickQuantity = brickQuantity; }

    public float getBrickPrice() { return brickPrice; }
    public void setBrickPrice(float brickPrice) { this.brickPrice = brickPrice; }

    // override methods
    @Override
    public String vehicleSelection() {
        // TODO: implement logic
    	if(getBrickSize() < 300) return "Truck";
    	else if(getBrickSize() >= 300 && getBrickSize() <= 500) return "Lorry";
    	else if(getBrickSize() > 500) return "MonsterLorry";
        return null;
    }

    @Override
    public float calculateTotalCharge() {
        // TODO: implement logic
    	float price = (getBrickPrice() * getBrickQuantity());
    	double tax = price * 0.3;
    	double discount = price * 
        return 0;
    }
}

class TimberTransport extends GoodsTransport {

    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    // 7 argument constructor
    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius,
                           String timberType, float timberPrice) {

        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    // getters and setters
    public float getTimberLength() { return timberLength; }
    public void setTimberLength(float timberLength) { this.timberLength = timberLength; }

    public float getTimberRadius() { return timberRadius; }
    public void setTimberRadius(float timberRadius) { this.timberRadius = timberRadius; }

    public String getTimberType() { return timberType; }
    public void setTimberType(String timberType) { this.timberType = timberType; }

    public float getTimberPrice() { return timberPrice; }
    public void setTimberPrice(float timberPrice) { this.timberPrice = timberPrice; }

    @Override
    public String vehicleSelection() {
        // TODO: implement logic
        return null;
    }

    @Override
    public float calculateTotalCharge() {
        // TODO: implement logic
        return 0;
    }
}

class Utility {

    public GoodsTransport parseDetails(String input) {

        // TODO: split string using :
        // identify BrickTransport or TimberTransport
        // create respective object
        return null;
    }

    public boolean validateTransportId(String transportId) {

        // TODO: regex validation
        return false;
    }

    public String findObjectType(GoodsTransport goodsTransport) {

        // TODO: use instanceof
        return null;
    }
}


public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Utility util = new Utility();

        System.out.println("Enter the Goods Transport details");
        String input = sc.nextLine();

        GoodsTransport obj = util.parseDetails(input);

        // validate, find type, calculate charge
        // TODO: implement flow

	}
}
