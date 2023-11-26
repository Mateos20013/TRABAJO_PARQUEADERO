import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Parqueadero PARQUEADERO = new Parqueadero();
        int op= 0;
        do {
            System.out.println("1_. Ingresar Carro ");
            System.out.println("2_. Retirar Carro ");
            System.out.println("3_- Ingresos Parqueadero");
            System.out.println("4_. Puestos Disponibles ");
            System.out.println("5_. Avanzar Reloj ");
            System.out.println("6_. Cambiar Tarifa");
            System.out.println("7_. Metodo 1");
            System.out.println("8_. Metodo 2");
            System.out.println("9_. Salir ");
            System.out.println();
            System.out.println("Ingrese una opcion: ");
            op= sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Placa vehiculo: ");
                    String placa_ingreso= sc.next();
                    int resultado= PARQUEADERO.entrarCarro(placa_ingreso);
                    if (resultado == Parqueadero.NO_HAY_PUESTO){
                        System.out.println("Puestos insuficientes xd");
                    }else if(resultado == Parqueadero.CARRO_YA_EXISTE){
                        System.out.println("Auto ya en existencia");
                    }else{
                        System.out.println("Su vehiculo se encuentra en el puesto: "+resultado);
                    }
                    break;
                case 2:
                    System.out.println("Placa vehiculo: ");
                    String placa_salida = sc.next();
                    int Resultado = PARQUEADERO.sacarCarro(placa_salida);
                    if (Resultado == Parqueadero.CARRO_NO_EXISTE){
                        System.out.println("Su vehiculo no se encuentra");
                    }else{
                        System.out.println("Vehiculo retirado");
                        System.out.println("\nTarifa: "+Resultado);
                    }
                    break;
                case 3:
                    System.out.println("Ingresos: "+PARQUEADERO.darMontoCaja());
                    break;
                case 4:
                    System.out.println("Puestos disponibles: "+PARQUEADERO.calcularPuestosLibres());
                    break;
                case 5:
                    PARQUEADERO.avanzarHora();
                    System.out.println("hora actual +1 hora: "+PARQUEADERO.darHoraActual());
                    break;
                case 6:
                    System.out.println("Ingresar tarifa: ");
                    int tarifa= sc.nextInt();
                    PARQUEADERO.cambiarTarifa(tarifa);
                    System.out.println("Nueva tarifa por hora: "+PARQUEADERO.darTarifa());
                    break;
                case 7:
                    System.out.println(PARQUEADERO.metodo1());
                    break;
                case 8:
                    System.out.println(PARQUEADERO.metodo2());
                    break;
                case 9:
                    System.out.println("Gracias!!!!");
                    System.out.println("Conduzca con precaucion");
                    break;
            }
        }while(op!=9);
    }
}
