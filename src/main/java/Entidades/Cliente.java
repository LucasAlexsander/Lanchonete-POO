package Entidades;

public class Cliente extends Perfil{
    private int idCliente;
    private String ultPedidos;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getUltPedidos() {
        return ultPedidos;
    }

    public void setUltPedidos(String ultPedidos) {
        this.ultPedidos = ultPedidos;
    }
    
    
}
