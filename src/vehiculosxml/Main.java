/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculosxml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Hector
 */
public class Main {

    public static void main(String[] a) {
        List<Vehiculo> carros = new ArrayList<>();

        Vehiculo carro = new Vehiculo();
        carro.setNombre("RAV4");
        carro.setMarca("TOYOTA");
        carro.setAnio(2017);
        carro.setModelo("WSDE34");
        List<Recomendacion> reco = new ArrayList();
        Recomendacion reco1 = new Recomendacion();
        reco1.setUsuario(112212);
        reco1.setDescripcion("Es un muy buen carro");
        reco.add(reco1);
        Recomendacion reco2 = new Recomendacion();
        reco2.setUsuario(12332432);
        reco2.setDescripcion("Tiene buena calidad");
        reco.add(reco2);
        carro.setRecomendaciones(reco);
        carros.add(carro);

        Vehiculo carro2 = new Vehiculo();
        carro2.setNombre("CIVIC");
        carro2.setMarca("TOYOTA");
        carro2.setAnio(2019);
        carro2.setModelo("ASDE3ADS4");
        List<Recomendacion> recomendacion2 = new ArrayList();
        Recomendacion reco1Carro2 = new Recomendacion();
        reco1Carro2.setUsuario(112212);
        reco1Carro2.setDescripcion("Es un muy buen carro");
        recomendacion2.add(reco1Carro2);
        Recomendacion reco2Carro2 = new Recomendacion();
        reco2Carro2.setUsuario(12332432);
        reco2Carro2.setDescripcion("Tiene buena calidad");
        recomendacion2.add(reco2Carro2);
        carro2.setRecomendaciones(recomendacion2);
        carros.add(carro2);

        Vehiculo carro3 = new Vehiculo();
        carro3.setNombre("RAV4");
        carro3.setMarca("TOYOTA");
        carro3.setAnio(2017);
        carro3.setModelo("WSDE34");
        List<Recomendacion> recomendacion3 = new ArrayList();
        Recomendacion reco1Carro3 = new Recomendacion();
        reco1Carro3.setUsuario(112212);
        reco1Carro3.setDescripcion("Es un muy buen carro");
        recomendacion3.add(reco1Carro3);
        Recomendacion reco2Carro3 = new Recomendacion();
        reco2Carro3.setUsuario(12332432);
        reco2Carro3.setDescripcion("Tiene buena calidad");
        recomendacion3.add(reco2Carro3);
        carro3.setRecomendaciones(recomendacion3);
        carros.add(carro3);

        Vehiculo carro4 = new Vehiculo();
        carro4.setNombre("RAV4");
        carro4.setMarca("TOYOTA");
        carro4.setAnio(2017);
        carro4.setModelo("WSDE34");
        List<Recomendacion> recomendacion4 = new ArrayList();
        Recomendacion reco1Carro4 = new Recomendacion();
        reco1Carro4.setUsuario(112212);
        reco1Carro4.setDescripcion("Es un muy buen carro");
        recomendacion4.add(reco1Carro4);
        Recomendacion reco2Carro4 = new Recomendacion();
        reco2Carro4.setUsuario(12332432);
        reco2Carro4.setDescripcion("Tiene buena calidad");
        recomendacion4.add(reco2Carro4);
        carro4.setRecomendaciones(recomendacion4);
        carros.add(carro4);

        Vehiculo carro5 = new Vehiculo();
        carro5.setNombre("RAV4");
        carro5.setMarca("TOYOTA");
        carro5.setAnio(2017);
        carro5.setModelo("WSDE34");
        List<Recomendacion> recomendacion5 = new ArrayList();
        Recomendacion reco1Carro5 = new Recomendacion();
        reco1Carro5.setUsuario(112212);
        reco1Carro5.setDescripcion("Es un muy buen carro");
        recomendacion5.add(reco1Carro5);
        Recomendacion reco2Carro5 = new Recomendacion();
        reco2Carro5.setUsuario(12332432);
        reco2Carro5.setDescripcion("Tiene buena calidad");
        recomendacion5.add(reco2Carro5);
        carro5.setRecomendaciones(recomendacion5);
        carros.add(carro5);

        crearXML(carros);

    }

    public static void crearXML(List<Vehiculo> carros) {

        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            for (Vehiculo carro : carros) {

                Element vehiculo = document.createElement("Vehiculo");
                
                

                Element nombre = document.createElement("Nombre");
                Text nombreText = document.createTextNode(carro.getNombre());

                Element marca = document.createElement("Marca");
                Text marcaText = document.createTextNode(carro.getMarca());

                Element modelo = document.createElement("Modelo");
                Text modeloText = document.createTextNode(carro.getModelo());

                Element anio = document.createElement("Anio");
                Text anioText = document.createTextNode(carro.getAnio().toString());

                //Asignamos la versión de nuestro XML
                document.setXmlVersion("1.0");

                document.getDocumentElement().appendChild(vehiculo);

                //Añadimos el elemento hijo a la raíz
                vehiculo.appendChild(nombre);
                nombre.appendChild(nombreText);

                vehiculo.appendChild(marca);
                marca.appendChild(marcaText);

                vehiculo.appendChild(modelo);
                modelo.appendChild(modeloText);

                vehiculo.appendChild(anio);
                anio.appendChild(anioText);

                Element recomendaciones = document.createElement("Recomendaciones");

                for (Recomendacion recomendacion : carro.getRecomendaciones()) {

                    Element comentario = document.createElement("Comentario");

                    Element usuario = document.createElement("Usuario");
                    Text usuarioText = document.createTextNode(recomendacion.getUsuario().toString());

                    Element descripcion = document.createElement("Descripcion");
                    Text descripcionText = document.createTextNode(recomendacion.getDescripcion());

                    //Añadimos el elemento hijo a la raíz
                    comentario.appendChild(usuario);
                    usuario.appendChild(usuarioText);

                    comentario.appendChild(descripcion);
                    descripcion.appendChild(descripcionText);

                    recomendaciones.appendChild(comentario);
                }

                vehiculo.appendChild(recomendaciones);

            }
            guardaConFormato(document, "vehiculo.xml");
            recuperarCarro();

        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    public static void guardaConFormato(Document document, String URI) {
        try {
            TransformerFactory transFact = TransformerFactory.newInstance();

            //Formateamos el fichero. Añadimos sangrado y la cabecera de XML
            transFact.setAttribute("indent-number", new Integer(3));
            Transformer trans = transFact.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

            //Hacemos la transformación
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource domSource = new DOMSource(document);
            trans.transform(domSource, sr);

            //Mostrar información a guardar por consola (opcional)
            //Result console= new StreamResult(System.out);
            //trans.transform(domSource, console);
            try {
                //Creamos fichero para escribir en modo texto
                PrintWriter writer = new PrintWriter(new FileWriter(URI));

                //Escribimos todo el árbol en el fichero
                writer.println(sw.toString());

                //Cerramos el fichero
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void recuperarCarro() throws FileNotFoundException, JDOMException, IOException{
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( "vehiculo.xml" );
        try{
        org.jdom2.Document doc = (org.jdom2.Document) builder.build (xmlFile);
        org.jdom2.Element root = (org.jdom2.Element) doc.getRootElement();
        
        List list = root.getChildren( "Vehiculo" );
        org.jdom2.Element tabla = (org.jdom2.Element) list.get(0);
        List lista_campos = tabla.getChildren();
        List<String> elementos = new ArrayList();
        int cont = 0;
        System.out.println("Vehiculo: \n");
        for(int i = 0; i< lista_campos.size(); i++){
            org.jdom2.Element campo = (org.jdom2.Element)lista_campos.get(i);
            String elemento = campo.getContent(0).getValue();
            if(cont == 4){
                String recomendaciones = "Recomendaciones: \n";
                recomendaciones += "Usuario: \n"+campo.getChildren().get(0).getContent(1).getValue()+"\n";
                recomendaciones += "Descripcion: \n"+campo.getChildren().get(0).getContent(3).getValue()+"\n";
                recomendaciones +="\n";
                recomendaciones += "Usuario: \n"+campo.getChildren().get(1).getContent(1).getValue()+"\n";
                recomendaciones += "Descripcion: \n"+campo.getChildren().get(1).getContent(3).getValue();
                elemento = recomendaciones;
            }
            
            System.out.println(elemento);
            elementos.add(elemento);
            cont++;
        }
        
        

        
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
  

}
