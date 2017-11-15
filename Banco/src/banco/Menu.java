package banco;

import java.util.Scanner;

public  class Menu {
    public static int pintarMenu (){
    int menu=0;
        Scanner leer = new Scanner(System.in);
        if((menu>0)||(menu<10)){
        System.out.println("***************************");
        System.out.println("1-Ingresar Dinero");
        System.out.println("2-Retirar Dinero");
        System.out.println("3-Ver NumCuentaCompleto");
        System.out.println("4-Ver Titular Cuenta");
        System.out.println("5-Ver Codigo Entidad");
        System.out.println("6-Ver Codigo oficina");
        System.out.println("7-Ver NumCuenta");
        System.out.println("8-Ver los Digitos de control de la cuenta");
        System.out.println("9-Salir");
        System.out.println("***************************");
        menu=leer.nextInt();
        }
        return menu;
    }
}