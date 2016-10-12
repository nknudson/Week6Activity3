package gov.weather;
import java.io.*;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.*;

/**
 * Created by nataliya.knudson on 10/12/2016.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new  NdfdXMLLocator().getndfdXMLPort();

        String result = binding.latLonListZipCode("53711");
        // Setting the expected value to ??? so this assertion will fail, but will also allow us to to see the returned value
        assertEquals("Result did not match expected value","???",result);
    }

        @Test
        public void latLonListListZipCodeNew () throws Exception {
            JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();
            String result = binding.latLonListZipCode("53711");
            DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(result));

            //assertTrue("Result did not match expected value",  dwml != null);
            assertEquals("Result did not match expected value","???",dwml.getLatLonList());

        }

}