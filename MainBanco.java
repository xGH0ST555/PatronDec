import java.util.ArrayList;
import java.util.List;

interface observador{
    void actualizarSaldo(double saldo);
}

abstract class Subject {
    protected List<observador> observadores = new ArrayList<>();

    public void agregarObservador(observador o){
     observadores.add(o);   
    }

    public void eliminarObservador(observador o){
        observadores.remove(o);
    }

    public void notificarObservadores(double saldo){
        for(observador o : observadores){
            o.actualizarSaldo(saldo);
        }
    }
}

class CuentaBanco extends Subject {
    private double saldo = 0.0;

    public void depositar(double valor){
        saldo += valor;
        System.out.println("Deposito: " + valor);
        notificarObservadores(saldo);
    }
    public void retirar(double valor){
        if(valor <= saldo){
            saldo -= valor;
            System.out.println("Retiro: " + valor);
            notificarObservadores(saldo);
        } else {
            System.out.println("Fondos insuficientes para retirar: " + valor);
        }
    }
}
class NotificacionApp implements observador{
    @Override
    public void actualizarSaldo(double saldo){
        System.out.println("[NequiApp] Tu nuevo saldo es: $"  + saldo);
    }
}
class NotificacionCorreo implements observador{
    @Override
    public void actualizarSaldo(double saldo){
        System.out.println("[GmailApp] Registro: Tu nuevo saldo es: $"  + saldo);
    }
}

class NotificacionSMS implements observador{
    @Override
    public void actualizarSaldo(double saldo){
        System.out.println("[SMSApp] Registro: Tu nuevo saldo es: $"  + saldo);
    }
}
public class MainBanco{
    public static void main(String[] args) {
        CuentaBanco cuenta = new CuentaBanco();
        cuenta.agregarObservador(new NotificacionApp());
        cuenta.agregarObservador(new NotificacionCorreo());
        cuenta.agregarObservador(new NotificacionSMS());
        cuenta.depositar(150000);
        cuenta.retirar(500000);
        


    }
} 