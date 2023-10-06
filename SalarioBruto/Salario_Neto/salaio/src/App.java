import java.util.Scanner;

public class App {

   public static final double INSS = 7;
   public static final double IR = 15.6;
   public static final int SINDICATO = 1;
   public static final int ANTIGUEDAD = 15;
   public static final double INSS_PATRONAL = 22.5;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        double ingresoBruto;
        double Antiguedad,Cuota_Sindical,Salario_Total,Inss,Ir,Total_Deducciones,Inss_Patronal,Salario_Neto;

        do {

       
        System.out.print("Ingreso Su Salario Bruto");
        ingresoBruto = lector.nextDouble();
        
        if (ingresoBruto < 1000) {
            System.out.println("El salario no puede ser menor a 1000. Intente nuevamente.");
        }
    } while (ingresoBruto < 1000);


     Antiguedad = Monto_Antiguedad(ingresoBruto);
     Cuota_Sindical = Monto_cuotaSindical(ingresoBruto);
     Salario_Total = Monto_SalarioTotal(ingresoBruto, Antiguedad);
     Inss = MontoInss(Salario_Total);
     Ir = Monto_Ir(Salario_Total);
     Total_Deducciones = calcularTotalDeducciones(Cuota_Sindical, Inss, Ir);
     Inss_Patronal = Monto_InssPatronal(Salario_Total);
     Salario_Neto = Salrio_Neto(Salario_Total, Total_Deducciones);

        Nomina(ingresoBruto, Antiguedad, Salario_Total, Cuota_Sindical, Inss, Ir, Total_Deducciones, Inss_Patronal, Salario_Neto);
    
    lector.close();
    }

    
    public static double Monto_Antiguedad(double ingresoBruto) {
        return ingresoBruto * ANTIGUEDAD / 100;
    }

    public static double Monto_cuotaSindical(double ingresoBruto) {
        return ingresoBruto * SINDICATO / 100;
    }

    public static double Monto_SalarioTotal(double ingresoBruto, double Antiguedad) {
        return ingresoBruto + Antiguedad;
    }

    public static double MontoInss(double Salario_Total) {
        return Salario_Total * INSS / 100;
    }

    public static double Monto_Ir(double Salario_Total) {
        return Salario_Total * IR / 100;
    }

    public static double calcularTotalDeducciones(double Cuota_Sindical, double Inss, double Ir) {
        return Cuota_Sindical + Inss + Ir;
    }

    public static double Monto_InssPatronal(double Salario_Total) {
        return Salario_Total * INSS_PATRONAL / 100;
    }

    public static double Salrio_Neto(double Salario_Total, double Total_Deducciones) {
        return Salario_Total - Total_Deducciones;
    }


   public  static void Nomina(double ingresoBruto, double Antiguedad, double Salario_Total, double Cuota_Sindical, double Inss, double Ir, double Total_Deducciones,
 double Inss_Patronal, double Salario_Neto) {

 System.out.println("Ingreso bruto = C$" + ingresoBruto);
       
 System.out.println("Monto por antiguedad = C$" + Antiguedad);
        
 System.out.println("Monto del ingreso total = C$" + Salario_Total);
       
 System.out.println("Cuota Sindical = C$" + Cuota_Sindical);
       
 System.out.println("Monto del INSS = C$" + Inss);
       
 System.out.println("Monto del IR = C$" + Ir);
        
 System.out.println("Monto del total de deducciones = C$" + Total_Deducciones);
        
System.out.println("Monto del INSS Patronal = C$" + Inss_Patronal);
 
System.out.println("Monto del ingreso neto = C$" + Salario_Neto);
    }
}