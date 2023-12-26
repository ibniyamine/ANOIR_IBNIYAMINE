package main;


import dao.IUsers;
import dao.UsersImpl;
import entity.Users;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        IUsers usr = new UsersImpl();
        Scanner sc = new Scanner(System.in);
        Users u = new Users();
        System.out.println("Donner le nom de l'utilisateur");
        String nomUser = sc.nextLine();
        System.out.println("Donner l'email");
        String emailUser = sc.nextLine();
        System.out.println("Donner le mot de passe");
        String mdpUser = sc.nextLine();
        u.setMdp(mdpUser);
        u.setNom(nomUser);
        u.setEmail(emailUser);
        int ok = usr.add(u);
        if(ok==1){
            System.out.println("l'utilisateur est enregistrer avec succes");
        }
        else{
            System.out.println("Echec de l'ajout de l'utilisateur");
        }


    }






}