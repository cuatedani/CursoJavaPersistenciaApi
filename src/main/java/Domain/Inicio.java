package Domain;

import Entity.PokemonEntity;
import Service.PokemonService;

import javax.swing.*;

public class Inicio {

    public static void main(String[] args) {

        PokemonService pokeSer = new PokemonService();

        while (true) {

            String[] botones = {"Buscar por Nombre", "Buscar Por Numero", "Salir"};

            String opcion = (String) JOptionPane.showInputDialog(
                    null,
                    "Pokeapi Java",
                    "Menu Principal",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botones,
                    botones[0]
            );

            // Si cierra o cancela el menú
            if (opcion == null) {
                continue;
            }

            switch (opcion) {

                case "Buscar por Nombre":

                    String nombre = JOptionPane.showInputDialog(
                            "Ingresa el nombre del pokemon"
                    );

                    if (nombre == null || nombre.isBlank()) {
                        continue;
                    }

                    PokemonEntity pokemonNombre =
                            pokeSer.findByName(nombre.toLowerCase().trim());

                    mostrarPokemon(pokemonNombre);
                    break;


                case "Buscar Por Numero":

                    String input = JOptionPane.showInputDialog(
                            "Ingresa un id de pokemon"
                    );

                    if (input == null || input.isBlank()) {
                        continue;
                    }

                    try {
                        int id = Integer.parseInt(input);
                        PokemonEntity pokemonId = pokeSer.findById(id);
                        mostrarPokemon(pokemonId);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Debes ingresar un número válido");
                    }

                    break;


                case "Salir":
                    System.exit(0);
                    break;
            }
        }
    }

    private static void mostrarPokemon(PokemonEntity pokemon) {

        if (pokemon == null ||
                pokemon.getSprites() == null ||
                pokemon.getSprites().getFront_default() == null) {

            JOptionPane.showMessageDialog(null,
                    "Pokemon no encontrado");
            return;
        }

        try {

            java.net.URL imageUrl =
                    new java.net.URL(
                            pokemon.getSprites().getFront_default()
                    );

            ImageIcon icon = new ImageIcon(imageUrl);

            JOptionPane.showMessageDialog(
                    null,
                    "Pokemon #" + pokemon.getId() +
                            "\nNombre: " + pokemon.getName() +
                            "\nAltura: " + pokemon.getHeight() +
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
}
