package org.david.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class SerializerTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Vehicle> vehicleList;


    @Before
    public void before() {
        vehicleList = new ArrayList<Vehicle>();
        Car car1 = new Car();
        car1.setColor("brown");
        car1.setYear(1990);

        vehicleList.add(car1);

        Truck truck = new Truck();
        truck.setNumPassengersInCabin(4);
        truck.setNumWheels(18);
        truck.setColor("blue");
        truck.setYear(2010);

        vehicleList.add(truck);
    }


    @Test
    public void serializeListAsList() throws IOException {
        String listSerialized = objectMapper.writeValueAsString(vehicleList);
        //here we set that the serialized List did not include the type
        assertThat(listSerialized.indexOf("type"), is(-1));
    }

    @Test
    public void serializeListAsArray() throws IOException {
        String listSerialized = objectMapper.writeValueAsString(vehicleList);
        String arraySerialized = objectMapper.writeValueAsString(vehicleList.toArray(new Vehicle[vehicleList.size()]));
        assertThat(arraySerialized, not(listSerialized));
        assertThat(arraySerialized, containsString("type"));
        //here we set that the serialized List did not include the type
        List<Vehicle> actual = Arrays.asList(objectMapper.readValue(arraySerialized,Vehicle[].class));
        assertThat(actual, contains(vehicleList.toArray()));
    }

}
