package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Bomba {
	double x;
	double y;
	double velocidad;
	double escala;
	Image DisparoDer;
	Image DisparoIzq;
	boolean direccion;

	Bomba (double x, double y, double velocidad, boolean direccion) {
		this.x = x;				 
		this.y = y;			     
		this.velocidad = velocidad;
		this.direccion = direccion;
		this.escala = 0.1;
		DisparoDer = Herramientas.cargarImagen("bombaDer.gif");
		DisparoIzq = Herramientas.cargarImagen("bombaIzq.gif");
	}
	
	public void dibujarBomba (Entorno e) {
		if (direccion) {
			e.dibujarImagen(this.DisparoIzq, x, y, this.escala);
		}
		else {
			e.dibujarImagen(this.DisparoDer, x, y, this.escala);
		}
	}																	
	
	public void mover() {
		if (direccion) {
			this.x -= velocidad; 
		}						 
		else {
			this.x += velocidad; 
		}
	}
	
	public boolean seFue (Entorno entorno) {		
		return this.x < 0 || this.x > entorno.ancho();
	}
	public double getAncho() {
		return DisparoIzq.getWidth(null)*this.escala;
	}
	public double getAlto() {
		return DisparoIzq.getHeight(null)*this.escala;
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
}
