public class Vehiculo
{
    public static Vehiculo[] vehiculos = new Vehiculo[10];
    public static int tamaño = 10;
    public static int posAñadir = 0;    
    private int modelo = 0;
    private String marca ="";
    private double valorComercial = 0;
    private String color="";
    
    public Vehiculo(){   
    }

    public Vehiculo(int mo,String ma,double va){
        this(mo,ma,va,"verde");
    }

    public Vehiculo(int mo,String ma,double va,String co){
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;
        vehiculos[posAñadir]= this;
        posAñadir+=1;
    }

    public int getModelo(){
        return modelo;
    }

    public String getMarca(){
        return marca;
    }

    public double getValorComercial(){
        return valorComercial;
    }

    public String getColor(){
        return color;
    }

    public void setModelo(int mo){
        this.modelo = mo;
    }

    public void setMarca(String ma){
        this.marca = ma;
    }

    public void setValorComercial(double va){
        this.valorComercial = va;
    }

    public void setColor(String co){
        this.color = co;
    }

    public String toString(){
        return "Modelo: " + this.modelo + " Marca: " + this.marca + " ValorComercial: " + this.valorComercial + " Color: "+ this.color;
    }
    
    public static int getTamaño(){
        return tamaño;
    }

    public static String toStringVehiculos(){
        String informacion="";
        if(posAñadir > 0){
            for(int i =0;i<Vehiculo.posAñadir;i++){
                informacion += "Vehiculo " + i + " : " + vehiculos[i].toString() + "\n";
            }
            return informacion; 
        }else{
            return "No hay vehiculos registrados";
        }
    }

    public static int cantidadVehiculos(){
        return posAñadir;
    } 
    
    public static String toStringVehiculosVerdes(){
        String informacion="";
        if(posAñadir > 0){
            for(int i = 0; i < Vehiculo.posAñadir; i++){
                if(vehiculos[i].getColor().toLowerCase().equals("verde")){
                    informacion += "Vehiculo " + i + " : " + vehiculos[i].toString() + "\n";
                }
            }
            return informacion; 
        }else{
            return "No hay vehiculos registrados";
        }
    }
    
    public static String toStringVehiculosMod(){
        String informacion="";
        if(posAñadir > 0){
            for(int i = 0; i < Vehiculo.posAñadir; i++){
                if(vehiculos[i].getModelo() >= 2000 && vehiculos[i].getModelo() <= 2021){
                    informacion += "Vehiculo " + i + " : " + vehiculos[i].toString() + "\n";
                }
            }
            return informacion; 
        }else{
            return "No hay vehiculos registrados";
        }
    }
}