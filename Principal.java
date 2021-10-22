import java.util.Scanner;
public class Principal{
    
    public static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args){
        mostrarMenu();
    }

    public static void mostrarMenu(){
        System.out.println("Bienvenido: Por favor seleccione una opcion");
        System.out.println("0. Para detener la ejecucion");
        System.out.println("1. Para crear un vehiculo");
        System.out.println("2. Para mostrar todos los vehiculos");
        System.out.println("3. Para mostrar la cantidad de vehiculos");
        System.out.println("4. Para mostrar vehiculos color verde");
        System.out.println("5. Para mostrar vehiculos modelo entre 2000 y 2021");
        System.out.println("6. Para crear un sensor");
        System.out.println("7. Para mostrar todos los sensores");
        System.out.println("8. Para mostrar la cantidad de sensores");
        System.out.println("9. Para mostrar sensores tipo temperatura");
        System.out.println("666. Para mostrar sensores tipo temperatura ordenados por valor");
            
        while(true){
            int num = entrada.nextInt();
            if (num == 0){
                System.out.println("Ejecucion finalizada");
                break;
            }else{
                switch(num){
                    case 1:
                        if(Vehiculo.cantidadVehiculos() < Vehiculo.getTamaño()){
                            System.out.print("Ingrese el modelo: ");
                            int modelo = entrada.nextInt();
                            System.out.print("Ingrese la marca: ");
                            String marca = entrada.next();
                            System.out.print("Ingrese el valor comercial: ");
                            int valorComercial = entrada.nextInt();
                            System.out.print("Ingrese el color: ");
                            String color = entrada.next();
                            
                            Vehiculo vehiculoNuevo = new Vehiculo(modelo, marca,valorComercial,color);
                            System.out.println("Vehiculo creado con éxito");
                        }else{
                            System.out.println("Error base de datos llena");
                        }
                        break; 
                    case 2:
                        System.out.println(Vehiculo.toStringVehiculos());
                        break;
                    case 3:
                        System.out.println("La cantidad de vehiculos actual es: " + Vehiculo.cantidadVehiculos());
                        break;
                    case 4:
                        System.out.println(Vehiculo.toStringVehiculosVerdes());
                        break;
                    
                    case 5:
                         System.out.println(Vehiculo.toStringVehiculosMod());
                         break;
                         
                    case 6:
                         if(Sensor.cantidadSensores() < Sensor.getTamaño()){
                            System.out.print("Ingrese el tipo: ");
                            String tipo = entrada.next();
                            System.out.print("Ingrese el valor: ");
                            int valor = entrada.nextInt();
            
                            Sensor sensorNuevo = new Sensor(tipo,valor);
                            System.out.println("Sensor creado con éxito");
                        }else{
                            System.out.println("Error base de datos llena");
                        }
                         break;
                         
                    case 7:
                         System.out.println(Sensor.toStringSensores());
                         break;
                         
                    case 8:
                         System.out.println("La cantidad de sensores actual es: " + Sensor.cantidadSensores());
                         break;
                         
                    case 9:
                         System.out.println(Sensor.toStringSensoresTemp());
                         break;
                         
                    case 666:
                         Sensor[] sensoresTempOrdenados = ObtenerSensoresTemperaturaOrdenados();
                         if (sensoresTempOrdenados.length > 0){
                             for (int i=0; i < sensoresTempOrdenados.length; i++){
                                 System.out.println(sensoresTempOrdenados[i].toString());
                             }
                         }else{
                              System.out.println("No existen sensores de tipo temperatura");
                         }
                         break;
                }
            }
        }
    }
    
    public static Sensor[] ObtenerSensoresTemperaturaOrdenados(){
        Sensor[] sensoresOrganizados = Sensor.sensores; 
        int posMenor; 
        Sensor temporal;
        for (int i = 0; i < Sensor.posAñadir - 1; i++){
            posMenor = i;
            for (int j = i + 1; j < Sensor.posAñadir; j++){
                if (sensoresOrganizados[j].getValor() < sensoresOrganizados[posMenor].getValor()){
                    posMenor = j;
                }
            } 
            temporal = sensoresOrganizados[i];
            sensoresOrganizados[i] = sensoresOrganizados[posMenor];
            sensoresOrganizados[posMenor] = temporal; 
        }
        
        int cantidadSensoresTemp = 0, sensoresTempGuardados = 0;
 
        for (int i = 0; i < Sensor.posAñadir; i++){  
            if (sensoresOrganizados[i].getTipo().toLowerCase().equals("temperatura")){
                cantidadSensoresTemp++;
            }
        }
        
        Sensor[] sensoresTemp = new Sensor[cantidadSensoresTemp]; 
        for (int i = 0; i < Sensor.posAñadir; i++){
            if (sensoresOrganizados[i].getTipo().toLowerCase().equals("temperatura")){
                sensoresTemp[sensoresTempGuardados] = sensoresOrganizados[i];
                sensoresTempGuardados++;
            }
        }
        
        return sensoresTemp;
    }
}