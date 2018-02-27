
import java.util.Scanner;


public class conecta4 {

    
    public static void main(String[] args) {
        char[][] conecta4 = new char[6][7];
        tablero(conecta4);
        juegoConecta4(conecta4);
    }
    
    /* Juego conecta4.
    Pregunta al usuario que ficha quiere introducir.
    El juego acaba cuando hay cuatro fichas iguales consecutivas, ya sea
    en fila, en columna o en diagonal.
    Si turnoJugadores == true, es el turno del jugador rojo.
    Si turnoJugadores == false, es el turno del jugador amarillo.
    */
    public static void juegoConecta4(char[][] conecta4){
        Scanner sc = new Scanner(System.in);
        
        boolean gameOver = false, turnoJugadores = true;
        int posicionColumna = 0;
        char colorFicha;
        
        
        while(!gameOver){
            if(turnoJugadores){
                System.out.print("Ponga la ficha roja en una columna (0-6): ");
                colorFicha = 'R';
            }
            
            else{
                System.out.print("Ponga la ficha amarilla en una columna (0-6): ");
                colorFicha = 'A';
            }
            
            posicionColumna = sc.nextInt();
            
            while(posicionColumna < 0 || posicionColumna > 6){
                System.out.println("La ficha debe colocarse en una columna entre 0 y 6: ");
                posicionColumna = sc.nextInt();
            }
            turnoJugadores = !turnoJugadores;
            
            if (colocarFicha(conecta4, posicionColumna, colorFicha)){
                turnoJugadores = !turnoJugadores;
            }
            else{
                tablero(conecta4);
                
                if(estadoJuego(conecta4, posicionColumna, colorFicha)){
                    gameOver = true;
                    System.out.println(colorFicha + " ganó! Fin de la partida.");
                }
                else if(miraEmpate(conecta4)){
                    gameOver = true;
                    System.out.println("Empate.");
                }
            }
        }
        sc.close();
}
    
    public static boolean miraEmpate(char[][] conecta4){
        
        for (int i = 0; i < conecta4[0].length; i++){
            if(conecta4[0][i] == 0){
                return false;
            }
        }
        
        return true;
    }
    
    /*
    Devuelve true si hay cuatro fichas iguales consecutivas, ya sea
    en fila, en columna o en diagonal.
    */
    
    public static boolean estadoJuego(char[][] conecta4, int posicionColumna, char colorFicha){
        
        int filaPosicion = 0;
        
        for (int i = 0; i < conecta4.length; i++){
            if(conecta4[i][posicionColumna] != 0){
                filaPosicion = i;
            }
            else{
                continue;
            }
            if(miraColumna(conecta4, posicionColumna, colorFicha, filaPosicion)){
                return true;
            }
            if(miraFila(conecta4, posicionColumna, colorFicha, filaPosicion)){
                return true;
            }
            if(miraDiagonalMayor(conecta4, posicionColumna, colorFicha, filaPosicion)){
                return true;
            }
            if(miraDiagonalMenor(conecta4, posicionColumna, colorFicha, filaPosicion)){
                return true;
            }
        }
        return false;
    }
    
    /*
    Diagonal der.
    */
    
    public static boolean miraDiagonalMenor(char[][] conecta4, int posicionColumna, char colorFicha, int filaPosicion){
     int contadorFichas = 1;
    
    int posicionActualF;
    int posicionActualC;
    
        System.out.print(colorFicha + " ");
        
        for (int i = 1; i < 4; i++){
            posicionActualF = filaPosicion + i;
            posicionActualC = posicionColumna - i;
            
            if(posicionActualF > conecta4.length - 1 | posicionActualF < 0 |
                    posicionActualC > conecta4[0].length -1 | posicionActualC < 0){
                break;
            }
            
            if(colorFicha == conecta4[posicionActualF][posicionActualC]){
                contadorFichas++;
            }
            else{
                break;
            }
        }
        
        if(contadorFichas >=4){
             System.out.println("Izq");
            return true;
        }
        
        for (int i = 1; i < 4; i++){
            posicionActualF = filaPosicion - i;
            posicionActualC = posicionColumna + i;
            
            if(posicionActualF > conecta4.length -1 | posicionActualF < 0 |
                    posicionActualC > conecta4[0].length -1 | posicionActualC < 0){
                break;
            }
            
            if(colorFicha == conecta4[posicionActualF][posicionActualC]){
                contadorFichas++;
            }
            else{
                break;
            }
        }
        if(contadorFichas >=4){
            System.out.println("Izq2");
            return true;
        }
        
        return false;
    }
    
    /*
    Diagonal Izq.
    */
    
    public static boolean miraDiagonalMayor(char[][] conecta4, int posicionColumna, char colorFicha, int filaPosicion){
        
    int contadorFichas = 1;
    
    int posicionActualF;
    int posicionActualC;
    
        System.out.print(colorFicha + " ");
        
        for (int i = 1; i < 4; i++){
            posicionActualF = filaPosicion - i;
            posicionActualC = posicionColumna - i;
            
            if(posicionActualF > conecta4.length -1 | posicionActualF < 0 |
                    posicionActualC > conecta4[0].length -1 | posicionActualC < 0){
                break;
            }
            
            if(colorFicha == conecta4[posicionActualF][posicionActualC]){
                contadorFichas++;
            }
            else{
                break;
            }
        }
        
        if(contadorFichas >=4){
             System.out.println("Izq");
            return true;
        }
        
        for (int i = 1; i < 4; i++){
            posicionActualF = filaPosicion + i;
            posicionActualC = posicionColumna + i;
            
            if(posicionActualF > conecta4.length -1 | posicionActualF < 0 |
                    posicionActualC > conecta4[0].length -1 | posicionActualC < 0){
                break;
            }
            
            if(colorFicha == conecta4[posicionActualF][posicionActualC]){
                contadorFichas++;
            }
            else{
                break;
            }
        }
        if(contadorFichas >=4){
            System.out.println("Izq2");
            return true;
        }
        
        return false;
    }
    
    /*
    Devuelve true si hay cuatro fichas del mismo color en una fila.
    */
    public static boolean miraFila(char[][] conecta4, int posicionColumna, char colorFicha, int filaPosicion){
        
        int contadorFichas = 0;
        
        for (int i = posicionColumna - 1; i >= 0; i--){
            if(colorFicha == conecta4[filaPosicion][i]){
                contadorFichas++;
            }
            else{
                break;
            }
        }
        if(contadorFichas >=3){
            System.out.println("fila1.");
            return true;
        }
        
        for (int i = posicionColumna + 1; i < conecta4[0].length; i++){
            if(colorFicha == conecta4[filaPosicion][i]){
                contadorFichas++;
            }
            else{
                break;
            }
        }
        if(contadorFichas >=3){
            System.out.println("Fila2.");
            return true;
        }
        
        return false;
    }
    
    /*
    Devuelve true si hay cuatro fichas del mismo color en una columna.
    */
    
    public static boolean miraColumna(char[][] conecta4, int posicionColumna, char colorFicha, int filaPosicion){
        
        int contadorFichas = 0;
        
        if((filaPosicion + 4) <= 6){
            for (int i = filaPosicion + 1; i <= (filaPosicion + 3); i++){
                if (colorFicha == conecta4[i][posicionColumna]){
                    contadorFichas++;
                }
                else{
                    break;
                }
            }
        }
        if (contadorFichas == 3){
            System.out.println("c1.");
            return true;
        }
        
        return false;
    }
    
    /*
    Coloca la ficha en la columna indicada.
    Si la columna esta completa, le pregunta al jugador si quiere introducir
    la ficha en otro lugar.
    */
    public static boolean colocarFicha(char[][] conecta4, int posicionColumna, char colorFicha){
        
        for(int i = conecta4.length - 1; i >= 0; i--){
            if(conecta4[i][posicionColumna] == 0){
                conecta4[i][posicionColumna] = colorFicha;
                return false;
            }
        }
        System.out.println("Columna llena, jugador " + colorFicha + " vuelva a intentarlo.");
        return true;
    }
    
    public static void tablero(char[][] conecta4){
        for (int i = 0; i < conecta4.length; i++){
            for (int j = 0; j < conecta4[i].length; j++){
              if (conecta4[i][j] == 0) {
                  System.out.print("| ");
              } else {
                  System.out.print("|"  + conecta4[i][j]);
              }
            } 
            System.out.println("|");
        }
        
       for(int i = 0; i < conecta4[0].length; i++){
                System.out.print(" " + i); 
       }
        System.out.println("");
    }
    
}
