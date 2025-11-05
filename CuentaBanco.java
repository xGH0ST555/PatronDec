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
}
class NotificacionApp implements observador{
    @Override
    public void actualizarSaldo(double saldo){
        System.out.println("[NequiApp] Tu nuevo saldo es: $"  + saldo);
    }
}