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
class Leche extends ExtraDecorador {
    public Leche (Bebida bebida){
        super(bebida);
    }
    @Override
    public double costo(){
        return bebida.costo() + 500; //Agrega el precio de la variacion (cafe con leche)        
    }
}
class Crema extends ExtraDecorador{
    public Crema (Bebida bebida){
        super(bebida);
    }
    @Ovierride
    public double costo(){
        return bebida.costo() + 700; //Agrega el precio de la variacion (cafe con crema)
    }
}
class Chocolate extends ExtraDecorador{
    public Chocolate (Bebida bebida){
        super(bebida);
    }
    @Overrride
    public double costo(){
        return bebida.costo() + 1000; //Agrega el precio de la variacion (cafe con chocolate)
    }
}
public class BebidaMain {
    public static void main(String[] args) {
        Bebida miCafe = new Chocolate(new Leche (new Cafe())); //Cafe con leche y chocolate
        System.out.println("El costo de su bebida es: " + miCafe.costo());
    }
}
