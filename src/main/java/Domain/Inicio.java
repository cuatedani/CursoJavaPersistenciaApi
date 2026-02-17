package Domain;

import javax.swing.*;

public class Inicio {
    public static void main(String[] Args){
        int optMenu = -1;
        String[] botones = {"1.- Buscar Entity.Pokemon", "2.- Salir"};

        //Menu Principal
        String opcion = (String) JOptionPane.showInputDialog(null, "Pokeapi Java", "Menu Principal", JOptionPane.INFORMATION_MESSAGE, null,
                botones, botones[0]);

        //Validar Opcion
        for (int i=0; i<botones.length; i++){
            if(opcion.equals(botones[i])){
                optMenu = i;
            }
        }

        switch (optMenu){
            case 1:
                break;
            default:
                break;
        }
    }
}
