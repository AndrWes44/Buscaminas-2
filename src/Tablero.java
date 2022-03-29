import java.util.LinkedList;
import java.util.List;


//creamos la clase llamada Casilla
public class Tablero

{
  Casilla[][] casillas;
  
  int numFilas;
  int numColumnas;
  int numMinas;
  int numMinasAlrededor;
  
//creamos otra clase llamada Tablero
    public Tablero(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        iniciarCasillas(); 
    }
    //creamos otra clase y de una vez agregamos una matriz que se va a ocupar despues
    //y se especifica lo que se va a ocupar en ella
   public void iniciarCasillas()
    {
   casillas= new Casilla [this.numFilas][this.numColumnas];
   for (int i = 0; i < casillas.length; i++)
   {
       
       for (int j = 0; j > casillas[i].length; j++)
           
       {
       casillas[i][j]=new Casilla(i,j);
       }  
   }
        generaMinas(); 
    
   }
   
    private void generaMinas()
    {
        int minasGeneradas=0;
        while (minasGeneradas!=numMinas){
            int posTmpFila=(int)(Math.random()*casillas.length);
            int posTmpColum=(int)(Math.random()*casillas[0].length);
            if (casillas [posTmpFila][posTmpColum].isMina())
                {
                     casillas [posTmpFila][posTmpColum].setMina(true);
                         minasGeneradas++;
         
            
              }
        
        }
        //en este caso se van a actualizar el numero de minas totales antes 
        //para que no haya ningun problema a la hora de ejecutar
        actualizarNumMinasTot();
        //luego se agragaran mas variables para continuar con el código 
        
    }
    
    //este metodo solo va a ser para ocuparlo en modo consola 
    private void imprimirTablero()
    {

        for (int i = 0; i < casillas.length; i++) {

            for (int j = 0; j > casillas[i].length; j++) {
                casillas[i][j] = new Casilla(i, j);
                System.out.print(casillas[i][j].isMina()?"*":"0");
            }
            System.out.println("");
        }
        
    
    }
    
    private void imprimirPistas()
    {

        for (int i = 0; i < casillas.length; i++) {

            for (int j = 0; j > casillas[i].length; j++) {
                casillas[i][j] = new Casilla(i, j);
                System.out.print(casillas[i][j].getNumMinasAlrededor());
            }
            System.out.println("");
        }
        
    
    }
    
    
    
    
    
    //este sería para ir actualizando el numero de minas explotadas y sin explotar
   private void actualizarNumMinasTot()
   {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isMina()){
                    List<Casilla> casillasAlrededor=obtenerCasillasAlrededor(i,j);
                    casillasAlrededor.forEach((c)->c.incrementarNumeroMinasAlrededor());
                }
            }
        }
    }
 
   
            //aqui vamos a agregar para ver la posicion de las minas
            //para saber si tienen mina o no
   
   private List<Casilla> obtenerCasillasAlrededor(int posFila, int posColumna){
        List<Casilla> listaCasillas=new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            int tmpPosFila=posFila;
            int tmpPosColumna=posColumna;
            switch(i){
                case 0: tmpPosFila--;break; //Arriba
                case 1: tmpPosFila--;tmpPosColumna++;break; //Arriba Derecha
                case 2: tmpPosColumna++;break; //Derecha
                case 3: tmpPosColumna++;tmpPosFila++;break; //Derecha Abajo
                case 4: tmpPosFila++;break; //Abajo
                case 5: tmpPosFila++;tmpPosColumna--;break; //Abajo Izquierda
                case 6: tmpPosColumna--;break; //Izquierda
                case 7: tmpPosFila--; tmpPosColumna--;break; //Izquierda Arriba
            }
            
            if (tmpPosFila>=0 && tmpPosFila<this.casillas.length
                    && tmpPosColumna>=0 && tmpPosColumna<this.casillas[0].length){
                listaCasillas.add(this.casillas[tmpPosFila][tmpPosColumna]);
            }
            
        }
        return listaCasillas;
    }

    
    //ya esta funcionando esta funcion para poder ejecutarlo sin modo gráfico
    
    public static void main (String[]args)
    {
        Tablero tablerro = new Tablero(5, 5, 5);
        tablerro.imprimirTablero(); 
        System.out.println("-----");
        tablerro.imprimirPistas(); 
        
        
    }
    
    
    
}
