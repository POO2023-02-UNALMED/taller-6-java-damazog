package vehiculos;

import java.util.HashMap;
import java.util.Map;

public class Pais {
	private String nombre;
	private int contador;

	public Pais(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getContador() {
		return contador;
	}
	
	public void sumContador() {
		contador++;
	}
	
	public static Pais paisMasVendedor() {
	    
		Map<Pais, Integer> ventasPorPais = new HashMap<>();

	  
	    for (Vehiculo vehiculo : Vehiculo.getTodosLosVehiculos()) { 
	        Pais paisFabricante = vehiculo.getFabricante().getPais();

	        
	        if (ventasPorPais.containsKey(paisFabricante)) {
	            
	            int ventasAnteriores = ventasPorPais.get(paisFabricante);
	            ventasPorPais.put(paisFabricante, ventasAnteriores + 1);
	        } 
	        
	        else {
	        
	            ventasPorPais.put(paisFabricante, 1);
	        }
	    }

	    int maxVentas = 0;
	    Pais paisMasVendedor = null;

	    for (Map.Entry<Pais, Integer> entry : ventasPorPais.entrySet()) {
	        if (entry.getValue() > maxVentas) {
	            maxVentas = entry.getValue();
	            paisMasVendedor = entry.getKey();
	        }
	    }

	    return paisMasVendedor;
	}
}
