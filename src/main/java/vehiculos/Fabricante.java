package vehiculos;

import java.util.HashMap;

import java.util.Map;

public class Fabricante {
	private String nombre;
	private Pais pais;
	private int contador = 0;
	
	
	public Fabricante(String nombre, Pais pais) {
		this.nombre = nombre;
		this.pais = pais;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public int getContador() {
		return contador;
	}
	
	public void sumContador() {
		contador++;
		this.pais.sumContador();
	}
	
	public static Fabricante fabricaMayorVentas() {
	    
	    Map<Fabricante, Integer> ventasPorFabricante = new HashMap<>();

	    
	    for (Vehiculo vehiculo : Vehiculo.getTodosLosVehiculos()) {
	        Fabricante fabricante = vehiculo.getFabricante();

	        if (ventasPorFabricante.containsKey(fabricante)) {
	        	
	            int ventasAnteriores = ventasPorFabricante.get(fabricante);
	            ventasPorFabricante.put(fabricante, ventasAnteriores + 1);
	        } 
	        
	        else {
	       
	            ventasPorFabricante.put(fabricante, 1);
	        }
	    }

	  
	    int maxVentas = 0;
	    Fabricante fabricaMayorVentas = null;

	    for (Map.Entry<Fabricante, Integer> entry : ventasPorFabricante.entrySet()) {
	        if (entry.getValue() > maxVentas) {
	            maxVentas = entry.getValue();
	            fabricaMayorVentas = entry.getKey();
	        }
	    }

	    return fabricaMayorVentas;
	}

}
