package Estudio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Chat> chats = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            cargarUsuarios("userss.txt");
            cargarChats("chats.txt");
            cargarMensajes("msj.txt");
        } catch (IOException e) {
            
        }
    }
}