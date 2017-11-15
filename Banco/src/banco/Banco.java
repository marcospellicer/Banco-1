package banco;

import java.util.Scanner;

public class BancoObjeto {

    public static void main(String[] args) {
        boolean bandera;
        String ccc;
        String nombre;
        Cuentabancaria cliente1 = null;
        Scanner leer1 = new Scanner(System.in);//num
        Scanner leer2 = new Scanner(System.in);//String
        Scanner leer3 = new Scanner(System.in);//String
        System.out.println("Dime tu nombre");
        nombre = leer2.next();
        System.out.println("Dime tu numero de cuenta  (entidad-oficina-dígitos de controlcuenta-numCuneta)");
        ccc=leer3.nextLine();
        if(Cuentabancaria.comprobarCcc(ccc)==true){
            bandera=true;
            cliente1 = new Cuentabancaria(nombre,ccc);
        }else{
            bandera=false;
            System.out.println("El Numero de cuenta introducido es eroneo");
        }
        while (bandera) {
           switch(Menu.pintarMenu()){
              case 1://Ingresar Dinero
                  boolean ingreso;
                  System.out.println("Dime la cantidad a ingresar");
                  ingreso=cliente1.ingreso(leer1.nextDouble());
                  if (ingreso==true){
                      System.out.println("El Ingreso se a realizado correctamente");
                  }else{
                      System.out.println("No se a podido realizar");
                  }
                  break;
              case 2://Retirar dinero
                   boolean retirar;
                  System.out.println("Dime la cantidad a retirar");
                  retirar=cliente1.retirarDinero(leer1.nextDouble());
                  if (retirar==true){
                      System.out.println("has retirardo dinero corectamente");
                  }else{
                      System.out.println("No se a podido realizar");
                  }
                  break;
              case 3://Ver NumCuentaCompleto
                  System.out.println("Tu numero de cuenta es: "+"\n"+
                          cliente1.numCuentaConpleto());
                  break;
              case 4://Ver Titular Cuenta
                    System.out.println("Titular: "+cliente1.getTitular());
                  break;
              case 5://Ver Codigo Entidad
                  System.out.println("Codigo Entidad: "+cliente1.getEntidad());
                  break;
              case 6://Ver Codigo oficina
                  System.out.println("Codigo Oficina: "+cliente1.getOficina());
                  break;
              case 7://Ver NumCuenta
                  System.out.println("NumCuenta: "+cliente1.getNumCuenta());
                  break;
              case 8://Ver los Digitos de control de la cuenta
                  System.out.println("DC: "+cliente1.getDigControl());
                  break;
              case 9://salir
                  System.out.println("Has salido del programa");
                    bandera =true;
                  break;
            }         
        }
    }
}
