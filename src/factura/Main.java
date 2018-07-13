/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Hector
 */
public class Main {
    public static void main(String []a) throws JDOMException, IOException{
        String factura1 = "factura1";
        obtenerInformacion(factura1);
        
        String factura2 = "-2017-02-26-CCO8605231N4_FAC_HER3369a946-9b18-4a5d-b08a-b33696527da3_20170226";
        obtenerInformacion(factura2);
        
        String factura3 = "aff6ccce-fb20-417c-8d90-47d132bc43c0";
        obtenerInformacion(factura3);
        
        String factura4 = "CETF800512GF4_Factura_FE5419_20170312";
        obtenerInformacion(factura4);
        
        String factura5 = "F0000015199";
        obtenerInformacion(factura5);
        
        String factura6 = "FACTURA-40354";
        obtenerInformacion(factura6);
        
        String factura7 = "SECFD_20170321_121815";
        obtenerInformacion(factura7);
        
        String factura8 = "V519000207";
        obtenerInformacion(factura8);
    }
    public static void obtenerInformacion(String nombre) throws FileNotFoundException, JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("factura/"+nombre+".xml");
        try {
            org.jdom2.Document doc = (org.jdom2.Document) builder.build(xmlFile);
            org.jdom2.Element root = (org.jdom2.Element) doc.getRootElement();

            List list = root.getChildren();
            org.jdom2.Element concepto = (org.jdom2.Element) list.get(2);
            List conceptos = concepto.getChildren();
            System.out.println("Informacion de factura "+nombre+": ");
            System.out.println();
            System.out.println("Articulos:");
            for(int i = 0; i < conceptos.size(); i++){
                
                org.jdom2.Element campoConcepto = (org.jdom2.Element) conceptos.get(i);
                
                System.out.println("Concepto "+(i+1)+": "+campoConcepto.getAttributeValue("descripcion"));
                System.out.println("Importe articulo : "+campoConcepto.getAttributeValue("importe"));
            }

            org.jdom2.Element emisor = (org.jdom2.Element) list.get(0);
            System.out.println("Emisor: "+emisor.getAttributeValue("nombre"));
            
            System.out.println("Subtotal: "+root.getAttributeValue("subTotal"));
            System.out.println("Importe total: "+root.getAttributeValue("total"));
            
            String total = root.getAttributeValue("total");
            String subtotal = root.getAttributeValue("subTotal");
            System.out.println("Cantidad final impuestos: "+(Double.valueOf(total)-Double.valueOf(subtotal)));
            
            System.out.println("Sello digital: "+root.getAttributeValue("sello"));
            
            System.out.println("------------------------------------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
