package banco;
public class Cuentabancaria {
    private String titular;
    private String entidad,oficina,digControl,numCuenta;
    private String numCuentaguiones;
    private double saldo;

    
     public Cuentabancaria(String titular,String numCuentaguiones) {
        this.titular = titular;
        String vCuenta[] = numCuentaguiones.split("-");
        this.entidad = vCuenta[0];
        this.oficina = vCuenta[1];
        this.digControl = vCuenta[2];
        this.numCuenta = vCuenta[3];
        this.numCuentaguiones = numCuentaguiones;
        this.saldo = 0;
    }
     
    public Cuentabancaria(String titular, String entidad, String oficina, String digControl, String numCuenta, String numCuentaguiones, double saldo) {
        this.titular = titular;
        this.entidad = entidad;
        this.oficina = oficina;
        this.digControl = digControl;
        this.numCuenta = numCuenta;
        this.numCuentaguiones = numCuentaguiones;
        this.saldo = saldo;
    }
    
    public Cuentabancaria() {
        titular="";
        entidad="";
        oficina="";
        digControl="";
        numCuenta="";
        saldo=0;
    }
    public Cuentabancaria(double saldo) {
        titular="";
        entidad="";
        oficina="";
        digControl="";
        numCuenta="";
        this.saldo=saldo;
    }
    public Cuentabancaria(String titular, String entidad, String oficina, String digControl, String numCuenta, double saldo) {
        this.titular = titular;
        this.entidad = entidad;
        this.oficina = oficina;
        this.digControl = digControl;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }
    public String numCuentaConpleto(){
    return this.getEntidad()+this.getOficina()+this.getDigControl()+this.getNumCuenta()+"\n";
    }
    @Override
    public String toString(){
        return "Titular: "+this.getTitular()+"\n"+
                "Entidad: "+this.getEntidad()+"\n"+
                "Oficina: "+this.getOficina()+"\n"+
                "DigControl: "+this.getDigControl()+"\n"+
                "NumCuenta: "+this.getNumCuenta()+"\n"+
                "Saldo"+this.getSaldo()+"\n"+
                "--------------------------------"+"\n";
    }
    public boolean ingreso(double saldo){
        if((this.getTitular()!="")&&(this.getNumCuenta()!="")){
            this.setSaldo(this.getSaldo() + saldo);
            return true;
        }
        return false;
    }
    
    
    public boolean retirarDinero(double saldo){
        if((!"".equals(this.titular))&&(!"".equals(this.numCuenta))&&(this.saldo>=saldo)){
            this.setSaldo(this.getSaldo() - saldo);
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @return 
     */
    private boolean comprobarCCC(){
        double d1,d2,d3,d4,d5;
        double b1,b2,b3,b4,b5;
        double e1,e2,e3,e4,e5;
        double i1,i2,i3,i4,i5;
        String num1,num2,num3;
        double resto;
        int total;
        d1=Integer.valueOf(this.getEntidad().substring(0,1))*4;
        d2=Integer.valueOf(this.getEntidad().substring(1,2))*8;
        d3=Integer.valueOf(this.getEntidad().substring(2,3))*5;
        d4=Integer.valueOf(this.getEntidad().substring(3,4))*10;
        e1=Integer.valueOf(this.getOficina().substring(0,1))*9;
        e2=Integer.valueOf(this.getOficina().substring(1,2))*7;
        e3=Integer.valueOf(this.getOficina().substring(2,3))*3;
        e4=Integer.valueOf(this.getOficina().substring(3,4))*6;
        resto=(d1+d2+d3+d4+e1+e2+e3+e4)%11;
        total=11-((int)resto);
        if (total==10){
            d1 = 1;
        }else{
            if(total==11){
                d1 =0;
            }else{
               d1=total;
            }
        }
        num1=Integer.toString((int)d1);
        b1=Integer.valueOf(this.getNumCuenta().substring(0,1))*1;
        b2=Integer.valueOf(this.getNumCuenta().substring(1,2))*2;
        b3=Integer.valueOf(this.getNumCuenta().substring(2,3))*4;
        b4=Integer.valueOf(this.getNumCuenta().substring(3,4))*8;
        b5=Integer.valueOf(this.getNumCuenta().substring(4,5))*5;
        i1=Integer.valueOf(this.getNumCuenta().substring(5,6))*10;
        i2=Integer.valueOf(this.getNumCuenta().substring(6,7))*9;
        i3=Integer.valueOf(this.getNumCuenta().substring(7,8))*7;
        i4=Integer.valueOf(this.getNumCuenta().substring(8,9))*3;
        i5=Integer.valueOf(this.getNumCuenta().substring(9,10))*6;
        resto=(b1+b2+b3+b4+b5+i1+i2+i3+i4+i5)%11; 
        total=11-((int)resto);
        if (total==10){
            d2 = 1;
        }else{
            if(total==11){
               d2 =0;
            }else{
               d2=total;
            }  
        }
        num2=Integer.toString((int)d2);
        num3=num1+num2; 
        if (this.digControl.equals(num3)){
           return true;
           
            }   
        return false;  
    }
    public static boolean comprobarCcc(String ccc){
        String vCuenta[]=ccc.split("-");
        double d1,d2,d3,d4,d5;
        double b1,b2,b3,b4,b5;
        double e1,e2,e3,e4,e5;
        double i1,i2,i3,i4,i5;
        String num1,num2,num3;
        double resto;
        int total;
        d1=Integer.valueOf(vCuenta[0].substring(0,1))*4;
        d2=Integer.valueOf(vCuenta[0].substring(1,2))*8;
        d3=Integer.valueOf(vCuenta[0].substring(2,3))*5;
        d4=Integer.valueOf(vCuenta[0].substring(3,4))*10;
        e1=Integer.valueOf(vCuenta[1].substring(0,1))*9;
        e2=Integer.valueOf(vCuenta[1].substring(1,2))*7;
        e3=Integer.valueOf(vCuenta[1].substring(2,3))*3;
        e4=Integer.valueOf(vCuenta[1].substring(3,4))*6;
        resto=(d1+d2+d3+d4+e1+e2+e3+e4)%11;
        total=11-((int)resto);
        if (total==10){
            d1 = 1;
        }else{
            if(total==11){
                d1 =0;
            }else{
               d1=total;
            }
        }
        num1=Integer.toString((int)d1);
        b1=Integer.valueOf(vCuenta[3].substring(0,1))*1;
        b2=Integer.valueOf(vCuenta[3].substring(1,2))*2;
        b3=Integer.valueOf(vCuenta[3].substring(2,3))*4;
        b4=Integer.valueOf(vCuenta[3].substring(3,4))*8;
        b5=Integer.valueOf(vCuenta[3].substring(4,5))*5;
        i1=Integer.valueOf(vCuenta[3].substring(5,6))*10;
        i2=Integer.valueOf(vCuenta[3].substring(6,7))*9;
        i3=Integer.valueOf(vCuenta[3].substring(7,8))*7;
        i4=Integer.valueOf(vCuenta[3].substring(8,9))*3;
        i5=Integer.valueOf(vCuenta[3].substring(9,10))*6;
        resto=(b1+b2+b3+b4+b5+i1+i2+i3+i4+i5)%11; 
        total=11-((int)resto);
        if (total==10){
            d2 = 1;
        }else{
            if(total==11){
               d2 =0;
            }else{
               d2=total;
            }  
        }
        num2=Integer.toString((int)d2);
        num3=num1+num2; 
        if (vCuenta[2].equals(num3)){
           return true;
            }   
        return false;
    }
    public String getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * @return the entidad
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the oficina
     */
    public String getOficina() {
        return oficina;
    }

    /**
     * @param oficina the oficina to set
     */
    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    /**
     * @return the digControl
     */
    public String getDigControl() {
        return digControl;
    }

    /**
     * @param digControl the digControl to set
     */
    public void setDigControl(String digControl) {
        this.digControl = digControl;
    }

    /**
     * @return the numCuenta
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * @param numCuenta the numCuenta to set
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the numCuentaguiones
     */
    public String getNumCuentaguiones() {
        return numCuentaguiones;
    }

    /**
     * @param numCuentaguiones the numCuentaguiones to set
     */
    public void setNumCuentaguiones(String numCuentaguiones) {
        this.numCuentaguiones = numCuentaguiones;
    }
}
