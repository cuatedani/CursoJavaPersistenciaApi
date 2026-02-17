package Domain;

import Service.PokemonService;

import javax.swing.*;

public class Inicio {

    public static void main(String[] Args){
        PokemonService pokeSer = new PokemonService();

        int optMenu = -1;
        String[] botones = {"Buscar por Nombre", "Buscar Por Numero", "Salir"};

        //Menu Principal
        String opcion = (String) JOptionPane.showInputDialog(null, "Pokeapi Java", "Menu Principal", JOptionPane.INFORMATION_MESSAGE, null,
                botones, botones[0]);

        //Realizar Accion
        switch (opcion){
            case "Buscar por Nombre":
                break;
            case "Buscar Por Numero":
                int id = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingresa un id de pokemon")
                );

                var pokemon = pokeSer.findById(id);

                if (pokemon != null && pokemon.getSprites().getFront_default() != null) {

                    try {
                        java.net.URL imageUrl = new java.net.URL(
                                pokemon.getSprites().getFront_default()
                        );

                        ImageIcon icon = new ImageIcon(imageUrl);

                        JOptionPane.showMessageDialog(
                                null,
                                "Pokemon #" + pokemon.getId()+
                                        "\nNombre: " + pokemon.getName() +
                                        "\nAltura: " + pokemon.getHeight()+
                                        "\nPeso: " + pokemon.getWeight(),
                                "Pokemon Encontrado",
                                JOptionPane.INFORMATION_MESSAGE,
                                icon
                        );

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                "Error al cargar imagen");
                    }
                }
                break;
            case "2.- Salir":
                System.exit(0);
                break;
            default:
                System.exit(0);
                break;
        }
    }
}
