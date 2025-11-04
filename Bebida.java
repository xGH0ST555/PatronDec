interface Bebida{
    double costo(); //metodo en comun de cada clase
}
class Cafe implements Bebida {
    @Override
    public double costo(){
        return 2500; //precio del cafe solo
    }
}
abstract class ExtraDecorador implements Bebida {
    protected Bebida bebida; // La bebida que voy a decorar
    public  ExtraDecorador (Bebida bebida){
        this.bebida = bebida;
    }
    public abstract double costo(); //Para sobreescribir el metodo en los extras
}
class 
