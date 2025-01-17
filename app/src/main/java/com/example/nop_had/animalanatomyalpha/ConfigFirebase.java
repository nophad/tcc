package com.example.nop_had.animalanatomyalpha;


import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ConfigFirebase {

    private static FirebaseAuth firebaseAuth;
    private static FirebaseAuth.AuthStateListener authStateListener;
    private static FirebaseUser firebaseUser;

    private ConfigFirebase() {
    }

    public static FirebaseAuth getFirebaseAuth() {
        if (firebaseAuth == null) {
            openFirebaseAuth();
        }
        return firebaseAuth;
    }

    private static void openFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
               FirebaseUser user = firebaseAuth.getCurrentUser();
               if (user != null){
                   firebaseUser = user;
               }
            }
        };
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    public static FirebaseUser getFirebaseUser(){
        return firebaseUser;
    }

    public static void logout(){
        firebaseAuth.signOut();
    }

   /* private static DatabaseReference referencefirebase;
    private static FirebaseAuth firebaseAuth;

    public static DatabaseReference getFirebase(){
        if (referencefirebase == null){

            referencefirebase = FirebaseDatabase.getInstance().getReference().child("users");
        }
        return referencefirebase;
    }

    public static FirebaseAuth getFirebaseAutenticacao(){
        if (firebaseAuth == null){
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }*/

}
