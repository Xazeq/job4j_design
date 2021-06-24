package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private  boolean is4WD;
    @XmlAttribute
    private  String manufacturer;
    @XmlAttribute
    private  int numberOfDoors;
    private  Engine engine;
    @XmlElementWrapper(name = "options")
    @XmlElement(name = "option")
    private  String[] options;

    public Car() {

    }

    public Car(boolean is4WD, String manufacturer, int numberOfDoors, Engine engine, String... options) {
        this.is4WD = is4WD;
        this.manufacturer = manufacturer;
        this.numberOfDoors = numberOfDoors;
        this.engine = engine;
        this.options = options;
    }

    @Override
    public String toString() {
        return "Car{"
                + "is4WD=" + is4WD
                + ", manufacturer='" + manufacturer + '\''
                + ", numberOfDoors=" + numberOfDoors
                + ", engine=" + engine
                + ", options=" + Arrays.toString(options)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Car car = new Car(true, "KIA", 4, new Engine(4, 149.5),
                "Leather seats", "Fog lights");
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Car carFromXml = (Car) unmarshaller.unmarshal(reader);
            System.out.println(carFromXml);
        }
    }
}
