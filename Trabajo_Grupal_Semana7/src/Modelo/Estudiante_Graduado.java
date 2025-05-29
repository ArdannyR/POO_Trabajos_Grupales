package Modelo;
public class Estudiante_Graduado extends Estudiante {
    protected int anioGraduacion;
    protected double promedioFinal;
    protected String especializacion;

    public Estudiante_Graduado(String nombre, int edad, Genero genero, int creditos, String curso, int anioGraduacion, double promedioFinal, String especializacion) {
        super(nombre, edad, genero, creditos, curso);
        this.anioGraduacion = anioGraduacion;
        this.promedioFinal = promedioFinal;
        this.especializacion = especializacion;
    }

    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil();
        System.out.printf("\nAño de graduacion: "+anioGraduacion+"\nPromedio final: "+promedioFinal+"\nEspecializacion: "+especializacion);
    }
}
