package org.david.serialization;

public class Truck extends Vehicle {
    private int  numWheels;
    private int numPassengersInCabin;

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public int getNumPassengersInCabin() {
        return numPassengersInCabin;
    }

    public void setNumPassengersInCabin(int numPassengersInCabin) {
        this.numPassengersInCabin = numPassengersInCabin;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "numWheels=" + numWheels +
                ", numPassengersInCabin=" + numPassengersInCabin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Truck truck = (Truck) o;

        if (numWheels != truck.numWheels) return false;
        return numPassengersInCabin == truck.numPassengersInCabin;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numWheels;
        result = 31 * result + numPassengersInCabin;
        return result;
    }
}
