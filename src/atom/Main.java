/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Hector
 */
public class Main {

    public static void main(String[] a) throws JDOMException, IOException {
        obtenerInformacion();
        System.out.println();
    }

    public static void obtenerInformacion() throws FileNotFoundException, JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("tec.xml");
        try {
            org.jdom2.Document doc = (org.jdom2.Document) builder.build(xmlFile);
            org.jdom2.Element root = (org.jdom2.Element) doc.getRootElement();

            List list = root.getChildren("channel");
            org.jdom2.Element tabla = (org.jdom2.Element) list.get(0);
            List lista_campos = tabla.getChildren();
            List<String> elementos = new ArrayList();
            int cont = 0;
            System.out.println("Informacion obtenida del FEED: \n");
            
            org.jdom2.Element campoTitulo1 = (org.jdom2.Element) lista_campos.get(9);
            String titulo = campoTitulo1.getContent(1).getValue();
            System.out.println("Titulo: "+titulo);
             
            org.jdom2.Element campoLink1 = (org.jdom2.Element) lista_campos.get(9);
            String link = campoLink1.getContent(3).getValue();
            System.out.println("Link: "+link);
            
            System.out.println("----------------------------------------------------");
            
            org.jdom2.Element campoTitulo2 = (org.jdom2.Element) lista_campos.get(10);
            String titulo2 = campoTitulo2.getContent(1).getValue();
            System.out.println("Titulo: "+titulo2);
             
            org.jdom2.Element campoLink2 = (org.jdom2.Element) lista_campos.get(10);
            String link2 = campoLink2.getContent(3).getValue();
            System.out.println("Link: "+link2);
            
            System.out.println("----------------------------------------------------");
            
            org.jdom2.Element campoTitulo3 = (org.jdom2.Element) lista_campos.get(11);
            String titulo3 = campoTitulo3.getContent(1).getValue();
            System.out.println("Titulo: "+titulo3);
             
            org.jdom2.Element campoLink3 = (org.jdom2.Element) lista_campos.get(11);
            String link3 = campoLink3.getContent(3).getValue();
            System.out.println("Link: "+link3);
            
            System.out.println("----------------------------------------------------");
            
            org.jdom2.Element campoTitulo4 = (org.jdom2.Element) lista_campos.get(12);
            String titulo4 = campoTitulo4.getContent(1).getValue();
            System.out.println("Titulo: "+titulo4);
             
            org.jdom2.Element campoLink4 = (org.jdom2.Element) lista_campos.get(12);
            String link4 = campoLink4.getContent(3).getValue();
            System.out.println("Link: "+link4);
            
            System.out.println("----------------------------------------------------");
            
            org.jdom2.Element campoTitulo5 = (org.jdom2.Element) lista_campos.get(13);
            String titulo5 = campoTitulo5.getContent(1).getValue();
            System.out.println("Titulo: "+titulo5);
             
            org.jdom2.Element campoLink5 = (org.jdom2.Element) lista_campos.get(13);
            String link5 = campoLink5.getContent(3).getValue();
            System.out.println("Link: "+link5);
            
            System.out.println("----------------------------------------------------");
            
            

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
