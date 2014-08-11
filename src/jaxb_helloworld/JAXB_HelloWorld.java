/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_helloworld;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author mrroot
 */
public class JAXB_HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Customer cs = new Customer();
        cs.setId(100);
        cs.setName("Aerdy");
        cs.setAge(20);
        try {
            
            File file = new File ("/home/mrroot/file.xml");//alamat direktory file yang akan di simpan
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            //output untuk melakukan konversi menggunakan marshaller
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(cs, file);
            jaxbMarshaller.marshal(cs, System.out);
            
            //output shell
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
