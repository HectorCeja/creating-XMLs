package pedidos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import static vehiculosxml.Main.guardaConFormato;
import vehiculosxml.Vehiculo;


public class Main {
    
    public static void main(String[]a) throws ClassNotFoundException, SQLException{
        Connection con = conexion();
        List<Pedido> pedidos = obtenerDatosLocales(con);
        crearXML(pedidos);
        System.out.println();
    }
    
    public static void crearXML(List<Pedido> pedidos){
        
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try{
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            for(Pedido pedido : pedidos){
                  
                Element pedidoE = document.createElement("Pedido"); 

                Element id= document.createElement("ID");
                Text idText = document.createTextNode(pedido.getId().toString());

                Element cliente = document.createElement("Cliente"); 
                Text clienteText = document.createTextNode(pedido.getCliente()); 

                Element estado = document.createElement("Estado"); 
                Text estadoText = document.createTextNode(pedido.getEstado());

                Element entrega = document.createElement("FechaEntrega"); 
                Text fechaText = document.createTextNode(pedido.getFecha().toString()); 

                Element direccion = document.createElement("Direccion"); 
                Text direccionText = document.createTextNode(pedido.getDireccion()); 

                //Asignamos la versión de nuestro XML
                document.setXmlVersion("1.0"); 

                document.getDocumentElement().appendChild(pedidoE); 

                //Añadimos el elemento hijo a la raíz
                pedidoE.appendChild(id);
                id.appendChild(idText);

                pedidoE.appendChild(cliente); 
                cliente.appendChild(clienteText);

                pedidoE.appendChild(estado); 
                estado.appendChild(estadoText);

                pedidoE.appendChild(entrega);
                entrega.appendChild(fechaText);

                pedidoE.appendChild(direccion);
                direccion.appendChild(direccionText);
                
                Element partidas = document.createElement("Partidas"); 
                
                for(PartidasPedido partida : pedido.getPartidas()){
                    
                    Element partidaP = document.createElement("Partida"); 
                    
                    Element idP= document.createElement("ID");
                    Text idPText = document.createTextNode(partida.getId().toString());

                    Element idPedido = document.createElement("idPedido"); 
                    Text idPedidoText = document.createTextNode(partida.getIdPedido().toString()); 

                    Element articulo = document.createElement("Articulo"); 
                    Text articuloText = document.createTextNode(partida.getArticulo());

                    Element cantidad = document.createElement("Cantidad"); 
                    Text cantidadText = document.createTextNode(partida.getCantidad().toString()); 

                    Element surtido = document.createElement("Surtido"); 
                    Text surtidoText = document.createTextNode(partida.getSurtido().toString()); 
                    
                    Element descripcion = document.createElement("Descripcion"); 
                    Text descripcionText = document.createTextNode(partida.getDescripcion()); 

                    //Añadimos el elemento hijo a la raíz
                    partidaP.appendChild(idP);
                    idP.appendChild(idPText);

                    partidaP.appendChild(idPedido); 
                    idPedido.appendChild(idPedidoText);

                    partidaP.appendChild(articulo); 
                    articulo.appendChild(articuloText);

                    partidaP.appendChild(cantidad);
                    cantidad.appendChild(cantidadText);

                    partidaP.appendChild(surtido);
                    surtido.appendChild(surtidoText);
                    
                    partidaP.appendChild(descripcion);
                    descripcion.appendChild(descripcionText);
                    
                    partidas.appendChild(partidaP);
                }
                
                pedidoE.appendChild(partidas);
            }
            guardaConFormato(document,"C:\\Users\\Hector\\Desktop\\pedidos.xml");

         }catch(Exception e){
             System.err.println("Error");
         } 
    }
    
    public static List<Pedido> obtenerDatosLocales(Connection con) throws ClassNotFoundException, SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        PreparedStatement pst2 = null;
        ResultSet rs2 = null;
        List<Pedido> lista = new ArrayList();
        try {

            String query = "SELECT "
                    + "* "
                    + "FROM pedidos  ";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
           
            while (rs.next()) {
                
                    Pedido pedido = new Pedido();
 
                    pedido.setId(rs.getInt("id"));
                    pedido.setFecha(rs.getDate("fechaEntrega"));
                    pedido.setCliente(rs.getString("Cliente"));
                    pedido.setEstado(rs.getString("Estado"));
                    pedido.setDireccion(rs.getString("direccion"));
                    
                    String query2 = "SELECT * "
                    + "FROM PartidasPedidos "
                    + "WHERE PedidoId = ? ";

                    pst2 = con.prepareStatement(query2);
                    pst2.setInt(1, pedido.getId());
                    rs2 = pst2.executeQuery();
                    List<PartidasPedido> partidas = new ArrayList<>();
                    
                    while(rs2.next()){
                        PartidasPedido partida = new PartidasPedido();
                        partida.setId(rs2.getInt("id"));
                        partida.setIdPedido(rs2.getInt("PedidoId"));
                        partida.setArticulo(rs2.getString("articulo"));
                        partida.setDescripcion(rs2.getString("Descripcion"));
                        partida.setCantidad(rs2.getInt("Cantidad"));
                        partida.setSurtido(rs2.getInt("surtido"));
                        partidas.add(partida);
                    }
                    pedido.setPartidas(partidas);
                    
                    lista.add(pedido);
            }
            
            rs.close();
            pst.close();
            //con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

        }

        return lista;
    }
    
    public static Connection conexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:sqlserver://HectorCeja\\dbo:1433;databaseName=tarea5XML", "hector", "1234567");
        return con;
    }
}
