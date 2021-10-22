public class Sensor
{
    public static Sensor[] sensores = new Sensor[8];
    public static int tamaño = 8;
    public static int posAñadir = 0;    
    private String tipo;
    private double valor;
    
    public Sensor(){
    }

    public Sensor(String t,double v){
        this.tipo = t;
        this.valor = v;
        sensores[posAñadir]= this;
        posAñadir+=1;
    }
    
    public String getTipo(){
        return tipo;
    }

    public double getValor(){
        return valor;
    }
    public void setTipo(String t){
        this.tipo = t;
    }

    public void setValor(double v){
        this.valor = v;
    }

    public String toString(){
        return "Tipo: "+ this.tipo + " Valor: " + this.valor;
    }
    
    public static int getTamaño(){
        return tamaño;
    }
    
    public static String toStringSensores(){
        String informacion="";
        if(posAñadir > 0){
            for(int i = 0; i < Sensor.posAñadir; i++){
                informacion += "Sensor " + i + " : " + sensores[i].toString()+ "\n";
            }
            return informacion; 
        }else{
            return "No hay sensores registrados";
        }
    }
    
    public static String toStringSensoresTemp(){
        String informacion="";
        if(posAñadir > 0){
            for(int i = 0; i < Sensor.posAñadir; i++){
                if(sensores[i].getTipo().toLowerCase().equals("temperatura")){
                    informacion += "Sensor " + i + " : " + sensores[i].toString()+ "\n";
            }
        }
            return informacion; 
        }else{
            return "No hay sensores registrados";
        }
    }

    public static int cantidadSensores(){
        return posAñadir;
    } 
}