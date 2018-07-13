/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedidos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Hector
 */
public class Pedido {
    
    private Integer id;
    
    private String cliente;
    
    private String estado;
    
    private Date fecha;
    
    private String direccion;
    
    private List<PartidasPedido> partidas;

    public List<PartidasPedido> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidasPedido> partidas) {
        this.partidas = partidas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
