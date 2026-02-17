package Domain;

import Service.PokemonService;

import javax.swing.*;

public class Inicio {
    PokemonService pokeSer = new PokemonService();

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
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Pokeapi Java", "Ingresa un id de pokemon", JOptionPane.QUESTION_MESSAGE));
                pokeSer.findById(id);
                break;
            case 2:
                break;
            default:
                break;
        }
    }
}
